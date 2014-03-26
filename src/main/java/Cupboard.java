/**
 * Created by qatang on 13-12-12.
 */
public class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        bowl4.f1(2);
    }
    void f3(int i) {
        System.out.println("f3(" + i + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}
