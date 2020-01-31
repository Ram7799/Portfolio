import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test class for my Easter
 * @author Ram Sajja
 * @version 1.0,10/11/2019
 */

class EasterTest {
    /**
     * Im testing for 20 years.
     * https://en.wikipedia.org/wiki/List_of_dates_for_Easter
     * I got the dates from the above source
     */
    @Test
    public void ComputusTest1(){
        boolean ret = true;
        Easter temp = new Easter();
        int[] num;
        int[] years = {1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019};
        String[] str ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"} ;
        String[] Dates = {"April 4","April 23","April 15","March 31","April 20","April 11","March 27","April 16","April 8","March 23","April 12","April 4","April 24","April 8","March 31","April 20","April 5","March 27","April 16","April 1","April 21"};
        for(int i=0;i<years.length;i++){
            num =temp.date(years[i]);
            num[0] -=1;
            String check = str[num[0]]+" " +num[1];
            System.out.println(check + ", " +years[i] );
            if(!check.equals(Dates[i])){
                System.out.println("They are not equal");
                ret=false;
            }
        }
        assertTrue(ret);
    }

}