// Frequency Map
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum=0;
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int element : skill){
            freqMap.put(element, freqMap.getOrDefault(element,0)+1);
            totalSum += element;
        }
        if(totalSum % teams !=0 ){
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for(int element : skill){
            if(freqMap.get(element)==0){
                continue;
            }
            freqMap.put(element, freqMap.get(element)-1);
            int partner = targetPoints - element;
            if(!freqMap.containsKey(partner) || freqMap.get(partner)==0){
                return -1;
            }
            freqMap.put(partner, freqMap.get(partner)-1);
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}


// Frequency Array
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum=0;
        int freqMap[] = new int[1001];
        for(int element : skill){
            freqMap[element]++;
            totalSum += element;
        }
        if(totalSum % teams !=0 ){
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for(int element : skill){
            if(freqMap[element]==0){
                continue;
            }
            freqMap[element]--;
            int partner = targetPoints - element;
            if(freqMap[partner]==0){
                return -1;
            }
            freqMap[partner]--;
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}
