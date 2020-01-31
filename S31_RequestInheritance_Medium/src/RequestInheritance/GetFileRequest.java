package RequestInheritance;

import java.io.File;
import java.util.UUID;

/**
 * This is GetFileRequest class inheriting from GetRequest.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class GetFileRequest extends GetRequest { //inherits from GetRequest and it inherits from Request
    /**This is used to hold the File. */
    private File RandomFile;
    /** This is used to keep track of number of calls*/
    private static int num6 =0;

    /**
     * This is a two parameter constructor.
     * @param randUUID This is of type UUID, to hold the UUID.
     * @param randFile This is of type File, to hold the File.
     */
    public GetFileRequest(UUID randUUID, File randFile) {
        super(randUUID,randFile.getPath()); //super can take care of my UUID and the url.
        this.RandomFile = randFile;
        num6++;
    }


    /**
     * This is used to access the static variable which keeps track of the number of calls.
     * @return An integer.
     */
    public static int count(){return num6;}

    /**
     * Overriding the toString from the super class
     * @return A string in the defined manner.
     */
    @Override
    public String toString(){ // super has a toString which has the URL and UUID
        String retString = super.toString()+ "\n" + "File Path: " + RandomFile.getPath() + "\n" + "File Type: " + RandomFile.getName();
        return retString;
    }
}
