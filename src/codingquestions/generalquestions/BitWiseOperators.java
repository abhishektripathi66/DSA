package codingquestions.generalquestions;

public class BitWiseOperators {

    public static void main(String[] args) {
        // 3 equvialent is // 0011 in binary
        // 6 equvialent is // 0110 in binary
        // AND of 3 and 6 is // 0010 in binary which is 2 in decimal
        System.out.println("Bitwise AND: " + (6 & 3)); // 2
        // 5 equivalent is // 0101 in binary
        // 3 equivalent is // 0011 in binary
        // OR of 5 and 3 is // 0111 in binary which is 7 in decimal
        System.out.println("Bitwise OR: " + (5 | 3)); // 7
        // 5 equivalent is // 0101 in binary
        // 3 equivalent is // 0011 in binary
        // XOR of 5 and 3 is // 0110 in binary which is 6 in decimal
        System.out.println("Bitwise XOR: " + (5 ^ 3)); // 6
        // Bitwise NOT of 1 is the complement of 1
        // 1 equivalent is // 0001 in binary
        // NOT of 1 is // 1110 in binary which is -2 in decimal (two's complement representation)
        // the negative value is basically the 2^32-1-x where x is the value of number of zeros in the binary representation of 1's complement of the value.
        System.out.println("Bitwise NOT: " + (~1)); // -2
        // Left shift operator shifts bits to the left, filling with zeros
        // 5 equivalent is // 0101 in binary
        // Left shift by 1 results in // 1010 in binary which is 10 in decimal
        System.out.println("Left Shift: " + (5 << 1)); // 10
        System.out.println("Left Shift: " + (-5 << 2)); // -20
        // 5 equivalent is // 0101 in binary
        // Right shift by 1 results in // 0010 in binary which is 2 in decimal
        // Note: Right shift operator in Java performs an arithmetic shift for positive numbers
        System.out.println("Right Shift: " + (5 >> 1)); // 2
        // unsigned Right shift operator shifts bits to the right, filling with zeros
        // 5 equivalent is // 0101 in binary
        // Unsigned right shift by 1 results in // 0010 in binary which is 2 in decimal
        // Note: Unsigned right shift operator in Java always fills with zeros, regardless of the sign of the number
        System.out.println("unsigned Right Shift: " + (5 >>> 1)); // 2


        // Negative numbers in Java are represented using two's complement.
        // range of negative numbers is from -2^(n-1) to 2^(n-1)-1, where n is number of bits

        //steps to get the two's complement of a number:
        // 1. Write the binary representation of the number
        // 2. Invert the bits (change 0s to 1s and 1s to 0s)
        // 3. Add 1 to the inverted bits
        int num = -5;
        String binaryRepresentation = Integer.toBinaryString(num);
        String invertedBits = "";
        for (char bit : binaryRepresentation.toCharArray()) {
            invertedBits += (bit == '0') ? '1' : '0';
        }
        int invertedNumber = Integer.parseInt(invertedBits, 2);
        int twosComplement = invertedNumber + 1;
        System.out.println("Two's complement of " + num + " is: " + Integer.toBinaryString(twosComplement));
        // Direct formular = 2^n -x
    }
}
