package com.insertpunhere1.gl.engine;

public class GLPerspectiveContainer {
    private float fov, zn, zf;

    private GLWindow window;

    public GLPerspectiveContainer(float fov, float zn, float zf, GLWindow window) {
        this.fov = fov;
        this.zn = zn;
        this.zf = zf;

        this.window = window;
    }

    public float getFOV() {
        return fov;
    }

    public void setFOV(float fov) {
        this.fov = fov;
    }

    public float getZN() {
        return zn;
    }

    public void setZN(float zn) {
        this.zn = zn;
    }

    public float getZF() {
        return zf;
    }

    public void setZF(float zf) {
        this.zf = zf;
    }

    public GLWindow getWindow() {
        return window;
    }

    public void setWindow(GLWindow window) {
        this.window = window;
    }

    public float getAspect() {
        return (float) window.getWidth() / (float) window.getHeight();
    }
}
