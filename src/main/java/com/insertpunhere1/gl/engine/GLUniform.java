package com.insertpunhere1.gl.engine;

class GLUniform {
    private String name, type;

    private int location;

    GLUniform(String name, String type, int location) {
        this.name = name;
        this.type = type;

        this.location = location;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    int getLocation() {
        return location;
    }

    void setLocation(int location) {
        this.location = location;
    }
}
