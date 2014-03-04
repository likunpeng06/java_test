import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by qatang on 13-12-19.
 */
@Abc(color = "red", value = "111")
public class Dog {
     class Inner {
        public Inner() {
            System.out.println("inner");
        }
    }
    private boolean sex = true;
    public String name = "dog";



    public Dog () {
//        wang();
    }

    public void wang() throws FileNotFoundException {
        System.out.println("dog dog");

    }
    public void wang(String aaa) {
        System.out.println("aaaa aaaa");

    }

    public static void wangwang() {
        System.out.println("wangwang");
    }

    public String toString() {
        return this + "";
    }

    public static void main(String[] args) {
//     Dog.Inner inner = new Dog.Inner();
        Dog d = new Dog();

        d.getClass();
        System.out.println(d);

        LinkedList<String> list = new LinkedList<String>();
      for( Iterator<String> iter = list.iterator();iter.hasNext(); ) {
          String aa = iter.next();
      }
        TreeSet<String> t = new TreeSet<String>();
        t.add("5");
        t.add("3");
        t.add("6");
        t.add("1");
        for (String i : t) {
            System.out.println(i);
        }

        try {
            System.out.println("aaa");
            return;
        } catch (Exception e) {
            System.out.println("bbb");
            return;
        } finally {
            System.out.println("ccc");
        }
    }
}
