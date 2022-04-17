package pckg.Class;

public class Operator {

    private String input;
    private int totalNumberOfSingularOperators;
    private int totalNumberOfDUALOperators;
    private int totalNumberOfDigitalOperators;
    private int totalNumberOfRelationalOperators;
    private int totalNumberOfLogicalOperators;
    private int totalNumberOfOperators;

    public Operator(String input){
        FileContentOperation fileContentOperation = new FileContentOperation();

        this.input = fileContentOperation.getContentWithoutStringContent(fileContentOperation.getUncommentedContent(input));

    }

    public void setTotalNumberOfSingularOperators(int totalNumberOfSingularOperators) {
        this.totalNumberOfSingularOperators = totalNumberOfSingularOperators;
    }

    public int getTotalNumberOfSingularOperators() {
        return totalNumberOfSingularOperators;
    }

    public int getTotalNumberOfDUALOperators() {
        return totalNumberOfDUALOperators;
    }

    public int getTotalNumberOfRelationalOperators() {
        totalNumberOfRelationalOperators = getOperatorCount(OperatorType.SINGULAR_RELATIONAL) + getOperatorCount(OperatorType.DUAL_RELATIONAL);
        return totalNumberOfRelationalOperators;
    }

    public int getTotalNumberOfOperators() {
        return getTotalNumberOfDUALOperators() + getTotalNumberOfSingularOperators();
    }
    public int getTotalNumberOfLogicalOperators() {
        totalNumberOfLogicalOperators = getOperatorCount(OperatorType.SINGULAR_LOGICAL) + getOperatorCount(OperatorType.DUAL_LOGICAL);
        return totalNumberOfLogicalOperators;
    }

    public int getTotalNumberOfDigitalOperators() {
        totalNumberOfDigitalOperators = getOperatorCount( OperatorType.SINGULAR_DIGITAL) + getOperatorCount( OperatorType.DUAL_DIGITAL);
        return totalNumberOfDigitalOperators;
    }

    public void setTotalNumberOfOperators(int totalNumberOperators) {
        this.totalNumberOfOperators = totalNumberOperators;
    }

    private int getOperatorCount(OperatorType operatorType){

        int operatorCounter = 0;

        for (String operator : operatorType.elements) {
            operatorCounter+=findOperatorSubstringCounter(operator,operatorType);
        }
        return operatorCounter;
    }

    private int findOperatorSubstringCounter(String substring,OperatorType operatorType) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = this.input.indexOf(substring,lastIndex);

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
    public int getTotalNumberOfOperator(){
        int totalNumberOfSingularOperators = getOperatorCount(OperatorType.SINGULAR);
        int totalNumberOfDUALOperators = getOperatorCount(OperatorType.DUAL);
        int totalNumberOfOperators = totalNumberOfSingularOperators + totalNumberOfDUALOperators;
        int totalNumberOfDigitalOperators = getTotalNumberOfDigitalOperators();
        int totalNumberOfRelationalOperators = getTotalNumberOfRelationalOperators();
        int totalNumberOfLogicalOperators = getTotalNumberOfLogicalOperators();
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
