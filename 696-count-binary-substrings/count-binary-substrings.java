class Solution {
    public int countBinarySubstrings(String s) 
    {
        int ans=0; 
        int n=s.length(); 
        List<Integer>temp=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int el=s.charAt(i);
            int cnt=0;
            while(i<n && s.charAt(i)==el)
            {
                cnt++;
                i++;
            }
            temp.add(cnt);
            i--;
        }
        for(int i=1;i<temp.size();i++)
        {
            ans+=Math.min(temp.get(i-1),temp.get(i));
        }
        return ans;
    }
}