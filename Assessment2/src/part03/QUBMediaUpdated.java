package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import audio.AudioPlayer;
import console.Console;

/**QUBMediaUpdated Class
 * @purpose To run the methods with the objects created, as part of a single application, using a console
 * @author seanm
 */
public class QUBMediaUpdated 
{
	
	static final int MAX = 4; // a constant value use to fix the size of the array defined below
	static AudioFile MyMusic[] = new AudioFile[MAX]; // an array of AudioFile object references
	static AudioPlayer play = new AudioPlayer(); //A player to run the AudioFiles for the manager
	static AudioManager Pear = new AudioManager(play); //The audioManager that will store and manipulate data
	static int count = 0; // defines the number of AudioFile object references managed within array 'myMusic'
	static Console con = new Console(true); //The console that will display the application
	static ArrayList<Album> data = new ArrayList<Album>(); //ArrayList of albums
	
	/**QUBMediaUpdated main method
	 * @purpose To select the options from the menu, and run the specific methods using a console
	 * @author seanm
	 */
	public static void main(String[] args) 
	{		
		//Create all options for the ConsoleMenu and run it
		String options[] = { "Display All Files", "Load Audio File or Album", "Delete Audio File", "Play Audio File", "Display The Top 10","Display All Albums","Search Album Contents", "Exit" };
		ConsoleMenu myMenu = new ConsoleMenu("Music Menu", options, con);
		boolean finished = false;//Will be true when the user chooses to exit the app
		do 
		{
			int option = myMenu.getUserChoice();
			switch (option) 
			{
				case 1: display(); //Display All Files: the user should be able to view summary details (code, title, duration, data path) of all audio files within audioData. 
				break;
				
				case 2: addFile(); //Load Audio File: the user should be able to create and add a new AudioFile or AudioTrack to the AudioManager - can’t be added more than once. They can also add Albums to data
				break;
				
				case 3: deleteFile(); //Delete Audio: the user should be able to delete an AudioFile (identified by unique code) from audioData. 
				break;
				
				case 4: playFile(); //Play Audio File: the user should be able to select (by unique code) and play a specific AudioFile. 
				break;
				
				case 5: displayTop10(); //Display the Top 10: user should be able to view a list of the top 10 AudioFile titles sorted in order of number of plays.
				break;
				
				case 6: listAlbums(); //List All Albums: user should be able to view summary details (name, artist, cover) of all albums within QUBMedia. 
				break;
				
				case 7: searchAlbums(); //Search Album Contents:  user should be able to pick one album from a list, then view every song added to that album
				break;
				
				case 8: con.println("Goodbye!");
					finished = true; //Exit: the user should be able to exit the system. 
				break;
				
				default: con.println("Not a valid option.");
			}
		} 
		while (!finished);
	}
	
	/**QUBMediaUpdated display method
	 * @purpose To display all of the AudioFiles in AudioManager in numbered order, in the format of its toString
	 * @author seanm
	 */
	private static void display()
	{
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		con.println();
		if(newList.length <= 0)//Makes sure there are files in the array
		{
			con.println("There are no files present");
		}
		else
		{
			for (int i = 0; i < newList.length; i++)
			{
				con.println((i+1)+". " + newList[i]);//Prints with numbered code
				con.println();
			}
		}
		con.println();
	}
	
	/**QUBMediaUpdated addFile method
	 * @purpose To add (non duplicate) AudioFiles and AudioTracks to the manager, or Album to the data arrayList
	 * @author seanm
	 */
	private static void addFile()
	{
		boolean isValid = false;
		con.print("Are you adding A: An AudioFile or B: An Album? "); //check if making an album or AudioFile
		String answer = con.readLn().trim().toUpperCase(); //Filter string so that it is accepted easier
		switch(answer)
		{
			case "A": con.println("AudioFile");
			// ask for the name (must not be an empty string)
			con.print("Enter the Name: ");
			String name = con.readLn().trim();
			// ask for duration (between 1 - 500)
			con.print("Duration: ");
			int duration = filterInt("Duration",1,500);
			// ask for data source (Must not be the same as another file
			con.print("Data Source (Physical Directory): ");
			String dataS = con.readLn().trim();
			addAlbumTrack(name, duration, dataS); //Check to see if the file will be added to an album
			break;
			
			case "B": con.println("Album");
			addAlbum(); //Method to add an album to data
			break;
			
			default: con.println("Not a valid option.");
		}
	}
	
	/**QUBMediaUpdated deleteFile method
	 * @purpose To delete AudioFiles and AudioTracks from the manager
	 * @author seanm
	 */
	private static void deleteFile()
	{
		display(); //Show all files in the manager
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		if(newList.length > 0)//Makes sure there are files in the array
		{
			con.println("Enter the code of the file you wish to delete: ");
			int deletetemp = filterInt("Code", 1, newList.length); //Use filterInt to make sure the input is valid
			Pear.deleteAudio(deletetemp);
		}
		con.println();
	}
	
	/**QUBMediaUpdated playFile method
	 * @purpose To play AudioFiles and AudioTracks from the manager
	 * @author seanm
	 */
	private static void playFile()
	{
		display(); //Show all files in the manager
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		if(newList.length > 0)//Makes sure there are files in the array
		{
			con.println("Enter the code of the file you wish to play: ");
			int playtemp = filterInt("Code", 1, newList.length); //Use filterInt to make sure the input is valid
			String temp = Pear.play(playtemp);
			con.println(temp);
		}
		con.println();
	}
	
