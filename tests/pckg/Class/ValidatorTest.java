package pckg.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    public FileContentOperation fileContentOperation;
    public Reader reader;
    public Validator validator;

    @BeforeEach
    public void setUp() throws IOException {
        reader = new Reader("tests/pckg/Testing.java");
        fileContentOperation = new FileContentOperation();
        validator = new Validator("tests/pckg/Testing.java");
    }

    @ParameterizedTest
    @ValueSource(strings = "Testing.java")
    public void isJavaFileShouldReturnTrueTest(String input) {
        Validator fileTypeValidator = new Validator(input);
        assertTrue(fileTypeValidator.isJavaFile());
    }

    @ParameterizedTest
    @CsvSource({
            " private int test2() {" +
                    "  int a=5;" +
                    "  return a;" +
                    "  }",
    })
    public void isContentEmptyShouldReturnFalseTest(String input) {
        assertFalse(validator.isContentEmpty(input));
    }

    @ParameterizedTest
    @Tag("Parametrized")
    @ValueSource(strings = "../SomeFile.java")
    void isFileExistsShouldThrowExceptionTest(String file) {
        Validator fileExistsValidator = new Validator(file);
        assertThrows(FileNotFoundException.class,()->{
            fileExistsValidator.isFileExist();
        });
    }

}
