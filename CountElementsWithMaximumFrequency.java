//today's question was rather on the very easy side

class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int num:nums){
            if(map.get(num)!=null) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }

        int max= 0;
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }
        int sum = 0;
        for (int freq : map.values()) {
           if(freq==max){
            sum+=freq;
           }
        }
        return sum;
    }
}
