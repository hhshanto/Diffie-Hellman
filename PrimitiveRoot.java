package network.security;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Hasibul Hasan Shanto
 */
public class PrimitiveRoot {

    private int n, i, j;
    private int count = 0;
    private int PRoot[];

    PrimitiveRoot(int p) {
        BigInteger pr = BigInteger.valueOf(p);
        int arr[] = new int[p];
        PRoot = new int[p];
        for (i = 1; i < p; i++) {
            for (j = 0; j < p - 1; j++) {
                BigInteger b1 = BigInteger.valueOf(i);
                BigInteger res = b1.pow(j);
                res = res.mod(pr);
                //System.out.print(res + " ");
                arr[j] = res.intValue();
            }
            int chk = PrimitiveRootCheck(arr);
            if (chk == 0) {
                //System.out.println("Not Primitive");
            } else {
                //System.out.println("Primitive Root");
                PRoot[count] = i;
                count++;
                
            }

        }
//        System.out.print("\n\nPrimitive Roots are: ");
//        for (i = 0; i < count; i++) {
//            System.out.print(PRoot[i] + " ");
//        }
//        System.out.println("\n");
    }

    public int getPrimitive() {
        
        Random r = new Random();
       int x =  r.nextInt((count - 1) + 1) + 1;
       
        return PRoot[x];
    }

    private int PrimitiveRootCheck(int[] arr) {
        int i, j;
        int check = 1;
        for (i = 1; i < arr.length; i++) {
            for (j = 1; j < arr.length; j++) {
                if (arr[i] == (arr[j]) && i != j) {
                    check = 0;
                    return check;
                }
            }
        }
        return check;

    }
    public void PrimitiveShow()
    {
        System.out.print("\n\nPrimitive Roots are: ");
        for (i = 0; i < count; i++) {
            System.out.print(PRoot[i] + " ");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter the prime number: ");
            Scanner input = new Scanner(System.in);
            int prime = input.nextInt();
            boolean flag = false;
            for (int i = 2; i <= prime / 2; ++i) {
                if (prime % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                PrimitiveRoot pr = new PrimitiveRoot(prime);
                pr.getPrimitive();
                pr.PrimitiveShow();
                break;
            } else {
                System.out.println(prime + " is not a prime number.");
            }
        }

    }
}
