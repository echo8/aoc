from utils import read_lines


def main() -> None:
    part1(parse_grid(read_lines("inputs/day4ex1.txt")))
    part1(parse_grid(read_lines("inputs/day4input.txt")))
    part2(parse_grid(read_lines("inputs/day4ex1.txt")))
    part2(parse_grid(read_lines("inputs/day4input.txt")))


def part1(grid: list[list[str]]) -> None:
    accessible_rolls = find_accessible_rolls(grid)
    print(accessible_rolls)


def part2(grid: list[list[str]]) -> None:
    total_accessible_rolls: int = 0
    accessible_rolls = find_accessible_rolls(grid)
    total_accessible_rolls += accessible_rolls
    while accessible_rolls > 0:
        accessible_rolls = find_accessible_rolls(grid)
        total_accessible_rolls += accessible_rolls
    print(total_accessible_rolls)


def find_accessible_rolls(grid: list[list[str]]) -> int:
    accessible_roll_cnt: int = 0
    accessible_roll_pos: list[tuple[int, int]] = []
    for row, row_val in enumerate(grid):
        for col, col_val in enumerate(row_val):
            if col_val == ".":
                continue
            adj_cnt = 0
            if col > 0 and row > 0:
                adj_cnt += 1 if grid[row - 1][col - 1] == "@" else 0
            if row > 0:
                adj_cnt += 1 if grid[row - 1][col] == "@" else 0
            if col < len(row_val) - 1 and row > 0:
                adj_cnt += 1 if grid[row - 1][col + 1] == "@" else 0
            if col > 0:
                adj_cnt += 1 if grid[row][col - 1] == "@" else 0
            if col < len(row_val) - 1:
                adj_cnt += 1 if grid[row][col + 1] == "@" else 0
            if col > 0 and row < len(grid) - 1:
                adj_cnt += 1 if grid[row + 1][col - 1] == "@" else 0
            if row < len(grid) - 1:
                adj_cnt += 1 if grid[row + 1][col] == "@" else 0
            if col < len(row_val) - 1 and row < len(grid) - 1:
                adj_cnt += 1 if grid[row + 1][col + 1] == "@" else 0
            if adj_cnt < 4:
                accessible_roll_cnt += 1
                accessible_roll_pos.append((row, col))
    for row, col in accessible_roll_pos:
        grid[row][col] = "."
    return accessible_roll_cnt


def parse_grid(lines: list[str]) -> list[list[str]]:
    parsed: list[list[str]] = []
    for line in lines:
        grid_line: list[str] = []
        for n in line.strip():
            grid_line.append(n)
        parsed.append(grid_line)
    return parsed


if __name__ == "__main__":
    main()
