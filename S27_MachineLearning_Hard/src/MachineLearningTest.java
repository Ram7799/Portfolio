import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for MachineLearning
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
class MachineLearningTest {
    /**
     * This is the first test case for Euclidean distance method in MachineLearning class.
     */
    @Test
    public void EuclideanDistanceTest1(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3};
        double [] b1 = {2,6,3};
        assertEquals(4.123105625617661,temp.EuclideanDistance(a1,b1));
    }

    /**
     * This is the second test case for Euclidean distance method in MachineLearning class.
     */
    @Test
    public void EuclideanDistanceTest2(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {3,4,5};
        double [] b1 = {2,6,3};
        assertEquals(3.0,temp.EuclideanDistance(a1,b1));
    }

    /**
     * This is the third test case for Euclidean distance method in MachineLearning class.
     */
    @Test
    public void EuclideanDistanceTest3(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1.5, 3.5, 2, 2, 8};
        double [] b1 = {1.32,2.56,6.78,9,7.86};
        assertEquals(8.5313539370958,temp.EuclideanDistance(a1,b1));
    }

    /**
     * This is the fourth test case for Euclidean distance method in MachineLearning class.
     */
    @Test
    public void EuclideanDistanceTest4(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3,4,5};
        double [] b1 = {1.32,2.56,6.78,9,7.86};
        assertEquals(6.919826587422549,temp.EuclideanDistance(a1,b1));
    }

    /**
     * This is the fifth test case for Euclidean distance method in MachineLearning class.
     */
    @Test
    public void EuclideanDistanceTest5(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3,4,5};
        double [] b1 = {9,0.3,5,7};
        assertEquals(-1.0,temp.EuclideanDistance(a1,b1));
    }

    /**
     * This is the first test case for Hamming distance method in MachineLearning class.
     */
    @Test
    public void HammingDistanceTest1(){
        MachineLearning temp = new MachineLearning();
        String one = "0110101";
        String two = "1110010";
        assertEquals(4,temp.HammingDistance(one,two));
    }

    /**
     * This is the second test case for Hamming distance method in MachineLearning class.
     */
    @Test
    public void HammingDistanceTest2(){
        MachineLearning temp = new MachineLearning();
        String one = "1101010";
        String two = "1110010";
        assertEquals(2,temp.HammingDistance(one,two));
    }

    /**
     * This is the third test case for Hamming distance method in MachineLearning class.
     */
    @Test
    public void HammingDistanceTest3(){
        MachineLearning temp = new MachineLearning();
        String one = "110101";
        String two = "1110010";
        assertEquals(-1,temp.HammingDistance(one,two));
    }

    /**
     * This is the fourth test case for Hamming distance method in MachineLearning class.
     */
    @Test
    public void HammingDistanceTest4(){
        MachineLearning temp = new MachineLearning();
        String one = "1111111";
        String two = "1110010";
        assertEquals(3,temp.HammingDistance(one,two));
    }

    /**
     * This is the fifth test case for Hamming distance method in MachineLearning class.
     */
    @Test
    public void HammingDistanceTest5(){
        MachineLearning temp = new MachineLearning();
        String one = "0000001";
        String two = "1110010";
        assertEquals(5,temp.HammingDistance(one,two));
    }

    /**
     * This is the first test case for Cosine Similarity method in MachineLearning class.
     */
    @Test
    public void CosineSimilarityTest1(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3};
        double [] b1 = {2,6,3};
        assertEquals(0.8781440805693944,temp.CosineSimilarity(a1,b1));
    }

    /**
     * This is the second test case for Cosine Similarity method in MachineLearning class.
     */
    @Test
    public void CosineSimilarityTest2(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {3,4,5};
        double [] b1 = {2,6,3};
        assertEquals(0.9091372900969896,temp.CosineSimilarity(a1,b1));
    }

    /**
     * This is the third test case for Cosine Similarity method in MachineLearning class.
     */
    @Test
    public void CosineSimilarityTest3(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1.5, 3.5, 2, 2, 8};
        double [] b1 = {1.32,2.56,6.78,9,7.86};
        assertEquals(0.8071765436968908,temp.CosineSimilarity(a1,b1));
    }

    /**
     * This is the fourth test case for Cosine Similarity method in MachineLearning class.
     */
    @Test
    public void CosineSimilarityTest4(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3,4,5};
        double [] b1 = {1.32,2.56,6.78,9,7.86};
        assertEquals(0.980567983656957,temp.CosineSimilarity(a1,b1));
    }

    /**
     * This is the fifth test case for Cosine Similarity method in MachineLearning class.
     */
    @Test
    public void CosineSimilarityTest5(){
        MachineLearning temp = new MachineLearning();
        double[] a1 = {1,2,3,4,5};
        double [] b1 = {9,0.3,5,7};
        assertEquals(-1.0,temp.CosineSimilarity(a1,b1));
    }
}