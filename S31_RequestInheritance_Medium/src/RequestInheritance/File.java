package RequestInheritance;

/**
 * This is the File Class.
 * @author Ram Sajja
 * @version 1.0, 10/10/2019
 */
public class File { //doesnt inherit from anything
    /**This is of type String to hold the filePath */
    private String  filePath;
    /**This is of type String to hold the filetype */
    private String filetype;

    /**
     * This a Two parameter constructor.
     * @param RandFilePath This is of type String, to hold the RandFilePath.
     * @param RandFileType This is of type String, to hold the file type.
     */
    public File(String RandFilePath,String RandFileType){ //just a helper class to hold the information.
        this.filePath = RandFilePath;
        this.filetype = RandFileType;
    }


}
