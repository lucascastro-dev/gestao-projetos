package com.gestaoprojetos.srvgestaoprojetos.infra.handler;

import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.handler.IHandler;
import com.gestaoprojetos.srvgestaoprojetos.domain.interfaces.validation.ITask;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHandler<T> implements IHandler<T> {
    private final ApplicationContext applicationContext;
    private List<ITask<T>> tasks;

    protected AbstractHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public final void setTasks(List<Class<? extends ITask<T>>> validationClasses) {
        this.tasks = new ArrayList<>();
        for (Class<? extends ITask<T>> validationClass : validationClasses) {
            tasks.add(getBean(validationClass));
        }
    }

    public void process(final T obj) {
        for (ITask<T> task : tasks) {
            task.runTask(obj);
        }
    }

    protected ITask<T> getBean(Class<? extends ITask<T>> clazz) {
        return applicationContext.getBean(clazz);
    }
}