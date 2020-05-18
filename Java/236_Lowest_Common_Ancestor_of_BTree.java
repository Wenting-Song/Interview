N-ary Tree:

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        List<TreeNode> returned = new ArrayList<>();
        for(int i = 0; i < root.childen.length; i++){
            TreeNode node = lowestCommonAncestor(root, p, q);
            if(node != null){
                returned.add(node);
            }
        }
        if(returned.size() == 2){
            return root;
        }
        return returned.size() == 0? null: returned.get(0);
    }
}

Regular Binary Tree:
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p ,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
