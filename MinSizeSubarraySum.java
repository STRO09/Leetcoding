// I guess now i will only add the ones that gave me trouble. and maybe remove the easy ones later.

//this is what i did at first. although i knew this is not gonna work while writing since i expand the window at the same time i reduce. i didnt how to do that. and it was as simple as putting while inside for

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int windowsum = nums[0];
//         int minLength = Integer.MAX_VALUE;
//         int left = 0;
//         boolean exists = false;

//         for (int i = 1; i < nums.length; i++) {
//             if (windowsum < target) {
//                 windowsum += nums[i];
//             } else {
//                 exists = true;
//                 minLength = Math.min(minLength, i - left );
//                 windowsum -= nums[left++];
//                 windowsum += nums[i];
//             }
//         }

//         while( windowsum >=target) {
//             exists = true;
//             minLength = Math.min(minLength, nums.length - left );
//             windowsum -= nums[left++];
//         }


//         if(exists) {
//             return minLength;
//         }
//         return 0;

//    }

//correct solution

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int minLength = Integer.MAX_VALUE;
       int windowsum = 0;
       int left = 0;

       for(int i=0;i< nums.length;i++){
        windowsum += nums[i];
        while(windowsum >= target && i>= left) {
            minLength = Math.min(minLength, i-left +1);
            windowsum -= nums[left++];
        }
       }

       return (minLength == Integer.MAX_VALUE) ? 0 : minLength; 
    }
}
}
