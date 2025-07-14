package codingquestions.leetcode.ds;

public class RomanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {

        double number = 0;
        char prev = '0';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                number += 1;
            } else if (s.charAt(i) == 'V') {
                if (prev == 'I') {
                    number += 3;
                } else {
                    number += 5;
                }
            } else if (s.charAt(i) == 'X') {
                if (prev == 'I') {
                    number += 8;
                } else {
                    number += 10;
                }
            } else if (s.charAt(i) == 'L') {
                if (prev == 'X') {
                    number += 30;
                } else {
                    number += 50;
                }
            } else if (s.charAt(i) == 'C') {
                if (prev == 'X') {
                    number += 80;
                } else {
                    number += 100;
                }
            } else if (s.charAt(i) == 'D') {
                if (prev == 'C') {
                    number += 300;
                } else {
                    number += 500;
                }
            } else if (s.charAt(i) == 'M') {
                if (prev == 'C') {
                    number += 800;
                } else {
                    number += 1000;
                }
            }

            prev = s.charAt(i);

        }

        return (int) number;

    }
}
