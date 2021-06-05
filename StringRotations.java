public class Main
{
	public static void main(String[] args) {
	    System.out.println(isRotation("ABCD","ACBD"));
	}
	public static boolean isRotation(String s1, String s2)
	{
	    int n1=s1.length();
	    int n2=s2.length();
	    n1+=n1;
	    s1=s1+s1;
	    int i=0,j=0;
	    while(i<n1 && j<n2)
	    {
	        if(i<n1 && j<n2 && s1.charAt(i)==s2.charAt(j)) j++;
	        else
	        {
	            if(j>0) i-=j;
	            j=0;
	        }
	        i++;
	        if(j==n2) return true;
	    }
	    return false; 
	}
}
