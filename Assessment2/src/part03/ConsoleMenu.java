package part03;

import java.awt.Color;
import java.awt.Font;

import console.Console;

/**ConsoleMenu Class
 * @purpose To be able to initialise a menu to use for the Audio Application, printed using a console
 * @author seanm
 */
public class ConsoleMenu 
{
	private String items[]; //An array of options to select from the menu
	private String title; //The name of the menu
	private Console con = new Console(true); //The Console to display the menu
	
	/**ConsoleMenu Constructor method
	 * @param a menu title(string), the menu options (string array), the console to display (Console Object)
	 * @author seanm
	 */
	public ConsoleMenu(String title, String data[], Console con) 
	{
		//Set the class variables equal to the input parameters, so that they can be modified in this class
		this.title = title;
		this.items = data;
		this.con = con;
		//Set teh console's values
		this.con.setSize(1240, 440);
		this.con.setVisible(true);
		this.con.setFont(new Font("Courier", Font.BOLD, 20));
		this.con.setColour(Color.BLACK);
	}
	
	/**ConsoleMenu display method
	 * @purpose To display the Menu title and all of the options in numbered order
	 * @author seanm
	 */
	private void display() 
	{
		con.println(title);
		for(int count=0;count<title.length();count++) 
		{
			con.print("+"); //Add a line of + to separate the title and the options
		}
		con.println();
		for(int option=1; option<=items.length; option++) 
		{
			con.println(option + ". " + items[option-1] ); //Number and print each option for the user
		}
		con.println();
	}

	/**ConsoleMenu getUserChoice method
	 * @purpose To allow the user to select one of the options displayed
	 * @author seanm
	 * @return the number of the option selected
	 */
	public int getUserChoice()
	{
		display(); //display all options
		int finalChoice = 0;
		con.print("Enter Selection: ");
		boolean answer = false; //Use boolean to verify that the input is valid
		while(answer != true)
		{
			try
			{
				int choice = Integer.parseInt(con.readLn());
				if (choice >= 1 && choice < items.length+1)
				{
					finalChoice = choice;
					answer = true; //the input is valid, exit the loop
				}
				else
				{
					con.println("Invalid response, input again.");
					con.print("Enter Selection: ");
					finalChoice = Integer.parseInt(con.readLn());
				}
			
			}
			catch (Exception e) //catch out of range numbers or non int inputs
			{
				con.println("Invalid response, input again.");
				con.print("Enter Selection: ");
			}
		}
		return finalChoice;
	}
}
