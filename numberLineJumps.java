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
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */
    public static boolean doesMatch(int x1, int v1, int x2, int v2){
        int i=1;
        int doesHit=0;
        while(x1+(i*v1)<=x2+(i*v2)){
            if(x1+(i*v1)==x2+(i*v2)){
                doesHit=1;
                break;
            }
            i++;
        }
        if(doesHit==1)
            return true;
        else
            return false;
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        String match="NO";
        if(v1>v2&&x1>x2)
            match="NO";
        else if(v2>v1 && x2>x1)
            match="NO";

        else if(v1>v2){
            if(doesMatch(x1, v1, x2, v2)){
                match="YES";
            }
        }
        else {
            if(doesMatch(x2, v2, x1, v1)){
                match="YES";
            }
        }
        return match;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
