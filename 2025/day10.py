import z3
from dataclasses import dataclass
from functools import cache
from utils import read_lines


@dataclass
class Machine:
    lights: list[bool]
    buttons: list[list[int]]
    jolt_reqs: list[int]


def main() -> None:
    part1(parse_machines(read_lines("inputs/day10ex1.txt")))
    part1(parse_machines(read_lines("inputs/day10input.txt")))
    part2(parse_machines(read_lines("inputs/day10ex1.txt")))
    part2(parse_machines(read_lines("inputs/day10input.txt")))


def part1(machines: list[Machine]) -> None:
    presses: list[int] = []
    for machine in machines:
        lights = "".join(["#" if l else "." for l in machine.lights])
        buttons = machine.buttons

        @cache
        def find_button_presses(cur_lights: str, presses: int) -> int:
            if lights == cur_lights:
                return 0
            if presses > len(buttons):
                return len(buttons) + 1
            min_presses = len(buttons) + 1
            for button in buttons:
                next_lights = list(cur_lights)
                for l in button:
                    if next_lights[l] == "#":
                        next_lights[l] = "."
                    else:
                        next_lights[l] = "#"
                res = 1 + find_button_presses("".join(next_lights), presses + 1)
                min_presses = min(min_presses, res)
            return min_presses

        presses.append(find_button_presses("".join(["." for _ in lights]), 0))
    print(sum(presses))


def part2(machines: list[Machine]) -> None:
    presses: list[int] = []
    for machine in machines:
        buttons = machine.buttons
        jolt_reqs = machine.jolt_reqs

        optimize = z3.Optimize()

        button_counts = []
        for i in range(len(buttons)):
            button_counts.append(z3.Int("b" + str(i)))

        for j, jolt in enumerate(jolt_reqs):
            counts = []
            for i, button in enumerate(buttons):
                if j not in button:
                    continue
                counts.append(button_counts[i])
            optimize.add(z3.Sum(counts) == jolt)

        for count in button_counts:
            optimize.add(count >= 0)

        optimize.minimize(z3.Sum(button_counts))

        if optimize.check() != z3.sat:
            print("failed to solve")
            return

        model = optimize.model()
        presses.append(sum([int(model[count].__str__()) for count in button_counts]))
    print(sum(presses))


def parse_machines(lines: list[str]) -> list[Machine]:
    machines: list[Machine] = []
    for line in lines:
        parts = line.strip().split(" ")
        lights: list[bool] = []
        for l in parts[0][1:-1]:
            if l == "#":
                lights.append(True)
            else:
                lights.append(False)
        buttons: list[list[int]] = []
        for b in parts[1:-1]:
            button: list[int] = []
            for light in b[1:-1].split(","):
                button.append(int(light))
            buttons.append(button)
        jolt_reqs: list[int] = [int(j) for j in parts[-1][1:-1].split(",")]
        machines.append(Machine(lights, buttons, jolt_reqs))
    return machines


if __name__ == "__main__":
    main()
