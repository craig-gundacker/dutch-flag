package dutchflag;
import javafx.scene.shape.Rectangle;

/*
Class to encapsulate thread
*/
public class Thread extends Rectangle
{
    private ThreadColor color; //color enum type
    
    public Thread()
    {
       setWidth(Flag.WIDTH);
       setHeight(1);
    }

    public ThreadColor getColor() 
    {
        return color;
    }

    public void setColor(ThreadColor color) 
    {
        this.color = color;
        setFill(color.getColorValue());
    }
}
