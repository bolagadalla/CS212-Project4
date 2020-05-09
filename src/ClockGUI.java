import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 * This class contains everything that would be needed to show a window on the screen
 * This class extends from the JFrame Library so it would be able to inherit everything that is in JFrame
 * 
 * @author Bola Gadalla
 *
 */
public class ClockGUI extends JFrame
{
   // Text area for the unsorted array
   JTextArea unsortedClockText = new JTextArea();
   String unsortedText [];
   // Text area for the sorted array
   JTextArea sortedClockText = new JTextArea();
   Container myContent = new Container();
   
   /**
    * This is a constructor for the main window that would display both sorted and unsorted clocks
    * @param title - Title of the window
    * @param width - Width of the window
    * @param height - Height of the window
    */
   public ClockGUI(String title, int width, int height)
   {
      // Sets Properties of the Window
      setTitle(title);
      setSize(width, height);
      setLocation(400, 200);
      setLayout(new GridLayout(1, 2));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // Adds the JTextArea to the layout of the window
      add(unsortedClockText);
      add(sortedClockText);
      unsortedClockText.setEditable(false);
      sortedClockText.setEditable(false);
      // Create a file tap
      CreateFileMenu();
      // Sets the window visible
      setVisible(true);
   }
   
   /**
    * This is a constructor for the search result window that would display with information related to the search query
    * @param title - The title of the window
    * @param searches - The search text result that would be displayed in the window
    */
   public ClockGUI(String title, String searches)
   {
      // Creating a window with one text area
      TextArea searchedClocks = new TextArea();
      setTitle(title);
      setSize(300, 350);
      setLocation(600, 200);
      add(searchedClocks);
      searchedClocks.setText(searches);
      searchedClocks.setEditable(false);
      setVisible(true);
   }
   
   /**
    * Adds the strings into the text areas
    * 
    * @param unsorted - The unsorted array to be shown in the window
    * @param sorted - The sorted array to be shown in the window
    */
   public void ShowClockData(String unsorted, String sorted)
   {
      // Sets the text for the corresponding text area
      unsortedClockText.setText(unsorted);
      sortedClockText.setText(sorted);
      
      // Create a file tap
      CreateFileMenu();
      // Sets the window visible
      setVisible(true);
   }
   
   
   /**
    * Creates the File and Edit menu in the JFrame with two sub menus , Open and Quit for File, Search for Edit
    */
   private void CreateFileMenu() 
   {
      // Creates an item and a menu bar
      JMenuItem item;
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      
      // Creates a menu called File
      JMenu fileMenu = new JMenu("File");
      FileMenuHandler fmh = new FileMenuHandler(this);
      item = new JMenuItem("Open"); // Open sub menu option
      item.addActionListener(fmh);
      fileMenu.add(item);
      fileMenu.addSeparator(); 
      item = new JMenuItem("Quit"); // Quit sub menu option
      item.addActionListener(fmh);
      fileMenu.add(item);
      menuBar.add(fileMenu);
      
      // Creating a menu called Edit
      JMenu editMenu = new JMenu("Edit");
      EditMenuHandler emh = new EditMenuHandler(this);      
      item = new JMenuItem("Search");
      item.addActionListener(emh);
      editMenu.add(item);
      menuBar.add(editMenu);
   }
}
