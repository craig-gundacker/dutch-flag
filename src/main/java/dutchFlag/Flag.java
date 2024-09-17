package dutchflag;
import java.security.SecureRandom;
import javafx.scene.layout.Pane;

/*
Class to encapsulate Flag
*/
public class Flag extends Pane
{
    protected static final double WIDTH = 400;
    protected static final double HEIGHT = 300;
    private static final int NUM_THREADS = (int)HEIGHT;
    private static final int MAX_THREADS_PER_COLOR = NUM_THREADS / 3;
    private Thread[] threads = new Thread[NUM_THREADS];
    
    
    public Flag()
    {
        setWidth(WIDTH);
        setHeight(HEIGHT);
        fillFlag();
    }
    
    /*
    Fills flag with equal number of randomnly colored threads
    */
    private void fillFlag()
    {
        SecureRandom random = new SecureRandom();
        //Holds number of threads of each color that have been added to flag
        int numRed = 0;
        int numWhite = 0;
        int numBlue = 0;
          
        for (int i = 0; i < NUM_THREADS; i++)
        {
            Thread thread = new Thread(); //Creates new Thread
            boolean threadColored = false;
            /*
            Iterates until the variable numColor represents a ThreadColor that
            can be placed in Flag
            */
            while (!threadColored)
            {
                int numColor = random.nextInt(ThreadColor.values().length); //Generates 0, 1, or 2
                if (numColor == ThreadColor.RED.getNumValue() && numRed < MAX_THREADS_PER_COLOR)
                {
                    thread.setColor(ThreadColor.RED);
                    numRed++;
                    threadColored = true;
                }
                else if (numColor == ThreadColor.WHITE.getNumValue() && numWhite < MAX_THREADS_PER_COLOR)
                {
                    thread.setColor(ThreadColor.WHITE);
                    numWhite++;
                    threadColored = true;
                }
                else if (numColor == ThreadColor.BLUE.getNumValue() && numBlue < MAX_THREADS_PER_COLOR)
                {
                    thread.setColor(ThreadColor.BLUE);
                    numBlue++;
                    threadColored = true;
                }
            }
            thread.setX(0);
            thread.setY(i);
            threads[i] = thread; //Adds thread to array
            getChildren().add(thread); //Adds thread to Pane
        }
    }

    /*
    Sorts threads using recursion.  Variable lowIndex is upper bound for a Threads
    in array that are properly sorted as red.  The highIndex variable is lower
    bound for all Threads that are blue.  When variable midIndex is greater than
    highIndex, then the sort is complete
    */
    public void sort()
    {
        int lowIndex = 0;
        int midIndex = 0;
        int highIndex = threads.length - 1;

        while (midIndex <= highIndex)
        {
            ThreadColor threadColor = threads[midIndex].getColor();
            int value = threadColor.getNumValue();
            if (value == ThreadColor.RED.getNumValue())
            {
                swap(lowIndex, midIndex);
                lowIndex++;
                midIndex++;                
            }
            else if (value == ThreadColor.WHITE.getNumValue())
            {
                midIndex++;
            }
            else
            {
                swap(midIndex, highIndex);
                highIndex--;
            }
        }
        displaySorted();
    }
    
    /*
    Swaps threads in array of threads
    */
    public void swap(int low, int high)
    {
        Thread temp = threads[low];
        threads[low] = threads[high];
        threads[high] = temp;
    }
    
    /*
    Displays sorted threads in Pane.  Clears Pane members.  Then iterates
    through Thread array, retrieving the color value of each thread and then
    adding it to Pane
    */
    private void displaySorted()
    {
        getChildren().clear();
        ThreadColor red = ThreadColor.RED;
        ThreadColor white = ThreadColor.WHITE;
        ThreadColor blue = ThreadColor.BLUE;
        int i = 0;
        for (Thread thread: threads)
        {
            ThreadColor color = thread.getColor();
            if (color.equals(red))
                thread.setColor(red);
            else if (color.equals(white))
                thread.setColor(white);
            else
                thread.setColor(blue);
            thread.setY(i);
            i++;
            getChildren().add(thread);
        }
    }
    
    /*
    Resets flag to an unordered state
    */
    public void reset()
    {
        threads = new Thread[NUM_THREADS];
        getChildren().clear();
        fillFlag();
    }
}
