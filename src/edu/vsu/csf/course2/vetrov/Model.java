package edu.vsu.csf.course2.vetrov;

import java.util.*;

public class Model {

    public Model() {
        vertices = new ArrayList<>();
        textureVertices = new ArrayList<>();
        normals = new ArrayList<>();
        polygonVertexIndices = new ArrayList<>();
        polygonTextureVertexIndices = new ArrayList<>();
        polygonNormalIndices = new ArrayList<>();
    }

    ArrayList<Vector3f> vertices;
    ArrayList<Vector2f> textureVertices;
    ArrayList<Vector3f> normals;

    ArrayList<ArrayList<Integer>> polygonVertexIndices;
    ArrayList<ArrayList<Integer>> polygonTextureVertexIndices;
    ArrayList<ArrayList<Integer>> polygonNormalIndices;
}
