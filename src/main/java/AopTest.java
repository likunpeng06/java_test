import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by qatang on 14-3-5.
 */
public class AopTest {
    public static void main(String[] args) throws Exception{
        //代理的概念
        //代理类与目标类实现了相同的接口

        //OAP 面向切面(Aspect)编程

        //jvm可以在运行期动态生成出类的字节码，这种动态生成的类往往被用作代理类，即动态代理
        //jvm生成的动态类必须实现一个或多个接口，jdk标准

        //CGLIB可以动态生成一个类的子类，一个类的子类也可以用作该类的代理

        //直接在内存中创建的类，所有没有类加载器，这样就必须给它指定一个类加载器
        //默认习惯使用接口的类加载器
        Class<?> clazz = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(clazz.getName());

        System.out.println("-------------constructor begin-------------");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            String name = constructor.getName();

            StringBuilder sb = new StringBuilder(name);
            List<String> list = new ArrayList<String>();
            Class<?>[] clazzParams = constructor.getParameterTypes();
            for (Class<?> clazzParam : clazzParams) {
                list.add(clazzParam.getName());
            }
            sb.append("(");
            if (list.size() > 0) {
                sb.append(StringUtils.join(list, ","));
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
        System.out.println("-------------constructor end-------------");

        System.out.println("-------------method begin-------------");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            String name = method.getName();

            StringBuilder sb = new StringBuilder(name);
            List<String> list = new ArrayList<String>();
            Class<?>[] clazzParams = method.getParameterTypes();
            for (Class<?> clazzParam : clazzParams) {
                list.add(clazzParam.getName());
            }
            sb.append("(");
            if (list.size() > 0) {
                sb.append(StringUtils.join(list, ","));
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
        System.out.println("-------------method begin-------------");

        System.out.println("-------------instance begin-------------");
//        clazz.newInstance();

        Constructor<?> constructor = clazz.getConstructor(InvocationHandler.class);

        Collection collection = (Collection)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        System.out.println(collection.toString());
        collection.clear();//无返回值
//        collection.size();//有返回值
        System.out.println("-------------instance end-------------");

        Collection collection1 = (Collection)Proxy.newProxyInstance(Collection.class.getClassLoader(), new Class[] {Collection.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                List<String> target = new ArrayList<String>();//目标对象
                System.out.println(method.getName() + " begin execute");
                Object object = method.invoke(target, args);
                System.out.println(method.getName() + " end execute");
                return object;
            }
        });
        collection1.add("1111");
        collection1.add("2222");
        collection1.add("3333");
        System.out.println(collection1.size());

        //上面begin execute和end execute是写死的功能，不能满足自定义需求，所有该用调用某个对象的方法来实现，这就是面向切面编程
//        final List<String> target = new ArrayList<String>();//目标对象
        //Advice增强，对目标对象功能的增强
        AopTest.class.getClassLoader().getResourceAsStream("xxx.xml");

        String className = "";
        Object target = Class.forName(className).newInstance();

        Collection collection2 = (Collection)getProxy(target, new Advice() {
            @Override
            public void before(Method method) {
                System.out.println(method.getName() + " begin execute");
            }

            @Override
            public void after(Method method) {
                System.out.println(method.getName() + " end execute");
            }

            @Override
            public void loop() {

            }

            @Override
            public void exceptionCatch() {

            }
        });
        collection2.add("aaa");
        collection2.add("bbb");
        collection2.add("ccc");
        System.out.println(collection2.size());
    }

    private static Object getProxy(final Object target, final Advice advice) {
        Object object = (Object) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                advice.before(method);
                Object object = method.invoke(target, args);
                advice.after(method);
                return object;
            }
        });
        return object;
    }


}
