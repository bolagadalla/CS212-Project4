import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * This is a FileMenuHandler to handle what happens when a button on the menu is clicked
 * @author Bola Gadalla
 *
 */
public class FileMenuHandler implements ActionListener
{
   JFrame jframe;

   /**
    * Constructor
    * @param jf - The JFrame of the GUI
    */
   public FileMenuHandler(JFrame jf) 
   {
      jframe = jf; 
   }

   /**
    * In charge of what happens when either File , Open or File , Quit is clicked
    * @param event - This is the ActionEvent of the menu buttons
    */
   public void actionPerformed(ActionEvent event) 
   {
      // Stores the string of the button
      String menuName = event.getActionCommand();
      if (menuName.equals("Open"))
      {
         // Creates a JFileChoose object
         JFileChooser jfc = new JFileChooser();
         // Opens a open file window
         jfc.showOpenDialog(null);
         try
         {
            // Tries to read the file
            readSource(jfc.getSelectedFile());
         }
         catch (IOException e) // Catches any error
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      else if (menuName.equals("Quit")) // Quit the program when Quit is pressed
         System.exit(0);
   }
   
   /**
    * Reads the file and gets the path string and then Adds it to the lists
    * @param chosenFile - The file that is passed through the open window
    * @throws IOException - exception
    */
   private void readSource(File chosenFile) throws IOException
   {
      // Stores the file path as a string
      String chosenFileName = chosenFile.getAbsolutePath();
      // Opens and add the data from the file in that file path
      Project4.AddToLists(chosenFileName);
   }
}
