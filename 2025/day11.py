from functools import cache
from utils import read_lines


def main() -> None:
    part1(parse_devices(read_lines("inputs/day11ex1.txt")))
    part1(parse_devices(read_lines("inputs/day11input.txt")))
    part2(parse_devices(read_lines("inputs/day11ex2.txt")))
    part2(parse_devices(read_lines("inputs/day11input.txt")))


def part1(devices: dict[str, list[str]]) -> None:
    print(count_all_paths(devices, "you"))


def part2(devices: dict[str, list[str]]) -> None:
    @cache
    def count_paths(cur: str, has_fft: bool, has_dac: bool) -> int:
        if cur == "out":
            if has_fft and has_dac:
                return 1
            else:
                return 0
        total = 0
        for device in devices[cur]:
            next_fft = has_fft
            if device == "fft":
                next_fft = True
            next_dac = has_dac
            if device == "dac":
                next_dac = True
            total += count_paths(device, next_fft, next_dac)
        return total

    print(count_paths("svr", False, False))


def count_all_paths(devices: dict[str, list[str]], cur: str) -> int:
    if cur == "out":
        return 1
    total = 0
    for device in devices[cur]:
        total += count_all_paths(devices, device)
    return total


def parse_devices(lines: list[str]) -> dict[str, list[str]]:
    devices: dict[str, list[str]] = {}
    for line in lines:
        name, outputs = line.strip().split(": ")
        devices[name] = outputs.split(" ")
    return devices


if __name__ == "__main__":
    main()
