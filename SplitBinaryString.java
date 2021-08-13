	public static int binString(String str)
	{
	    int countZero=0;
	    int countOne=0;
	    int ans=0;
	    for(int i=0;i<str.length();i++)
	    {
	        if(str.charAt(i)=='0') countZero++;
	        else countOne++;
	        
	        if(countOne==countZero)
	        {
	            ans++;
	            countZero=0;
	            countOne=0;
	        }
	    }
	    return (ans==0)?-1:ans;
	}
