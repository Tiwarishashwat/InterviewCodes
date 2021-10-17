class Solution{
    int middle(int A, int B, int C){
        //code here
        
        if(A>B)
        {
            if(A<C) return A;
            
            else if(B>C) return B;
            
            else return C;
        }
        else 
        {
            if(B<C) return B;
            
            else if(A>C) return A;
            
            else return C;
        }
    }
}
