from dataclasses import dataclass
from utils import read_lines


@dataclass
class Rotation:
    direction: str
    length: int


def main() -> None:
    part1(read_lines("inputs/day1ex1.txt"))
    part1(read_lines("inputs/day1input.txt"))
    part2(read_lines("inputs/day1ex1.txt"))
    part2(read_lines("inputs/day1ex2.txt"))
    part2(read_lines("inputs/day1input.txt"))
    # part2_naive(read_lines("inputs/day1ex1.txt"))
    # part2_naive(read_lines("inputs/day1ex2.txt"))
    # part2_naive(read_lines("inputs/day1input.txt"))


def part1(rotations: list[str]) -> None:
    pos: int = 50
    zero_count: int = 0
    for r in parse_rotations(rotations):
        if r.direction == "R":
            pos += r.length
        else:
            pos -= r.length
        pos = pos % 100
        if pos == 0:
            zero_count += 1
    print(zero_count)


def part2(rotations: list[str]) -> None:
    pos: int = 50
    zero_count: int = 0
    for r in parse_rotations(rotations):
        if r.direction == "R":
            zero_count += abs(int((pos + r.length) / 100))
            pos += r.length
        else:
            zero_count += (1 if pos != 0 and pos - r.length < 0 else 0) + abs(
                int((pos - r.length) / 100)
            )
            pos -= r.length
            if pos == 0:
                zero_count += 1
        pos = pos % 100
    print(zero_count)


def part2_naive(rotations: list[str]) -> None:
    pos: int = 50
    zero_count: int = 0
    for r in parse_rotations(rotations):
        for _ in range(r.length):
            if r.direction == "R":
                pos += 1
                if pos == 100:
                    pos = 0
            else:
                pos -= 1
                if pos == -1:
                    pos = 99
            if pos == 0:
                zero_count += 1
    print(zero_count)


def parse_rotations(rotations: list[str]) -> list[Rotation]:
    parsed: list[Rotation] = []
    for rotation in rotations:
        parsed.append(Rotation(rotation[0], int(rotation[1:])))
    return parsed


if __name__ == "__main__":
    main()
