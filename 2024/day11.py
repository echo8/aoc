def load_stones(path: str) -> list[int]:
  with open(path) as f:
    contents = f.read()
    for line in contents.splitlines():
      return [int(n) for n in line.split()]

def blink(stones: list[int]) -> list[int]:
  new_stones = []
  for stone in stones:
    if stone == 0:
      new_stones.append(1)
    elif len(str(stone)) % 2 == 0:
      stone_str = str(stone)
      mid = int(len(stone_str)/2)
      new_stones.append(int(stone_str[0:mid]))
      new_stones.append(int(stone_str[mid:]))
    else:
      new_stones.append(stone * 2024)
  return new_stones

from collections import defaultdict

def get_stone_dict(stones: list[int]) -> dict[int, int]:
  stone_dict = defaultdict(int)
  for stone in stones:
    stone_dict[stone] += 1
  return stone_dict

def blink2(stone_dict: dict[int, int]) -> dict[int, int]:
  new_dict = defaultdict(int)
  for stone in stone_dict:
    if stone == 0:
      new_dict[1] += stone_dict[0]
    elif len(str(stone)) % 2 == 0:
      cnt = stone_dict[stone]
      stone_str = str(stone)
      mid = int(len(stone_str)/2)
      new_dict[int(stone_str[0:mid])] += cnt
      new_dict[int(stone_str[mid:])] += cnt
    else:
      new_dict[stone * 2024] += stone_dict[stone]
  return new_dict

def part1():
  stones = load_stones("day11_input.txt")
  for i in range(25):
    stones = blink(stones)
  print(len(stones))

def part2():
  stones = load_stones("day11_input.txt")
  stone_dict = get_stone_dict(stones)
  for i in range(75):
    stone_dict = blink2(stone_dict)
  total_stones = sum(stone_dict.values())
  print(total_stones)

part1()
part2()
