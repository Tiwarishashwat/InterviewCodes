// hashset
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();
        for(String str : arr){
            if(duplicate.contains(str)){
                continue;
            }
            if(distinct.contains(str)){
                distinct.remove(str);
                duplicate.add(str);
            }else{
                distinct.add(str);
            }
        }
        for(String str : arr){
            if(!duplicate.contains(str)){
                k--;
            }
            if(k==0){
                return str;
            }
        }
        return "";
    }
}

// hashmap
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> freqMap = new HashMap<>();
        for(String str : arr){
            freqMap.put(str,freqMap.getOrDefault(str,0)+1);
        }
        for(String str : arr){
            if(freqMap.get(str)==1){
                k--;
            }
            if(k==0){
                return str;
            }
        }
        return "";
    }
}
