package com.insertpunhere1.gl.engine;

public class GLPrimitives {
    public static final GLMeshContainer TRIANGLE = new GLMeshContainer(new float[] {
            -0.5f, -0.5f, 0,
            -0.5f, 0.5f, 0,
            0.5f, -0.5f, 0
    }, new float[] {
            0, 1,
            0, 0,
            1, 1
    }, new float[] {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    }, new int[] {
            0, 1, 2
    });

    public static final GLMeshContainer QUAD = new GLMeshContainer(new float[] {
            -0.5f, -0.5f, 0,
            -0.5f, 0.5f, 0,
            0.5f, -0.5f, 0,
            0.5f, 0.5f, 0
    }, new float[] {
            0, 1,
            0, 0,
            1, 1,
            1, 0
    }, new float[] {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    }, new int[] {
            0, 1, 2,
            2, 3, 1
    });

    public static final GLMeshContainer CUBE = new GLMeshContainer(new float[] {
            -0.5f, 0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,

            -0.5f, 0.5f, 0.5f,
            -0.5f, -0.5f, 0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,

            0.5f, 0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f, 0.5f, 0.5f,

            -0.5f, 0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f, 0.5f,
            -0.5f, 0.5f, 0.5f,

            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, 0.5f,

            -0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, 0.5f
    }, new float[] {
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0,
            0, 0,
            0, 1,
            1, 1,
            1, 0
    }, new float[] {
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    }, new int[] {
            0, 1, 3,
            3, 1, 2,
            4, 5, 7,
            7, 5, 6,
            8, 9, 11,
            11, 9, 10,
            12, 13, 15,
            15, 13, 14,
            16, 17, 19,
            19, 17, 18,
            20, 21, 23,
            23, 21, 22
    });
}
