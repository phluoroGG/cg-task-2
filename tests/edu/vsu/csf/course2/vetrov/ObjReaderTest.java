package edu.vsu.csf.course2.vetrov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ObjReaderTest {

    @Test
    public void testParseVertex01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.03f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseVertex02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.10f);
        Assertions.assertFalse(result.equals(expectedResult));
    }

    @Test
    public void testParseVertex03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("zx", "яч", ".-"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too many vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("0.01", "0.02"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(0.01f, 0.02f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseTextureVertex02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("0.01", "0.02"));
        Vector2f result = ObjReader.parseTextureVertex(wordsInLineWithoutToken, 5);
        Vector2f expectedResult = new Vector2f(0.01f, 0.10f);
        Assertions.assertFalse(result.equals(expectedResult));
    }

    @Test
    public void testParseTextureVertex03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("zx", ".-"));
        try {
            ObjReader.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Collections.singletonList("0.0"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("0.0", "0.1", "0.2"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too many texture vertex arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseTextureVertex06() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("-1.0", "2.0"));
        try {
            ObjReader.parseTextureVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Invalid value for texture vertex.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseNormal(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.03f);
        Assertions.assertTrue(result.equals(expectedResult));
    }

    @Test
    public void testParseNormal02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = ObjReader.parseNormal(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.10f);
        Assertions.assertFalse(result.equals(expectedResult));
    }

    @Test
    public void testParseNormal03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("zx", "яч", ".-"));
        try {
            ObjReader.parseNormal(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0"));
        try {
            ObjReader.parseNormal(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few normal arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseNormal05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            ObjReader.parseNormal(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too many normal arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceWord01() {
        String wordInLine = "1";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result = onePolygonVertexIndices.get(0);
        Integer expectedResult = 0;
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testParseFaceWord02() {
        String wordInLine = "1";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result = onePolygonVertexIndices.get(0);
        Integer expectedResult = 1;
        Assertions.assertNotEquals(expectedResult, result);
    }

    @Test
    public void testParseFaceWord03() {
        String wordInLine = "1/2";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result1 = onePolygonVertexIndices.get(0);
        Integer expectedResult1 = 0;
        Assertions.assertEquals(expectedResult1, result1);
        Integer result2 = onePolygonTextureVertexIndices.get(0);
        Integer expectedResult2 = 1;
        Assertions.assertEquals(expectedResult2, result2);
    }

    @Test
    public void testParseFaceWord04() {
        String wordInLine = "1/2";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result1 = onePolygonVertexIndices.get(0);
        Integer expectedResult1 = 1;
        Assertions.assertNotEquals(expectedResult1, result1);
        Integer result2 = onePolygonTextureVertexIndices.get(0);
        Integer expectedResult2 = 2;
        Assertions.assertNotEquals(expectedResult2, result2);
    }

    @Test
    public void testParseFaceWord05() {
        String wordInLine = "1/2/3";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result1 = onePolygonVertexIndices.get(0);
        Integer expectedResult1 = 0;
        Assertions.assertEquals(expectedResult1, result1);
        Integer result2 = onePolygonTextureVertexIndices.get(0);
        Integer expectedResult2 = 1;
        Assertions.assertEquals(expectedResult2, result2);
        Integer result3 = onePolygonNormalIndices.get(0);
        Integer expectedResult3 = 2;
        Assertions.assertEquals(expectedResult3, result3);
    }

    @Test
    public void testParseFaceWord06() {
        String wordInLine = "1/2/3";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        ObjReader.parseFaceWord(wordInLine,
                onePolygonVertexIndices,
                onePolygonTextureVertexIndices,
                onePolygonNormalIndices, 5);
        Integer result1 = onePolygonVertexIndices.get(0);
        Integer expectedResult1 = 1;
        Assertions.assertNotEquals(expectedResult1, result1);
        Integer result2 = onePolygonTextureVertexIndices.get(0);
        Integer expectedResult2 = 2;
        Assertions.assertNotEquals(expectedResult2, result2);
        Integer result3 = onePolygonNormalIndices.get(0);
        Integer expectedResult3 = 3;
        Assertions.assertNotEquals(expectedResult3, result3);
    }

    @Test
    public void testParseFaceWord07() {
        String wordInLine = "zx/яч/.-";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        try {
            ObjReader.parseFaceWord(wordInLine,
                    onePolygonVertexIndices,
                    onePolygonTextureVertexIndices,
                    onePolygonNormalIndices, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse int value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceWord08() {
        String wordInLine = "";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        try {
            ObjReader.parseFaceWord(wordInLine,
                    onePolygonVertexIndices,
                    onePolygonTextureVertexIndices,
                    onePolygonNormalIndices, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Invalid element size.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceWord09() {
        String wordInLine = "/";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        try {
            ObjReader.parseFaceWord(wordInLine,
                    onePolygonVertexIndices,
                    onePolygonTextureVertexIndices,
                    onePolygonNormalIndices, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseFaceWord10() {
        String wordInLine = "1/2/3/4";
        ArrayList<Integer> onePolygonVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonTextureVertexIndices = new ArrayList<>();
        ArrayList<Integer> onePolygonNormalIndices = new ArrayList<>();
        try {
            ObjReader.parseFaceWord(wordInLine,
                    onePolygonVertexIndices,
                    onePolygonTextureVertexIndices,
                    onePolygonNormalIndices, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Invalid element size.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

}