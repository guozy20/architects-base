package com.guozy.design.principle.lsp;

public class Square implements QuadRangle {
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getWidth() {
        return length;
    }

    public long getHeight() {
        return length;
    }
}
