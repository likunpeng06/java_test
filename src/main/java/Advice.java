import java.lang.reflect.Method;

/**
 * Created by qatang on 14-3-5.
 */
public interface Advice {
    public void before(Method method);

    public void after(Method method);

    public void loop();

    public void exceptionCatch();
}
