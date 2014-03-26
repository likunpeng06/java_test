import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by qatang on 14-2-23.
 */
public class GenericDaoImpl<T> implements GenericDao<T> {
    public GenericDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        System.out.println((Class<T>) type.getActualTypeArguments()[0]);
    }

    @Override
    public void save(T t) {

    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public void del(T t) {

    }

    @Override
    public List<T> list() {
        return null;
    }
}
