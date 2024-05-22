package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation;

public interface ITask<T> {
    void runTask(final T param);
}
