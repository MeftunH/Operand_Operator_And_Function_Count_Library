package pckg.Class;

import com.github.javafaker.Faker;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakerTest {
    private static Faker faker;
    private List<String> expressionList;
    @BeforeAll
    public static void init() {
        faker = new Faker();
    }

    @BeforeEach
    public void setUp() {
        expressionList = new ArrayList<>();
    }

    @Test
    @Tag("FakerTest")
    void fakerRandomDualRelationalExpressionWithDoubleOperandTest() {;
        for (int i = 0; i < 10; i++) {
            String randomOperator = faker.options().option(OperatorType.DUAL_RELATIONAL.elements);
            int randomOperand = faker.number().randomDigitNotZero();
            expressionList.add(randomOperand + randomOperator+ randomOperand);
        }
        Operator operator = new Operator(expressionList.toString());

        assertEquals(operator.getTotalNumberOfRelationalOperators(),10);
    }

    @Test
    @Tag("FakerTest")
    void fakerRandomSingularRelationalExpressionWithDoubleOperandTest() {
        for (int i = 0; i < 7; i++) {
            String randomOperator = faker.options().option(OperatorType.SINGULAR_RELATIONAL.elements);
            int randomOperand = faker.number().randomDigitNotZero();
            expressionList.add(randomOperand + randomOperator+ randomOperand);
        }
        Operator operator = new Operator(expressionList.toString());
        assertEquals(operator.getTotalNumberOfRelationalOperators(),7);
    }

    @Test
    @Tag("FakerTest")
    void fakerRandomDualExpressionWithSingleOperandTest() {
        for (int i = 0; i < 5; i++) {
            String randomOperator = faker.options().option(OperatorType.DUAL_WITH_SINGLE_OPERAND.elements);
            int randomOperand = faker.number().randomDigitNotZero();
            expressionList.add(randomOperand + randomOperator);
        }
        Operator operator = new Operator(expressionList.toString());
        assertEquals(operator.getTotalNumberOfDualOperators(),5);
    }

    @Test
    @Tag("FakerTest")
    void fakerRandomExpressionDualRelationalWithDoubleOperandCountTest() {
        for (int i = 0; i < 5; i++) {
            String randomOperator = faker.options().option(OperatorType.DUAL_RELATIONAL.elements);
            int firstRandomOperand = faker.number().randomDigitNotZero();
            int secondRandomOperand = faker.number().randomDigitNotZero();
            expressionList.add(firstRandomOperand + randomOperator + secondRandomOperand);
        }
        Operand operand = new Operand(expressionList.toString());
        assertEquals(operand.getOperandCount(),10);
    }

    @Test
    @Tag("FakerTest")
    void fakerRandomExpressionSingularRelationalOperatorWithDoubleOperandCountTest() {
        for (int i = 0; i < 6; i++) {
            String randomOperator = faker.options().option(OperatorType.SINGULAR_RELATIONAL.elements);
            int firstRandomOperand = faker.number().randomDigitNotZero();
            int secondRandomOperand = faker.number().randomDigitNotZero();
            expressionList.add(firstRandomOperand + randomOperator + secondRandomOperand);
        }
        Operand operand = new Operand(expressionList.toString());
        assertEquals(operand.getOperandCount(),12);
    }
}
