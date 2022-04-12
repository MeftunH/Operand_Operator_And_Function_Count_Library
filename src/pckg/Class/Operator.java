package pckg.Class;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private String input;
    String[] SINGULAROperators = {"+", "-", "*", "/", "%", "&", "|", "^", "=", "<", ">", "!"};
    String[] dualOperators = {"++", "--", "+=", "-=", "*=", "/=", "%=", "&=", "&&", "^=", "<=", ">=" ,"|=", "==", "!=", "||"};
    OperatorType operatorType;
    
    
    private int totalNumberOfSINGULAROperators;
    private int totalNumberOfDualOperators;
    private int totalNumberOfOperators;

    public int getTotalNumberOfSINGULAROperators(String input){
        return totalNumberOfSINGULAROperators;
    }

    public void setTotalNumberOfSINGULAROperators(int totalNumberOfSINGULAROperators) {
        this.totalNumberOfSINGULAROperators = totalNumberOfSINGULAROperators;
    }

    public void setTotalNumberOfSINGULAROperators(String input) {
        this.totalNumberOfSINGULAROperators = getOperatorCount(input, OperatorType.SINGULAR.elements,1);
    }

    public int getTotalNumberOfSINGULAROperators() {
        return totalNumberOfSINGULAROperators;
    }

    public int getTotalNumberOfDualOperators() {
        return totalNumberOfDualOperators;
    }

    public void setTotalNumberOfDualOperators(int totalNumberOfDualOperators) {
        this.totalNumberOfDualOperators = totalNumberOfDualOperators;
    }

    public void setTotalNumberOfDualOperators(String input) {
        this.totalNumberOfDualOperators = getOperatorCount(input, OperatorType.Dual.elements,2);;
    }

    public int getTotalNumberOfOperators() {
        return getTotalNumberOfDualOperators() + getTotalNumberOfSINGULAROperators();
    }

    public void setTotalNumberOfOperators(int totalNumberOperators) {
        this.totalNumberOfOperators = totalNumberOperators;
    }

    private int getOperatorCount(String input, String[] operators, int numberOfJump) {
        int operatorCounter = 0;
        for (String operator : operators) {
            int index = input.indexOf(operator);
            while (index != -1) {
                operatorCounter++;
                input = input.substring(index + numberOfJump);
                index = input.indexOf(operator);
            }
        }
        return operatorCounter;
    }

    public int getTotalNumberOfOperators(String input){
        int totalNumberOfSINGULAROperators = getOperatorCount(input, SINGULAROperators,1);
        int totalNumberOfDualOperators = getOperatorCount(input, dualOperators,2);
        int totalNumberOfOperators = totalNumberOfSINGULAROperators + totalNumberOfDualOperators;
        setTotalNumberOfOperators(totalNumberOfOperators);
        System.out.println("Operator{" +
                "totalNumberOfSINGULAROperators=" + totalNumberOfSINGULAROperators +
                ", totalNumberOfDualOperators=" + totalNumberOfDualOperators +
                ", totalNumberOperators=" + totalNumberOfOperators +
                '}');
        return totalNumberOfOperators;
    }

}
