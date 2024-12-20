package com.echo8.aoc2020;

import java.util.*;

public class Day7Part1 {
    private static final String INPUT = "shiny indigo bags contain 4 vibrant lime bags.\n" +
            "clear lime bags contain 1 dotted lime bag, 2 clear gold bags.\n" +
            "dotted turquoise bags contain 2 shiny green bags, 5 striped magenta bags, 3 muted green bags.\n" +
            "bright red bags contain 1 plaid magenta bag, 3 light cyan bags.\n" +
            "vibrant magenta bags contain 5 drab lime bags, 3 muted red bags, 3 wavy turquoise bags, 3 mirrored salmon bags.\n" +
            "plaid violet bags contain 4 plaid indigo bags, 1 mirrored beige bag.\n" +
            "muted gray bags contain 2 striped crimson bags, 2 striped maroon bags, 1 faded maroon bag, 4 dim lavender bags.\n" +
            "mirrored crimson bags contain 5 muted lavender bags.\n" +
            "muted gold bags contain 3 striped plum bags, 4 bright coral bags.\n" +
            "pale black bags contain 4 shiny orange bags, 3 pale bronze bags, 2 wavy coral bags.\n" +
            "muted purple bags contain 5 muted brown bags.\n" +
            "clear cyan bags contain 4 muted white bags.\n" +
            "shiny blue bags contain 5 pale magenta bags, 3 drab coral bags.\n" +
            "posh white bags contain 3 posh brown bags, 3 striped gold bags, 1 faded gray bag.\n" +
            "muted beige bags contain 1 pale teal bag.\n" +
            "clear purple bags contain 4 plaid turquoise bags.\n" +
            "pale gold bags contain 1 mirrored lime bag, 2 dim crimson bags, 3 dim aqua bags, 2 dull silver bags.\n" +
            "pale beige bags contain 4 drab olive bags, 2 wavy coral bags.\n" +
            "drab black bags contain 4 mirrored blue bags, 2 light olive bags.\n" +
            "faded purple bags contain 3 dim lime bags, 2 vibrant violet bags.\n" +
            "pale silver bags contain 3 light cyan bags.\n" +
            "plaid teal bags contain 3 dotted fuchsia bags, 3 bright teal bags.\n" +
            "plaid beige bags contain 5 shiny black bags, 3 dotted maroon bags.\n" +
            "light silver bags contain 3 posh chartreuse bags, 4 dark bronze bags, 1 vibrant silver bag, 2 muted coral bags.\n" +
            "pale plum bags contain 5 drab silver bags, 4 light crimson bags.\n" +
            "striped cyan bags contain 3 wavy tan bags, 5 pale teal bags, 5 clear orange bags, 3 wavy violet bags.\n" +
            "plaid red bags contain 2 dim lavender bags, 4 striped maroon bags.\n" +
            "dark salmon bags contain 5 bright gold bags, 5 muted lavender bags, 5 light beige bags.\n" +
            "shiny purple bags contain 2 plaid silver bags, 2 mirrored green bags, 3 bright violet bags.\n" +
            "shiny turquoise bags contain 1 vibrant salmon bag.\n" +
            "muted orange bags contain 2 striped indigo bags, 1 striped crimson bag.\n" +
            "pale turquoise bags contain 3 light silver bags, 5 light crimson bags.\n" +
            "light indigo bags contain 4 vibrant white bags, 5 plaid yellow bags.\n" +
            "faded coral bags contain 1 vibrant beige bag, 4 muted white bags.\n" +
            "dim red bags contain 1 mirrored cyan bag, 2 wavy indigo bags, 5 shiny chartreuse bags, 5 muted yellow bags.\n" +
            "striped fuchsia bags contain 2 faded salmon bags, 1 pale beige bag, 2 posh magenta bags, 2 wavy green bags.\n" +
            "bright green bags contain 4 pale turquoise bags, 2 bright chartreuse bags, 5 posh yellow bags, 4 shiny gold bags.\n" +
            "light blue bags contain 5 dim silver bags.\n" +
            "vibrant purple bags contain 3 wavy indigo bags, 1 pale maroon bag, 3 drab chartreuse bags, 5 vibrant aqua bags.\n" +
            "light coral bags contain 2 clear orange bags, 3 shiny fuchsia bags, 3 striped chartreuse bags.\n" +
            "striped maroon bags contain 4 vibrant tomato bags, 2 dull salmon bags, 1 shiny gold bag, 2 muted coral bags.\n" +
            "drab lime bags contain 1 mirrored violet bag, 4 posh magenta bags.\n" +
            "dotted gold bags contain 3 muted silver bags.\n" +
            "pale magenta bags contain 5 mirrored orange bags, 4 pale teal bags.\n" +
            "dim olive bags contain no other bags.\n" +
            "mirrored blue bags contain 1 dim indigo bag, 4 bright lime bags, 1 plaid beige bag.\n" +
            "plaid bronze bags contain 3 pale gold bags.\n" +
            "faded aqua bags contain 3 muted aqua bags, 3 muted gray bags, 4 dim olive bags.\n" +
            "light gold bags contain 1 mirrored crimson bag, 3 pale tan bags, 3 dotted yellow bags, 2 wavy aqua bags.\n" +
            "dim gold bags contain 4 plaid tomato bags.\n" +
            "faded chartreuse bags contain 5 muted coral bags, 4 vibrant indigo bags, 1 faded teal bag, 1 vibrant bronze bag.\n" +
            "posh brown bags contain 2 muted gray bags, 1 dark plum bag, 3 bright lime bags, 2 dull turquoise bags.\n" +
            "mirrored lime bags contain 1 shiny indigo bag, 4 dark olive bags, 3 pale beige bags.\n" +
            "posh cyan bags contain 3 pale olive bags.\n" +
            "dark lime bags contain 3 shiny cyan bags, 4 bright green bags.\n" +
            "drab lavender bags contain 4 drab plum bags.\n" +
            "vibrant orange bags contain 5 wavy olive bags.\n" +
            "faded violet bags contain 1 faded aqua bag, 2 muted gray bags.\n" +
            "light green bags contain 5 pale brown bags, 4 dark aqua bags, 5 vibrant teal bags, 1 pale black bag.\n" +
            "bright turquoise bags contain 4 striped teal bags, 2 dim magenta bags, 5 striped orange bags, 4 bright aqua bags.\n" +
            "mirrored indigo bags contain 2 wavy violet bags, 2 muted white bags, 2 dim lavender bags.\n" +
            "wavy green bags contain 5 dotted teal bags.\n" +
            "light aqua bags contain 4 posh lime bags, 1 dotted maroon bag, 3 dotted gray bags, 2 plaid bronze bags.\n" +
            "muted tomato bags contain 3 mirrored tomato bags, 3 pale blue bags, 2 mirrored violet bags, 4 drab tomato bags.\n" +
            "posh beige bags contain 5 faded aqua bags.\n" +
            "shiny coral bags contain 5 striped gold bags, 1 drab coral bag, 2 light lavender bags, 4 striped blue bags.\n" +
            "posh orange bags contain 5 dark olive bags, 3 light silver bags, 3 striped gray bags, 2 faded fuchsia bags.\n" +
            "posh violet bags contain 2 drab turquoise bags, 5 mirrored gray bags.\n" +
            "pale brown bags contain 2 bright chartreuse bags.\n" +
            "shiny green bags contain 2 mirrored magenta bags.\n" +
            "faded salmon bags contain 2 wavy tan bags.\n" +
            "dark gold bags contain no other bags.\n" +
            "clear black bags contain 5 vibrant lime bags.\n" +
            "muted fuchsia bags contain 1 pale fuchsia bag, 4 mirrored white bags, 3 clear fuchsia bags, 3 faded maroon bags.\n" +
            "drab fuchsia bags contain 1 bright chartreuse bag, 3 pale beige bags, 5 wavy brown bags.\n" +
            "mirrored plum bags contain 1 plaid yellow bag, 2 dim beige bags, 5 dim aqua bags, 4 dim crimson bags.\n" +
            "dark maroon bags contain 1 striped crimson bag, 5 muted fuchsia bags, 3 vibrant silver bags, 2 drab olive bags.\n" +
            "drab green bags contain 5 faded bronze bags, 2 bright violet bags, 3 dark gold bags.\n" +
            "drab purple bags contain 3 plaid orange bags, 4 striped black bags, 5 vibrant indigo bags, 4 pale turquoise bags.\n" +
            "dotted silver bags contain 1 clear crimson bag, 2 faded yellow bags.\n" +
            "dull olive bags contain 3 muted salmon bags, 2 vibrant cyan bags, 3 posh bronze bags, 5 light cyan bags.\n" +
            "posh gold bags contain 4 bright violet bags, 1 drab yellow bag.\n" +
            "dark plum bags contain 4 clear fuchsia bags, 2 mirrored aqua bags.\n" +
            "dim purple bags contain 5 clear chartreuse bags, 4 dark gold bags.\n" +
            "drab tomato bags contain 5 mirrored white bags.\n" +
            "mirrored chartreuse bags contain 3 clear indigo bags, 4 clear crimson bags.\n" +
            "striped olive bags contain 4 posh orange bags, 5 shiny indigo bags.\n" +
            "dark purple bags contain 2 drab lavender bags, 2 faded bronze bags.\n" +
            "light purple bags contain 1 vibrant lime bag, 2 vibrant gray bags.\n" +
            "mirrored green bags contain 4 mirrored cyan bags.\n" +
            "bright lavender bags contain 1 dark red bag, 2 clear yellow bags, 3 bright brown bags, 2 bright teal bags.\n" +
            "posh tomato bags contain 4 posh silver bags, 3 shiny black bags, 4 clear crimson bags, 3 dotted chartreuse bags.\n" +
            "dotted coral bags contain 4 dotted bronze bags, 5 dotted maroon bags.\n" +
            "pale cyan bags contain 2 dim coral bags, 4 dotted brown bags.\n" +
            "plaid gold bags contain 4 bright chartreuse bags, 4 faded bronze bags.\n" +
            "bright tan bags contain 3 bright brown bags.\n" +
            "dim chartreuse bags contain 2 clear maroon bags, 3 pale tan bags, 2 mirrored lime bags, 1 wavy crimson bag.\n" +
            "dark bronze bags contain 4 faded maroon bags, 1 wavy violet bag, 4 plaid silver bags.\n" +
            "wavy brown bags contain 4 light red bags, 2 dull tomato bags, 5 mirrored red bags, 4 bright lime bags.\n" +
            "dim fuchsia bags contain 4 dark beige bags.\n" +
            "drab bronze bags contain 2 dotted blue bags.\n" +
            "bright plum bags contain 2 plaid orange bags.\n" +
            "shiny red bags contain 1 faded fuchsia bag.\n" +
            "vibrant brown bags contain 3 faded fuchsia bags, 2 light plum bags.\n" +
            "pale tan bags contain 3 dark aqua bags, 3 dark plum bags, 1 mirrored green bag.\n" +
            "dull aqua bags contain 3 muted cyan bags, 5 drab cyan bags.\n" +
            "dark teal bags contain 1 light red bag, 4 plaid silver bags, 2 dark olive bags, 5 striped maroon bags.\n" +
            "pale tomato bags contain 4 dim indigo bags, 4 dark salmon bags.\n" +
            "faded silver bags contain 5 dim blue bags.\n" +
            "striped lime bags contain 2 bright black bags.\n" +
            "plaid coral bags contain 4 dull salmon bags, 5 mirrored green bags, 1 pale aqua bag.\n" +
            "clear white bags contain 4 drab turquoise bags, 2 posh coral bags, 5 dark fuchsia bags.\n" +
            "dark turquoise bags contain 1 wavy lavender bag, 4 bright lime bags.\n" +
            "dark tomato bags contain 5 faded maroon bags, 4 dark chartreuse bags, 5 wavy fuchsia bags, 2 dotted purple bags.\n" +
            "striped bronze bags contain no other bags.\n" +
            "dark black bags contain 2 dotted chartreuse bags, 3 pale bronze bags.\n" +
            "dotted teal bags contain 2 dark teal bags.\n" +
            "drab yellow bags contain 3 dark turquoise bags, 4 muted fuchsia bags.\n" +
            "wavy salmon bags contain 2 plaid turquoise bags.\n" +
            "dull violet bags contain 3 mirrored red bags, 5 shiny black bags, 3 dark maroon bags.\n" +
            "muted cyan bags contain 4 mirrored black bags, 4 dim olive bags, 1 bright chartreuse bag, 1 clear bronze bag.\n" +
            "clear plum bags contain 4 light teal bags, 1 faded white bag, 3 striped lime bags.\n" +
            "light red bags contain 3 mirrored orange bags.\n" +
            "pale gray bags contain 5 wavy cyan bags, 2 bright green bags, 3 striped gray bags.\n" +
            "posh green bags contain 3 clear purple bags.\n" +
            "dark crimson bags contain 5 bright violet bags, 4 light magenta bags, 1 posh chartreuse bag, 1 shiny gray bag.\n" +
            "dull yellow bags contain 1 dotted fuchsia bag, 5 muted maroon bags, 1 muted salmon bag.\n" +
            "plaid plum bags contain 1 striped olive bag.\n" +
            "wavy lime bags contain 3 vibrant silver bags, 5 shiny gold bags.\n" +
            "dim green bags contain 1 dark tomato bag, 5 light red bags, 4 muted gold bags.\n" +
            "mirrored yellow bags contain 1 vibrant tomato bag.\n" +
            "dotted yellow bags contain 3 striped crimson bags.\n" +
            "drab turquoise bags contain 1 clear indigo bag, 1 mirrored magenta bag, 4 clear violet bags.\n" +
            "dim aqua bags contain 3 wavy coral bags, 1 posh beige bag.\n" +
            "pale violet bags contain 1 faded plum bag, 4 dull purple bags, 2 pale brown bags.\n" +
            "muted crimson bags contain 3 dim beige bags, 2 dim gray bags.\n" +
            "mirrored brown bags contain 1 dotted tan bag, 4 dim olive bags, 1 bright lime bag.\n" +
            "dotted crimson bags contain 5 striped beige bags, 4 striped turquoise bags, 3 shiny fuchsia bags.\n" +
            "mirrored tan bags contain 5 bright indigo bags, 3 light violet bags.\n" +
            "striped black bags contain 4 striped olive bags.\n" +
            "faded fuchsia bags contain 3 faded teal bags, 4 dull salmon bags, 3 light red bags.\n" +
            "dull green bags contain 4 mirrored coral bags.\n" +
            "vibrant blue bags contain 1 striped gray bag, 4 striped olive bags, 3 wavy brown bags, 3 faded maroon bags.\n" +
            "vibrant plum bags contain 4 wavy brown bags, 5 clear violet bags, 3 pale turquoise bags, 2 posh crimson bags.\n" +
            "wavy fuchsia bags contain 5 wavy olive bags.\n" +
            "striped red bags contain 2 pale yellow bags, 3 pale chartreuse bags, 1 dim blue bag.\n" +
            "muted blue bags contain 2 posh red bags, 2 muted red bags, 3 dark tomato bags.\n" +
            "muted plum bags contain 4 plaid red bags.\n" +
            "clear violet bags contain 5 muted salmon bags.\n" +
            "pale white bags contain 3 plaid lavender bags, 5 mirrored green bags.\n" +
            "clear beige bags contain 2 vibrant blue bags, 5 muted white bags, 2 dull chartreuse bags.\n" +
            "vibrant fuchsia bags contain 4 posh gray bags, 5 dull tomato bags, 3 dim crimson bags.\n" +
            "dim indigo bags contain 1 bright black bag, 5 faded black bags, 5 dull turquoise bags, 2 mirrored lime bags.\n" +
            "dotted lime bags contain 3 light lime bags, 4 pale salmon bags, 4 dark aqua bags.\n" +
            "posh teal bags contain 3 pale gold bags, 2 faded silver bags.\n" +
            "faded gray bags contain 2 shiny gold bags, 1 dull turquoise bag, 1 faded chartreuse bag.\n" +
            "dim magenta bags contain 2 mirrored aqua bags, 5 wavy orange bags, 3 pale turquoise bags.\n" +
            "shiny fuchsia bags contain 5 vibrant silver bags.\n" +
            "drab teal bags contain 3 posh magenta bags, 2 striped indigo bags, 5 muted salmon bags, 4 shiny plum bags.\n" +
            "bright indigo bags contain 2 faded teal bags.\n" +
            "muted teal bags contain 4 mirrored green bags, 3 dull violet bags, 3 shiny purple bags.\n" +
            "light tan bags contain 1 muted salmon bag, 1 plaid olive bag, 2 plaid silver bags.\n" +
            "striped yellow bags contain 2 drab salmon bags, 2 faded aqua bags.\n" +
            "mirrored olive bags contain 5 clear maroon bags, 2 striped coral bags, 4 dim gold bags.\n" +
            "wavy cyan bags contain 3 plaid lavender bags, 1 wavy turquoise bag, 2 plaid bronze bags, 1 light beige bag.\n" +
            "mirrored red bags contain no other bags.\n" +
            "light yellow bags contain 3 dim purple bags, 4 posh green bags, 3 pale gold bags.\n" +
            "dotted gray bags contain 3 dotted orange bags, 5 plaid turquoise bags, 4 drab magenta bags.\n" +
            "faded red bags contain 3 bright aqua bags.\n" +
            "dull teal bags contain 4 clear purple bags, 5 faded turquoise bags.\n" +
            "light salmon bags contain 3 posh lime bags, 1 clear lime bag, 1 drab chartreuse bag, 3 clear magenta bags.\n" +
            "dark red bags contain 1 plaid tomato bag, 1 plaid orange bag, 4 dotted white bags.\n" +
            "mirrored beige bags contain 3 mirrored violet bags, 3 clear orange bags, 3 dark olive bags.\n" +
            "drab indigo bags contain 2 muted aqua bags, 3 bright teal bags.\n" +
            "light lime bags contain 4 light indigo bags, 5 plaid white bags.\n" +
            "pale blue bags contain 3 wavy tan bags, 1 mirrored tomato bag, 5 faded magenta bags, 2 posh crimson bags.\n" +
            "drab plum bags contain 2 striped crimson bags.\n" +
            "striped tomato bags contain 1 dark maroon bag.\n" +
            "faded maroon bags contain 3 drab salmon bags, 5 posh lime bags, 4 dim olive bags, 5 striped bronze bags.\n" +
            "clear fuchsia bags contain 5 vibrant silver bags, 5 posh lime bags, 4 striped crimson bags.\n" +
            "bright maroon bags contain 2 dull gray bags, 4 bright magenta bags, 5 clear beige bags, 5 vibrant silver bags.\n" +
            "clear blue bags contain 4 faded black bags, 2 plaid magenta bags, 1 clear salmon bag, 1 shiny chartreuse bag.\n" +
            "plaid chartreuse bags contain 1 dark bronze bag, 1 clear red bag, 2 mirrored plum bags, 4 posh white bags.\n" +
            "pale crimson bags contain 4 muted silver bags.\n" +
            "clear olive bags contain 3 dark olive bags, 5 drab plum bags, 2 striped maroon bags, 5 shiny purple bags.\n" +
            "vibrant indigo bags contain 1 vibrant silver bag, 5 dark olive bags, 1 striped chartreuse bag, 1 muted fuchsia bag.\n" +
            "dim coral bags contain 2 dark yellow bags, 3 clear orange bags, 2 clear cyan bags, 1 pale turquoise bag.\n" +
            "shiny white bags contain 3 drab teal bags, 3 vibrant blue bags.\n" +
            "vibrant tan bags contain 3 posh red bags, 1 faded black bag, 3 faded aqua bags, 2 light beige bags.\n" +
            "wavy plum bags contain 1 dotted teal bag, 3 dark indigo bags.\n" +
            "drab coral bags contain 3 clear orange bags, 4 shiny red bags, 5 bright teal bags.\n" +
            "mirrored aqua bags contain 3 mirrored cyan bags, 5 wavy coral bags.\n" +
            "vibrant gray bags contain 2 muted coral bags, 1 clear fuchsia bag.\n" +
            "faded turquoise bags contain 2 posh lime bags.\n" +
            "clear green bags contain 4 posh yellow bags, 3 light bronze bags, 4 drab gray bags, 3 bright teal bags.\n" +
            "wavy gold bags contain 3 faded black bags, 4 faded violet bags.\n" +
            "shiny tan bags contain 4 mirrored gray bags, 3 mirrored magenta bags, 5 light red bags.\n" +
            "plaid turquoise bags contain 5 faded aqua bags, 3 mirrored tomato bags, 5 light tan bags, 2 drab olive bags.\n" +
            "pale bronze bags contain 5 drab chartreuse bags, 4 faded lime bags.\n" +
            "mirrored lavender bags contain 3 plaid green bags, 1 clear salmon bag, 3 dim gray bags.\n" +
            "pale yellow bags contain 3 drab yellow bags, 5 drab green bags, 1 drab lavender bag, 1 clear magenta bag.\n" +
            "mirrored teal bags contain 5 posh black bags.\n" +
            "vibrant teal bags contain 1 dark teal bag.\n" +
            "bright gold bags contain 3 dark green bags, 4 clear orange bags, 1 shiny purple bag, 5 dull chartreuse bags.\n" +
            "muted lavender bags contain 5 faded fuchsia bags.\n" +
            "light gray bags contain 5 plaid magenta bags, 3 vibrant cyan bags, 3 bright gold bags, 2 dim cyan bags.\n" +
            "dark gray bags contain 3 posh silver bags, 1 dark fuchsia bag, 5 dark teal bags, 5 clear fuchsia bags.\n" +
            "mirrored gold bags contain 5 dim crimson bags, 2 plaid beige bags, 3 dark coral bags.\n" +
            "wavy violet bags contain 5 dull silver bags, 3 dark gold bags, 5 striped bronze bags.\n" +
            "vibrant cyan bags contain 2 bright indigo bags.\n" +
            "dull tan bags contain 2 shiny indigo bags, 2 dim gold bags, 5 vibrant blue bags, 4 dull tomato bags.\n" +
            "dim orange bags contain 5 posh silver bags, 3 light red bags.\n" +
            "drab gold bags contain 4 shiny indigo bags, 2 clear indigo bags, 1 faded fuchsia bag, 1 muted crimson bag.\n" +
            "vibrant bronze bags contain 3 mirrored green bags, 2 striped gold bags, 5 wavy coral bags.\n" +
            "light violet bags contain 3 dull turquoise bags, 5 light white bags, 2 drab coral bags.\n" +
            "plaid tomato bags contain 1 wavy tan bag, 2 faded maroon bags.\n" +
            "faded black bags contain 4 dark bronze bags.\n" +
            "drab violet bags contain 2 pale green bags, 5 muted olive bags.\n" +
            "dull lavender bags contain 5 light chartreuse bags, 5 striped fuchsia bags, 2 clear white bags, 5 dull indigo bags.\n" +
            "light chartreuse bags contain 5 dim lavender bags.\n" +
            "dim salmon bags contain 5 shiny silver bags, 4 dark coral bags, 2 vibrant cyan bags, 3 faded black bags.\n" +
            "posh blue bags contain 4 clear bronze bags, 5 shiny aqua bags, 1 vibrant brown bag.\n" +
            "light crimson bags contain 4 plaid aqua bags, 3 mirrored green bags.\n" +
            "striped plum bags contain 5 plaid white bags, 5 light beige bags.\n" +
            "shiny bronze bags contain 5 dark magenta bags.\n" +
            "dark fuchsia bags contain 5 posh crimson bags, 3 dark turquoise bags, 1 vibrant white bag.\n" +
            "striped coral bags contain 5 dim gray bags.\n" +
            "vibrant gold bags contain 5 dull tomato bags, 3 mirrored cyan bags, 2 light tan bags.\n" +
            "wavy tan bags contain 2 faded maroon bags, 4 wavy violet bags.\n" +
            "dotted violet bags contain 5 shiny blue bags.\n" +
            "faded bronze bags contain 3 shiny gold bags.\n" +
            "plaid tan bags contain 3 posh tan bags, 5 mirrored cyan bags, 1 drab lavender bag, 4 shiny blue bags.\n" +
            "plaid salmon bags contain 2 faded coral bags.\n" +
            "dark orange bags contain 3 light purple bags, 5 wavy blue bags, 2 muted crimson bags, 2 dull magenta bags.\n" +
            "wavy beige bags contain 1 muted silver bag, 5 bright yellow bags.\n" +
            "plaid cyan bags contain 4 dark orange bags, 5 dark plum bags, 5 dotted tomato bags, 5 striped magenta bags.\n" +
            "dark lavender bags contain 2 mirrored beige bags, 1 pale blue bag, 2 dull chartreuse bags, 5 mirrored black bags.\n" +
            "light black bags contain 1 dull tomato bag, 5 bright violet bags.\n" +
            "wavy silver bags contain 2 clear gold bags.\n" +
            "wavy maroon bags contain 2 posh tomato bags, 5 shiny maroon bags, 1 wavy yellow bag.\n" +
            "clear lavender bags contain 1 muted white bag, 5 striped chartreuse bags, 3 dark salmon bags, 1 plaid teal bag.\n" +
            "dotted brown bags contain 4 striped blue bags, 3 mirrored fuchsia bags, 3 posh red bags.\n" +
            "faded teal bags contain 4 plaid olive bags.\n" +
            "clear gray bags contain 2 mirrored fuchsia bags, 4 faded blue bags.\n" +
            "light tomato bags contain 5 wavy indigo bags, 2 posh beige bags.\n" +
            "muted black bags contain 1 dark lime bag, 1 striped green bag.\n" +
            "dotted beige bags contain 5 faded lavender bags, 3 plaid yellow bags.\n" +
            "posh turquoise bags contain 1 wavy indigo bag.\n" +
            "bright crimson bags contain 1 dark fuchsia bag.\n" +
            "striped teal bags contain 3 vibrant olive bags, 1 bright maroon bag, 3 muted teal bags, 4 clear yellow bags.\n" +
            "clear orange bags contain 3 shiny plum bags, 3 drab olive bags.\n" +
            "posh silver bags contain 5 mirrored violet bags, 2 dotted teal bags.\n" +
            "dim gray bags contain 4 pale teal bags, 5 muted salmon bags, 3 dark indigo bags.\n" +
            "dotted tomato bags contain 3 dotted maroon bags.\n" +
            "posh purple bags contain 3 drab turquoise bags, 3 dark olive bags, 4 posh lime bags, 1 posh orange bag.\n" +
            "vibrant beige bags contain 2 mirrored violet bags, 1 mirrored white bag, 1 wavy violet bag.\n" +
            "dark tan bags contain 5 bright violet bags, 5 light blue bags, 4 shiny plum bags, 1 light indigo bag.\n" +
            "dim lavender bags contain 3 mirrored green bags, 1 wavy tan bag, 2 striped crimson bags, 5 wavy violet bags.\n" +
            "faded crimson bags contain 3 muted yellow bags, 2 posh lime bags, 5 mirrored gray bags, 3 faded chartreuse bags.\n" +
            "posh coral bags contain 3 muted silver bags, 4 pale magenta bags, 1 light orange bag.\n" +
            "dull tomato bags contain 2 plaid tomato bags, 2 dim lavender bags, 4 mirrored orange bags, 3 clear fuchsia bags.\n" +
            "striped orange bags contain 2 vibrant teal bags, 1 dotted teal bag.\n" +
            "shiny maroon bags contain 5 light beige bags, 1 dim lime bag.\n" +
            "pale olive bags contain 2 mirrored gold bags, 4 plaid tomato bags.\n" +
            "light olive bags contain 1 light red bag, 1 light crimson bag, 2 striped chartreuse bags.\n" +
            "posh plum bags contain 5 bright silver bags, 4 vibrant indigo bags, 4 pale turquoise bags.\n" +
            "shiny orange bags contain 4 dim chartreuse bags, 2 dotted lavender bags, 2 shiny green bags.\n" +
            "pale indigo bags contain 3 mirrored chartreuse bags, 5 mirrored violet bags, 2 vibrant blue bags, 3 mirrored maroon bags.\n" +
            "posh tan bags contain 5 shiny plum bags, 2 dark aqua bags.\n" +
            "bright blue bags contain 5 vibrant salmon bags, 5 bright maroon bags, 1 muted yellow bag.\n" +
            "clear maroon bags contain 4 vibrant beige bags, 3 mirrored gold bags, 2 drab teal bags, 2 drab plum bags.\n" +
            "wavy chartreuse bags contain 3 clear olive bags, 1 drab lavender bag.\n" +
            "drab gray bags contain 5 plaid salmon bags.\n" +
            "faded orange bags contain 1 faded maroon bag, 5 vibrant orange bags.\n" +
            "bright coral bags contain 3 pale turquoise bags.\n" +
            "light beige bags contain 1 muted cyan bag.\n" +
            "plaid maroon bags contain 5 faded magenta bags, 4 faded bronze bags.\n" +
            "dotted purple bags contain 1 drab plum bag, 5 faded black bags, 2 dull silver bags.\n" +
            "muted salmon bags contain no other bags.\n" +
            "striped blue bags contain 5 mirrored lime bags, 2 dark plum bags.\n" +
            "dotted lavender bags contain 2 faded salmon bags, 3 dim silver bags, 1 clear cyan bag, 4 plaid lavender bags.\n" +
            "wavy black bags contain 4 vibrant gold bags, 5 light black bags, 4 muted aqua bags, 5 vibrant white bags.\n" +
            "clear aqua bags contain 3 plaid beige bags, 1 plaid white bag, 3 shiny red bags, 3 wavy crimson bags.\n" +
            "mirrored cyan bags contain no other bags.\n" +
            "shiny brown bags contain 2 dim aqua bags.\n" +
            "dotted green bags contain 4 mirrored green bags, 3 mirrored tomato bags, 5 plaid gray bags.\n" +
            "striped purple bags contain 3 wavy yellow bags, 2 faded orange bags.\n" +
            "plaid indigo bags contain 2 shiny plum bags, 5 bright magenta bags, 2 posh yellow bags, 3 shiny gold bags.\n" +
            "posh chartreuse bags contain 2 mirrored cyan bags, 4 drab salmon bags, 4 dim olive bags, 2 posh lime bags.\n" +
            "light lavender bags contain 4 dim fuchsia bags, 5 pale salmon bags, 4 clear teal bags.\n" +
            "shiny crimson bags contain 5 light blue bags.\n" +
            "plaid black bags contain 5 clear indigo bags, 5 mirrored purple bags, 1 light aqua bag.\n" +
            "shiny lime bags contain 5 dotted blue bags, 2 shiny tan bags.\n" +
            "dotted salmon bags contain 4 pale salmon bags, 1 clear maroon bag.\n" +
            "vibrant lavender bags contain 4 shiny red bags, 4 shiny green bags, 5 dim silver bags.\n" +
            "muted yellow bags contain 5 wavy aqua bags, 2 posh lavender bags, 3 dull magenta bags, 1 plaid red bag.\n" +
            "faded beige bags contain 1 wavy violet bag, 4 plaid maroon bags.\n" +
            "wavy blue bags contain 5 dotted orange bags, 1 faded chartreuse bag, 4 posh magenta bags.\n" +
            "faded brown bags contain 4 bright coral bags, 3 mirrored aqua bags.\n" +
            "striped lavender bags contain 5 dim brown bags, 2 wavy cyan bags, 4 pale blue bags, 1 posh olive bag.\n" +
            "bright fuchsia bags contain 5 clear lime bags.\n" +
            "bright black bags contain 5 clear fuchsia bags, 4 pale purple bags.\n" +
            "pale orange bags contain 3 plaid aqua bags, 5 muted fuchsia bags, 1 wavy crimson bag.\n" +
            "mirrored magenta bags contain 2 posh chartreuse bags, 2 muted white bags, 5 posh lime bags, 5 dark gold bags.\n" +
            "light magenta bags contain 1 mirrored white bag, 1 dull silver bag, 5 posh chartreuse bags.\n" +
            "striped gold bags contain 1 mirrored cyan bag, 1 dark olive bag, 4 mirrored red bags, 5 posh chartreuse bags.\n" +
            "plaid lavender bags contain 1 vibrant white bag, 4 dotted maroon bags.\n" +
            "faded gold bags contain 5 striped crimson bags.\n" +
            "vibrant olive bags contain 1 plaid beige bag.\n" +
            "dark aqua bags contain 4 plaid tomato bags, 1 striped olive bag, 4 pale fuchsia bags, 3 dim gold bags.\n" +
            "dim lime bags contain 2 plaid gray bags.\n" +
            "pale lavender bags contain 4 muted yellow bags, 1 drab yellow bag, 2 dull cyan bags, 2 muted teal bags.\n" +
            "bright violet bags contain 2 posh lime bags, 1 wavy violet bag, 2 mirrored red bags.\n" +
            "dotted maroon bags contain 1 drab salmon bag.\n" +
            "clear magenta bags contain 3 mirrored brown bags.\n" +
            "vibrant red bags contain 5 clear cyan bags, 2 dark teal bags.\n" +
            "shiny olive bags contain 5 light tan bags, 5 plaid maroon bags, 3 mirrored blue bags.\n" +
            "plaid fuchsia bags contain 5 posh silver bags.\n" +
            "vibrant chartreuse bags contain 2 clear coral bags, 2 pale purple bags, 5 light beige bags.\n" +
            "vibrant violet bags contain 3 striped bronze bags, 2 drab tomato bags, 2 faded violet bags, 5 posh crimson bags.\n" +
            "vibrant white bags contain 1 plaid orange bag, 5 muted aqua bags, 5 pale fuchsia bags, 3 muted fuchsia bags.\n" +
            "drab magenta bags contain 3 bright indigo bags, 1 faded violet bag.\n" +
            "faded tan bags contain 3 dark crimson bags, 5 light aqua bags.\n" +
            "bright salmon bags contain 3 clear plum bags, 3 striped blue bags, 5 plaid green bags.\n" +
            "wavy aqua bags contain 1 clear beige bag, 5 dull magenta bags.\n" +
            "muted white bags contain 5 wavy tan bags, 5 plaid silver bags, 5 striped bronze bags, 3 dull silver bags.\n" +
            "mirrored gray bags contain 4 dim olive bags, 3 striped gold bags, 1 wavy tan bag, 5 striped bronze bags.\n" +
            "vibrant maroon bags contain 5 clear bronze bags.\n" +
            "shiny violet bags contain 2 clear salmon bags, 1 bright beige bag.\n" +
            "dim bronze bags contain 2 posh brown bags, 4 vibrant indigo bags, 2 dull purple bags.\n" +
            "bright bronze bags contain 1 bright maroon bag, 4 faded aqua bags, 2 pale tan bags, 3 mirrored lavender bags.\n" +
            "dull blue bags contain 4 clear coral bags, 2 drab olive bags.\n" +
            "posh crimson bags contain 1 muted white bag, 2 faded maroon bags, 5 plaid olive bags.\n" +
            "dark olive bags contain 3 dim olive bags, 3 mirrored red bags.\n" +
            "striped violet bags contain 4 wavy gold bags, 4 dotted maroon bags, 1 vibrant salmon bag.\n" +
            "vibrant tomato bags contain 1 striped gold bag, 1 faded turquoise bag.\n" +
            "mirrored turquoise bags contain 2 dark magenta bags, 2 clear lime bags, 3 dull turquoise bags.\n" +
            "mirrored coral bags contain 4 plaid lavender bags, 4 vibrant salmon bags, 4 mirrored chartreuse bags, 3 plaid white bags.\n" +
            "muted red bags contain 2 mirrored maroon bags, 4 vibrant beige bags.\n" +
            "shiny salmon bags contain 2 posh black bags, 4 wavy tan bags.\n" +
            "vibrant turquoise bags contain 4 clear crimson bags.\n" +
            "pale maroon bags contain 4 striped crimson bags, 5 wavy indigo bags, 3 dull turquoise bags, 2 faded black bags.\n" +
            "dull beige bags contain 4 dim olive bags, 3 vibrant olive bags, 1 mirrored plum bag, 3 muted white bags.\n" +
            "striped tan bags contain 5 mirrored gray bags.\n" +
            "dotted magenta bags contain 4 wavy olive bags, 5 mirrored magenta bags, 4 muted fuchsia bags, 2 muted gray bags.\n" +
            "pale chartreuse bags contain 1 wavy crimson bag.\n" +
            "dull white bags contain 1 dull tomato bag, 4 faded tomato bags, 3 shiny fuchsia bags, 4 dim beige bags.\n" +
            "light cyan bags contain 3 drab plum bags, 1 wavy violet bag, 1 vibrant gold bag, 1 dotted purple bag.\n" +
            "bright tomato bags contain 1 bright plum bag.\n" +
            "bright olive bags contain 1 dull green bag.\n" +
            "shiny tomato bags contain 3 faded red bags, 3 mirrored gold bags.\n" +
            "light white bags contain 2 dotted gray bags.\n" +
            "dotted bronze bags contain 3 wavy olive bags.\n" +
            "drab white bags contain 4 dim fuchsia bags.\n" +
            "posh indigo bags contain 2 dull salmon bags, 4 mirrored white bags.\n" +
            "vibrant coral bags contain 2 faded chartreuse bags, 3 dark indigo bags, 1 wavy coral bag.\n" +
            "bright purple bags contain 4 dull white bags.\n" +
            "faded blue bags contain 1 striped chartreuse bag, 2 faded crimson bags.\n" +
            "striped turquoise bags contain 5 dark plum bags.\n" +
            "faded green bags contain 1 mirrored white bag, 1 striped magenta bag.\n" +
            "dotted indigo bags contain 5 pale olive bags, 5 vibrant fuchsia bags.\n" +
            "drab blue bags contain 2 faded tomato bags.\n" +
            "dull lime bags contain 4 faded crimson bags, 1 striped white bag, 3 drab bronze bags.\n" +
            "bright yellow bags contain 5 drab purple bags, 2 mirrored white bags, 4 faded fuchsia bags, 2 dark tomato bags.\n" +
            "clear turquoise bags contain 3 muted fuchsia bags, 3 plaid purple bags, 4 posh blue bags.\n" +
            "dull crimson bags contain 5 muted green bags, 3 dotted bronze bags, 2 pale gray bags.\n" +
            "light maroon bags contain 5 faded indigo bags, 1 clear yellow bag.\n" +
            "wavy magenta bags contain 3 bright orange bags, 2 pale lavender bags, 1 shiny blue bag, 1 plaid purple bag.\n" +
            "vibrant aqua bags contain 2 vibrant silver bags.\n" +
            "posh black bags contain 3 striped crimson bags.\n" +
            "bright white bags contain 2 clear white bags.\n" +
            "clear bronze bags contain 2 dim aqua bags, 1 mirrored indigo bag.\n" +
            "vibrant yellow bags contain 2 vibrant silver bags.\n" +
            "bright silver bags contain 3 clear beige bags, 3 mirrored lime bags.\n" +
            "plaid magenta bags contain 5 striped gold bags, 5 posh purple bags, 2 pale brown bags.\n" +
            "shiny black bags contain 2 posh beige bags, 4 posh magenta bags, 4 dim blue bags, 4 dark bronze bags.\n" +
            "shiny yellow bags contain 2 wavy turquoise bags, 2 pale purple bags.\n" +
            "plaid aqua bags contain 3 shiny fuchsia bags, 1 dull tomato bag, 2 light magenta bags, 3 mirrored green bags.\n" +
            "wavy bronze bags contain 2 bright gold bags, 5 plaid green bags, 1 shiny violet bag, 1 faded chartreuse bag.\n" +
            "mirrored purple bags contain 2 faded tomato bags, 1 dark gold bag, 4 dim aqua bags, 1 faded aqua bag.\n" +
            "muted tan bags contain 3 pale teal bags, 3 drab tomato bags, 4 pale maroon bags, 1 dim cyan bag.\n" +
            "plaid blue bags contain 2 muted coral bags, 5 striped maroon bags, 3 pale plum bags, 5 dotted purple bags.\n" +
            "posh gray bags contain 5 muted salmon bags, 2 wavy orange bags.\n" +
            "wavy orange bags contain 5 dark aqua bags.\n" +
            "bright brown bags contain 3 muted yellow bags, 5 faded lavender bags, 2 drab cyan bags, 2 mirrored indigo bags.\n" +
            "dark brown bags contain 3 plaid coral bags.\n" +
            "bright beige bags contain 4 vibrant indigo bags, 5 bright lime bags, 5 bright magenta bags.\n" +
            "clear tan bags contain 3 dark turquoise bags, 4 vibrant cyan bags.\n" +
            "light brown bags contain 3 light lime bags.\n" +
            "wavy red bags contain 5 wavy cyan bags, 4 plaid bronze bags, 3 dark chartreuse bags.\n" +
            "faded olive bags contain 1 wavy green bag, 3 drab olive bags.\n" +
            "vibrant lime bags contain 5 vibrant silver bags, 2 light silver bags.\n" +
            "faded plum bags contain 3 clear lavender bags, 1 dotted lavender bag, 5 muted silver bags, 3 plaid purple bags.\n" +
            "dark violet bags contain 2 vibrant beige bags, 3 light crimson bags.\n" +
            "posh lime bags contain no other bags.\n" +
            "dark magenta bags contain 2 muted cyan bags.\n" +
            "striped white bags contain 5 light tan bags, 3 plaid orange bags, 1 dark gold bag, 4 mirrored white bags.\n" +
            "dull cyan bags contain 1 muted red bag, 5 faded lavender bags, 5 plaid gold bags, 5 dark beige bags.\n" +
            "mirrored white bags contain 2 dark olive bags, 4 striped bronze bags.\n" +
            "light plum bags contain 3 wavy crimson bags.\n" +
            "clear red bags contain 4 faded violet bags, 3 dotted tan bags, 1 pale indigo bag, 4 vibrant brown bags.\n" +
            "muted maroon bags contain 3 bright indigo bags, 1 striped magenta bag.\n" +
            "dull chartreuse bags contain 4 posh orange bags.\n" +
            "muted green bags contain 2 vibrant orange bags, 3 dull red bags.\n" +
            "muted coral bags contain 1 dark olive bag, 4 striped bronze bags.\n" +
            "drab brown bags contain 3 shiny maroon bags.\n" +
            "pale teal bags contain 2 faded aqua bags, 4 mirrored magenta bags, 2 plaid red bags, 1 dark coral bag.\n" +
            "dull purple bags contain 2 dotted teal bags, 3 vibrant orange bags.\n" +
            "mirrored maroon bags contain 3 light purple bags, 4 posh beige bags, 1 dim gold bag, 4 striped olive bags.\n" +
            "dull salmon bags contain 3 mirrored red bags.\n" +
            "posh maroon bags contain 3 dark bronze bags, 2 faded lavender bags, 3 plaid red bags.\n" +
            "shiny teal bags contain 1 dotted purple bag, 5 dull black bags, 1 muted purple bag.\n" +
            "dotted olive bags contain 1 wavy aqua bag, 2 clear indigo bags, 2 light coral bags, 1 plaid yellow bag.\n" +
            "drab silver bags contain 2 wavy coral bags, 1 light purple bag, 4 shiny fuchsia bags.\n" +
            "posh lavender bags contain 3 shiny plum bags, 5 wavy coral bags, 2 mirrored green bags.\n" +
            "dark silver bags contain 2 vibrant blue bags, 2 dull crimson bags.\n" +
            "clear indigo bags contain 3 plaid aqua bags, 4 posh orange bags.\n" +
            "plaid purple bags contain 3 vibrant gold bags, 4 wavy fuchsia bags, 2 striped maroon bags, 2 wavy coral bags.\n" +
            "dull gray bags contain 4 striped maroon bags, 1 striped gold bag, 4 vibrant salmon bags, 3 shiny fuchsia bags.\n" +
            "dim maroon bags contain 4 shiny beige bags.\n" +
            "plaid lime bags contain 4 bright lime bags, 5 vibrant tan bags.\n" +
            "faded lime bags contain 3 dotted crimson bags, 2 wavy violet bags.\n" +
            "pale coral bags contain 5 wavy blue bags.\n" +
            "plaid crimson bags contain 2 dull black bags, 3 striped gold bags, 5 dim beige bags, 1 mirrored purple bag.\n" +
            "dark beige bags contain 4 vibrant salmon bags, 2 drab plum bags, 5 dull chartreuse bags, 4 light crimson bags.\n" +
            "clear crimson bags contain 2 shiny fuchsia bags, 5 faded chartreuse bags.\n" +
            "dull orange bags contain 5 plaid bronze bags, 5 faded cyan bags, 3 dotted silver bags, 5 dim purple bags.\n" +
            "dotted black bags contain 2 bright green bags, 5 bright tomato bags, 1 pale magenta bag.\n" +
            "dull coral bags contain 2 dark beige bags, 5 striped gold bags.\n" +
            "vibrant salmon bags contain 5 striped indigo bags, 2 plaid olive bags, 2 drab plum bags.\n" +
            "dim blue bags contain 2 mirrored orange bags.\n" +
            "dim black bags contain 2 light chartreuse bags, 1 wavy fuchsia bag.\n" +
            "dark white bags contain 4 mirrored maroon bags, 2 dim lavender bags, 5 faded yellow bags, 3 dark silver bags.\n" +
            "drab olive bags contain 2 muted white bags, 1 mirrored white bag, 4 striped crimson bags, 4 faded maroon bags.\n" +
            "striped brown bags contain 1 dull fuchsia bag, 1 plaid crimson bag.\n" +
            "clear tomato bags contain 5 drab chartreuse bags.\n" +
            "muted bronze bags contain 3 light magenta bags, 4 clear yellow bags, 5 bright tomato bags.\n" +
            "posh olive bags contain 3 dotted gold bags.\n" +
            "dull maroon bags contain 4 plaid beige bags, 5 drab silver bags, 3 drab lime bags, 5 dull magenta bags.\n" +
            "drab cyan bags contain 3 striped magenta bags, 1 vibrant bronze bag, 2 mirrored green bags, 3 plaid silver bags.\n" +
            "posh magenta bags contain 1 striped chartreuse bag, 4 vibrant silver bags.\n" +
            "muted violet bags contain 4 dark gold bags, 1 posh purple bag, 3 clear purple bags, 4 bright teal bags.\n" +
            "muted silver bags contain 2 bright chartreuse bags, 1 clear chartreuse bag.\n" +
            "wavy coral bags contain 5 mirrored red bags, 1 striped gold bag, 5 faded maroon bags, 1 dark olive bag.\n" +
            "dark green bags contain 3 shiny gold bags.\n" +
            "drab beige bags contain 4 vibrant crimson bags, 4 posh silver bags.\n" +
            "plaid gray bags contain 2 wavy blue bags, 5 dim coral bags.\n" +
            "plaid orange bags contain 3 mirrored orange bags, 1 dark olive bag, 1 light red bag, 2 striped gold bags.\n" +
            "dull silver bags contain no other bags.\n" +
            "shiny lavender bags contain 3 dotted yellow bags, 1 wavy indigo bag, 1 dark coral bag.\n" +
            "dim brown bags contain 4 dim blue bags, 1 drab plum bag.\n" +
            "posh salmon bags contain 3 dim blue bags.\n" +
            "drab orange bags contain 1 faded bronze bag, 5 dull black bags.\n" +
            "wavy crimson bags contain 1 drab salmon bag, 2 vibrant salmon bags.\n" +
            "dull black bags contain 5 vibrant orange bags.\n" +
            "clear teal bags contain 5 faded aqua bags, 1 plaid crimson bag, 1 posh silver bag.\n" +
            "wavy olive bags contain 3 faded aqua bags, 3 faded fuchsia bags, 2 drab cyan bags.\n" +
            "bright gray bags contain 4 clear coral bags, 2 clear white bags, 3 faded lavender bags, 4 dark turquoise bags.\n" +
            "striped green bags contain 1 faded magenta bag, 1 wavy tan bag, 4 posh red bags, 1 striped bronze bag.\n" +
            "clear salmon bags contain 2 striped green bags, 1 striped aqua bag, 3 muted white bags, 3 pale plum bags.\n" +
            "wavy indigo bags contain 2 vibrant orange bags, 1 shiny indigo bag, 1 drab tomato bag.\n" +
            "clear brown bags contain 3 muted maroon bags, 4 dotted silver bags.\n" +
            "vibrant silver bags contain 4 wavy violet bags, 2 posh chartreuse bags.\n" +
            "mirrored salmon bags contain 4 bright brown bags, 3 mirrored crimson bags, 1 mirrored aqua bag.\n" +
            "faded white bags contain 1 wavy crimson bag, 3 drab silver bags, 5 striped yellow bags, 3 dotted olive bags.\n" +
            "muted indigo bags contain 1 wavy indigo bag.\n" +
            "drab aqua bags contain 5 dotted teal bags, 4 mirrored white bags.\n" +
            "posh red bags contain 5 wavy crimson bags.\n" +
            "dim turquoise bags contain 1 striped turquoise bag, 4 dotted crimson bags.\n" +
            "dark yellow bags contain 1 drab olive bag, 3 muted aqua bags.\n" +
            "pale red bags contain 2 vibrant gray bags.\n" +
            "vibrant black bags contain 1 posh gray bag, 5 pale teal bags, 5 shiny red bags.\n" +
            "pale purple bags contain 5 dim olive bags.\n" +
            "dim tomato bags contain 3 plaid lavender bags.\n" +
            "dim yellow bags contain 4 plaid brown bags.\n" +
            "plaid silver bags contain no other bags.\n" +
            "plaid white bags contain 2 muted purple bags, 5 dull black bags.\n" +
            "muted magenta bags contain 2 plaid gray bags, 5 wavy salmon bags, 3 dark chartreuse bags.\n" +
            "bright aqua bags contain 1 dark indigo bag, 1 faded gray bag, 5 vibrant white bags, 2 vibrant gold bags.\n" +
            "drab crimson bags contain 2 clear orange bags.\n" +
            "wavy purple bags contain 2 vibrant plum bags, 3 dark fuchsia bags, 2 pale salmon bags.\n" +
            "wavy teal bags contain 1 drab salmon bag, 4 muted indigo bags, 5 bright violet bags, 5 muted bronze bags.\n" +
            "pale salmon bags contain 5 mirrored blue bags, 4 mirrored maroon bags.\n" +
            "faded lavender bags contain 2 muted blue bags, 4 striped blue bags, 3 pale brown bags, 2 pale purple bags.\n" +
            "dull plum bags contain 5 clear coral bags.\n" +
            "drab maroon bags contain 2 plaid bronze bags, 1 bright orange bag.\n" +
            "light turquoise bags contain 4 striped teal bags, 4 posh indigo bags.\n" +
            "dotted orange bags contain 2 wavy violet bags.\n" +
            "bright teal bags contain 4 clear indigo bags, 1 vibrant violet bag.\n" +
            "mirrored fuchsia bags contain 4 muted brown bags, 5 wavy coral bags, 2 wavy turquoise bags.\n" +
            "dark indigo bags contain 1 light red bag, 4 vibrant lime bags, 2 drab teal bags.\n" +
            "plaid brown bags contain 2 dull gray bags, 3 mirrored magenta bags.\n" +
            "wavy yellow bags contain 4 dotted brown bags.\n" +
            "light orange bags contain 4 shiny black bags.\n" +
            "dark cyan bags contain 3 mirrored chartreuse bags, 4 pale magenta bags, 2 dull black bags, 2 posh lime bags.\n" +
            "muted chartreuse bags contain 3 dull silver bags, 1 dark aqua bag, 2 light tomato bags.\n" +
            "dull red bags contain 5 mirrored orange bags, 2 plaid yellow bags.\n" +
            "dotted cyan bags contain 1 vibrant fuchsia bag, 5 drab olive bags, 4 clear chartreuse bags, 5 pale beige bags.\n" +
            "dim beige bags contain 2 striped yellow bags, 3 bright cyan bags.\n" +
            "dull magenta bags contain 4 faded black bags.\n" +
            "dotted blue bags contain 2 posh maroon bags, 5 dark gold bags.\n" +
            "muted olive bags contain 1 mirrored aqua bag, 4 dull black bags, 5 clear gold bags, 1 mirrored cyan bag.\n" +
            "mirrored silver bags contain 2 bright blue bags, 4 shiny orange bags.\n" +
            "muted brown bags contain 5 muted white bags, 4 clear violet bags, 3 light red bags.\n" +
            "muted lime bags contain 2 plaid yellow bags, 2 pale chartreuse bags, 2 muted tomato bags.\n" +
            "clear silver bags contain 2 clear purple bags, 2 light tomato bags, 4 light gray bags, 1 shiny crimson bag.\n" +
            "dim tan bags contain 2 dull brown bags, 1 dull tomato bag, 2 dim salmon bags, 1 dull green bag.\n" +
            "shiny cyan bags contain 5 plaid turquoise bags.\n" +
            "faded indigo bags contain 4 drab plum bags, 4 clear maroon bags, 5 wavy cyan bags, 4 dim crimson bags.\n" +
            "posh bronze bags contain 5 mirrored olive bags.\n" +
            "posh aqua bags contain 3 dull violet bags, 5 bright silver bags, 1 drab coral bag, 5 shiny orange bags.\n" +
            "dark blue bags contain 5 light silver bags, 1 posh magenta bag, 3 mirrored crimson bags, 4 pale chartreuse bags.\n" +
            "dim crimson bags contain 1 faded gray bag, 3 dull turquoise bags.\n" +
            "dark coral bags contain 3 bright violet bags, 3 mirrored violet bags.\n" +
            "pale green bags contain 2 muted white bags, 5 bright lime bags, 4 dark indigo bags, 2 faded fuchsia bags.\n" +
            "shiny silver bags contain 4 bright teal bags, 1 dim gold bag.\n" +
            "light fuchsia bags contain 1 dull white bag, 1 striped indigo bag, 2 light orange bags.\n" +
            "vibrant crimson bags contain 4 striped maroon bags, 5 dim white bags.\n" +
            "clear yellow bags contain 5 bright green bags.\n" +
            "striped aqua bags contain 4 mirrored beige bags, 4 clear beige bags.\n" +
            "dark chartreuse bags contain 3 bright lime bags, 3 mirrored magenta bags.\n" +
            "wavy turquoise bags contain 4 bright brown bags, 5 mirrored lime bags, 3 pale white bags, 3 drab salmon bags.\n" +
            "faded tomato bags contain 2 clear indigo bags, 3 faded teal bags, 4 dark teal bags.\n" +
            "dull indigo bags contain 5 vibrant indigo bags, 1 mirrored purple bag, 1 vibrant tan bag, 2 shiny plum bags.\n" +
            "posh yellow bags contain 5 clear cyan bags, 3 mirrored red bags, 5 mirrored magenta bags.\n" +
            "plaid yellow bags contain 3 vibrant gold bags, 4 posh crimson bags, 3 mirrored green bags.\n" +
            "plaid olive bags contain 3 vibrant indigo bags, 3 posh indigo bags, 1 posh magenta bag, 5 dim olive bags.\n" +
            "bright cyan bags contain 2 vibrant brown bags, 2 muted red bags.\n" +
            "clear chartreuse bags contain 2 muted salmon bags, 1 plaid aqua bag.\n" +
            "shiny plum bags contain 5 mirrored gray bags, 2 dotted maroon bags.\n" +
            "dim teal bags contain 3 dotted tan bags, 4 faded aqua bags, 2 light teal bags.\n" +
            "mirrored bronze bags contain 3 wavy plum bags, 5 dotted tan bags.\n" +
            "muted turquoise bags contain 2 mirrored silver bags, 2 dotted yellow bags.\n" +
            "clear gold bags contain 4 plaid olive bags.\n" +
            "mirrored orange bags contain 5 mirrored cyan bags, 2 faded maroon bags, 2 bright violet bags.\n" +
            "striped chartreuse bags contain 3 dark gold bags, 2 pale fuchsia bags.\n" +
            "dull turquoise bags contain 5 faded black bags.\n" +
            "bright chartreuse bags contain 1 drab turquoise bag.\n" +
            "vibrant green bags contain 3 wavy plum bags, 1 shiny fuchsia bag, 3 dark yellow bags, 1 dotted lime bag.\n" +
            "mirrored black bags contain 4 plaid red bags, 2 wavy brown bags.\n" +
            "striped magenta bags contain 3 dim lavender bags.\n" +
            "shiny gold bags contain 3 clear fuchsia bags, 2 vibrant indigo bags, 4 dotted maroon bags.\n" +
            "posh fuchsia bags contain 3 dull silver bags, 3 mirrored lime bags, 2 dull black bags.\n" +
            "bright magenta bags contain 5 clear violet bags, 1 light red bag, 1 mirrored white bag.\n" +
            "mirrored tomato bags contain 1 dark olive bag, 5 faded maroon bags.\n" +
            "wavy gray bags contain 5 dotted orange bags, 3 muted magenta bags, 2 plaid maroon bags, 4 drab tomato bags.\n" +
            "dim plum bags contain 4 dim salmon bags, 4 light cyan bags, 3 wavy coral bags.\n" +
            "shiny chartreuse bags contain 2 drab plum bags, 2 pale beige bags.\n" +
            "striped gray bags contain 4 muted aqua bags.\n" +
            "faded cyan bags contain 2 muted coral bags.\n" +
            "clear coral bags contain 5 faded white bags, 5 dull coral bags.\n" +
            "dim violet bags contain 2 dark tomato bags, 3 vibrant silver bags, 2 clear maroon bags.\n" +
            "wavy tomato bags contain 1 striped orange bag, 2 posh magenta bags.\n" +
            "drab chartreuse bags contain 4 posh crimson bags, 3 wavy brown bags.\n" +
            "dotted plum bags contain 4 posh crimson bags, 3 dull magenta bags.\n" +
            "striped crimson bags contain 1 wavy coral bag.\n" +
            "faded yellow bags contain 2 faded gray bags.\n" +
            "faded magenta bags contain 4 dotted yellow bags.\n" +
            "bright orange bags contain 5 dark plum bags, 3 plaid white bags, 3 bright chartreuse bags.\n" +
            "drab red bags contain 4 vibrant cyan bags.\n" +
            "wavy white bags contain 4 mirrored lavender bags, 3 muted tomato bags, 3 faded tomato bags, 5 drab cyan bags.\n" +
            "striped salmon bags contain 5 dotted silver bags.\n" +
            "mirrored violet bags contain 3 plaid silver bags, 1 dotted maroon bag, 5 striped gray bags.\n" +
            "pale fuchsia bags contain 2 dark gold bags.\n" +
            "striped silver bags contain 1 faded cyan bag, 2 muted orange bags.\n" +
            "dull brown bags contain 5 dotted chartreuse bags, 4 vibrant red bags, 2 plaid purple bags, 4 shiny fuchsia bags.\n" +
            "dull gold bags contain 1 dull olive bag, 1 clear coral bag, 4 light tomato bags, 4 muted yellow bags.\n" +
            "plaid green bags contain 5 dark bronze bags, 1 muted aqua bag, 4 plaid aqua bags.\n" +
            "dim white bags contain 4 bright red bags, 2 striped teal bags, 2 posh crimson bags.\n" +
            "drab salmon bags contain no other bags.\n" +
            "dull fuchsia bags contain 5 clear crimson bags, 1 pale green bag, 3 vibrant coral bags, 3 plaid salmon bags.\n" +
            "pale lime bags contain 1 plaid magenta bag.\n" +
            "wavy lavender bags contain 4 faded magenta bags, 3 dark yellow bags, 5 plaid aqua bags.\n" +
            "shiny gray bags contain 4 dark teal bags, 1 wavy crimson bag, 4 posh lime bags.\n" +
            "dull bronze bags contain 5 drab tomato bags, 4 pale tan bags.\n" +
            "dotted chartreuse bags contain 2 dark maroon bags, 4 mirrored black bags, 4 light orange bags.\n" +
            "dotted aqua bags contain 2 mirrored maroon bags, 2 mirrored blue bags, 3 dark cyan bags, 4 dotted olive bags.\n" +
            "striped indigo bags contain 4 mirrored gray bags, 5 light tan bags, 4 dotted tan bags.\n" +
            "shiny magenta bags contain 5 dim chartreuse bags, 2 striped olive bags, 5 clear blue bags.\n" +
            "bright lime bags contain 4 drab cyan bags, 4 striped chartreuse bags, 1 dotted yellow bag.\n" +
            "dotted white bags contain 1 clear purple bag, 1 clear teal bag, 1 dotted cyan bag.\n" +
            "dotted red bags contain 3 dark silver bags.\n" +
            "dotted fuchsia bags contain 1 pale orange bag.\n" +
            "pale aqua bags contain 1 dim beige bag, 2 shiny aqua bags, 1 faded gray bag.\n" +
            "dotted tan bags contain 3 muted coral bags, 1 shiny fuchsia bag, 5 wavy tan bags.\n" +
            "light bronze bags contain 1 drab lavender bag, 5 faded red bags, 3 light tan bags, 1 striped white bag.\n" +
            "dim cyan bags contain 1 vibrant brown bag, 3 faded gray bags, 5 striped lime bags, 5 plaid beige bags.\n" +
            "dim silver bags contain 2 striped gray bags, 3 plaid gold bags, 5 striped orange bags.\n" +
            "shiny aqua bags contain 3 dotted tan bags, 4 muted brown bags, 1 mirrored maroon bag.\n" +
            "drab tan bags contain 4 muted brown bags, 1 dotted lavender bag, 2 dull coral bags.\n" +
            "shiny beige bags contain 2 muted blue bags, 3 wavy turquoise bags, 5 plaid silver bags.\n" +
            "muted aqua bags contain 2 mirrored orange bags.\n" +
            "striped beige bags contain 3 muted coral bags, 4 dim gold bags, 1 dim beige bag.\n" +
            "light teal bags contain 3 faded green bags, 5 dark indigo bags, 1 pale gold bag.\n";

