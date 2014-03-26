import sun.io.ByteToCharConverter;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: qatang
 * Date: 13-11-20
 * Time: 09:44
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    static {
        _i = 20;
    }
    public static int _i = 10;

    public HelloWorld(String aa) {}

    public static void main(String[] args) {
        //测试static属性初始化方式
//        System.out.println(_i);
//        Integer[] a = {
//                new Integer(1),
//                new Integer(2)
//        };
//         System.out.println((int)'a');
//         System.out.println((char) 149);

//        String[] s = {"a", "b"};
//        List<String> aa = new ArrayList<String>();
//        Collections.addAll(aa, s);
//        Arrays.asList(s);
//        System.out.println(aa.get(0));

        System.out.println(Object[].class.getName());
        List<String> bbb = new ArrayList<String>();
        bbb.add("aaa");
        bbb.add("bbb");
        bbb.iterator().next();
        for (Iterator<String> iter = bbb.iterator(); iter.hasNext();) {
             iter.next();
        }
        System.out.println(bbb.toArray().getClass().getName());

//        List<String> bb = new ArrayList<String>(bbb);

//        String msg = String.format("创建订单失败：未查询到id=%s的商户app", 111111);
//        System.out.println(msg);
//
//        Double d = 12.3366;
//
//        System.out.println(String.format("%2$08d", -3123,-5566));
//        System.out.println(String.format("%1$9d", -31));
//        System.out.println(String.format("%1$-9d", -31));
//        System.out.println(String.format("%1$(9d", -31));
//        System.out.println(String.format("%1$#9x", 5689));
//
//        //小数点后面两位
//        System.out.println(String.format("%1$.2f", 5689.0)); //必须是同类型的才能进行转换

        //格式化的位置
        /*String str = "I love ni %s, you love me %s";
        String str2 = "I love ni %2$s, you love me %1$s";

        System.out.println(String.format(str, "renjunjie","songliyu"));

        System.out.println(String.format(str2, "renjunjie","songliyu"));*/


        //数组的操作
        Object[] sendData = new Object[4];
        sendData[0] = Integer.valueOf(1);
        sendData[1] = "172.12.1.2";
        sendData[2] = Integer.valueOf(123);
        sendData[3] = "testadfaerfa";
        String sendDataString = String.format("%d,%s,%d,%s",(Object[]) sendData);
        System.out.println(sendDataString);

//        List<String> list = new ArrayList<String>();
//        list.add("aa");
//        List<String> list2 = new ArrayList<String>();
//        list2.addAll(list);
//        System.out.println(list.get(0) == list2.get(0));
//
//        int i = 1 << 4;
//        i = 15 << 1;
//        System.out.println(i);

//          int i = 1 >> 4;
          //0000 0000 0000 0000 0000 0000 0000 0001
          //0000 0000 0000 0000 0000 0000 0000 0000
//         System.out.println(i);
//        int j = -11 >> 2;
        //原码 1000 0000 0000 0000 0000 0000 0000 1011
        //反码 1111 1111 1111 1111 1111 1111 1111 0100
        //补码 1111 1111 1111 1111 1111 1111 1111 0101
        //向右移2位 1111 1111 1111 1111 1111 1111 1111 1101
        //反码 1000 0000 0000 0000 0000 0000 0000 0010
        //补码 1000 0000 0000 0000 0000 0000 0000 0011
        //结果为-3
//        System.out.println(j);

//        0001 0010 18
//        0010 0100 32 + 4=36
//        0100 1000 64 + 8 = 72

//        int i;
//        int num = 0xFFFFFFE;
//        System.out.println("0000" + Integer.toBinaryString(num));
//        for(i=0; i<4; i++) {
//            num = num << 1;
//            System.out.println("hex:" + Integer.toHexString(num));
//            System.out.println("binaray:" + Integer.toBinaryString(num));
//            System.out.println(num);
//        }

//        System.out.println(Integer.toBinaryString(127));
//        System.out.println(Integer.toBinaryString(-127));
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.toBinaryString(128));
//        System.out.println(Integer.toBinaryString(-128));

