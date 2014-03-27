/**
 * Created by qatang on 14-3-26.
 */

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(EnumClass.RED);
        System.out.println(EnumClass.RED.name());
        System.out.println(EnumClass.RED.ordinal());
        System.out.println(EnumClass.YELLOW.ordinal());
        System.out.println(EnumClass.GREEN.ordinal());

        System.out.println(EnumClass.valueOf("RED").ordinal());

        for (EnumClass enumClass : EnumClass.values()) {
            System.out.println(enumClass.name());
        }

        System.out.println(EnumClass.RED.getName());
        System.out.println(EnumClass.RED.ordinal());

        System.out.println(EnumClass.get(51));

        EnumTestInterface enumTestInterface = EnumTestInterface.BigDog.ZANGAO;
        EnumTestInterface enumTestInterface2 = EnumTestInterface.SmallDog.JIWAWA;

//        <property name="payType">
//        <column name="pay_type" precision="4" scale="0" not-null="true" />
//        <type name="org.hibernate.type.EnumType">
//        <param name="enumClass">
//                cn.mixpay.core.type.PayType
//                </param>
//        </type>
//        </property>
    }
}