    public static void main(String[] args) {
        List<String> rules = Arrays.asList(INPUT.split("\n").clone());
        Map<String, List<String>> mappings = new HashMap<>();
        for (String rule : rules) {
            String firstBag = getFirstBag(rule);
            List<String> otherBags = getOtherBags(rule);
            for (String otherBag : otherBags) {
                if (mappings.containsKey(otherBag)) {
                    mappings.get(otherBag).add(firstBag);
                } else {
                    List<String> bags = new ArrayList<>();
                    bags.add(firstBag);
                    mappings.put(otherBag, bags);
                }
            }
        }
        for (String key : mappings.keySet()) {
            System.out.println(key + " " + mappings.get(key));
        }
        int res = search(mappings, mappings.get("shiny gold"));
        System.out.println(res);
    }

    private static Set<String> seen = new HashSet<>();
    public static int search(Map<String, List<String>> mappings, List<String> next) {
        if (next == null)
            return 0;
        int cnt = 0;
        for (String n : next) {
            if (seen.add(n))
                cnt++;
            cnt += search(mappings, mappings.get(n));
        }
        return cnt;
    }

    private static String getFirstBag(String rule) {
        String[] parts = rule.split(" ");
        return parts[0] + " " + parts[1];
    }

    private static List<String> getOtherBags(String rule) {
        List<String> others = new ArrayList<>();
        String[] parts = rule.split(", ");
        if (!parts[0].endsWith("contain no other bags.")) {
            String[] p2 = parts[0].split(" ");
            others.add(p2[5] + " " + p2[6]);
            for (int i = 1; i < parts.length; i++) {
                String[] p3 = parts[i].split(" ");
                others.add(p3[1] + " " + p3[2]);
            }
        }
        return others;
    }
}
