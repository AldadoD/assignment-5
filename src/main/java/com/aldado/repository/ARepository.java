package com.aldado.repository;

public interface ARepository<K, V> {
        V create(K k, V v);
        V update(K k, V v);
        V delete(K id);
        V read(K id);

}

