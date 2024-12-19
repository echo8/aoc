def get_lists(path: str) -> tuple[list[int], list[int]]:
  with open(path) as f:
    contents = f.read()
    list1 = []
    list2 = []
    for line in contents.splitlines():
      parts = line.split()
      list1.append(int(parts[0]))
      list2.append(int(parts[1]))
    return (list1, list2)

def part1():
  lists = get_lists("day1_input.txt")
  lists[0].sort()
  lists[1].sort()

  total_distance = 0
  for i in range(len(lists[0])):
    total_distance += abs(lists[0][i] - lists[1][i])
  print(total_distance)

from collections import defaultdict

def part2():
  lists = get_lists("day1_input.txt")

  right_counts = defaultdict(int)
  for n in lists[1]:
    right_counts[n] += 1

  similarity_score = 0
  for n in lists[0]:
    similarity_score += n * right_counts[n]
  print(similarity_score)

part1()
part2()
