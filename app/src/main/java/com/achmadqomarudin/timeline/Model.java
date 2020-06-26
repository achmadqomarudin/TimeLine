package com.achmadqomarudin.timeline;

public class Model {
    public String text;
    public String time;
    public boolean isHead;

    public Model(boolean isHead, String text, String time) {
        this.isHead = isHead;
        this.text = text;
        this.time = time;
    }
}
