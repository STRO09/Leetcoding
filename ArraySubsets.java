class ArraySubsets {

    static void helper(List<Integer> nums, Set<List<Integer>> subs){
        if(nums.size()==1){
            return;
        }
        for(int i=0;i<nums.size();i++){
            List<Integer> li = new ArrayList<>();
            for(int j=0;j<i;j++){
                li.add(nums.get(j));
            }
            for(int j=i+1;j<nums.size();j++){
                li.add(nums.get(j));
            }
            subs.add(li);
            helper(li,subs);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subs = new LinkedHashSet<>();
        List<Integer> newnums = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());
        subs.add(Arrays.asList());
        subs.add(newnums);
        helper(newnums,subs);
        List<List<Integer>> finalsubsets = new ArrayList<>(subs);
        return finalsubsets;
    }
}
