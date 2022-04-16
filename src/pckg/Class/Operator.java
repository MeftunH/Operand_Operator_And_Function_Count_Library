package pckg.Class;

public class Operator {

    private String input;
    
    
    private int totalNumberOfSingularOperators;
    private int totalNumberOfDUALOperators;
    private int totalNumberOfDigitalOperators;
    private int totalNumberOfRelationalOperators;
    private int totalNumberOfLogicalOperators;
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

    public int getTotalNumberOfRelationalOperators(String input) {
        totalNumberOfRelationalOperators = getOperatorCount(input, OperatorType.SINGULAR_RELATIONAL) + getOperatorCount(input, OperatorType.DUAL_RELATIONAL);
        return totalNumberOfRelationalOperators;
    }

    public void setTotalNumberOfRelationalOperators(int totalNumberOfRelationalOperators) {
        this.totalNumberOfRelationalOperators = totalNumberOfRelationalOperators;
    }

    public int getTotalNumberOfOperators() {
        return getTotalNumberOfDUALOperators() + getTotalNumberOfSingularOperators();
    }
    public int getTotalNumberOfLogicalOperators(String input) {
        totalNumberOfLogicalOperators = getOperatorCount(input, OperatorType.SINGULAR_LOGICAL) + getOperatorCount(input, OperatorType.DUAL_LOGICAL);
        return totalNumberOfLogicalOperators;
    }

    public void setTotalNumberOfLogicalOperators(int totalNumberOfLogicalOperators) {
        this.totalNumberOfLogicalOperators = totalNumberOfLogicalOperators;
    }

    public int getTotalNumberOfDigitalOperators(String input) {
        totalNumberOfDigitalOperators = getOperatorCount(input, OperatorType.SINGULAR_DIGITAL) + getOperatorCount(input, OperatorType.DUAL_DIGITAL);
        return totalNumberOfDigitalOperators;
    }

    public void setTotalNumberOfOperators(int totalNumberOperators) {
        this.totalNumberOfOperators = totalNumberOperators;
    }

    private int getOperatorCount(String input, OperatorType operatorType){

        int operatorCounter = 0;

        for (String operator : operatorType.elements) {
            operatorCounter+=findOperatorSubstringCounter(input,operator,operatorType);
        }
        return operatorCounter;
    }

    private int findOperatorSubstringCounter(String input, String substring,OperatorType operatorType) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = input.indexOf(substring,lastIndex);

            if(lastIndex != -1){
                if (operatorType.equals(OperatorType.SINGULAR) || operatorType.equals(OperatorType.SINGULAR_DIGITAL)
                      || operatorType.equals(OperatorType.SINGULAR_LOGICAL) || operatorType.equals(OperatorType.SINGULAR_RELATIONAL)) {
                    String nextChar = String.valueOf(input.charAt(lastIndex + 1));
                    String prevChar = String.valueOf(input.charAt(lastIndex - 1));
                    if(!(nextChar.equals("+") || nextChar.equals("=") || nextChar.equals("-") || nextChar.equals("&") || nextChar.equals("|"))){
                        count++;
                        for (String singularOperator : OperatorType.SINGULAR.elements) {
                            if ((prevChar.equals(singularOperator))) {
                                count--;
                            }
                        }
                    }
                } else {
                    count++;
                }

                lastIndex += substring.length();
            }
        }
        return count;

    }
    public int getTotalNumberOfOperators(String input){
        int totalNumberOfSingularOperators = getOperatorCount(input, OperatorType.SINGULAR);
        int totalNumberOfDUALOperators = getOperatorCount(input, OperatorType.DUAL);
        int totalNumberOfOperators = totalNumberOfSingularOperators + totalNumberOfDUALOperators;
        int totalNumberOfDigitalOperators = getTotalNumberOfDigitalOperators(input);
        int totalNumberOfRelationalOperators = getTotalNumberOfRelationalOperators(input);
        int totalNumberOfLogicalOperators = getTotalNumberOfLogicalOperators(input);
        setTotalNumberOfOperators(totalNumberOfOperators);
        System.out.println("Operator{" +
                "totalNumberOfSingularOperators=" + totalNumberOfSingularOperators +
                ", totalNumberOfDUALOperators=" + totalNumberOfDUALOperators +
                ", totalNumberOperators=" + totalNumberOfOperators +
                ", totalNumberOfDigitalOperators=" + totalNumberOfDigitalOperators +
                ", totalNumberOfRelationalOperators=" + totalNumberOfRelationalOperators +
                "\n"+
                ", totalNumberOfLogicalOperators=" + totalNumberOfLogicalOperators +
                '}');
        return totalNumberOfOperators;
    }
}
