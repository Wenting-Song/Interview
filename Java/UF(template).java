//LC323
class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] ed: edges){
           uf.union(ed[0], ed[1]); 
        }
        return uf.capacity;
    }
    class UF {
        int[] parent;
        int[] size;
        int capacity;
        public UF(int capacity){
            this.capacity = capacity;
            parent = new int[capacity];
            size = new int[capacity];
             for(int i = 0; i < capacity; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        private void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
             if(rootI == rootJ) return;
            if(size[rootI] < size[rootJ]){
                parent[rootI] = rootJ;
                size[rootI] = rootJ;
            }else{
                parent[rootJ] = rootI;
                size[rootJ] = rootJ;
            }
            capacity--;
        }
        
        private int find(int i){
            if(parent[i] == i){
                return i;
            }
            return find(parent[i]);
        }
     
    }
}




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
