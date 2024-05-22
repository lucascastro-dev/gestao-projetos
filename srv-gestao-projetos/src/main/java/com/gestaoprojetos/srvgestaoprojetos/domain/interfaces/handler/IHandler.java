package com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.handler;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;

import java.util.List;

public interface IHandler<T> {
    void process(final T task);

    void setTasks(List<Class<? extends ITask<T>>> validationClasses);
}