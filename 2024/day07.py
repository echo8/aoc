def load_equations(path: str) -> list[tuple[int, list[int]]]:
  with open(path) as f:
    contents = f.read()
    eqs = []
    for line in contents.splitlines():
      tv, nums = line.split(": ")
      eqs.append((int(tv), [int(n) for n in nums.split()]))
    return eqs

def is_valid(tv: int, nums: list[int], pos: int, val: int) -> bool:
  if pos == len(nums):
    return tv == val
  if pos == 0:
    return is_valid(tv, nums, pos+1, nums[pos])
  if is_valid(tv, nums, pos+1, val + nums[pos]):
    return True
  if is_valid(tv, nums, pos+1, val * nums[pos]):
    return True
  return False

def is_valid2(tv: int, nums: list[int], pos: int, val: int) -> bool:
  if pos == len(nums):
    return tv == val
  if pos == 0:
    return is_valid2(tv, nums, pos+1, nums[pos])
  if is_valid2(tv, nums, pos+1, val + nums[pos]):
    return True
  if is_valid2(tv, nums, pos+1, val * nums[pos]):
    return True
  if is_valid2(tv, nums, pos+1, int(str(val) + str(nums[pos]))):
    return True
  return False

def part1():
  eqs = load_equations("day07_input.txt")
  sum = 0
  for eq in eqs:
    tv, nums = eq
    if is_valid(tv, nums, 0, 0):
      sum += tv
  print(sum)

def part2():
  eqs = load_equations("day07_input.txt")
  sum = 0
  for eq in eqs:
    tv, nums = eq
    if is_valid2(tv, nums, 0, 0):
      sum += tv
  print(sum)

part1()
part2()
