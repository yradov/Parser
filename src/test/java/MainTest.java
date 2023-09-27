import com.um191.Main;
import org.junit.Assert;
import org.junit.Test;


public class MainTest {
   @Test
    public void testGetGreetings() {
       String expected = "Hello and welcome Sasha!";
       String actual = Main.getGreetings("Sasha");
       Assert.assertEquals(expected, actual);

       expected = "Hello and welcome Yura!";
       actual = Main.getGreetings("Yura");
       Assert.assertEquals(expected, actual);
    }
}
