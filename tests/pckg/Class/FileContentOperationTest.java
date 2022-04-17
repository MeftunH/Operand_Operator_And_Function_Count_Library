package pckg.Class;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileContentOperationTest {
 public FileContentOperation fileContentOperation;
 public Reader reader;

 public Validator validator;

 @BeforeEach
 public void setUp() throws IOException {
   reader = new Reader("tests/pckg/Testing.java");
  fileContentOperation = new FileContentOperation();
  validator = new Validator("tests/pckg/Testing.java");
 }
 @Test
 void isJavaFileTest() {
  assertTrue(validator.isJavaFile());
 }

}