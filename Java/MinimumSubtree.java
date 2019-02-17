 /* Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
     1
   /   \
  -5    2
 /  \  /  \
0   2  -4  -5

return the node 1
*/
public class Solution {
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;
    
    public TreeNode findSubtree(TreeNode root){
      helper(root);
      return subtree;
    }
    private int helper(TreeNode root){
        if(root == null){
        return 0;
    }
    int sum = root.val + helper(root.left) + helper(root.right);
    if(sum < subtreeSum){
      subtreeSum = sum;
      subtree = root;
    }
    return sum;
  }
}

