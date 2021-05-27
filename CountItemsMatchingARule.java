class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        
        int ans=0;
        for(List l : items)
        {
          if((ruleKey.equals("type"))&&((l.get(0)).equals(ruleValue)))
           {
              ans++;
            }
             else if((ruleKey.equals("color"))&&((l.get(1)).equals(ruleValue)))
           {
              ans++;
            }
             else if((ruleKey.equals("name"))&&((l.get(2)).equals(ruleValue)))
           {
              ans++;
            }
        
        }
        
        return ans;
        
    }
}
