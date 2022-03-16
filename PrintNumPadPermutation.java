import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    String input = "24";
	    
	    HashMap<Character,String> map = new HashMap<>();
	    map.put('2',"abc");
	    map.put('3',"def");
	    map.put('4',"ghi");
	    map.put('5',"jkl");
	    map.put('6',"mno");
	    map.put('7',"pqr");
	    map.put('8',"stuv");
	    map.put('9',"wxyz");
	    
	    int n = input.length();
	    ArrayList<String> r = solve(map,input,n);
	    
	    for(int i=0;i<r.size();i++)
	    {
	        System.out.println(r.get(i));
	    }
	    
	}
	
	public static ArrayList<String> solve(HashMap<Character,String> map,String input,int n)
	{
      // Base case is that if only 1 input is there then store it in list and return the list
	    if(n==1)
	    {
	        
	        ArrayList<String> list = new ArrayList<>();
	        String res = map.get(input.charAt(n-1));
	        
	        for(int i=0;i<res.length();i++)
	            list.add(Character.toString(res.charAt(i)));
	        
	        return list;
	    }
    
      // Get the previous result
	        ArrayList<String> l1 = solve(map,input,n-1);
      //  Get the cuurent result
	        ArrayList<String> current = new ArrayList<>();
	        ArrayList<String> r = new ArrayList<>();
	        
	        String rest = map.get(input.charAt(n-1));
	        for(int i=0;i<rest.length();i++)
	        {
	            current.add(Character.toString(rest.charAt(i)));
	        }
	        
      // Combine the two list and store it in the final list
	        for(int i=0;i<l1.size();i++)
	        {
	            for(int j=0;j<current.size();j++)
	            {
	                String ni = l1.get(i)+current.get(j);
	                r.add(ni);
	            }
	        }
      // return the resultant list
	        return r;
	}
}
