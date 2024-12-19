package com.echo8.aoc2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day9Part2 {
    private static final String INPUT = "47\n" +
            "26\n" +
            "33\n" +
            "48\n" +
            "45\n" +
            "49\n" +
            "50\n" +
            "4\n" +
            "10\n" +
            "39\n" +
            "32\n" +
            "42\n" +
            "38\n" +
            "23\n" +
            "19\n" +
            "8\n" +
            "31\n" +
            "7\n" +
            "37\n" +
            "21\n" +
            "13\n" +
            "9\n" +
            "35\n" +
            "16\n" +
            "43\n" +
            "11\n" +
            "34\n" +
            "46\n" +
            "12\n" +
            "14\n" +
            "58\n" +
            "15\n" +
            "71\n" +
            "17\n" +
            "25\n" +
            "18\n" +
            "24\n" +
            "28\n" +
            "62\n" +
            "20\n" +
            "27\n" +
            "19\n" +
            "22\n" +
            "30\n" +
            "23\n" +
            "80\n" +
            "21\n" +
            "26\n" +
            "36\n" +
            "29\n" +
            "39\n" +
            "31\n" +
            "32\n" +
            "33\n" +
            "35\n" +
            "34\n" +
            "37\n" +
            "38\n" +
            "40\n" +
            "99\n" +
            "73\n" +
            "74\n" +
            "112\n" +
            "41\n" +
            "57\n" +
            "42\n" +
            "43\n" +
            "49\n" +
            "70\n" +
            "66\n" +
            "67\n" +
            "47\n" +
            "55\n" +
            "60\n" +
            "61\n" +
            "83\n" +
            "63\n" +
            "65\n" +
            "77\n" +
            "76\n" +
            "71\n" +
            "75\n" +
            "78\n" +
            "81\n" +
            "129\n" +
            "89\n" +
            "84\n" +
            "139\n" +
            "181\n" +
            "85\n" +
            "108\n" +
            "92\n" +
            "136\n" +
            "102\n" +
            "107\n" +
            "110\n" +
            "112\n" +
            "124\n" +
            "163\n" +
            "128\n" +
            "143\n" +
            "134\n" +
            "183\n" +
            "153\n" +
            "146\n" +
            "152\n" +
            "165\n" +
            "173\n" +
            "166\n" +
            "177\n" +
            "169\n" +
            "194\n" +
            "212\n" +
            "269\n" +
            "187\n" +
            "232\n" +
            "199\n" +
            "219\n" +
            "280\n" +
            "306\n" +
            "293\n" +
            "275\n" +
            "252\n" +
            "262\n" +
            "277\n" +
            "386\n" +
            "286\n" +
            "315\n" +
            "298\n" +
            "311\n" +
            "317\n" +
            "353\n" +
            "335\n" +
            "343\n" +
            "421\n" +
            "381\n" +
            "679\n" +
            "399\n" +
            "451\n" +
            "471\n" +
            "543\n" +
            "418\n" +
            "562\n" +
            "514\n" +
            "552\n" +
            "594\n" +
            "673\n" +
            "529\n" +
            "1235\n" +
            "563\n" +
            "633\n" +
            "584\n" +
            "615\n" +
            "651\n" +
            "1187\n" +
            "724\n" +
            "817\n" +
            "678\n" +
            "1097\n" +
            "780\n" +
            "850\n" +
            "1144\n" +
            "1238\n" +
            "869\n" +
            "889\n" +
            "1656\n" +
            "1167\n" +
            "1136\n" +
            "1528\n" +
            "1986\n" +
            "1092\n" +
            "1178\n" +
            "1113\n" +
            "1147\n" +
            "1196\n" +
            "1402\n" +
            "1235\n" +
            "1339\n" +
            "1468\n" +
            "1504\n" +
            "2124\n" +
            "1914\n" +
            "1458\n" +
            "2357\n" +
            "1630\n" +
            "1739\n" +
            "2640\n" +
            "1961\n" +
            "2016\n" +
            "2291\n" +
            "4140\n" +
            "2325\n" +
            "2693\n" +
            "2741\n" +
            "2703\n" +
            "2205\n" +
            "2654\n" +
            "2260\n" +
            "2343\n" +
            "4670\n" +
            "2574\n" +
            "3474\n" +
            "2797\n" +
            "4432\n" +
            "2962\n" +
            "3197\n" +
            "3653\n" +
            "5490\n" +
            "3369\n" +
            "3977\n" +
            "3700\n" +
            "4359\n" +
            "4221\n" +
            "6684\n" +
            "9338\n" +
            "6025\n" +
            "5001\n" +
            "4465\n" +
            "4548\n" +
            "7353\n" +
            "6619\n" +
            "6725\n" +
            "4603\n" +
            "5140\n" +
            "6048\n" +
            "6795\n" +
            "5759\n" +
            "7018\n" +
            "7921\n" +
            "6662\n" +
            "6566\n" +
            "7590\n" +
            "8978\n" +
            "7069\n" +
            "7677\n" +
            "8059\n" +
            "8686\n" +
            "11706\n" +
            "13066\n" +
            "9013\n" +
            "9068\n" +
            "12055\n" +
            "10224\n" +
            "11114\n" +
            "12817\n" +
            "13387\n" +
            "18368\n" +
            "9743\n" +
            "13361\n" +
            "11807\n" +
            "13680\n" +
            "17680\n" +
            "13228\n" +
            "13635\n" +
            "18775\n" +
            "14156\n" +
            "14746\n" +
            "18283\n" +
            "15128\n" +
            "19292\n" +
            "23169\n" +
            "29487\n" +
            "26204\n" +
            "18081\n" +
            "19237\n" +
            "37318\n" +
            "23130\n" +
            "19967\n" +
            "32237\n" +
            "24624\n" +
            "39230\n" +
            "38258\n" +
            "27041\n" +
            "25035\n" +
            "25442\n" +
            "26863\n" +
            "41991\n" +
            "46393\n" +
            "28381\n" +
            "28902\n" +
            "37286\n" +
            "37575\n" +
            "35095\n" +
            "45409\n" +
            "62360\n" +
            "57253\n" +
            "38048\n" +
            "79277\n" +
            "39204\n" +
            "42367\n" +
            "49993\n" +
            "78895\n" +
            "44591\n" +
            "49659\n" +
            "64239\n" +
            "73143\n" +
            "50477\n" +
            "51898\n" +
            "52305\n" +
            "66188\n" +
            "63476\n" +
            "78040\n" +
            "80686\n" +
            "57283\n" +
            "63997\n" +
            "72381\n" +
            "72670\n" +
            "74299\n" +
            "82639\n" +
            "77252\n" +
            "80415\n" +
            "81571\n" +
            "92844\n" +
            "89681\n" +
            "86958\n" +
            "94250\n" +
            "114474\n" +
            "95068\n" +
            "100136\n" +
            "126604\n" +
            "124568\n" +
            "194889\n" +
            "124686\n" +
            "109588\n" +
            "120759\n" +
            "121280\n" +
            "129664\n" +
            "129953\n" +
            "131582\n" +
            "146969\n" +
            "210368\n" +
            "168549\n" +
            "151551\n" +
            "158823\n" +
            "164210\n" +
            "161986\n" +
            "204656\n" +
            "283266\n" +
            "242039\n" +
            "181208\n" +
            "189318\n" +
            "209542\n" +
            "330301\n" +
            "279582\n" +
            "230347\n" +
            "230868\n" +
            "239541\n" +
            "286672\n" +
            "239252\n" +
            "250423\n" +
            "261535\n" +
            "259617\n" +
            "276922\n" +
            "278551\n" +
            "441568\n" +
            "428166\n" +
            "323033\n" +
            "310374\n" +
            "368365\n" +
            "345418\n" +
            "428859\n" +
            "390750\n" +
            "370526\n" +
            "450853\n" +
            "412076\n" +
            "398860\n" +
            "449083\n" +
            "461215\n" +
            "469599\n" +
            "469888\n" +
            "668400\n" +
            "478793\n" +
            "897765\n" +
            "489675\n" +
            "673611\n" +
            "521152\n" +
            "680900\n" +
            "746810\n" +
            "649077\n" +
            "759115\n" +
            "939487\n" +
            "633407\n" +
            "1440015\n" +
            "780441\n" +
            "715944\n" +
            "877942\n" +
            "831741\n" +
            "769386\n" +
            "810936\n" +
            "860075\n" +
            "847943\n" +
            "910298\n" +
            "1170229\n" +
            "948392\n" +
            "1837252\n" +
            "968468\n" +
            "1590856\n" +
            "1010827\n" +
            "1123082\n" +
            "1154559\n" +
            "1202052\n" +
            "1418463\n" +
            "1380217\n" +
            "1728833\n" +
            "1392522\n" +
            "1349351\n" +
            "2372281\n" +
            "1485330\n" +
            "1547685\n" +
            "1526880\n" +
            "2345405\n" +
            "3205480\n" +
            "1580322\n" +
            "1658879\n" +
            "2317819\n" +
            "2386931\n" +
            "1858690\n" +
            "2749737\n" +
            "3251212\n" +
            "2649962\n" +
            "2516153\n" +
            "2133909\n" +
            "2165386\n" +
            "2277641\n" +
            "2767814\n" +
            "2551403\n" +
            "2741873\n" +
            "2772739\n" +
            "2834681\n" +
            "3830735\n" +
            "2876231\n" +
            "3012210\n" +
            "3650716\n" +
            "5391835\n" +
            "3107202\n" +
            "3792788\n" +
            "4426693\n" +
            "3239201\n" +
            "3517569\n" +
            "3992599\n" +
            "4024076\n" +
            "5067556\n" +
            "4443027\n" +
            "8467103\n" +
            "4299295\n" +
            "4907259\n" +
            "4411550\n" +
            "4829044\n" +
            "5019514\n" +
            "5644045\n" +
            "5293276\n" +
            "7438903\n" +
            "5607420\n" +
            "8400478\n" +
            "5888441\n" +
            "7550229\n" +
            "6119412\n" +
            "6756770\n" +
            "8204338\n" +
            "7944262\n" +
            "7031989\n" +
            "8424828\n" +
            "7650751\n" +
            "8821643\n" +
            "9736303\n" +
            "9462541\n" +
            "12479795\n" +
            "8710845\n" +
            "9128339\n" +
            "9206554\n" +
            "9240594\n" +
            "19236565\n" +
            "12400815\n" +
            "10626934\n" +
            "10900696\n" +
            "13551682\n" +
            "11495861\n" +
            "13258171\n" +
            "14701032\n" +
            "12645211\n" +
            "15754567\n" +
            "23545907\n" +
            "13788759\n" +
            "14682740\n" +
            "17917399\n" +
            "15456817\n" +
            "18277685\n" +
            "16361596\n" +
            "17532488\n" +
            "17839184\n" +
            "17951439\n" +
            "18447148\n" +
            "18334893\n" +
            "18368933\n" +
            "19833488\n" +
            "25601728\n" +
            "35588055\n" +
            "23301511\n" +
            "35041768\n" +
            "24452378\n" +
            "30484395\n" +
            "26952678\n" +
            "25903382\n" +
            "26433970\n" +
            "27327951\n" +
            "29543326\n" +
            "31321247\n" +
            "30139557\n" +
            "31044336\n" +
            "32989305\n" +
            "31818413\n" +
            "34730529\n" +
            "35979636\n" +
            "41140695\n" +
            "35790623\n" +
            "36286332\n" +
            "44768863\n" +
            "49204893\n" +
            "70370591\n" +
            "43134999\n" +
            "49735481\n" +
            "47753889\n" +
            "58372287\n" +
            "50355760\n" +
            "50886348\n" +
            "52337352\n" +
            "56871277\n" +
            "57467508\n" +
            "53761921\n" +
            "81930684\n" +
            "59682883\n" +
            "61183893\n" +
            "61957970\n" +
            "62862749\n" +
            "64807718\n" +
            "67798049\n" +
            "84040221\n" +
            "71770259\n" +
            "72076955\n" +
            "78925622\n" +
            "93157609\n" +
            "104318892\n" +
            "90888888\n" +
            "92870480\n" +
            "97489370\n" +
            "98109649\n" +
            "108728047\n" +
            "102693112\n" +
            "101242108\n" +
            "103223700\n" +
            "121678995\n" +
            "128981942\n" +
            "115719891\n" +
            "113444804\n" +
            "120866776\n" +
            "122545632\n" +
            "219168365\n" +
            "235990436\n" +
            "160955658\n" +
            "136577977\n" +
            "139568308\n" +
            "143847214\n" +
            "150695881\n" +
            "215416112\n" +
            "229164695\n" +
            "219870830\n" +
            "183759368\n" +
            "188378258\n" +
            "247070914\n" +
            "222921103\n" +
            "350294614\n" +
            "434584477\n" +
            "203935220\n" +
            "333315634\n" +
            "282634653\n" +
            "234311580\n" +
            "518625089\n" +
            "236586667\n" +
            "243412408\n" +
            "294543095\n" +
            "259123609\n" +
            "280425191\n" +
            "276146285\n" +
            "344715026\n" +
            "533093284\n" +
            "283415522\n" +
            "347782434\n" +
            "334455249\n" +
            "372137626\n" +
            "784879091\n" +
            "387694588\n" +
            "392313478\n" +
            "422689838\n" +
            "426856323\n" +
            "827636379\n" +
            "613740825\n" +
            "470898247\n" +
            "440521887\n" +
            "617089902\n" +
            "657001418\n" +
            "477723988\n" +
            "479999075\n" +
            "628998344\n" +
            "707281514\n" +
            "577958617\n" +
            "610601534\n" +
            "906855398\n" +
            "867548533\n" +
            "631197956\n" +
            "948196074\n" +
            "552655238\n" +
            "812179237\n" +
            "706592875\n" +
            "794827464\n" +
            "780008066\n" +
            "1429269139\n" +
            "815003316\n" +
            "950897322\n" +
            "1252701124\n" +
            "1018480504\n" +
            "911420134\n" +
            "1283077484\n" +
            "918245875\n" +
            "1030379226\n" +
            "1260007141\n" +
            "957723063\n" +
            "1398244950\n" +
            "1130613855\n" +
            "1317194409\n" +
            "1183853194\n" +
            "1657490197\n" +
            "1367658554\n" +
            "1347482702\n" +
            "1845382542\n" +
            "1259248113\n" +
            "1811903351\n" +
            "1486600941\n" +
            "1501420339\n" +
            "1574835530\n" +
            "2063085550\n" +
            "3192865244\n" +
            "2531335896\n" +
            "1829666009\n" +
            "1869143197\n" +
            "1875968938\n" +
            "1941799360\n" +
            "1948625101\n" +
            "1988102289\n" +
            "3430744104\n" +
            "2088336918\n" +
            "5724201140\n" +
            "2715439359\n" +
            "2314467049\n" +
            "2443101307\n" +
            "4030136278\n" +
            "2626906667\n" +
            "2834083643\n" +
            "2606730815\n" +
            "3900240269\n" +
            "2745849054\n" +
            "3874988901\n" +
            "4506186857\n" +
            "5342346026\n" +
            "3404501539\n" +
            "6657042945\n" +
            "9263773760\n" +
            "3698809206\n" +
            "3705634947\n" +
            "3857245486\n" +
            "4076439207\n" +
            "3890424461\n" +
            "6910522850\n" +
            "4941373716\n" +
            "4402803967\n" +
            "4531438225\n" +
            "5233637482\n" +
            "10532031846\n" +
            "4757568356\n" +
            "5277184950\n" +
            "8582626064\n" +
            "5352579869\n" +
            "5440814458\n" +
            "6312365762\n" +
            "10818552619\n" +
            "7580623848\n" +
            "7103310745\n" +
            "10808945692\n" +
            "9209825355\n" +
            "7480940746\n" +
            "7404444153\n" +
            "7556054692\n" +
            "7562880433\n" +
            "7596059408\n" +
            "9167609411\n" +
            "8607877432\n" +
            "8293228428\n" +
            "8934242192\n" +
            "9344177683\n" +
            "9160372323\n" +
            "9765075707\n" +
            "14520189280\n" +
            "12353627764\n" +
            "11753180220\n" +
            "10629764819\n" +
            "12757024022\n" +
            "12915460302\n" +
            "12544125203\n" +
            "13716809915\n" +
            "14960498845\n" +
            "14507754898\n" +
            "15118935125\n" +
            "22324687347\n" +
            "14885384899\n" +
            "21704497526\n" +
            "14967324586\n" +
            "16940237091\n" +
            "19564007011\n" +
            "15889287836\n" +
            "21050252450\n" +
            "16901105860\n" +
            "31447991989\n" +
            "18094614515\n" +
            "18504550006\n" +
            "27320952350\n" +
            "20394840526\n" +
            "22382945039\n" +
            "22983392583\n" +
            "23173890022\n" +
            "29393139797\n" +
            "34619957828\n" +
            "35444787097\n" +
            "28684134501\n" +
            "32221359921\n" +
            "29468253743\n" +
            "29475079484\n" +
            "31008222961\n" +
            "29852709485\n" +
            "39923629674\n" +
            "45282427633\n" +
            "41445092976\n" +
            "50315974436\n" +
            "58536843986\n" +
            "32790393696\n" +
            "83106368132\n" +
            "46157282605\n" +
            "64428485559\n" +
            "68456317655\n" +
            "68265820216\n" +
            "42777785565\n" +
            "52616200447\n" +
            "45366337622\n" +
            "57793847850\n" +
            "51858024523\n" +
            "58077274298\n" +
            "58152388244\n" +
            "98309027140\n" +
            "60483302445\n" +
            "72144989595\n" +
            "58943333227\n" +
            "59327788969\n" +
            "89951556188\n" +
            "74235486672\n" +
            "72714023370\n" +
            "97218879255\n" +
            "75568179261\n" +
            "78156731318\n" +
            "84648418219\n" +
            "100571633415\n" +
            "130772931765\n" +
            "88935068170\n" +
            "88144123187\n" +
            "94635810088\n" +
            "104694126591\n" +
            "95393986012\n" +
            "104474224970\n" +
            "192618348157\n" +
            "231344565180\n" +
            "118271122196\n" +
            "116229662542\n" +
            "134718789117\n" +
            "119426635672\n" +
            "315992983399\n" +
            "134511512488\n" +
            "131657356597\n" +
            "132041812339\n" +
            "210286968378\n" +
            "146949510042\n" +
            "148282202631\n" +
            "175375610573\n" +
            "153724910579\n" +
            "248271474881\n" +
            "357236478420\n" +
            "177079191357\n" +
            "219801479784\n" +
            "182779933275\n" +
            "200088112603\n" +
            "252976329222\n" +
            "209168351561\n" +
            "235656298214\n" +
            "220703887512\n" +
            "234500784738\n" +
            "250312934535\n" +
            "250741175030\n" +
            "419455319939\n" +
            "251468448011\n" +
            "251083992269\n" +
            "359859124632\n" +
            "263699168936\n" +
            "428351939795\n" +
            "278991322381\n" +
            "411031908787\n" +
            "295231712673\n" +
            "368083682415\n" +
            "329100521152\n" +
            "336504843854\n" +
            "377167303960\n" +
            "409256464164\n" +
            "670539312208\n" +
            "391948284836\n" +
            "462144680783\n" +
            "420792000115\n" +
            "429872239073\n" +
            "443669136299\n" +
            "455204672250\n" +
            "471016822047\n" +
            "484813719273\n" +
            "501825167299\n" +
            "514440343966\n" +
            "891607647926\n" +
            "502552440280\n" +
            "757376393456\n" +
            "734715990983\n" +
            "542690491317\n" +
            "706263621460\n" +
            "574223035054\n" +
            "663315395088\n" +
            "869908849714\n" +
            "946958400056\n" +
            "839128703237\n" +
            "713672147814\n" +
            "769115588796\n" +
            "801204749000\n" +
            "917349353033\n" +
            "885076911323\n" +
            "850664239188\n" +
            "864461136414\n" +
            "873541375372\n" +
            "1674746124372\n" +
            "1220703965426\n" +
            "955830541320\n" +
            "1419935769274\n" +
            "1271668029076\n" +
            "1116913526371\n" +
            "1216224588094\n" +
            "1045242931597\n" +
            "1206005886405\n" +
            "1756478056270\n" +
            "1369579016548\n" +
            "1482787736610\n" +
            "1237538430142\n" +
            "1934983424164\n" +
            "1608244292033\n" +
            "1712670078609\n" +
            "2458242395568\n" +
            "1781810489447\n" +
            "1570320337796\n" +
            "3431224180642\n" +
            "1715125375602\n" +
            "1724205614560\n" +
            "1981374662785\n" +
            "1738002511786\n" +
            "1829371916692\n" +
            "2001073472917\n" +
            "2072744067691\n" +
            "2172055129414\n" +
            "2465178700871\n" +
            "2162156457968\n" +
            "2760368307199\n" +
            "2251248818002\n" +
            "2282781361739\n" +
            "2443544316547\n" +
            "2607117446690\n" +
            "3902115984383\n" +
            "2807858767938\n" +
            "4215361738723\n" +
            "3178564629829\n" +
            "3282990416405\n" +
            "5432297653559\n" +
            "3285445713398\n" +
            "4444937819707\n" +
            "4475493682801\n" +
            "3439330990162\n" +
            "3453127887388\n" +
            "4331323061250\n" +
            "4588492109475\n" +
            "3567374428478\n" +
            "7341446974545\n" +
            "6464010343227\n" +
            "4234900525659\n" +
            "4334211587382\n" +
            "4413405275970\n" +
            "5059107585940\n" +
            "6726742500803\n" +
            "4534030179741\n" +
            "5090640129677\n" +
            "5050661763237\n" +
            "5414976214628\n" +
            "7187561697781\n" +
            "5986423397767\n" +
            "6852820141876\n" +
            "6461555046234\n" +
            "6568436129803\n" +
            "6724776703560\n" +
            "8947435455711\n" +
            "8868104102016\n" +
            "10877415619197\n" +
            "7674231515821\n" +
            "7020502315866\n" +
            "9472512861910\n" +
            "7802274954137\n" +
            "7901586015860\n" +
            "8569112113041\n" +
            "8648305801629\n" +
            "8747616863352\n" +
            "8868241767123\n" +
            "9464067039207\n" +
            "12079609901806\n" +
            "13577596845436\n" +
            "9584691942978\n" +
            "14242667645624\n" +
            "10465637977865\n" +
            "11401399612395\n" +
            "12447978444001\n" +
            "16849021471571\n" +
            "15501125943505\n" +
            "13186331749794\n" +
            "18332308806330\n" +
            "17516547568752\n" +
            "14694733831687\n" +
            "14822777270003\n" +
            "15888744082989\n" +
            "16322537317450\n" +
            "14922088331726\n" +
            "26322277547430\n" +
            "15703860969997\n" +
            "16470698128901\n" +
            "23471083071632\n" +
            "17395922664981\n" +
            "20050329920843\n" +
            "29900134162886\n" +
            "19048758982185\n" +
            "23481009514201\n" +
            "20986091555373\n" +
            "24279425774665\n" +
            "21867037590260\n" +
            "25288415247868\n" +
            "26902525555900\n" +
            "27142712275688\n" +
            "28108420081520\n" +
            "27881065581481\n" +
            "48769424762069\n" +
            "30810832414715\n" +
            "29517511101690\n" +
            "38175743345888\n" +
            "29744865601729\n" +
            "38337735719161\n" +
            "30625949301723\n" +
            "34752619952182\n" +
            "32174559098898\n" +
            "47931395502324\n" +
            "43373223684801\n" +
            "52387845856185\n" +
            "40876932179182\n" +
            "48867157136854\n" +
            "40034850537558\n" +
            "74155572384722\n" +
            "42853129145633\n" +
            "49567841022533\n" +
            "46146463364925\n" +
            "47155452838128\n" +
            "56099247662583\n" +
            "54783591137381\n" +
            "55023777857169\n" +
            "55989485663001\n" +
            "60055624680379\n" +
            "59262376703419\n" +
            "79214667898343\n" +
            "60143460403413\n" +
            "61919424700627\n" +
            "60370814903452\n" +
            "90681573982102\n" +
            "62800508400621\n" +
            "66927179051080\n" +
            "81041716235752\n" +
            "80911782716740\n" +
            "90008581983761\n" +
            "82887979683191\n" +
            "83730061324815\n" +
            "92420970168166\n" +
            "86181313902483\n";

    public static void main(String[] args) {
        List<Long> nums = Arrays.stream(INPUT.split("\n")).map(Long::parseLong).collect(Collectors.toList());
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.subList(i, j+1).stream().mapToLong(n -> n).sum() == 552655238L) {
                    long min = nums.subList(i, j+1).stream().mapToLong(n -> n).min().getAsLong();
                    long max = nums.subList(i, j+1).stream().mapToLong(n -> n).max().getAsLong();
                    System.out.println(min+max);
                    return;
                }
            }
        }
    }
}