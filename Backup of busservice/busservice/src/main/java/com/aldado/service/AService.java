package com.aldado.service;

public interface AService <K, V> {
    V create(K k, V v);
    V update(K k, V v);
    V delete(K id);
    V read(K id);

}
