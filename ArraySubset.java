class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        
        HashSet<Long> set = new HashSet<Long>();
        
        for(int i=0;i<n;i++)
        {
            set.add(a1[i]);
        }
        
        for(int j=0;j<m;j++)
        {
            if(!set.contains(a2[j])) return "No";
        }
        return "Yes";
    }
}
