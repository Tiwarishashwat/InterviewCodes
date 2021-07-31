class Solution {
    public String findSubString( String str) {
        // Your code goes here
        // Getting unique elements using hashSet
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<str.length();i++)
        set.add(str.charAt(i));
        // count of unique elements
        int winLength=set.size();
        // Visited array to maintain element count
        int visited[] = new int[256];
        // local variables
        int start=0,start_index = -1;
        int counter=0;
        int min_len = Integer.MAX_VALUE;
        // main logic goes here
        for(int i=0;i<str.length();i++)
        {
            // increasing frequency
            visited[str.charAt(i)-65]++;
            // increment counter
            if(visited[str.charAt(i)-65]==1) counter++;
            // Shrinkking process
            if(counter==winLength)
            {
                // shrink from the left
                 while (visited[str.charAt(start)-65] > 1) {
                    if (visited[str.charAt(start)-65] > 1)
                        visited[str.charAt(start)-65]--;
                    start++;
                }
                // calculating minimum value
                int len_window = i - start + 1;
                if(min_len>len_window)
                {
                    min_len=Math.min(len_window,min_len);
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index + min_len);
    }
}
