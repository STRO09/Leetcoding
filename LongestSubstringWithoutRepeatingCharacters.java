class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< s.length();i++) {
            if(sb.toString().indexOf(s.charAt(i)) != -1) {
                sb.delete(0, sb.toString().indexOf(s.charAt(i)) +1 ); 
                sb.append(s.charAt(i));
                length = Math.max(length, sb.length());
            }
            else {
                sb.append(s.charAt(i));
                length = Math.max(length, sb.length());
            }
        }
        return length;     
    }
}
