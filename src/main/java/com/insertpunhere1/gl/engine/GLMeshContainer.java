package com.insertpunhere1.gl.engine;

public class GLMeshContainer {
    private float[] vertices, textures, normals;

    private int[] indices;

    GLMeshContainer(float[] vertices, float[] textures, float[] normals, int[] indices) {
        this.vertices = vertices;
        this.textures = textures;
        this.normals = normals;

        this.indices = indices;
    }

    public GLMesh getMesh() {
        return new GLMesh(vertices, textures, normals, indices);
    }


    public float[] getVertices() {
        return vertices;
    }

    public void setVertices(float[] vertices) {
        this.vertices = vertices;
    }

    public float[] getTextures() {
        return textures;
    }

    public void setTextures(float[] textures) {
        this.textures = textures;
    }

    public float[] getNormals() {
        return normals;
    }

    public void setNormals(float[] normals) {
        this.normals = normals;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }
}
