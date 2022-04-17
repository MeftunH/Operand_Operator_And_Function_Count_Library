package pckg.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    public FileContentOperation fileContentOperation;
    public Reader reader;
    public Validator validator;
    public Operator operator;

    @BeforeEach
    public void setUp() throws IOException {
        reader = new Reader("src/pckg/Testing.java");
        fileContentOperation = new FileContentOperation();
        operator = new Operator(fileContentOperation.getContentWithoutStringContent(reader.readFromFile("src/pckg/Testing.java")));
        validator = new Validator("src/pckg/Testing.java");
    }

    @Test
    public void isContentEmptyTest() throws IOException {
       assertFalse(validator.isContentEmpty(reader.readFromFile("src/pckg/Testing.java")));
    }

    @Test
    public void whenContentEmpty_thenThrownExceptionTest(@TempDir Path tempDir) throws IOException {
        final Path emptyFile = Files.createFile(tempDir.resolve("emptyFile.java"));
        final String emptyFileContent = Files.readString(emptyFile);


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isContentEmpty(emptyFileContent);
        });
        String expectedMessage = "File is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void isOperatorNumberTrueTest() {
        assertEquals(19, operator.getTotalNumberOfOperators());
    }

    @Test
    public void isDualOperatorNumberTrueTest() {
        assertEquals(11, operator.getTotalNumberOfDualOperators());
    }

    @Test
    public void isSingularOperatorNumberTrueTest() {
        assertEquals(8, operator.getTotalNumberOfSingularOperators());
    }

    @Test
    public void isDigitalOperatorNumberTrueTest() {
        assertEquals(12, operator.getTotalNumberOfDigitalOperators());
    }

    @Test
    public void isRelationalOperatorNumberTrueTest() {
        assertEquals(4, operator.getTotalNumberOfRelationalOperators());
    }
}
