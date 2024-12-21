def load_disk_map(path: str) -> list[int]:
  with open(path) as f:
    contents = f.read()
    dm = []
    for line in contents.splitlines():
      for i in range(len(line)):
        dm.append(int(line[i]))
    return dm

def convert_to_blocks(dm: list[int]) -> list[str]:
  file = True
  id = 0
  blocks = []
  for i in range(len(dm)):
    if file:
      for j in range(dm[i]):
        blocks.append(str(id))
      id += 1
      file = False
    else:
      for j in range(dm[i]):
        blocks.append(".")
      file = True
  return blocks

def move_blocks(blocks: list[str]):
  j = 0
  for i in range(len(blocks)-1, -1, -1):
    if blocks[i] != ".":
      while blocks[j] != "." and j < i:
        j += 1
      if blocks[j] == ".":
        blocks[j] = blocks[i]
        blocks[i] = "."
      else:
        return

def find_free_space(blocks: list[str], start: int, end: int) -> tuple[int, int] | None:
  n = start
  while blocks[n] != "." and n < end:
    n += 1
  if blocks[n] == ".":
    m = n+1
    while blocks[m] == "." and m < end:
      m += 1
    return (n, m)
  return None

def move_files(blocks: list[str]):
  i = len(blocks)-1
  while i >= 0:
    if blocks[i] != ".":
      j = i-1
      while blocks[j] == blocks[i]:
        j -= 1
      f = blocks[j+1:i+1]
      n = 0
      fs = find_free_space(blocks, n, i)
      while fs is not None:
        if len(f) <= (fs[1]-fs[0]):
          for m in range(len(f)):
            blocks[fs[0]+m] = f[0]
            blocks[j+1+m] = "."
          break
        n = fs[1]
        fs = find_free_space(blocks, n, i)
      i = j
    else:
      i -= 1

def calc_checksum(blocks: list[str]) -> int:
  sum = 0
  for i, n in enumerate(blocks):
    if n != ".":
      sum += i * int(n)
  return sum

def part1():
  dm = load_disk_map("day09_input.txt")
  blocks = convert_to_blocks(dm)
  move_blocks(blocks)
  print(calc_checksum(blocks))

def part2():
  dm = load_disk_map("day09_input.txt")
  blocks = convert_to_blocks(dm)
  move_files(blocks)
  print(calc_checksum(blocks))

part1()
part2()
