package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces;

import java.util.List;

public interface IFind<T, P> {
    List<T> all();

    T get(P param);
}
