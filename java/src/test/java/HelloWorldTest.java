import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        assertEquals("Hello World!", HelloWorld.sayHello(), "1 + 1 should equal 2");
    }
}