import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.sql.SQLException;

/**
 * Created by qatang on 13-12-19.
 */
public class Jinmao extends Dog {
    public String name = "jinmao";

    public Jinmao() {

    }
    public Jinmao(Dog dog) {
//        System.out.println("aaa");
//        dog.super();
    }

//    public String toString() {
//        System.out.println(super.name);
//        System.out.println(name);
//        super.wang();
//        wang();
//        return null;
//    }
    @Override
    public void wang() {
        System.out.println("jinmao jinmao");

    }
//
    public static void main(String[] args) {
       Dog dog = new Dog();
        Jinmao jinmao = new Jinmao(dog);
        jinmao.wang();


    }
}
