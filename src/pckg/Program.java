package pckg;

import pckg.Class.FileContentOperation;
import pckg.Class.Operand;
import pckg.Class.Operator;
import pckg.Class.Reader;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader("src/pckg/Testing.java");
        FileContentOperation fileContentOperation = new FileContentOperation();
        Operator operator = new Operator();

        System.out.println(fileContentOperation.
                getUncommentedContent(
                        fileContentOperation.
                                getContentWithoutStringContent(reader.readFromFile("src/pckg/Testing.java"))));

        operator.getTotalNumberOfOperators(fileContentOperation.
                getUncommentedContent(
                        fileContentOperation.
                                getContentWithoutStringContent(reader.readFromFile("src/pckg/Testing.java"))));

    }
}
