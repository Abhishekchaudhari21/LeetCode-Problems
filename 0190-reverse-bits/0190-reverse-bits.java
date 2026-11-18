
public class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Shift result left to make room
            result <<= 1;

            // Add the last bit of n
            result |= (n & 1);

            // Unsigned right shift
            n >>>= 1;
        }

        return result;
    }
}
