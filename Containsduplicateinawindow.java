//did this first and ofc i was gonna get tle

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int j=1;j<nums.length;j++) {
            int i=0;
            while(i<j) {
                if(nums[i] == nums[j] && Math.abs(i-j) <=k) return true;
                i++;
            }
        }
        return false;
    }
}


// then gpt taught me we can also do sliding window like this

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i]))
                return true;
            window.add(nums[i]);
            if (window.size() > k)
                window.remove(nums[i - k]);
        }
        return false;
    }
}
