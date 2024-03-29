package pckg;

import pckg.Class.*;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader("tests/pckg/Testing.java");

        FileContentOperation fileContentOperation = new FileContentOperation();

        Validator validator = new Validator(fileContentOperation.
                getUncommentedContent(
                        fileContentOperation.
                                getContentWithoutStringContent(reader.readFromFile("tests/pckg/Testing.java"))));

        Operator operator = new Operator(fileContentOperation.getContentWithoutStringContent(reader.readFromFile("tests/pckg/Testing.java")));

        System.out.println("operator = " +   operator.getTotalNumberOfOperators());
        System.out.println(fileContentOperation.
                getUncommentedContent(
                        fileContentOperation.
                                getContentWithoutStringContent(reader.readFromFile("tests/pckg/Testing.java"))));


        Operand operand = new Operand(fileContentOperation.
                getContentWithoutStringContent(reader.readFromFile("tests/pckg/Testing.java")));
        operand.getOperandCount();

        Function function = new Function();
        function.getFunctionCounter(fileContentOperation.getContentWithoutStringContent(reader.readFromFile("tests/pckg/Testing.java")));
    }
}
