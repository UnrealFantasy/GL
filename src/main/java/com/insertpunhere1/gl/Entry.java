package com.insertpunhere1.gl;

import com.insertpunhere1.gl.engine.GLPrimitives;

public class Entry {
    public static void main(String[] args) {
        Application application = new Application(1270, 700, "GL");

        application.init("transform");

        application.run();
    }
}