class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int n=s.length();
        int output=0;
        for(int i=0;i<n;i++)
        {
         if(i<n-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1)))
         {
             output+= map.get(s.charAt(i+1))-map.get(s.charAt(i));
             i++;
         }
         else
         {
             output+=map.get(s.charAt(i));
         }
        }
        return output;

    }
}
