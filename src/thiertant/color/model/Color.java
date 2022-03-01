package thiertant.color.model;

public class Color {

    private int red;
    private int green;
    private int blue;
    private String hexValue;

    public Color(int red, int green, int blue){

        if (red >= 0 && red < 255) {
            this.red = red;
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }

        if (green >= 0 && green < 255){
            this.green = green;
        }
        else {
            throw new IllegalArgumentException("Green color is not valid");
        }

        if (blue >= 0 && blue < 255){
            this.blue = blue;
        }
        else {
            throw new IllegalArgumentException("Blue color is not valid");
        }

    }

    public Color(String hexadecimalString){
        if (checkHex(hexadecimalString)){
            this.hexValue = hexadecimalString;
        }
        else {
            throw new IllegalArgumentException("Hexadecimal string format is not valid");
        }
    }

    public static boolean checkHex(String s)
    {
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
            return true;
        }
    }

    public int getRed(){
        return this.red;
    }

    public void setRed(int red) {
        if (red >= 0 && red < 255) {
            this.red = red;
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }

    public int getGreen(){
        return this.green;
    }

    public void setGreen(int green){
        if (green >= 0 && green < 255) {
            this.green = green;
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }

    public int getBlue(){
        return this.blue;
    }

    public void setBlue(int blue){
        if (blue >= 0 && blue < 255) {
            this.blue = blue;
        }
        else {
            throw new IllegalArgumentException("Red color is not valid");
        }
    }

    public String getHexValue(){
        return this.hexValue;
    }

    public void setHexValue(String hexValue){
        this.hexValue = hexValue;
    }

}
