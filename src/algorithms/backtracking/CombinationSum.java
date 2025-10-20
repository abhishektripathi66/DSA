
class CombinationSum {
    public static void main(String[] args) {
        
        System.out.println(combinationSum(3,3));
    }
 public List<List<Integer>> combinationSum3(int k, int n) {
return combine(new ArrayList<>(),k,n,1); 
   }

List<List<Integer>>combine(List<Integer>list,int k,int n,int pos){
        List<List<Integer>>ans=new ArrayList<>();
        if(list.size()==k){
            int sum=0;
            for(int index=0;index<list.size();index++){
                sum+=list.get(index);
            }
            if(sum==n) ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=pos;i<=9;i++){

            list.add(i);
            ans.addAll(new ArrayList<>(combine(list,k,n,pos=pos+1)));
            list.remove(list.size()-1);
        }
        return ans;
}
}
