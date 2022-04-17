package pckg.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    public FileContentOperation fileContentOperation;
    public Reader reader;
    public Validator validator;

    @BeforeEach
    public void setUp() throws IOException {
        reader = new Reader("src/pckg/Testing.java");
        fileContentOperation = new FileContentOperation();
        validator = new Validator("src/pckg/Testing.java");
    }

    @Test
    public void whenValidFile_thenReturnTrueTest() throws IOException {
        assertTrue(validator.isFileExist());
    }
}
