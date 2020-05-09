/**
 * This is a custom object called Clock that would hold hours, minutes, and seconds in a clock format
 * This is the model of clock
 * 
 * @author Bola Gadalla
 *
 */
public class Clock
{
   private int hours;
   private int minutes;
   private int seconds;
   
   /**
    * This is the constructor of the class Clock which would take in the following parameters and storing them
    * 
    * @param hours - The hours part of the clock
    * @param minutes - The minutes part of the clock
    * @param seconds - The seconds part of the clock
    */
   public Clock(int hours, int minutes, int seconds) throws IllegalClockException
   {
      this.setHours(hours);
      this.setMinutes(minutes);
      this.setSeconds(seconds);
      if(hours > 23 || minutes > 59 || seconds > 59) throw new IllegalClockException(this); // Throws an IllegalException when the clock format is incorrect
   }

   /**
    * @return hours
    */
   public int getHours()
   {
      return hours;
   }

   /**
    * @param hours - The number of hours to set
    */
   public void setHours(int hours)
   {
      this.hours = hours;
   }

   /**
    * @return minutes
    */
   public int getMinutes()
   {
      return minutes;
   }

   /**
    * @param minutes - The amount of minutes to set
    */
   public void setMinutes(int minutes)
   {
      this.minutes = minutes;
   }

   /**
    * @return seconds
    */
   public int getSeconds()
   {
      return seconds;
   }

   /**
    * @param seconds - The amount of seconds to set
    */
   public void setSeconds(int seconds)
   {
      this.seconds = seconds;
   }
   
   /**
    * This is to help sort the array by the largest amount of seconds
    * @return The amount of seconds of the clock Object
    */
   public int TotalSeconds()
   {
      return (getHours() * 3600) + (getMinutes() * 60) + getSeconds();
   }
   
   /**
    * @return It returns the time in a clock format, e.g. hours:minutes:seconds
    */
   public String toString()
   {
      String time = "";
      time += hours < 10 ? "0" + hours + ":" : hours + ":";
      time += minutes < 10 ? "0" + minutes + ":" : minutes + ":";
      time += seconds < 10 ? "0" + seconds : seconds;
      
      return time;
   }
}
