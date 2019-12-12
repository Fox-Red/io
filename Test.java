import javax.xml.soap.Node;

public class Test {
    public static void main(String[] args) {
        Tree t1 = new Tree(0);
        Tree t2 = new Tree(1);
        Tree t3 = new Tree(2);
        Tree t4 = new Tree(3);
        Tree t5 = new Tree(4);
        Tree t6 = new Tree(5);
        Tree t7 = new Tree(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t6.right =t7;
        TestTree tt = new TestTree();
//        System.out.println(tt.getLeafSize2(t1));
        System.out.println(tt.getSize2(t1));
    }
}
