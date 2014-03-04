import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qatang on 14-2-22.
 */
public class GenericTypeTest {
    public static void main(String[] args) throws Exception{
        List list = new ArrayList();
        list.add(1);
        list.add("aaa");
//        int i = (Integer)list.get(1);

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        int i1 = list1.get(1);

        List<String> list2 = new ArrayList<>();//jdk1.7 写法

        System.out.println(list1.getClass() == list2.getClass());

        //只与编译器有关
        list1.getClass().getMethod("add", Object.class).invoke(list1, "abc");
        System.out.println(list1.get(2));

//        List<Integer> list3 = new ArrayList<Object>(); //参数化类型不允许继承关系,arrayList如果装的不是Integer就无法get了

        List list3 = new ArrayList<Object>();
        List<Integer> list4 = list3;

        //泛型中的?通配符

        //使用？通配符可以引用其他各种参数化的类型，？通配符定义的变量主要用作引用，可以调用与参数化无关的方法，不能调用与参数化有关的方法

        //泛型中的?通配符的上边界
        List<? extends Number> list5 = new ArrayList<Integer>();
        List<? extends Number> list55 = new ArrayList<Number>(); //包含类型自己
//        List<? extends Number> list5 = new ArrayList<String>();

        ////泛型中的?通配符的下边界
        List<? super Integer> list6 = new ArrayList<Integer>(); //包含类型自己
        List<? super Integer> list7 = new ArrayList<Number>();
//        List<? extends Integer> list7 = new ArrayList<String>();

        //T 类似 类 的概念，替换T的类型 类似 对象 的概念，？通配符也属于 对象；

        //方法泛型, 类型推断为共有的类型
        add(3, 5);//Integer
        add(3.5, 5);//Number
        add(3.5, "abc");//Object

        Integer a = add(3, 5);
        Number b = add(3.5, 5);
//        Integer b1 = add(3.5, 5);
        Object c = add(3.5, "abc");

        switchArray(new String[]{"a", "b", "c"}, 1 , 2);
        //T 不能是基本类型
        //switchArray(new int[]{1, 2, 3}, 1 , 2);


        Jinmao jinmao = new Jinmao();
        Dog dog = getName(jinmao);

        Dog dog2 = new Dog();
//        Jinmao jinmao1 = getName(dog2);


        //多个接口的子类
//        public static <V extends Serializable&Cloneable> V dosth(){}


//        异常的泛型
        dddd();

        //类泛型

//        先用方法泛型实现，每个方法实际对象可能不一致
//        public class GenericDao {
//            public <T> void save(T t){};

//              public <T> T get(Long id){};
//        }

        DogGenericDaoImpl genericDao = new DogGenericDaoImpl();


        //通过反射来得到具体泛型类型
        Method applyMethod = GenericTypeTest.class.getMethod("applyMethod", GenericDao.class);
        Type[] types = applyMethod.getGenericParameterTypes();
        ParameterizedType pType = (ParameterizedType)types[0];
        System.out.println(pType.getRawType());
        System.out.println(pType.getActualTypeArguments()[0]);
    }

    //方法泛型,返回值之前定义类型
    public static <T> T add(T x, T y) {

        return null;
    }

    public static <T> void switchArray(T[] t, int x, int y) {
        T tmpX = t[x];
        T tmpY = t[y];
        System.out.println(tmpX);
        System.out.println(tmpY);
    }

    public static <T extends Dog> T getName(T t) {
        return null;
    }

    public static <T extends Exception> void dddd() throws T {
        try{

        } catch (Exception e) {
            throw (T)e;
        }
    }

    public void applyMethod(GenericDao<Dog> dogGenericDao){};

    public static void printCollection1(List list) {

    }

    //参数化类型不允许继承关系
    public static void printCollection2(List<Object> list) {

    }

    public static void printCollection(List<?> list) {
        //list.add("aaa"); //不能调用与类型相关的参数
        list.size();
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

}
