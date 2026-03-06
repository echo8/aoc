from dataclasses import dataclass
from utils import read_all


@dataclass
class IdRange:
    start: int
    end: int


def main() -> None:
    part1(read_all("inputs/day2ex1.txt"))
    part1(read_all("inputs/day2input.txt"))
    part2(read_all("inputs/day2ex1.txt"))
    part2(read_all("inputs/day2input.txt"))


def part1(id_ranges: str) -> None:
    invalid_ids: list[int] = []
    for id_range in parse_id_ranges(id_ranges):
        for id in range(id_range.start, id_range.end + 1):
            id_str = str(id)
            if len(id_str) <= 1:
                continue
            middle_idx = int(len(id_str) / 2)
            if id_str[:middle_idx] == id_str[middle_idx:]:
                invalid_ids.append(id)
    print(sum(invalid_ids))


def part2(id_ranges: str) -> None:
    invalid_ids: list[int] = []
    for id_range in parse_id_ranges(id_ranges):
        for id in range(id_range.start, id_range.end + 1):
            id_str = str(id)
            for end in range(int(len(id_str) / 2)):
                id_ss = id_str[0 : end + 1]
                id_ss_cnt = id_str.count(id_ss)
                if id_ss_cnt >= 2 and id_ss_cnt * len(id_ss) == len(id_str):
                    invalid_ids.append(id)
                    break
    print(sum(invalid_ids))


def parse_id_ranges(id_ranges: str) -> list[IdRange]:
    parsed: list[IdRange] = []
    for range in id_ranges.split(","):
        range_parts = range.split("-")
        parsed.append(IdRange(int(range_parts[0]), int(range_parts[1])))
    return parsed


if __name__ == "__main__":
    main()
