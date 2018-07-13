package com.insertpunhere1.gl.engine;

public class GLMaterial {
    private String name, resource, extension;

    public GLMaterial(String name, String resource, String extension) {
        this.name = name;
        this.resource = resource;

        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