	/**QUBMediaUpdated playFile method
	 * @purpose To display the ten AudioFiles and AudioTracks with the highest playCounts, in descending order
	 * @author seanm
	 */
	private static void displayTop10()
	{
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		con.println();
		if(newList.length <= 0)//Makes sure there are files in the array
		{
			con.println("There are no files present");
		}
		else
		{
			String topTen = Pear.topTen();
			con.println(topTen);
		}
	}
	
	/**QUBMediaUpdated filterInt method
	 * @purpose To filter integer inputs, to ensure they are valid to prevent error
	 * @param The name of the integer value (string), the integer minimum (int) and maximum (int)
	 * @author seanm
	 * @returns A valid integer input
	 */
	private static int filterInt(String name, int min, int max)
	{
		int finalTemp = 0;
		boolean answer = false;//Boolean to verify if the value to be returned is valid
		while(answer != true)
		{
			try
			{
				int temp = Integer.parseInt(con.readLn());
				if (temp >= min && temp <= max) //Makes sure the input is in range
				{
					finalTemp = temp;
					answer = true;
				}
				else
				{
					con.println(name+" must be between "+min+" and "+max);
					con.print(name+": ");
				}
			}
			catch (Exception e) //Make sure the input is an integer
			{
				con.println(name+" must be between "+min+" and "+max);
				con.print(name+": ");
			}
		}
		return finalTemp;
	}
	
	/**QUBMediaUpdated listAlbums method
	 * @purpose To display all of the Albums added to the data arrayList
	 * @author seanm
	 */
	private static void listAlbums()
	{
		if(data.size() <= 0)//Makes sure there are files in the arrayList
		{
			con.println("There are no albums present");
		}
		else
		{
			for (int i = 0; i < data.size(); i++)
			{
				con.println((i+1)+". " + data.get(i)); //Prints with numbered code
				con.println(data.get(i).getCover()); //Prints Album Cover
				con.println();
			}
		}
		con.println();
	}
	
	/**QUBMediaUpdated listAlbums method
	 * @purpose To add Albums to the data arrayList
	 * @author seanm
	 */
	private static void addAlbum()
	{
		// ask for the name (must not be an empty string)
		con.print("Enter the Name: ");
		String albumName = con.readLn().trim();
		// ask for the artist (must not be an empty string)
		con.print("Enter the Artist: ");
		String artist = con.readLn().trim();
		// ask for the data source for an image (must not be an empty string)
		con.print("Enter the data source for an Album Cover: ");
		String albumDS = con.readLn().trim();
		ImageIcon cover = new ImageIcon(albumDS.toUpperCase());
		try
		{
			Album alTemp = new Album(albumName, artist, cover);
			data.add(alTemp);
		}
		catch (Exception e) //Catch potential null values
		{
			con.println("Album was not added");
		}
	}
	
	/**QUBMediaUpdated addAlbumTrack method
	 * @purpose To add AlbumTracks to the Manager
	 * @param Track's name (string), duration (int), dataSource (string)
	 * @author seanm
	 */
	private static void addAlbumTrack(String name, int duration, String dataS)
	{
		if(data.size() > 0) //Makes sure that the arraylist is not empty
		{
			con.print("Is this file in an album? "); //Check wether the file is in an album
			String whichTrack = con.readLn().trim().toUpperCase();
			switch(whichTrack)
			{
				case "YES":
				//display all albums, add to one, that album becomes record for audioTrack
				listAlbums();
				con.println("Enter the code of the album to add this file to: ");
				int addAlbumTemp = filterInt("Code", 1, data.size()); //Use filterInt to make sure the input is valid
				AlbumTrack atTemp = new AlbumTrack(name, duration, dataS, data.get(addAlbumTemp-1));
				//add AlbumTrack to pear
				Pear.loadAudio(atTemp);
				break;
				
				case "NO": try //Add as a regular AudioFile
				{
					AudioFile afTemp = new AudioFile(name, duration, dataS);
					Pear.loadAudio(afTemp);
				}
				catch (Exception e) //Catch potential null values
				{
					con.println("File was not added");
				}
			}
		}
		else
		{
			con.println("No albums to add to, creating AudioFile."); //No albums means nowhere to add AudioTracks
			try
			{
				AudioFile afTemp = new AudioFile(name, duration, dataS);
				Pear.loadAudio(afTemp);
			}
			catch (Exception e) //Catch potential null values
			{
				con.println("File was not added");
			}
		}
	}
	
	/**QUBMediaUpdated searchAlbums method
	 * @purpose To add AlbumTracks to the Manager
	 * @author seanm
	 */
	public static void searchAlbums()
	{
		listAlbums(); //List all Albums
		int size = data.size();
		String[] list = {};
		String[] newList = Pear.getAllData(list);//Store all the data in an array
		con.println();
		con.print("Enter the code of the album you wish to view: ");
		int searchChoice = filterInt("Code", 1, data.size()); //Use filterInt to make sure the input is valid
		String albumName = data.get(searchChoice-1).getTitle(); //fetch the album name to search
		String[] splitList = new String[5];
		for (int i = 0; i < newList.length; i++)
		{
			String splitter = newList[i];
			splitList = splitter.split(","); //Split the toString into an array of values
		}
		if(size == 1)
		{
			if(albumName.equals(splitList[5])) //Point 5 in the array will hold the name of the album
			{
				for(int arrayI = 0; arrayI < splitList.length; arrayI++)
				{
					con.print(splitList[arrayI]+", "); //List all values with the same album as the one searched
				}
			}
		}
		else
		{
			for (int index = 0; index < data.size()-1; index++) //look through every value for it's album name
			{
				if(albumName.equals(splitList[5]))
				{
					for(int arrayI = 0; arrayI < splitList.length; arrayI++)
					{
						con.print(splitList[arrayI]+", "); //List all values with the same album as the one searched
					}
				}
			}
		}
		con.println();
	}
	
}
