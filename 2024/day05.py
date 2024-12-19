def load_puzzle(path: str) -> tuple[list[tuple[int, int]], list[list[int]]]:
  with open(path) as f:
    contents = f.read()
    ordering_rules = []
    pages_produce = []
    parse_ordering = True
    for line in contents.splitlines():
      if line == "":
        parse_ordering = False
        continue
      if parse_ordering:
        parts = line.split("|")
        ordering_rules.append((int(parts[0]), int(parts[1])))
      else:
        pages_produce.append([int(n) for n in line.split(",")])
    return (ordering_rules, pages_produce)

from collections import defaultdict

def build_rule_dict(rules: list[tuple[int, int]]) -> dict[int, set[int]]:
  rule_dict = defaultdict(set)
  for rule in rules:
    before, after = rule
    rule_dict[before].add(after)
  return rule_dict

def is_valid(rule_dict: dict[int, set[int]], pages: list[int]) -> bool:
  for p in range(len(pages)):
    page = pages[p]
    for ap in range(p+1, len(pages)):
      after_page = pages[ap]
      if after_page not in rule_dict[page]:
        return False
  return True

def is_valid_page(rule_dict: dict[int, set[int]], page: int, after: list[int]) -> bool:
  for n in after:
    if n not in rule_dict[page]:
      return False
  return True

def find_valid(rule_dict: dict[int, set[int]], after: list[int], new_pages: list[int]) -> list[int] | None:
  if len(after) == 0:
    return new_pages
  for p in range(len(after)):
    after_new = after.copy()
    page = after_new.pop(p)
    if is_valid_page(rule_dict, page, after_new):
      np = new_pages.copy()
      np.append(page)
      maybe_valid = find_valid(rule_dict, after_new, np)
      if maybe_valid is not None:
        return maybe_valid
  return None

def part1():
  rules, pages_produce = load_puzzle("day05_input.txt")
  rule_dict = build_rule_dict(rules)
  middle_sum = 0
  for pages in pages_produce:
    if is_valid(rule_dict, pages):
      middle_sum += pages[int(len(pages)/2)]
  print(middle_sum)

def part2():
  rules, pages_produce = load_puzzle("day05_input.txt")
  rule_dict = build_rule_dict(rules)
  middle_sum = 0
  for pages in pages_produce:
    if not is_valid(rule_dict, pages):
      valid_pages = find_valid(rule_dict, pages, [])
      middle_sum += valid_pages[int(len(valid_pages)/2)]
  print(middle_sum)

part1()
part2()
