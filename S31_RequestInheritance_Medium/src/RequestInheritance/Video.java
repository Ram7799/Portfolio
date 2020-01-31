package RequestInheritance;

/**
 * This is a video class.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class Video {
    /** This variable holds the URL to the video*/
    private String URL;
    /** This variable holds the title of the video*/
    private String title;
    /** This variable holds the Name of the Video*/
    private String RandName;

    /**
     * This is three-parameter constructor.
     * @param RandUrl This is a string, which holds the URL.
     * @param Randtitle This is a String, which holds the Title of the video.
     * @param RandomName This is String which holds the Name of the person who made the Video.
     */
    public Video(String RandUrl,String Randtitle, String RandomName){
        this.URL = RandUrl;
        this.title=Randtitle;
        this.RandName = RandomName;
    }

    /**
     * A getter to get the URL
     * @return A string holding the URL.
     */

    public String getURL() {
        return URL;
    }

    /**
     * A getter to get the Title.
     * @return A string with the Title.
     */

    public String getTitle() {
        return title;
    }


    /**
     * A getter to get the Name
     * @return A string with the Name of the person who made the video.
     */
    public String getRandName() {
        return RandName;
    }


}
