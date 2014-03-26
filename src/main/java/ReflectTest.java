import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;
import java.util.Date;

/**
 * Created by qatang on 14-2-18.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
//        Class clazz = 字节码；//加载到内存中的类的字节码
//
//        一个类被类加载器加载到内存中，占用了一片存储空间，这个空间里面的内容就是类的字节码
//
//        没有Class clazz = new Class();

        Class<?> clazz = Dog.class;


        Dog dog = new Dog();
        clazz = dog.getClass();

        clazz = Class.forName("Dog");

        clazz = void.class;
        clazz = int.class;
        clazz = Integer.TYPE;

        String aaa = "aaa";
        String aaa1 = "aaa1";
        System.out.println(aaa.getClass() == aaa1.getClass());

        System.out.println(int.class == Integer.TYPE);

        System.out.println(clazz.isPrimitive());//是否是基本类型字节码
        clazz = Class.forName("java.lang.String");
        System.out.println(clazz.isPrimitive());

        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());

        Constructor<?>[] constructors = Class.forName("java.lang.String").getConstructors();

        Constructor<?> constructor = Class.forName("java.lang.String").getConstructor(StringBuffer.class);
        String abc = (String)constructor.newInstance(new StringBuffer("abc"));


        Class<?> clazz2 = Class.forName("java.lang.String");//查看Class类中 forName方法的源码
        String bbb = (String)clazz2.newInstance();//默认构造方法

        Class<String> clazz3 = String.class;
        String ccc = clazz3.newInstance();//不用转型

//        如何创建一个 Class<T> 类型的实例？就像使用非泛型代码一样，有两种方式：调用方法 Class.forName() 或者使用类常量X.class。Class.forName() 被定义为返回 Class<?>。另一方面，类常量 X.class 被定义为具有类型 Class<X>，所以 String.class 是Class<String> 类型的。

         Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog2.name = "dasdasd";

        Field field = dog1.getClass().getField("name");
        System.out.println(field.get(dog1));
        System.out.println(field.get(dog2));
        //getField只能得到public的变量

        Field[] fields2 = dog1.getClass().getDeclaredFields();
        System.out.println(fields2.length);

        Field field1 = dog1.getClass().getDeclaredField("sex"); //getDeclaredField可以得到所有变量
        field1.setAccessible(true);//暴力反射
        System.out.println(field1.get(dog1));
        field1.set(dog1, false) ;
        System.out.println("fiedl:" + field1.get(dog1));

        Field[] fields = Class.forName("Dog").getDeclaredFields();
        for (Field f : fields) {
            if (f.getModifiers() == Modifier.PRIVATE) {
                f.setAccessible(true);
            }
            System.out.println(f.get(Class.forName("Dog").newInstance()));
        }


        Method method = Class.forName("Dog").getMethod("wang", String.class);
        method.invoke(Class.forName("Dog").newInstance(), "1111");
        //method.invoke(null);静态方法

        Dog.wangwang();

        Method method2 = Class.forName("Dog").getMethod("wangwang");
        System.out.println("static method invoke:" + method2.invoke(null));

        System.out.println(Modifier.isStatic(method.getModifiers())); //判断是否为静态方法

        //Annotation 注解

        System.out.println("annotation:" + Abc.class.isAnnotation());
        Dog.class.isAnnotationPresent(Abc.class);

        Abc abc1 = Dog.class.getAnnotation(Abc.class);
        System.out.println(abc1.color());
        System.out.println(abc1.value());

//        @Retention(RetentionPolicy.RUNTIME)//RetentionPolicy.SOURCE RetentionPolicy.CLASS RetentionPolicy.RUNTIME 分别对应java源文件 class文件 内存中的字节码
        //@Target({ElementType.METHOD, ElementType,TYPE})
//        public @interface Abc {
//        }

//        @Abc(color = "red", value = "111") //如果Abc注解只设置一个value值，可写成@Abc("111")，默认的value可以不用写
//        public class Dog {}


        //数组的反射
        int[] a = {1, 2, 3};

        Class<?> c = a.getClass();
        if (c.isArray()) {
           int i =  Array.getLength(a);
        }
        //类加载器
        Dog.class.getClassLoader().getResourceAsStream("com/lecai/admin/aaa.properties");
        System.out.println("class name : " + String.class.getName());
        System.out.println("canonical class name : " + String.class.getCanonicalName());

        //内省 IntroSpector 主要操作javaBean
        // get set


//        PropertyDescriptor pd = new PropertyDescriptor("name",  Class.forName("Dog"));
//                Method method3 = pd.getReadMethod();
//                Method method4 = pd.getWriteMethod();
//        method3.invoke(Class.forName("Dog").newInstance());
//        method4.invoke(Class.forName("Dog").newInstance(), "asdasd");

        //BeanUtils.setProperty() 支持级联属性设置，自己实现很困难

        //抓取器的例子，如果不使用反射，则需要对每一个彩种的不同抓取方式设置一个实现类

        Dog dog3 = new Dog();
        Jinmao jinmao = new Jinmao();
        System.out.println(dog3 instanceof Dog);
        System.out.println(jinmao instanceof Dog);
        System.out.println(jinmao instanceof Jinmao);
    }
}
