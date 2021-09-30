class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        
        if(str1.length()!=str2.length()) return false;
        
        HashMap<Character,Character> map = new HashMap<>();
        
        for(int i=0;i<str1.length();i++)
        {
            char p1 = str1.charAt(i);
            char p2 = str2.charAt(i);
            if(map.containsKey(p1))
            {
                if(map.get(p1)!=p2) return false;
            }
            else if(map.containsValue(p2))
            {
                return false;
            }
            else
            map.put(p1,p2);
        }
        return true;
    }
}
