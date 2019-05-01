package com.aldado.repository;

    public interface ARepository<T, ID> {
        T create(T t);
        T update(T t);
        void delete(ID id);
        T read(ID id);

}
