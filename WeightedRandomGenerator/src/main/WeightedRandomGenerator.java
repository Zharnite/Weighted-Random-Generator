/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author zheny
 */
public class WeightedRandomGenerator {
    public static void main(String[] args) {        
        int minNum = 4;
        int midNum = 8;
        int maxNum = 15;
        double pow = 1;
        
        int generations = 500;
        int[] vidCount = new int[16]; //from 0-15
        for(int i = 0; i < generations; i++) {
            int num = genRandNum(minNum, midNum, maxNum, pow);
            vidCount[num]++;
        }
        
        //prints out final array of generated numbers
        
        for(int i = 0; i < vidCount.length; i++) {
            System.out.println("Vid count " + i + " was generated " + vidCount[i] + " times.");
            System.out.println("The pecentage is: " + percentage(vidCount[i], generations));
        }
    }
    
    public static double percentage(int count, int total) {
        return (double)count / total;
    }
    
    public static int genRandNum(int min, int mid, int max, double pow) {
        double num = 0;
        double randDouble = Math.pow(Math.random(), pow);
        double temp = Math.random();
        if(temp < 0.5) {
            num = Math.floor(randDouble * (max - mid) + mid);
        }
        else {
            num = Math.floor(randDouble * (mid - min) + min);
            num = (min + mid) - num;
        }
        
        return (int)num;
    }
}
