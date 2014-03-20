import java.io.*;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by qatang on 14-3-20.
 */
public class IOTest implements Serializable {
    private transient String jinsheng = "{";
    public static void main(String[] args) throws Exception {

        //File类
        String pathname = "/users/qatang/iotest.txt";
        File file = new File(pathname);
        System.out.println(file.createNewFile());
        System.out.println(file.createNewFile());//如果文件已存在，则不会再次创建，返回false

        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        URI uri = file.toURI();
        System.out.println(uri.toString());

        Field field = File.class.getDeclaredField("fs");
        field.setAccessible(true);
        Object fs = (Object)field.get(file);
        System.out.println(fs.toString());

        //InputStream OutputStream
        //file是实际文件，stream是通道，程序里的数据

        String aaa = "aaa我日";
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(aaa.getBytes());
        outputStream.close();

        String bbb = "";
        InputStream inputStream = new FileInputStream(file);

        int initLen = 1024;
        double factor = 0.75;
        byte[] tmp = new byte[initLen];
        int i = 0;
        int len = 0;
        int l = inputStream.read(tmp);
//        while ((i = inputStream.read()) != -1) {
//            System.out.println(i);
//            tmp[len] = (byte)i;
//            len ++;
//            if (len >= initLen * factor) {
//                byte[] tmp2 = new byte[initLen];
//                //
//            }
//        }
        inputStream.close();

        bbb = new String(tmp);
        System.out.println("bbb length : " + l);
        System.out.println("bbb : " + bbb);

       //reader writer
       Writer writer = new FileWriter(file);
       writer.write("我发了快疯啦减肥啦睡觉");
       writer.close();

       Reader reader = new FileReader(file);
        char[] tmp2 = new char[initLen];
        int i2 = 0;
        int len2 = 0;
        while ((i2 = reader.read()) != -1) {
            System.out.println(i2);
            tmp2[len2] = (char)i2;
            len2 ++;
            if (len2 >= initLen * factor) {
//                byte[] tmp2 = new byte[initLen];
                //
            }
        }
        System.out.println(new String(tmp2));


        //转换
        Writer writer1 = new OutputStreamWriter(new FileOutputStream(file));

        //jdk 7

//        Java 7用try-with-resources进行了改进：在try子句中能创建一个资源对象，当程序的执行完try-catch之后，运行环境自动关闭资源。下面是这方面改进的示例代码：

//        try (MyResource mr = new MyResource()) {
//            System.out.println("MyResource created in try-with-resources");
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }



        Path path = Paths.get("some_file");

        Path path2 = new File("some_file").toPath();

    }
}
