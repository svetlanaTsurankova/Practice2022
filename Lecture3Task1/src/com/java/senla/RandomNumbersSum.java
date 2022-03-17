package com.java.senla;

public class RandomNumbersSum {

        public static void main(String[] args) {
        int  sum=0,num;
        for (int i = 0 ; i<3; i++) {
            num=(new java.util.Random()).nextInt(899)+100;
            System.out.println( "Random number " +i + " : " +num);
            sum+= num/100;
        }
        System.out.println("Random sum : " +sum);
    }

}
