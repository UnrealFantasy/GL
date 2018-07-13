package com.insertpunhere1.gl.engine;

import org.joml.Vector3f;

public class GLBlock {
    private final GLMeshContainer meshContainer = GLPrimitives.CUBE;

    private GLMaterial material;

    private Vector3f position;

    public GLBlock(GLMaterial material, Vector3f position) {
        this.material = material;

        this.position = position;
    }

    public GLMeshContainer getMeshContainer() {
        return meshContainer;
    }

    public GLMaterial getMaterial() {
        return material;
    }

    public void setMaterial(GLMaterial material) {
        this.material = material;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }
}
