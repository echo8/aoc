def load_map(path: str) -> tuple[list[list[str]], tuple[int, int]]:
  with open(path) as f:
    contents = f.read()
    mp = []
    start_pos = None
    for line in contents.splitlines():
      row = []
      for i in range(len(line)):
        row.append(line[i])
        if line[i] == "^":
          start_pos = (len(mp), i)
      mp.append(row)
    return (mp, start_pos)

def has_loop(mp: list[list[str]], start_pos: tuple[int, int]) -> bool:
  row, col = start_pos
  row_dir = -1
  col_dir = 0
  pos_set = set()
  pos_set.add((row, col, row_dir, col_dir))
  while True:
    new_row = row + row_dir
    new_col = col + col_dir
    if new_row == -1 or new_row == len(mp) or new_col == -1 or new_col == len(mp[0]):
      break
    while mp[new_row][new_col] == "#":
      # turn right
      if row_dir == 1 and col_dir == 0:
        row_dir = 0
        col_dir = -1
      elif row_dir == 0 and col_dir == 1:
        row_dir = 1
        col_dir = 0
      elif row_dir == -1 and col_dir == 0:
        row_dir = 0
        col_dir = 1
      elif row_dir == 0 and col_dir == -1:
        row_dir = -1
        col_dir = 0
      new_row = row + row_dir
      new_col = col + col_dir
    if (new_row, new_col, row_dir, col_dir) in pos_set:
      return True
    pos_set.add((new_row, new_col, row_dir, col_dir))
    row = new_row
    col = new_col
  return False

def part1():
  mp, start_pos = load_map("day06_input.txt")
  pos_set = set()
  pos_set.add(start_pos)
  row, col = start_pos
  row_dir = -1
  col_dir = 0
  while True:
    new_row = row + row_dir
    new_col = col + col_dir
    if new_row == -1 or new_row == len(mp) or new_col == -1 or new_col == len(mp[0]):
      break
    if mp[new_row][new_col] == "#":
      # turn right
      if row_dir == 1 and col_dir == 0:
        row_dir = 0
        col_dir = -1
      elif row_dir == 0 and col_dir == 1:
        row_dir = 1
        col_dir = 0
      elif row_dir == -1 and col_dir == 0:
        row_dir = 0
        col_dir = 1
      elif row_dir == 0 and col_dir == -1:
        row_dir = -1
        col_dir = 0
      new_row = row + row_dir
      new_col = col + col_dir
    pos_set.add((new_row, new_col))
    row = new_row
    col = new_col
  print(len(pos_set))

def part2():
  mp, start_pos = load_map("day06_input.txt")
  loops = 0
  for row in range(len(mp)):
    for col in range(len(mp[row])):
      if mp[row][col] == ".":
        mp[row][col] = "#"
        if has_loop(mp, start_pos):
          loops += 1
        mp[row][col] = "."
  print(loops)

part1()
part2()
