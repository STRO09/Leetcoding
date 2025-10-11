// 17

class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> combinations = new ArrayList<>();

      if(digits.length()==0 || digits == null) return combinations;

      String mapping[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

      backtracking(combinations, mapping, digits, 0, new StringBuilder());;
      return combinations;  
    }

    public void backtracking(List<String> combinations, String[] mapping, String digits, int index, StringBuilder current) {

        if(index == digits.length()){
            combinations.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for(char c: letters.toCharArray()){
            current.append(c);
            backtracking(combinations,mapping,digits,index+1,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}
