import java.util.Arrays;

/**
 * Created by qatang on 14-3-6.
 */
public class AAA implements Comparable<Integer>{
    private int a;

    public AAA(int a) {
        this.a = a;
    }
    @Override
    public int compareTo(Integer o) {
        return a - o;
    }

    public static void main(String[] args) {
        System.out.println(AAA.class.getClassLoader().getClass().getName());
        //享元模式
        String aaa = "0";
        String bbb = "0";
        System.out.println(Integer.valueOf(aaa) == Integer.valueOf(bbb) );

        int[][] a = {{1,2,3}, {4,5,6}};
        System.out.println(a[1][2]);
        System.out.println(Arrays.deepToString(a));

        String[] aa = {"b","a"};
        String[] bb = {"a", "b"};
        System.out.println(Arrays.equals(aa, bb));

        AAA aaa1 = new AAA(1);
        System.out.println(aaa1.compareTo(2));

        Integer[] ii = {2, 4, 5 ,1};
        Arrays.sort(ii);
        System.out.println(Arrays.deepToString(ii));
    }
}
