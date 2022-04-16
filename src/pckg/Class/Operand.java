package pckg.Class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {
    private FileContentOperation fileContentOperation;
    private String input;
    public int operandCounter;
    public Operand(String input) {
        this.input = fileContentOperation.
                getContentWithoutStringContent(fileContentOperation.
                getUncommentedContent(fileContentOperation.removeWhiteSpace(input)));
        operandCounter = 0;
    }

    public int getOperandCounter() {
        return operandCounter;
    }

    public int findOperandOccurrences(String subString) {
        int operandOccurrences = 0;
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = input.indexOf(subString, lastIndex);

            if (lastIndex != -1) {
                String nextChar = String.valueOf(input.charAt(lastIndex + 1));
                String prevChar = String.valueOf(input.charAt(lastIndex - 1));
                lastIndex += subString.length();

                if (isCharacterLetterOrDigit(nextChar) || isCharacterLetterOrDigit(prevChar)) {
                    operandCounter++;
                }
            }
        }
        return operandCounter;
    }
    private boolean isCharacterLetterOrDigit(String character) {
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(character);

        return matcher.matches();
    }

    @Override
    public String toString() {
        return "Operand{" +
                "operandCounter=" + operandCounter +
                '}';
    }
}
