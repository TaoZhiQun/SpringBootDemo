package com.example.test.responsibility;

public abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;
    void setSuccessor(ProcessingObject<T> successor){
        this.successor = successor;
    }
    public T handle(T input){
        T r = handleWork(input);
        if(null != successor){
            return successor.handle(r);
        }
        return r;
    }
    abstract protected T handleWork(T input);
}
