import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qatang on 14-3-26.
 */
public enum EnumClass {
    ALL("全部"),
    DEFAULT("默认"),
    RED("红色"),
    YELLOW("黄色"),
    GREEN("绿色");

    private static List<EnumClass> _LIST = new ArrayList<EnumClass>();
    private static Map<Integer, EnumClass> _MAP = new HashMap<Integer, EnumClass>();

    static {
        _LIST.add(RED);
        _LIST.add(YELLOW);
        _LIST.add(GREEN);

        for(EnumClass enumClass : EnumClass.values()) {
            _MAP.put(enumClass.getValue(), enumClass);
        }
    }

    private String name;

    private EnumClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.ordinal();
    }


    public static EnumClass get(int value) {
        return _MAP.get(value);
    }

    public static List<EnumClass> list() {
        return _LIST;
    }
}
