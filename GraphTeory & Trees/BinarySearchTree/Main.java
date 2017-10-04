public class Main {
    public static void main(String args[])
    {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert( 30);
        tree.insert( 20);
        tree.insert( 40);
        tree.insert( 70);
        tree.insert( 60);
        tree.insert(80);


        System.out.println("Inorder traversal of the given tree : ");
        tree.inorder();
        System.out.print("\n\n");


        System.out.println("Postorder traversal of the given tree : ");
        tree.postorder();
        System.out.print("\n\n");

        
        System.out.println("Preorder traversal of the given tree : ");
        tree.preorder();
    }
}
