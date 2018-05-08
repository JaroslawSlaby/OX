package com.js.tictactoe.parser;

import java.util.function.Supplier;

public class DigitParser {


    public static String correctCoordinates(Supplier<String> input) {
        boolean isNumber;
        String line;
        do {
            line = input.get();

            if (line.equalsIgnoreCase("quit"))
                return line;

            isNumber = DigitParser.isInputContainingDigits(line);

            if (!isNumber)
                System.out.println("Wrong coordinates!");

        } while (!isNumber);
        return line;
    }

    public static boolean isInputContainingDigits(String line) {
        return line.matches("[0-9 ]+");
    }
}
