from dataclasses import dataclass
from utils import read_lines


@dataclass
class Region:
    width: int
    height: int
    shape_counts: list[int]


@dataclass
class Summary:
    shapes: list[list[list[str]]]
    regions: list[Region]


def main() -> None:
    part1_slow(parse_summary(read_lines("inputs/day12ex1.txt")))
    part1(parse_summary(read_lines("inputs/day12input.txt")))


def part1(summary: Summary) -> None:
    fit_count = 0
    shape_areas = [sum([row.count("#") for row in shape]) for shape in summary.shapes]
    for region in summary.regions:
        all_shape_areas = sum(
            [region.shape_counts[i] * area for i, area in enumerate(shape_areas)]
        )
        if all_shape_areas <= region.width * region.height:
            fit_count += 1
    print(fit_count)


def part1_slow(summary: Summary) -> None:
    fit_count = 0
    shapes = [get_shape_variations(s) for s in summary.shapes]
    for region in summary.regions:
        region_map = create_region_map(region.width, region.height)
        if shapes_fit(shapes, region_map, region.shape_counts):
            fit_count += 1
    print(fit_count)


def shapes_fit(
    shapes: list[list[list[list[str]]]], region_map: list[list[str]], counts: list[int]
) -> bool:
    if sum(counts) == 0:
        return True
    for i, cnt in enumerate(counts):
        if cnt == 0:
            continue
        next_counts = list(counts)
        next_counts[i] -= 1
        for shape in shapes[i]:
            for row in range(len(region_map)):
                for col in range(len(region_map[row])):
                    if place_shape(shape, region_map, row, col):
                        res = shapes_fit(shapes, region_map, next_counts)
                        if res:
                            return True
                        erase_shape(shape, region_map, row, col)
        break
    return False


def create_region_map(width: int, height: int) -> list[list[str]]:
    region_map: list[list[str]] = []
    for _ in range(height):
        row = []
        for _ in range(width):
            row.append(".")
        region_map.append(row)
    return region_map


def place_shape(
    shape: list[list[str]], region_map: list[list[str]], row: int, col: int
) -> bool:
    if row + len(shape) > len(region_map):
        return False
    if col + len(shape[0]) > len(region_map[0]):
        return False
    for r, shape_row in enumerate(shape):
        for c, val in enumerate(shape_row):
            if val != "." and region_map[row + r][col + c] != ".":
                return False
    for r, shape_row in enumerate(shape):
        for c, val in enumerate(shape_row):
            if val != ".":
                region_map[row + r][col + c] = val
    return True


def erase_shape(
    shape: list[list[str]], region_map: list[list[str]], row: int, col: int
) -> None:
    for r, shape_row in enumerate(shape):
        for c, val in enumerate(shape_row):
            if val != ".":
                region_map[row + r][col + c] = "."


def get_shape_variations(shape: list[list[str]]) -> list[list[list[str]]]:
    variations: list[list[list[str]]] = []
    variation_set: set[str] = set()

    variations.append(shape)
    variation_set.add(str(shape))

    cur = shape
    for _ in range(4):
        rot = rotate_shape(cur)
        cur = rot
        rot_str = str(rot)
        if rot_str not in variation_set:
            variations.append(rot)
            variation_set.add(rot_str)
        fv = flip_shape_vertical(rot)
        fv_str = str(fv)
        if fv_str not in variation_set:
            variations.append(fv)
            variation_set.add(fv_str)
        fh = flip_shape_horizontal(rot)
        fh_str = str(fh)
        if fh_str not in variation_set:
            variations.append(fh)
            variation_set.add(fh_str)
    return variations


def rotate_shape(shape: list[list[str]]) -> list[list[str]]:
    return [list(row) for row in zip(*shape[::-1])]


def flip_shape_vertical(shape: list[list[str]]) -> list[list[str]]:
    return shape[::-1]


def flip_shape_horizontal(shape: list[list[str]]) -> list[list[str]]:
    return [row[::-1] for row in shape]


def parse_summary(lines: list[str]) -> Summary:
    shapes: list[list[list[str]]] = []
    regions: list[Region] = []
    cur_shape: list[list[str]] = []
    for line in lines:
        if line.count(":") > 0 and line.count("x") == 0:
            pass
        elif line.count("#") > 0 or line.count(".") > 0:
            cur_shape.append(list(line.strip()))
        elif line.count("x") > 0:
            dim, counts = line.strip().split(": ")
            width, height = dim.split("x")
            shape_counts = [int(c) for c in counts.split()]
            regions.append(Region(int(width), int(height), shape_counts))
        else:
            shapes.append(cur_shape)
            cur_shape = []
    return Summary(shapes, regions)


if __name__ == "__main__":
    main()
