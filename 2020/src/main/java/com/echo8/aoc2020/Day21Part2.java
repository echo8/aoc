package com.echo8.aoc2020;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Day21Part2 {
    /*
mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
trh fvjkl sbzzf mxmxvkd (contains dairy)
sqjhc fvjkl (contains soy)
sqjhc mxmxvkd sbzzf (contains fish)

dairy -> mxmxvkd (2), kfcds, sqjhc, nhms, trh, fvjkl, sbzzf
fish -> mxmxvkd (2), kfcds, sqjhc (2), nhms, sbzzf
soy -> sqjhc, fvjkl

kfcds, nhms, trh, sbzzf

dairy -> mxmxvkd
fish -> mxmxvkd, sqjhc
soy -> sqjhc, fvjkl

kfcds
nhms
trh
sbzzf

     */
    private static final String INPUT = "rlpkdv qjm kxhh tzqf cqtmst jdcc tvbppb vtxf zkshp gstsgf lxjkr bbgjn zqzmzl znmhcfmc zbhf llpfvs xkthpt szqr njtvrpc sbzllf tfqsb fgdn vgj kndt vkcf crgmxg nccmqg rzl qmst jdlvgvp xhnk pthkfzr lbgl kxsll qdrcnt cndz xpdqxtrh srsl qxptn fzhhqp kskjbx tnrmchc tsqpn jncgc pbjgn jhddxv dmrfb zmnpsx zbqrfb nrl ddgd hmhqq dtbfb mntxnf grgjkz kxjszsfm pkvhv dsqdcl jsbpht dtphdp jrlvrx gbzml ffc htnmftg fkxl dmx vndmsf sfp nvmpqzd zbvflpl drmssh vvgz bsdjq pnqdpt qltkhqt tzgkm lnhx rcl kvlx mxvjf prbcss mdxq zvthr cltx rcqb sqr fjcrzgq jxdms jbjnx sphfb (contains peanuts)\n" +
            "kjflc jxbzxd cfn djqrsd jngvsq vgssk xkthpt xhnk pbqgcl bcbsh dmpnpc qlmtgt sdtsq cqstff ngqdpq zmnpsx kxhh mbfb fgdn bcfhrtlx rpjlrl kqzdmd jxdms mntxnf kndt rzrb pkknz fr klqj jbjnx ccsm cltx ztjqx crgmxg znmhcfmc xrlvd rcqb nrl rtdhc ztmqrbvb tfqsb vxltmm hsbgl lknk lqqbz tsqpn sqr qmst qjvvcvz zkqmd xnqfx skjn tsktk tzqf kfzm bfbcl kvlx slzdx vvgz krhfmd rkdrk sphfb hzkcvk (contains dairy, sesame)\n" +
            "cvkmvd xhnk fkxl pbqgcl rzrb vtxf cqtmst dmx ztjqx zqzmzl gdffb ddgd rpjlrl pthkfzr qjvvcvz cctgq ccsm vndmsf qqtnt kxhh fgdn vgj fmlc fjqns lcktf xbbcn xskcmdk kndt xggvd nrl ngqdpq qdhfqx txjxng lbgl pkknz szqr dtbfb xkthpt bcbsh lxjkr cfn rlpkdv rcqb xmctlnjx cltx kqzdmd vxltmm vbbxd zkr hzkcvk rtdhc jxfz jncgc qmst mfcf ppphm qjm xrlvd lqqbz fccp xxf vkcf zvthr pnqdpt skjn zvsgzv lhvcd crxd kvlx ckrf pzvx jxbzxd ktsnqg xvtbk tsqpn mdxq zkqmd ptnpb pbjgn dtphdp kqpcn jfbds dkjjpmt vjj vllhf tvbppb kschtq fjcrzgq nvmpqzd hmhqq (contains nuts, sesame)\n" +
            "klqj cndz pjkkm tcgmz prbcss lknk djqrsd zqzmzl qjvvcvz sdtsq fftkllp rcqb hllqx gstsgf dmpnpc mbfb tfqsb cltx cvkmvd nrzc dq kskjbx vndmsf lhvcd jrlvrx jhddxv znmhcfmc mfcf bfbcl kndt tsqpn cqstff bcfhrtlx vvgz fkxl vtxf hcqs ckrf fjcrzgq nrl crxd ztmqrbvb zkshp ppphm bbgjn zvthr crrh xskcmdk jncgc crgmxg hzkcvk jngvsq llghzs (contains peanuts, dairy)\n" +
            "qxplxtp txjxng qlmtgt jdcc tsktk zvbpd tsqpn mntxnf rzl ppphm tzqf rzrb vqmdd qqtnt cltx rcqb xhnk kndt pkknz dmpnpc jrlvrx nrl kschtq pzvx cvkmvd lhvcd klqj fr xqlvq cfn tfqsb ptnpb kskjbx fgdn dmrfb qdhfqx szqr nvmpqzd qjvvcvz djqrsd zbhf lknk kxsll pkvhv fkxl gvpd qjm vvgz pttq hsbgl mzhp kqzdmd jhddxv tcgmz fccp spthcff sqr bfbcl zkshp dmx hxgbnc htnmftg lcktf vgj dkjjpmt kxhh (contains fish, eggs)\n" +
            "qmst xmctlnjx xrlvd krhfmd sdtsq dtbfb zbvflpl vgssk lknk tsqpn crrh kqzdmd bnjq nrzc xxf gtvk cltx ffc lqqbz rcl fkxl fchtgm pkknz zmnpsx qjvvcvz ktsnqg slzdx nrl bbgjn xhnk crgmxg xbbcn ckrf sfp zbhf rkdrk cqtmst jncgc txjxng qqtnt kskjbx mdxq pttq bcfhrtlx hzkcvk sbzllf kvlx pbqgcl nccmqg jfbds rcqb mzhp dnxhx xggvd kqpcn hllqx ndn crxd fgdn hjkvk xskcmdk tsktk djqrsd cvkmvd jdcc mntxnf tvbppb krg zkshp nvmpqzd qxplxtp zqzmzl vtxf llghzs (contains nuts, eggs, wheat)\n" +
            "qxptn bsdjq rcqb kqpcn mxvjf xpdqxtrh cvkmvd bcfhrtlx mntxnf qdrcnt kqzdmd kxjszsfm xhnk xmctlnjx tvbppb nrl cxtgtz dmx tfqsb jbjnx cltx kjflc qlmtgt bbgjn dsqdcl dmrfb mzhp llghzs prbcss djqrsd qjvvcvz pttq szqr hsbgl jhddxv gtvk kndt crxd njtvrpc dnxhx krhfmd tcgmz fjcrzgq sqr xrlvd jncgc zqzmzl (contains fish)\n" +
            "tsqpn pbqgcl tsktk lbgl xxf qdrcnt chtpkf pkknz hxgbnc djqrsd drmssh kskjbx qxptn zkshp nrzc rcqb fr xhnk hllqx cxtgtz rzl vndmsf pbjgn xkthpt zvsgzv ptnpb pjkkm tfqsb cqstff hjkvk vxltmm gdffb cltx krg nrl nvmpqzd xggvd zkqmd vqmdd slzdx qjvvcvz fftkllp kvlx hmhqq cndz tvbppb dnxhx ztjqx (contains fish)\n" +
            "hmhqq vqmdd zzmvlnq kndt xhnk ktsnqg ckrf tsqpn nrl vkcf hcqs jdcc kjflc spthcff tfqsb xggvd vtxf dmrfb tvbppb fftkllp mdxq mfcf qdrcnt vjj pzvx jxdms xxf hllqx jsbpht sfp rtdhc zqzmzl qsddtb jrlvrx zbqrfb cltx klqj fkxl qjvvcvz drmssh kxhh nhqz txjxng bsdjq crrh chtpkf zkr fjqns mntxnf kschtq hzkcvk bfbcl crxd znmhcfmc zkshp jbjnx zbvflpl skjn tnrmchc hjkvk qdhfqx qqtnt llpfvs tzgkm nhgmnc ddgd kxsll kskjbx rkdrk gtvk dsqdcl gdffb dkjjpmt vxltmm jxfz qxptn gzbs qjm (contains peanuts, nuts, sesame)\n" +
            "chtpkf nrl jngvsq rcqb zkshp vbbxd jsbpht gbzml jxbzxd bcfhrtlx tvbppb pttq fmlc qxplxtp srsl crxd drmssh vgssk cltx mxvjf xmctlnjx sbzllf pjkkm tzqf gtvk xskcmdk tsktk kxjszsfm mntxnf lcktf lxjkr vgj jxdms kvlx jrlvrx nhgmnc szqr zqzmzl qsddtb vndmsf lbgl pbjgn zkqmd vxltmm rzrb tfqsb zzmvlnq qdhfqx fftkllp znmhcfmc hsbgl kjflc kskjbx vtxf xhnk hcqs tsqpn cqtmst kqzdmd vllhf fccp sqr qltkhqt xvtbk gdffb htnmftg dmpnpc vkcf lhvcd krg xxf fchtgm vqmdd cfn kxsll gvpd rcl fr nhqz (contains peanuts)\n" +
            "xmctlnjx tvbppb jfbds zvbpd dq hcqs zbhf vvgz qdrcnt dmpnpc ddgd nhgmnc kqpcn rpjlrl fzhhqp qqtnt rkdrk sbzllf znmhcfmc njtvrpc bsdjq lcktf xhnk zvsgzv bcbsh cndz bnjq mzhp jncgc nrl vtxf chtpkf dmx ndn fkxl nccmqg cqstff drmssh hsbgl zvthr xvtbk zzmvlnq tsqpn gbzml kxjszsfm vqmdd rtdhc vgj mxvjf hzkcvk vxltmm xqlvq dtphdp crgmxg cxtgtz sdtsq ckrf rcqb cltx cfn vjj llghzs xbbcn srsl xkthpt fgdn gtvk hxgbnc zbvflpl pzvx zmnpsx kqzdmd lhvcd qjvvcvz tfqsb pkknz lqqbz (contains shellfish)\n" +
            "vxltmm kqzdmd szqr xhc zbhf bcfhrtlx ccsm kfzm cltx qdhfqx ptnpb jxfz xbbcn jdlvgvp kxjszsfm zbqrfb nrl xrlvd ngqdpq rzl dsqdcl jbjnx xggvd crxd zqzmzl hjkvk pbqgcl znmhcfmc xhnk sfp tfqsb flrxh ndn tcgmz sdtsq kschtq vgssk jfbds ffc kvlx tsqpn vtxf fzhhqp klqj gstsgf mxvjf tvbppb lhvcd kndt qltkhqt grgjkz bnjq qhps fchtgm qmst zvsgzv fccp pttq zkqmd lcktf mbfb rlpkdv rpjlrl zvbpd jrlvrx skjn pthkfzr qxptn llpfvs dtphdp kxhh htnmftg vkcf qjvvcvz rkdrk (contains fish)\n" +
            "tzgkm zbhf qxptn cvkmvd gbzml sdtsq xhnk jdlvgvp dnxhx tvbppb tfqsb nrl zmnpsx fchtgm rcqb xmctlnjx hllqx pbqgcl drmssh bcbsh prbcss fccp htnmftg gzbs kqpcn qlmtgt tsqpn pjkkm cqtmst djqrsd txjxng tcgmz kskjbx spthcff rlpkdv vqmdd slzdx cqstff sbzllf zbqrfb zqzmzl xhc jfbds cltx sqr dkjjpmt hjkvk mdxq nhqz rtdhc dsqdcl szqr xskcmdk (contains peanuts, sesame)\n" +
            "zqzmzl sbzllf lxjkr spthcff xqlvq fkxl xbbcn skjn cqstff nvmpqzd cctgq dmx tnrmchc dmrfb qltkhqt pttq nrl llpfvs kjflc cndz qjvvcvz vndmsf kxhh tzgkm tzqf rkdrk ppphm cfn zbqrfb bcbsh gzbs zvbpd fchtgm ptnpb dsqdcl jxbzxd jsbpht pzvx hsbgl nhgmnc nrzc dtphdp jxfz zbhf nhqz jxdms sphfb pkknz cltx xnqfx mfcf xmctlnjx zbvflpl gtvk fmlc xvtbk hmhqq xggvd lqqbz tsqpn tfqsb fccp zkr xhnk zvsgzv cxtgtz slzdx bbgjn mdxq hllqx hjkvk fgdn qxptn zkqmd xrlvd bcfhrtlx (contains shellfish, wheat, eggs)\n" +
            "zqzmzl qdhfqx sbzllf spthcff tvbppb rcqb ffc kxhh fmlc hzkcvk rzrb mdxq sphfb ztjqx xrlvd jbjnx szqr zvsgzv dmx tfqsb vllhf jncgc zvthr zkr lhvcd krg ndn vndmsf zkshp nhgmnc zvbpd txjxng mntxnf cltx xskcmdk rlpkdv xkthpt bcfhrtlx qmst xggvd pttq llghzs lcktf xhnk qhps xnqfx fr ccsm llpfvs lnhx mzhp nccmqg jfbds pbjgn ddgd lqqbz qjvvcvz sdtsq rzl fchtgm sfp fkxl tsqpn cqtmst xmctlnjx mbfb htnmftg qsddtb pkknz flrxh kxjszsfm dsqdcl (contains shellfish, eggs)\n" +
            "vkcf jxfz rcqb dnxhx dtphdp zbvflpl pbqgcl cndz jrlvrx vllhf szqr mxvjf gbzml zzmvlnq xhnk xrlvd lbgl hllqx mzhp bfbcl qdrcnt hcqs xmctlnjx lqqbz gtvk qjvvcvz ppphm zbhf fftkllp fgdn lcktf zvsgzv srsl llpfvs krg tsqpn grgjkz kskjbx bcfhrtlx chtpkf jngvsq gstsgf bsdjq xskcmdk zmnpsx zqzmzl xvtbk tzqf vjj vqmdd nrl ckrf jbjnx tsktk tvbppb gvpd hxgbnc qxptn fccp pzvx ptnpb drmssh zkshp kschtq cltx njtvrpc xbbcn pkknz rcl jdcc llghzs fr slzdx rtdhc nccmqg tcgmz znmhcfmc zkr jsbpht zvbpd qqtnt rlpkdv bbgjn jxbzxd kjflc xhc cfn lnhx zbqrfb (contains wheat, dairy, sesame)\n" +
            "zbqrfb kjflc kqpcn vllhf jngvsq dmpnpc chtpkf pkknz ccsm vxltmm mdxq cltx gvpd hsbgl kfzm qdrcnt pttq zmnpsx kschtq ppphm tsqpn pkvhv rcl cvkmvd txjxng tnrmchc ndn lnhx zbvflpl skjn fr crxd rpjlrl rcqb jdlvgvp kndt vgj vkcf fzhhqp grgjkz fmlc slzdx zkshp zvbpd fccp hjkvk zkqmd rzl hllqx dnxhx nrl qmst bnjq ztmqrbvb zqzmzl xkthpt pbjgn njtvrpc jbjnx cndz cqtmst kxjszsfm bcfhrtlx qjvvcvz hmhqq lknk jrlvrx xhnk tsktk cxtgtz (contains nuts)\n" +
            "fgdn sqr krhfmd qjvvcvz crrh qqtnt qsddtb nhgmnc vjj gbzml zqzmzl xxf tzgkm qhps lcktf ptnpb znmhcfmc pttq rcqb rtdhc cxtgtz szqr xqlvq djqrsd ztmqrbvb hmhqq pkknz tsqpn xhnk cltx mfcf kndt lxjkr tfqsb vkcf zkshp mdxq cndz vbbxd qltkhqt xhc cctgq bbgjn kjflc dsqdcl qxplxtp rkdrk zvbpd xpdqxtrh qjm qlmtgt htnmftg jrlvrx fzhhqp ndn zvsgzv sfp nccmqg mntxnf kschtq jsbpht hzkcvk vndmsf fchtgm xnqfx lhvcd bnjq sphfb (contains sesame, dairy, nuts)\n" +
            "bbgjn gvpd ptnpb dtbfb pjkkm ccsm vkcf qltkhqt ppphm krhfmd xmctlnjx fmlc zkshp tfqsb lcktf rcqb qjm xpdqxtrh qjvvcvz znmhcfmc djqrsd spthcff jxdms pbjgn jxbzxd cqstff zqzmzl zvsgzv tcgmz jdlvgvp bsdjq ngqdpq cltx mfcf kxjszsfm xhnk xkthpt vvgz kfzm jhddxv dnxhx kqzdmd xggvd tvbppb crgmxg jrlvrx slzdx vqmdd srsl vbbxd pbqgcl xskcmdk mdxq kndt hsbgl gdffb tsqpn lknk bcbsh hcqs (contains shellfish, eggs)\n" +
            "cqtmst jdcc vbbxd lqqbz qdhfqx vgssk rlpkdv tzgkm nrzc kxsll kqzdmd cltx ztmqrbvb fzhhqp bnjq pkvhv vtxf zvsgzv slzdx zbqrfb flrxh klqj xxf xkthpt tsqpn jxdms gzbs fchtgm ccsm xhnk lknk llpfvs kxjszsfm prbcss tfqsb nrl crgmxg vllhf zqzmzl kjflc hxgbnc vjj lnhx ngqdpq sfp ddgd gvpd rpjlrl pnqdpt qmst znmhcfmc kndt zbvflpl njtvrpc qjvvcvz (contains nuts, eggs)\n" +
            "vjj kskjbx kndt lxjkr lhvcd jsbpht hmhqq jbjnx mbfb pthkfzr pzvx vllhf zkshp ddgd bfbcl fgdn cltx bnjq qlmtgt mntxnf zvsgzv jrlvrx vgj kfzm xhc vvgz pkknz crgmxg ndn bbgjn hsbgl zmnpsx xhnk sbzllf bcbsh fkxl crrh sqr jxfz bcfhrtlx nvmpqzd tsktk xggvd hxgbnc krg cndz fzhhqp qhps htnmftg lnhx rcqb xbbcn crxd rzrb sphfb dtphdp rcl pkvhv vndmsf ptnpb cqtmst cxtgtz ckrf fccp cfn tfqsb gdffb ffc tsqpn kschtq nccmqg slzdx zqzmzl mxvjf nhqz vbbxd mfcf klqj zbhf prbcss gstsgf drmssh qdhfqx nhgmnc nrl (contains sesame, shellfish)\n" +
            "ztjqx rpjlrl zvthr gdffb fjcrzgq jsbpht fgdn zvsgzv cxtgtz klqj cqtmst dtphdp jdlvgvp kndt ccsm rtdhc jncgc qdhfqx tsqpn zkshp dmrfb rkdrk nrzc znmhcfmc vndmsf jxbzxd llghzs hxgbnc kschtq dsqdcl kvlx lhvcd rzl skjn zvbpd djqrsd tfqsb ngqdpq jxdms pttq crrh kqpcn fccp ppphm nvmpqzd sdtsq qjm qltkhqt zzmvlnq rcqb qqtnt tzqf zqzmzl pnqdpt crxd pjkkm jdcc ztmqrbvb crgmxg zbqrfb zkr xhc mntxnf lqqbz mfcf qhps cltx vtxf qjvvcvz jxfz hsbgl sphfb sbzllf qxptn cctgq xmctlnjx sfp jhddxv xhnk kqzdmd xnqfx kxjszsfm kjflc mbfb ptnpb kxsll grgjkz lcktf (contains wheat, eggs, peanuts)\n" +
            "kskjbx fkxl szqr vxltmm ndn nccmqg lhvcd qdrcnt rzrb kvlx hsbgl tnrmchc cvkmvd vtxf pbjgn ccsm vqmdd rkdrk tsqpn ztmqrbvb lxjkr hjkvk pzvx pjkkm txjxng xhnk zkqmd htnmftg dmpnpc kqzdmd rpjlrl xpdqxtrh sbzllf crrh fccp vgj fmlc dnxhx dtphdp nrl fjqns fr vgssk vjj zqzmzl rcqb mbfb bcfhrtlx sphfb qsddtb kqpcn qdhfqx qmst xvtbk cndz qjvvcvz xmctlnjx cltx pbqgcl grgjkz gzbs rzl zbqrfb jncgc qhps nhgmnc fchtgm fgdn sqr (contains eggs, nuts)\n" +
            "mxvjf lknk tsqpn tfqsb fjcrzgq qlmtgt hcqs jngvsq qltkhqt lnhx znmhcfmc sdtsq zbvflpl jxfz dnxhx drmssh rtdhc grgjkz ztjqx nrzc vtxf ktsnqg vgj krg nhgmnc bcfhrtlx lhvcd rcqb zvbpd ddgd cqstff djqrsd zkr crgmxg rkdrk xhnk dtbfb kskjbx llpfvs rzl hllqx hjkvk pthkfzr rzrb gvpd xkthpt ffc zbqrfb kvlx qmst ngqdpq cltx zqzmzl pzvx dmpnpc jxdms klqj xggvd vqmdd flrxh gbzml pbqgcl pkknz htnmftg ccsm nrl sfp srsl cqtmst cfn kqzdmd zkqmd vjj (contains shellfish, wheat, eggs)\n" +
            "fzhhqp bsdjq znmhcfmc gbzml fftkllp zkr mntxnf rpjlrl bcbsh rzrb drmssh pkknz sbzllf llpfvs pnqdpt jxbzxd bfbcl spthcff qxplxtp kxjszsfm xhnk cqstff srsl zvsgzv mbfb htnmftg mzhp pjkkm krhfmd kjflc vgj vvgz rkdrk nrl crgmxg dsqdcl cltx pkvhv vllhf qjvvcvz gzbs zqzmzl tvbppb szqr kschtq rcqb vgssk djqrsd xmctlnjx kfzm jdlvgvp txjxng tsqpn kqzdmd xggvd tnrmchc xskcmdk hsbgl fjqns rtdhc (contains sesame)\n" +
            "slzdx gvpd zkr hxgbnc bnjq jxdms bcfhrtlx pttq tfqsb dnxhx rcqb znmhcfmc nccmqg rcl zqzmzl qjvvcvz tsktk cndz xskcmdk ztmqrbvb vxltmm dq mntxnf zkqmd jdcc zbvflpl xqlvq zbhf ffc srsl prbcss gstsgf sphfb nhgmnc kxhh jfbds cltx ndn qdrcnt dkjjpmt skjn flrxh dmpnpc tsqpn pthkfzr cqtmst ckrf nvmpqzd kjflc kxjszsfm xhnk mdxq qxplxtp kqpcn jsbpht vndmsf hllqx cqstff kskjbx fzhhqp (contains peanuts, dairy)\n" +
            "kqpcn ztmqrbvb qdrcnt zqzmzl jbjnx rpjlrl rlpkdv szqr kvlx slzdx fgdn rtdhc vndmsf qmst kschtq htnmftg jncgc bsdjq pthkfzr vgssk bcfhrtlx ffc hsbgl ndn tfqsb sbzllf nccmqg fftkllp qjvvcvz txjxng vjj bbgjn mfcf xbbcn cfn gdffb znmhcfmc sfp lcktf gstsgf dmpnpc xqlvq jfbds jdlvgvp zkqmd jrlvrx zvsgzv zzmvlnq njtvrpc nrl fr fccp xhnk vvgz pbjgn sdtsq zkr dtphdp pttq ccsm krhfmd xxf fjcrzgq nhqz lbgl xpdqxtrh dmrfb xmctlnjx mxvjf lnhx ddgd skjn lqqbz mntxnf klqj xhc zbvflpl tsqpn kjflc xskcmdk kxsll rcqb qqtnt rzrb (contains nuts)\n" +
            "qjm znmhcfmc zqzmzl htnmftg zbqrfb cltx mbfb kschtq bfbcl cndz cqtmst jfbds nrl ztmqrbvb llghzs cctgq xxf kxsll jncgc qjvvcvz kfzm mdxq ngqdpq kxjszsfm grgjkz nccmqg tsqpn tzgkm nhqz xggvd vvgz fjcrzgq ckrf sqr tfqsb krhfmd pkvhv fftkllp lbgl fmlc zbhf xhc tvbppb xhnk sphfb qltkhqt fccp rkdrk jrlvrx pkknz nrzc kvlx dnxhx dsqdcl xnqfx lknk zkqmd zkr drmssh pthkfzr gtvk sfp (contains peanuts, fish)\n" +
            "pbjgn hsbgl zvthr pthkfzr cqstff qjvvcvz jxfz jsbpht fccp gstsgf cxtgtz rlpkdv rzl pkknz ckrf mxvjf bsdjq fjcrzgq vndmsf klqj tvbppb bcbsh tfqsb htnmftg nvmpqzd zbhf drmssh xhc xhnk kxjszsfm flrxh ddgd rkdrk tzqf cctgq lqqbz fchtgm lcktf qlmtgt nrl txjxng tsktk qxplxtp rcqb nhgmnc mntxnf pttq tsqpn vkcf qdhfqx cfn jngvsq zqzmzl ffc hcqs sbzllf (contains wheat, sesame)\n" +
            "hllqx sphfb tzqf nrl sqr ndn sfp xkthpt gzbs bfbcl lcktf kndt fzhhqp qqtnt bcbsh rlpkdv zzmvlnq cltx qxplxtp tsqpn bnjq xhnk zqzmzl rpjlrl pbjgn prbcss kjflc zbhf tfqsb bsdjq rzrb dnxhx nrzc pbqgcl rcl mzhp ktsnqg zmnpsx fr kvlx xnqfx xskcmdk kxsll fjqns dtphdp vkcf mbfb ptnpb rcqb hjkvk zkr hmhqq kskjbx kxjszsfm jfbds (contains wheat, sesame, dairy)\n" +
            "cfn pzvx vqmdd tfqsb zqzmzl txjxng vkcf fzhhqp dtphdp xhnk vjj kxsll xhc vgj mntxnf sphfb pkknz zbhf tsqpn flrxh xvtbk lknk dmpnpc lcktf tnrmchc hxgbnc tzgkm dq qxptn srsl kschtq crrh rcqb klqj gzbs nhgmnc dkjjpmt tsktk llpfvs zkr jsbpht qqtnt sqr fkxl gbzml szqr pkvhv ccsm nvmpqzd cxtgtz bcbsh qdrcnt zvsgzv cltx dsqdcl qlmtgt vxltmm skjn sbzllf tcgmz vtxf qjvvcvz xpdqxtrh ngqdpq dnxhx pbqgcl bbgjn fftkllp ztjqx hzkcvk rlpkdv bcfhrtlx zkqmd tzqf (contains eggs)\n" +
            "dmpnpc fgdn pkvhv mntxnf kschtq jxfz tcgmz fjcrzgq qxptn cfn bnjq xpdqxtrh rcqb drmssh gtvk qxplxtp gdffb dkjjpmt jngvsq prbcss tzqf xkthpt fkxl lxjkr qjm nhqz gbzml sqr pzvx nrl qqtnt xhnk nhgmnc vxltmm zkshp dnxhx xxf jbjnx vvgz sphfb ppphm cltx dsqdcl jsbpht rzl dtphdp dmx qlmtgt jxbzxd pttq njtvrpc zqzmzl vbbxd skjn lbgl cqtmst hxgbnc qjvvcvz kxhh pjkkm bsdjq hsbgl fccp gstsgf qhps cvkmvd xvtbk kfzm ndn kvlx sdtsq ffc gvpd bbgjn lnhx gzbs kqpcn spthcff hllqx fftkllp jfbds kxjszsfm pbjgn tfqsb rzrb (contains shellfish, fish, wheat)\n" +
            "lcktf njtvrpc jhddxv xhnk kndt drmssh tsqpn pbjgn kxsll cfn mbfb vgssk ppphm zbvflpl nrl zkshp pttq znmhcfmc fftkllp hmhqq slzdx cqtmst sfp lknk jdcc cvkmvd crgmxg pjkkm qdrcnt qxptn jxfz vqmdd xpdqxtrh qhps kqpcn tsktk qdhfqx ztjqx lqqbz xkthpt vbbxd lxjkr ffc dq lnhx htnmftg pkknz cqstff tnrmchc rtdhc pkvhv tfqsb jsbpht fjqns grgjkz hzkcvk bsdjq cltx djqrsd lbgl jncgc mzhp pnqdpt jxdms spthcff vndmsf fjcrzgq xbbcn fchtgm bfbcl rzrb rpjlrl nrzc qqtnt zqzmzl klqj xxf qjvvcvz xqlvq (contains fish, nuts, wheat)\n" +
            "mdxq vxltmm vbbxd spthcff txjxng rpjlrl dsqdcl bsdjq dmx nrzc lbgl tnrmchc xnqfx cvkmvd pnqdpt cndz ptnpb sphfb jbjnx bbgjn mntxnf qdhfqx hjkvk pbqgcl pbjgn bcbsh nhqz kvlx hcqs pkvhv gbzml qsddtb fjqns grgjkz kschtq vgssk jrlvrx gtvk kxjszsfm crrh xskcmdk kqzdmd hmhqq qjvvcvz zvsgzv kskjbx vvgz cltx xvtbk lnhx rcqb tsqpn jxfz zkr ppphm jncgc gstsgf cfn fkxl vndmsf pjkkm tfqsb nvmpqzd qltkhqt kndt zqzmzl ztjqx ndn dq htnmftg qdrcnt drmssh fgdn vqmdd klqj nrl (contains nuts, dairy, shellfish)\n" +
            "qdhfqx pzvx hcqs jsbpht zbhf xhnk ckrf zvsgzv cqtmst jbjnx xkthpt tvbppb rlpkdv spthcff hllqx fjqns bsdjq nrzc kndt pjkkm nhqz cvkmvd bcfhrtlx klqj zmnpsx sfp rtdhc qmst mbfb rcl srsl fmlc qsddtb bnjq tfqsb kskjbx xmctlnjx pthkfzr cqstff njtvrpc qjm dkjjpmt rzrb fjcrzgq lqqbz vjj hxgbnc xbbcn xhc qjvvcvz ztjqx tsqpn cltx tcgmz dq ztmqrbvb qdrcnt htnmftg cxtgtz lknk xvtbk djqrsd qlmtgt tzgkm rcqb ffc hzkcvk vbbxd llpfvs skjn pbqgcl dtbfb nhgmnc nrl ndn jfbds jncgc pnqdpt txjxng pbjgn qxptn drmssh jxfz crgmxg (contains sesame, peanuts)\n" +
            "xkthpt ckrf qqtnt rtdhc vtxf jngvsq cltx jbjnx tsktk pkvhv qhps dtphdp hxgbnc rcqb dkjjpmt qltkhqt crxd slzdx cndz nrl vvgz ptnpb pzvx jxfz xhc ndn vndmsf rzrb vgj xskcmdk zzmvlnq hsbgl ddgd gzbs zvsgzv tfqsb fr jhddxv qjvvcvz sphfb tsqpn rcl grgjkz gvpd sbzllf cqtmst xbbcn kndt djqrsd xmctlnjx kskjbx zqzmzl mxvjf zbqrfb fkxl kxjszsfm krhfmd dmrfb cctgq (contains eggs, shellfish)\n" +
            "hsbgl ndn ztmqrbvb kskjbx xvtbk ngqdpq hllqx tfqsb dq crgmxg qjm pnqdpt jfbds zvsgzv pttq zmnpsx spthcff qxplxtp xnqfx qdrcnt vxltmm vqmdd txjxng lqqbz nrl cltx qjvvcvz zbvflpl nhgmnc qqtnt tnrmchc pkvhv bcbsh jncgc ddgd jxdms jhddxv cqstff zvthr bcfhrtlx pbqgcl kjflc tcgmz jrlvrx xhnk vkcf ccsm lxjkr llghzs hjkvk dnxhx vndmsf xpdqxtrh vtxf vgj sqr krhfmd zkr fccp jxfz ckrf jxbzxd pkknz krg sphfb nccmqg ktsnqg mdxq kxsll zqzmzl tsqpn (contains wheat, peanuts)\n" +
            "fchtgm qjm crrh bnjq rlpkdv lnhx zvthr rpjlrl zkr zvbpd xqlvq fmlc jbjnx pkknz kfzm zqzmzl cctgq hmhqq bcbsh jsbpht tsktk jhddxv rcl fkxl xggvd kskjbx qxptn grgjkz rzl tsqpn xhc klqj kxjszsfm xnqfx tzgkm dmx lhvcd ckrf xpdqxtrh hllqx tnrmchc fjcrzgq pbjgn rcqb kqpcn lqqbz vxltmm ccsm nrl mntxnf jxbzxd vkcf nhqz djqrsd cltx sfp cqstff rtdhc qmst zbhf cndz mdxq cxtgtz kqzdmd vgssk xskcmdk spthcff fftkllp mzhp szqr lxjkr qsddtb sqr tfqsb qjvvcvz xxf dmpnpc ptnpb xkthpt ndn qdrcnt znmhcfmc (contains shellfish)\n" +
            "xskcmdk mzhp jxbzxd jdcc pnqdpt qdhfqx zkqmd fr pbqgcl kskjbx zqzmzl vkcf mfcf cvkmvd nrl zbvflpl krg jfbds tvbppb qxptn nccmqg rlpkdv xvtbk nvmpqzd krhfmd pbjgn xggvd tfqsb tsqpn mbfb fftkllp skjn crrh vxltmm kqzdmd tsktk prbcss cltx dkjjpmt zbqrfb cqtmst ktsnqg fgdn hmhqq rcqb llpfvs tcgmz sphfb jrlvrx djqrsd lhvcd jncgc llghzs mntxnf rtdhc jsbpht bfbcl sbzllf jdlvgvp drmssh xpdqxtrh kschtq vjj zkr bnjq vtxf gbzml dsqdcl vgj xhnk (contains fish, peanuts)\n" +
            "jfbds tfqsb vgj chtpkf rcqb ckrf dmx jncgc lcktf qdhfqx nrl qjvvcvz nhgmnc rzl zvbpd pkvhv jhddxv cqstff bcfhrtlx spthcff vtxf bcbsh kskjbx lknk htnmftg cqtmst rlpkdv gstsgf mbfb dtbfb gzbs xpdqxtrh fjcrzgq vqmdd hcqs dtphdp zbqrfb xhnk zqzmzl tsqpn hjkvk gdffb nhqz (contains dairy, sesame)\n" +
            "tfqsb qxplxtp qdhfqx cqstff nrzc zkr jrlvrx cxtgtz tzgkm rtdhc tsqpn rcqb spthcff vgj cqtmst jncgc bcfhrtlx cvkmvd qsddtb nhqz fgdn qhps ptnpb pthkfzr xnqfx xxf fzhhqp htnmftg ckrf sdtsq llpfvs xhnk cfn slzdx dkjjpmt hmhqq bsdjq krg zqzmzl vjj pbjgn chtpkf rpjlrl cltx rcl qjvvcvz cctgq (contains peanuts, shellfish, wheat)\n" +
            "tzgkm htnmftg qjvvcvz pnqdpt tfqsb hzkcvk rcqb mfcf grgjkz jxbzxd kfzm xkthpt klqj vkcf qlmtgt kqpcn zvbpd jsbpht zvthr dtbfb crxd jxfz xhnk pttq crrh jxdms pbqgcl cqstff gtvk nrl kskjbx bbgjn hcqs fzhhqp dtphdp qxplxtp dsqdcl zkshp mdxq fjqns nvmpqzd fgdn kjflc xpdqxtrh qjm ndn zqzmzl hsbgl qxptn skjn cltx pzvx fjcrzgq xrlvd ktsnqg (contains nuts, eggs)\n" +
            "tsqpn ckrf ztjqx znmhcfmc rcqb nccmqg dsqdcl rtdhc pbjgn hmhqq ptnpb xrlvd mxvjf vbbxd pjkkm ngqdpq xskcmdk tzqf sqr xxf zmnpsx kqzdmd tfqsb dtphdp krhfmd lknk vxltmm dq spthcff nrl qmst drmssh zvthr htnmftg xhnk jncgc xbbcn bsdjq hzkcvk xmctlnjx qjm hllqx jxdms kfzm cxtgtz hcqs vqmdd tcgmz fmlc vgj slzdx kskjbx zqzmzl njtvrpc cltx zbvflpl gbzml gstsgf kschtq jbjnx (contains sesame)";

    private static final String INPUT2 = "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)\n" +
            "trh fvjkl sbzzf mxmxvkd (contains dairy)\n" +
            "sqjhc fvjkl (contains soy)\n" +
            "sqjhc mxmxvkd sbzzf (contains fish)";

    public static void main(String[] args) {
        Map<String, Set<String>> allergenToIntersectionSet = new HashMap<>();
        Multiset<String> ingredientCounts = HashMultiset.create();
        for (String line : INPUT.split("\n")) {
            String[] parenParts = line.split(" \\(contains ");
            String[] ingredients = parenParts[0].split(" ");
            String[] allergens = parenParts[1].substring(0, parenParts[1].length()-1).split(", ");
            ingredientCounts.addAll(Arrays.asList(ingredients));
            for (String allergen : allergens) {
                if (!allergenToIntersectionSet.containsKey(allergen)) {
                    allergenToIntersectionSet.put(allergen, new HashSet<>(Arrays.asList(ingredients)));
                } else {
                    allergenToIntersectionSet.put(allergen,
                            Sets.intersection(allergenToIntersectionSet.get(allergen),
                                    new HashSet<>(Arrays.asList(ingredients))));
                }
            }
        }
        Set<String> possibleSet = new HashSet<>();
        for (Set<String> s : allergenToIntersectionSet.values()) {
            possibleSet.addAll(s);
        }
        int res = 0;
        for (String ingredient : ingredientCounts.elementSet()) {
            if (!possibleSet.contains(ingredient)) {
                res += ingredientCounts.count(ingredient);
            }
        }
        System.out.println(res);

        List<Result> results = new ArrayList<>();
        while (!possibleSet.isEmpty()) {
            for (Map.Entry<String, Set<String>> entry : allergenToIntersectionSet.entrySet()) {
                Set<String> newPossible = Sets.intersection(entry.getValue(), possibleSet);
                if (newPossible.size() == 1) {
                    String allergen = entry.getKey();
                    String ingredient = newPossible.stream().findFirst().get();
                    results.add(new Result(ingredient, allergen));
                    possibleSet.remove(ingredient);
                }
            }
        }

        Collections.sort(results, new Comparator<Result>() {
            @Override
            public int compare(Result r1, Result r2) {
                return r1.allergen.compareTo(r2.allergen);
            }
        });
        System.out.println(StringUtils.join(results.stream().map(r -> r.ingredient).collect(Collectors.toList()), ","));
    }

    private static class Result {
        String ingredient;
        String allergen;

        public Result(String ingredient, String allergen) {
            this.ingredient = ingredient;
            this.allergen = allergen;
        }
    }
}
