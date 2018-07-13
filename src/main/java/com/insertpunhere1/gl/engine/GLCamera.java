package com.insertpunhere1.gl.engine;

import org.joml.Vector3f;

import static org.lwjgl.glfw.GLFW.*;

public class GLCamera {
    private Vector3f position, rotation;

    public GLCamera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public void input(GLWindow window) {
        if(key(window, GLFW_KEY_W))
            position.z -= 0.02f;

        if(key(window, GLFW_KEY_S))
            position.z += 0.02f;

        if(key(window, GLFW_KEY_A))
            position.x -= 0.02f;

        if(key(window, GLFW_KEY_D))
            position.x += 0.02f;

        if(key(window, GLFW_KEY_SPACE))
            position.y += 0.02f;

        if(key(window, GLFW_KEY_LEFT_SHIFT))
            position.y -= 0.02f;
    }

    private boolean key(GLWindow window, int key) {
        return glfwGetKey(window.getHandle(), key) == GLFW_PRESS;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
}
