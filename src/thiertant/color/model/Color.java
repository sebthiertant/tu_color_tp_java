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
        this.hexValue = hexadecimalString;
    }

    public int getRed(){
        return this.red;
    }

    public void setRed(int red){
        this.red = red;
    }

    public int getGreen(){
        return this.green;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public int getBlue(){
        return this.blue;
    }

    public void setBlue(int blue){
        this.blue = blue;
    }

    public String getHexValue(){
        return this.hexValue;
    }

    public void setHexValue(String hexValue){
        this.hexValue = hexValue;
    }

}
