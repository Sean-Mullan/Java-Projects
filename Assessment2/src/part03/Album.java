package part03;

import javax.swing.ImageIcon;

/**Album Class
 * @purpose To be able to initialise an album to store AlbumTracks
 * @author seanm
 */
public class Album 
{
	private String title; //Album title
	private String artist; //Artist name
	private ImageIcon cover; //The image (.png) used for the album cover
	
	/**Album Constructor method
	 * @param an album title(string), the artist (string), the album cover (ImageIcon Object)
	 * @author seanm
	 */
	public Album(String title, String artist, ImageIcon cover)
	{
		//Set the class variables equal to the input parameters, so that they can be modified in this class
		this.title = title;
		this.artist = artist;
		this.cover = cover;
	}
	
	/**Album toString method
	 * @purpose To properly format an Album which has been initialised
	 * @author seanm
	 * @return formatted string including all details on an Album
	 */
	public String toString()
	{
		return "Title: "+this.title+", Artist: "+this.artist+", Cover: "+this.cover;
	}
	
	/**Album getTitle method
	 * @purpose To fetch the title of an Album when it is called by said Album instance
	 * @author seanm
	 * @return The title as a String
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**Album getArtist method
	 * @purpose To fetch the artist of an Album when it is called by said Album instance
	 * @author seanm
	 * @return The artist as a String
	 */
	public String getArtist()
	{
		return this.artist;
	}
	
	/**Album getCover method
	 * @purpose To fetch the cover of an Album when it is called by said Album instance
	 * @author seanm
	 * @return The cover as an ImageIcon
	 */
	public ImageIcon getCover()
	{
		return this.cover;
	}

}