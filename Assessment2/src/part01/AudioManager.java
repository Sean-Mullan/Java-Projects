package part01;

import java.util.ArrayList;

import audio.AudioPlayer;

/**AudioManager Class
 * @purpose To be able to initialise an audio manager for use with the audio files and application
 * @author seanm
 */
public class AudioManager 
{
	private ArrayList<AudioFile> audioData = new ArrayList<>(); //list of AudioFile object references managed by an AudioManager instance 
	private AudioPlayer player; //reference to an AudioPlayer used by the AudioManager to play audio. 
	
	/**AudioManager Constructor method
	 * @param an AudioPlayer object
	 * @author seanm
	 */
	public AudioManager(AudioPlayer player) //single parameter – reference to a AudioPlayer object 
	{
		//Set the class variable equal to the input parameter, so that they can be modified in this class
		this.player = player;
	}
	
	/**AudioManager loadAudio method
	 * adds an AudioFile reference to audioData (no duplicates permitted) 
	 * @param The AudioFile to be added to the AudioManager
	 * @author seanm
	 */
	public void loadAudio(AudioFile file)  
	{
		if (file.getTitle() == "" || file.getDataSource() == "") //Verify that the input is not an empty string
		{
			System.out.println("Invalid input");
		}
		else
		{
			boolean isDupe = dupeCheck(file); //Use dupeCheck to make sure the dataSource is a unique one
			if (audioData == null || isDupe == true)
			{
				System.out.println("Invalid input");
			}
			else
			{
				audioData.add(file);
			}	
		}
		
	}
	
	/**AudioManager deleteAudio method
	 * removes an AudioFile reference from audioData
	 * @param The code of the AudioFile to be removed from the AudioManager
	 * @author seanm
	 */
	public void deleteAudio(int code)
	{
		code--;
		if(code < 0 || code > audioData.size()-1) //Check to see if the input is in the valid range
		{
			System.out.println("Invalid Input");
		}
		else
		{
			audioData.remove(code);
		}
	}
	
	/**AudioManager getAllData method
	 * returns an array of String references (one for each AudioFile in audioData), where each contains a comma-separated list of values (code, title, duration & data path).
	 * @param The array of Strings the data will be copied to
	 * @author seanm
	 * @return the array of Strings, with all of the Manager's File instances
	 */
	public String[] getAllData(String[] data)
	{
		data = new String[audioData.size()];
		for (int count = 0; count < audioData.size(); count++)
		{
			data[count] = audioData.get(count).toString();//Add each AudioFile instance in the arraylist to the array
		}
		return data;
	}
	
	/**AudioManager play(AudioFile) method
	 * will ‘play’ an AudioFile referenced by the parameter
	 * @param The AudioFile that will be "played"
	 * @author seanm
	 * @return a string to indicate success (“File XXX is playing”) or failure (“Couldn’t play file XXX”)
	 */
	public String play(AudioFile file)
	{
		AudioPlayer ply = new AudioPlayer(); //Initialise an audioplayer to play the file
		String sourceget = file.getDataSource();
		String str = player.playFile(sourceget); //run playFile, a method in the AudioPlayer class
		if (str == "OK")
		{
			file.registerPlay();//Increment playCount on success
			return String.format("Successfully played "+ file);
		}
		else
			return String.format("Couldn't play "+ file);
	}
	
	/**AudioManager play(int) method
	 * will ‘play’ an AudioFile referenced by the parameter
	 * @param The code of the AudioFile that will be "played"
	 * @author seanm
	 * @return a string to indicate success (“File XXX is playing”) or failure (“Couldn’t play file XXX”)
	 */
	public String play(int intplay) //Overloading play to accept the code of the AudioFile
	{
		String finalPlay = "";
		if(intplay >= 0 && intplay <= audioData.size()) //Verify that the code is in the valid range
		{
			AudioFile playfile = null;
			for (AudioFile dio : audioData)
				if(dio.getCode() == intplay)
				{
					playfile = dio;
				}
			finalPlay = this.play(playfile); //Play the AudioFile using the previous version of the play method
		}
		else
		{
			System.out.println("Invalid input- out of range");
		}
		return finalPlay;
	}
	
	/**AudioManager topTen method
	 * Lists the top ten AudioFile objects, in descending order of playCount
	 * @author seanm
	 * @return a String listing the ‘top ten’ AudioFile objects (code, name and playCount)
	 */
	public String topTen()
	{
		String ten = "Top Ten:\n";
		AudioFile[] temp = new AudioFile[audioData.size()];
		for (int i = 0; i < audioData.size(); i++)
		{
			temp[i] = audioData.get(i); //Copies the AudioFile object instances from an arraylist to an array
		}
		bubbleSort(temp); //Use bubble sort to sort values of playcount
		int size = temp.length;
		for(int index = 0; index < size; index++)
		{
			ten += temp[size-index-1].toString();//Prints the top ten playCounts
			ten += "\n";
		}
		return ten;
	}
	
	/**AudioManager setPlayer method
	 * 
	 * Assigns an AudioPlayer to be used with the AudioManager, it may be null to have none
	 * @param The AudioPlayer to instantiate
	 * @author seanm
	 */
	public void setPlayer(AudioPlayer play)
	{
		if(play != null) //Ensure the parameter is not null
		{
			System.out.println("Valid Player, It has been set");
			play = new AudioPlayer();
		}
		else
		{
			System.out.println("Invalid Player, It has not been set");
		}
	}
	
	/**AudioManager dupeCheck method
	 * Checks an AudioFile's dataSource, to make sure it is unique from the other files in the arraylist
	 * @param The AudioPlayer to instantiate
	 * @author seanm
	 * @return a boolean, true if the dataSource is a duplicate, false if not
	 */
	public boolean dupeCheck(AudioFile file)
	{
		String dsOne = file.getDataSource();
		AudioFile temp;
		String dsTwo;
		boolean isDupe = false;
		if (audioData != null) //Check to see if the arrayList is empty
		{
			for(int i = 0; i< audioData.size(); i++)
			{
				temp = audioData.get(i);
				dsTwo = temp.getDataSource();
			
				if(dsOne.equals(dsTwo)) //Does the dataSource of the parameter match any one in the list?
				{
					isDupe = true;
					break;
				}
				else
				{
					isDupe = false;
				}
			}
		}
		else 
		{
			isDupe = true;
		}
		return isDupe;
	}
	
	/**AudioManager bubbleSort method
	 * Sorts an array of AudioFiles in order of playCounts
	 * @param The AudioPlayer array to sort
	 * @author seanm
	 */
	private void bubbleSort(AudioFile[] array)
	{
		for (int i = 0; i < array.length-1; i++)
		{
			for (int j = 0; j < array.length-1-i; j++)
			{
				if(array[j].getPlayCount() > array[j+1].getPlayCount())
				{
					AudioFile temp = array[j]; //Swap the values around when they are out of order
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
