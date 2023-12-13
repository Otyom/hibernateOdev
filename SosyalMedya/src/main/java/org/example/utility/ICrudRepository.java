package org.example.utility;

import java.util.List;

public interface ICrudRepository<T,ID> {
    public void create(T t);
    public void delete(T t);

    public <T> T getById(Class<T> tClass, ID id);
    public void update(T t);
}
