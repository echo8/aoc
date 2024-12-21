def load_map(path: str) -> list[list[str]]:
  with open(path) as f:
    contents = f.read()
    mp = []
    for line in contents.splitlines():
      row = []
      for i in range(len(line)):
        row.append(line[i])
      mp.append(row)
    return mp

def build_pos_map(mp: list[list[str]]) -> dict[str, list[tuple[int, int]]]:
  res = {}
  for row in range(len(mp)):
    for col in range(len(mp[row])):
      if mp[row][col] != ".":
        if mp[row][col] in res:
          res[mp[row][col]].append((row, col))
        else:
          pos_list = []
          pos_list.append((row, col))
          res[mp[row][col]] = pos_list
  return res

def get_antinode_pos(i: tuple[int, int], j: tuple[int, int], mp: list[list[str]]) -> list[tuple[int, int]]:
  res = []
  i_row, i_col = i
  j_row, j_col = j
  if i_col > j_col:
    col_diff = i_col - j_col
    row_diff = j_row - i_row
    ia_col = i_col + col_diff
    ia_row = i_row - row_diff
    if in_map((ia_col, ia_row), mp):
      res.append((ia_col, ia_row))
    ja_col = j_col - col_diff
    ja_row = j_row + row_diff
    if in_map((ja_col, ja_row), mp):
      res.append((ja_col, ja_row))
  elif j_col > i_col:
    col_diff = j_col - i_col
    row_diff = j_row - i_row
    ia_col = i_col - col_diff
    ia_row = i_row - row_diff
    if in_map((ia_col, ia_row), mp):
      res.append((ia_col, ia_row))
    ja_col = j_col + col_diff
    ja_row = j_row + row_diff
    if in_map((ja_col, ja_row), mp):
      res.append((ja_col, ja_row))
  return res

def in_map(pos: tuple[int, int], mp: list[list[str]]) -> bool:
  return pos[0] in range(len(mp)) and pos[1] in range(len(mp[0]))

def get_antinode_pos2(i: tuple[int, int], j: tuple[int, int], mp: list[list[str]]) -> list[tuple[int, int]]:
  res = []
  i_row, i_col = i
  j_row, j_col = j
  if i_col > j_col:
    col_diff = i_col - j_col
    row_diff = j_row - i_row
    ia_col = i_col + col_diff
    ia_row = i_row - row_diff
    while in_map((ia_row, ia_col), mp):
      res.append((ia_row, ia_col))
      ia_col = ia_col + col_diff
      ia_row = ia_row - row_diff
    ja_col = j_col - col_diff
    ja_row = j_row + row_diff
    while in_map((ja_row, ja_col), mp):
      res.append((ja_row, ja_col))
      ja_col = ja_col - col_diff
      ja_row = ja_row + row_diff
  elif j_col > i_col:
    col_diff = j_col - i_col
    row_diff = j_row - i_row
    ia_col = i_col - col_diff
    ia_row = i_row - row_diff
    while in_map((ia_row, ia_col), mp):
      res.append((ia_row, ia_col))
      ia_col = ia_col - col_diff
      ia_row = ia_row - row_diff
    ja_col = j_col + col_diff
    ja_row = j_row + row_diff
    while in_map((ja_row, ja_col), mp):
      res.append((ja_row, ja_col))
      ja_col = ja_col + col_diff
      ja_row = ja_row + row_diff
  return res

def part1():
  mp = load_map("day08_input.txt")
  pos_map = build_pos_map(mp)

  apos_set = set()
  for key in pos_map:
    pos_list = pos_map[key]
    for i in range(len(pos_list)):
      for j in range(i+1, len(pos_list)):
        for apos in get_antinode_pos(pos_list[i], pos_list[j], mp):
          apos_set.add(apos)
  print(len(apos_set))

def part2():
  mp = load_map("day08_input.txt")
  pos_map = build_pos_map(mp)

  apos_set = set()
  for key in pos_map:
    pos_list = pos_map[key]
    for i in range(len(pos_list)):
      apos_set.add(pos_list[i])
      for j in range(i+1, len(pos_list)):
        for apos in get_antinode_pos2(pos_list[i], pos_list[j], mp):
          apos_set.add(apos)
  print(len(apos_set))

part1()
part2()
