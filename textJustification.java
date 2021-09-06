class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<String>();
        int i=0;
        while(i<words.length)
        {
            int j=i-1,characters=0;
            while(j+1<words.length && words[j+1].length() + characters + j+1-i<=maxWidth)
            {
                j++;
                characters+=words[j].length();
            }
            r.add(line(words,i,j,characters,maxWidth));
            i=j+1;
        }
        return r;
    }
    public String line(String words[],int l, int r, int wLen,int max)
    {
        StringBuilder a = new StringBuilder();
        int p=1,q=0;
        if(r!=l)
        {
            p=(max-wLen)/(r-l);
            q=(max-wLen)%(r-l);
        }
        
        for(int i=l;i<=r;i++)
        {
            a.append(words[i]);
            if(i!=r)
            {
                if(r==words.length-1) a.append(" ");
                else{
                    for(int k=1;k<=p;k++) a.append(" ");
                    if(q-->=1) a.append(" ");
                }
            }
        }
        while(a.length()<max) a.append(" ");
        return a.toString();
    }
}
