import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Created by qatang on 14-3-21.
 */
public class CharsetTest {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_UTF16 = "UTF-16";
    public static final String CHARSET_GBK = "GBK";
    public static final String CHARSET_GB2312 = "gb2312";

    public static void main(String[] args) throws Exception {
        //字节，字符，字符串，字符集，字符编码

        //字节byte，实际计算机存储的单位，8位(bit)一个字节，跟编码方式有关（gbk,utf8）
        //字符 "a"是一个字符，"我"也是一个字符，具体显示成什么样，跟你所拥护的字体有关
        //字符串 "abc我日"
        //字符集，所有字符的集合，unicode字符集是把全世界的字符都弄进去了，gb2312是中国弄的一套汉字的字符集
        //字符编码 某个字符集中的某个字符存放到计算机的字节中，需要几个字节，每个字节实际的值是多少，所以每个字符集的字符编码是不一样的。
        //        比如unicode包含多种字符编码，utf-8，utf-16，utf-32等等，
        //        而gb2312这个字符集的字符编码也叫gb2312，也就是gb2312字符集里就已经有字符编码了

        //一个http请求把一个字节数组传输给你，实际上这个字节数组使用gb2312编码的，你接收这个字节数组，然后用utf8编码来读取，那就绝逼乱码了，这就是乱码的原因。
        //无论是utf8还是gb2312都是兼容ascii码的，也就是说：a这个字符在这两种字符集中的编码是一样的

        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset().displayName());//根据系统默认字符集来确定

        String aaa = "abc我日";

        {//gb2312
            byte[] aaaArray = aaa.getBytes(CHARSET_GB2312);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            for (byte b : aaaArray) {
                sb.append(b).append(" ");
                sb1.append(Integer.toHexString(b)).append(" ");
            }
            System.out.println(CHARSET_GB2312 + " 字节(byte)的十进制 : " + sb.toString());
            System.out.println(CHARSET_GB2312 + " 字节(byte)的十六进制 : " + sb1.toString());
            System.out.println("gb2312使用2个字节表示一个汉字");
            System.out.println("---------------------");
        }

        {//java使用unicode字符集，所以我知道aaa可以赋值为任意汉字字符，如果我赋值给aaa一个很生僻的汉字字符，比如“囧”这个字，这个字符在gb2312字符集中没有
         //然后我通过aaa.getBytes("gb2312")来得到这个字符的字节数组，会得到什么样的结果？

        //输入一个gb2312字符集不包含的字符，
            String bbb = "囧"; //java使用unicode字符集，将aaa转换成gb2312字符集时，会去查找对应字符是否存在，如果不存在就返回“?”
            byte[] bbbArray = bbb.getBytes(CHARSET_GB2312);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            for (byte b : bbbArray) {
                sb.append(b).append(" ");
                sb1.append(Integer.toHexString(b)).append(" ");
            }
            System.out.println(CHARSET_GB2312 + " 字节(byte)的十进制 : " + sb.toString());//63小于127，明显属于ascii码范围
            System.out.println(CHARSET_GB2312 + " 字节(byte)的十六进制 : " + sb1.toString());
            System.out.println(CHARSET_GB2312 + " 囧 字打不出来 : " + new String(bbbArray, CHARSET_GB2312));
            System.out.println("gb2312使用2个字节表示一个汉字");
            System.out.println("---------------------");
        }

        {//gbk
            byte[] aaaArray = aaa.getBytes(CHARSET_GBK);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            for (byte b : aaaArray) {
                sb.append(b).append(" ");
                sb1.append(Integer.toHexString(b)).append(" ");
            }
            System.out.println(CHARSET_GBK + " 字节(byte)的十进制 : " + sb.toString());
            System.out.println(CHARSET_GBK + " 字节(byte)的十六进制 : " + sb1.toString());
            System.out.println("gbk是gb2312的扩展，兼容gb2312，包含了更多的汉字");
            System.out.println("---------------------");
        }

        {//utf-8
            byte[] aaaArray = aaa.getBytes(CHARSET_UTF8);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (byte b : aaaArray) {
                sb.append(b).append(" ");
                sb1.append(Integer.toHexString(b)).append(" ");
                sb2.append(Integer.toBinaryString(b)).append(" ");
            }
            System.out.println(CHARSET_UTF8 + " 字节(byte)的十进制 : " + sb.toString());
            System.out.println(CHARSET_UTF8 + " 字节(byte)的十六进制 : " + sb1.toString());
            System.out.println(CHARSET_UTF8 + " 字节(byte)的二进制 : " + sb2.toString());
            System.out.println("utf8使用3个字节表示一个汉字，第一个字节表示后面还有几个字节用来表示当前字符");
            System.out.println("---------------------");
        }

