package RequestInheritance;

import java.io.File;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
//

/**
 * This is DataGenerator class. this is used to create random data.
 */
class DataGenerator  {
    // fields to hold example data
    /** Used to create random elemets*/
    private Random rand;
    /** An array of strings consisting of names*/
    private String[] names;
    /** An array of strings consisting of encryption */
    private String[] encryption;
    /**An array of strings consisting of video titles. */
    private String[] videoTitles;
    /** An array of strings consisting of file paths*/
    private String[] filePaths;
    /** An array of strings consisting of File types*/
    private String[] fileTypes;
    /** An array of strings consisting of colors*/
    private String[] colors;

    // Constructor

    /**
     * No parameter constructor.
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    // private utilities for data generation

    /**
     * Used to create random name
     * @return An String
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * Used to create random color
     * @return An String
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * Used to create random video titles
     * @return An String
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * Used to create a random file type
     * @return An String
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * used to create Random file path
     * @return An String
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    // public data generation tools

    /**
     * Used to create random URL
     * @return An String
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * Used to create a Random payment
     * @return A Payment
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * Used to create random UUID
     * @return A UUID
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * Used to create random encryption scheme
     * @return An String
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * used to create a Random video
     * @return A Video
     */

    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * used to create a random File
     * @return A File
     */

    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * Used to create a Random Form
     * @return A Form
     */

    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * Used to create a Random IP
     * @return An String
     */


    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

}