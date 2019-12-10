/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.security;

import java.math.BigInteger;
import java.util.Random;
import java.security.SecureRandom;

/**
 *
 * @author Hasibul Hasan Shanto
 */
public class diffieHellman {

    private long prime, pRoot, privKeyA, pubKeyA, pubKeyB, privKeyB, keyA, keyB, K1, K2;

    public diffieHellman(long prime) {
        this.prime = prime;
        this.pRoot = primtiveRoot(prime);
        this.privKeyA = privateKey(this.prime);
        this.pubKeyA = publicKey(prime, privKeyA);
        this.privKeyB = privateKey(this.prime);
        this.pubKeyB = publicKey(prime, privKeyB);
    }

    public void DHFunc() {
        BigInteger temp = BigInteger.valueOf(pubKeyB);
        //keyB = (long)Math.pow( pubKeyA, privKeyB)%prime;
//        BigInteger temp1 = BigInteger.valueOf(privKeyA);
        BigInteger res = temp.pow((int) privKeyA);
        BigInteger temp2 = BigInteger.valueOf(prime);
        K1 = res.mod(temp2).intValue();

        BigInteger temp3 = BigInteger.valueOf(pubKeyA);
        //keyB = (long)Math.pow( pubKeyA, privKeyB)%prime;
//        BigInteger temp1 = BigInteger.valueOf(privKeyA);
        BigInteger res2 = temp3.pow((int) privKeyB);
        BigInteger temp4 = BigInteger.valueOf(prime);
        K2 = res.mod(temp2).intValue();
        System.out.println("Key of Alice: " + K1 + "\nKey of Bob: " + K2);
    }

    public long primtiveRoot(long prime) {
        PrimitiveRoot pr = new PrimitiveRoot((int) prime);
        long val = pr.getPrimitive();
        System.out.println("P root is: " + val);
        return val;
    }

    public long privateKey(long prime) {
        Random num = new Random();
        long temp = (long) (num.nextDouble() * prime);
        System.out.println("Private Key: " + temp);
        return temp;
    }

    public long publicKey(long prime, long privKey) {
        long temp = (long) Math.pow(pRoot, privKey) % prime;
        System.out.println("Public Key:" + temp);
        return temp;
    }

    public static void main(String[] args) {

        Random ran = new SecureRandom();
        long prime = BigInteger.probablePrime(7, ran).longValue();
        System.out.println("Prime number is: " + prime);
        diffieHellman ob = new diffieHellman(prime);
        ob.DHFunc();
    }
}
