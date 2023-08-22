import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */public static int min(List<Integer> a){
         int min =a.get(0);
         for(int i=0; i<a.size(); i++){
             if(a.get(i)<min){
                 min=a.get(i);
             }
         }
         return min;
     }
     public static int max(List<Integer> a){
         int max =a.get(0);
         for(int i=0; i<a.size(); i++){
             if(a.get(i)>max){
                 max=a.get(i);
             }
         }
         return max;
     }
     
     public static boolean isFactors(List<Integer> a, int b){
         boolean check=true;
         for(int i=0; i<a.size(); i++){
             if(b%a.get(i)!=0){
                 check=false;
                 break;
             }
         }
         return check;
     }
     public static boolean isFactor(List<Integer> a, int b){
         boolean check= true;
         for(int i=0; i<a.size(); i++){
             if(a.get(i)%b!=0){
                 check=false;
                 break;
             }
         }
         return check;
     }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
           int i=1;
           int count=0;
           while(i<=min(b)){
               if(isFactors(a,i)&& isFactor(b,i)){
                   count++;
               }
               i++;
           }
           return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
