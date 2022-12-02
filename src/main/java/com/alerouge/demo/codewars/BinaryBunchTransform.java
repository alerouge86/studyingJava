package com.alerouge.demo.codewars;

/**
 * Given an integer, n, consider its binary representation - I shall call a binary bunching of n any rearrangement of the bits of n such that all set
 * bits are contiguous (i.e. all its 1s are side-by-side when viewed as a string).
 * <p>
 * There are many possible ways of binary bunching the bits of n; for each possible way, we can calculate its bunching cost - this is the number of bit
 * flips necessary to reach the final binary number from the initial value of n.
 * <p>
 * An example will make all this clear:
 * <p>
 * If we take n = 52 then in binary n = 110100. We see that there are 6 bits in the binary representation n = 110100.
 * <p>
 * There are only 4 possible ways to binary bunch rearrange these 6 bits of n = 110100, listed here with the number of bit flips necessary to do so in each case:
 * <p>
 * 110100 -> 000111, requires flipping 1st, 2nd, 5th, 6th bits, so total bunching cost = 4
 * <p>
 * 110100 -> 001110, requires flipping 2nd, 4th, 5th, 6th bits, so total bunching cost = 4
 * <p>
 * 110100 -> 011100, requires flipping 4th, 6th bits, so total bunching cost = 2
 * <p>
 * 110100 -> 111000, requires flipping 3rd, 4th bits, so total bunching cost = 2
 * <p>
 * Finally, we shall call the Binary Bunch Transform of n the smallest number among all possible numbers which have the lowest possible bunching cost.
 * <p>
 * So returning to the above example, of the 4 possible ways of binary bunching n = 52 = 110100, the lowest possible bunching cost is 2 and of two
 * possible numbers that shared this minimum bunching cost (111000 = 56, and 011100 = 28) the smallest is 28.
 * <p>
 * Therefore bunch(52) = 28.
 * <p>
 * Inputs and Outputs
 * You will be given a positive integer, n > 0.
 * <p>
 * Values of n up to 2**32 will be tested (depending on language).
 * <p>
 * You must return an integer, the Binary Bunch Transform of n as defined above.
 * <p>
 * Further examples with small values
 * Here are some further small examples you can check by hand if you want, before coding your solution.
 * <p>
 * n = 19 = 10011 -> transforms to 00111 in 2 bit flips, which is the smallest number of bit flips needed to get all 1s bunched together. 00111 is the
 * smallest bunched binary number that can be reached in 2 bit flips starting from n = 19 = 10011. 00111 represents the integer 7 so bunch(19) = 7.
 * <p>
 * n = 49 = 110001 -> transforms to 111000 in 2 bit flips, which is the smallest number of bit flips needed to get all 1s bunched together. 111000 is the
 * smallest bunched binary number that can be reached in 2 bit flips starting from n = 49 = 110001.111000 represents the integer 56 so bunch(49) = 56.
 */
public class BinaryBunchTransform {
    public static int bunchIt(int number) {
        String binaryStr = Integer.toBinaryString(number);
        // counting the number of bit "1"
        int countBitOnes = getCountBitOnes(binaryStr);
        // finding the zone with more concentration of bit one
        int indexZoneMorePopulated = getIndexZoneMorePopulated(binaryStr, countBitOnes);
        // creating the flipped binary number and converting in decimal
        return Integer.parseInt("0".repeat(indexZoneMorePopulated) + "1".repeat(countBitOnes) + "0".repeat(binaryStr.length() - countBitOnes - indexZoneMorePopulated), 2);
    }

    private static int getIndexZoneMorePopulated(String binaryStr, int countBitOne) {
        int indexZoneMoreOnes = 0;
        int maxOnesPerZone = 0;
        for (int i = 0; i <= binaryStr.length() - countBitOne; i++) {
            int countOnesPerZone = getCountBitOnes(binaryStr.substring(i, i + countBitOne));
            if (countOnesPerZone >= maxOnesPerZone) {
                maxOnesPerZone = countOnesPerZone;
                indexZoneMoreOnes = i;
            }
        }
        return indexZoneMoreOnes;
    }

    private static int getCountBitOnes(String str) {
        return (int) str.chars()
                .filter(c -> c == '1')
                .count();
    }
}
