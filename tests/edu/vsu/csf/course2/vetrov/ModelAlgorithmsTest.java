package edu.vsu.csf.course2.vetrov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModelAlgorithmsTest {

    @Test
    public void testMoveModel01() {
        Model model = new Model();
        model.vertices.add(new Vector3f(0.1234f, 1.2345f, 2.3456f));
        Vector3f displacementVector = new Vector3f(1.8766f, 2.7655f, 3.6544f);
        ModelAlgorithms.moveModel(model, displacementVector);
        Vector3f result = model.vertices.get(0);
        Vector3f expectedResult = new Vector3f(2f, 4f, 6f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testMoveModel02() {
        Model model = new Model();
        model.vertices.add(new Vector3f(0.1234f, 1.2345f, 2.3456f));
        Vector3f displacementVector = new Vector3f(1, 2, 3);
        ModelAlgorithms.moveModel(model, displacementVector);
        Vector3f result = model.vertices.get(0);
        Vector3f expectedResult = new Vector3f(1.1234f, 3.2345f, 4f);
        Assertions.assertFalse(result.equals(expectedResult));
    }
}