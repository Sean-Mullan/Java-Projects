package part03;

/**AlbumTrack SubClass
 * @purpose To be able to initialise an AudioFile that can be added to an album
 * @author seanm
 */
public class AlbumTrack extends AudioFile
{
	private Album record; //The album the AlbumTrack belongs to
	
	/**AlbumTrack Constructor method
	 * @param a track title(string), the duration (int), the dataSource (string), the track's album (Album Object)
	 * @author seanm
	 */
	public AlbumTrack(String title, int duration, String dataSource, Album record)
	{
		super(title, duration, dataSource); //The first three parameters are taken directly from the AudioFile parent class
		this.record = record;
	}
	
	/**AlbumTrack toString method
	 * @purpose To properly format an AlbumTrack which has been initialised
	 * @author seanm
	 * @return formatted string including all details on an AlbumTrack
	 */
	public String toString()
	{
		return super.getCode()+","+super.getTitle()+","+super.getDuration()+","+super.getDataSource()+","+super.getPlayCount()+","+this.record.getTitle();
	}
}
