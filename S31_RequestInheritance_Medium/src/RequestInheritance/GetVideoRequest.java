package RequestInheritance;

import java.util.UUID;

/**
 * This is a GetVideoRequest which inherits from GetRequest
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class GetVideoRequest extends GetRequest { //this class inherits from Getrequest which inherits from request.
    /** This is an object of the Video to hold the RandomVideo*/
    private Video RandomVideo;
    /** A static variable to hold the number of calls*/
    private static int num7 =0;

    /**
     * This is a two parameter Constructor.
     * @param randUUID This is of type UUID, to hold the UUID.
     * @param randVideo This is of type Video, to hold the randVideo.
     */
    public GetVideoRequest(UUID randUUID, Video randVideo) {
        super(randUUID,randVideo.getURL()); // get request has a constructor with UUID and URL as its parameters
        this.RandomVideo = randVideo;
        num7++;
    }

    /**
     * This is used to access the variable which keeps track of number of calls
     * @return An int
     */
    public static int count(){return num7;}

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){ // get request tostring method can take care of UUID and URL; i had to add the required stuff.
        String retString = super.toString();
        return retString + "\n" + "Video: " + RandomVideo.getTitle()+"\n" + "By: " + RandomVideo.getRandName();
    }
}
