package part03;

import java.util.ArrayList;
import java.util.Scanner;

import audio.AudioPlayer;

/**QUBMedia Class
 * @purpose To run the methods with the objects created, as part of a single application
 * @author seanm
 */
public class QUBMedia 
{

	static Scanner input = new Scanner(System.in); // A Scanner for reading data from the keyboard
	static final int MAX = 4; // a constant value use to fix the size of the array defined below
	static AudioFile MyMusic[] = new AudioFile[MAX]; // an array of AudioFile object references
	static AudioPlayer play = new AudioPlayer(); //A player to run the AudioFiles for the manager
	static AudioManager Pear = new AudioManager(play); //The audioManager that will store and manipulate data
	static int count = 0; // defines the number of AudioFile object references managed within array 'myMusic'
			
	/**QUBMedia main method
	 * @purpose To select the options from the menu, and run the specific methods
	 * @author seanm
	 */
	public static void main(String[] args) 
	{
		//Create all options for the menu and run it
		String options[] = { "Display All Files", "Load Audio File", "Delete Audio File", "Play Audio File", "Display The Top 10", "Exit" };
		Menu myMenu = new Menu("Music Menu", options);
		boolean finished = false; //Will be true when the user chooses to exit the app
		do 
		{
			int option = myMenu.getUserChoice();
			switch (option) 
			{
				case 1: display(); //Display All Files: the user should be able to view summary details (code, title, duration, data path) of all audio files within audioData. 
				break;
				
				case 2: addFile(); //Load Audio File: the user should be able to create and add a new AudioFile to the AudioManager - can’t be added more than once. 
				break;
				
				case 3: deleteFile(); //Delete Audio: the user should be able to delete an AudioFile (identified by unique code) from audioData. 
				break;
				
				case 4: playFile(); //Play Audio File: the user should be able to select (by unique code) and play a specific AudioFile. 
				break;
				
				case 5: displayTop10(); //Display the Top 10: user should be able to view a list of the top 10 AudioFile titles sorted in order of number of plays.
				break;
					
				case 6: System.out.println("Goodbye!");
					finished = true; //Exit: the user should be able to exit the system. 
				break;
				
				default: System.out.println("Not a valid option.");
			}
		} 
		while (!finished);
	}
	
	/**QUBMedia display method
	 * @purpose To display all of the AudioFiles in AudioManager in numbered order, in the format of its toString
	 * @author seanm
	 */
	private static void display()
	{
		String[] list = {};
		String[] newList = Pear.getAllData(list); //Store all the data in an array
		System.out.println();
		if(newList.length <= 0) //Makes sure there are files in the array
		{
			System.out.println("There are no files present");
		}
		else
		{
			for (int i = 0; i < newList.length; i++)
			{
				System.out.println((i+1)+". " + newList[i]); //Prints with numbered code
				System.out.println();
			}
		}
		System.out.println();
	}
	
	/**QUBMedia addFile method
	 * @purpose To add (non duplicate) AudioFiles to the manager
	 * @author seanm
	 */
	private static void addFile()
	{
		boolean isValid = false;
		//ask for the name (can be String or Integer)
		System.out.print("Enter the Name: ");
		String name = input.nextLine().trim();
		// ask for duration (between 1 - 500)
		System.out.print("Duration: ");
		int duration = filterInt("Duration",1,500); //Use filterInt to make sure the input is valid
		// ask for data source (Must be string)
		System.out.print("Data Source (Physical Directory): ");
		String dataS = input.nextLine().trim();
		
		try
		{
			AudioFile temp = new AudioFile(name, duration, dataS);
			Pear.loadAudio(temp);
		}
		catch (Exception e) //Catch potential null values
		{
			System.out.println("File was not added");
		}
	}
	
	/**QUBMedia deleteFile method
	 * @purpose To delete AudioFiles from the manager by calling their code
	 * @author seanm
	 */
	private static void deleteFile()
	{
		display(); //Show all files in the manager
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		if(newList.length > 0) //Make sure there are files to delete
		{
			System.out.println("Enter the code of the file you wish to delete: ");
			int deletetemp = filterInt("Code", 1, newList.length); //Use filterInt to make sure the input is valid
			Pear.deleteAudio(deletetemp);
		}
		System.out.println();
	}
	
	/**QUBMedia playFile method
	 * @purpose To play AudioFiles from the manager by calling their code
	 * @author seanm
	 */
	private static void playFile()
	{
		display(); //Show all files in the manager
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		if(newList.length > 0) //Make sure there are files to play
		{
			System.out.println("Enter the code of the file you wish to play: ");
			int playtemp = filterInt("Code", 1, newList.length); //Use filterInt to make sure the input is valid
			String temp = Pear.play(playtemp);
			System.out.println(temp);
		}
		System.out.println();
	}
	
	/**QUBMedia displayTop10 method
	 * @purpose To display the ten AudioFiles with the highest playCounts, in descending order
	 * @author seanm
	 */
	private static void displayTop10()
	{
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		System.out.println();
		if(newList.length <= 0)//Make sure there are files to list
		{
			System.out.println("There are no files present");
		}
		else
		{
			String topTen = Pear.topTen();
			System.out.println(topTen);
		}
	}
	
	/**QUBMedia filterInt method
	 * @purpose To filter integer inputs, to ensure they are valid to prevent error
	 * @param The name of the integer value (string), the integer minimum (int) and maximum (int)
	 * @author seanm
	 * @returns A valid integer input
	 */
	private static int filterInt(String name, int min, int max)
	{
		int finalTemp = 0;
		boolean answer = false; //Boolean to verify if the value to be returned is valid
		while(answer != true)
		{
			try
			{
				int temp = Integer.parseInt(input.nextLine()); 
				if (temp >= min && temp <= max) //Makes sure the input is in range
				{
					finalTemp = temp;
					answer = true;
				}
				else
				{
					System.out.println(name+" must be between "+min+" and "+max);
					System.out.print(name+": ");
				}
			}
			catch (Exception e) //Make sure the input is an integer
			{
				System.out.println(name+" must be between "+min+" and "+max);
				System.out.print(name+": ");
			}
		}
		return finalTemp;
	}
}
