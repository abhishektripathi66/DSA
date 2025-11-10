package codingquestions.leetcode;


class KoKoEatingBananas {
    public int countHour(int[] p, int k) {
        int count = 0;
        for(int pile : p) {
            count += (int)Math.ceil((double)pile/k);
        }
        return count;
    }

    public int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);

        while(left < right) {
            int mid = left + (right - left)/2;

            int ch =  countHour(piles, mid);

            if(ch > h) {
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return left;
    }
}