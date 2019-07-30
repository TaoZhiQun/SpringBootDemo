package com.example.test.other.algorithm;

public class Gu {
    public static int count = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    int[] nums = new int[]{i, j, k};
                    operate(nums);
                }
            }
        }
        System.out.println("总共有" + count + "情况");
    }

    public static void operate(int[] nums) {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            double sum1 = caculate(nums[0], nums[1], i);
            for (int j = 0; j < 3; j++) {
                sum = caculate(sum1,nums[2],j);
                int [] sysolNum ={i,j};
                String[] symbol=new String[2];
                symbol = symbol(sysolNum);
                if(sum == 6){
                    count++;
                    System.out.println(nums[0]+" "+symbol[0]+" "+nums[1]+" "+symbol[1]+" "+nums[2]);
                }
            }
        }
    }


    public static double caculate(double num1, double num2, int num) {
        double sum = 0.0;
        if (num == 0) {
            sum = num1 + num2;
        } else if (num == 1) {
            sum = num1 - num2;
        } else if (num == 2) {
            sum = num1 * num2;
        } else {
            sum = num1 / num2;
        }
        return sum;
    }

    public static String[] symbol(int[] symbolNum) {
        String[] symbol = new String[3];
        for (int i = 0; i < 2; i++) {
            int sym = symbolNum[i];
            switch (sym) {
                case 0:
                    symbol[i] = "+";
                    break;
                case 1:
                    symbol[i] = "-";
                    break;
                case 2:
                    symbol[i] = "x";
                    break;
                case 3:
                    symbol[i] = "÷";
                    break;
                default:
                    break;
            }

        }
        return symbol;
    }


}
