package pckg.Class;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OperatorTest {
    Operator operator;
    @Mock
    FileContentOperation fileContentOperationMock;

    @Test
    @Tag("MockTest")
    public void operandInputUncommentedContentTest() {
        assertNotNull(fileContentOperationMock);
        fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("5+3-1 //2+2")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("5+3-1 //2+2"));
        assertEquals(2, operator.getTotalNumberOfOperator());
    }

    @Test
    @Tag("MockTest")
    public void operandInputWithoutStringContentTest() {
        assertNotNull(fileContentOperationMock);
        fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');"));
        assertEquals(2, operator.getTotalNumberOfOperator());
    }

    @Test
    @Tag("MockTest")
    public void operatorInputWithStringContentTest() {
        assertNotNull(fileContentOperationMock);
        fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');"));
        assertEquals(2, operator.getTotalNumberOfOperator());
    }

    @Test
    @Tag("MockTest")
    public void operatorInputWithStringContentTest2() {
        assertNotNull(fileContentOperationMock);
        fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');"));
        assertEquals(2, operator.getTotalNumberOfOperator());
    }

    @Test
    @Tag("MockTest")
    void operandConstructorTest() {
         FileContentOperation fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("5+3-1 System.out.println('1+2');"));
        assertThat(operator, notNullValue());
    }

    @Test
    @Tag("MockTest")
    void operatorInstanceOfTest() {
        FileContentOperation fileContentOperationMock = mock(FileContentOperation.class);
        when(fileContentOperationMock.getUncommentedContent("1+3/1 System.out.println('1+2');")).thenReturn("5+3-1");
        operator = new Operator(fileContentOperationMock.getUncommentedContent("1+3/1 System.out.println('1+2');"));
        assertThat(operator, instanceOf(Operator.class));
    }

}
