package thiertant.color.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColorTest {

    private Color color;
    private Color hexConstructColor;

    @BeforeEach
    public void setUp() {
        this.hexConstructColor = new Color("#15AACF");
        this.color = new Color(55, 5,15);
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
        this.color.setRed(55);
        Assertions.assertEquals(55, color.getRed(), "Set red value is not valid");
    }

    @Test
    public void testSetGreen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setGreen(865));
        this.color.setGreen(55);
        Assertions.assertEquals(55, color.getGreen(), "Set green value is not valid on green value");
        Assertions.assertEquals(55, color.getRed(), "Set green value is not valid on red value");
        Assertions.assertEquals(15, color.getBlue(), "Set green value is not valid on blue value");
        //Assertions.assertEquals("#15AACF", color.getHexValue(), "Set blue value is not valid on hex value");
    }

    @Test
    public void testSetBlue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> color.setBlue(865));
        this.color.setBlue(55);
        Assertions.assertEquals(5, color.getGreen(), "Set blue value is not valid on green value");
        Assertions.assertEquals(55, color.getRed(), "Set blue value is not valid on red value");
        Assertions.assertEquals(55, color.getBlue(), "Set blue value is not valid on blue value");
        //Assertions.assertEquals("#15AACF", color.getHexValue(), "Set blue value is not valid on hex value");
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[value=#15AACF, r=55, g=5, b=15]", color.toString(), "Error on the toString override method");
    }

    /*
    @AfterEach
    public void afterTestCheck() {
        Assertions.assertEquals(55, color.getRed(), "AfterEach red value is not valid");
        Assertions.assertEquals(5, color.getGreen(), "AfterEach green value is not valid");
        Assertions.assertEquals(55, color.getBlue(), "AfterEach blue value is not valid");
       //Assertions.assertEquals("#15AACF", color.getHexValue(), "Set blue value is not valid on hex value");
    }
     */

}