import java.io.File;
import java.io.IOException;

/**
 * this is a driver class for MachineLearning
 * @author Ram Sajja
 * @version 10/11/2019
 */
public class MachineLearningDriver {
    /**
     * Its used to print out the Cluster values and test cases given in the assignment
     * @param args Arguments to the Main method.
     * @throws IOException Throws an exception if the file is not found.
     */
    public static void main(String[] args) throws IOException {
        MachineLearning a = new MachineLearning();
        double[] a1 =  {1,2,3};
        double [] b1 = {2,6,3};
        double [] b2 = {1.5, 3.5, 2, 2, 8} ;
        double [] b4 = {3, 3, 2, 2, 1};
        String one =  "0110101";
        String two =  "1110010";
        System.out.println("Cosine similarity given in the assignment: " + a.CosineSimilarity(a1,b1));
        System.out.println("Hamming distance example given in the assignment: " + a.HammingDistance(one,two));
        System.out.println("Euclidean distance example given in the assignment: " + a.EuclideanDistance(a1,b1));
        a.Knearest("oral_exam1"+ File.separator +"S27_MachineLearning_Hard"+ File.separator +"S27-MLMedium.csv",b2,3);
        a.Knearest("oral_exam1"+File.separator+"S27_MachineLearning_Hard"+File.separator+"S27-MLMedium.csv",b4,5);
        a.kMeansClustering("oral_exam1"+File.separator+"S27_MachineLearning_Hard"+File.separator+"S27-MLHard.csv",4);
    }
}
