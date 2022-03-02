package thiertant.color.model;

public class Color {

    private int red;
    private int green;
    private int blue;
    private final static char[] VALUES = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F' };

    /** @author Peter Bardu
     * tableau de caractères de taille 6 avec les cases 0 et 1 pour le rouge, 2 et 3
     * pour le vert et 4 et 5 pour le bleu en hexadécimal.
     */
    private char[] tabChar;


    public Color(int red, int green, int blue){
        this.tabChar = new char[6];

        if (red >= 0 && red < 255) {
            setRed(red);
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }

        if (green >= 0 && green < 255){
            setGreen(green);
        }
        else {
            throw new IllegalArgumentException("Green color is not valid");
        }

        if (blue >= 0 && blue < 255){
            setBlue(blue);
        }
        else {
            throw new IllegalArgumentException("Blue color is not valid");
        }
    }

    public Color(String hexadecimalString){
        tabChar = new char[6];
        if ((hexadecimalString != null) && (checkHex(hexadecimalString))) {
            setHexValue(hexadecimalString);
        }
        else {
            throw new IllegalArgumentException("Hexadecimal string format is not valid");
        }
    }

    private boolean checkHex(String s)
    {
        if (s == null) {
            return false;
        } else {

        //check #
        String firstChar = s.substring(0,1);
        if (!firstChar.equals("#")){
            return false;
        } else {
            int n = s.length();
            if (s.length() != 7)
            {
                return false;
            }
            // on démarre à 1 pour ne plus vérifier le #
                for (int i = 1; i < n; i++) {
                    char ch = s.charAt(i);
                    if ((ch < '0' || ch > '9')
                            && (ch < 'A' || ch > 'F')) {
                        return false;
                    }
                }
        }
            return true;
        }
    }

    public int getRed(){
        return this.red;
    }

    public void setRed(int red) {
        if (red >= 0 && red < 255) {
            this.red = red;
            updateRedHexValue();
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }

    public int getGreen() {
        return this.green;
    }

    public void setGreen(int green) {
        if (green >= 0 && green < 255) {
            this.green = green;
            updateGreenHexValue();
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }

    public int getBlue() {
        return this.blue;
    }

    public void setBlue(int blue) {
        if (blue >= 0 && blue < 255) {
            this.blue = blue;
            updateBlueHexValue();
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }
    /**
     * Méthode de type get permettant de retourner la valeur hexa de la couleur
     *
     * @return la couleur au format hexa
     * @author Peter Bardu
     */
    public String getHexValue() {
        return "#" + new String(tabChar);
    }

    public void setHexValue(String hexValue) {
        if (hexValue != null && checkHex(hexValue)) {
            updateHexValueFromString(hexValue);
            updateRGB();
        }
        else {
            throw new IllegalArgumentException("Hexadecimal string format is not valid");
        }
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa à partir d'une chaîne de
     * caractère bien formée.
     *
     * @param s
     * @author Peter Bardu
     *            la chaîne bien formée
     */
    private void updateHexValueFromString(String s) {
        this.tabChar[0] = s.charAt(1);
        this.tabChar[1] = s.charAt(2);
        this.tabChar[2] = s.charAt(3);
        this.tabChar[3] = s.charAt(4);
        this.tabChar[4] = s.charAt(5);
        this.tabChar[5] = s.charAt(6);
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du rouge
     */
    private void updateRedHexValue() {
        tabChar[0] = VALUES[red / 16];
        tabChar[1] = VALUES[red % 16];
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du vert
     */
    private void updateGreenHexValue() {
        tabChar[2] = VALUES[green / 16];
        tabChar[3] = VALUES[green % 16];
    }

    /**
     * Méthode permettant de mettre à jour la valeur hexa du bleu
     */
    private void updateBlueHexValue() {
        tabChar[4] = VALUES[blue / 16];
        tabChar[5] = VALUES[blue % 16];
    }

    /**
     * Récupère la valeur décimal d'un élément hexa, exemple : '1' -> 1, 'A' -> 10.
     *
     * @param charValue le caractère cherché
     * @return la valeur décimal correspondante
     * @author Peter Bardu
     */
    private int indexOf(char charValue) {

        for (int i = 0; i < VALUES.length; i++)
            if (VALUES[i] == charValue)
                return i;

        throw new IllegalArgumentException();
    }

    /**
     * Méthode permettant de mettre à jour la valeur de RGB à partir de la valeur
     * hexa
     * @author Peter Bardu
     */
    private void updateRGB() {
        red = indexOf(tabChar[0]) * 16 + indexOf(tabChar[1]);
        green = indexOf(tabChar[2]) * 16 + indexOf(tabChar[3]);
        blue = indexOf(tabChar[4]) * 16 + indexOf(tabChar[5]);
    }

    @Override
    public String toString() {
        return "[value=" + getHexValue() + ", r=" + getRed() + ", g=" + getGreen() + ", b=" + getBlue() + "]";
    }

}
