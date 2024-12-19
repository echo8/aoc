def load_puzzle(path: str) -> list[list[str]]:
  with open(path) as f:
    contents = f.read()
    puzzle = []
    for line in contents.splitlines():
      row = []
      for i in range(len(line)):
        row.append(line[i])
      puzzle.append(row)
    return puzzle

def search(puzzle: list[list[str]], start_row: int, start_col: int, dir_row: int, dir_col: int, search_str: str = "XMAS") -> bool:
  row = start_row
  col = start_col
  if row == -1 or row == len(puzzle) or col == -1 or col == len(puzzle[row]):
    return False
  for i in range(len(search_str)):
    if row == -1 or row == len(puzzle) or col == -1 or col == len(puzzle[row]) or puzzle[row][col] != search_str[i]:
      return False
    row += dir_row
    col += dir_col
  return True

def part1():
  puzzle = load_puzzle("day04_input.txt")
  count = 0
  for row in range(len(puzzle)):
    for col in range(len(puzzle[row])):
      if search(puzzle, row, col, 1, 0):
        count += 1
      if search(puzzle, row, col, -1, 0):
        count += 1
      if search(puzzle, row, col, 0, 1):
        count += 1
      if search(puzzle, row, col, 0, -1):
        count += 1
      if search(puzzle, row, col, 1, 1):
        count += 1
      if search(puzzle, row, col, -1, -1):
        count += 1
      if search(puzzle, row, col, 1, -1):
        count += 1
      if search(puzzle, row, col, -1, 1):
        count += 1
  print(count)

def part2():
  puzzle = load_puzzle("day04_input.txt")
  count = 0
  for row in range(len(puzzle)):
    for col in range(len(puzzle[row])):
      if search(puzzle, row, col, 1, 1, "MAS"):
        if search(puzzle, row, col+2, 1, -1, "MAS"):
          count += 1
      if search(puzzle, row, col, -1, -1, "MAS"):
        if search(puzzle, row, col-2, -1, 1, "MAS"):
          count += 1
      if search(puzzle, row, col, 1, -1, "MAS"):
        if search(puzzle, row+2, col, -1, -1, "MAS"):
          count += 1
      if search(puzzle, row, col, -1, 1, "MAS"):
        if search(puzzle, row-2, col, 1, 1, "MAS"):
          count += 1
  print(count)

part1()
part2()
