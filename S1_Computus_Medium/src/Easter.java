import java.util.Scanner;

/**
 * This class is used to calculate the easter on a particular year
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */
public class Easter {
    /** This is the variable which holds the required year's easter.*/
    private int reqYear;

    /**
     * This is used to store all the months in the year
     */
    private String[] Months ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"} ;
    /**
     * This is used to store all the probable easter dates.
     */
    private String[] Dates = {"March 22","March 23","March 24","March 25","March 26","March 27","March 27","March 28","March 29","March 30","March 31","April 1","April 2","April 3","April 4","April 5"
            ,"April 6","April 7","April 8","April 9","April 10","April 11","April 12","April 13","April 14","April 15","April 16","April 17"
            ,"April 18","April 19","April 20","April 21","April 22","April 23","April 24","April 25"}; // easter can only come on certain days of the year


    /** This is just an empty constructor with no input parameters. used for my testing.*/
    public Easter(){

    }
    /** This is a constructor which takes in a required year and prints out the date of the easter.
     * @param year The year we have to find easter for
     */
    public Easter(int year){  //used to print out the info
        reqYear = year;
        int[] d =date(reqYear);
        print(d);
    }

    /**
     * This method is used to find the easter in the required year.
     * @param reqYear
     * @return int[], which consists of the month,date and year.
     */
    public int[] date(int reqYear){ //used to calculate the date for the asked year
        int a = reqYear%19;
        int b = reqYear/100;
        int c = reqYear%100;
        int d = b/4;
        int e =b%4;
        int f = (b + 8)/25;
        int g = (b-f+1)/3;
        int h = (19*a + b - d - g + 15) % 30;
        int i = c/4;
        int k = c%4;
        int l = (32 + 2*e + 2*i - h - k) % 7;
        int m = (a + 11*h + 22*l)/451;
        int month = (h + l- 7*m + 114)/ 31;
        int day = ((h + l - 7*m + 114)% 31) + 1;
        int[]ans = new int[3];
        ans[1]=day;
        ans[0]=month;
        ans[2]= reqYear;

        return ans;
    }

    /**
     * This method is used to print out the easter date in Month Day manner.
     * @param d, consisting an int array with month,date and year.
     */
    public  void print( int[] d){  //used to print out the value for the users input, and then for the next 5.7 million years.
        int month = d[0]-1;
        int date = d[1];
        int year = d[2];
        System.out.println("Easter Date:"+ ' ' +(Months[month] +' '+ date + ','+ year ));
        System.out.println(' ');
        System.out.println("Easter in the period of 5.7 million years (Medium) :");
        int[] pnt = getValue();
        for(int i = 0; i< Dates.length; i++){
            String str3 = Dates[i] + ' ' + pnt[i];
            System.out.println(str3);
        }
    }

    /**
     * This is used to find how many times easter falls on particular day in the next 5.7 million years.
     * @return it returns an int[] with my count for each date in the next 5.7 million years.
     */
    public  int[] getValue(){
        int[] str3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int i=1;i<5700000;i++){
            int[] first = date(i);
            int Date =first[1];
            int month = first[0]-1;
            String month1 = Months[month];
            String date = month1+' '+Date;
            for(int j =0;j< str3.length;j++){
                if(date.equals(Dates[j])){
                    str3[j]= str3[j]+1;
                }
            }
        }
       return str3;
        }
}
