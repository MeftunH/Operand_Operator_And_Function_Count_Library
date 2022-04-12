package pckg.Class;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private String input;
    String[] singleOperators = {"+", "-", "*", "/", "%", "&", "|", "^", "=", "<", ">", "!"};
    String[] dualOperators = {"++", "--", "+=", "-=", "*=", "/=", "%=", "&=", "&&", "^=", "<=", ">=" ,"|=", "==", "!=", "||"};

    private int totalNumberOfSingleOperators;
    private int totalNumberOfDualOperators;
    private int totalNumberOperators;

    public int getTotalNumberOfSingleOperators(String input){
        return totalNumberOfSingleOperators;
    }

    public void setTotalNumberOfSingleOperators(int totalNumberOfSingleOperators) {
        this.totalNumberOfSingleOperators = totalNumberOfSingleOperators;
    }

    public void setTotalNumberOfSingleOperators(String input) {
        this.totalNumberOfSingleOperators = getOperatorCount(input, singleOperators);
    }

    public int getTotalNumberOfSingleOperators() {
        return totalNumberOfSingleOperators;
    }

    public int getTotalNumberOfDualOperators() {
        return totalNumberOfDualOperators;
    }

    public void setTotalNumberOfDualOperators(int totalNumberOfDualOperators) {
        this.totalNumberOfDualOperators = totalNumberOfDualOperators;
    }

    public void setTotalNumberOfDualOperators(String input) {
        this.totalNumberOfDualOperators = getOperatorCount(input, dualOperators);;
    }

    public int getTotalNumberOperators() {
        return getTotalNumberOfDualOperators() + getTotalNumberOfSingleOperators();
    }

    public void setTotalNumberOperators(int totalNumberOperators) {
        this.totalNumberOperators = totalNumberOperators;
    }

    public int findOperators(String input) {

        //Regex hali
//        Pattern pattern = Pattern.compile(operatorPattern);
//        Matcher matcher = pattern.matcher(input);
//        while (matcher.find()) {
//            operatorCounter++;
//        }






        System.out.println("Operator Counter22: " + getTotalNumberOfOperators(input));
        return getTotalNumberOfOperators(input);
    }

    private int getOperatorCount(String input, String[] operators) {
        int operatorCounter = 0;
        for (String operator : operators) {
            int index = input.indexOf(operator);
            while (index != -1) {
                operatorCounter++;
                input = input.substring(index + 1);
                index = input.indexOf(operator);
            }
        }
        return operatorCounter;
    }

    public int getTotalNumberOfOperators(String input){
        int totalNumberOfSingleOperators=getOperatorCount(input, singleOperators);
        int totalNumberOfDualOperators=getOperatorCount(input, dualOperators);
        int totalNumberOfOperators=totalNumberOfSingleOperators+totalNumberOfDualOperators;
        return totalNumberOfOperators;
    }

}
