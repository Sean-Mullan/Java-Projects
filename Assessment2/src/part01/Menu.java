package part01;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

/**Menu Class
 * @purpose To be able to initialise a menu to use for the Audio Application
 * @author seanm
 */
public class Menu 
{	
	private String items[]; //An array of options to select from the menu
	private String title; //The name of the menu
	private Scanner input = new Scanner(System.in); //The scanner to accept inputs, to select options
	
	/**Menu Constructor method
	 * @param a menu title(string), the menu options (string array)
	 * @author seanm
	 */
	public Menu(String title, String data[]) 
	{
		//Set the class variables equal to the input parameters, so that they can be modified in this class
		this.title = title;
		this.items = data;
	}
	
	/**Menu display method
	 * @purpose To display the Menu title and all of the options in numbered order
	 * @author seanm
	 */
	private void display() 
	{
		System.out.println(title);
		for(int count=0;count<title.length();count++) 
		{
			System.out.print("+"); //Add a line of + to separate the title and the options
		}
		System.out.println();
		for(int option=1; option<=items.length; option++) 
		{
			System.out.println(option + ". " + items[option-1] ); //Number and print each option for the user
		}
		System.out.println();
	}

	/**Menu getUserChoice method
	 * @purpose To allow the user to select one of the options displayed
	 * @author seanm
	 * @return the number of the option selected
	 */
	public int getUserChoice()
	{
		display(); //display all options
		int finalChoice = 0;
		System.out.print("Enter Selection: ");
		boolean answer = false; //Use boolean to verify that the input is valid
		while(answer != true)
		{
			try
			{
				int choice = Integer.parseInt(input.nextLine());
				if (choice >= 1 && choice < items.length+1)
				{
					finalChoice = choice;
					answer = true; //the input is valid, exit the loop
				}
				else
				{
					System.out.println("Invalid response, input again.");
					System.out.print("Enter Selection: ");
					finalChoice = input.nextInt();
				}
			
			}
			catch (Exception e) //catch out of range numbers or non int inputs
			{
				System.out.println("Invalid response, input again.");
				System.out.print("Enter Selection: ");
			}
		}
		return finalChoice;
	}

}