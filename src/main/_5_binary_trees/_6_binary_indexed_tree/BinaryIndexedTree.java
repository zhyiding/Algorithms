package _5_binary_trees._6_binary_indexed_tree;

/**
 * Store sequence segments of the length of 2's multiple
 *
 * Average case:
 *   Both read and write within O(log(N))
 *
 * Worst case:
 *   Both read and write within O(log(N))
 */
public class BinaryIndexedTree {

    // Gets parent index to read
    private static int getParentIndex(int current) {
        int complement = ~current + 1;
        return current - (current & complement);
    }

    // Gets next index to update
    private static int getNextIndex(int current) {
        int complement = ~current + 1;
        return current + (current & complement);
    }

    public static void main(String[] args) {
        System.out.println(getNextIndex(6));
    }
}
