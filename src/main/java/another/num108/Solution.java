package another.num108;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = len / 2;
        int i = mid - 1;
        int j = mid + 1;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode node = root;
        while (i >= 0) {
            node.left = new TreeNode(nums[i]);
            node = node.left;
            i--;
        }
        node = root;
        while (i < len) {
            node.right = new TreeNode(nums[j]);
            node = node.right;
            j++;
        }
        return root;
    }
}
