package pckg.Class;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private String input;
    String[] SINGULAROperators = {"+", "-", "*", "/", "%", "&", "|", "^", "=", "<", ">", "!"};
    String[] DUALOperators = {"++", "--", "+=", "-=", "*=", "/=", "%=", "&=", "&&", "^=", "<=", ">=" ,"|=", "==", "!=", "||"};
    OperatorType operatorType;
    
    
    private int totalNumberOfSINGULAROperators;
    private int totalNumberOfDUALOperators;
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

    public int getTotalNumberOfDUALOperators() {
        return totalNumberOfDUALOperators;
    }

    public void setTotalNumberOfDUALOperators(int totalNumberOfDUALOperators) {
        this.totalNumberOfDUALOperators = totalNumberOfDUALOperators;
    }

    public void setTotalNumberOfDUALOperators(String input) {
        this.totalNumberOfDUALOperators = getOperatorCount(input, OperatorType.DUAL.elements,2);;
    }

    public int getTotalNumberOfOperators() {
        return getTotalNumberOfDUALOperators() + getTotalNumberOfSINGULAROperators();
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
        int totalNumberOfDUALOperators = getOperatorCount(input, DUALOperators,2);
        int totalNumberOfOperators = totalNumberOfSINGULAROperators + totalNumberOfDUALOperators;
        setTotalNumberOfOperators(totalNumberOfOperators);
        System.out.println("Operator{" +
                "totalNumberOfSINGULAROperators=" + totalNumberOfSINGULAROperators +
                ", totalNumberOfDUALOperators=" + totalNumberOfDUALOperators +
                ", totalNumberOperators=" + totalNumberOfOperators +
                '}');
        return totalNumberOfOperators;
    }

}
