import java.io.*;
import java.util.*;
import static java.lang.Double.*;

/**
 * The class used to implement several machine learning functions.
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class MachineLearning {
    /**
     * The method used to calculate the cosine similarity between two arrays.
     * @param a Its an array of double elements
     * @param b Its an array of double elements.
     * @return This method returns a double value; which is the cosine similarity between the two arrays.
     */
    public double CosineSimilarity(double[] a, double[] b){ //calculates the cosine similarity
        double num, den,den1;num=den=den1=  0;
        if(a.length!=b.length || a.length==0){ //input validation
            System.out.println("ERROR! they are not of the same length");
            return -1;
        }
        for(int i = 0; i< a.length;i++){  //calculating the value
            num += a[i] * b[i];
            den += (a[i]*a[i]) ;
            den1+= (b[i]*b[i]);
        }
        return num/(Math.sqrt(den) * Math.sqrt(den1));
    }

    /**
     * The method used to calculate the Hamming Distance of given two strings.
     * @param seq1 Its the first String.
     * @param seq2 Its the second String.
     * @return This method returns an integer; which is the Hamming distance of the two given two strings.
     */

    public int HammingDistance(String seq1, String seq2){ //to calculate the hamming distance
        int notEqual = 0;
        if(seq1.length() != seq2.length() || seq1.length()==0){ //input validation
            System.out.println("ERROR! They are not of the same length");
            return -1;
        }
        for(int i=0;i<seq1.length();i++){
            if(seq1.charAt(i)!= seq2.charAt(i)){
                notEqual +=1;
            }
        }
        return notEqual;
    }

    /**
     * The method used to calculate the Euclidean distance between the given two arrays.
     * @param a Its an array of double elements.
     * @param b Its an array of double elements.
     * @return This method return an double; which is the Euclidean distance between the arrays.
     */
    public double EuclideanDistance(double[] a, double[] b){ //calculates euclidean distance
        double s = 0;
        if(a.length!=b.length || a.length==0){ //input validation
            System.out.println("ERROR!");
            return -1;
        }
        for(int i =0;i<a.length;i++){
            s += Math.pow(a[i]-b[i],2);
        }
        return Math.sqrt(s);
    }

    /**
     * This method is used to implement the K-nearest neighbors algorithm (Supervised Learning).
     * @param filename This is the input file with Data points.
     * @param input The array we are comparing the Data points in the input file with.
     * @param kvalue The number of data points that are closest to; using the euclidean distance.
     * @throws IOException Throws exception if the file is not found
     */
    public void Knearest(String filename, double[] input, int kvalue) throws IOException {
        int count, OneCount, TwoCount; //used to keep tack of class values
        count = OneCount = TwoCount = 0;
        Vector<double[]> s = new Vector<>(); // pushing my information into vector of double array; consisting of the euclidean distance and class number.
        BufferedReader scanner = new BufferedReader(new FileReader(filename));
        String fileLine;
        while ((fileLine = scanner.readLine()) != null) { // as im reading the file; im calculating the euclidean distance with the data point and the array given.
            String[] Lineinput = fileLine.split(",", 6);
            Lineinput[5] = Lineinput[5].replace("\"", "");
            String[] newArr = new String[5];
            System.arraycopy(Lineinput, 0, newArr, 0, 5);
            double[] in = Arrays.stream(newArr).mapToDouble(Double::parseDouble).toArray();
            s.add(new double[]{EuclideanDistance(in, input), Lineinput[5].equals("class1") ? 1 : 2});
        }
        String[] temp = new String[s.size()]; //im converting from a vector to an array. to sort
        for (double[] i : s) {
            temp[count] = i[0] + "," + i[1];
            count++;
        }
        Arrays.sort(temp);
        for (int i = 0; i <= kvalue; i++) { //finding k closest values
            String[] spliLine = temp[i].split(",");
            if (parseDouble(spliLine[1]) == 1.0) OneCount += 1;
            else TwoCount += 1;
        }
        if (OneCount > TwoCount) System.out.println("New data point belongs to Class" + " " + 1); //making sure which has the higher count. class 1 or class2
        else if(OneCount == TwoCount){System.out.println("New data point belongs to Class" + " " + (int )(Math.random() * 2 + 1));}//this is just a tie breaker.
        else System.out.println("New data point belongs to Class" + " " + 2);
    }

    /**
     * This method is used to find the minimum distance value between the Data point and the Cluster values
     * @param a Its an Object of XandYValues which has the Data points.
     * @param b Its an Object of XandYValues which has the Cluster Points.
     * @return This method returns a double; which is the Euclidean distance between the data point and the Cluster point.
     */
    public double FindtheMin(XandYValues a,XandYValues b){
        return EuclideanDistance(new double[] {a.getX(),a.getY()},new double[] {b.getX(),b.getY()}); //used to find the distance between the given cluster point and the data point.
    }

    /**
     * This method implements the K-means clustering algorithm(Un-Supervised Learning)
     * @param filename This is the input file with Data points.
     * @param kvalue This is the no of Clusters to create.
     * @throws IOException This method throws an Exception if the file is not found.
     */
    public void kMeansClustering(String filename, int kvalue) throws IOException { //implements the Kmeans clustering
        Vector<XandYValues> Clusters = new Vector<>(kvalue); // to hold my cluster values
        Vector<XandYValues> DataINFO = new Vector<>(); // to hold the data points
        ArrayList<Double> XVals = new ArrayList<>(); //to store just the x values from the file
        ArrayList<Double> Yvals = new ArrayList<>(); //to store just the y values from the file
        BufferedReader scanner = new BufferedReader(new FileReader(filename));
        String fileLine;
        Random r = new Random(7);
        int count = 0;
        while ((fileLine = scanner.readLine()) != null) {
            String[] Lineinput = fileLine.split(",");
            XandYValues Value = new XandYValues(parseDouble(Lineinput[0]), parseDouble(Lineinput[1])); //calling my two parameter constructor.
            DataINFO.add(count, Value); //adding it to my vector holding the data points
            XVals.add(count, Double.valueOf(Lineinput[0])); //adding just the x values
            Yvals.add(count,Double.valueOf(Lineinput[1])); // adding just the y values
            count++; //used to keep track of total points
        }
        double MinX = Collections.min(XVals); // finding min and max for both x and y coordinates
        double MaxX = Collections.max(XVals);
        double MinY = Collections.min(Yvals);
        double MaxY = Collections.max(Yvals);
        for (int i = 0; i < kvalue; i++) { //using those values to create my random points.
            double randomValueX = MinX + (MaxX - MinX) * r.nextDouble();
            double randomValueY = MinY + (MaxY - MinY) * r.nextDouble();
            Clusters.add(i, (new XandYValues(randomValueX,randomValueY))); // adding to my vector holding the cluster values.
        }
        boolean stop = true;
        double avgX;
        double avgY ; //to keep track of the present avgx and avgy
        int count1;
        double oldX ; //to hold the old ones
        double oldY;
        while(stop) { //changes to fales when old and present one are same
            for(int i=0;i<DataINFO.size();i++){ // going through all the data points
                double min = FindtheMin(DataINFO.get(0),Clusters.get(0)); // finding the min using 0 and 0. as my base test cae
                for(int j=0;j<Clusters.size();j++){
                    if(min> FindtheMin(DataINFO.get(i),Clusters.get(j))){ // actually finding the min euclidean distance for that data point with all the cluster vlaues.
                        min = FindtheMin(DataINFO.get(i),Clusters.get(j));
                        DataINFO.get(i).setOwner_Cluster(j); // setting the data points owner the minimum values cluster number
                    }
                }
            }
            for (int i = 0; i < kvalue; i++) { // this is where im checking if old and present values are same
                oldX=Clusters.get(i).getX();
                oldY = Clusters.get(i).getY();
                avgX = 0;
                avgY = 0;
                count1 = 0;
                for (XandYValues a : DataINFO) {
                    if (i == a.getOwner_Cluster()) {
                        avgX += a.getX();
                        avgY += a.getY();
                        count1++;
                    }
                }
                Clusters.set(i, new XandYValues(avgX / count1, avgY / count1)); //changing the cluster values with the new avgx and avgy
                if(oldX==(avgX/count1)||oldY ==(avgY/count1) ){ // checking the condition to see if they are same
                    stop = false;
                }
            }
        }
        int ret; //printing out the cluster values
        for(int m =0;m<kvalue;m++){
            ret=0;
            for(XandYValues l : DataINFO){
                if(l.getOwner_Cluster() == m){
                    ret++;

                }
            }
            System.out.println("Cluster "+(m+1) + " : " + ret);
        }
    }

}

