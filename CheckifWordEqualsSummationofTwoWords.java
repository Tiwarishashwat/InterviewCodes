class Solution 
{
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) 
    {
        return (findVal(firstWord) + findVal(secondWord) == findVal(targetWord));
        
    }
    public static int findVal(String word)
    {
        String n1="";
        for(int i=0;i<word.length();i++)
        {
          n1=n1+Integer.toString((int)(word.charAt(i))-97);
        }
        return Integer.parseInt(n1);
    }
}
