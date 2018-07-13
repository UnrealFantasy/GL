package com.insertpunhere1.gl.engine;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3i;

import java.util.ArrayList;
import java.util.List;

public class GLChunk {
    private GLBlock[][][] chunk = new GLBlock[16][16][16];

    private static final float[][] split_data = {
            {
                    -1, 1, -1,
                    -1, -1, -1,
                    1, -1, -1,
                    1, 1, -1,
            },

            {
                    -1, 1, 1,
                    -1, -1, 1,
                    1, -1, 1,
                    1, 1, 1,
            },

            {
                    1, 1, -1,
                    1, -1, -1,
                    1, -1, 1,
                    1, 1, 1,
            },

            {
                    -1, 1, -1,
                    -1, -1, -1,
                    -1, -1, 1,
                    -1, 1, 1,
            },

            {
                    -1, 1, 1,
                    -1, 1, -1,
                    1, 1, -1,
                    1, 1, 1,
            },

            {
                    -1, -1, 1,
                    -1, -1, -1,
                    1, -1, -1,
                    1, -1, 1
            }
    };

    public GLChunk() {
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (int z = 0; z < 16; z++)
                    chunk[x][y][z] = new GLBlock(GLDefaultMaterials.GRASS, new Vector3f(x, y, z));

        for (int x = 0; x < 16; x++)
            for (int y = 1; y < 16; y++)
                for (int z = 0; z < 16; z++)
                    chunk[x][y][z] = new GLBlock(new GLMaterial("AIR", "./textures/environmental/", ".png"), new Vector3f(x, y, z));
    }

    public GLMeshContainer generateMesh() {
        List<Float> vertices = new ArrayList<>();
        List<Float> textures = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        int indices_offset = 0;

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (int z = 0; z < 16; z++) {
                    if (x != 0 && y != 0 && z != 0 && x != 15 && y != 15 && z != 15) {
                        if (chunk[x][y][z - 1].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 0);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }

                        if (chunk[x][y][z + 1].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 1);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }

                        if (chunk[x + 1][y][z].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 2);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }

                        if (chunk[x - 1][y][z].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 3);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }

                        if (chunk[x][y + 1][z].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 4);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }

                        if (chunk[x][y - 1][z].getMaterial().getName().equals("AIR")) {
                            mesh(vertices, new Vector3f(x, y, z), 5);

                            texture(textures);
                            index(indices, indices_offset);

                            indices_offset += 4;
                        }
                    }
                }
            }
        }

        float[] vertices_array = new float[vertices.size()];
        float[] textures_array = new float[textures.size()];
        int[] indices_array = new int[indices.size()];

        int vertices_index = 0;

        for (float vertex : vertices) {
            vertices_array[vertices_index] = vertex;

            vertices_index++;
        }

        int textures_index = 0;

        for (float texture : textures) {
            textures_array[textures_index] = texture;

            textures_index++;
        }

        int indices_index = 0;

        for (int index : indices) {
            indices_array[indices_index] = index;

            indices_index++;
        }

        return new GLMeshContainer(vertices_array, textures_array, new float[vertices.size()], indices_array);
    }

    private void add(List<Float> array, Vector3f vector3f) {
        array.add(vector3f.x);
        array.add(vector3f.y);
        array.add(vector3f.z);
    }

    private void add(List<Integer> array, Vector3i vector3f) {
        array.add(vector3f.x);
        array.add(vector3f.y);
        array.add(vector3f.z);
    }

    private void add(List<Float> array, Vector2f vector2f) {
        array.add(vector2f.x);
        array.add(vector2f.y);
    }

    private void texture(List<Float> array) {
        add(array, new Vector2f(0, 0));
        add(array, new Vector2f(0, 1));
        add(array, new Vector2f(1, 1));
        add(array, new Vector2f(1, 0));
    }

    private void mesh(List<Float> array, Vector3f offset, int side) {
        List<Vector3f> vectors = new ArrayList<>();

        vectors.add(new Vector3f(split_data[side][0] + offset.x, split_data[side][1] + offset.y, split_data[side][2] + offset.z));
        vectors.add(new Vector3f(split_data[side][3] + offset.x, split_data[side][4] + offset.y, split_data[side][5] + offset.z));
        vectors.add(new Vector3f(split_data[side][6] + offset.x, split_data[side][7] + offset.y, split_data[side][8] + offset.z));
        vectors.add(new Vector3f(split_data[side][9] + offset.x, split_data[side][10] + offset.y, split_data[side][11] + offset.z));

        for (Vector3f vector : vectors)
            add(array, vector);
    }

    private void index(List<Integer> array, int offset) {
        add(array, new Vector3i(offset, 1 + offset, 3 + offset));
        add(array, new Vector3i(3 + offset, 1 + offset, 2 + offset));
    }
}
