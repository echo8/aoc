def load_map(path: str) -> list[list[int]]:
  with open(path) as f:
    contents = f.read()
    mp = []
    for line in contents.splitlines():
      row = []
      for i in range(len(line)):
        row.append(int(line[i]))
      mp.append(row)
    return mp

def find_trails(mp: list[list[int]], row: int, col: int, ends: set[tuple[int, int]]) -> int:
  if mp[row][col] == 9:
    ends.add((row, col))
    return
  if row > 0 and mp[row-1][col] == mp[row][col]+1:
    find_trails(mp, row-1, col, ends)
  if row < len(mp)-1 and mp[row+1][col] == mp[row][col]+1:
    find_trails(mp, row+1, col, ends)
  if col > 0 and mp[row][col-1] == mp[row][col]+1:
    find_trails(mp, row, col-1, ends)
  if col < len(mp[0])-1 and mp[row][col+1] == mp[row][col]+1:
    find_trails(mp, row, col+1, ends)

def get_rating(mp: list[list[int]], row: int, col: int) -> int:
  if mp[row][col] == 9:
    return 1
  score = 0
  if row > 0 and mp[row-1][col] == mp[row][col]+1:
    score += get_rating(mp, row-1, col)
  if row < len(mp)-1 and mp[row+1][col] == mp[row][col]+1:
    score += get_rating(mp, row+1, col)
  if col > 0 and mp[row][col-1] == mp[row][col]+1:
    score += get_rating(mp, row, col-1)
  if col < len(mp[0])-1 and mp[row][col+1] == mp[row][col]+1:
    score += get_rating(mp, row, col+1)
  return score

def part1():
  mp = load_map("day10_input.txt")
  score = 0
  for row in range(len(mp)):
    for col in range(len(mp[row])):
      if mp[row][col] == 0:
        ends = set()
        find_trails(mp, row, col, ends)
        score += len(ends)
  print(score)

def part2():
  mp = load_map("day10_input.txt")
  score = 0
  for row in range(len(mp)):
    for col in range(len(mp[row])):
      if mp[row][col] == 0:
        score += get_rating(mp, row, col)
  print(score)

part1()
part2()
