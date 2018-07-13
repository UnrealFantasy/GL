package com.insertpunhere1.gl.engine;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

public class GLMesh {
    private int count;

    GLMesh(float[] vertices, float[] textures, float[] normals, int[] indices) {
        count = indices.length;

        int vaoID = glGenVertexArrays();

        glBindVertexArray(vaoID);

        attribute(0, 3, vertices);
        attribute(1, 2, textures);
        attribute(2, 3, normals);

        attribute(indices);
    }

    void render() {
        glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_INT, 0);
    }

    private void attribute(int index, int size, float[] data) {
        int vboID = glGenBuffers();

        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);

        glVertexAttribPointer(index, size, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(index);
    }

    private void attribute(int[] data) {
        int vboID = glGenBuffers();

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, data, GL_STATIC_DRAW);
    }
}
