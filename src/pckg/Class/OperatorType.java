package pckg.Class;

import java.util.HashMap;
import java.util.Map;

public enum OperatorType {



    SINGULAR_DIGITAL("SINGULAR_DIGITAL",2, new String[]{"+", "-", "*", "/", "%", "&", "|", "^", "="}),
    SINGULAR_RELATIONAL("SINGULAR_RELATIONAL",2,new String[]{"<", ">"}),
    SINGULAR_LOGICAL("SINGULAR_LOGICAL",2,new String[]{"!"}),
    SINGULAR("SINGULAR",2,new String[]{"+", "-", "*", "/", "%", "&", "|", "^", "=", "<", ">", "!"}),
    DUAL_DIGITAL("DUAL_DIGITAL",1,new String[]{"++", "--", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^="}),
    DUAL_RELATIONAL("DUAL_RELATIONAL",1,new String[]{"<=", ">=", "==", "!="}),
    DUAL_LOGICAL("DUAL_LOGICAL",1,new String[]{"&&", "||"}),
    DUAL("DUAL",1,new String[]{"++", "--", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=","<=", ">=", "==", "!=","&&", "||"}),
    DUAL_WITH_SINGLE_OPERAND("DUAL_WITH_SINGLE_OPERAND",1,new String[]{"++", "--"});


    private static final Map<String, OperatorType> BY_LABEL = new HashMap<>();
    private static final Map<Integer, OperatorType> BY_ITERATION_NUMBER = new HashMap<>();
    private static final Map<String[], OperatorType> BY_ELEMENTS = new HashMap<>();

    static {
        for (OperatorType operatorType : values()) {
            BY_LABEL.put(operatorType.label, operatorType);
            BY_ITERATION_NUMBER.put(operatorType.numberOfIteration, operatorType);
            BY_ELEMENTS.put(operatorType.elements, operatorType);
        }
    }

    public final String label;
    public final int numberOfIteration;
    public final String[] elements;

    OperatorType(String label, int numberOfIteration, String[] elements) {
        this.label = label;
        this.numberOfIteration = numberOfIteration;
        this.elements = elements;
    }

    public static OperatorType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static OperatorType valueOfElements(String[] elements) {
        return BY_ELEMENTS.get(elements);
    }

    public static OperatorType valueOfIterationNumber(int numberOfIteration) {
        return BY_ITERATION_NUMBER.get(numberOfIteration);
    }

}
