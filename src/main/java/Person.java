import com.lecai.java.Column;
import com.lecai.java.Entity;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import org.junit.Test;

/**
 * Created by qatang on 14-4-3.
 */
@Entity(tableName = "db_table")
public class Person implements Serializable {
    @Column(length = 1000000, isPrimaryKey = true, isAllowNull = false)
    private Long id;
    @Column(length = 32, isAllowNull = false)
    private String name;
    @Column(length = 18, name = "id_card")
    private String idCard;
    private Boolean sex;
    private String memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Test
    public void test() {
        assert true : "adc";
    }

    @Test
    public void test1() {
        assert false : "adc";
    }

//    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("create table");
//
//        Person person = new Person();
//        Entity entity = person.getClass().getAnnotation(Entity.class);
//
//        String dbTableName = entity.tableName();
//        if (StringUtils.isEmpty(dbTableName)) {
//            dbTableName = person.getClass().getName();
//        }
//        System.out.println(dbTableName);
//        sb.append(" " + dbTableName + " (");
//
//        Field[] fields = person.getClass().getDeclaredFields();
//        for(Field field : fields) {
//            System.out.println("--------");
//            Column column = field.getAnnotation(Column.class);
//            if (column == null) {
//                continue;
//            }
//            System.out.println(column.length());
//            String columnName = column.name();
//            if (StringUtils.isEmpty(columnName)) {
//                columnName = field.getName();
//            }
//            System.out.println(columnName);
//
//            System.out.println("isPrimaryKey : " + column.isPrimaryKey());
//            System.out.println("isAllowNull : " + column.isAllowNull());
//        }
//
//    }
}
