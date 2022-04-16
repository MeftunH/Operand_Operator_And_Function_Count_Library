package pckg.Class;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {

    private String input;
    
    
    private int totalNumberOfSingularOperators;
    private int totalNumberOfDUALOperators;
    private int totalNumberOfOperators;

    public int getTotalNumberOfSingularOperators(String input){
        return totalNumberOfSingularOperators;
    }

    public void setTotalNumberOfSingularOperators(int totalNumberOfSingularOperators) {
        this.totalNumberOfSingularOperators = totalNumberOfSingularOperators;
    }

    public void setTotalNumberOfSingularOperators(String input) {
        this.totalNumberOfSingularOperators = getOperatorCount(input, OperatorType.SINGULAR);
    }

    public int getTotalNumberOfSingularOperators() {
        return totalNumberOfSingularOperators;
    }

    public int getTotalNumberOfDUALOperators() {
        return totalNumberOfDUALOperators;
    }

    public void setTotalNumberOfDUALOperators(int totalNumberOfDUALOperators) {
        this.totalNumberOfDUALOperators = totalNumberOfDUALOperators;
    }

    public void setTotalNumberOfDUALOperators(String input) {
        this.totalNumberOfDUALOperators = getOperatorCount(input,OperatorType.DUAL);;
    }

    public int getTotalNumberOfOperators() {
        return getTotalNumberOfDUALOperators() + getTotalNumberOfSingularOperators();
    }

    public void setTotalNumberOfOperators(int totalNumberOperators) {
        this.totalNumberOfOperators = totalNumberOperators;
    }

    private int getOperatorCount(String input, OperatorType operatorType){

        int operatorCounter = 0;
        for (String operator : operatorType.elements) {
            int index = input.indexOf(operator);
            while (index != -1) {
                if (operatorType.equals(OperatorType.SINGULAR) || operatorType.equals(OperatorType.SINGULAR_DIGITAL)
                      || operatorType.equals(OperatorType.SINGULAR_LOGICAL) || operatorType.equals(OperatorType.SINGULAR_RELATIONAL)) {
                    String nextChar = String.valueOf(input.charAt(index + 1));
                    String prevChar = String.valueOf(input.charAt(index - 1));
                    if(!(nextChar.equals("+") || nextChar.equals("=") || nextChar.equals("-") || nextChar.equals("&") || nextChar.equals("|"))){
                        operatorCounter++;
                        for (String singularOperator : OperatorType.SINGULAR.elements) {
                            if ((prevChar.equals(singularOperator))) {
                                operatorCounter--;
                                System.out.println("operator" + operator + " found at index " + index + "nextChar" + nextChar + "prevChar" + prevChar);
                            }
                        }
                    }
                } else {
                    operatorCounter++;
                }

                input = input.substring(index + operatorType.numberOfIteration);
                index = input.indexOf(operator);
            }
        }
        return operatorCounter;
    }

    public int getTotalNumberOfOperators(String input){
        int totalNumberOfSingularOperators = getOperatorCount(input, OperatorType.SINGULAR);
        int totalNumberOfDUALOperators = getOperatorCount(input, OperatorType.DUAL);
        int totalNumberOfOperators = totalNumberOfSingularOperators + totalNumberOfDUALOperators;
        setTotalNumberOfOperators(totalNumberOfOperators);
        System.out.println("Operator{" +
                "totalNumberOfSingularOperators=" + totalNumberOfSingularOperators +
                ", totalNumberOfDUALOperators=" + totalNumberOfDUALOperators +
                ", totalNumberOperators=" + totalNumberOfOperators +
                '}');
        return totalNumberOfOperators;
    }

}
