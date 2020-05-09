import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * This class is in charge of reading a .txt file and creating a Clock object out of the content of the file
 * Then adding those objects as nodes into two lists, UnsortedClockList and SortedClockList which both inherets from a super class called ClockList
 * Then creating a GUI to represent both the sorted and unsorted lists
 * 
 * @author Bola Gadalla
 *
 */
public class Project4
{
   // A global StringToneizer
   public static StringTokenizer myTokens;
   private static ClockGUI clockGUI;
   private static TreeMap <String, Integer> clockTree = new TreeMap<>();
   
   public static void main(String[] args) throws IOException
   {
      // Creates a new ClockGUI object
      clockGUI = new ClockGUI("Project 4 - Clock Times TreeMap", 400, 400);
   }

   /**
    * This opens the file name myFile and reads the content of it and tokanize it and store it into a clock object
    * which then is added to the an unsortedText String and is added to a Clock Tree with the clock object as the key and the value is the hour which is used later on.
    * 
    * @param myFile - The file name to open, PLEASE ENTER FILE NAME IN THE CONCOLE, INCLUDE .txt
    * @throws IOException - Throws an exception if there was no file
    */
   public static void AddToLists(String myFile) throws IOException
   {
      String unsortedText = "";
      String sortedText = "";
            
      // Creates a BufferedReader object
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(myFile)));
      String line = br.readLine();
      while(line != null)
      {
         try // Tries the code and catches an error
         {
            myTokens = new StringTokenizer(line, ":");
            if (myTokens.countTokens() > 2)
            {
               int hour = Integer.parseInt(myTokens.nextToken());
               // Create a Clock object with parameters being the tokens
               Clock clock = new Clock(hour, Integer.parseInt(myTokens.nextToken()), Integer.parseInt(myTokens.nextToken()));
               
               // APPEND INTO THE UNSORTED TEXTAREA by adding it into this string and pass it later to the GUI
               unsortedText += clock.toString() + "\n";
               
               // ADD IT TO THE TREEMAP
               clockTree.put(clock.toString(), hour);
               
               line = br.readLine();
            }
            else
            {
               System.out.println(line);
               line = br.readLine();
            }
         }
         catch (Exception e) // Print out any exception and skip the line without adding it
         {
            System.out.println(e);
            line = br.readLine();
         }
      }
      br.close();
      
      // This sorts the TreeMap based on the key value
      Set set = clockTree.entrySet();
      Iterator i = set.iterator();
      
      Map.Entry<String, Integer> clockMap;
      while(i.hasNext())
      {
         clockMap = (Map.Entry)i.next();
         // Adds the sorted text into a string value which is passed on later
         sortedText += clockMap.getKey() + "\n"; 
      }
      // Showing a window with the data in it
      clockGUI.ShowClockData(unsortedText, sortedText);
   }
   
   /**
    * This is used to search for clocks with hours less then or equal to the parameter value
    * 
    * This goes through the TreeMap and sort it.
    * At the same time it adds the clock with less or equal value to the parameter value into a string variable.
    * The string variable is passed through the clockGUI second constructor as a parameter to be used in the newly created window
    * @param hour - The hour parameter which is used to search for clocks with less or equal hour value
    */
   public static void ClocksLessThen(int hour)
   {
      // Hour text which is used as the result for the search
      String hoursText = "";
      
      // Sort the map
      Set set = clockTree.entrySet();
      Iterator i = set.iterator();
      
      Map.Entry<String, Integer> clockMap;
      while(i.hasNext())
      {
         clockMap = (Map.Entry)i.next();
         // Adding any clocks with hour equal or less then the given parameter. All others are ignored by just adding an empty string which is nothing.
         // Syntax short for, if clockMap valye is less or equal to hour then add the clockMap key into the string hoursText, otherwise add empty strings.
         hoursText += clockMap.getValue() <= hour ? clockMap.getKey() + "\n" : "";
      }
      // Creates a new window
      clockGUI = new ClockGUI("Search Results", hoursText);
   }
}
