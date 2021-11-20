package com.echo8.aoc2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day24Part1 {
    private static final String INPUT = "sesenwnenenewseeswwswswwnenewsewsw\n" +
            "neeenesenwnwwswnenewnwwsewnenwseswesw\n" +
            "seswneswswsenwwnwse\n" +
            "nwnwneseeswswnenewneswwnewseswneseene\n" +
            "swweswneswnenwsewnwneneseenw\n" +
            "eesenwseswswnenwswnwnwsewwnwsene\n" +
            "sewnenenenesenwsewnenwwwse\n" +
            "wenwwweseeeweswwwnwwe\n" +
            "wsweesenenewnwwnwsenewsenwwsesesenwne\n" +
            "neeswseenwwswnwswswnw\n" +
            "nenwswwsewswnenenewsenwsenwnesesenew\n" +
            "enewnwewneswsewnwswenweswnenwsenwsw\n" +
            "sweneswneswneneenwnewenewwneswswnese\n" +
            "swwesenesewenwneswnwwneseswwne\n" +
            "enesenwswwswneneswsenwnewswseenwsese\n" +
            "wnwnesenesenenwwnenwsewesewsesesew\n" +
            "nenewswnwewswnenesenwnesewesw\n" +
            "eneswnwswnwsenenwnwnwwseeswneewsenese\n" +
            "neswnwewnwnwseenwseesewsenwsweewe\n" +
            "wseweeenwnesenwwwswnew";

    private static final String INPUT2 = "nwwswee";

    private static final String INPUT3 = "sweswneswswswswwswswswseneswswnwswwne\n" +
            "swwswswswnwswwnwswswswwswswseenwsesw\n" +
            "eeeeseeeneeenesweweeeswee\n" +
            "swswswwneseneswswwnwswneswswwenewne\n" +
            "seesesesenewsenwseseesesesesesenwesee\n" +
            "nwsenwnwnewnewnwenenewnenenwneenenwne\n" +
            "seseswsesenwnwswsenwneswswsesenwseswswsesw\n" +
            "enwnwneswnewneswnwnenenwnesewsenenenwne\n" +
            "swswnwsweseseswswswseweswswswnwseswsesw\n" +
            "wwwweneswswwswwswswwwwswnewnww\n" +
            "wwwnewwswswseswewwsewswwwswwnwne\n" +
            "wswswwnwswwswwseewwweswwnesww\n" +
            "wnwnwsenenwnwnwsenwnw\n" +
            "nwwwsesenwnewsenenweneneeeswwsese\n" +
            "senenwnwwnwsewwewswnwnwewnwnwwnwnw\n" +
            "seswsesenwseswseseeseeseseewswneseww\n" +
            "ewswseneswseswswswnewnwwswswswnwewnw\n" +
            "nwnwnwnenwsesesenwnwwewnwnwwewwe\n" +
            "swswswswswswnwseneswwswsww\n" +
            "swseneweswswseswseeseswswswseswwnww\n" +
            "swseswswswneswswswewwwswwsw\n" +
            "wswwnwnewnwnwwnwswwnesenwnwwwnww\n" +
            "wwnewnewnwswwwwwsewwwswwwswese\n" +
            "wswsesewswswwwwenewwwwwwnwswsw\n" +
            "seeeeneweeesweeeeneeeeeew\n" +
            "swseswneneseeswweswneswsewnwswsewese\n" +
            "eseseeneswsenweswesewenwseneenww\n" +
            "neswnwnwnenwnwenenwwswnwswnenwnenwenw\n" +
            "swewswswswswswwenwswswwswswnewswnesw\n" +
            "eswwnwnwnewsenwwnewwwsweesesene\n" +
            "swneneswnwneneswnwwnenwneneneneeseswwsene\n" +
            "swnwnenenenwnewenwnenweeneswneswnenwswsw\n" +
            "seneewesesesesenwseswsesesesewseseesese\n" +
            "wseswsenwwnesenwnwenwneesewnwwnwwnw\n" +
            "nwnenenwnenwnwnenenwnwneeneesesweneswnwsw\n" +
            "nesenewneneneneneneenenenenenenewe\n" +
            "seneseseseswswseesenwsee\n" +
            "swsweswenwswneswwswswwswswewsweswsw\n" +
            "ewneswewwwnwwsewwswwwwwwwww\n" +
            "wwwneswnwnweseseewnenwewwswww\n" +
            "swneenwnwnwnwwwwnwsenwwwenwswnwnwww\n" +
            "seenwswseseesenwsenwseseseseseseswsese\n" +
            "seeesweeseeneesee\n" +
            "nwnwwsenewnwwnwnwwsenwnewsesenwsenwnw\n" +
            "wswswseswseneeswswswswseswswseswswnw\n" +
            "neeseesesewsesewseeseseeeeeenwse\n" +
            "swnwnwenewnwnwnwnwnwnwnwsenwnwnwnwnwnwe\n" +
            "wwenweswnweenwnwsewswneenewsenenw\n" +
            "nwseeweswseeswnwneseweenesenwenee\n" +
            "nwnwnwnwnwnwnwnwnwnwswsenewesenwnwnwnw\n" +
            "nwwneseneeneneneneneesenwnenene\n" +
            "neneeneeseneneneswneswnwnenenenenewnene\n" +
            "neneeswenwseneene\n" +
            "nesenenweswswswsesenwnesesewswswwsww\n" +
            "wwwsewnwnwwwnwnwneewse\n" +
            "wwwnwnwneswsenwewswswewnewswnwnw\n" +
            "neewwewneneeeseseneeneenewseneee\n" +
            "wswnweswnewswwswsewnenewwe\n" +
            "neneesesenwnwsweene\n" +
            "swnwenenwnwnwseswswneewnwnenwnesewesesw\n" +
            "seseswseswnwswswweseswseweswsesenwsee\n" +
            "swsesesenwwnwenwnwneeswseswseswesesenw\n" +
            "nwnwnwnwnwnwnwnwnwnenwsenwnw\n" +
            "senweeewewsewewnwesenewneswenwsw\n" +
            "nenwnenwwweswsenwseseswswswwnenewswenw\n" +
            "eseeesweenweeesesesewseeeenwe\n" +
            "neswnenenenweeswseeseswewswnwneneene\n" +
            "sewnwwswwwnwnwnenenwswenwwwnwnwnw\n" +
            "wseneseeeseseseseseseee\n" +
            "seeeeeseweseseseseewwsesesesesew\n" +
            "swseswnwswnwnesewsweswswsw\n" +
            "neseneneeneenenewseeenesweenwene\n" +
            "swseswsenewswseseseswseseseswse\n" +
            "nwnwnwwswwswwwnene\n" +
            "nwnwewnweneneenenwwwsenwswneswee\n" +
            "wnwswnwneswnwwnwwnewwenwwwsenwww\n" +
            "swneswneswswneenenenenwenweneneeew\n" +
            "wwswwswswswwswwseswswswswnwswne\n" +
            "swnwseesesesesesesenweseeseseseesewe\n" +
            "eenenwneneneswnenwneeneneeswnenenwneswne\n" +
            "seeseseeswseewnweenwsenwswesesene\n" +
            "wswswswswswseswsewwnwswswnww\n" +
            "eeeweneeswenenewweeeenenesenee\n" +
            "nwwwewswnwwwwewnwsesew\n" +
            "wswsenweenwnwwnwswewswnene\n" +
            "seseesenweswswseseswsesweswwswnwswse\n" +
            "eeneswenenenwswnwnenenesw\n" +
            "seseneswwnwneswswsweswnenwnwsenewswenesw\n" +
            "neneneneneswneneswnenenenwneswnenenenee\n" +
            "neeswnenenenenenenenwnewe\n" +
            "swswswnwseswseswsenwswswswseswsesw\n" +
            "nenwswswswswswswwsenwseswswwswswswswswesw\n" +
            "wseesenwwnwswseseenwseseseswseeswsenese\n" +
            "sewwnenewwwwwwswwwwwnww\n" +
            "wsewseseseneeeseeweeesew\n" +
            "nwnwnwnwenwnwnwnwnwnwnwenwnwnwswsenwswnw\n" +
            "neswwseswseswseswswswseseswnewseswswne\n" +
            "wswnwwnwenwwnwwnwwewwwww\n" +
            "nwnwnwswwwwnwewnewwwnwnw\n" +
            "eweeeseseeeeseee\n" +
            "wswwnwnwnwnwenwnwnwswnwnwwwnenw\n" +
            "nenenwnenenenenenenenesenenenenw\n" +
            "wneneswneseeneenenenenweneeeneene\n" +
            "wewnwenwwenwnwnwnesenwnwwnwnwew\n" +
            "seseswswneseseseseseseseneswsesese\n" +
            "neneneneneenwsewnesenenenenenwnwnewnene\n" +
            "wwwwwnewswseswwsewnwwwwneww\n" +
            "swwswwwwwwesewswwswwwswnene\n" +
            "nwenwnenwneneswnwnenesewnwnenenwnwnwne\n" +
            "seenwswswseseeswswnwenwenwnweesene\n" +
            "senwsewnenwneswwnwnwenwswenwwnwwnenw\n" +
            "newsenwseweesenewnwnwnwwwswnwnwnwsw\n" +
            "eseseseeewnwesewswseenwenwewne\n" +
            "wswneswswswswswswsw\n" +
            "sewswsesesesesesewswwseneseenesw\n" +
            "enenwnwsenwnwwsenwnwnwwwnwnwnwsewnw\n" +
            "senwewswsenenwwseesweweneeseswnew\n" +
            "senenenwnenenwnenwnwnenwenenwnwnwswwe\n" +
            "neeseseeseseeewseeseseee\n" +
            "wswwwnwsewnewswswnewwwse\n" +
            "nwnwnenwwwwswwsewwwewsewswswswesw\n" +
            "esweneeeneeeeeeenwne\n" +
            "swwwnewswnwwswwsenweseeewswswswnw\n" +
            "nwnwnwsesenwnwwwenenesewnwswwnwnwnwsw\n" +
            "nwswnenenenwnwnwenenenwswnweewnwnwne\n" +
            "nwnenwwnwnwewnwnwnwsenwnwsewnwnwsene\n" +
            "eswnwswswswsweswwswwsweswswswswwnwsw\n" +
            "enewnenenenenewneneeswnenwnenwneew\n" +
            "swswseswswneswewswwseswnwwnwneswneswsesw\n" +
            "nwewswseeswsenwwweswneesewenenwe\n" +
            "eswswseswseseswswnewse\n" +
            "nwneneneseneneneseneneneneneswnenenwnene\n" +
            "sesesenwenweeenwnwswwsweeneneenene\n" +
            "nwwnwnwsesenwnwnwnwnwnenenwwneswesenwne\n" +
            "seewnenwwnwnewwsenwswwwwwnwnew\n" +
            "eswneneeneenwneswneneneneswnewsenee\n" +
            "neneswnenwnenwnwnenene\n" +
            "eesweseeeeneeweeeeeenwenw\n" +
            "seseseseneseseseseswswnewnwsesewswswse\n" +
            "nwnwsenwswwnwnesenwenenenwneeswnwnwne\n" +
            "wneswwwwnwnewnwwswswwnwwnwwsene\n" +
            "eswneneswnweneneneneneeneene\n" +
            "nwnwwwsenwswswnwswenenwnew\n" +
            "swswswswwwnwwenwwswswswneswswseswe\n" +
            "ewwnwseseswnewswwneswwswnwswswee\n" +
            "eesewwneeeseneeseseweseeseee\n" +
            "eeweweeeeesenweeeeeeeesw\n" +
            "enwnenwnwnenwnwnwnenwswneswnwnwnwenwnw\n" +
            "nwnwwwswsewwnwnweswnwwnewswnewnwnw\n" +
            "eeneneewseneneeenenweeeweeseese\n" +
            "nwnwswsenewwwsewnwwwneww\n" +
            "newnenenwnwwnweseswsenenesenwnenew\n" +
            "eseseneseeeseseswwnwseeeenwseesese\n" +
            "seswswswnewnwnwewswsenweswseenwswse\n" +
            "swsenenwseswseseswwseneswsewswsenenew\n" +
            "wnenenwnenwnwewnwnenwseneenwnwnewnw\n" +
            "neneneenwwseeenwswseeewseneeewse\n" +
            "swewsesenwneseneeswenwsese\n" +
            "eswseesweeenenenweenenenewnenwne\n" +
            "newnenenenewnenesweneneneneenwnwnenesw\n" +
            "wnwwnwwnwwnwnwsewwnwnwnww\n" +
            "sewwwsewwwwwwnenwenenwwww\n" +
            "eseewnesenwseseseseneswsenwsesesenenww\n" +
            "neswswnewseswseeswswswsewswseseswswswe\n" +
            "seswwnwsweweswnwnesenwswseeenwsesw\n" +
            "nenenenenenenweneewwenesweswenenw\n" +
            "seseneseswsesewnwwseesenwnwsw\n" +
            "nwswnwweswnenwnwnenenenwnwnwswnenwnwnwnw\n" +
            "nwswnwewswswswwewwwswswswwswnewsw\n" +
            "seneseneeeeswswsenwnewnwwenenwwswne\n" +
            "seeseseseenwswsewseswwneswsenewnwswne\n" +
            "wwwwnwwewewswswwwwwwewnw\n" +
            "neeswewwwwwwswwwseenwnewwseew\n" +
            "neneswnwwnenwnwwswwnwnwesese\n" +
            "eeneneeneneneneneneewee\n" +
            "nwwswseneeeenewneeeeneenewsweesw\n" +
            "nweswsweswneswenwsweeneswswwswwnw\n" +
            "swneneneseneeeswnwswnweneneneenwneee\n" +
            "seenwswnwnwswswswswseswswesweswseswsene\n" +
            "swswswneswswnwenwsenesewenwnwsenwswswswe\n" +
            "eeneweeseseweeseeesesenesesese\n" +
            "nwnesenenwnwnenwnenwnewswneenenenenene\n" +
            "wnewnenwswwnwwsenwseseeswnenewewwsw\n" +
            "eeeseneweenenwwweewsweneeee\n" +
            "neneswenwswnwenesweneneeeneneeneeene\n" +
            "eneswweeswesenwnenenenee\n" +
            "nwswweswneesesenenwswswswe\n" +
            "neswseswseneswwneneneeswnwnenenewnenene\n" +
            "swswesesenwsenewseseseseswseeswswswswse\n" +
            "eswnwswswswseswswswswswsw\n" +
            "nwnwnwewnwnwneneenwwsenwnwnwnwwnene\n" +
            "enewswwseseswnenwneenenwnwsesesewnenene\n" +
            "eenwnwwswenwnwnwwenesenwewneswne\n" +
            "seseseseswseneseseneewswsesewsese\n" +
            "neneneneneneswswnewneenwneneewnenenee\n" +
            "ewswwswswwnwnwwwswswswseswwwwse\n" +
            "wnwneswwswswnwwnwweenenwnwewsenwne\n" +
            "sewneseenwseseseneenwswseseesew\n" +
            "enweeneseswswneeneweeswsesweenw\n" +
            "nwnwnwsenwnwnwnenwnwnwwnwnwnwnwsew\n" +
            "nwnenwwnwnwswnwnwwnwnwwwnwenwenww\n" +
            "nwnenenwneswswnwnwnenwnesenwsenenenenenenw\n" +
            "sesenesewnwseseeseew\n" +
            "swnwwnwsenwneswnwneenenwsenesene\n" +
            "seeseswwnewwnwewwwswesenwnewsenw\n" +
            "swsweswswweswwswewswswnwswwneswswsw\n" +
            "seeseswnwweseenesesesenesesenwwseew\n" +
            "swseswswswswsweswswsewswswenwswnesww\n" +
            "nwnwwwnwwnwswnwnwseenwenwsenwnwnenw\n" +
            "nwsewsewnwsesesenweswseseseseeesese\n" +
            "seeneeenwneneneeeenenenee\n" +
            "swnwwnwnwnwnwnwnenwnwnwnwnw\n" +
            "swseeswswseneeseswseeswsesenwwswswswnw\n" +
            "wnewwswsewwwwww\n" +
            "nwseeswnwnweewweswnewswnwweee\n" +
            "swseswsesenesesenwwseswseeswseseseenwse\n" +
            "swswnwwseswneeswwswneseswnew\n" +
            "seseeseneseseweeseesesenenwseswww\n" +
            "nesenwwewsesweesewseswswwswnwne\n" +
            "swnwwneeenwnwnwswswenwnwnenwenwwswnw\n" +
            "senwnwsenwwsenwnwne\n" +
            "swswswnwswwseneeneswwswnewneswnesewswse\n" +
            "wsenenweewwewnwwnwnenwnwnwesenw\n" +
            "nwnwnwnwwnwnwnwnwnwsenwswnwnwnwnwnwsene\n" +
            "neenenwneneseneesweneswwswne\n" +
            "eweeeesenweeeenwseweweeee\n" +
            "wswwweswsewwnewseswwwnewwwnesw\n" +
            "wnwnenwswnwnwnwnwwwnwwnwnw\n" +
            "nwnwewnwswneenenwnenwnwnwnenw\n" +
            "eneeweseeswswesenwnwseeswenwseene\n" +
            "eswnwnwsweeeswwswnwswwswwseenww\n" +
            "weswsesewnwwseeseweseseeeneenenew\n" +
            "nwnwnwnwnwwewnwnwnwwnwnwsenwnw\n" +
            "nwnwnwswnwnwnwnenewnwenwnwne\n" +
            "nwseneewneseneeseseseswsewwsesewsew\n" +
            "swsenweseseeeseswseeeseseewesenwne\n" +
            "wswnwnwwwewswnwwnewsenwnwweww\n" +
            "seesewswnwesenwswswsenwswswseswesw\n" +
            "neesewnwsenwsewnwsweswsenenewneewse\n" +
            "nwnwwwnwnwsewnewwwnwnwwnwnwswenw\n" +
            "neneswswswswsesenwswswswswwswseseswswsw\n" +
            "nweeswswneneeeneneewswneenenenwswne\n" +
            "wseeeweseeeeseneeeeenweeew\n" +
            "nenenewneneneneswneneseneeneeenenewne\n" +
            "nwnwnwenwnwnwnwnwnenwswnw\n" +
            "sewsesesenenesewseseseseneeesesewe\n" +
            "eeneseswseweeeeeeweseeeenwe\n" +
            "nwnwnwnwewnwwswnwnwnwwenwenwnwenw\n" +
            "nwnwnwsewseeseenww\n" +
            "nwenwnenenwswnwenenwneswneswnwnwnwnwnwne\n" +
            "wwswseneswseneweswenwseseswswsweswsw\n" +
            "swwwnweswswwwnesewsw\n" +
            "eneeeeeeswwneneeeee\n" +
            "nwnewwwwwseewswnewwwwwwnww\n" +
            "senwnwnwnwnwnwnwnwwsenenwnwnwnwnwsenwnwnw\n" +
            "seswnwsesewseswseeseseswewnwesenwswse\n" +
            "newneswneneeneenenenenenewne\n" +
            "swwwswswswweeswnwnewseseneseneenesew\n" +
            "wwewwnewswnwwwwnwnwswwsewwse\n" +
            "nenenesenesenewsenenwnwnesenewnwnenenenw\n" +
            "seeeenwesweweeeneneseeneseswsw\n" +
            "nwnwswnwsenewnenwnwnwnwsenwnenwnwnwnwnenw\n" +
            "swneneneneneenesewneeeseswewswnenee\n" +
            "sweewenwneenesenwsweneneeneneswne\n" +
            "sesweseseenwseseseswsenwseneseseseseese\n" +
            "nwsewwenenwseewnwewwsweswewnwse\n" +
            "seswswseseneesewwenwswwswneseeneswswse\n" +
            "sweswsweseswswswsweswswswswswnwswswwnw\n" +
            "newnwseeenwnwenesewwneswswne\n" +
            "nenwnenwwwneenenwnenwnenwswnwneseese\n" +
            "eseenwesesesenwseweseeeeswswnwe\n" +
            "nwnwwnwnwwenwnwnwwnwnwwsw\n" +
            "swwwseswwnwwswswenewwswswwwnwww\n" +
            "wnenwnenenwnwwnenwsenwnwsenwnwnesewsene\n" +
            "swnwwsewswnewwswwwewewwnwwsw\n" +
            "wsweswswneneswseneswswnwswswenwswse\n" +
            "swnwseseenewseswsenw\n" +
            "eesenesweeneesenwswseeseewnweee\n" +
            "eneeeeneeeneneewnesene\n" +
            "seeseneseswwneweseneeeswenwsesenesw\n" +
            "wswseswwswswwwneswneseswneeswwwwwsw\n" +
            "nwesesweewswnwenwnweswnwswsw\n" +
            "nwnwnwnenwnwsenwnesenwnwenwwnwnwwnwnw\n" +
            "swneswenwnwnweneenwnwswnwnenwnwnwnenenwse\n" +
            "nesweswnwswnwneneeneewnwneseneeswnenese\n" +
            "neeenwseneewneswnenwseeeneenenenenew\n" +
            "swnwnwenwnwnweswnwnwnwnwnwnwnenwnwnwnese\n" +
            "nesenewswwneneswnweneenwnenee\n" +
            "swswswswswneswswswswswswswswsw\n" +
            "neneneneeneneewswenenenwewneswenene\n" +
            "weneneseeneneeenenenweeeeneewswe\n" +
            "wwwsenwwsewnwenenenwneswwnewseseesw\n" +
            "newnwnesenesenwneesewnwwnwwnwenenw\n" +
            "seenwnwneeeneeeweenesweeesese\n" +
            "nwnenewnesenwwnwnenwnwnwnwwnwseenwwnwse\n" +
            "ewnenwswneseneeese\n" +
            "wneewseeswneneswsweeeenwnesenwne\n" +
            "swswseswnwsewsewnwswswwswnwswswnesesw\n" +
            "seseseseseeseesesesewsese\n" +
            "nwwswswwswsewwwswsww\n" +
            "swneswseeneswsewswswwswsw\n" +
            "neswwswswnewewnesewwesenesenesww\n" +
            "newwnenwneneseesenenenenenenenweswnw\n" +
            "weswsweswswswwswwneswswswswswswnwwsw\n" +
            "swswswswswneswenwswweswswseswseseswnw\n" +
            "wsewnwsewnwwwsweneww\n" +
            "seeeeeenweesweeseee\n" +
            "sesesesesesesesesewesenwswneneseseswnw\n" +
            "nwnenwnwnwsenwnwnwwnwnweneswwe\n" +
            "wnenwnwsewnwwnewnwsesenwnwsenewnw\n" +
            "seeseneswesewnwe\n" +
            "swwnenwnwenenwseswneswwnesesweeswnwnw\n" +
            "swwswneswswwwswwneseeswwswswswsenwsw\n" +
            "eewwwneeseneeewwewenenewne\n" +
            "swswswwseneeneswwswseswswnewswnewnwsw\n" +
            "newnenenewswenesenenwneneesewneenesw\n" +
            "neeseswnweswswsenwwsenwweesesesesesw\n" +
            "seeseeswenwnweeeeeeeenw\n" +
            "seswswswseswwseenwseseswseseseesesw\n" +
            "wswswswnenwswswseswswseswswseswswnesesww\n" +
            "esesenweeswseeeseenesenwese\n" +
            "eseseenwseseeseseweesewseseesesw\n" +
            "enwnwnwsenwnwswnwnwnwnwnwnwnenwne\n" +
            "esesewneneeseswseewwnweeseeswnwse\n" +
            "wsewwenwswnwwsewwnwwwwswwwew\n" +
            "nwswswswseneswswswneseseeswwwnesenesesw\n" +
            "nwsesenwseeseesesweseseseeseeseeew\n" +
            "enewwwswwewwewwnenwsewwwwse\n" +
            "nwnweneeswewwnwnenwenwwwenenwnw\n" +
            "wwwwwneswswswwwwwewwwswnew\n" +
            "eswseseswnwswsewsw\n" +
            "wsweswwwenwwwsesewweswnwswwnwsw\n" +
            "nwsewwwnwnwsenwnweewwnwwnenewnw";

    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Map<Coord, Boolean> coordMap = new HashMap<>();
        for (String line : INPUT3.split("\n")) {
            Coord c = new Coord(0, 0);
            String cur = line;
            while (cur.length() > 0) {
                if (cur.startsWith("w")) {
                    c.x -= 1;
                    cur = cur.substring(1);
                } else if (cur.startsWith("e")) {
                    c.x += 1;
                    cur = cur.substring(1);
                } else if (cur.startsWith("nw")) {
                    c.y -= 1;
                    cur = cur.substring(2);
                } else if (cur.startsWith("se")) {
                    c.y += 1;
                    cur = cur.substring(2);
                } else if (cur.startsWith("ne")) {
                    c.x += 1;
                    c.y -= 1;
                    cur = cur.substring(2);
                } else if (cur.startsWith("sw")) {
                    c.x -= 1;
                    c.y += 1;
                    cur = cur.substring(2);
                }
            }
            if (coordMap.containsKey(c)) {
                coordMap.put(c, !coordMap.get(c));
            } else {
                coordMap.put(c, true);
            }
        }
//        System.out.println(coordMap);
        int blackCount = 0;
        for (Map.Entry<Coord, Boolean> entry : coordMap.entrySet()) {
            if (entry.getValue()) {
                blackCount++;
            }
        }
        System.out.println(blackCount);
    }
}
