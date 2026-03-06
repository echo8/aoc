import shapely
from utils import read_lines


def main() -> None:
    part1(parse_coords(read_lines("inputs/day9ex1.txt")))
    part1(parse_coords(read_lines("inputs/day9input.txt")))
    part2(parse_coords(read_lines("inputs/day9ex1.txt")))
    part2(parse_coords(read_lines("inputs/day9input.txt")))


def part1(coords: list[tuple[int, int]]) -> None:
    max_area = 0
    for i, a in enumerate(coords):
        for b in coords[i + 1 :]:
            area = get_area(a, b)
            max_area = max(max_area, area)
    print(max_area)


def part2(coords: list[tuple[int, int]]) -> None:
    max_area = 0
    polygon = shapely.Polygon(coords)
    for i, a in enumerate(coords):
        for b in coords[i + 1 :]:
            x_min, x_max = min(a[0], b[0]), max(a[0], b[0])
            y_min, y_max = min(a[1], b[1]), max(a[1], b[1])
            if polygon.contains(shapely.box(x_min, y_min, x_max, y_max)):
                area = get_area(a, b)
                max_area = max(max_area, area)
    print(max_area)


def get_area(a: tuple[int, int], b: tuple[int, int]) -> int:
    width = 0
    height = 0
    if a[0] > b[0]:
        width = a[0] - b[0] + 1
    else:
        width = b[0] - a[0] + 1
    if a[1] > b[1]:
        height = a[1] - b[1] + 1
    else:
        height = b[1] - a[1] + 1
    return width * height


def parse_coords(lines: list[str]) -> list[tuple[int, int]]:
    coords: list[tuple[int, int]] = []
    for line in lines:
        x, y = line.strip().split(",")
        coords.append((int(x), int(y)))
    return coords


if __name__ == "__main__":
    main()
