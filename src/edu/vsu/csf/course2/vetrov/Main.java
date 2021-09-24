package edu.vsu.csf.course2.vetrov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static String moveModel(String fileContent, double x, double y, double z) {
        Scanner scanner = new Scanner(fileContent);
        StringBuilder newString = new StringBuilder();
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            ArrayList<String> wordsInLine = new ArrayList<>(Arrays.asList(line.split("\\s+")));
            if (wordsInLine.isEmpty())
                continue;

            final String token = wordsInLine.get(0);

            if (token.equals("v")) {
                wordsInLine.set(1, String.format("%.4f", Double.parseDouble(wordsInLine.get(1)) + x));
                wordsInLine.set(2, String.format("%.4f", Double.parseDouble(wordsInLine.get(2)) + y));
                wordsInLine.set(3, String.format("%.4f", Double.parseDouble(wordsInLine.get(3)) + z));
                newString.append(wordsInLine.get(0)).append(" ")
                        .append(wordsInLine.get(1)).append(" ")
                        .append(wordsInLine.get(2)).append(" ")
                        .append(wordsInLine.get(3)).append("\n");
            } else {
                newString.append(line).append("\n");
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ROOT);
        Path fileName = Path.of("WrapHand.obj");
        String fileContent = Files.readString(fileName);
        double x = 1;
        double y = 2;
        double z = -1;
        String newString = moveModel(fileContent, x, y, z);
        Files.writeString(Path.of("Moved" + fileName), newString);
        System.out.println("All good?");
    }


}