        aaa = "abc我日";
        {//utf-16
            byte[] aaaArray = aaa.getBytes(CHARSET_UTF16);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (byte b : aaaArray) {
                sb.append(b).append(" ");
                sb1.append(Integer.toHexString(b)).append(" ");
                sb2.append(Integer.toBinaryString(b)).append(" ");
            }
            System.out.println(CHARSET_UTF16 + " 字节(byte)的十进制 : " + sb.toString());
            System.out.println(CHARSET_UTF16 + " 字节(byte)的十六进制 : " + sb1.toString());
            System.out.println(CHARSET_UTF16 + " 字节(byte)的二进制 : " + sb2.toString());
            System.out.println("utf8使用3个字节表示一个汉字，第一个字节表示后面还有几个字节用来表示当前字符");
            System.out.println("---------------------");
        }
        //以上都表示：字符串在实际内存中  使用多少个byte以及每个byte的值是什么  的byte对象

        aaa = "我";

        {//char，代表字符对象，说白了就是代表 字符集中的某一个字符。 char是无符号数据类型，2个字节，范围是0-65535
         //char x = '我';
         //int y = (int)x;//y返回的是 "我"这个字符，在unicode中的code point
            char[] aaaArray = aaa.toCharArray();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (char b : aaaArray) {
                sb.append(b).append(" ");
                sb2.append((int)b).append(" ");//返回code point
                sb3.append(Integer.toHexString((int)b)).append(" ");
            }
            System.out.println(" 字符(char) : " + sb.toString());
            System.out.println(" 字符的十进制 : " + sb2.toString());
            System.out.println(" 字符的十六进制 : " + sb3.toString());
            System.out.println("---------------------");
        }

        //unicode字符集
        // code point       字符         utf8编码(计算机实际地址，十六进制)
        //  25105            我          ffffffe6 ffffff88 ffffff91
        //  25105            我          62 11

//        在 Java 中一个 Unicode 字符是使用 UTF-16 编码的 char 进行表示的，也就是一个 char 只能表示 U+0000～U+FFFF 的 Unicode 基本字符（BMP, basic multilingual plane）。因此在 Java 中需要表示 U+10000～U+10FFFF 的字符需要使用一对代理字符进行表示，高代理字符的范围为 U+D800～U+DBFF，低代理字符的范围为 U+DC00～U+DFFF。比如表示 U+10400 的字符需要两个 char（U+D801, U+DC00）才能表示，这时的代码点(code point)长度为 1，而代码单元(code unit)长度为 2。

        {
            char[] chs = Character.toChars(0x10400);
            System.out.printf("U+10400 高代理字符: %04x%n", (int)chs[0]);
            System.out.printf("U+10400 低代理字符: %04x%n", (int)chs[1]);
            String str = new String(chs);
            System.out.println("字符串是: " + str);
            System.out.println("代码单元长度: " + str.length());
            System.out.println("代码点数量: " + str.codePointCount(0, str.length()));

            System.out.println("---------------------");
        }

        {//如果我aaa定义的是一个code unit是2的字符，我再得到的char数组的length将会是2，那我每个char的code point是啥？
            char[] aaaArray = Character.toChars(0x10400);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (char b : aaaArray) {
                sb.append(b).append(" ");
                sb2.append((int)b).append(" ");//返回code point
                sb3.append(Integer.toHexString((int)b)).append(" ");
            }
            String ccc = new String(aaaArray);
            System.out.println(" 字符串 : " + ccc);
            System.out.println(" 对应的code point : " + ccc.codePointBefore(ccc.length()));
            System.out.println(" 字符(char) : " + sb.toString());
            System.out.println(" 字符的十进制 : " + sb2.toString());
            System.out.println(" 字符的十六进制 : " + sb3.toString());
            System.out.println("---------------------");
        }

        String unicode = CharsetTest.str2Unicode(aaa);
        System.out.println(unicode);
        System.out.println(CharsetTest.unicode2Str(unicode));

        System.out.println(URLEncoder.encode(aaa, "UTF-8"));

    }


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
