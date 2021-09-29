package edu.vsu.csf.course2.vetrov;

public class ModelAlgorithms {

    public static void moveModel(Model model, Vector3f displacementVector) {
        for (Vector3f vertex : model.vertices) {
            vertex.x += displacementVector.x;
            vertex.y += displacementVector.y;
            vertex.z += displacementVector.z;

            vertex.x *= 10000;
            vertex.x = Math.round(vertex.x);
            vertex.x /= 10000;
            vertex.y *= 10000;
            vertex.y = Math.round(vertex.y);
            vertex.y /= 10000;
            vertex.z *= 10000;
            vertex.z = Math.round(vertex.z);
            vertex.z /= 10000;
        }
    }
}
