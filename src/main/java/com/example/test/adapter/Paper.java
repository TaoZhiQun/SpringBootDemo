package com.example.test.adapter;

public abstract class Paper {
    protected Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen;
    }
    abstract void writing();
}
