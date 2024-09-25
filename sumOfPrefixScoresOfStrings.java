class Solution {
    public int[] sumPrefixScores(String[] words) {
        HashMap<String,Integer> map =new HashMap<>();
        int count[] = new int[words.length]; //res
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++){
                sb.append(word.charAt(i));
                String w = sb.toString();
                map.put(w,map.getOrDefault(w,0)+1);
            }
        }
        int index=0;
        for(String word : words){
            int c=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++){
                sb.append(word.charAt(i));
                String w = sb.toString();
                c += map.get(w);
            }
            count[index] = c;
            index++;
        }
        return count;
    }
}


class Node {
    Node child[];
    int count;
    Node(){
        child = new Node[26]; //0 to 9 digits
        count = 0;
    }
}

class Trie {
    Node root;
    Trie(){
        root = new Node();
    }
    public void addWord(String word){ //word.len
        Node temp = root;
        for(char ch : word.toCharArray()){ //abc -> temp =>Root, Root.a, Root.a.b, Root.a.b.c
            int index = ch - 'a'; //'1' to 1
            //if ch child is not present, then add it.
            if(temp.child[index]==null){
                temp.child[index] = new Node();
            }
            temp.child[index].count++;
            //move to ch child
            temp = temp.child[index];
            
        }
    }
    // if prefix is present, return prefix otherwise return empty
     public int findPrefixCount(String word){
        Node temp=root;
        int count=0;
        for(char ch : word.toCharArray()){ //abc -> temp =>Root, Root.a, Root.a.b, Root.a.b.c
            int index = ch - 'a';
            //move to ch child
            count += temp.child[index].count;
            temp = temp.child[index];
            
        }
        return count;
    }
}
     
