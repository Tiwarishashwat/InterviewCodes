// 1st approach
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch-96);
        }
        while(k>0){
            int sum=0;
            for(int i=0;i<sb.length();i++){ 
                sum += (sb.charAt(i) - '0');
            }
            k--;
            sb = new StringBuilder(String.valueOf(sum)); 
        }
        return Integer.parseInt(sb.toString());
    }
}


// 2nd approach
class Solution {
    public int getLucky(String s, int k) {
        int sum1=0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int num = ch-96;
            while(num>0){ //log base 10 (num)
                sum1 += (num%10);
                num/=10;
            }
        }
        sb.append(sum1);
        while(k>1){ //k*z
            int sum=0;
            for(int i=0;i<sb.length();i++){  //z
                sum += (sb.charAt(i) - '0');
            }
            k--;
            sb = new StringBuilder(String.valueOf(sum)); 
        }
        return Integer.parseInt(sb.toString());
    }
}
