from dataclasses import dataclass
from utils import read_lines
from typing import Literal

Operation = Literal["+", "*"]


@dataclass
class Problem:
    numbers: list[int]
    operation: Operation


def main() -> None:
    part1(read_lines("inputs/day6ex1.txt"))
    part1(read_lines("inputs/day6input.txt"))
    part2(read_lines("inputs/day6ex1.txt"))
    part2(read_lines("inputs/day6input.txt"))


def part1(lines: list[str]) -> None:
    total = solve_problems(parse_horizontal_numbers(lines))
    print(total)


def part2(lines: list[str]) -> None:
    total = solve_problems(parse_vertical_numbers(lines))
    print(total)


def parse_horizontal_numbers(lines: list[str]) -> list[Problem]:
    numbers: list[list[int]] = []
    operations: list[Operation] = []
    for line in lines:
        parts = line.strip().split()
        if parts[0] == "+" or parts[0] == "*":
            operations = [("+" if o == "+" else "*") for o in parts]
        else:
            numbers.append([int(n) for n in parts])
    problems: list[Problem] = []
    for i in range(len(operations)):
        problem_numbers: list[int] = []
        for line in numbers:
            problem_numbers.append(line[i])
        problems.append(Problem(problem_numbers, operations[i]))
    return problems


def parse_vertical_numbers(lines: list[str]):
    numbers: dict[tuple[int, int], str] = {}
    max_num_idx: dict[int, int] = {}
    max_prob_idx: int = 0
    operations: list[Operation] = []
    prob_idx = 0
    num_idx = 0
    for line in lines:
        parts = line.strip().split()
        if parts[0] == "+" or parts[0] == "*":
            operations = [("+" if o == "+" else "*") for o in parts]
        else:
            for c_idx, c in enumerate(line.rstrip("\r\n")):
                if c == " ":
                    if is_col_splitter(lines, c_idx):
                        max_num_idx[prob_idx] = num_idx - 1
                        prob_idx += 1
                        num_idx = 0
                    else:
                        num_idx += 1
                else:
                    pos = (prob_idx, num_idx)
                    if pos in numbers:
                        numbers[pos] += c
                    else:
                        numbers[pos] = c
                    num_idx += 1
            max_num_idx[prob_idx] = num_idx - 1
            max_prob_idx = max(max_prob_idx, prob_idx)
            prob_idx = 0
            num_idx = 0
    problems: list[Problem] = []
    for p in range(max_prob_idx + 1):
        problem_numbers: list[int] = []
        for n in range(max_num_idx[p] + 1):
            problem_numbers.append(int(numbers[(p, n)]))
        problems.append(Problem(problem_numbers, operations[p]))
    return problems


def is_col_splitter(lines: list[str], c_idx: int) -> bool:
    for line in lines:
        if line[c_idx] != " ":
            return False
    return True


def solve_problems(problems: list[Problem]) -> int:
    total = 0
    for prob in problems:
        answer = prob.numbers[0]
        if prob.operation == "+":
            for n in prob.numbers[1:]:
                answer += n
        else:
            for n in prob.numbers[1:]:
                answer *= n
        total += answer
    return total


if __name__ == "__main__":
    main()
