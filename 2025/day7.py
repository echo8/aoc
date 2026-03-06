from dataclasses import dataclass
from utils import read_lines


@dataclass
class Diagram:
    grid: list[list[str]]
    start: tuple[int, int]


def main() -> None:
    part1(parse_diagram(read_lines("inputs/day7ex1.txt")))
    part1(parse_diagram(read_lines("inputs/day7input.txt")))
    part2(parse_diagram(read_lines("inputs/day7ex1.txt")))
    part2(parse_diagram(read_lines("inputs/day7input.txt")))


def part1(diagram: Diagram) -> None:
    print(trace_beams(diagram.grid, diagram.start))


def part2(diagram: Diagram) -> None:
    print(get_all_paths(diagram.grid, diagram.start, {}))


def trace_beams(grid: list[list[str]], pos: tuple[int, int]) -> int:
    row, col = pos
    if row >= len(grid) or col >= len(grid[row]):
        return 0
    if grid[row][col] == "S":
        return trace_beams(grid, (row + 1, col))
    elif grid[row][col] == ".":
        grid[row][col] = "|"
        return trace_beams(grid, (row + 1, col))
    elif grid[row][col] == "^":
        return 1 + trace_beams(grid, (row, col - 1)) + trace_beams(grid, (row, col + 1))
    return 0


def get_all_paths(
    grid: list[list[str]], pos: tuple[int, int], endings: dict[tuple[int, int], int]
) -> int:
    if pos in endings.keys():
        return endings[pos]
    row, col = pos
    if row >= len(grid) or col >= len(grid[row]):
        endings[pos] = 1
        return 1
    if grid[row][col] == "S":
        res = get_all_paths(grid, (row + 1, col), endings)
        endings[pos] = res
        return res
    elif grid[row][col] == ".":
        res = get_all_paths(grid, (row + 1, col), endings)
        endings[pos] = res
        return res
    elif grid[row][col] == "^":
        res = get_all_paths(grid, (row, col - 1), endings) + get_all_paths(
            grid, (row, col + 1), endings
        )
        endings[pos] = res
        return res
    return 0


def parse_diagram(lines: list[str]) -> Diagram:
    grid: list[list[str]] = []
    start: tuple[int, int] | None = None
    for i, line in enumerate(lines):
        row: list[str] = []
        for j, c in enumerate(line.strip()):
            row.append(c)
            if c == "S":
                start = (i, j)
        grid.append(row)
    if start is None:
        raise Exception("Failed to find start")
    return Diagram(grid, start)


if __name__ == "__main__":
    main()
