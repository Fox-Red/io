public class TestTree {
    private static int size1;
    private int size2;

    public void getSize1(Tree tree) {
        if (tree != null) {
            getSize1(tree.left);
            getSize1(tree.right);
            size1++;
        }
    }
    public int getSize2(Tree tree) {
        if (tree != null) {
            getSize2(tree.left);
            getSize2(tree.right);
            return ++ size2;
        }
        return size2;
    }
    public int getSize3(Tree tree) {
        int size = 0;
        if (tree != null) {
            size = 1;
            size += getSize3(tree.left);
            size += getSize3(tree.right);
        }
        return size;
    }
    public int getLeafSize2(Tree tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 1;
        }
        return getLeafSize2(tree.left) + getLeafSize2(tree.right);
    }

}
