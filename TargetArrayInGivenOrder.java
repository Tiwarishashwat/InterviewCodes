// Way one
class Solution {
    
    public static void shift(int arr[],int pos,int n)
    {
        for(int i=n-2;i>=pos;i--)
        {
            arr[i+1]=arr[i];
        }
    }
    public int[] createTargetArray(int[] nums, int[] index) {   
        int target[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            target[i]=-1;
        }
        for(int i=0;i<nums.length;i++)
        {
           if(target[index[i]]!=-1)
           {
               shift(target,index[i],target.length);
           }
            target[index[i]]=nums[i];
        }
        return target;
    }
}

// Way two

 public int[] createTargetArray(int[] nums, int[] index) {   
    List<Integer> temp = new ArrayList<>();
        int[] target = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) temp.add(index[i], nums[i]);
                
        for (int j = 0; j < temp.size(); j++) target[j] = temp.get(j);
        
        return target;
   
    }
