package pckg.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operand {
    private String input;
    public int operandCounter;
    public Operand(String input) {
        FileContentOperation fileContentOperation = new FileContentOperation();
        this.input = fileContentOperation.removeWhiteSpace(fileContentOperation.getContentWithoutStringContent(fileContentOperation.getUncommentedContent(input)));
        operandCounter = 0;
    }

    public int getOperandCount() {
        int operandCounter = 0;

        for (String operator : OperatorType.DUAL.elements) {
            operandCounter+=findOperandOccurrences(operator,2,OperatorType.DUAL);
        }

        removeDualOperatorOperands();
        for (String operator : OperatorType.SINGULAR.elements) {
            operandCounter+=findOperandOccurrences(operator,1,OperatorType.SINGULAR);
        }
        return operandCounter;
    }

    private void removeDualOperatorOperands(){

        Pattern pattern = Pattern.compile(
                        "\\+\\+|--|" +          // ++ --
                        "\\+=|-=|\\*=|" +       // += -= *=
                        "/=|%=|&=|\\^=|" +      // /= %= &= ^=
                        "\\|=|" +               // |=
                        "==|!=|<=|>=|" +        // == != <= >=
                        "&&|\\|\\||" +          // && ||
                        "instanceof"            // instanceof
        );
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
               input = matcher.replaceAll("");
            }
    }

    public int findOperandOccurrences(String subString,int iterateCount,OperatorType operatorType){
        operandCounter = 0;

        for (int i = -1; (i = input.indexOf(subString, i + 1)) != -1; i++) {

            String nextChar = String.valueOf(input.charAt(i+1));
            String prevChar = String.valueOf(input.charAt(i-1));

            if((isCharacterLetterOrDigit(prevChar) || isCharacterLetterOrDigit(nextChar))){
                if (subString.equals("++") || subString.equals("--")) {
                    operandCounter = operandCounter + 1;
                }
                else if(subString.equals("&&") || subString.equals("||")){
                    operandCounter = operandCounter - 1;
                }
                else {
                    operandCounter = operandCounter + 2;
                }
            }
        }


        return operandCounter;
    }

    private boolean isCharacterLetterOrDigit(String character){
        return character.matches("[a-zA-Z0-9]");
    }
    @Override
    public String toString() {
        return "Operand{" +
                "operandCounter=" + operandCounter +
                '}';
    }
}
