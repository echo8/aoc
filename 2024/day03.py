def get_programs(path: str) -> list[str]:
  with open(path) as f:
    contents = f.read()
    programs = []
    for line in contents.splitlines():
      programs.append(line)
    return programs

def parse_num(program: str, start: int) -> tuple[int, int] | None:
  i = 0
  num = ""
  while program[start+i].isdigit() and i < 3:
    num += program[start+i]
    i += 1
  if i > 0:
    return (start+i, int(num))
  else:
    return None

def parse_mul(program: str, start: int) -> int:
  if program[start:].startswith("mul("):
    next1, num1 = parse_num(program, start+4)
    if next1 is None:
      return 0
    if program[next1] != ",":
      return 0
    next2, num2 = parse_num(program, next1+1)
    if next2 is None:
      return 0
    if program[next2] != ")":
      return 0
    return num1 * num2
  return 0

def parse_do(program: str, start: int) -> bool:
  return program[start:].startswith("do()")

def parse_dont(program: str, start: int) -> bool:
  return program[start:].startswith("don't()")

def part1():
  programs = get_programs("day03_input.txt")
  res = 0
  for program in programs:
    for i in range(len(program)):
      res += parse_mul(program, i)
  print(res)

def part2():
  mul_enabled = True
  programs = get_programs("day03_input.txt")
  res = 0
  for program in programs:
    for i in range(len(program)):
      if parse_do(program, i):
        mul_enabled = True
      elif parse_dont(program, i):
        mul_enabled = False
      elif mul_enabled:
        res += parse_mul(program, i)
  print(res)

part1()
part2()
