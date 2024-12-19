def get_reports(path: str) -> list[list[int]]:
  with open(path) as f:
    contents = f.read()
    reports = []
    for line in contents.splitlines():
      reports.append([int(s) for s in line.split()])
    return reports

def is_increasing(report: list[int]) -> bool:
  for i, n in enumerate(report):
    if i != 0 and report[i-1] > n:
      return False
  return True

def is_decreasing(report: list[int]) -> bool:
  for i, n in enumerate(report):
    if i != 0 and report[i-1] < n:
      return False
  return True

def is_ok_diff(report: list[int]) -> bool:
  for i, n in enumerate(report):
    if i != 0:
      diff = abs(report[i-1] - n)
      if diff < 1 or diff > 3:
        return False
  return True

def is_safe(report: list[int]) -> bool:
  return (is_increasing(report) or is_decreasing(report)) and is_ok_diff(report)

def is_safe_with_removal(report: list[int]) -> bool:
  for i in range(len(report)):
    report_copy = report.copy()
    report_copy.pop(i)
    if is_safe(report_copy):
      return True
  return False

def part1():
  reports = get_reports("day02_input.txt")
  safe_reports = 0
  for report in reports:
    if is_safe(report):
      safe_reports += 1
  print(safe_reports)

def part2():
  reports = get_reports("day02_input.txt")
  safe_reports = 0
  for report in reports:
    if is_safe_with_removal(report):
      safe_reports += 1
  print(safe_reports)

part1()
part2()
