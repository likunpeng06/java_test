import java.util.List;

/**
 * Created by qatang on 14-2-23.
 */
public interface GenericDao<T> {
    public void save(T t);

    public T update(T t);

    public T get(Long id);

    public void del(T t);

    public List<T> list();
}
