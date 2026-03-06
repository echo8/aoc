from utils import read_lines


def main() -> None:
    part1(parse_banks(read_lines("inputs/day3ex1.txt")))
    part1(parse_banks(read_lines("inputs/day3input.txt")))
    part2(parse_banks(read_lines("inputs/day3ex1.txt")))
    part2(parse_banks(read_lines("inputs/day3input.txt")))


def part1(banks: list[list[str]]) -> None:
    max_joltages: list[int] = []
    for bank in banks:
        max_joltages.append(get_joltage([int(v) for v in bank], 2))
    print(sum(max_joltages))


def part2(banks: list[list[str]]) -> None:
    max_joltages: list[int] = []
    for bank in banks:
        max_joltages.append(get_joltage([int(v) for v in bank], 12))
    print(sum(max_joltages))


def get_joltage(bank: list[int], battery_total: int) -> int:
    joltages: str = ""
    cur: int = 0
    battery_left: int = battery_total
    for _ in range(battery_total):
        possible_start: int = cur
        possible_end: int | None = -(battery_left - 1) if battery_left > 1 else None
        possible_vals: list[int] = bank[possible_start:possible_end]
        current_max: int = max(possible_vals)
        joltages += str(current_max)
        cur = cur + possible_vals.index(current_max) + 1
        battery_left -= 1
    return int(joltages)


def parse_banks(lines: list[str]) -> list[list[str]]:
    parsed: list[list[str]] = []
    for line in lines:
        bank: list[str] = []
        for n in line.strip():
            bank.append(n)
        parsed.append(bank)
    return parsed


if __name__ == "__main__":
    main()
