class Solution {
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
    public List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length]; 
        if(nums == null || nums.length == 0)  return new ArrayList<>();
        root = new Node(nums[nums.length -1]);
        for(int i = nums.length - 2; i >= 0; i--){
            insert(nums, ans, root, i, 0);
        }
        List<Integer> list = new ArrayList<>();
        for(int a : ans){
            list.add(a);
        }
        return list;
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
