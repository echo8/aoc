package com.echo8.aoc2020;

import java.util.*;

public class Day4Part2 {
    private static final String INPUT = "ecl:grn\n" +
            "cid:315 iyr:2012 hgt:192cm eyr:2023 pid:873355140 byr:1925 hcl:#cb2c03\n" +
            "\n" +
            "byr:2027 hcl:ec0cfd ecl:blu cid:120\n" +
            "eyr:1937 pid:106018766 iyr:2010 hgt:154cm\n" +
            "\n" +
            "byr:1965 eyr:2028 hgt:157cm\n" +
            "cid:236 iyr:2018 ecl:brn\n" +
            "hcl:#cfa07d pid:584111467\n" +
            "\n" +
            "eyr:2029 ecl:hzl\n" +
            "iyr:1972 byr:1966\n" +
            "pid:2898897192\n" +
            "hgt:59cm hcl:z\n" +
            "\n" +
            "pid:231652013 hcl:#602927 hgt:166\n" +
            "ecl:grn eyr:2025\n" +
            "byr:2008 iyr:1986\n" +
            "\n" +
            "byr:1928 hgt:167cm\n" +
            "hcl:#18171d iyr:2012\n" +
            "ecl:oth pid:237657808 eyr:1944\n" +
            "\n" +
            "hgt:73in ecl:grn byr:1931 pid:358388825 iyr:2020\n" +
            "hcl:#602927 eyr:2020\n" +
            "\n" +
            "hcl:#efcc98 eyr:2024 ecl:hzl\n" +
            "byr:2030 hgt:192cm\n" +
            "iyr:2013 pid:7479289410\n" +
            "\n" +
            "pid:053467220 iyr:2012 hgt:169cm\n" +
            "cid:149 hcl:#866857\n" +
            "eyr:2030\n" +
            "byr:1995 ecl:oth\n" +
            "\n" +
            "hgt:162cm hcl:#efcc98 ecl:grn byr:1985 pid:419840766\n" +
            "eyr:2022\n" +
            "iyr:2020\n" +
            "\n" +
            "pid:22086957 hcl:c69235 ecl:#c458c5 eyr:1986 byr:2014 hgt:72cm iyr:1934\n" +
            "\n" +
            "hcl:#866857\n" +
            "ecl:brn eyr:2024\n" +
            "iyr:2017\n" +
            "pid:505225484 cid:144\n" +
            "byr:1980\n" +
            "hgt:170cm\n" +
            "\n" +
            "hcl:#866857 ecl:gry\n" +
            "byr:1972 iyr:2019 eyr:2023\n" +
            "cid:234 pid:721290041 hgt:191cm\n" +
            "\n" +
            "pid:346301363\n" +
            "eyr:2020\n" +
            "hcl:#733820 iyr:2019 hgt:177cm\n" +
            "byr:1998\n" +
            "\n" +
            "hgt:157cm byr:1963\n" +
            "pid:898055805\n" +
            "hcl:#fffffd ecl:blu iyr:2017 cid:87\n" +
            "eyr:2030\n" +
            "\n" +
            "pid:605900764 iyr:2011\n" +
            "hgt:73in ecl:hzl eyr:2024\n" +
            "hcl:#888785\n" +
            "cid:281\n" +
            "\n" +
            "iyr:2010 eyr:2026 hcl:#4f7e76 pid:883386029 byr:1946 ecl:brn\n" +
            "\n" +
            "hcl:z\n" +
            "iyr:2020 pid:9121928466 byr:2014 ecl:zzz eyr:2025\n" +
            "hgt:172in\n" +
            "\n" +
            "hgt:151cm cid:163 pid:670884417 iyr:2012\n" +
            "ecl:oth hcl:#ceb3a1\n" +
            "eyr:2028\n" +
            "\n" +
            "hcl:z cid:92 hgt:69cm\n" +
            "byr:2008 pid:492284612\n" +
            "eyr:2020 iyr:2023\n" +
            "ecl:hzl\n" +
            "\n" +
            "byr:1933\n" +
            "hcl:#7d3b0c eyr:2020 hgt:170cm\n" +
            "pid:949064511 iyr:2010\n" +
            "ecl:oth\n" +
            "\n" +
            "eyr:2025 byr:1989 ecl:oth cid:100 hgt:182cm\n" +
            "pid:629190040 iyr:2017 hcl:#b6652a\n" +
            "\n" +
            "ecl:hzl cid:76 hcl:#e71392 eyr:2021 iyr:2013 byr:1995\n" +
            "pid:762177473\n" +
            "hgt:179cm\n" +
            "\n" +
            "pid:198500564 eyr:2029 hcl:#733820 cid:51 iyr:2012\n" +
            "hgt:70in byr:1938 ecl:oth\n" +
            "\n" +
            "hgt:190cm ecl:brn byr:1952 iyr:2015 hcl:#623a2f\n" +
            "eyr:2023\n" +
            "\n" +
            "hgt:169cm hcl:#602927 byr:2001 pid:823979592 iyr:2016 eyr:2029\n" +
            "\n" +
            "iyr:2010 ecl:gry\n" +
            "eyr:2022 hgt:156cm byr:1953 pid:434063393\n" +
            "hcl:#733820\n" +
            "\n" +
            "pid:091724580 hcl:a7069e eyr:1984 ecl:#95d01e byr:2012 iyr:2005\n" +
            "\n" +
            "eyr:2022 byr:1972 hcl:#866857 ecl:hzl pid:227453248\n" +
            "hgt:153cm cid:324 iyr:2018\n" +
            "\n" +
            "cid:195 pid:049871343\n" +
            "eyr:2024 hgt:169cm\n" +
            "byr:1952 iyr:2010 ecl:grn\n" +
            "\n" +
            "eyr:2035 pid:189cm\n" +
            "hgt:77 iyr:1973 ecl:#dc83d5\n" +
            "hcl:z byr:2004\n" +
            "\n" +
            "byr:2027\n" +
            "pid:89338932 hcl:1de39e ecl:grn hgt:159in eyr:2034 iyr:1937\n" +
            "\n" +
            "pid:076534920\n" +
            "hgt:152cm\n" +
            "byr:1969\n" +
            "ecl:blu\n" +
            "hcl:#866857 iyr:2011 eyr:2024\n" +
            "\n" +
            "iyr:2019 eyr:2028\n" +
            "ecl:blu hgt:169cm\n" +
            "hcl:#888785 pid:332202163 byr:1923\n" +
            "\n" +
            "hgt:65in byr:1964 iyr:2019\n" +
            "pid:287612987 ecl:hzl cid:213 eyr:2023 hcl:#ceb3a1\n" +
            "\n" +
            "hcl:#623a2f pid:182484027\n" +
            "iyr:2016 ecl:brn byr:1943\n" +
            "hgt:71in eyr:2021 cid:344\n" +
            "\n" +
            "hcl:#cdee64 iyr:2011 ecl:brn eyr:2026 hgt:176cm\n" +
            "byr:1985 pid:978641227\n" +
            "\n" +
            "eyr:2029 ecl:brn hgt:173cm byr:1920 cid:211\n" +
            "hcl:#866857\n" +
            "iyr:2016 pid:289769625\n" +
            "\n" +
            "hcl:#7d3b0c pid:770938833 iyr:2010 byr:1941 ecl:oth eyr:2029 hgt:161cm\n" +
            "\n" +
            "hgt:172cm iyr:2015 ecl:gry byr:1948\n" +
            "eyr:2029\n" +
            "pid:466359109 hcl:#341e13\n" +
            "\n" +
            "cid:74 pid:405199325 ecl:blu\n" +
            "hcl:#6b5442\n" +
            "eyr:1980 byr:2024 hgt:174cm iyr:2011\n" +
            "\n" +
            "hgt:183cm pid:075760048 cid:78 byr:1960 ecl:hzl eyr:2030 hcl:#6b5442 iyr:2014\n" +
            "\n" +
            "cid:264 hcl:#7d3b0c\n" +
            "ecl:blu iyr:2011 eyr:2020 hgt:182cm\n" +
            "byr:1929\n" +
            "\n" +
            "pid:435338286 byr:1931\n" +
            "hcl:z ecl:amb iyr:2013 hgt:73in\n" +
            "cid:165 eyr:2027\n" +
            "\n" +
            "pid:511898552 eyr:2025 hgt:184cm hcl:#602927\n" +
            "iyr:2018 byr:1989 ecl:hzl\n" +
            "\n" +
            "iyr:2016\n" +
            "hgt:168in\n" +
            "hcl:#623a2f\n" +
            "eyr:2025 pid:310738569 ecl:#0c3039\n" +
            "byr:2027\n" +
            "\n" +
            "pid:158cm byr:1946 ecl:grt\n" +
            "iyr:1920 cid:189\n" +
            "hcl:389bce hgt:165cm\n" +
            "\n" +
            "pid:973732906 hcl:#cfa07d iyr:2010 eyr:2020 hgt:180cm\n" +
            "byr:1930\n" +
            "ecl:brn\n" +
            "\n" +
            "pid:930994364 byr:1967 hgt:151cm\n" +
            "iyr:2011 eyr:2022\n" +
            "\n" +
            "eyr:1968 hgt:75cm cid:241\n" +
            "iyr:2011 pid:5493866745\n" +
            "ecl:grt\n" +
            "byr:1976 hcl:#a97842\n" +
            "\n" +
            "eyr:2026 ecl:oth\n" +
            "iyr:2016 hcl:#c0946f\n" +
            "byr:1929\n" +
            "hgt:175cm\n" +
            "pid:9421898537\n" +
            "\n" +
            "eyr:2028 iyr:2016 byr:1962\n" +
            "ecl:grn hgt:186cm hcl:#cfa07d pid:432962396\n" +
            "\n" +
            "iyr:2010 byr:1934 eyr:2023 hgt:180cm hcl:#cfa07d ecl:gry\n" +
            "\n" +
            "cid:168\n" +
            "byr:1978\n" +
            "eyr:2027 hgt:189cm pid:802710287\n" +
            "hcl:#2f980b iyr:2014\n" +
            "ecl:grn\n" +
            "\n" +
            "eyr:1970\n" +
            "pid:576329104\n" +
            "ecl:xry iyr:1954 hcl:#341e13 byr:2026\n" +
            "hgt:74in\n" +
            "\n" +
            "eyr:2027 hgt:153cm\n" +
            "ecl:oth\n" +
            "hcl:#866857\n" +
            "pid:290407832 byr:1956 iyr:2017\n" +
            "\n" +
            "iyr:2011\n" +
            "cid:128\n" +
            "ecl:amb hcl:#7d3b0c hgt:68in pid:743606119 eyr:2020\n" +
            "\n" +
            "ecl:oth hcl:#cfa07d\n" +
            "byr:2016 pid:#de98ae iyr:1984 cid:194\n" +
            "hgt:170cm\n" +
            "eyr:2034\n" +
            "\n" +
            "pid:526098672 hgt:168cm\n" +
            "hcl:#7d3b0c cid:167 byr:1923 ecl:blu iyr:2016\n" +
            "eyr:2030\n" +
            "\n" +
            "pid:495569197 hcl:#866857 hgt:193cm\n" +
            "iyr:2013 eyr:2021 byr:1921 ecl:amb\n" +
            "\n" +
            "ecl:amb\n" +
            "hcl:#a97842 pid:862249915 iyr:2012 byr:1964\n" +
            "cid:325\n" +
            "eyr:2021\n" +
            "\n" +
            "iyr:1958\n" +
            "byr:2003\n" +
            "hgt:160 hcl:#18171d\n" +
            "ecl:hzl eyr:2020\n" +
            "\n" +
            "iyr:2019 byr:1997 ecl:brn\n" +
            "pid:342735713 hcl:#efcc98\n" +
            "hgt:181cm cid:307\n" +
            "eyr:2027\n" +
            "\n" +
            "pid:817121616 eyr:2020\n" +
            "iyr:2012\n" +
            "hgt:185cm\n" +
            "hcl:#18171d byr:1969 ecl:hzl\n" +
            "\n" +
            "pid:381399203\n" +
            "ecl:oth byr:1930\n" +
            "iyr:2014 hcl:#6b5442 hgt:71in cid:156 eyr:2025\n" +
            "\n" +
            "byr:2002 hcl:#18171d iyr:2017\n" +
            "pid:398245854 hgt:64in ecl:gry eyr:2025 cid:127\n" +
            "\n" +
            "eyr:2028 hcl:#341e13\n" +
            "ecl:amb iyr:2012\n" +
            "pid:079796480 hgt:69cm\n" +
            "byr:1995\n" +
            "\n" +
            "cid:315 iyr:2028\n" +
            "pid:775929239\n" +
            "hgt:162cm ecl:dne byr:1940 eyr:1952 hcl:#c0946f\n" +
            "\n" +
            "iyr:2015\n" +
            "hgt:154cm byr:1997\n" +
            "ecl:grn\n" +
            "cid:125 eyr:2024 pid:834780229\n" +
            "hcl:#18171d\n" +
            "\n" +
            "ecl:hzl hcl:#a97842 pid:553710574 eyr:2028\n" +
            "hgt:183cm cid:196\n" +
            "iyr:2014\n" +
            "\n" +
            "pid:377912488 hgt:159cm ecl:amb eyr:2024 byr:1974\n" +
            "iyr:2014\n" +
            "hcl:#ceb3a1\n" +
            "\n" +
            "eyr:2024\n" +
            "byr:1947 hgt:63in ecl:brn\n" +
            "cid:69\n" +
            "pid:185228911 hcl:#b6652a iyr:2016\n" +
            "\n" +
            "eyr:2024\n" +
            "hgt:168cm hcl:#602927\n" +
            "iyr:2013\n" +
            "byr:1993\n" +
            "pid:681091728 ecl:gry cid:203\n" +
            "\n" +
            "pid:037922164 iyr:2020\n" +
            "byr:1990 hgt:156cm eyr:2023 hcl:#866857\n" +
            "cid:97 ecl:grn\n" +
            "\n" +
            "hgt:170cm pid:980455250\n" +
            "iyr:2011 ecl:hzl byr:1957\n" +
            "eyr:2030 hcl:#cfa07d\n" +
            "\n" +
            "hgt:158cm\n" +
            "hcl:#602927\n" +
            "byr:2002 ecl:hzl iyr:2013\n" +
            "cid:99\n" +
            "eyr:2020 pid:48646993\n" +
            "\n" +
            "byr:1955 pid:814033843 eyr:2030 hcl:#a97842\n" +
            "hgt:191cm iyr:2019\n" +
            "\n" +
            "pid:111196491 hgt:191cm iyr:2012 ecl:blu hcl:#a97842\n" +
            "eyr:2026 cid:131 byr:1979\n" +
            "\n" +
            "hcl:#fffffd hgt:68in\n" +
            "cid:121 ecl:oth eyr:2024 pid:343836937\n" +
            "byr:1955\n" +
            "iyr:2020\n" +
            "\n" +
            "eyr:2025 byr:1954\n" +
            "pid:737517118\n" +
            "cid:343 hcl:#b6652a\n" +
            "iyr:2017 ecl:hzl\n" +
            "hgt:175cm\n" +
            "\n" +
            "ecl:brn\n" +
            "iyr:2011 hgt:171cm cid:102 pid:066348279 byr:1981\n" +
            "\n" +
            "ecl:oth iyr:2018 byr:1975\n" +
            "eyr:2029\n" +
            "hgt:185cm cid:226\n" +
            "pid:978243407 hcl:#341e13\n" +
            "\n" +
            "iyr:2015 pid:918017915 hcl:#3e52b7\n" +
            "byr:1999 ecl:brn cid:314\n" +
            "eyr:2025 hgt:192cm\n" +
            "\n" +
            "hcl:#19d1fa byr:1984 ecl:dne hgt:76in\n" +
            "iyr:2015 cid:118 pid:417075672\n" +
            "eyr:2020\n" +
            "\n" +
            "iyr:2019\n" +
            "cid:120 hgt:186cm\n" +
            "hcl:#733820 eyr:2024 pid:423238982 ecl:brn byr:1968\n" +
            "\n" +
            "hgt:70cm cid:173 pid:767014975\n" +
            "hcl:#866857 eyr:2039 ecl:brn byr:1985\n" +
            "\n" +
            "pid:340424924\n" +
            "eyr:2027 hcl:#7d3b0c\n" +
            "hgt:168cm ecl:hzl iyr:2016\n" +
            "byr:1994\n" +
            "\n" +
            "ecl:hzl byr:1933 pid:580425691\n" +
            "iyr:2010 hcl:#c0946f eyr:2024\n" +
            "hgt:64in\n" +
            "\n" +
            "hcl:#9fe6b0 pid:913184461 ecl:grn eyr:2030\n" +
            "cid:262 iyr:2014\n" +
            "\n" +
            "ecl:amb pid:640007768 eyr:2030 byr:2017 iyr:1988 hcl:z\n" +
            "\n" +
            "byr:1977 cid:54\n" +
            "eyr:1939 pid:882762394 iyr:2030 hcl:#ceb3a1 ecl:blu\n" +
            "\n" +
            "iyr:2011 hcl:#7d3b0c byr:1928\n" +
            "pid:340969354 cid:199 hgt:168cm eyr:2029 ecl:hzl\n" +
            "\n" +
            "pid:729464282\n" +
            "iyr:2012 hcl:baae60\n" +
            "eyr:2026 ecl:hzl hgt:166cm byr:2019\n" +
            "\n" +
            "pid:930997801 iyr:2019 eyr:2030\n" +
            "hcl:#866857 ecl:oth byr:1960 cid:235 hgt:73in\n" +
            "\n" +
            "ecl:brn\n" +
            "byr:1988 hgt:179cm iyr:2017\n" +
            "pid:864768439 cid:305 hcl:#c0946f\n" +
            "eyr:2029\n" +
            "\n" +
            "hcl:#7d3b0c ecl:grn\n" +
            "hgt:182cm eyr:2021 pid:719891314\n" +
            "byr:1920 iyr:2017\n" +
            "\n" +
            "hgt:62cm\n" +
            "cid:71 ecl:brn hcl:#fffffd iyr:2025 eyr:1997\n" +
            "pid:175cm byr:2022\n" +
            "\n" +
            "hcl:#cfa07d cid:239 eyr:2025 ecl:hzl hgt:189in byr:1980 iyr:2020\n" +
            "pid:703047050\n" +
            "\n" +
            "byr:1951\n" +
            "eyr:2030\n" +
            "ecl:hzl\n" +
            "pid:130992467 hgt:157cm hcl:#341e13\n" +
            "\n" +
            "hgt:175cm\n" +
            "hcl:#623a2f\n" +
            "cid:68 eyr:2025\n" +
            "byr:2001 ecl:oth pid:253618704 iyr:2016\n" +
            "\n" +
            "hcl:#fffffd pid:379344553 ecl:grn\n" +
            "eyr:2026\n" +
            "hgt:72in byr:1974 iyr:2013\n" +
            "\n" +
            "ecl:#b4e952 byr:1970 hcl:z\n" +
            "eyr:2039 pid:6056894636 iyr:2021 hgt:165cm\n" +
            "cid:328\n" +
            "\n" +
            "hcl:#602927 iyr:2014 pid:890429537 byr:1957 hgt:68in eyr:2020 ecl:hzl\n" +
            "\n" +
            "cid:265 byr:1961 hcl:#ceb3a1 eyr:2022 iyr:2016 hgt:184cm pid:921615309\n" +
            "\n" +
            "byr:1951 eyr:2024\n" +
            "hcl:#341e13\n" +
            "ecl:amb pid:414644982\n" +
            "iyr:2010 hgt:159cm\n" +
            "\n" +
            "iyr:2015 cid:319\n" +
            "eyr:2029 ecl:brn pid:380237898\n" +
            "hcl:#efcc98 hgt:157cm byr:1972\n" +
            "\n" +
            "pid:237156579 ecl:#312a91\n" +
            "hgt:167cm iyr:2011 hcl:#c0946f eyr:2021 byr:1953\n" +
            "\n" +
            "ecl:hzl iyr:2015 pid:10160221 eyr:2025 hgt:175cm hcl:z byr:1939\n" +
            "\n" +
            "hgt:59in hcl:#18171d byr:1962 ecl:hzl\n" +
            "iyr:2019 eyr:2025\n" +
            "cid:337 pid:491938615\n" +
            "\n" +
            "ecl:utc hgt:82 pid:51674655 byr:2020\n" +
            "eyr:1954 iyr:2029 hcl:z\n" +
            "\n" +
            "pid:119530189\n" +
            "cid:103\n" +
            "iyr:2010 byr:1979\n" +
            "hgt:168cm hcl:#a97842 ecl:brn eyr:2029\n" +
            "\n" +
            "hgt:177cm ecl:brn\n" +
            "byr:1990\n" +
            "pid:015089628 eyr:2028 hcl:#733820 iyr:2020\n" +
            "\n" +
            "ecl:blu iyr:2020 hgt:189cm\n" +
            "hcl:#efcc98 byr:1982 pid:346500376 eyr:2021 cid:160\n" +
            "\n" +
            "ecl:brn hgt:173cm iyr:2011 cid:259 hcl:#6b5442 eyr:2026\n" +
            "byr:1995\n" +
            "pid:654875035\n" +
            "\n" +
            "ecl:grn eyr:2025 pid:147155222 byr:1942\n" +
            "cid:341 hcl:#602927\n" +
            "hgt:165cm\n" +
            "iyr:2016\n" +
            "\n" +
            "pid:543171646\n" +
            "hgt:153cm\n" +
            "iyr:2019 hcl:#fffffd byr:1985 cid:266\n" +
            "eyr:2027\n" +
            "ecl:hzl\n" +
            "\n" +
            "ecl:blu\n" +
            "eyr:2022\n" +
            "pid:667939101 byr:1974\n" +
            "cid:259 hcl:#888785\n" +
            "\n" +
            "eyr:2030 byr:2016 iyr:2022\n" +
            "pid:86902982\n" +
            "ecl:zzz hgt:72 hcl:ceb867\n" +
            "\n" +
            "hcl:#fffffd\n" +
            "ecl:grn pid:046978329\n" +
            "byr:1924\n" +
            "eyr:2025 hgt:158cm iyr:2011\n" +
            "\n" +
            "hgt:150cm eyr:2028 byr:1985 ecl:gry hcl:#866857 pid:340615189\n" +
            "iyr:2017\n" +
            "cid:50\n" +
            "\n" +
            "cid:171 hcl:#18171d pid:009562218 byr:1981 hgt:175cm eyr:2024 ecl:oth iyr:2017\n" +
            "\n" +
            "iyr:2019\n" +
            "eyr:2022\n" +
            "ecl:brn hcl:#cfa07d pid:050270380 cid:159\n" +
            "hgt:151cm\n" +
            "byr:1951\n" +
            "\n" +
            "hcl:#7d3b0c hgt:176cm iyr:2015 byr:1923 pid:348188421 ecl:blu eyr:2029\n" +
            "\n" +
            "byr:1997 hgt:162cm eyr:2023 pid:445685977\n" +
            "iyr:2012 ecl:amb hcl:#efcc98\n" +
            "\n" +
            "iyr:2017 ecl:oth eyr:2028 pid:791977055 hgt:170cm byr:1991\n" +
            "hcl:#623a2f\n" +
            "\n" +
            "byr:1998 hcl:#fffffd\n" +
            "eyr:2020\n" +
            "ecl:gry pid:039483695 hgt:163cm iyr:2020\n" +
            "cid:165\n" +
            "\n" +
            "ecl:hzl hgt:74in iyr:2016 pid:026214321\n" +
            "cid:152 hcl:#a1f179\n" +
            "eyr:2036 byr:2001\n" +
            "\n" +
            "pid:257900949 cid:80 byr:1956 iyr:2012 hgt:165cm eyr:2030\n" +
            "\n" +
            "pid:918371363\n" +
            "ecl:xry\n" +
            "iyr:2012\n" +
            "byr:2012 hgt:65cm\n" +
            "eyr:2029\n" +
            "\n" +
            "pid:041789006 iyr:2018 byr:1945 eyr:2024 ecl:blu\n" +
            "hcl:#5ab31e hgt:171cm\n" +
            "\n" +
            "ecl:gry\n" +
            "byr:1956 cid:318 iyr:2020 hcl:#623a2f\n" +
            "eyr:2030 pid:020576506 hgt:184cm\n" +
            "\n" +
            "hgt:173cm iyr:2025\n" +
            "eyr:2023\n" +
            "ecl:amb pid:958983168 hcl:#866857 byr:1935\n" +
            "\n" +
            "byr:1974\n" +
            "eyr:2040 pid:57104308 iyr:1980 hcl:z\n" +
            "hgt:192in cid:295 ecl:amb\n" +
            "\n" +
            "pid:180cm hcl:1109f7 eyr:2039 byr:2020\n" +
            "ecl:dne hgt:189in iyr:1921\n" +
            "\n" +
            "iyr:2013 byr:1961\n" +
            "hcl:#866857\n" +
            "eyr:2025 hgt:158cm ecl:gry\n" +
            "\n" +
            "ecl:brn iyr:2013 eyr:2021 pid:978650418 byr:1980\n" +
            "hcl:#ceb3a1 cid:110\n" +
            "hgt:166cm\n" +
            "\n" +
            "pid:864880558 ecl:hzl hcl:#c0946f byr:1955 eyr:2027 hgt:169cm iyr:2011\n" +
            "\n" +
            "eyr:2023 hgt:191cm hcl:#866857\n" +
            "pid:454509887\n" +
            "ecl:grn byr:1938 iyr:2015\n" +
            "\n" +
            "pid:793008846 eyr:2025 ecl:grn hcl:#341e13\n" +
            "hgt:187cm\n" +
            "byr:1973 cid:224\n" +
            "iyr:2013\n" +
            "\n" +
            "hcl:#866857 eyr:2022 pid:802335395 hgt:171cm ecl:amb\n" +
            "iyr:2015 byr:1991\n" +
            "\n" +
            "hcl:#888785 pid:768625886\n" +
            "hgt:180cm\n" +
            "eyr:2026 ecl:oth cid:178 byr:1958\n" +
            "\n" +
            "pid:921387245 cid:82 hgt:190cm hcl:#c0946f ecl:grn\n" +
            "iyr:2015 eyr:2023\n" +
            "\n" +
            "pid:0704550258 hcl:1ba8f6 iyr:2010 byr:1978 cid:130\n" +
            "eyr:2030 ecl:dne hgt:66cm\n" +
            "\n" +
            "pid:626293279 hcl:#7d3b0c hgt:185cm ecl:oth\n" +
            "eyr:2020 byr:1937 iyr:2012\n" +
            "\n" +
            "hgt:175\n" +
            "eyr:1933 ecl:gry\n" +
            "hcl:#7d3b0c byr:2003 pid:#5d8fcc\n" +
            "iyr:2012\n" +
            "\n" +
            "eyr:2027\n" +
            "byr:1927 cid:154\n" +
            "ecl:gry pid:683668809 hgt:164cm\n" +
            "hcl:#a97842 iyr:2011\n" +
            "\n" +
            "byr:1940 iyr:2014 hgt:172cm eyr:2024 pid:033678324 hcl:#10fded\n" +
            "cid:292 ecl:oth\n" +
            "\n" +
            "iyr:1970 ecl:#201515 pid:#4cd485 eyr:2034 hgt:162\n" +
            "byr:2005 cid:67\n" +
            "hcl:#c0946f\n" +
            "\n" +
            "cid:306\n" +
            "byr:1948\n" +
            "hcl:#efcc98\n" +
            "eyr:2024 hgt:171cm pid:440657854 iyr:2015 ecl:brn\n" +
            "\n" +
            "hgt:172cm ecl:brn byr:1958 pid:054926969 hcl:#4b8065 iyr:2019\n" +
            "\n" +
            "pid:45977569 ecl:amb byr:2002 hgt:71cm hcl:z iyr:1983\n" +
            "\n" +
            "pid:811407848 hcl:#866857 cid:112 hgt:180cm byr:1986\n" +
            "ecl:brn eyr:2026\n" +
            "\n" +
            "ecl:amb\n" +
            "byr:1992\n" +
            "cid:288 pid:417117245 hcl:#623a2f\n" +
            "iyr:2011 hgt:181cm\n" +
            "eyr:2021\n" +
            "\n" +
            "byr:1974 hgt:192cm cid:172\n" +
            "eyr:2022\n" +
            "ecl:blu\n" +
            "hcl:#cfa07d iyr:2014\n" +
            "\n" +
            "eyr:2024 ecl:gry\n" +
            "pid:874569675 byr:1960 iyr:2017 hgt:186cm\n" +
            "hcl:#6b5442\n" +
            "\n" +
            "byr:1988 eyr:2024 iyr:2020 ecl:oth hcl:#866857 pid:227304269 hgt:170cm\n" +
            "\n" +
            "ecl:grn iyr:2019 byr:2002 cid:150 hcl:#efcc98\n" +
            "pid:600740993\n" +
            "hgt:167cm eyr:2027\n" +
            "\n" +
            "pid:553824537 iyr:2019 ecl:blu eyr:2025 hcl:#e21269 hgt:193cm\n" +
            "byr:1923\n" +
            "\n" +
            "byr:2030 iyr:2019 ecl:#cb0911\n" +
            "hcl:#cfa07d hgt:74in eyr:2012\n" +
            "pid:7647207386\n" +
            "\n" +
            "cid:289 hgt:128 pid:178cm iyr:2025 ecl:#4ad977 byr:2020 eyr:2036 hcl:#efcc98\n" +
            "\n" +
            "cid:119 hgt:150in\n" +
            "hcl:z\n" +
            "iyr:2012\n" +
            "ecl:brn eyr:1975\n" +
            "byr:2007 pid:#0dcd32\n" +
            "\n" +
            "hcl:8a1ce7 pid:0434291854\n" +
            "eyr:2034 iyr:2005\n" +
            "hgt:62cm byr:2029 ecl:utc\n" +
            "\n" +
            "ecl:gry hcl:#ceb3a1 byr:1976 eyr:2024 iyr:2010 hgt:188cm\n" +
            "pid:636312902\n" +
            "\n" +
            "hcl:#888785 byr:2027 hgt:178in iyr:2017 pid:973095872 eyr:1952\n" +
            "\n" +
            "hgt:179cm iyr:2015 hcl:#ceb3a1\n" +
            "byr:1944 pid:182079308 cid:317\n" +
            "eyr:2025 ecl:hzl\n" +
            "\n" +
            "hcl:#6b5442 ecl:grn eyr:2023 hgt:71in pid:829794667 byr:2000\n" +
            "iyr:2014 cid:192\n" +
            "\n" +
            "iyr:2014 pid:096659610 hcl:#c0946f ecl:oth byr:1991 cid:180\n" +
            "hgt:177cm\n" +
            "eyr:2023\n" +
            "\n" +
            "byr:2017\n" +
            "eyr:2036 iyr:1933\n" +
            "cid:225 ecl:gmt hgt:179in\n" +
            "hcl:b5c44d pid:99932231\n" +
            "\n" +
            "hcl:#18171d\n" +
            "hgt:187cm eyr:2023 byr:1934 cid:286 pid:878541119 iyr:2020 ecl:amb\n" +
            "\n" +
            "hgt:185cm\n" +
            "pid:754207134 ecl:oth eyr:2023\n" +
            "hcl:#a97842 cid:313 byr:1966\n" +
            "iyr:2015\n" +
            "\n" +
            "hcl:#ceb3a1 byr:1921 eyr:2022 pid:799265846 cid:285\n" +
            "hgt:67in iyr:2015\n" +
            "\n" +
            "iyr:2011 byr:1941\n" +
            "hcl:#341e13 cid:65 pid:413556937\n" +
            "hgt:169cm\n" +
            "ecl:amb eyr:2020\n" +
            "\n" +
            "iyr:2016\n" +
            "hgt:158cm ecl:grn byr:1931 hcl:#7d3b0c\n" +
            "\n" +
            "pid:574299170 iyr:2013 byr:1961 ecl:hzl hcl:#866857 hgt:168cm eyr:2022\n" +
            "\n" +
            "eyr:2022 pid:245416405\n" +
            "iyr:2019 hgt:173cm hcl:#c0946f\n" +
            "ecl:brn\n" +
            "byr:1965\n" +
            "\n" +
            "byr:1980 hgt:162cm ecl:brn pid:239318191\n" +
            "hcl:#fffffd\n" +
            "cid:58 eyr:2025 iyr:2020\n" +
            "\n" +
            "pid:892646915\n" +
            "iyr:2012 hcl:#733820 byr:1991 eyr:2021\n" +
            "hgt:157cm ecl:oth\n" +
            "\n" +
            "pid:310597466 eyr:2025\n" +
            "hcl:#cfa07d byr:1944 iyr:2018 ecl:oth\n" +
            "hgt:183cm\n" +
            "\n" +
            "iyr:2010 hgt:187cm ecl:oth\n" +
            "pid:975763328\n" +
            "hcl:#866857 eyr:2023 cid:283 byr:1997\n" +
            "\n" +
            "iyr:2020 cid:225 hcl:#efcc98 pid:424680047 ecl:blu\n" +
            "hgt:154cm\n" +
            "byr:1968 eyr:2027\n" +
            "\n" +
            "ecl:oth eyr:2020 hgt:183cm hcl:#623a2f\n" +
            "pid:771851807\n" +
            "byr:1990\n" +
            "iyr:2017\n" +
            "\n" +
            "hcl:#efcc98 ecl:blu byr:1991 hgt:191cm pid:266021118\n" +
            "cid:124\n" +
            "eyr:2025\n" +
            "\n" +
            "byr:1993\n" +
            "ecl:hzl eyr:2020\n" +
            "hgt:163cm\n" +
            "iyr:2015 pid:831538073 hcl:#18171d\n" +
            "\n" +
            "hgt:74in hcl:#420afb eyr:2028\n" +
            "ecl:grn pid:264469103\n" +
            "byr:1993\n" +
            "\n" +
            "eyr:2020\n" +
            "cid:79\n" +
            "byr:1972\n" +
            "pid:084953331 hcl:#a97842 ecl:brn iyr:2010\n" +
            "hgt:170cm\n" +
            "\n" +
            "iyr:2014 ecl:gry pid:094812116 eyr:2026 hgt:190cm byr:1965 hcl:#944667\n" +
            "\n" +
            "hcl:#fffffd byr:1953 iyr:2014 ecl:hzl hgt:164cm\n" +
            "cid:123 eyr:2023 pid:546394433\n" +
            "\n" +
            "iyr:2012 hgt:155cm byr:1998 pid:#2c9be6 eyr:2023 hcl:#ceb3a1 ecl:gry\n" +
            "\n" +
            "eyr:2029 ecl:gry pid:752489331 iyr:2015 hgt:167cm hcl:#18171d cid:70 byr:2002\n" +
            "\n" +
            "byr:1938\n" +
            "ecl:gry\n" +
            "pid:764937909 iyr:2014\n" +
            "hcl:#7d3b0c\n" +
            "eyr:2022 cid:145 hgt:184cm\n" +
            "\n" +
            "cid:340\n" +
            "byr:1924 hgt:169cm eyr:2026\n" +
            "iyr:2013 ecl:amb\n" +
            "pid:499844992 hcl:#18171d\n" +
            "\n" +
            "pid:838417672 hgt:175cm\n" +
            "ecl:grt iyr:2017 eyr:2025 hcl:17aa1a\n" +
            "\n" +
            "eyr:2020\n" +
            "byr:1925 hcl:#341e13\n" +
            "ecl:brn cid:342 pid:047426814 hgt:156cm iyr:2012\n" +
            "\n" +
            "iyr:2011 hcl:#341e13 byr:1959\n" +
            "ecl:amb pid:969679865\n" +
            "\n" +
            "byr:1978 cid:320 hgt:180cm hcl:#435ceb pid:363518544 eyr:2023 iyr:2016 ecl:blu\n" +
            "\n" +
            "iyr:2010 eyr:2028\n" +
            "pid:183cm byr:1948\n" +
            "ecl:oth cid:133\n" +
            "hcl:#8d3298 hgt:190cm\n" +
            "\n" +
            "hcl:#6b5442 byr:1929 iyr:2019 pid:207713865 eyr:2029\n" +
            "hgt:166cm ecl:gry\n" +
            "\n" +
            "ecl:blu iyr:2019\n" +
            "byr:1985 eyr:2030 hcl:#866857 hgt:155cm pid:659180287\n" +
            "\n" +
            "ecl:hzl\n" +
            "eyr:2020 iyr:2016 pid:440624039\n" +
            "cid:147\n" +
            "hgt:61in byr:1976 hcl:#733820\n" +
            "\n" +
            "hcl:#341e13 pid:178082907 eyr:2023\n" +
            "iyr:2015 byr:1956\n" +
            "ecl:amb hgt:163cm\n" +
            "\n" +
            "eyr:2023\n" +
            "iyr:2011 hcl:#cfa07d hgt:164cm\n" +
            "pid:291621559 byr:1960 ecl:gry\n" +
            "\n" +
            "hcl:#efcc98 byr:1976\n" +
            "iyr:2017 pid:394566091 cid:248\n" +
            "hgt:176cm ecl:hzl eyr:2026\n" +
            "\n" +
            "iyr:2013 eyr:2029 hgt:152cm ecl:gry byr:1984 hcl:#623a2f pid:511780941\n" +
            "\n" +
            "pid:953716819 iyr:2010 hgt:156cm ecl:amb\n" +
            "byr:1947\n" +
            "hcl:#18171d eyr:2025\n" +
            "\n" +
            "eyr:2025 ecl:amb\n" +
            "iyr:2016\n" +
            "hcl:#cfa07d byr:1925 pid:322787273 hgt:168cm\n" +
            "\n" +
            "hgt:59in iyr:2012\n" +
            "pid:916978929 byr:1959\n" +
            "hcl:#c0946f eyr:2021\n" +
            "ecl:brn\n" +
            "\n" +
            "byr:2018 eyr:1929 hgt:187in\n" +
            "hcl:z\n" +
            "iyr:2003 pid:0377361331 ecl:utc\n" +
            "\n" +
            "byr:1949 hcl:#fffffd pid:071791776 eyr:2030 iyr:2015 hgt:71in ecl:hzl\n" +
            "\n" +
            "hcl:#341e13\n" +
            "hgt:154cm byr:1927 eyr:2023 ecl:blu iyr:2017\n" +
            "pid:639867283\n" +
            "\n" +
            "hcl:z pid:315276249 byr:2026\n" +
            "hgt:151cm\n" +
            "iyr:2028 eyr:2020\n" +
            "ecl:hzl\n" +
            "\n" +
            "hcl:#341e13 eyr:2027 byr:1981 cid:342 pid:999898177 hgt:187cm\n" +
            "ecl:blu iyr:2011\n" +
            "\n" +
            "byr:2009\n" +
            "hgt:73cm iyr:1921 hcl:z\n" +
            "pid:181cm\n" +
            "ecl:xry\n" +
            "\n" +
            "ecl:hzl\n" +
            "byr:1925\n" +
            "pid:034183103 hcl:#341e13 hgt:158cm eyr:2029 iyr:2010\n" +
            "\n" +
            "byr:1976\n" +
            "iyr:2011 hgt:177cm pid:833479839 hcl:#dcab9d ecl:blu eyr:2020\n" +
            "\n" +
            "cid:230 hcl:#7d3b0c byr:1954\n" +
            "iyr:2014 eyr:2026 pid:122150889\n" +
            "ecl:brn hgt:182cm\n" +
            "\n" +
            "hcl:#a97842\n" +
            "ecl:brn hgt:187cm\n" +
            "eyr:2028\n" +
            "pid:427631634 iyr:2002 byr:2004\n" +
            "\n" +
            "pid:912516995 ecl:hzl iyr:2017 hcl:#ceb3a1 byr:1929 eyr:2028\n" +
            "hgt:155cm\n" +
            "\n" +
            "pid:019809181\n" +
            "cid:128 iyr:2013 hcl:#f5b9f7 byr:1931\n" +
            "hgt:161cm\n" +
            "ecl:amb\n" +
            "\n" +
            "hgt:64in byr:1924\n" +
            "iyr:2016 eyr:2029 ecl:hzl pid:474940085 hcl:#c0946f\n" +
            "\n" +
            "pid:172419213\n" +
            "ecl:grn\n" +
            "hgt:193cm iyr:2010 byr:1973 hcl:#6b5442\n" +
            "eyr:2027\n" +
            "\n" +
            "ecl:#7b5cfd iyr:2019\n" +
            "byr:2016\n" +
            "eyr:2040 hgt:191in\n" +
            "cid:187 hcl:z pid:#c61084\n" +
            "\n" +
            "eyr:2032 iyr:2014 pid:430247344 byr:1967\n" +
            "hcl:#ceb3a1\n" +
            "cid:241\n" +
            "ecl:brn hgt:178in\n" +
            "\n" +
            "hcl:#623a2f iyr:2017 cid:235\n" +
            "eyr:2020 byr:1978 ecl:blu hgt:175cm\n" +
            "\n" +
            "iyr:2013 ecl:amb hgt:174cm hcl:#866857 pid:285533942 byr:1954\n" +
            "\n" +
            "hgt:152cm ecl:blu pid:952587262 eyr:2024\n" +
            "iyr:2019 cid:268 hcl:#602927 byr:1947\n" +
            "\n" +
            "hgt:176in cid:245 byr:2011 iyr:2018\n" +
            "eyr:1987\n" +
            "hcl:z\n" +
            "pid:346518170\n" +
            "ecl:utc\n" +
            "\n" +
            "hgt:180cm\n" +
            "iyr:2015 ecl:brn eyr:2027 pid:807494368 cid:324 byr:1980\n" +
            "\n" +
            "byr:1936 hcl:#866857 ecl:blu\n" +
            "eyr:2021 hgt:187cm\n" +
            "iyr:2016 pid:244556968\n" +
            "\n" +
            "byr:1950 cid:125\n" +
            "iyr:2020 hgt:168cm hcl:#c0946f eyr:2030 pid:758313758 ecl:blu\n" +
            "\n" +
            "eyr:2021\n" +
            "pid:618915663 hcl:#cfa07d iyr:2018 byr:2002\n" +
            "hgt:157cm ecl:blu\n" +
            "\n" +
            "byr:1967\n" +
            "ecl:brn hcl:#c0946f pid:200495802 eyr:2021 iyr:2020\n" +
            "cid:335\n" +
            "hgt:181cm\n" +
            "\n" +
            "byr:1996\n" +
            "ecl:brn iyr:2015\n" +
            "eyr:2030\n" +
            "hcl:#fffffd cid:207\n" +
            "pid:022460311 hgt:158cm\n" +
            "\n" +
            "eyr:2022 hgt:59cm iyr:2023\n" +
            "byr:1974 pid:354098699 hcl:b244f7\n" +
            "ecl:#219505\n" +
            "\n" +
            "hcl:#866857 eyr:2025\n" +
            "pid:370874666\n" +
            "byr:1947\n" +
            "cid:162 ecl:oth hgt:186cm iyr:2011\n" +
            "\n" +
            "ecl:hzl eyr:2029\n" +
            "byr:1981\n" +
            "iyr:2012 pid:433430792 cid:252\n" +
            "hgt:171cm\n" +
            "\n" +
            "pid:512473844 hgt:186cm iyr:2012 eyr:2028 byr:1949 ecl:hzl hcl:#18171d\n" +
            "\n" +
            "hgt:60cm iyr:1934\n" +
            "ecl:#4a4017 pid:3067366202 hcl:1161df\n" +
            "eyr:1938 byr:2008\n" +
            "\n" +
            "pid:119509757 hcl:#cfa07d eyr:2022 hgt:174cm byr:1983\n" +
            "iyr:2015\n" +
            "ecl:blu\n" +
            "\n" +
            "byr:1955 eyr:2023\n" +
            "cid:114\n" +
            "hcl:f1aa8a pid:609049659 ecl:grn hgt:177cm\n" +
            "iyr:2015\n" +
            "\n" +
            "eyr:2027 cid:284\n" +
            "pid:654627982 byr:1964 iyr:2018 hgt:168cm\n" +
            "hcl:#fffffd ecl:oth\n" +
            "\n" +
            "iyr:1988\n" +
            "hgt:191cm hcl:b87a62 byr:1990 ecl:xry\n" +
            "pid:996624367 eyr:1960\n" +
            "\n" +
            "pid:641466821 eyr:2028 hcl:#7d3b0c\n" +
            "iyr:2010 hgt:175cm ecl:gry\n" +
            "\n" +
            "hcl:#b6652a\n" +
            "ecl:oth\n" +
            "byr:1926 eyr:2030 iyr:2019 hgt:183cm\n" +
            "pid:057196056\n" +
            "\n" +
            "iyr:2017\n" +
            "eyr:2022 pid:936841429\n" +
            "ecl:blu hcl:#6b5442 cid:179 byr:1927 hgt:161cm\n" +
            "\n" +
            "eyr:2021\n" +
            "cid:289 hgt:174cm iyr:2013\n" +
            "ecl:grn pid:329574701 byr:1970\n" +
            "\n" +
            "eyr:2021 byr:1939 ecl:gry pid:933505139 iyr:2014 hgt:173cm hcl:#7d3b0c\n" +
            "\n" +
            "cid:116 hcl:045bff eyr:2030 iyr:1920\n" +
            "ecl:brn\n" +
            "byr:2030\n" +
            "pid:#38f7f3\n" +
            "hgt:155in\n" +
            "\n" +
            "eyr:2028\n" +
            "pid:225829241 byr:1928 hcl:#cfa07d iyr:2019\n" +
            "ecl:oth\n" +
            "hgt:166cm\n" +
            "\n" +
            "cid:80 byr:1936\n" +
            "iyr:2017\n" +
            "hgt:94 hcl:#2e7503 ecl:oth eyr:2030\n" +
            "pid:597284996\n" +
            "\n" +
            "ecl:oth\n" +
            "iyr:2019 hgt:76in\n" +
            "byr:1956 pid:821874039\n" +
            "\n" +
            "eyr:2026 hgt:168cm\n" +
            "pid:019015588\n" +
            "iyr:2010\n" +
            "ecl:amb byr:2009 hcl:#623a2f cid:159\n" +
            "\n" +
            "iyr:1980 hgt:167in\n" +
            "pid:380644909 eyr:1966 ecl:blu byr:2004 hcl:z\n" +
            "\n" +
            "eyr:2020 iyr:2013\n" +
            "hcl:#08ad66 pid:540886868\n" +
            "ecl:oth byr:1980 hgt:158cm\n" +
            "\n" +
            "eyr:2026 hgt:186cm byr:1995\n" +
            "cid:275\n" +
            "hcl:z iyr:1958 ecl:blu\n" +
            "\n" +
            "eyr:2026 iyr:2012\n" +
            "hgt:61in byr:1936 pid:390833536 cid:298 ecl:grn hcl:#623a2f\n" +
            "\n" +
            "pid:393878498 eyr:2023 ecl:gry byr:1943 iyr:2010 hcl:#888785 hgt:158cm\n" +
            "\n" +
            "hgt:191cm cid:197 iyr:2014 byr:1945\n" +
            "hcl:#fffffd\n" +
            "eyr:2020\n" +
            "pid:183948344 ecl:amb\n" +
            "\n" +
            "ecl:gmt hgt:88\n" +
            "cid:260 iyr:2024 byr:2022 eyr:2031 hcl:z pid:#532c6e\n" +
            "\n" +
            "hcl:#a97842\n" +
            "hgt:160cm eyr:2024 ecl:blu iyr:2015 byr:1970\n" +
            "\n" +
            "byr:1964 hgt:178cm\n" +
            "eyr:2025\n" +
            "pid:813643223 ecl:brn iyr:2014\n" +
            "hcl:#ceb3a1\n" +
            "\n" +
            "byr:1965 eyr:2024 iyr:2018\n" +
            "hgt:165cm hcl:#18171d ecl:grn pid:475669993\n" +
            "\n" +
            "hgt:116\n" +
            "iyr:2024 eyr:1974 hcl:504345 byr:2010 cid:206 pid:166cm ecl:zzz\n" +
            "\n" +
            "iyr:2014 eyr:2020 pid:096460673 byr:1948\n" +
            "hgt:153cm\n" +
            "ecl:blu hcl:#341e13\n" +
            "\n" +
            "hcl:#ceb3a1\n" +
            "iyr:2017 hgt:67cm\n" +
            "pid:178cm byr:2028 ecl:brn\n" +
            "cid:293\n" +
            "\n" +
            "hgt:157cm\n" +
            "hcl:#602927 byr:1941\n" +
            "iyr:2012 pid:611003211 eyr:2029\n" +
            "\n" +
            "iyr:2019 byr:2000 pid:083917767 eyr:2024 hgt:172cm\n" +
            "cid:248 hcl:#7e4d15\n" +
            "\n" +
            "byr:1946\n" +
            "hgt:160cm iyr:2020 hcl:#559278 pid:989139577\n" +
            "ecl:amb eyr:2020\n" +
            "\n" +
            "pid:165cm byr:1927 cid:178 hcl:#733820 iyr:2017 hgt:156in\n" +
            "eyr:2029 ecl:brn\n" +
            "\n" +
            "hcl:#18171d hgt:163cm eyr:2022 byr:1962 pid:639124940 cid:258 ecl:hzl\n" +
            "iyr:2015\n" +
            "\n" +
            "cid:123 pid:4542006033\n" +
            "eyr:1987 byr:2010 iyr:2029 ecl:amb\n" +
            "hgt:191cm hcl:#18171d\n" +
            "\n" +
            "hcl:z\n" +
            "byr:1928 iyr:1965\n" +
            "eyr:2022 hgt:75 ecl:oth pid:400765046\n" +
            "\n" +
            "hcl:#c0946f hgt:62in\n" +
            "ecl:blu byr:1978 iyr:1923\n" +
            "cid:260 eyr:2021 pid:404628742\n" +
            "\n" +
            "pid:#bf1611 ecl:grn\n" +
            "iyr:2018 cid:146 byr:1948\n" +
            "eyr:2025 hcl:#fffffd hgt:87\n" +
            "\n" +
            "pid:767547618\n" +
            "iyr:2018 hcl:#b6652a eyr:2029 hgt:165cm ecl:hzl byr:1937\n" +
            "\n" +
            "ecl:blu iyr:2019 pid:960083875 eyr:2027 hgt:71in hcl:#c0946f\n" +
            "byr:1921\n" +
            "\n" +
            "iyr:2011\n" +
            "pid:9562042482\n" +
            "hcl:z hgt:59cm\n" +
            "eyr:1994 cid:258 ecl:#6c1bcc byr:2025\n" +
            "\n" +
            "eyr:2028 pid:494999718 byr:1928 hgt:176cm\n" +
            "iyr:2015 ecl:oth hcl:#733820\n" +
            "\n" +
            "cid:78 eyr:2020 hgt:160cm byr:1947 ecl:blu\n" +
            "hcl:#b6652a iyr:2016 pid:069457741\n" +
            "\n" +
            "hcl:#6b5442 iyr:2010\n" +
            "byr:1971\n" +
            "eyr:2028 hgt:169cm ecl:brn pid:528961949\n" +
            "\n" +
            "eyr:2028\n" +
            "hcl:#7d3b0c\n" +
            "byr:1952\n" +
            "ecl:hzl\n" +
            "cid:317 iyr:2016\n" +
            "pid:832169844\n" +
            "\n" +
            "hcl:#c0946f\n" +
            "ecl:brn\n" +
            "iyr:2017 eyr:2028\n" +
            "pid:161390075 byr:1993 cid:50\n" +
            "hgt:171cm\n" +
            "\n" +
            "ecl:#ae12d3 hgt:74cm cid:239 hcl:z pid:345439730 iyr:1924 byr:2029 eyr:2031\n";

