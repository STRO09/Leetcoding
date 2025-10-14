//3349

// the solution felt really simple
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int submark = 0;
        List<Integer> markedindexes = new ArrayList<>();
      for(int i=1;i<nums.size();i++){
        if(nums.get(i)> nums.get(i-1)) submark++;
        else submark =0;
        if(submark>=k-1) {
            markedindexes.add(i-k+1);
            submark =0;
        }
      }

      for(int i=1;i<markedindexes.size();i++) {
        if(markedindexes.get(i) == markedindexes.get(i-1)+k) {
           return true;
        }
      }
      return false;  
    }
}

// but then this one stupid sneaky testcase ruined it
// Wrong Answer
// 1058 / 1422 testcases passed
// Input
// nums =
// [-15,19]
// k =
// 1
// Output
// false
// Expected
// true

// i could only think of special if loops for that condition which felt like cheating
// but then asked gpt and it seems it was the only fix
// so cheating it isssss

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        if (k == 1) return nums.size() >= 2;
        int submark = 0;
        List<Integer> markedindexes = new ArrayList<>();
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)> nums.get(i-1)) submark++;
            else submark =0;
            if(submark>=k-1) {
                markedindexes.add(i);
            }
        }

        for(int i=1;i<markedindexes.size();i++) {
            if(markedindexes.get(i) == markedindexes.get(i-1)+k) {
                return true;
            }
        }
        return false;  
    }
} 
// welp theres a life lesson! sometimes cheating is imp and the only way lol



// turns out this still wasnt enough, spoke too soon lol..
// another testcase messed it up
// Wrong Answer
// 1223 / 1422 testcases passed
// Input
// nums =
// [-15,-13,4,7]
// k =
// 2
// Output
// false
// Expected
//true

//so my checking was wrong, i should not just check if the consecutive indices stored are k apart. that would be wrong if the stored indices are also in between k distance appart. 
// so had to check if each element was k distance apart or not from each element 

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        if (k == 1) return nums.size() >= 2;
        int submark = 0;
        List<Integer> markedindexes = new ArrayList<>();
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)> nums.get(i-1)) submark++;
            else submark =0;
            if(submark>=k-1) {
                markedindexes.add(i);
            }
        }

        for (int i = 0; i < markedindexes.size(); i++) {
            for (int j = i + 1; j < markedindexes.size(); j++) {
                if (markedindexes.get(j) - markedindexes.get(i) == k) {
                    return true;
                }
            }
        }

        return false;  
    }
}
//done!

// not really happy an easy difficulty took this much time. oh well

