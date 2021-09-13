package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.Scanner;

public class App 
{

    private static final double lower_limit = 18.5;

    private static final double upper_limit = 25.0;

    public static void main( String[] args )
    {

        double weight, height, BMI;

        String temp;

        Scanner s = new Scanner(System.in);

        System.out.print("What is your weight in pounds? ");

        weight = String_to_Double(verify_num(s));

        System.out.print("What is your height in inches? ");

        height = String_to_Double(verify_num(s));

        BMI = weight / (height * height) * 703;

        temp = "Your BMI is " + BMI + ".\n";

        if(BMI < lower_limit){

            temp = temp.concat("You are underweight. You should see your doctor.");

        }

        else if(BMI > upper_limit){

            temp = temp.concat("You are overweight. You should see your doctor.");

        }

        else{

            temp = temp.concat("You are within the ideal weight range.");

        }

        System.out.print(temp);

        s.close();

    }

    private static String verify_num(Scanner s){

        String in = s.nextLine();

        int flag = 0;

        if(in.equals(".")){

            flag = 1;

        }

        for(int i = 0; i < in.length(); i++){

            if(in.charAt(i) < '0' || in.charAt(i) > '9'){

                if(in.charAt(i) == '.' && flag < 1){

                    flag++;

                    continue;

                }

                System.out.print("Please enter a number. ");

                return verify_num(s);

            }

        }

        return in;

    }

    private static int String_to_Int(String num){

        int res = 0;

        for(int i = 0; i < num.length(); i++){

            res += (num.charAt(i)-'0')*pow(10, num.length()-1-i);

        }

        return res;

    }

    private static double String_to_Double(String num){

        double res = 0.0;

        int decimal_index = num.indexOf("."), flag = 1;

        if(decimal_index == -1){

            return(String_to_Int(num));

        }

        for(int i = 0; i < num.length(); i++) {

            if (i == decimal_index) {

                flag = 0;

                continue;

            }

            res += (num.charAt(i) - '0') * pow(10, decimal_index - flag - i);

        }

        return res;

    }

    private static double pow(int base, int exponent){

        if(exponent < 0){

            pow_neg_exp(base, -1*exponent);

        }

        int res = 1;

        for(int i = 0; i < exponent; i++){

            res *= base;

        }

        return res;

    }

    private static double pow_neg_exp(int base, int exponent){

        double res = 1;

        for(int i = 0; i < exponent; i++){

            res /= base;

        }

        return res;

    }

}
