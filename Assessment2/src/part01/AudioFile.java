package part01;

/**AudioFile Class
 * @purpose To be able to initialise audio files for use with the audio manager
 * @author seanm
 */
public class AudioFile 
{
	private int code; //a unique code identifier
	private static int nextCode = 1; //next usable AudioFIle identifier
	private String title; //AudioFile title
	private int duration; //duration (in seconds) of the AudioFile
	private String dataSource; //physical directory (path & filename) of associated audio data
	private int playCount; //a count of the number of times the AudioFile has been played
	private static final int MAX_TIME = 999; //Max number of seconds a song can be on this system
	
	/**AudioFile Constructor method
	 * @param a file title(string), the duration(int), and the source of the file on your device(string)
	 * @author seanm
	 */
	public AudioFile(String title, int duration, String dataSource)
	{
		//Set the class variables equal to the input parameters, so that they can be modified in this class
		this.title = title;
		this.duration = duration;
		this.dataSource = dataSource;
		this.code = nextCode; //make the code equal to nextCode, so we have an automatic incremental code 
		nextCode++; //increments nextCode, so that the next file created has an code of 1 greater
	}
	
	/**AudioFile toString method
	 * @purpose To properly format an AudioFile which has been initialised
	 * @author seanm
	 * @return formatted string including all details on an AudioFile
	 */
	public String toString()
	{
		return "ID: "+this.code+", Title: "+this.title+", Duration: "+this.duration+", Data Source: "+this.dataSource+", Times Played: "+playCount;
	}
	
	/**AudioFile registerPlay method
	 * @purpose To increment playCount after a file has been played
	 * @author seanm
	 * @return None, void
	 */
	public void registerPlay()
	{
		this.playCount++;
	}
	
	/**AudioFile getTitle method
	 * @purpose To fetch the title of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @return The title as a String
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**AudioFile getDuration method
	 * @purpose To fetch the duration of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @return The duration as an int
	 */
	public int getDuration()
	{
		return this.duration;
	}
	
	/**AudioFile getDataSource method
	 * @purpose To fetch the dataSource of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @return The dataSource as a String
	 */
	public String getDataSource()
	{
		return this.dataSource;
	}
	
	/**AudioFile getPlayCount method
	 * @purpose To fetch the playCount of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @return The playCount as an int
	 */
	public int getPlayCount()
	{
		return this.playCount;
	}
	
	/**AudioFile getCode method
	 * @purpose To fetch the code of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @return The code as an int
	 */
	public int getCode()
	{
		return this.code;
	}
	
	/**AudioFile setTitle method
	 * @purpose To set a new value to the title of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @param The value to change the title to, as a string
	 * @return a true or false boolean, to confirm if the value has been successfully set
	 */
	public boolean setTitle(String title) 
	{
		if (checkString(title)) //Uses checkString to verify if the input is valid
		{
			this.title = title;
			this.title = this.title.trim();//trims the title to remove spaces
			return true; //The input is valid
		}
		return false; //The input is invalid
	}
	
	/**AudioFile setDuration method
	 * @purpose To set a new value to the duration of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @param The value to change the duration to, as an int
	 * @return a true or false boolean, to confirm if the value has been successfully set
	 */
	public boolean setDuration(int dur) 
	{
		// will only accept values >= 20000
		if (dur <= MAX_TIME && dur >= 0) //compare with MAX_TIME and 0 to verify if the value is valid
		{
			this.duration = dur;
			return true; //The input is valid
		}
		return false; //The input is invalid
	}
	
	/**AudioFile setDuration method
	 * @purpose To set a new value to the dataSource of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @param The value to change the dataSource to, as a string
	 * @return a true or false boolean, to confirm if the value has been successfully set
	 */
	public boolean setDataSource(String DS) 
	{
		if (checkString(DS)) //Uses checkString to verify if the input is valid
		{
			this.dataSource = DS;
			this.dataSource = this.dataSource.trim(); //trims the title to remove spaces
			return true; //The input is valid
		}
		return false; //The input is invalid
	}
	
	/**AudioFile checkString method
	 * @purpose To verify if the string input is valid, so that it can be used for other methods without error
	 * @author seanm
	 * @param The string to check
	 * @return a true or false boolean, to confirm if the value is valid
	 */
	private boolean checkString(String str) 
	{
		// will only accept non-null/non-empty strings
		if (str != null) {
			// trim() results in a String with leading/trailing 'white-space' chars removed
			str = str.trim();
			if (str.length() != 0) 
			{
				return true; //The input is valid
			}
		}
		return false; //The input is invalid
	}
	
	/**AudioFile setPlayCount method
	 * @purpose To set a new value to the playCount of an AudioFile when it is called by said AudioFile instance
	 * @author seanm
	 * @param The value to change the playCount to, as an int
	 * @return a true or false boolean, to confirm if the value has been successfully set
	 */
	public boolean setPlayCount(int pc) 
	{
		// will only accept values >= 0
		if (pc >= 0) //compare with 0 to verify if the value is valid
		{
			this.playCount = pc;
			return true; //The input is valid
		}
		return false; //The input is invalid
	}
}
