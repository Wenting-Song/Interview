class Solution {
     public int numTeams(int[] rating) {
        int[] left = countSmallerLeft(rating);
        int[] right = countSmallerRight(rating);
        int res = 0;
        for(int i = 1; i < rating.length-1; i++){
            int countLargerLeft = i- left[i];
            int countLargerRight = rating.length - i -1 -right[i];
            res += left[i]*countLargerRight + right[i]*countLargerLeft;
        }
        return res;
     }
     class Node {
        Node left, right;
        int val; //value of the node
        int dup; //duplicate num of this val
        int sum; //nums of node in left subtree
        public Node(int val){
            this.val = val;
            dup = 1;
            sum = 0;
        }
    }
    Node root = null;
    public int[] countSmallerRight(int[] nums) { // count of smaller numbers after self
        root = new Node(nums[nums.length -1]);
        int[] res = new int[nums.length];
        for(int i = nums.length - 2; i > 0; i--){
            insert(nums, res, root, i, 0);
        }
        return res;
    } 
    public int[] countSmallerLeft(int[] nums) { // count of smaller numbers after self
        root = new Node(nums[0]);
        int[] res = new int[nums.length];
        for(int i = 1; i < nums.length-1; i++){
            insert(nums, res, root, i, 0);
        }
        return res;
    }
    private void insert(int[] nums, int[] res, Node root, int i, int preSum){
        if(nums[i] == root.val){
            res[i] = preSum + root.sum;
            root.dup++;
        }else if(nums[i] < root.val){
            root.sum++;
            if(root.left == null){
                root.left = new Node(nums[i]);
                res[i] = preSum;
            }else{
                insert(nums, res, root.left, i, preSum);
            }
        }else if(nums[i] > root.val){
            preSum += root.sum;
            preSum += root.dup;
            if(root.right == null){
                root.right = new Node(nums[i]);
                res[i] = preSum;
            }else{
                insert(nums, res, root.right, i, preSum);
            }
        }
    }
}
