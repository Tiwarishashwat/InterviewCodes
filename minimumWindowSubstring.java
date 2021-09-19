class Solution {
    
  public String minWindow(String s, String t) {
      
      // map for storing the frequency of elements
       Map<Character,Integer> map = new HashMap<>();
      
      // storing the default values in the map
        for(int i=0; i< t.length() ;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
      
        // utility variables
        int uniqueCount = map.size();
        int start = 0 , end = 0;
        int minLen  =  Integer.MAX_VALUE , startInd = -1 ; 
      
        // traverse the input string
      
        while(end<s.length()){
            
            // if a character of String "s" is present in String "t" (map)
            // then decremment its frequency
            
            if(map.containsKey(s.charAt(end)))
            {
                map.put(s.charAt(end),map.get(s.charAt(end))-1);
                // if frequency becomes 0 then decrease the value of uniqueCount
                // as you have exhausted one of the characterss of "t"
                if(map.get(s.charAt(end))==0){
                    uniqueCount--;
                }
            }
            // if uniqueCount drops to 0 then it means all unique values of consumed 
            // you got your window
            if(uniqueCount==0){
                // now shrinkig the size of the window!
                while (uniqueCount == 0 ){
                    // calculate the length and save the minimum length as well as new starting index of the window! 
                    if(minLen > end-start+1){
                        minLen = end-start+1;
                        startInd = start;
                    }
                    
                    if(map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start),map.get(s.charAt(start))+1);
                        if(map.get(s.charAt(start))>0){
                            uniqueCount++;
                        }
                    }
                    start++;
                }
            }
            end++;
            
        }
        if(startInd==-1 ){
            return "";
        }
        return s.substring(startInd,startInd+minLen);
  }
}
