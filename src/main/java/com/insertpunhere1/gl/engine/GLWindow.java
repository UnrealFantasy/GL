package com.insertpunhere1.gl.engine;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL11.*;

public class GLWindow {
    private int width, height;

    private String title;

    private volatile long window;

    public GLWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;

        this.title = title;
    }

    public void create(boolean fs) {
        if(!glfwInit())
            throw new IllegalStateException("GLFW failed to initialize.");

        glfwDefaultWindowHints();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);

        glfwWindowHint(GLFW_SAMPLES, 16);

        long monitor = 0;

        if(fs)
            monitor = glfwGetPrimaryMonitor();

        window = glfwCreateWindow(width, height, title, monitor, 0);

        if(window == 0)
            throw new IllegalStateException("GLFW window failed to create.");

        glfwMakeContextCurrent(window);
        glfwShowWindow(window);

        GL.createCapabilities();

        glViewport(0, 0, width, height);
    }

    public void clear() {
        glClearColor(0, 0, 0, 1);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void update() {
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    public void updatePointers() {
        glfwSetWindowSize(window, width, height);
        glfwSetWindowTitle(window, title);
    }

    public void close() {
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getHandle() {
        return window;
    }
}
