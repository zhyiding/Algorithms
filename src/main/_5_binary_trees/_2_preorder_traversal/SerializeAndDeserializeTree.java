package _5_binary_trees._2_preorder_traversal;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SerializeAndDeserializeTree {
    private static final String SPLITER = ",";
    private static final String NULL = "null";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SPLITER);
        } else {
            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodes);
    }

    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL)) return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
