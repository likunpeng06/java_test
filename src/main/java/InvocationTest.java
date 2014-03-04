/**
 * Created by qatang on 14-3-4.
 */
public class InvocationTest {
    public static void main(String[] args) throws Exception {
        //类加载器，java虚拟机中可以安装多个类加载器，系统默认三个主要类加载器，每个类负责加载特定位置的类
        //Bootstrap(加载jre/lib/rt.jar) ExtClassLoader(加载jre/lib/ext/*.jar),AppClassLoader(CLASSPATH指定的目录里的jar)
        //Bootstrap这个不是java类,c++编写的，其他类加载器都是java类

        System.out.println(InvocationTest.class.getClassLoader().getClass().getName());

        System.out.println(System.class.getClassLoader());//返回null,Boostrap类加载器

        System.out.println("-----------------------------------------");

        ClassLoader loader = InvocationTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        System.out.println(loader);


        //类加载器的委托机制，类加载器的选择顺序
        //首先，使用当前线程的类加载器去加载线程中的第一个类
        Thread t = new Thread();
        ClassLoader loader1 = t.getContextClassLoader();
        //如果类A中引用了类B，java虚拟机将使用加载类A的类加载器来加载类B
        //还可以直接调用ClassLoader.loadClass()方法来指定某个类加载器去加载某个类
        loader1.loadClass("String");

        //每个类加载器加载类时，先委托给其上级类加载器进行查找。
        //查找顺序：Bootstrap-->ExtClassLoader-->AppClassLoader


        //可以自己定义类加载器，继承classloader类
        //loadClass方法，调用委托机制，
        //findClass方法，如果各个父级类加载器没有找到类，则调用findClass方法
        //defineClass方法，把二进制转换成class字节码


    }

    class NetworkClassLoader extends ClassLoader {
        private String dir;

        public NetworkClassLoader() {
            this.dir = "/Users/qatang";
        }

        public NetworkClassLoader(String dir) {
            this.dir = dir;
        }

        public Class<?> findClass(String name) {
            byte[] b = loadClassData(name);
            return defineClass(name, b , 0, b.length);
        }

        private byte[] loadClassData(String name) {
            //比如我在一个特定位置里存一个class文件，而且这个class文件是加密过的，就可以用自己的类加载器来进行解密
            return null;
        }
    }
}
