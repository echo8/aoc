def read_lines(file_path: str) -> list[str]:
    lines: list[str] = []
    with open(file_path, "r") as f:
        for line in f:
            lines.append(line)
    return lines


def read_all(file_path: str) -> str:
    with open(file_path, "r") as f:
        return f.read()
