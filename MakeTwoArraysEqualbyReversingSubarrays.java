//sorting solution (try it on your own)
// hint: use two pointer after sorting both the arrays
 
//Double map solution
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int element : target){
            map1.put(element, map1.getOrDefault(element,0)+1);
        }

        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int element : arr){
            map2.put(element, map2.getOrDefault(element,0)+1);
        }

        for(int key : map1.keySet()){
            if(!map2.containsKey(key)){
                return false;
            }
            if(map1.get(key)!=map2.get(key)){
                return false;
            }
        }
        return true;
    }
}

//single map solution
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int element : target){
            map1.put(element, map1.getOrDefault(element,0)+1);
        }
        for(int element : arr){
            if(!map1.containsKey(element)){
                return false;
            }
            map1.put(element,map1.get(element)-1);
            if(map1.get(element)==0){
                map1.remove(element);
            }
        }
        return map1.isEmpty();
    }
}

// single array solution
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int freq[] = new int[1001]; 
        for(int element : target){
            freq[element]++;
        }
        for(int element : arr){
            freq[element]--;
        }
        for(int element : freq){
            if(element!=0){
                return false;
            }
        }
        return true;
    }
}
