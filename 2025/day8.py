from math import prod, sqrt
from utils import read_lines


def main() -> None:
    part1(parse_coords(read_lines("inputs/day8ex1.txt")), 10)
    part1(parse_coords(read_lines("inputs/day8input.txt")))
    part2(parse_coords(read_lines("inputs/day8ex1.txt")))
    part2(parse_coords(read_lines("inputs/day8input.txt")))


def part1(coords: list[tuple[int, int, int]], n=1000) -> None:
    print(connect_jbs(coords, n=n))


def part2(coords: list[tuple[int, int, int]]) -> None:
    print(connect_jbs(coords, n=None))


def connect_jbs(coords: list[tuple[int, int, int]], n: int | None = 1000) -> int:
    dists: list[tuple[int, int, float]] = []
    for i, a in enumerate(coords):
        for j, b in enumerate(coords[i + 1 :]):
            dists.append((i, i + 1 + j, dist(a, b)))
    dists.sort(key=lambda c: c[2])
    circuits: dict[int, list[int]] = {}
    jb_to_circuits: dict[int, int] = {}
    total = 0
    last_i = 0
    last_j = 0
    for d in dists[:n]:
        i, j, _ = d
        if i not in jb_to_circuits.keys() and j not in jb_to_circuits.keys():
            total += 1
            cid = total
            circuits[cid] = [i, j]
            jb_to_circuits[i] = cid
            jb_to_circuits[j] = cid
        elif i in jb_to_circuits.keys() and j not in jb_to_circuits.keys():
            cid = jb_to_circuits[i]
            circuits[cid].append(j)
            jb_to_circuits[j] = cid
        elif i not in jb_to_circuits.keys() and j in jb_to_circuits.keys():
            cid = jb_to_circuits[j]
            circuits[cid].append(i)
            jb_to_circuits[i] = cid
        else:
            cid1 = jb_to_circuits[i]
            cid2 = jb_to_circuits[j]
            if cid1 == cid2:
                continue
            circuits[cid1] += circuits[cid2]
            for jb in circuits[cid2]:
                jb_to_circuits[jb] = cid1
            del circuits[cid2]
        if len(circuits) == 1 and len(jb_to_circuits) == len(coords):
            last_i = i
            last_j = j
            break
    if n is not None:
        circuit_sizes = sorted([len(jbs) for jbs in circuits.values()], reverse=True)
        return prod(circuit_sizes[:3])
    else:
        return coords[last_i][0] * coords[last_j][0]


def dist(a: tuple[int, int, int], b: tuple[int, int, int]) -> float:
    return sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2 + (a[2] - b[2]) ** 2)


def parse_coords(lines: list[str]) -> list[tuple[int, int, int]]:
    coords: list[tuple[int, int, int]] = []
    for line in lines:
        x, y, z = line.strip().split(",")
        coords.append((int(x), int(y), int(z)))
    return coords


if __name__ == "__main__":
    main()
