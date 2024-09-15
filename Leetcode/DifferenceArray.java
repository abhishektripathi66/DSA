import java.util.AbstractList;

class DifferenceArray {
  
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
            return new AbstractList<List<Integer>>() {
            List<Integer> first = null;
            List<Integer> second = null;

            @Override
            public List<Integer> get(int i){
                if(first==null){
                    process();
                }
                return (i==0)?first:second;
            }

            @Override
            public int size(){
                return 2;
            }

            private void process(){
                first = new ArrayList<>();
                second = new ArrayList<>();
                byte[] m1 = new byte[2001];
                byte[] m2 = new byte[2001];
                for(int i : nums2){
                    m1[i+1000]=0b1;
                }
                for(int i : nums1){
                    int x = i+1000;
                    if(m1[x]!=0b1){
                        m1[x] = 0b1;
                        first.add(i);
                    }
                    m2[x] = 0b1;
                }
                for(int i:nums2){
                    int x=i+1000;
                    if(m2[x]!=0b1){
                        m2[x] = 0b1;
                        second.add(i);
                    }
                }

            }
        };
    }
}
