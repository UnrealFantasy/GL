package com.insertpunhere1.gl;

import com.insertpunhere1.gl.engine.*;
import org.joml.Vector3f;

import java.io.IOException;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

class Application {
    private GLWindow window;

    private GLShader shader;

    private GLTexture texture;

    private GLEntity entity;
    private GLCamera camera;

    GLChunk chunk = new GLChunk();

    Application(int width, int height, String title) {
        window = new GLWindow(width, height, title);
    }

    void init(String sl) {
        window.create(false);

        glEnable(GL_DEPTH_TEST);

        shader = new GLShader("./shaders/" + sl + "/vertex.txt", "./shaders/" + sl + "/fragment.txt");

        try {
            shader.parseUniforms();

            texture = new GLTexture("./textures/checkerboard.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        entity = new GLEntity(new Vector3f(0, 0, -32), new Vector3f(0, 0, 0), new Vector3f(1, 1, 1), chunk.generateMesh().getMesh());
        camera = new GLCamera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0));
    }

    void run() {
        while (!glfwWindowShouldClose(window.getHandle()) && glfwGetKey(window.getHandle(), GLFW_KEY_ESCAPE) != GLFW_PRESS) {
            window.clear();

            glActiveTexture(GL_TEXTURE0);

            glBindTexture(GL_TEXTURE_2D, texture.getTextureID());

            entity.render(shader, camera, new GLPerspectiveContainer(70, 0.012f, 128f, window));

            window.update();

            camera.input(window);
        }

        window.close();
    }
}
