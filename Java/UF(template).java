//LC839
class Solution {
    class UF {
        int[] parent;
        int[] rank;
        int count;
        public UF(int N){
            parent = new int[N];
            rank = new int[N];
            count = N;
            for(int i = 0; i < N; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int p){
            while( p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
       public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootQ] > rank[rootP]){
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            }else{
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
            count--;
        }
        public int count(){
            return count;
        }
    }
    public int numSimilarGroups(String[] A) {
        UF uf = new UF(A.length);
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(check(A[i], A[j])){
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }
    public boolean check(String A, String B){
        int a = 0;
        int b = 0;
        int count = 0;
        while(a < A.length()){
            if(A.charAt(a) != B.charAt(b)){
                count++;
            }
            if(count > 2){
                return false;
            }
            a++;
            b++;
        }
        return true;
    }
}
