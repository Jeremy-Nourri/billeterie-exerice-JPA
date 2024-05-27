package org.example.Repository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseRepository<T> {
    protected EntityManager em;
    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public abstract void save (T element);
    public abstract T update (T element);
    public abstract void delete(T element);
    public abstract T get(int id);
    public abstract List<T> get();

}
