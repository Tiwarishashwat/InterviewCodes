class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int m = part.length();
        for(char ch : s.toCharArray()){
            sb.append(ch);
            if(sb.length() >= m){
                String sub = sb.substring(sb.length()-m);
                if(sub.equals(part)){
                    sb.setLength(sb.length()-m);
                }
            }
        }
        return sb.toString();
    }
}
