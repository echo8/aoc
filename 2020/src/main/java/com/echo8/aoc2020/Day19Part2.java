package com.echo8.aoc2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day19Part2 {
    private static final String INPUT = "108: 117 50 | 63 64\n" +
            "124: 50 64 | 64 64\n" +
            "123: 64 119 | 50 85\n" +
            "45: 60 64\n" +
            "32: 20 50 | 79 64\n" +
            "36: 97 64 | 70 50\n" +
            "97: 50 64 | 64 50\n" +
            "21: 50 104 | 64 83\n" +
            "59: 50 124 | 64 83\n" +
            "10: 115 64 | 34 50\n" +
            "118: 50 124 | 64 4\n" +
            "60: 12 50 | 4 64\n" +
            "84: 29 64 | 99 50\n" +
            "111: 64 27 | 50 14\n" +
            "18: 64 101 | 50 29\n" +
            "13: 64 45 | 50 1\n" +
            "62: 64 97 | 50 83\n" +
            "117: 124 64 | 70 50\n" +
            "98: 50 4 | 64 124\n" +
            "15: 64 114 | 50 12\n" +
            "7: 100 64 | 56 50\n" +
            "78: 99 50 | 52 64\n" +
            "82: 114 64 | 97 50\n" +
            "22: 6 64 | 4 50\n" +
            "63: 12 50 | 114 64\n" +
            "16: 64 52 | 50 70\n" +
            "76: 50 46 | 64 13\n" +
            "31: 64 69 | 50 67\n" +
            "37: 21 50 | 128 64\n" +
            "95: 68 64 | 16 50\n" +
            "12: 64 50 | 50 30\n" +
            "26: 50 12 | 64 83\n" +
            "112: 113 50 | 72 64\n" +
            "33: 104 64 | 52 50\n" +
            "25: 70 64 | 114 50\n" +
            "96: 51 64 | 105 50\n" +
            "51: 50 47 | 64 26\n" +
            "91: 103 50 | 9 64\n" +
            "65: 66 64 | 23 50\n" +
            "116: 64 114 | 50 97\n" +
            "42: 64 54 | 50 40\n" +
            "4: 50 64\n" +
            "79: 50 97 | 64 29\n" +
            "110: 64 116 | 50 118\n" +
            "0: 8 11\n" +
            "73: 50 12 | 64 101\n" +
            "70: 50 50 | 64 50\n" +
            "74: 61 50 | 65 64\n" +
            "27: 50 107 | 64 90\n" +
            "101: 30 30\n" +
            "105: 17 50 | 24 64\n" +
            "61: 58 64 | 102 50\n" +
            "17: 50 83 | 64 29\n" +
            "72: 30 97\n" +
            "88: 64 38 | 50 2\n" +
            "14: 50 36 | 64 2\n" +
            "125: 64 50 | 64 64\n" +
            "127: 95 64 | 28 50\n" +
            "83: 64 64\n" +
            "80: 64 107 | 50 81\n" +
            "106: 50 101 | 64 29\n" +
            "56: 88 64 | 49 50\n" +
            "52: 50 50 | 64 64\n" +
            "46: 80 50 | 120 64\n" +
            "94: 68 64 | 33 50\n" +
            "47: 50 114 | 64 6\n" +
            "69: 44 64 | 57 50\n" +
            "54: 74 64 | 3 50\n" +
            "89: 50 83\n" +
            "48: 106 64 | 59 50\n" +
            "87: 86 50 | 37 64\n" +
            "35: 64 73 | 50 55\n" +
            "115: 50 99 | 64 70\n" +
            "44: 111 50 | 109 64\n" +
            "75: 78 50 | 22 64\n" +
            "20: 64 101 | 50 6\n" +
            "41: 50 4 | 64 101\n" +
            "6: 64 50\n" +
            "66: 50 93 | 64 115\n" +
            "90: 64 101 | 50 124\n" +
            "23: 50 82 | 64 77\n" +
            "81: 50 114 | 64 101\n" +
            "30: 50 | 64\n" +
            "100: 122 50 | 75 64\n" +
            "86: 50 73 | 64 18\n" +
            "92: 64 48 | 50 71\n" +
            "68: 6 50 | 114 64\n" +
            "121: 50 70\n" +
            "8: 42\n" +
            "85: 64 112 | 50 110\n" +
            "38: 64 104 | 50 4\n" +
            "120: 84 50 | 55 64\n" +
            "67: 64 7 | 50 53\n" +
            "64: \"a\"\n" +
            "55: 50 52 | 64 125\n" +
            "28: 89 50 | 84 64\n" +
            "71: 50 39 | 64 16\n" +
            "109: 43 64 | 94 50\n" +
            "99: 50 50\n" +
            "43: 41 64 | 77 50\n" +
            "119: 64 108 | 50 35\n" +
            "57: 87 50 | 96 64\n" +
            "39: 64 97 | 50 6\n" +
            "104: 50 64 | 64 30\n" +
            "29: 50 64 | 50 50\n" +
            "34: 83 50 | 125 64\n" +
            "2: 99 64 | 124 50\n" +
            "11: 42 31\n" +
            "114: 64 64 | 30 50\n" +
            "93: 50 97 | 64 101\n" +
            "58: 50 33 | 64 121\n" +
            "113: 64 99 | 50 70\n" +
            "128: 64 4 | 50 125\n" +
            "40: 123 64 | 76 50\n" +
            "107: 50 52 | 64 83\n" +
            "102: 126 50 | 25 64\n" +
            "126: 50 125 | 64 97\n" +
            "19: 50 124 | 64 114\n" +
            "24: 114 64 | 29 50\n" +
            "49: 20 30\n" +
            "1: 64 19 | 50 15\n" +
            "103: 26 50 | 18 64\n" +
            "9: 64 117 | 50 62\n" +
            "50: \"b\"\n" +
            "53: 91 64 | 5 50\n" +
            "77: 6 64 | 99 50\n" +
            "5: 32 64 | 10 50\n" +
            "3: 64 92 | 50 127\n" +
            "122: 115 64 | 98 50\n" +
            "\n" +
            "bbabbaaabbabbaaaabbbbbbb\n" +
            "bbaabaaaaabbbaaaabaaabba\n" +
            "baabababbbbaaaaabbabaaba\n" +
            "baaabbbabaabbaaababaabbaaaaabbbb\n" +
            "bbbbaabbbabaabbabaabaaaa\n" +
            "aabaaaabaababbbbababaabb\n" +
            "bbabbbaaabbbbabbbbabbabbbbbbbbabaabaaaabaabaabbabbabbbbbaabaaaba\n" +
            "baaaaaaabaabbbaaaaaababb\n" +
            "aaabbabaaabbabbbabaaabba\n" +
            "abbbbbabbababaabbaaabbbaababbbbaababbabb\n" +
            "bababbaabbbbbbaababaaabaaabababbabababba\n" +
            "babbaabbbabaabbbbbaaabba\n" +
            "abbbbbabbbbaababbababaaa\n" +
            "aaabaaababbaaabbbbbabbaaaabbbbba\n" +
            "bbaabaaaabbbaaaabbabbbab\n" +
            "baabaabababbaaababbababa\n" +
            "abbbbbabababaaabbbbbbbba\n" +
            "aababbbababbababaaababababbbbbbabaaabaaa\n" +
            "bbbbabaabbabaabbbbabbbaa\n" +
            "aabaabbbbbbababbbabbbaba\n" +
            "abbababaabbbaabbbabaaaababbbaabababbaaaaababbaabbbaabbabbbabaaabbaabaabbbbaaabaa\n" +
            "baababaaabababaabaaabbabbbaaaabbabbabaab\n" +
            "bbbaaaaabaababaaaaabbaaabbbababbaaabaaba\n" +
            "bbababbabbbbbbabbbbabbbbbaabbbabaabbbbababbabaab\n" +
            "abbbbbabbbabaabbbabbaabaaababaab\n" +
            "bbbbabbbbaababaaaaabbbbabbabbbbbbabbbbaaabaabbabaabbabbb\n" +
            "abbaabbabaaabaaaaabbbbaaaaabbbbb\n" +
            "aabaababababbbabbbabbbaabaaaabaaaaabbbbbaabbbabbaaabbbab\n" +
            "abaabaaabababbaababbabab\n" +
            "aabaaaabbbaababbbbabaaab\n" +
            "bbbababbabbbbabaaaabababbbabbbabbbbaaaabaaabbbbbaabababbbbababbbbbabaabb\n" +
            "aabbaababaabaaaaabbbbbabbbaaabaaaabaabab\n" +
            "baabbaaaaaaabbabbbababab\n" +
            "abbbabaabaabbbabbabaaaabaabaaaababaabbbb\n" +
            "aabbbabaaabababaabbababb\n" +
            "abababbbabaaabbaaaaaaababbabaabbbabbaaaabbbbbaab\n" +
            "abbabbaabbbaabbbabbaabaa\n" +
            "baabababbaabbaaabaaababb\n" +
            "aababaabbbabbababbaabababaaaabbabaabbaab\n" +
            "bbaaaabbbbbbababaabbbaaaabaabaaabbbbbbba\n" +
            "abbaabbbbaababaaaabaabaa\n" +
            "aaaaaabbabbaabbbbaabbabb\n" +
            "bababababababaabaaabbaabbababaababaabaabababbaba\n" +
            "ababbbbabbbbabaaabbbbbba\n" +
            "babaaabaaabbababbabbbbaa\n" +
            "bbabbbbabbbbbbabaaababbbaaabbabbbabbabbababbabbbbaabbbaabbababaa\n" +
            "bbaabaaaaabbbabaabbabbba\n" +
            "babababababbaabaaabbbbbb\n" +
            "baabbbabaabaabbabaabbbbb\n" +
            "babbbbababbaaabbbaaabbaabababbaabababaabbbbbaaabaaaaaaaa\n" +
            "aabbbabbababbbbaaaaaabaa\n" +
            "bbbababbababbbbabbaaabba\n" +
            "aabbabbaababaabbbbaababa\n" +
            "abbabaaabbbaaaaabbbababaaabbababbabbbaab\n" +
            "babaaaaaaababababbbabbbbbbbbbbaa\n" +
            "abaaababbabbbbbabaabaabb\n" +
            "babbbabbabbbbbabababbbbaaababbab\n" +
            "aaabbbbabababaabababbbbaabababab\n" +
            "baaabaabbabaaaabbababbaabbbabbbaabbbabbb\n" +
            "babaaabbabbabbabbabbbaba\n" +
            "bbaabbbababbbbabaaaabaaaaabbabababaabaab\n" +
            "abaaabaaabaabababbaaaabbbabbabab\n" +
            "bbbaaaababbabbabaaaaabab\n" +
            "bbbbababbaaabbaaabaabbbb\n" +
            "abbbbabbbaaaaababbbbbbba\n" +
            "bababbabaababbbbbababaaa\n" +
            "bbababbabbbbabbbbbababaabbbbbbbbabbbbabbbbaababa\n" +
            "baaaaababaabababaabaaabb\n" +
            "baabaababaaabbaaabababab\n" +
            "baaaaaaabbbababbbbbaabbbaababaaa\n" +
            "ababaaabbabaabbbabababba\n" +
            "baaabbbaabbabaaabbaaaaabaaaabbabbabbbbbbbbbaabaa\n" +
            "bbbababbabbbaaabaababaab\n" +
            "aaaaaabbaabbbaaabaaaaabb\n" +
            "babaaabbbbabbaaabbabbaab\n" +
            "aaabbaabbbababaaabaabaababababab\n" +
            "aaabaabbbabbaaaaababaaabababaabb\n" +
            "bbaaaabbbaaabbbaaababaaa\n" +
            "bbabbbbabbbaababbabbabba\n" +
            "baabababaaababaababaaaaaaababbab\n" +
            "baabbaaaaaabaaabbbbbaaaa\n" +
            "babbaaababaabaaaaaaabbbb\n" +
            "babaaaaaaaaabbabaabbababaabbabbaababaaabbbaabbaaaaabbbbb\n" +
            "abababaabbabaabbbaabbaaabbaaaaaa\n" +
            "bbbbbbaaaaabbabbbabbaaaabaabbbaababbbbbbbaabbbbaabbbababaabbaaababaababbabbbbaaaaabaaaaaaabaabab\n" +
            "bbababaabbbbaabbbbaabbbbbbbbbbbabbbaabbabbbbbabbabaaabaaaaabaaaa\n" +
            "abbbaabbbbbaabbbbabaabaabababbbbabaabbab\n" +
            "babaababaaababaabbaabbbbaaabaaabaaababbbabbbaaaabbabbbbbbbaababaabaabbbbbbbbbaaaaaababaa\n" +
            "babaabaababaabaabbaabbbb\n" +
            "bbbbbaaabbababaaabaabbaaaaaaabbbabbabaabbaaaabba\n" +
            "babbbbbbaaabbbabbbbabaaa\n" +
            "abaabaaababbbbabaababbab\n" +
            "bbaaabaabaaaaaaaaaabbbabaabbbbbb\n" +
            "aaabbbabaaaaaabbaabbaabbbaabaabaaabbababaaabaaababbbabab\n" +
            "aaabbaabaabbabaabbbbabbabaaabaabbaabbabb\n" +
            "babababaabaabaaababbaaba\n" +
            "babbbbbbabababaabaabbaba\n" +
            "baabbbabbbaaaaabababbaabaabbbbaaababaabaabbaabaaaaaabbaabbaaabba\n" +
            "abbbabaaabbbaabbbbaaabba\n" +
            "baabbbabaabbbbaaaabbbbbb\n" +
            "bababbabaaaabaaaaabbbbaaababaaaaaaababbaaaabbbbbabaabbab\n" +
            "abbaabbbbbabbbbbaabbbaab\n" +
            "ababbbabababbbaaaabbbabbbbaabaabbbbaaabbbaababbaaaaabbbbbaabbabb\n" +
            "aaababaaabbaabbbabbbbaaa\n" +
            "bbbababbbabbbaaaaabbbbaabaaabbaabbabababaaaaabaa\n" +
            "babaabaaabbaabbbbbbbabaaabbaaabbbaababbaabbbbbbbbaabaaaa\n" +
            "bababaabaabaaaabbaaaabba\n" +
            "baabbbbabaabababbaaabbabbbaabbbaabbbbabaababaaaaababbabaaabaabaaaaaababb\n" +
            "aabbbabbbbabbaaaaaaaabba\n" +
            "bbbaaabbaabbababbaabaaaa\n" +
            "abbbbbababbaabbbbaaabaaabbbbbabbbaaababaaabbaaababaabaaabbbabbaabbbbbbababaababb\n" +
            "babbbbbbababbbaabbabbbab\n" +
            "abbaabbaaababbbabbaababa\n" +
            "aaabbbabbabaabaaabbaabbbabbaabbbaaaaaaaa\n" +
            "abbbbabbbbbbabababbaabab\n" +
            "bbbbababaaabababbbbbbbba\n" +
            "bbbabaabababbbabbaaaabbbbababbabbabababa\n" +
            "aababababbbababbbbaabaaaababbababbbbaaaaabbbbabaabaababbabbbaaabbabbaaaabbbbababbabaabab\n" +
            "aabbaaabababbbaaabbaabaabababaaaaaaabababbabaaab\n" +
            "bbaaaaabbabbbbbabbabbbab\n" +
            "babbaababbbbabbbbbabaaab\n" +
            "aabababaaabbababbbbbaaba\n" +
            "babbaaaabbbaabbbbbbbabaaabbbbbba\n" +
            "bbaabaabbbabbbbaabaaababbaabababaabaaaaa\n" +
            "abaaababbababbaaabbbbbbb\n" +
            "bbaaaabbabbabaaaababbabb\n" +
            "aaabababaababababaaabbbb\n" +
            "ababbaaaabbbaabbbaabababbaaabbababbabbbabbaaabbb\n" +
            "aababbbaabababbabbabbbabbbaabababbbaababbabaabbabaababaa\n" +
            "baaabbbababbbabbbbaabaababbbbabbbabababbaabbbbba\n" +
            "aabababbaababbbbabbbaaaababbbbabbbbaaabbbabbbabaabaababb\n" +
            "baaabbabababbaaabaaaabab\n" +
            "aababbbaaabaabbaababbabb\n" +
            "aaabbaaaaababbbbbaabbbbbbaaaabaa\n" +
            "bbbbbaaababaabaaabbaabbbbbabbbabaaaaabab\n" +
            "aababbbbaabaabbabbabbaab\n" +
            "bbbaaaabaaaabaababbbbbbb\n" +
            "abbabaaaaaaabaaababaaabaaaababbbabaaabbb\n" +
            "abbbaaabbabababaabbbbbaa\n" +
            "baababaaaaababababababaabaaabbbaabaabaaa\n" +
            "bbbbbbbbababbbbabbabbaab\n" +
            "ababbaabaabaabbbabbbbbbb\n" +
            "babaaababaabbaaaabbabbaaababbababbabbbaaababbbabbbabbbabbabbbabb\n" +
            "babaabbabbbaaababbaaaaaa\n" +
            "bababbbaabababaabababaabaaaaaabbbbbababa\n" +
            "bbbbaabbababaababaaaaaab\n" +
            "ababbabbbabbbbaabaabbbbb\n" +
            "aabababbabababbaababaabbbbbaabaaabbbbbababbbbbabbbbbabbbbababbabbaababaa\n" +
            "ababbbababbabbaabaaaaabb\n" +
            "babaabbbbabbabbbaaabbaabbaabbbababbbabba\n" +
            "abbbaaabbaababaabbabaaba\n" +
            "bbbabaabbabaabbbaabaabab\n" +
            "ababbaaaaabaaaabbbaaabab\n" +
            "baababababbabbaabbababab\n" +
            "abbbbbabbbbbaabbaaaaaaab\n" +
            "baaaabbbaababaaaaabaaabbababbababaaaaabbbaaaabaa\n" +
            "bbbaaabbabbbaaaababaaaaa\n" +
            "bbbbaabbbbabbaaabbaaaaba\n" +
            "aaaabbabaaabbabbaaaabbba\n" +
            "abaabaaabbbaaaababbaaabaabbbaaabbbababaaaabbaabbabbabaababbabbbb\n" +
            "aaabaabbbbaabaababbbaaababbbaaba\n" +
            "baaabbbbbabbababbabaabab\n" +
            "babbbabbabbabaaaaaaaaabbbbaaaaaa\n" +
            "ababbaaaabaababaaaabbbbb\n" +
            "bbbaaabbbaabaababaaabbaabbbbbbaaabbbbbaa\n" +
            "ababaaaabbbbbbbbabaabbaa\n" +
            "bababaababbbabaaaabbabaa\n" +
            "babbabaababbaaabbabbbbaababaababbbbaaaaaaaabaabaaaaaababbbabbbbaaaabbbaa\n" +
            "baaabaaaabbbabbabaababbb\n" +
            "babaaaaabababababaabbaabbaabbbbabbabbabbbbaaaabababbabbbaabbbaaa\n" +
            "baabaababbaabbbaaababbab\n" +
            "aabaabababaabbbabbbabaaaabaaabaababbabbbaaabbbbbbaabbbaabaaabbbbaababbbbaabbaabb\n" +
            "aabbbabbbbaabaaabbbbbabb\n" +
            "aaabbaabaabbabbabaaaabba\n" +
            "baaabbbaaaabbaaababbabba\n" +
            "abaabbbababbbbababbaaaaa\n" +
            "bbaaabaaabbbbababbbaababbbbbbaaaabbaababaaabbbbb\n" +
            "ababaaaabbbbbaabbababaabbbabbaaabbbbaaba\n" +
            "aabbabaaaabbbabbbaabbbbaababaababbbabbbbabaaabaabbaaaabbaabaaaaa\n" +
            "bbbabbababbaaabbbaabbaaabaabbbaaaabbbbaabbababaaaabababb\n" +
            "babaaababbbbbaaaaabaaabb\n" +
            "abbbabbabbbbaabbbbabbbaa\n" +
            "bbbbabbbababbaabbbabaaaa\n" +
            "abbbaabbbbbbbaaaabbababa\n" +
            "bababaabbbbbbbbbaaaaabbb\n" +
            "babaaaababaabababbaabbaa\n" +
            "abbbaabbabaababaabaaabaaabbbabaabbaababa\n" +
            "bababbababbabbaabbaaaaaa\n" +
            "babbaaaababbaaabbbabaaaa\n" +
            "bbbbbaaaaabbababaaaaabaa\n" +
            "abaababaabaaabaaabaababb\n" +
            "baabbbbababbaabbbbbbbaba\n" +
            "bbabbbbbbbaaaaabbbaaaaabbaabbbaabbbbaaabaaaabbaa\n" +
            "aaabbbaaaaaaabbbaaabaabbaaaaaaaabbbaaabbbbbbbaba\n" +
            "aabbbababbababbaaaaaabbb\n" +
            "bbaabaaaabbaaabbabbabbababaaabbabbaaabba\n" +
            "babbaabbabbbbabbbabbbaaabbbaabbbbabbbaababaabbabbabbbbaa\n" +
            "bbbaabbbaababababaaaaaab\n" +
            "bbaaabaababaaabbaabbabbb\n" +
            "aaabaabbbbabbbbbababaabb\n" +
            "babaabbbbbbaababaabbbabbabbbabaabbabbaaababbabba\n" +
            "babbbbbabaaabbbaaaaaabab\n" +
            "aaabbbbabbababaaababbbbb\n" +
            "abbbaaaabaaaaababbabbaba\n" +
            "baabaaabbbbabbbbaabbbbaababaaabbabaaabba\n" +
            "ababaababaababaaaaabbbaa\n" +
            "baaabbabaaabbaabbbbbabaaaaaabbaaaaaabaaabaabaabaabaaabbaaabbababaaabbababbaaaaba\n" +
            "baabaabaaaaaaabbabbabaaabbabaabbbbabbbbabbabbaabbbabbbabbaabaabb\n" +
            "aabbbaaabbbabbbbbbbbbbba\n" +
            "aaabaabbaababbbabbabaaaa\n" +
            "aaabbabbabbbbbbaaabbbbbbabbbbaaa\n" +
            "aabbbbaaaabababaaababbbaaaabaaaa\n" +
            "bbaabaabbbbbbabababaababbbbbabaabbbbabaaabbabaab\n" +
            "aaabaabbaabbabbabaaaaaab\n" +
            "baaaaabaababbbabbbbaaaaa\n" +
            "ababbaabaaabaabbabaaaaba\n" +
            "baabaabaabababaababaaabbbbabbabb\n" +
            "baabbbabbbababbaaababaaa\n" +
            "aabaaaabaabaaaabbabababb\n" +
            "babbaababaabaaabaaaabbba\n" +
            "abbaabbbaabbbaaabaaababa\n" +
            "aabbbabbaababbbbbbaababbbbbbbbaaabaaaabb\n" +
            "babbabbaababababbaaaabbbbaaaaaabbaaabbbbababbbabaabababa\n" +
            "baabaaabbababbabbbaababa\n" +
            "babbbabbbbabbbbbabbababa\n" +
            "aabbababbbbbbbbbabbaabab\n" +
            "bbbbbaabaabbabbaabaaaabb\n" +
            "babbbbbbbabaaaabaabbbabbbabaabbbbbababaabbbbaabbabaaabbb\n" +
            "bbabbbbaaaababbabaaaaaab\n" +
            "abaaaabababaabbaababaabb\n" +
            "aaabbbabababbaaaaabaabbaababbbaabaaabbab\n" +
            "aaaabbabbababbbabaabbaab\n" +
            "bbaaaaabbbaabaababbabbba\n" +
            "baaabaaabaabbbbaaabaaabb\n" +
            "aababbbbbbbababbbaaabbbbbbaaabba\n" +
            "aaaabaaabbbbbbbaabaabbab\n" +
            "aabaabbabbbaabbbaabbabbababaabbababbaaabaabaabaaabaaabba\n" +
            "baababaabababababbbbbaba\n" +
            "bbaabaaabaaabbababbababa\n" +
            "abbbaaaaaaababaabaaabbaabaaabbaaaabbaaba\n" +
            "abbabbabbbbaaabaabaababb\n" +
            "babbabbbaabbbaaaaaaababb\n" +
            "bbbabababbaabaabaaabaaaa\n" +
            "bbbabaaabaababbabbaaabbaabaabbaa\n" +
            "baaaaababbbbbaabbbabbabb\n" +
            "baabababbaaabbbabababbaaababbabbabbbbbbb\n" +
            "abbbaabbabaaaaaaabaaaaaaaaabbbbababbaaaaababbababaabbbbbbabbbaababbbbaaa\n" +
            "aaabbabbbaaaaaaabababaababaaaaab\n" +
            "babaaaaaaabbbababbbbabbbabbaabbbaaabbaaaaaaaaaab\n" +
            "aabbbabbbababbaabbbababaabbaabbabaaaaabb\n" +
            "babbaaabbaabbbaabaabbabb\n" +
            "abbaabbaaabababbababbaba\n" +
            "abbbbbabbbbbbbbbbaabbabb\n" +
            "bbbaabbbbabaabaababaababbabbbabaaabaaabb\n" +
            "baabbbbabbbbbbbbbbbbaabbababbabb\n" +
            "aaabbbbaabbabbaaaaaababa\n" +
            "aabaabbabbbaaabababbbbbaaaaaaababaabbaba\n" +
            "abbabbabbaabbbabaaaabbaabaabbabbababbbbbbbaaaaaaaaaababbbbbaaabaaabaaaaabaaaabaa\n" +
            "aaababaaaabbababbaabbbaabaababaaaabaaabaaaaabbaa\n" +
            "baabaaabaaaaaaaaaabaaabbbbbbaaab\n" +
            "abaaabaaaaaaaabbbbaaaaba\n" +
            "babbaaabbbaaabaababbbaba\n" +
            "babbbbbabbaabaababbababbbabbabbabbbbbaba\n" +
            "aaaaaabbbaaaaaaaabaaaabaabbaabbaabbabbbbbbababbbaaaabbbb\n" +
            "bbbaababababbaabbbbabaaa\n" +
            "aaaaabbabbaaaaabaaabbaabbbabbabaababaabbababbaaababbabaabbbaaabbabbbbabb\n" +
            "babaabaaaabbbaaaaabbaaab\n" +
            "bbbbabbbbaaabbbabbbaababaaabbaabbabbbaba\n" +
            "aabaabaaabaaaabbabbabababaaabbabbbaaaabbbbbbaaaaababbaabaaabaabaabbababb\n" +
            "ababbaaaababbaabbaaaabbabababaababbaaabb\n" +
            "abababababbbabbbaabbbaababbabaab\n" +
            "babbbbabbbbababbbbbbbbabbbababbb\n" +
            "aababbbbabaaaabaaabaabab\n" +
            "bbbaaababababbababaababb\n" +
            "bbbabbbbbabbbabbaabaabab\n" +
            "baaababbaaabbbaaabbbabaaabaabaaaaaaabaaaabaababa\n" +
            "bbbbbbbbbbabbbbbbbbbbbabaaabbbaaabbbbaab\n" +
            "babbabbbbbbbabbbbbaaabba\n" +
            "babaaababbbbabaaaaabaaabaababababbabaaab\n" +
            "abaababaababbaaabbabbbbbabbabbab\n" +
            "bbbabbbbaabaaaabbbabaabbaaababbaaababbbbabaaaabbbbbabbbabaaaabab\n" +
            "babbbbbbaaabaabbbbbabbbbbabaabaaabaaabaabaaababa\n" +
            "abbabbababbbbababbabaaab\n" +
            "ababbaaaabaaabaabbaababb\n" +
            "aabaaaabababaaaabbbbaabbabbbaaaaabbaaaab\n" +
            "babaaaaaabbbaaaabababaababbbabbababaabaababbbbaaaabaabab\n" +
            "abaaaaaababbaabaabbaaaaababbaabbbabbbbbbbaaaabbbabaabbabbbabababaaababba\n" +
            "aabbbabababbaabbababbabb\n" +
            "aaabbaaaabaabbbaababaabb\n" +
            "bbaabbbabbbbababaaabbbabbbbbabbabaaaaaabaabbbbaaaaabbaabbaaaaaaa\n" +
            "babaaaabaaabbabbaaabbaba\n" +
            "aabbbbaabbbabbaabbbbbbba\n" +
            "bbaaaaaaabaabbaaaabaaaba\n" +
            "abbbaaabbabbbbbbbbbbabaababaaabbbbaabaaaabbbbbbaabaabbaaabbbababbbbabbba\n" +
            "abbaabbbaabbabababaaaabaabbababbabbbabbb\n" +
            "abbaaabbbbaabaaabbbbabbbbabbbbbbbaababbb\n" +
            "bbabbbbaabbbaaaabbbaababbbababbababbabba\n" +
            "abaaabaaabaabaaabbabbbaa\n" +
            "aaabbbabbbbbababaaabaaba\n" +
            "aabaabbabbbaaaabbabbabba\n" +
            "abbaaabbbbaabaabbababaaa\n" +
            "aabbabababbaaaaaaaaaabbbabababaabbbaaabbbbbaaaaa\n" +
            "aaaabbabbaababaabaaabaab\n" +
            "bababbaaaaabbaaaabbabbbb\n" +
            "abbaabbbabaaababbbbaababbabbaaaaabbbaaababbaaabaabbbbbba\n" +
            "aabbbabaaaabaaabbaaaabaa\n" +
            "bababbaabababbaabaabbaba\n" +
            "bbaabbbbbbbbaaaaabaabbbb\n" +
            "bbbbbbabbabbbbbaabbbbaaa\n" +
            "bababbbabaaabaaabbbabaab\n" +
            "baaaabaaaabbbbabbabbabbaaaaabbaa\n" +
            "bbbbbbabbaabbbabaabbbaab\n" +
            "baabaabaabbbaabbaababbab\n" +
            "aaabbaaabbbbababaabbababbabaabbaabaabbbabbbabaab\n" +
            "baaaaaababbbbbbabbabababbbaaabbbaabaaaababbbabbbaababaabbbaaaaabbaabbbbbabbababb\n" +
            "abbbabbabbaaabaabaaabaab\n" +
            "abaabbbabababbabababaabaabbabbabaabbaaaabbbbaaaa\n" +
            "bbabbabbbbbbaaabaabaababababaabbabababba\n" +
            "abaabbabbababaaabbabbababbabaaaababaaaaaaaaaabaabbbbaabbbbbbabaaaaaababbbbabaabaaababbba\n" +
            "bbaabbaabbbbbbabbabaaaabababaabbabbabbabbabaaabb\n" +
            "abbbaabbbbbaabbaabbbabab\n" +
            "bbbbbaabaaaabaabbaaababbabaaaabbabababbb\n" +
            "aabbbbbabaabaababaaabbaaaabaabbaabababbbaaabbbbb\n" +
            "aaaabaaabbbabababaaabbaaaabbabababbaababaababbaaabaaabba\n" +
            "bbbbabaaababbaaabbabaabbbabbaaaaaaaaaaab\n" +
            "babbaaaababbbbbabbbabababaabaabb\n" +
            "baabababbbbbabbbabbabbba\n" +
            "babaabaaaaabbaaaaaaaaaaa\n" +
            "bbbaaaabbabbaabbbabbbaba\n" +
            "abbaaabababbbaaabbaababb\n" +
            "aaababaabbabaabbbababaaa\n" +
            "baaabbaaababbabbbabaaaaaabaabbbbaaabaabaababbbbbbbaaaabbaabbbaabababbabbababbaaa\n" +
            "bbaabaabbbbababaaabbaabbaaabababbbbabaaaaaaaaaabbaaaaabbababbbbb\n" +
            "aaababbaabababaabbbaaabbbbabbaab\n" +
            "aabbbabaabbbabaabaabaaaa\n" +
            "ababbaaababbaababbabbaba\n" +
            "babbabaabbaaabbbabbbaaaaaabaabababaabaaaabaaabbbabbaabbbbabbabbbabbbaaab\n" +
            "ababbaaaababbaaabbbbaaba\n" +
            "bababbaabaabaaababbaabab\n" +
            "babaabbaaabaabbaabbbbabbaababbbabaaaabaaaababaab\n" +
            "babbbaaaabbbbbabaabaaaabbbabaaaa\n" +
            "abaabaaabababbabbbabaaab\n" +
            "babaabbabbbbabaaabaaaabaabbabbabaaaabbab\n" +
            "aaabaabbaabbbababbabbbbbaaabaaaa\n" +
            "ababaababbbaabababbaaaaabababbbbaabbaaba\n" +
            "aabbbabbabbabaaaabaabbab\n" +
            "bbabbaaabababbaabbababbb\n" +
            "baabbababbababbaaaaabbbbaabbbabaabaabbbbbabaabaabbbbbaaa\n" +
            "aababbbabaaaaaabbaaabaab\n" +
            "bbbbabbbaaaabaaaababaaaabbaaaaaaababbabb\n" +
            "baababbbaabaababbbababbbbbbaababbbbbaaabaaabbababbabaaaaababaaabaaaaabbabbbababb\n" +
            "baababaabbbabbbbbaaaabab\n" +
            "abbaaababbbaaabbbabababb\n" +
            "bbaaaaabbabbaabbababbabb\n" +
            "aabaabbaababaabaaaabbaba\n" +
            "bbbaababaaabbbbaabbaabbbbaaabababbbbbaba\n" +
            "bbaabbbabbaabaabaaaaabaa\n" +
            "aabaaaabbaaabbababaabbbabbbaaabbaabaaabaaaaabbba\n" +
            "babbaaabbaaabbaabbabbabb\n" +
            "bbbaababaaabbbabbabaabab\n" +
            "aaababaabbaaabaaaabaabbaabaabbab\n" +
            "aaababbaabaabaabbaaaaabbbbabbaaaaaaabbababbbaaaabaabbaabaabbaabbbbbabbab\n" +
            "aaaaaaaaabbaabaababbbbbababaababbabbaabbababbbabaaaaaabaabbbabab\n" +
            "baaaaabbabaaaabbaaababbabaabbaababbbbbabaaababbbbbbbbaaaabaaabababbababbabbabaababababab\n" +
            "abaaaaabbaabababbabaaaababbbaaaabbaaaaaa\n" +
            "ababaaaabbbbbaaaababaababaabbabbbbaaabab\n" +
            "bbaaaabbaabbbabbabbaabab\n" +
            "baabaabaababaabaaaabaaba\n" +
            "baabbbabbbaabbaabbababaabbbaaabbbaaaabaabaabbbbbaabbabaaabbababbbbbbbaabbabbaaabababaabb\n" +
            "aaaabaaaabbaaababbabbaba\n" +
            "aabababbaaabbbababaababb\n" +
            "ababaaabababbbabbbabbbab\n" +
            "abbbabbaaaababaabaaabbaaababbbbaaabbabbaaaaaabaabaaabbbbbbaaabbaaaaaabba\n" +
            "baaaabbbbaabbababbabbbabbabaaaba\n" +
            "baabaabaaaaabbabaabaabbbbaaaabbaabaaabbb\n" +
            "abbaabbbababbaaababaaababbbaaababaaaaaabbbababab\n" +
            "aabbbbaaaaaabaababbaaaababaaabbbaabbbaaaabbbbbababbbaabaaaaabbabaaaaaaaa\n" +
            "baaaaaaabababaabababbaba\n" +
            "bababbbaaabbababbbaaaaba\n" +
            "aaababbaaabbabbaababbbbb\n" +
            "aabababbabbbbabaabbabaaaabaabbbabbababbabababbabaaaaabba\n" +
            "abbababbbaabaabbbaabbaaaabaaabbaababbbbbbbbbbabbaababbaabaabaababbbabbabaabbabbbbbaaaabbbbbababb\n" +
            "aabbabbaabaababaaaaaabba\n" +
            "aabbababaaababbaabaabbab\n" +
            "abbbbbaababbaababbababaabbaaaaaabaaabababaaaabbbbbaaabbb\n" +
            "aaaaabbabaababbaaabaabaa\n" +
            "babbbaaabaabbbbababaabbaabaaaaabbbabbbaaabbbabbbbabbbbaa\n" +
            "aaaabaabbabaaaababababba\n" +
            "abbbabbbaaaaabbbbbaabbaa\n" +
            "bbbaaaabbbaabbbababaaabbbbababaabbaaaaaa\n" +
            "aaaabaabbbbaaaabbbbabbab\n" +
            "aababbbbbaabababbbaaabba\n" +
            "baabbbbababbbabbaabbabbabbbababbaaaaabab\n" +
            "bbabbbbabaabbaaabaabbbbb\n" +
            "ababbaabbbababbabbababab\n" +
            "aaabababbbbababbabaaababbbabaaba\n" +
            "aaabababbaaabbbabbabbabb\n" +
            "bbbbbbabaabaaaabbbaaabab\n" +
            "abbabbaabbbabbaaabbaabbbaabaababaababbab\n" +
            "abbaabbababbaaaaabbaabbaaabaabbaaabbaaba\n" +
            "ababbbabbaababbbbabbbbaaaabbaaabaaaaaaab\n" +
            "baabbbbaaaababbbaabbbbbaaabaaaaa\n" +
            "bbbababababbaabaaaaaabaa\n" +
            "baabababbbbaabbababbbbbaaaababbaabaabbbaaabbabaabbaabbbb\n" +
            "aabbbaaabbbbbaabaaabbaba\n" +
            "babbbabbaabbaabbbaabbaab\n" +
            "bbbabaabbbbaabbaaaabbabbaaabababbbabbaaaabbbaabbbaaabaaababababb\n" +
            "bbbaaaabbbabbbbabbbabbba\n" +
            "aabbbabababaaaaabbbabbaaaabaaaba\n" +
            "bababbaababababaabaaaabb\n" +
            "bbbaaabbbbbaabbabbbbbbaabbaabbbb\n" +
            "abbbaabbbababaabbbaaaaba\n" +
            "abababaabaaabbbabaaabbabbabaaaabbbaaabab\n" +
            "bbbabbbbbbbaaaaabbbbababbbabaaabababbbbb\n" +
            "abaaaaaaababbaababbaaabaabbaaaab\n" +
            "bababaababbbabbabbabaaba\n" +
            "babbaababababaabbbbbbbbbabbababbbababbbb\n" +
            "bbbaaabbbbababaababbbaba\n" +
            "aaabbbbaabbbababbababaaaaaabbbbaababbbbbabaaababbbabbbaaaaaaaabaaaaaabaa\n" +
            "bbaabbbabbbbbbaaaaaaaaab\n" +
            "baaabbbabbbaaaaaaabbaaaa\n" +
            "aaaabaaaaabaabbaabbabbbb\n" +
            "abbbbabbbaababaaabababbbbaaabaabaaaaabaabbbbabbaabbabbbb\n" +
            "aaaabaabbbababbababbaabbbbabaabbbbbbaaab\n" +
            "bbbbbaaabbbaababbbbababbbbabaabbaabbbbba\n" +
            "aaabbbbababbbabbbbbaababbbbbbbbbbbabaabbaaaaabaa\n" +
            "aabbbabaababaaabbabbbaba\n" +
            "bbbaababbbbbbbbbabaabbaa\n" +
            "ababaaababbbbbabaaaaabab\n" +
            "bbbababbbababbbaabbababa\n" +
            "bababbbaabbbabbababbabaa\n" +
            "bbbababaabaaaabaaaaabbbb\n" +
            "ababaaabbbbaaaabbbabaaba\n" +
            "aaababaabbbaaabbbbbaaaababbabbbb\n" +
            "babbbbabbababbaaababaaaaabaababbabbbabbb\n" +
            "bababbabbabbabbbaabbababbaabbaaaaabbbaabaabbaabbbbaaabbaabbabbbabbbbbaab\n" +
            "babbaababaaabbaaababaaaabbbaabaa\n" +
            "bbabbbbabaabababbaaabaab\n" +
            "abbbaaabaaababbaabaabbab\n" +
            "bbbababbbbbabbbbbbabbabb\n" +
            "bbbbbaababaaaabaababaabb\n" +
            "abbabaaaabbbaaaababbbbab\n" +
            "ababbbabaaabbbabaabbbbaaaaabbbbbaabaaaba\n" +
            "bbaaabaaaaababaaabaabbbb\n" +
            "abaaabaababaaabbbaaabbaabbbbabaabbabbaab\n" +
            "bbbbbababbabaababaababbbaabbaabaaabaaaaaaabbbbba\n" +
            "aabbbabbabbaaababbababaabbbabababaaaaaaaaabaabaabaababba\n" +
            "abaaaababbbbbbababaabbbabbbaaaaaababbabb\n" +
            "babbbbbaaaaabbabbaaaaabb\n" +
            "aaabaababbaabbaaabbbbbabbbbababbaabbbbbababbbaab\n" +
            "abbabaaabbbabbaababbaabbaabbbbba\n" +
            "babaaabaabbbabbaaaaabbaa\n" +
            "baabbbbabaaaaababbbaabbbaaaabbbb\n" +
            "aabbaabbbbbaaaabbbbabbaaabbabbababbbbaababaababb\n" +
            "abaaaabbbbaaababbbbbbabb\n" +
            "abaaaabaababbbabaabaaabb\n" +
            "abaababbaabaababbaaabbbb\n" +
            "bbabbabbabababbaaaabbabaabababab\n" +
            "aaaaaabbbabaaaabbbbbbbaabaaaaabbaababbabbabbbababaaaabba\n" +
            "bbababbabaaababbababbbbbbabbabab\n" +
            "bbabbaaababbbbaababbaaab\n" +
            "baaaaaaaaabababbaabaabaa\n" +
            "abbaaabbabbbaaaababaaabaababaabaababaabb\n" +
            "abaaaaabaaababbaaaabaaab\n" +
            "abaaaaaabbaabaaaaaabbaabababbbaaabbbabbbbaabbaab\n" +
            "abbaaabbbbaabbaaaabbbaaabaabaaaa\n" +
            "aabaaaabbbbaaaabaaababbb\n" +
            "abbaabaabbbbababbabbaaababaaabbaaabaaaabbabababababababb";

    private static final String INPUT2 = "42: 9 14 | 10 1\n" +
            "9: 14 27 | 1 26\n" +
            "10: 23 14 | 28 1\n" +
            "1: \"a\"\n" +
            "11: 42 31 | 42 11 31\n" +
//            "11: 42 31\n" +
            "5: 1 14 | 15 1\n" +
            "19: 14 1 | 14 14\n" +
            "12: 24 14 | 19 1\n" +
            "16: 15 1 | 14 14\n" +
            "31: 14 17 | 1 13\n" +
            "6: 14 14 | 1 14\n" +
            "2: 1 24 | 14 4\n" +
            "0: 8 11\n" +
            "13: 14 3 | 1 12\n" +
            "15: 1 | 14\n" +
            "17: 14 2 | 1 7\n" +
            "23: 25 1 | 22 14\n" +
            "28: 16 1\n" +
            "4: 1 1\n" +
            "20: 14 14 | 1 15\n" +
            "3: 5 14 | 16 1\n" +
            "27: 1 6 | 14 18\n" +
            "14: \"b\"\n" +
            "21: 14 1 | 1 14\n" +
            "25: 1 1 | 1 14\n" +
            "22: 14 14\n" +
            "8: 42 | 42 8\n" +
//            "8: 42\n" +
            "26: 14 22 | 1 20\n" +
            "18: 15 15\n" +
            "7: 14 5 | 1 21\n" +
            "24: 14 1\n" +
            "\n" +
            "abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa\n" +
            "bbabbbbaabaabba\n" +
            "babbbbaabbbbbabbbbbbaabaaabaaa\n" +
            "aaabbbbbbaaaabaababaabababbabaaabbababababaaa\n" +
            "bbbbbbbaaaabbbbaaabbabaaa\n" +
            "bbbababbbbaaaaaaaabbababaaababaabab\n" +
            "ababaaaaaabaaab\n" +
            "ababaaaaabbbaba\n" +
            "baabbaaaabbaaaababbaababb\n" +
            "abbbbabbbbaaaababbbbbbaaaababb\n" +
            "aaaaabbaabaaaaababaa\n" +
            "aaaabbaaaabbaaa\n" +
            "aaaabbaabbaaaaaaabbbabbbaaabbaabaaa\n" +
            "babaaabbbaaabaababbaabababaaab\n" +
            "aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba";

    private static class State {
        Map<String, State> nextStates;

        public State(Map<String, State> nextStates) {
            this.nextStates = nextStates;
        }

        @Override
        public String toString() {
            return "State" + Integer.toHexString(System.identityHashCode(this)) + "{" +
                    "nextStates=" + nextStates +
                    '}';
        }
    }

    private static class Rule {
        List<List<String>> next;
        String output;

        public Rule(List<List<String>> next, String output) {
            this.next = next;
            this.output = output;
        }
    }

    public static void main(String[] args) {
//        Map<String, List<String>> rules = parseRules(INPUT);
//        System.out.println(rules);
//        State start = new State(new HashMap<>());
//        build(start, rules, "0", rules.get("0"));
//        System.out.println(start);

        Map<String, Rule> rules = new HashMap<>();
        String[] lines = INPUT.split("\n");
        int blank = 0;
        for (String line : lines) {
            if (line.length() == 0) {
                break;
            }
            String[] parts = line.split(": ");
            String ruleName = parts[0];
            String[] patterns = parts[1].split(" ");
            if (patterns.length == 1 && patterns[0].charAt(0) == '"') {
                rules.put(ruleName, new Rule(null, patterns[0].substring(1, patterns[0].length()-1)));
            } else {
                List<List<String>> nexts = new ArrayList<>();
                List<String> next = new ArrayList<>();
                for (String pattern : patterns) {
                    if (pattern.equals("|")) {
                        nexts.add(next);
                        next = new ArrayList<>();
                    } else {
                        next.add(pattern);
                    }
                }
                nexts.add(next);
                rules.put(ruleName, new Rule(nexts, null));
            }
            blank++;
        }

        int matches = 0;
        for (int i = blank+1; i < lines.length; i++) {
            String line = lines[i];
            if (isValidV2(line, rules)) {
                matches++;
            }
        }
        System.out.println(matches);
    }

    private static int linePos = 0;
    private static boolean isValid(String line, Map<String, Rule> rules) {
        linePos = 0;
        for (List<String> ps : rules.get("0").next) {
            boolean valid = true;
            for (String p : ps) {
                if (!isValid(line, rules, rules.get(p))) {
                    valid = false;
                    break;
                }
            }
            if (valid && linePos == line.length()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidV2(String line, Map<String, Rule> rules) {
        linePos = 0;
        int validCntFor42 = 0;
        boolean valid = true;
        int lastValidLinePos = 0;
        while (valid) {
            lastValidLinePos = linePos;
            valid = isValid(line, rules, rules.get("42"));
            if (valid) {
                validCntFor42++;
            }
        }
        linePos = lastValidLinePos;
        if (validCntFor42 > 1) {
            int validCntFor31 = 0;
            valid = true;
            while (valid) {
                lastValidLinePos = linePos;
                valid = isValid(line, rules, rules.get("31"));
                if (valid) {
                    validCntFor31++;
                }
            }
            linePos = lastValidLinePos;
            if (linePos == line.length() && validCntFor31 > 0 && validCntFor31 < validCntFor42) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(String line, Map<String, Rule> rules, Rule curRule) {
        if (curRule.output != null) {
            if (linePos < line.length() && Character.toString(line.charAt(linePos)).equals(curRule.output)) {
                linePos++;
                return true;
            } else {
                return false;
            }
        } else {
            for (List<String> ps : curRule.next) {
                boolean valid = true;
                int beforeLinePos = linePos;
                for (String p : ps) {
                    if (!isValid(line, rules, rules.get(p))) {
                        valid = false;
                        linePos = beforeLinePos;
                        break;
                    }
                }
                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }
//
//    private static Map<String, List<String>> parseRules(String input) {
//        Map<String, List<String>> rules = new HashMap<>();
//        for (String line : input.split("\n")) {
//            if (line.length() == 0) {
//                break;
//            }
//            String[] parts = line.split(": ");
//            String ruleName = parts[0];
//            String[] patterns = parts[1].split(" ");
//            rules.put(ruleName, Arrays.asList(patterns));
//        }
//        return rules;
//    }
//
//    private static void build(State startState, Map<String, List<String>> rules, String curName, List<String> curPatterns) {
//        State cur = startState;
//        for (String pattern : curPatterns) {
//            System.out.println(String.format("curName=%s, pat=%s, curState=%s, startState=%s",
//                    curName, pattern, cur, startState));
//            if (pattern.equals("|")) {
//                cur = startState;
//            } else if (rules.get(pattern).get(0).charAt(0) == '"') {
//                State next = new State(new HashMap<>());
//                cur.nextStates.put(rules.get(pattern).get(0).substring(1, rules.get(pattern).get(0).length()-1), next);
//                cur = next;
//            } else {
//                build(cur, rules, pattern, rules.get(pattern));
//            }
//        }
//    }
}