    private static final Set<String> REQ_TAGS = new HashSet<>(Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
    private static final Set<String> REQ_HCL_CHARS = new HashSet<>(Arrays.asList(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"));
    private static final Set<String> REQ_ECL_VALUES = new HashSet<>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));

    public static void main(String[] args) {
        int valid = 0;
        for (String passport : INPUT.split("\n\n")) {
            int tagCount = 0;
            Map<String, String> kvMap = new HashMap<>();
            for (String kvs : passport.split("\\s+")) {
                String k = kvs.split(":")[0];
                kvMap.put(k, kvs.split(":")[1]);
                if (REQ_TAGS.contains(k)) {
                    tagCount++;
                }
            }
            if (tagCount == REQ_TAGS.size()) {
                String byr = kvMap.get("byr");
                if (byr.length() != 4) {
                    continue;
                }
                try {
                    int byrInt = Integer.parseInt(byr);
                    if (byrInt < 1920 || byrInt > 2002) {
                        continue;
                    }
                } catch (Exception e) {
                    continue;
                }

                String iyr = kvMap.get("iyr");
                if (iyr.length() != 4) {
                    continue;
                }
                try {
                    int iyrInt = Integer.parseInt(iyr);
                    if (iyrInt < 2010 || iyrInt > 2020) {
                        continue;
                    }
                } catch (Exception e) {
                    continue;
                }

                String eyr = kvMap.get("eyr");
                if (eyr.length() != 4) {
                    continue;
                }
                try {
                    int eyrInt = Integer.parseInt(eyr);
                    if (eyrInt < 2020 || eyrInt > 2030) {
                        continue;
                    }
                } catch (Exception e) {
                    continue;
                }

                String hgt = kvMap.get("hgt");
                if (hgt.endsWith("cm")) {
                    try {
                        int hgtInt = Integer.parseInt(hgt.substring(0, hgt.length()-2));
                        if (hgtInt < 150 || hgtInt > 193) {
                            continue;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                } else if (hgt.endsWith("in")) {
                    try {
                        int hgtInt = Integer.parseInt(hgt.substring(0, hgt.length()-2));
                        if (hgtInt < 59 || hgtInt > 76) {
                            continue;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                } else {
                    continue;
                }

                String hcl = kvMap.get("hcl");
                if (!hcl.startsWith("#")) {
                    continue;
                }
                hcl = hcl.substring(1);
                if (hcl.length() != 6) {
                    continue;
                }
                boolean ok = true;
                for (int i = 0; i < hcl.length(); i++) {
                    if (!REQ_HCL_CHARS.contains(Character.toString(hcl.charAt(i)))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    continue;
                }

                String ecl = kvMap.get("ecl");
                if (!REQ_ECL_VALUES.contains(ecl)) {
                    continue;
                }

                String pid = kvMap.get("pid");
                if (pid.length() != 9) {
                    continue;
                }
                try {
                    int pidInt = Integer.parseInt(pid);
                } catch (Exception e) {
                    continue;
                }

                valid++;
            }
        }
        System.out.println(valid);
    }
}
