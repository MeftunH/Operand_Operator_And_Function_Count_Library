package pckg.Class;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperandTest {
    Operand operand;
    @BeforeEach
    void setUp() {
        operand = new Operand("5+1");
    }

    @RepeatedTest(3)
    @Tag("RepeatedTest")
    void isCharacterLetterOrDigitRepeatedTest(){
      Faker faker = new Faker();
      int randomNumber = faker.number().randomDigitNotZero();
      assertTrue(operand.isCharacterLetterOrDigit(Integer.toString(randomNumber)));
    }
}
