/*
Description
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Have you met this question in a real interview?  
Example
MovingAverage m = new MovingAverage(3);
m.next(1) = 1 // return 1.00000
m.next(10) = (1 + 10) / 2 // return 5.50000
m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
*/
public class MovingAverage {
    /*
    * @param size: An integer
   
    */
     double[] sum;
     int id, size;
    public MovingAverage(int size) {
        // do intialization if necessary
        sum = new double[size+1];
        id = 0;
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
     int mod(int x){
         return x % (size + 1);
     }
    public double next(int val) {
        // write your code here
        id++;
        sum[mod(id)] =  sum[mod(id-1)] + val;
        if(id > size) {
            return (sum[mod(id)] - sum[mod(id-size)]) / size;
        }
        else {
            return sum[mod(id)]/id;
        }
        
    }
}
