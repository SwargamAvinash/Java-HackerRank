import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            // Need to Print in single line..
            int start = a;
            for (int j=0; j < n;j++){
                start += Math.pow(2, j) * b;
                System.out.print(start + " ");                
            }
            
            System.out.println("");
        }
        in.close();
    }
}
