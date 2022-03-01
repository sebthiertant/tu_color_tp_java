package thiertant.color.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColorTest {

    private Color color;

    @BeforeEach
    public void setUp() {
        this.color = new Color(55, 5,15);
    }

    @Test
    public void testConstructorWithThreeArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(256,251,15));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(15,256,15));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Color(35,251,256));
    }
}