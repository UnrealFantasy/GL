package com.insertpunhere1.gl.engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;

class GLMath {
    static Matrix4f transform(GLEntity entity) {
        return new Matrix4f().identity()
                .translate(entity.getPosition())

                .rotateX((float) Math.toRadians(entity.getRotation().x))
                .rotateY((float) Math.toRadians(entity.getRotation().y))
                .rotateZ((float) Math.toRadians(entity.getRotation().z))

                .scale(entity.getScale());

    }

    static Matrix4f view(GLCamera camera) {
        return new Matrix4f().identity()
                .rotate((float) Math.toRadians(camera.getRotation().x), new Vector3f(1, 0, 0))
                .rotate((float) Math.toRadians(camera.getRotation().y), new Vector3f(0, 1, 0))

                .translate(new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z));
    }

    static Matrix4f project(GLPerspectiveContainer container) {
        return new Matrix4f().identity()
                .perspective(container.getFOV(), container.getAspect(), container.getZN(), container.getZF());
    }
}
