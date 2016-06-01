
package dutchflag;

import javafx.scene.paint.Color;

/*
An enumerator to encapsulate data about each color represented in flag
*/
public enum ThreadColor 
{
    //Constructs enums
    RED(0, Color.RED), WHITE(1, Color.WHITE), BLUE(2, Color.BLUE); 

    private final int numValue;
    private final Color color;

    ThreadColor(int numValue, Color color)
    {
        this.numValue = numValue;
        this.color = color;
    }
    
    public int getNumValue()
    {
        return numValue;
    }
    
    public Color getColorValue()
    {
        return color;
    }
}
