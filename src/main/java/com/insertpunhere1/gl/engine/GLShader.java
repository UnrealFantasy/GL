package com.insertpunhere1.gl.engine;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;

import java.io.IOException;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL20.*;

public class GLShader {
    private int programID;

    private List<GLUniform> uniforms = new ArrayList<>();

    private String vp, fp;

    public GLShader(String vp, String fp) {
        this.vp = vp;
        this.fp = fp;

        programID = glCreateProgram();

        try {
            glAttachShader(programID, generateShader(GLUtility.read(vp), GL_VERTEX_SHADER));
            glAttachShader(programID, generateShader(GLUtility.read(fp), GL_FRAGMENT_SHADER));
        } catch (IOException e) {
            e.printStackTrace();
        }

        glLinkProgram(programID);
        glValidateProgram(programID);
    }

    public void parseUniforms() throws IOException {
        List<String> lines = GLUtility.readLines(vp);

        lines.addAll(GLUtility.readLines(fp));

        for (String line : lines) {
            String[] tokens = line.replace(';', ' ').split(" ");

            if (tokens[0].equals("uniform")) {
                uniforms.add(new GLUniform(tokens[2], tokens[1], glGetUniformLocation(programID, tokens[2])));
            }
        }

        for(GLUniform uniform : uniforms)
            System.out.println(uniform.getName() + " " + uniform.getType() + " " + uniform.getLocation());
    }

    void setUniform(String name, int iv, float fv, Vector2f v2v, Vector3f v3v, Matrix4f m4v) {
        for (GLUniform uniform : uniforms) {
            if (uniform.getName().equals(name)) {
                switch (uniform.getType()) {
                    case "int":
                        glUniform1i(uniform.getLocation(), iv);

                        break;
                    case "float":
                        glUniform1f(uniform.getLocation(), fv);

                        break;
                    case "vec2":
                        glUniform2f(uniform.getLocation(), v2v.x, v2v.y);

                        break;
                    case "vec3":
                        glUniform3f(uniform.getLocation(), v3v.x, v3v.y, v3v.z);

                        break;
                    case "mat4":
                        try (MemoryStack stack = MemoryStack.stackPush()) {
                            FloatBuffer buffer = stack.mallocFloat(16);

                            m4v.get(buffer);

                            glUniformMatrix4fv(uniform.getLocation(), false, buffer);
                        }

                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void bind(boolean use) {
        if (use)
            glUseProgram(programID);
        else
            glUseProgram(0);
    }

    private int generateShader(String source, int type) {
        int shaderID = glCreateShader(type);

        glShaderSource(shaderID, source);
        glCompileShader(shaderID);

        System.out.println(glGetShaderInfoLog(shaderID));

        return shaderID;
    }
}
