from dataclasses import dataclass
from utils import read_lines
from typing import Literal


@dataclass
class IdRange:
    start: int
    end: int


@dataclass
class ParsedIdInfo:
    fresh_id_ranges: list[IdRange]
    available_ids: list[int]


@dataclass
class StartOrEnd:
    id: int
    type: Literal["start", "end"]


def main() -> None:
    part1(parse_id_info(read_lines("inputs/day5ex1.txt")))
    part1(parse_id_info(read_lines("inputs/day5input.txt")))
    part2(parse_id_info(read_lines("inputs/day5ex1.txt")))
    part2(parse_id_info(read_lines("inputs/day5input.txt")))


def part1(parsed_id_info: ParsedIdInfo) -> None:
    fresh_cnt = 0
    for id in parsed_id_info.available_ids:
        for range in parsed_id_info.fresh_id_ranges:
            if id >= range.start and id <= range.end:
                fresh_cnt += 1
                break
    print(fresh_cnt)


def part2(parsed_id_info: ParsedIdInfo) -> None:
    largest_ranges = get_largest_ranges(parsed_id_info.fresh_id_ranges)
    fresh_cnt = 0
    for range in largest_ranges:
        fresh_cnt += (range.end - range.start) + 1
    print(fresh_cnt)


def get_largest_ranges(fresh_id_ranges: list[IdRange]) -> list[IdRange]:
    start_ends: list[StartOrEnd] = []
    for range in fresh_id_ranges:
        start_ends.append(StartOrEnd(range.start, "start"))
        start_ends.append(StartOrEnd(range.end, "end"))
    start_ends.sort(key=lambda e: e.id + (0.1 if e.type == "start" else 0.2))
    depth: int = 0
    cur_start: StartOrEnd | None = None
    largest_ranges: list[IdRange] = []
    for se in start_ends:
        if se.type == "start":
            depth += 1
            if depth == 1:
                cur_start = se
        else:
            depth -= 1
            if depth == 0 and cur_start is not None:
                largest_ranges.append(IdRange(cur_start.id, se.id))
                cur_start = None
    return largest_ranges


def parse_id_info(lines: list[str]) -> ParsedIdInfo:
    fresh_id_ranges: list[IdRange] = []
    available_ids: list[int] = []
    for line in lines:
        if line.count("-") > 0:
            parts = line.strip().split("-")
            fresh_id_ranges.append(IdRange(int(parts[0]), int(parts[1])))
        elif len(line.strip()) > 0:
            available_ids.append(int(line.strip()))
    return ParsedIdInfo(fresh_id_ranges, available_ids)


if __name__ == "__main__":
    main()
