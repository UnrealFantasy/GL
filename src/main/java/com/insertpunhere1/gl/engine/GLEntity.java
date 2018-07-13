package com.insertpunhere1.gl.engine;

import org.joml.*;

public class GLEntity {
    private Vector3f position, rotation, scale;

    private GLMesh mesh;

    public GLEntity(Vector3f position, Vector3f rotation, Vector3f scale, GLMesh mesh) {
        this.position = position;
        this.rotation = rotation;

        this.scale = scale;

        this.mesh = mesh;
    }

    public void render(GLShader shader, GLCamera camera, GLPerspectiveContainer container) {
        shader.bind(true);

        shader.setUniform("m4_pr", 0, 0, new Vector2f(), new Vector3f(), GLMath.project(container));
        shader.setUniform("m4_vw", 0, 0, new Vector2f(), new Vector3f(), GLMath.view(camera));
        shader.setUniform("m4_tr", 0, 0, new Vector2f(), new Vector3f(), GLMath.transform(this));

        mesh.render();

        shader.bind(false);
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

    public Vector3f getScale() {
        return scale;
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public GLMesh getMesh() {
        return mesh;
    }

    public void setMesh(GLMesh mesh) {
        this.mesh = mesh;
    }
}
