package thiertant.color.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColorTest {

    private Color color;

    @BeforeEach
    public void setUp() {
        //this.color = new Color("#15AACF");
        this.color = new Color(55, 5,15);
        color.setRed(850);
        color.setGreen(850);
        color.setBlue(850);
    }

    @Test
    public void testConstructorWithThreeArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(256,251,15));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(-256,251,15));

        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(15,256,15));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(15,-256,15));

        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(35,251,256));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(35,251,-256));

    }

    @Test
    public void testConstructorWithStringArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color("#15AACF7"));
    }

    @Test
    public void testSetRed() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setRed(865));
    }

    @Test
    public void testSetGreen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setGreen(865));
    }

    @Test
    public void testSetBlue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setBlue(865));
    }
}