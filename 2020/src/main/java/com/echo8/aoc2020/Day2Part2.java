package com.echo8.aoc2020;

import java.util.Arrays;
import java.util.List;

public class Day2Part2 {
    private static final String INPUT = "2-6 c: fcpwjqhcgtffzlbj\n" +
            "6-9 x: xxxtwlxxx\n" +
            "5-6 w: wwwwlwwwh\n" +
            "7-10 q: nfbrgwqlvljgq\n" +
            "2-3 g: gjggg\n" +
            "9-11 q: qqqqqqnqgqq\n" +
            "14-20 b: bbbbbbbbbbbbzwbbbbbb\n" +
            "2-6 s: sjsssss\n" +
            "4-13 b: mdbctbzgcpdjbhsdctrd\n" +
            "5-6 t: tttttt\n" +
            "7-9 h: zbhhfmwhhpxh\n" +
            "3-4 t: ttmt\n" +
            "4-6 j: jjjjjj\n" +
            "12-13 w: wwwwwwwwwwwwkw\n" +
            "3-4 f: sgbmjfftf\n" +
            "11-12 p: pdppppppppcppp\n" +
            "5-9 q: qqqqqvsqdjq\n" +
            "5-8 j: qsljqmxwk\n" +
            "1-7 w: gwvktwwwkwwww\n" +
            "2-3 w: gvwcvrggjbk\n" +
            "1-4 d: kddd\n" +
            "13-14 k: zkkpkkkkkksskp\n" +
            "2-5 w: wwwwfw\n" +
            "4-5 n: bnrnlnnkdvhbnnj\n" +
            "7-17 s: kswscfssbssztsgwmdr\n" +
            "9-14 h: hhhhhhhvhhhhhbhhhhh\n" +
            "1-2 s: sgvmzrpssss\n" +
            "1-4 x: xxvgbxwxqx\n" +
            "5-9 b: bbbbbbqbdbbzbxb\n" +
            "6-10 d: ndddkqdddd\n" +
            "8-9 z: zzqvkhpzzhx\n" +
            "10-11 k: jrktpgkvkqk\n" +
            "2-4 l: lklf\n" +
            "14-16 c: cxqccccccccccctccc\n" +
            "1-2 g: bsmmpkmd\n" +
            "4-16 q: vmqdqktlqqnhzqqx\n" +
            "6-12 k: kqkwkktfbklkjnkqrtmb\n" +
            "15-16 v: vvvvvvvvvvvvvvxt\n" +
            "12-13 r: rrrrrrsrrrrrx\n" +
            "5-7 p: ppbqlppppp\n" +
            "5-8 s: dxmsqssk\n" +
            "3-4 m: mxmlmm\n" +
            "6-7 c: kcfcbhcc\n" +
            "4-6 z: zzzxzxz\n" +
            "12-14 r: rrrrmrrrrrrrrkkltr\n" +
            "4-6 j: zhbtgg\n" +
            "5-7 r: rrdrrrzrr\n" +
            "1-3 x: rxcxxxxxxxxxxxxx\n" +
            "5-7 g: ggggggvgmcg\n" +
            "12-15 n: nnnnnnnnnnnnnnhn\n" +
            "4-6 p: qppppppp\n" +
            "9-12 j: pjjsmbjjjjjj\n" +
            "3-16 b: bhgbtjhqvkpgcbgbpbz\n" +
            "2-7 q: mqfhknwswqjxjncxjt\n" +
            "6-16 c: wclpphqjcmbzdwccp\n" +
            "13-15 k: dkkdkkkkkkkknkkcn\n" +
            "7-9 b: blfbbbhvz\n" +
            "14-18 w: wwwwwwwvwvwwwwwwwc\n" +
            "11-18 w: xstwwbwwwwwwtrbwww\n" +
            "3-14 z: zdgxzpvzjztfzzrpjz\n" +
            "7-10 j: mjrxjstdnj\n" +
            "10-13 f: ffrfqflffftjkf\n" +
            "1-4 j: jnjtjfj\n" +
            "8-9 g: wtbqjjggjfcvgs\n" +
            "2-7 z: qpwvvjcpzf\n" +
            "3-4 k: kfgk\n" +
            "6-12 l: lllllllllllw\n" +
            "14-15 n: nnnnnnnnnnnnnpr\n" +
            "10-11 p: prcpwdzmcqp\n" +
            "12-14 v: vvvrvvvqvvvschvvzvv\n" +
            "1-11 q: jqqqkfqqqqqqqqwqq\n" +
            "11-12 j: jjjjjjjjjjtj\n" +
            "2-6 x: nqxxxx\n" +
            "7-17 s: blbvqsssssssnslgswz\n" +
            "9-10 s: ssssssssbsss\n" +
            "1-2 t: ttvqtt\n" +
            "3-8 w: bsddhgwb\n" +
            "1-2 r: jrxdfg\n" +
            "8-9 j: ljjjjjjljfmj\n" +
            "1-3 j: jjjjjjjjjdkjj\n" +
            "4-13 f: jfffmsffmfxrmhnf\n" +
            "1-4 s: sswvjx\n" +
            "4-8 b: btfgtwkvdfqkwv\n" +
            "2-3 p: tptddqdkgdfcbxxrpv\n" +
            "1-4 p: dspz\n" +
            "14-16 d: ddddhdvdddddtddh\n" +
            "6-9 l: hnvrpllsl\n" +
            "4-5 h: hjhzhnh\n" +
            "3-10 b: zsvjzttjnbbgdt\n" +
            "12-15 c: ccjscwcccdcccccl\n" +
            "1-9 j: xjjjkjjlj\n" +
            "1-9 m: gngmvxqmmmmhmmml\n" +
            "9-10 k: kkkkkkkkpc\n" +
            "13-14 q: qrsxtpgpnhcrkq\n" +
            "3-6 k: pkjcks\n" +
            "1-3 t: ttjtt\n" +
            "10-15 f: sjwnfftrffptbqltg\n" +
            "3-4 b: nwbtnz\n" +
            "5-7 k: kkkkkkdk\n" +
            "14-18 l: lglllllllllllllllrpl\n" +
            "1-14 q: fqqqqqqdqqqqvd\n" +
            "16-18 p: pppppppppppppppppn\n" +
            "3-7 l: lllllgvx\n" +
            "2-5 b: pbbkcbbbbbg\n" +
            "7-9 c: bcnjkzxccl\n" +
            "4-5 x: cwxxfxtmqtxxp\n" +
            "10-11 d: dddddwcxdvddbdddd\n" +
            "3-5 v: vvvvlvv\n" +
            "4-7 m: mmmmmltldmmmbk\n" +
            "13-14 s: sssssssssssssks\n" +
            "4-6 s: ssslszs\n" +
            "15-16 z: dzbzfxmpzhrrszzf\n" +
            "5-12 x: xrzxxxgxtcxxxxxx\n" +
            "17-19 g: ggggggggggggggxwjgq\n" +
            "12-13 n: nnnnnnhnnnnjn\n" +
            "8-10 l: llllllltllldlll\n" +
            "9-14 t: fttftqttmtkstdf\n" +
            "4-11 l: nnlljlhllllx\n" +
            "5-7 q: qhpzqjl\n" +
            "2-6 v: fglnsvvwlpx\n" +
            "2-3 b: mbvbb\n" +
            "4-9 w: wwqwwwjwmz\n" +
            "1-4 j: jjxpmsk\n" +
            "6-8 c: pckczdcccncr\n" +
            "3-6 x: xbslxxzhqn\n" +
            "11-17 j: jdkjkjjjjbjxjjjjsj\n" +
            "4-8 h: hphbzhjh\n" +
            "12-14 x: xxxxxrxxxxxxxrx\n" +
            "2-4 q: kqgm\n" +
            "1-14 r: lrtrzrrrsrrzrr\n" +
            "5-15 w: tpwwwbdlbxczwcgwnvbw\n" +
            "1-4 p: qppsppp\n" +
            "1-9 z: zzzzzzzzzzzzzz\n" +
            "8-12 t: tttttttbttst\n" +
            "2-3 n: bkfn\n" +
            "5-8 w: xwwwwwwdw\n" +
            "9-10 c: csdccccqcgcbxcn\n" +
            "3-5 v: mvfvvqvvm\n" +
            "2-5 r: rrstrnzfrdwrvbpfqz\n" +
            "1-4 m: mmmmmmmmmmmmmmmmm\n" +
            "8-9 m: mmmmmmmmg\n" +
            "3-6 l: llllll\n" +
            "3-5 j: jjgjft\n" +
            "10-11 b: xtlppqfbnkq\n" +
            "15-17 p: pppxpppfppppppppb\n" +
            "7-8 f: ffbmfffd\n" +
            "6-11 t: htgvbttnjzpkt\n" +
            "5-6 t: tvttwt\n" +
            "8-10 b: bbqbrtbrbb\n" +
            "6-10 x: xxspxkxmpxxxvrcxx\n" +
            "3-6 f: lgrxkfrfkfj\n" +
            "1-7 f: fffffftf\n" +
            "5-6 t: rcjtqtwvgsttc\n" +
            "12-13 k: kkmgwdjmgpkkgrkk\n" +
            "1-13 w: dwdwzlwxrtvhwwhmwj\n" +
            "3-13 n: nnwnnnnnnnfnnnnn\n" +
            "9-10 j: kbjjcsjtjn\n" +
            "17-18 v: vvvvvvvvvvvvvvvvvh\n" +
            "11-17 z: zzqkzzzzdzhzgzzzvzz\n" +
            "7-11 f: nrdftjqffff\n" +
            "3-8 t: tttttttctt\n" +
            "4-5 r: rrcrwrf\n" +
            "5-7 c: ccqccccccc\n" +
            "13-14 r: rrdrrrfrrrrrhrr\n" +
            "9-12 s: xjddslskrjpd\n" +
            "8-9 n: nnnpgnnbnnnn\n" +
            "6-10 j: wjjdjjjjjpjjjj\n" +
            "1-7 z: hzzzzzzzz\n" +
            "4-7 b: bbbzbbbxlb\n" +
            "4-13 t: tttqnttttkxtt\n" +
            "6-9 h: vhphhzhhshh\n" +
            "2-10 p: bpfwnncsmtppppsq\n" +
            "3-19 n: dnklnrnnnnfnnnngndn\n" +
            "5-15 n: nnnnknnnnnnnnnsnnnn\n" +
            "6-8 t: trttttwv\n" +
            "8-12 m: mtmmbkmxmjdjmmmtm\n" +
            "2-8 k: kjkkkkkkkk\n" +
            "6-8 n: xrnmndqn\n" +
            "13-16 n: nnnnnnnnnnnndnnnnnn\n" +
            "14-15 c: cswjctfcccrccxc\n" +
            "2-9 k: knkkkkkkj\n" +
            "5-12 r: rxrfwrdrcmdr\n" +
            "6-11 v: vxwsnvnxvgs\n" +
            "12-13 n: nnnnnnnnprnnmn\n" +
            "1-3 l: blbz\n" +
            "4-7 h: hhhbhhh\n" +
            "8-12 m: mqhrnmzmmmmmm\n" +
            "6-15 n: nnnnnpnnnbnnnnzn\n" +
            "3-6 q: lzjcxqpmjqsbqgxjql\n" +
            "6-7 q: qqqnqrq\n" +
            "5-7 q: qtlhqct\n" +
            "3-5 q: qlxmq\n" +
            "2-3 n: knnn\n" +
            "4-5 z: zzzzh\n" +
            "4-9 r: rrrwlprfrlrnpzrrmwt\n" +
            "14-15 j: fchdfjzmdrjxrxj\n" +
            "1-4 m: dmmm\n" +
            "2-4 x: wxkmpxn\n" +
            "5-11 r: rvblrrjkvrsbr\n" +
            "1-2 c: ntcmkz\n" +
            "14-16 h: hhhhhhhhhhfhhhhhhh\n" +
            "1-3 h: cnsvhm\n" +
            "4-5 w: wwwww\n" +
            "7-10 j: jjjjjjjjjsjjj\n" +
            "9-14 j: zjjjjjjjkjjjjwj\n" +
            "12-13 k: nqwkrcpkkkkkkk\n" +
            "3-5 k: vxkkj\n" +
            "6-7 j: pjjjtjpjjjw\n" +
            "2-3 j: jjsg\n" +
            "4-5 g: ggggcg\n" +
            "3-5 b: wbbnvxw\n" +
            "2-4 h: gwjhqj\n" +
            "3-4 l: ltlm\n" +
            "8-10 j: bjpdpvtjdj\n" +
            "1-7 v: vbfvvsvcvv\n" +
            "11-16 j: jbjhjjjjjjjjjjjc\n" +
            "6-13 b: bmswrnbdhbrfbmbb\n" +
            "1-4 x: xxxh\n" +
            "4-10 c: wjgcwbrkxk\n" +
            "11-13 v: sfbcphvzttvmzv\n" +
            "6-16 q: pqqqqqqqqqqqqqqq\n" +
            "10-12 w: wwwwwwwwwswww\n" +
            "2-9 b: fbwwwbrdp\n" +
            "3-4 v: vvnvvvvv\n" +
            "8-14 x: drwxxvqdgmpxmxfcxr\n" +
            "8-10 k: kkkkklkkkc\n" +
            "4-7 j: jcwrjjjfc\n" +
            "3-4 c: cczcgc\n" +
            "3-12 l: smllklclprdvlsl\n" +
            "1-2 j: fjqd\n" +
            "10-19 g: gggggggggqggggggggxg\n" +
            "3-5 m: fpmmmvb\n" +
            "2-3 c: ccmc\n" +
            "3-7 v: pvqktqh\n" +
            "1-3 c: ccfv\n" +
            "4-5 x: khxxj\n" +
            "3-4 g: ggbgf\n" +
            "1-9 x: xxhxxxxxx\n" +
            "5-6 f: zfffmfff\n" +
            "5-8 l: gmlqlkrl\n" +
            "7-10 c: ccccckcscsb\n" +
            "1-3 p: spppp\n" +
            "1-3 v: qmvvv\n" +
            "15-16 z: czhzzzzzpzzzzzzkzz\n" +
            "2-4 r: rrrr\n" +
            "3-13 k: kktkkgkkkkkkgkk\n" +
            "10-13 p: bpqpxpqqtprjn\n" +
            "6-7 j: jwnjjjxj\n" +
            "2-8 w: wmgwdwww\n" +
            "12-14 g: gggggggcgggggg\n" +
            "4-8 f: mdffklwtcj\n" +
            "2-7 j: jmjxjdxjrbrjjdjjrjwj\n" +
            "3-4 m: mmml\n" +
            "5-7 l: wllkqll\n" +
            "6-10 s: ssqcpssddslxncsbs\n" +
            "6-11 n: nnnvnznnnnwn\n" +
            "9-10 w: cbbqgrqglwgqskw\n" +
            "1-8 v: nvvzlhcvvvslv\n" +
            "1-3 t: tttttt\n" +
            "3-6 f: mftpff\n" +
            "1-11 t: pmjtttttttl\n" +
            "8-11 h: hhkmfhvhnwwhhhhhhh\n" +
            "4-6 k: kkkrkkkb\n" +
            "2-17 x: zzxxzvrsbmjxnxxxx\n" +
            "5-6 d: zdhxdldm\n" +
            "1-4 c: nmcc\n" +
            "2-4 j: njjjj\n" +
            "7-13 s: jjsbqrsddsclpvs\n" +
            "10-15 f: mbffrlpjtptgfff\n" +
            "10-13 d: dddddvddddddv\n" +
            "8-9 g: gxhgkggrgc\n" +
            "2-4 b: tbbcnkvp\n" +
            "9-11 g: ggggghgldgpggvg\n" +
            "4-5 m: mmmvm\n" +
            "2-5 d: ddfdp\n" +
            "8-11 r: rrrsrlcmltgrrbr\n" +
            "9-11 r: rrgrrrrxwrrr\n" +
            "3-11 g: zgggvgdggdsj\n" +
            "13-15 x: xxxxxxxvkxxxrxlbxx\n" +
            "13-16 b: bbbrbbpbbfcbqbbxbbb\n" +
            "7-10 x: jxlhxxxxxbx\n" +
            "1-12 p: plkprppjpppb\n" +
            "9-10 t: ttttttttft\n" +
            "1-5 q: qqqsqqjsqp\n" +
            "6-9 m: mzmmmlqmmgm\n" +
            "6-7 j: pbjjkjcj\n" +
            "8-9 b: bbbbbbbbxb\n" +
            "1-2 c: cflj\n" +
            "12-15 c: xskhcckcttmtmfc\n" +
            "5-6 p: pppppb\n" +
            "10-18 v: vjrplvzjxmjvvrvvfvd\n" +
            "3-5 x: hvfqxxqzqz\n" +
            "1-10 t: sttttttbttftttttttt\n" +
            "4-7 f: nrxknwf\n" +
            "3-9 l: fllltcllltlsjlc\n" +
            "10-16 x: cxxxxhxjrxxqjxxkxcx\n" +
            "10-14 m: mdmmmcmmmmmmmmmm\n" +
            "2-17 n: nmnnnnnnnnnnnnnnnn\n" +
            "7-11 s: dtpqdssfbbsrl\n" +
            "1-4 h: hhqh\n" +
            "2-7 j: jjrbbmjps\n" +
            "3-4 d: dhsddvflkqdvgd\n" +
            "6-7 m: gmmmpmr\n" +
            "2-9 j: jjjjjjjtpjjjjjjjjj\n" +
            "12-13 g: gggggggtggggz\n" +
            "16-17 p: ppppppppppppppppspp\n" +
            "6-8 w: wntlwwwhnwtgwhwjj\n" +
            "2-4 s: tntsjn\n" +
            "4-6 t: tgtgtt\n" +
            "6-7 f: qpffwwfv\n" +
            "3-5 k: zltkkgsvjhrbxwvkg\n" +
            "8-10 l: ljlwlgpllkklllflrb\n" +
            "3-5 q: qqbqqqs\n" +
            "4-5 f: zfffb\n" +
            "2-5 b: bbzhbbbb\n" +
            "4-5 q: sfhqpqtqbrbgdqgqw\n" +
            "13-14 k: kkkkdkkkkkgtkzpqkkk\n" +
            "4-9 p: bnpwptvkps\n" +
            "10-11 n: nnnnnnnnnnsnnn\n" +
            "12-14 d: ntpzdcqdpsrmddkcwgc\n" +
            "4-10 g: wgxxgsgggkchgggkg\n" +
            "2-7 q: qwbqccqlqmqqqsqcw\n" +
            "3-5 d: ddddddd\n" +
            "2-4 v: vwsvv\n" +
            "4-13 p: pppppppprppql\n" +
            "6-8 s: zcxssstnfr\n" +
            "8-9 f: zfffcqfff\n" +
            "10-11 m: qmbmmmmmpmx\n" +
            "1-3 j: qvjjkn\n" +
            "14-16 d: zfdmddxdrddvdcdc\n" +
            "5-10 w: rwwwwwwwwww\n" +
            "1-4 p: cmpp\n" +
            "2-3 f: dffff\n" +
            "4-8 n: nnnznznnn\n" +
            "1-4 t: bvrntkt\n" +
            "5-6 v: xjgvnvmgfwxvvv\n" +
            "2-4 w: tvwgtc\n" +
            "1-7 f: ffffffdfc\n" +
            "15-18 w: wwwwwwwwwwwwvwwwwww\n" +
            "1-2 t: jtct\n" +
            "2-3 k: cskdkkkl\n" +
            "3-19 q: qpfqqmqqqqqqqqqqqtqq\n" +
            "2-9 n: wnnjcngnkdnbnlrcbvns\n" +
            "1-14 d: vddfpndddfddddjhddd\n" +
            "1-2 m: bmmbwtwml\n" +
            "3-4 p: ppgrprpgrqb\n" +
            "2-3 m: mrmmm\n" +
            "5-6 l: zllllz\n" +
            "8-13 k: xkzptdzzkggkv\n" +
            "5-6 j: jjjjcj\n" +
            "4-5 b: bbcdfb\n" +
            "1-2 b: vbmbrbsf\n" +
            "8-9 q: lqhmjvdqgnxmb\n" +
            "2-4 n: snmrcnntn\n" +
            "11-15 r: rrsjrfrmqrlrqrz\n" +
            "2-3 l: dlblr\n" +
            "2-3 h: cthlxj\n" +
            "8-15 l: lllwlllllclfllbl\n" +
            "6-7 q: hqqqqqjq\n" +
            "13-14 f: ffffffffffffhf\n" +
            "2-4 v: dtxvztgnvffxlxfcdwf\n" +
            "5-11 h: hxhkhpfnhlchh\n" +
            "3-5 n: nnwcj\n" +
            "12-15 s: sssssssssmssssrcl\n" +
            "1-6 d: rdddddddd\n" +
            "14-15 b: bzbfnbbbbbbbbpxbb\n" +
            "4-8 w: jkxpzcnwhzsgmbkw\n" +
            "7-13 t: ttmlfbttdttgtpvktt\n" +
            "8-11 z: jdqfmwgltdztpzc\n" +
            "13-17 s: sssshsssssskslsxnss\n" +
            "9-10 t: tttttttttf\n" +
            "3-4 l: sllzl\n" +
            "1-2 s: ksxsxbwjn\n" +
            "12-17 l: dlvflhjmlgtldlllr\n" +
            "1-5 f: hfffffhf\n" +
            "5-12 f: gmklffbffztjfwswdg\n" +
            "18-19 z: zzzzzzzzzzzzzzzzzqz\n" +
            "1-5 c: cwccgcc\n" +
            "3-4 p: pspp\n" +
            "5-9 n: tknnnnsjwnsntng\n" +
            "6-7 x: xxxxxxm\n" +
            "6-10 g: szrpggtlwr\n" +
            "9-11 s: xgwsbcssxcs\n" +
            "8-9 t: dtttdtzrt\n" +
            "5-11 d: snddldcdhdd\n" +
            "11-13 m: fbkmsdvklzmtmkmmbjq\n" +
            "10-13 s: nqnsssmsvwrrs\n" +
            "3-4 w: hwnwk\n" +
            "5-11 h: ztkpgzhpfhh\n" +
            "6-7 w: wwwwwwww\n" +
            "3-4 z: zvzzczzlglv\n" +
            "13-14 l: llllllllllllll\n" +
            "12-13 x: xxxwxxxxxxxgx\n" +
            "3-4 p: mxkppr\n" +
            "2-3 d: ddbdt\n" +
            "3-5 l: zlplllphl\n" +
            "3-7 p: spmrbvp\n" +
            "4-5 b: bbbvn\n" +
            "16-17 l: zzxvmvxsgrprbclvl\n" +
            "4-7 h: hphwfshhrpgdmktsphhl\n" +
            "1-5 l: nllllll\n" +
            "4-5 r: rrrnr\n" +
            "5-9 k: bbkwgkklqkqhkk\n" +
            "4-5 t: sttnt\n" +
            "15-16 f: fffjffffffsdffwfsff\n" +
            "5-8 z: bzzzzjzzzv\n" +
            "5-7 f: qqzzffmfvb\n" +
            "3-10 m: zmmpmfcwdmfmvc\n" +
            "3-4 z: zlzzz\n" +
            "2-3 c: cjcsl\n" +
            "5-15 r: mrdznrsrctlrrqrflzm\n" +
            "8-11 g: ggggggggggdg\n" +
            "5-10 s: bnshsbvrthssmq\n" +
            "7-10 m: mmhmmmmmmmm\n" +
            "14-17 h: hhhhhhhhhhhnmkhhhhh\n" +
            "1-5 n: nnsnx\n" +
            "4-17 j: jmxjdkgbhjxflrmqjjdj\n" +
            "6-8 m: mmmmmmmb\n" +
            "3-5 p: ppppxrpp\n" +
            "3-8 t: jtjtttqttt\n" +
            "17-18 k: xklkkkkkgkfmrkkhkbhh\n" +
            "1-3 k: kkhk\n" +
            "13-14 j: jjjjjjjjbjjjgj\n" +
            "9-12 q: cmwwkzrkqsqqqmqhqb\n" +
            "3-8 s: sssfclpwhssfss\n" +
            "3-6 s: mshsfss\n" +
            "10-16 p: plftpppkpqppppppp\n" +
            "4-5 d: dddgdq\n" +
            "4-5 s: slsss\n" +
            "1-7 z: zzgxkzf\n" +
            "6-7 w: wwwwlwz\n" +
            "11-12 w: mqwwwwwwwwbzw\n" +
            "13-14 t: ttttttttttttlt\n" +
            "9-10 c: ccccccccvc\n" +
            "9-13 q: qmqqqqqqhqqqqq\n" +
            "1-7 z: rzzzzzmzzzzz\n" +
            "7-16 w: wwwwwwwwwwwwwwwcw\n" +
            "4-5 m: nkmrmxz\n" +
            "8-9 q: qqmqqcmqlqqqqw\n" +
            "10-15 x: ltnxqwwxxztmzhxxmnt\n" +
            "3-6 r: pkvpfprgwm\n" +
            "10-11 k: kkkkkkkkkkkk\n" +
            "3-4 c: ccfjs\n" +
            "1-6 n: nqvkzjn\n" +
            "9-12 k: qkhxrknkkzpk\n" +
            "8-10 x: xxxxxxxxddx\n" +
            "4-14 t: tttttttttttttbttq\n" +
            "12-13 h: hhhnhhhhhhhhd\n" +
            "2-6 x: bdwljxqxhkxjwpvdxk\n" +
            "3-4 w: kwfw\n" +
            "5-13 w: skrwgwwdwmcwv\n" +
            "1-3 m: mtmvsmc\n" +
            "5-7 v: gvbvvdt\n" +
            "7-8 s: ssshssspss\n" +
            "4-14 m: mmbmdbtmvhvmlc\n" +
            "4-9 g: ggsgnhhmgg\n" +
            "1-6 g: gsmfgjgzmkglzbgfjw\n" +
            "1-12 z: zzzzzzzzzzzdz\n" +
            "4-6 q: dbqjwnd\n" +
            "9-15 c: ccccccchccjcccc\n" +
            "1-7 l: fkllkmp\n" +
            "2-17 g: dggmgzhvphggcjgmtx\n" +
            "9-10 f: fffffffpfs\n" +
            "1-4 n: nnnw\n" +
            "11-12 l: llllllllllrl\n" +
            "9-10 p: ppppppppppp\n" +
            "5-6 p: pskgtx\n" +
            "7-8 q: qqqqqqjr\n" +
            "7-8 d: ddrdddkgddd\n" +
            "2-5 l: llllhl\n" +
            "4-6 h: hhbhlbhh\n" +
            "9-12 m: mmmmmmqmtmqgcx\n" +
            "10-13 f: fbfffjffffffjff\n" +
            "5-14 c: cvvrcmkhztsctfpf\n" +
            "1-2 k: fkkk\n" +
            "8-11 j: kjzchnjlrxjjljjljj\n" +
            "5-6 x: xxxxxq\n" +
            "6-11 r: zrkrrrznrfm\n" +
            "2-5 r: rdrrrr\n" +
            "12-16 c: cccccccccccccccvcccc\n" +
            "14-16 w: pwwfwwntkwwrjwcww\n" +
            "1-16 z: zzzpzmzmdzjzzzzvzzgs\n" +
            "6-8 j: mttjfgswgjwjjdjx\n" +
            "1-8 w: hwswwlwwxtgxbgkwp\n" +
            "7-8 h: hhhhbhnhb\n" +
            "3-4 n: cnzn\n" +
            "8-9 r: ltnkhrdsr\n" +
            "4-5 t: tttmtltptttttttltt\n" +
            "7-8 s: sssslsscszws\n" +
            "16-18 j: jjjljjxjjnvjjjjjjnj\n" +
            "3-4 s: psjpswct\n" +
            "5-7 b: kslrgbhcxmhbv\n" +
            "7-9 x: gxxxdxxxbxxx\n" +
            "1-5 d: lddddd\n" +
            "12-16 x: gsbzzgxnwsrmqxvx\n" +
            "10-12 m: mmrmmmmmmmmbmmmmmr\n" +
            "4-7 f: lfsfcnczbfh\n" +
            "9-11 r: rrrrrrrrrfzr\n" +
            "3-6 c: jfhnvcc\n" +
            "8-19 f: ffffffgfffffffffffj\n" +
            "2-6 x: lpfxdqws\n" +
            "1-4 q: xcvqnqvh\n" +
            "2-11 r: rrrrrrrrrrrcr\n" +
            "1-5 z: pvdczgkznqpxpnzrz\n" +
            "2-3 j: rzcjvmjb\n" +
            "5-6 w: wcwwwlblgplfwft\n" +
            "3-13 j: djjrjmwzrkzzn\n" +
            "10-11 p: hlsbzcpdqppww\n" +
            "9-10 f: fffffffffb\n" +
            "2-7 m: tvmjknlkdqlqmh\n" +
            "6-19 x: cqkrszrxppxxzrclxkx\n" +
            "1-11 m: zfmmjmmmlmmmmmdmm\n" +
            "3-4 t: fstwjtqqsdzbwrt\n" +
            "8-9 x: xxxxxxxxg\n" +
            "4-5 n: xnnnfnnnl\n" +
            "1-4 n: xxnngpfxl\n" +
            "5-6 m: tgsmmqm\n" +
            "10-11 l: lpvhlllrhcn\n" +
            "11-12 k: kkkkkkkkkfdkk\n" +
            "14-16 c: cccccccccccccbcc\n" +
            "13-14 f: ffffffffffffjff\n" +
            "10-11 w: hwhwqngbwmw\n" +
            "16-18 m: mmmmmmmmmmmmmmmrmm\n" +
            "8-12 d: bddddddrddddd\n" +
            "14-16 z: zzzzzzzzvzkvzzznzz\n" +
            "9-10 z: fzzzzzzzzbf\n" +
            "14-15 j: jjjjjjjjjjjjjqjj\n" +
            "8-11 b: qtfjvqgbpwb\n" +
            "6-9 d: ddddddddzddddd\n" +
            "5-7 c: rlqqctcr\n" +
            "5-6 m: mmkmmfmdwjd\n" +
            "6-7 n: nnnnnnz\n" +
            "11-12 s: sssssssssswpsss\n" +
            "12-15 r: rrrrrrrrvrgrrrk\n" +
            "2-3 b: bqbbb\n" +
            "7-9 c: ccccccdcc\n" +
            "15-17 s: sssssssspsdsssqsssss\n" +
            "2-7 g: bgggwrbggfc\n" +
            "4-5 n: ncdnb\n" +
            "11-12 x: xxxxvxxsxxrxxvx\n" +
            "4-17 c: crscfpdcrngngctxc\n" +
            "1-3 s: xsrsss\n" +
            "14-18 w: wzwwwwpxwwfwwlkwbl\n" +
            "2-8 w: tbjctwlwml\n" +
            "1-10 h: xhhfhhgjhhhhhwhz\n" +
            "13-15 c: cccccccccccclccq\n" +
            "1-14 j: hjfjjjzsjpjjjjjj\n" +
            "6-10 c: jccxcccbcc\n" +
            "5-6 n: nznnnxcnn\n" +
            "4-10 w: wwwbwwvfwwmwwws\n" +
            "9-10 s: krsgskgtvl\n" +
            "2-11 p: pppppcppppspp\n" +
            "12-14 c: ccccccccccccvcc\n" +
            "3-13 c: blcvjwrwzzwlmttsncg\n" +
            "3-9 w: wqwlqwqpdwc\n" +
            "12-15 v: gtwlqvxjkvvgvft\n" +
            "14-19 k: kkkkkkkkkkkkkkkkkknk\n" +
            "4-5 g: gggnx\n" +
            "3-4 r: rxxrr\n" +
            "13-14 h: hhhhhhphhhhhch\n" +
            "11-15 w: wwwwwwwwwwdwwwdw\n" +
            "16-17 l: jmphnlvdgmltcflxlm\n" +
            "1-4 q: qmqw\n" +
            "5-10 f: ffmbxfqffffbfff\n" +
            "2-14 b: bbbqjbxvdbbvbdx\n" +
            "18-19 p: ppppppppppppptpppnn\n" +
            "5-6 m: mmbmmkmm\n" +
            "3-8 d: ldkddkddmbcdwdrbx\n" +
            "11-12 s: shjssssssspgssssssss\n" +
            "2-4 d: fddqdd\n" +
            "6-11 f: ffffffffcszsrff\n" +
            "5-10 r: mrrrhrrrrr\n" +
            "2-17 n: nhtnxnnnnfnnnnnnnn\n" +
            "3-4 s: ssvs\n" +
            "5-6 t: ktgbft\n" +
            "7-10 m: mwmmmlmmmhp\n" +
            "10-11 c: cccccccccbc\n" +
            "1-3 t: rnttg\n" +
            "13-14 f: kjqrkfstrfngqf\n" +
            "12-15 g: gdgknggggqghgpd\n" +
            "1-13 t: ttttttgttttttjrttt\n" +
            "1-5 r: brrgrrrrr\n" +
            "4-7 c: cccnccccccp\n" +
            "11-12 n: nnnnnnnnnndl\n" +
            "9-11 j: jwjjjkjjjjfj\n" +
            "3-10 w: wdwgswwwwx\n" +
            "10-12 r: zzrrctnvrxfrrqrrjrrr\n" +
            "4-5 x: xxxhx\n" +
            "5-9 j: fqgwpjtjnt\n" +
            "7-9 l: lxllllllqllwllll\n" +
            "11-17 p: ptbzpvppswpppplpr\n" +
            "7-13 g: ggggggzgggggfgg\n" +
            "2-8 j: pbftjswjqzcp\n" +
            "5-6 z: zzzzzczzzzzzzzzzzzz\n" +
            "2-6 n: ntvnnnnnn\n" +
            "12-13 n: nndntnhknsnnnnnnqfnn\n" +
            "1-6 x: wtnxdw\n" +
            "2-4 f: fxxf\n" +
            "5-12 k: xcxrwkpfkkfkdk\n" +
            "3-4 z: lzzz\n" +
            "12-15 n: knnnnnnncnnnnnpnnnn\n" +
            "3-11 h: jdhfhhfmthh\n" +
            "9-10 k: kkkkkkhkskk\n" +
            "2-6 g: hhngvjgbkg\n" +
            "3-4 k: zkkz\n" +
            "12-19 r: rrrrrrrrrrpmrrrprrvr\n" +
            "2-9 d: dkddddddjdddd\n" +
            "1-4 c: zccc\n" +
            "7-12 d: dqbxtdxdgztddc\n" +
            "4-5 x: kxxxd\n" +
            "1-3 x: xjfkxvhvbq\n" +
            "5-9 w: dpqcpwcrwpwcqhlj\n" +
            "1-7 q: dkbtgkqxjhjzsqccn\n" +
            "4-10 c: cncccccccccc\n" +
            "7-13 b: bbmbqwbbbbbbbpnbb\n" +
            "9-10 b: bbbbbwbbbgx\n" +
            "7-14 b: bbbqjbcpbbjbvbbbqrxb\n" +
            "5-13 s: fspsqsshvhssssmrqss\n" +
            "11-15 v: vvvvvvvvvvvvvsjvhvdp\n" +
            "5-9 d: brwdshwddzvg\n" +
            "2-7 w: wwkfgkwtbvwx\n" +
            "6-9 l: llllwnlllll\n" +
            "4-7 h: hchhhtpr\n" +
            "1-4 n: npgnn\n" +
            "3-4 k: kvkkkkjkkxkgkk\n" +
            "1-13 m: xmkkhmwddbtkm\n" +
            "6-7 x: xxxxxxr\n" +
            "15-19 m: mmmmnmmmmmmmkmbmmmd\n" +
            "14-15 z: zzzzzzzzznzzzhzz\n" +
            "11-13 h: sfhxhlhtnnkvdkhm\n" +
            "9-10 z: dzzzvzzzztmhczbzx\n" +
            "5-7 v: vvvvwvv\n" +
            "5-7 z: zrgzxzzfdz\n" +
            "1-3 n: nvlm\n" +
            "4-7 x: xkvxxjt\n" +
            "4-10 m: mfwzzmnqfsdkxzmmmm\n" +
            "1-15 x: xxxxxxxxxxxxxxt\n" +
            "5-7 n: nnnnnnm\n" +
            "11-12 z: xknzzzwddzxxzzzzzzhc\n" +
            "3-4 f: fzflfjf\n" +
            "4-6 g: ggkgrxg\n" +
            "1-2 n: sncpt\n" +
            "4-18 z: xvrsrxzzzzlzzznzzz\n" +
            "5-7 j: jbhfjcrpkgjhp\n" +
            "6-7 g: gggggsh\n" +
            "8-9 n: nnnzntnqpfnnpc\n" +
            "8-9 k: kkkkkkkxsk\n" +
            "6-11 n: nnhntnmhnnms\n" +
            "3-5 q: qzqqqqhlcbfdqq\n" +
            "6-9 r: rrrrrrrrvdjrrrr\n" +
            "3-7 r: rrrrqhm\n" +
            "6-9 t: xmdtvstttjtt\n" +
            "3-5 l: gnsnlp\n" +
            "2-6 x: hxjxjd\n" +
            "2-6 t: tttttp\n" +
            "7-8 l: vdtrllllrmlwllcplgb\n" +
            "10-11 t: ttttttztmwtt\n" +
            "3-4 d: ddgd\n" +
            "9-11 j: jjjjtnjjqjcjj\n" +
            "6-7 n: nnnnlcwbn\n" +
            "4-6 g: ngdsggg\n" +
            "7-9 q: hnxrvqjqqr\n" +
            "3-5 l: fltllw\n" +
            "3-11 g: gghggggggggg\n" +
            "7-17 w: wwwwwwwvwpwwwmwtgw\n" +
            "2-19 n: nhnnnnnnnnnnnnnnnnn\n" +
            "1-2 n: xnmr\n" +
            "4-6 x: xtxxxpxxxx\n" +
            "10-13 z: zbzzzpjrwzdzxszzzz\n" +
            "9-19 b: bbbbbbbbbbbbbbbbbvbb\n" +
            "9-10 w: wwlwzwwwvr\n" +
            "5-9 p: pnkpdppppppkpwzpp\n" +
            "15-17 j: jjvjjvjjjjjjjjljwcj\n" +
            "3-4 t: tttkt\n" +
            "1-5 j: jvjtq\n" +
            "2-11 r: rrrrrrrrrrwr\n" +
            "1-4 x: xqpzxwcslbj\n" +
            "3-4 b: bpbp\n" +
            "11-13 w: wwwwhwwwwwnwl\n" +
            "2-4 f: nfnjtfkbsxvm\n" +
            "6-7 v: vvvvvvs\n" +
            "1-4 t: xwtxxmgfwpkqd\n" +
            "5-6 h: hgjhrhhhh\n" +
            "2-4 p: psppp\n" +
            "10-14 j: pqjjjsjjjbcbjjjjj\n" +
            "3-7 d: ddbjddgzdd\n" +
            "6-7 l: llsllbl\n" +
            "1-13 p: pppppmpppppppppppcpp\n" +
            "1-3 r: rbdzrjsrd\n" +
            "11-14 x: xxxxxcxxqxxxxs\n" +
            "11-12 c: ccccwccczccccc\n" +
            "2-12 g: spwsxfgdrqngkqgdb\n" +
            "1-3 h: dhrhh\n" +
            "1-7 f: tfffffff\n" +
            "15-16 s: sssssssssssssvssz\n" +
            "12-13 q: qqzqqqqqqqqvq\n" +
            "4-5 g: cgxgk\n" +
            "3-8 n: nnnnnnnnnnnnn\n" +
            "1-3 r: rrkr\n" +
            "14-15 g: sgtgggggggggggxgr\n" +
            "2-5 s: vhcts\n" +
            "2-4 x: xdbvvrnxxhnzsl\n" +
            "8-11 p: ppwpppclpvlp\n" +
            "7-11 b: bblbbkbbbbmxfqgxgk\n" +
            "5-6 d: dddldffx\n" +
            "5-6 z: zzzzzwz\n" +
            "11-15 q: hqrqbzbhnhdqjfqdvg\n" +
            "3-16 b: btgbbbbhzbbbbbjb\n" +
            "4-5 f: ffvkf\n" +
            "6-10 q: qqqqxqqdvlqq\n" +
            "12-15 g: gggxsgsnwqxldmg\n" +
            "8-12 d: ddddddjpdddh\n" +
            "1-2 p: pphgjjm\n" +
            "9-11 d: ddddddmdfddd\n" +
            "18-19 z: zzzzzzzzzzzzzzzzzmz\n" +
            "8-14 r: rrrrrrrtrkrrrq\n" +
            "4-5 t: jhtrt\n" +
            "3-6 h: bjhwkpdjqbnng\n" +
            "4-5 m: mmmmbm\n" +
            "2-4 t: dqttgszbrwpcdr\n" +
            "5-7 q: dfxmqxxqtdfqxqq\n" +
            "3-5 k: kkkcmk\n" +
            "7-10 t: tttttttttn\n" +
            "7-14 m: mmhmbmkmmvrtmxgxwmm\n" +
            "10-11 v: vvvvvzvvcxvvv\n" +
            "5-6 s: lssssbrssl\n" +
            "8-15 h: hhbhhhhhwhrhhhqh\n" +
            "18-19 q: qqqqkqqqqqqqqqqqqtq\n" +
            "10-12 p: xpprjzzlpqspsnpb\n" +
            "5-6 t: ttttgt\n" +
            "4-12 s: csvwsslsshgkbsrds\n" +
            "12-17 z: zzzzzjfzzzzzzzzzzzz\n" +
            "4-5 f: fnktwj\n" +
            "3-6 h: hphdhvh\n" +
            "16-19 m: mmmmmmmmmmmmmmmnmmmm\n" +
            "5-8 m: msmjtplmmtqbm\n" +
            "6-9 q: gqqcqqqrq\n" +
            "1-10 g: gvgfsqggph\n" +
            "10-11 l: nlllpllljql\n" +
            "1-4 q: qqqx\n" +
            "2-4 q: qbwqwpqq\n" +
            "3-5 s: scsmjtszkscsds\n" +
            "2-5 t: txttfttt\n" +
            "1-2 s: swsqspmz\n" +
            "2-4 f: vffw\n" +
            "11-16 r: rrrrrrrrrrjrrrrq\n" +
            "2-13 r: rlxpzrftnrkhrvlzrp\n" +
            "4-7 g: lggfgsggggggggggg\n" +
            "4-5 w: wwblw\n" +
            "2-5 t: tbgtg\n" +
            "6-7 n: jvzmhnmnphhx\n" +
            "1-8 m: cmmhmlmmm\n" +
            "10-14 x: wtxtkxxjpxxxxr\n" +
            "3-5 h: hmchhfhk\n" +
            "5-8 h: qgfkhktmhhhmbw\n" +
            "10-11 k: kkkkkkkkkkh\n" +
            "5-6 g: ghzggxgsgpksg\n" +
            "3-4 w: mwwv\n" +
            "3-7 p: zppsxpnbj\n" +
            "1-2 d: qtdd\n" +
            "9-10 h: rhdhlhhhwhhtdhzxhp\n" +
            "1-6 v: lvtpvvnb\n" +
            "2-6 q: qqqlqm\n" +
            "4-8 j: jjfjjvjjxjj\n" +
            "13-14 x: xhvqxxxxxxhxxq\n" +
            "10-13 k: kclwxblmncnbkkdhrhr\n" +
            "1-3 j: jjpj\n" +
            "3-4 b: sbmxhbbt\n" +
            "2-3 d: mjscddjrh\n" +
            "2-6 x: xxxgxqxxxxzxrxx\n" +
            "19-20 h: hhshhhhhmshhhhhhhhhq\n" +
            "12-15 s: scbssrsslnsskfbs\n" +
            "3-4 p: jpmp\n" +
            "11-19 p: pppptpppcthpppppppp\n" +
            "1-5 w: lwwvw\n" +
            "3-4 d: xzfddddpdddzdjxcdd\n" +
            "3-8 f: fspmqqkfjtfrz\n" +
            "9-12 c: cccccccccccr\n" +
            "15-16 w: wwwwwwwwwwwwpwlg\n" +
            "2-3 v: vzvb\n" +
            "10-18 t: txttttmtmtrtntttfktt\n" +
            "3-12 h: mwbdpslghxxhhh\n" +
            "2-9 l: lcllllllxllllllll\n" +
            "9-10 r: rrrrrrjrtrrr\n" +
            "2-9 m: mmmbmmmmmmmm\n" +
            "7-13 t: ttttttttttwtz\n" +
            "7-13 b: bzbbbbqdxbqbb\n" +
            "5-7 d: ddhdddmd\n" +
            "4-5 b: bqbdkbbb\n" +
            "1-3 k: wkkkk\n" +
            "4-6 d: dddddf\n" +
            "2-7 j: tmnjptjtrvx\n" +
            "5-7 z: qzlzzzvzm\n" +
            "4-5 h: hhhhhf\n" +
            "3-14 s: zsrkrsssmsssshsssss\n" +
            "7-8 k: bkkkgkkxk\n" +
            "8-9 x: xxxxxxxtxm\n" +
            "7-9 j: jmjjjjljjjjb\n" +
            "10-11 n: xnnkrqnfnjnnnpncnn\n" +
            "3-6 c: cxcdlhv\n" +
            "1-2 q: qdlmfhgtgrnqhmvqmkhm\n" +
            "6-7 t: tttttttt\n" +
            "2-4 j: xjvzcjcftgvfqg\n" +
            "5-7 n: srnxnjjgdnnnnqrwt\n" +
            "2-3 z: vhzzvk\n" +
            "6-13 d: nlbwzrpsrfvwddcz\n" +
            "1-3 s: ssfs\n" +
            "10-13 n: nnnnnnnnnmnnnnnnn\n" +
            "6-8 g: lggggnggx\n" +
            "7-10 j: jjjjjjqjjjj\n" +
            "2-10 c: fccbgjccvzwqczcvcc\n" +
            "3-4 p: wqws\n" +
            "1-6 w: wqbjbnrp\n" +
            "5-9 v: vvvvvvvvhvvv\n" +
            "13-16 n: nnnnnnnnnnnntnnn\n" +
            "5-7 h: qzjhhhp\n" +
            "14-15 c: ccccccccccccclcc\n" +
            "11-13 g: tkthwlwggncggxmjfk\n" +
            "2-11 v: vndvvvvvvvvv\n" +
            "10-11 p: ppppppppppt\n" +
            "1-11 c: ccccccccccdc\n" +
            "9-10 b: bbbfbpbbtbb\n" +
            "5-10 r: rrsrrrckhp\n" +
            "2-16 v: vvbktgjvhvvkmfbvccwc\n" +
            "6-10 v: nrvxrvcvvvktrvvvl\n" +
            "10-17 d: ddddddqdhdddddddvd\n" +
            "5-7 f: fqkxhfffghfc\n" +
            "1-13 z: zkzwcggpsppzzxwcbbp\n" +
            "2-4 d: hkvdzhlpbqdnvrjsc\n" +
            "9-11 x: zxxxxxxxsxx\n" +
            "14-17 q: qqqqqqlqqqvqqgtqq\n" +
            "5-12 q: qqqqqqqqqqqrqqqqq\n" +
            "10-13 w: wxwbnbkwgwxwhwwwln\n" +
            "5-16 c: xzvscccccjcccchhc\n" +
            "2-3 v: vgmvvvvvvvvv\n" +
            "7-9 j: mjjjjpjjdjjjb\n" +
            "6-9 q: gqqqqqqqq\n" +
            "10-12 p: pcpxppppprpppp\n" +
            "1-6 s: zsssss\n" +
            "1-3 g: mhggg\n" +
            "2-7 g: gsggsgnvggggqggvlgrc\n" +
            "1-6 d: rddddddd\n" +
            "1-3 n: nntnknnr\n" +
            "8-9 t: tttltttttt\n" +
            "5-6 f: jfzqfljhkwdn\n" +
            "12-14 j: jljjjjvjjjjjjcj\n" +
            "9-10 q: qqqqqqqqqwqq\n" +
            "2-11 h: hhhhhhmhhhqhphhh\n" +
            "4-9 z: cldzzfxzblb\n" +
            "3-4 l: lvlm\n" +
            "3-4 m: mmrmm\n" +
            "15-18 m: mmmmmmvdmmmmmdmmmsmm\n" +
            "4-5 f: wffzff\n" +
            "10-16 b: bbbtmbblpbbbbbmmbv\n" +
            "13-14 d: dpdmjrgdqrdwwd\n" +
            "6-7 m: mmmmmjm\n" +
            "12-19 g: gggggzxggggrgggglgvv\n" +
            "10-15 p: ppppspbpvpkpcpqppp\n" +
            "4-10 m: mmmmzmnmpct\n" +
            "11-12 c: chcccpcccccdcccpd\n" +
            "3-5 f: ffnzqjzh\n" +
            "1-6 p: cpjpppp\n" +
            "7-14 p: ppppnpqpwnrtmbjjppm\n" +
            "7-8 w: wwwwwwtw\n" +
            "3-4 d: ddds\n" +
            "3-4 r: vrxdtlt\n" +
            "2-7 w: wcwvwwqw\n" +
            "5-12 b: bbbbbbbbbbbhb\n" +
            "1-5 t: tlvktt\n" +
            "6-7 p: mprngps\n" +
            "8-12 x: xxrbnxxjhxxxxlx\n" +
            "1-3 x: xvqx\n" +
            "5-7 v: vvvvqjvvvvsg\n" +
            "2-6 w: fwwjwz\n" +
            "16-20 q: qrqqbqnqqfqjhqfqqqqh\n" +
            "3-6 j: jhjjjfjsjk\n" +
            "4-9 k: rkgpgskkz\n" +
            "2-4 z: gzdz\n" +
            "6-8 t: tttttsttdtttt\n" +
            "11-12 p: ppppppppppppp\n" +
            "4-6 x: mzqcfxct\n" +
            "16-19 d: qjdlfdccdbxngddnkgn\n" +
            "2-3 f: rrcvqfs\n" +
            "13-16 z: zzqzzjzzfnttznxzzzz\n" +
            "16-17 w: rbngvbwpgwgzkwswp\n" +
            "1-9 k: klkkkkpkp\n" +
            "3-4 f: fffxffffff\n" +
            "1-2 l: lhpl\n" +
            "1-4 w: vznmj\n" +
            "2-3 j: jdjmpjd\n" +
            "17-20 v: vvvvvvvvvvfvvvvvvrvx\n" +
            "3-7 w: wnzwwswwwwj\n" +
            "3-8 m: mmnmmmmmmm\n" +
            "3-4 l: llmll\n" +
            "9-11 r: rrrfrrrdqrwrr\n" +
            "9-10 w: wwwwwzwwhw\n" +
            "6-10 t: pttwtbxqgttttntktjt\n" +
            "1-3 j: jpngpm\n" +
            "1-9 g: gggggggggg\n" +
            "4-5 b: gbbtb\n" +
            "2-6 q: qqblqdrnmcnhqvvpvkq\n" +
            "6-7 w: zwwwwjw\n" +
            "2-8 w: rpbbwwwlqzhl\n" +
            "11-13 b: bbqbbbbbbbbbb\n" +
            "7-10 v: vvvvfvvvvv\n" +
            "6-17 t: ttttttttttttttttwt\n" +
            "2-3 f: fbff\n" +
            "8-13 l: qlllzllmllgllmlcl\n" +
            "3-4 n: nnnfnqd\n" +
            "9-12 z: lzzzlzzzzffb\n" +
            "3-11 p: bhlpnccgcfp\n" +
            "1-3 s: stccsf\n" +
            "10-18 p: pdgpphscppdlpppvsh\n" +
            "3-6 j: jjjjjq\n" +
            "2-3 s: dslwlsvljc\n" +
            "3-7 g: sgggtdgwkdhspgnxkglv\n" +
            "12-13 h: vrgnfshfssvhh\n" +
            "12-13 m: mmmmmmmmmmmbgm\n" +
            "12-16 d: djddvdqpdddddjlt\n" +
            "3-4 k: kfkmkpk\n" +
            "6-13 s: ksphskxpdswsssbbnwwt\n" +
            "6-18 x: xxsvxndxxxxfvkxxbxs\n" +
            "7-8 d: dxbdddddddd\n" +
            "6-7 q: qqkqdcqjfdqqbbqp\n" +
            "4-5 k: vkkbkzqpk\n" +
            "4-9 l: llbhllllldl\n" +
            "14-17 d: ddddhdhddddddxdddd\n" +
            "3-5 r: htlfbsgmvz\n" +
            "2-4 h: hthhh\n" +
            "4-7 l: xlzllbqkdwqsllfsw\n" +
            "17-18 n: wnnrnnnnngnnnnnnqnfn\n" +
            "1-3 j: vlwkv\n" +
            "1-2 g: bggz\n" +
            "10-11 x: ddsxjxxtnxjpcxxxxxv\n" +
            "4-5 g: hggkg\n" +
            "5-7 t: khtnzct\n" +
            "10-15 g: ggkggsggcgggggqggwgg\n" +
            "9-11 s: ssssbwjhssj\n" +
            "1-8 b: gxvbllbjqk\n" +
            "2-3 w: jgwqhrw\n" +
            "7-8 j: wxtqdvjpbcfzxsjlpmsj\n" +
            "9-16 b: bcpbcbbbbbjmbpwbbj\n" +
            "2-5 t: tpttttt\n" +
            "2-3 z: pzzz\n" +
            "3-10 j: jjpjjrjjjjjjw\n" +
            "5-8 t: tttttttxt\n" +
            "5-15 r: rrnrrrrrrrrrrrkr\n" +
            "8-9 j: hdjwgbjmj\n" +
            "3-14 c: jcccwcccccrckccch\n" +
            "11-12 n: jvzktxgpcmnjglwljrn\n" +
            "9-13 k: vqsgdcksxtxhks\n" +
            "3-5 c: zdccczpwlxt\n" +
            "3-5 r: wxgkrqrsgl\n" +
            "7-8 s: kspsssksswssj\n" +
            "3-7 j: djjjhbrkhtncxjvf\n" +
            "11-12 x: xxxxxxxxxxxz\n" +
            "11-12 t: ttttttttttht\n" +
            "8-11 v: ptvvvsvtvrvvwvxvtfg\n" +
            "9-13 d: nhjddddvlbkdcdntdf\n" +
            "3-6 w: gnwwjqwzqwm\n" +
            "3-5 s: tsssc\n" +
            "3-7 k: kkkzkpmmll\n" +
            "13-15 k: kgkkkkkkhkkktkf\n" +
            "5-8 t: ktttrttnt\n" +
            "1-4 z: nzzzzzz\n" +
            "2-4 k: lkkc\n" +
            "2-3 z: szjh\n" +
            "19-20 d: dddpcddkddckdddbmdld\n" +
            "3-9 q: xqqqpqqqwlqqqqq\n" +
            "14-17 s: ssspkssssssssssslss\n" +
            "17-19 c: ccccccccjcczccccxccc\n" +
            "4-13 h: qtrhflbfmkfchjmfzph\n" +
            "10-18 m: nmmmmmmmmmmmmmmmxd\n" +
            "5-11 n: dnnnfsnnkznbgnjn\n" +
            "6-11 c: cccccvccccc\n" +
            "7-9 d: dddddrxdzldv\n" +
            "2-4 z: zbzz\n" +
            "1-6 j: njjjjjjpjj\n" +
            "3-5 p: prpww\n" +
            "3-16 c: tqjdhbgxvxcxwbvcn\n" +
            "4-5 c: vclfc\n" +
            "3-18 x: xxrxxxtxxxxxxxxxxtxx\n" +
            "2-4 g: gvgggg\n" +
            "6-12 j: cjjpjjjjlhpt\n" +
            "3-4 w: pfwq\n" +
            "5-14 v: vsqqvlrmqbbrlp\n" +
            "2-12 l: rlblqwmphxzpsp\n" +
            "2-8 h: hhqqvhhphhhqddhh\n" +
            "7-9 f: dnfvhwwffk\n" +
            "4-5 p: ppppcd\n" +
            "8-14 t: ttttdtqhttttftttt\n" +
            "13-14 f: fffffffffffffff\n" +
            "1-6 s: jrtwjslzwgkt\n" +
            "4-6 c: jcwzhcscc\n" +
            "10-14 x: llxxxxxxvnxsmx\n" +
            "1-2 h: hhhhv\n" +
            "2-4 d: mvdclzddj\n" +
            "16-17 t: tttttttttttttttmt\n" +
            "2-3 l: jklzlmzrppdpzt\n" +
            "5-6 g: rvfgnggjgk";
    public static void main(String[] args) {
        List<String> inputs = Arrays.asList(INPUT.split("\n").clone());
        int valid = 0;
        for (String inp : inputs) {
            String policy = inp.split(":")[0];
            int minPos = Integer.parseInt(policy.split("-")[0]);
            int maxPos = Integer.parseInt(policy.split("-")[1].split(" ")[0]);
            char c = policy.split("-")[1].split(" ")[1].charAt(0);
            String password = inp.split(":")[1].trim();
            boolean first = password.charAt(minPos-1) == c;
            boolean second = password.charAt(maxPos-1) == c;
            if ((first || second) && !(first && second)) {
                valid++;
            }
        }
        System.out.println(valid);
    }
}
