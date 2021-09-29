package edu.vsu.csf.course2.vetrov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("WrapHand.obj");
        String fileContent = Files.readString(fileName);

        Model model = ObjReader.read(fileContent);
        Vector3f vector = new Vector3f(1, 2, -1);
        ModelAlgorithms.moveModel(model, vector);
        System.out.println("All good?");
    }
}
