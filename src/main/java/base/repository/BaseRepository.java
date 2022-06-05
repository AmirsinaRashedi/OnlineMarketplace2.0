package base.repository;

import base.domain.BaseEntity;

import java.io.Serializable;

public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T t);

    T update(T t);

    void delete(T t);

    T find(T t);

    T findById(ID id);

}
