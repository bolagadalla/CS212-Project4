
/**
 * This is a custom IllegalArgumentException that is thrown when the clock format is incorrect
 * 
 * @author Bola Gadalla
 *
 */
public class IllegalClockException extends IllegalArgumentException
{
   /**
    * Constructor 
    * @param clock - Clock object to be passed to print it's value
    */
   public IllegalClockException(Clock clock)
   {
      super(clock + " is not a valid Clock format!");
   }
}
