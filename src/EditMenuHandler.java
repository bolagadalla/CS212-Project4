import javax.swing.*;
import java.awt.event.*;

public class EditMenuHandler implements ActionListener 
{
   JFrame jframe;

   /**
    * Constructor to set the JFrame to add the menu to
    * @param jf - The frame to use to add the Edit menu button to.
    */
   public EditMenuHandler(JFrame jf) 
   {
      jframe = jf;
   }

   /**
    * Responsible for adding actions to the Search submenu of Edit
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();

      // If the menu clicked is Search then we present an input dialog
      if (menuName.equals("Search"))
      {
         String inputText = JOptionPane.showInputDialog("Enter an hour for a clock:");
         try // for catching if the inputText is not a number
         {
            int inputNumber = Integer.parseInt(inputText);
            if (inputNumber >= 0 && inputNumber < 24)
            {
               Project4.ClocksLessThen(inputNumber);
            }
            else JOptionPane.showMessageDialog(null, "Please enter a valid hour between 0 and 23");
         }
         catch (NumberFormatException e) // Catches any input that is not a number
         {
            if(inputText.isEmpty()) return; // Its so that if the inputText is empty and no input was in it, then do nothing
            JOptionPane.showMessageDialog(null, "Please enter an hour as a number!"); // Shows a popup
         }
      }
   }
}