//        Map<String , String> map  =   new HashMap<String , String>();
//        map.put( " What " ,  " chenyz " );
//        map.put( " You " ,  " chenyz " );
//        map.put( " Don't " ,  " chenyz " );
//        map.put( " Know " ,  " chenyz " );
//        map.put( " About " ,  " chenyz " );
//        map.put( " Geo " ,  " chenyz " );
//        map.put( " APIs " ,  " chenyz " );
//        map.put( " Can't " ,  " chenyz " );
//        map.put( " Hurt " ,  " chenyz " );
//        map.put( " you " ,  " chenyz " );
//        map.put( " google " ,  " chenyz " );
//        map.put( " map " ,  " chenyz " );
//        map.put( " hello " ,  " chenyz " );
//
//        Iterator<String> iter = map.keySet().iterator();
//        iter.next();

//        System.out.println(5 & 3);// 5=0101  3=0011  按位与 得到 0001，故结果为1
//        System.out.println(5 | 3);// 5=0101  3=0011  按位或 得到 0111，故结果为7
//        System.out.println(5 ^ 3);// 5=0101  3=0011  按位异或 得到 0110，故结果为6
//        System.out.println(~5);// 5=0000 0000 0000 0000 0000 0000 0000 0101  按位非 得到
                               // 1111 1111 1111 1111 1111 1111 1111 1010，需要取该二进制数的补码
                               // 先取反码，最高位为符号位不变,反码：1000 0000 0000 0000 0000 0000 0000 0101
                               // 再取补码，最高位为符号位不变,反码：1000 0000 0000 0000 0000 0000 0000 0110,故最后结果为-6


//        AbstractSpoon spoon = new Spoon("aaa");
//        AbstractSpoon spoon2 = new Spoon("bbb");
//        spoon.setSpoonName("111");
//
//        spoon2 = (AbstractSpoon)spoon.clone();
//        spoon2.setSpoonName("222");
//
//        System.out.println(spoon.getSpoonName());
//        System.out.println(spoon2.getSpoonName());
//
//
//        System.out.println(spoon == spoon2);
//        System.out.println(spoon.getClass() == spoon2.getClass());


//          System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toHexString(65));
//        char a = 0x41;
//        System.out.println("result:" + a);

//        String aa = "ab我";
//        System.out.println(aa.codePointAt(2));
////        System.out.println(aa.codePointCount(0, aa.length()));
//        byte[] aaBytes = aa.getBytes();
//        System.out.println(aaBytes);
//
//        String bb = "中";
//        try {
//            byte[] b_gbk = bb.getBytes("GBK");
//            byte[] b_utf8 = bb.getBytes("UTF-8");
//            byte[] b_iso88591 = bb.getBytes("ISO8859-1");
//            System.out.println(b_gbk);
//            System.out.println(b_utf8);
//            System.out.println(b_iso88591);
//        } catch (Exception e) {}
//
//        Integer a = 110000;
//        System.out.println(a.byteValue());

//        char[] chs = Character.toChars(0x10400);
//        System.out.printf("U+10400 高代理字符: %04x%n", (int)chs[0]);
//        System.out.printf("U+10400 低代理字符: %04x%n", (int)chs[1]);
//        String str = new String(chs);
//        System.out.println("代码单元长度: " + str.length());
//        System.out.println("代码点数量: " + str.codePointCount(0, str.length()));


//        String str = "abc\\u811adef\\u672cghi";
//        System.out.println(unicode2Str(str));
//        System.out.println(str2Unicode("222ds测1试aa"));

//        String encoding = "gb2312";
//        byte b[] = {(byte)'\u00c4',(byte)'\u00e3'};
//        ByteToCharConverter converter = ByteToCharConverter.getConverter(encoding);
//        char c[] = converter.convertAll(b);
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(Integer.toHexString(c[i]));
//        }

//         new Cupboard();
//         new Cupboard();
//        table.f2(1);
//        cupboard.f3(1);

    }
//     static Table table = new Table();
//     static Cupboard cupboard = new Cupboard();


    public static String unicode2Str(String str) {
        StringBuffer sb = new StringBuffer();
        String[] arr = str.split("\\\\u");
        int len = arr.length;
        sb.append(arr[0]);
        for(int i=1; i<len; i++){
            String tmp = arr[i];
            char c = (char)Integer.parseInt(tmp.substring(0, 4), 16);
            sb.append(c);
            sb.append(tmp.substring(4));
        }
        return sb.toString();
    }

    /**
     * 字符串转unicode
     * @param str
     * @return
     */
    public static String str2Unicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] charArr = str.toCharArray();
        for (char ch : charArr) {
            if (ch > 128) {
                sb.append("\\u" + Integer.toHexString(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}
