class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int word=0;
        while(word<words.length)
        {
            int j=word-1;
            int characters=0;
//             Max words that can be adjusted in one line, that is :
//             cuurent length (words[j+1].length()) + total characters seen so far for this line (characters) + the spaces between each pair of words (j+1-word)
            while(j+1<words.length && characters+words[j+1].length() + j+1-word<=maxWidth)
            {
                j++;
                characters+=words[j].length();
            }
            // Adding each line
            result.add(line(words,word,j,characters,maxWidth));
            word=j+1;
        }
        return result;
    }
    public String line(String words[],int start,int end, int Linelen,int max)
    {
        StringBuilder a = new StringBuilder();
        int p=1,q=0;
        if(end!=start)
        {
            p=(max-Linelen)/(end-start);
            q=(max-Linelen)%(end-start);
        }
        
        for(int i=start;i<=end;i++)
        {
            a.append(words[i]);
            if(i!=end)
            {
                if(end==words.length-1) a.append(" ");
                else {
                    for(int j=1;j<=p;j++) a.append(" ");
                    // extra spaces 
                    if(q-->=1) a.append(" ");
                }
            }
        }
        // spaces in the last line
        while(a.length()<max) a.append(" ");
        return a.toString();
    }
}
















