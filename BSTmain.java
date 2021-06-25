
public class BSTmain {
    public static void main(String[] args) {
        
        BST b = new BST();
        b.insert(100);
        b.insert(20);
        b.insert(30);
        b.insert(10);
        b.insert(200);
        b.insert(300);
        b.insert(150);
        b.insert(5);
        b.insert(60);
        b.insert(260);
        b.insert(270);  
        System.out.println();
        
        //Question 1
        System.out.println("Is 60 in the tree : " + b.search(60));
        System.out.println("\nInorder Traversal: ");
        b.inorder();
        System.out.println("\n\nPreorder Traversal : " );
        b.preorder();
        System.out.println("\n\nPostorder Traversal : ");
        b.postorder();
        System.out.println("\n\nLevelorder Traversal : ");
        b.levelorder();
        
        //Question 2   
        System.out.println('\n');
        b.displayMax();
        System.out.println();
        b.displayMin();

        System.out.println("\n\nHeight of the tree is : " + b.computeHeight(b.root));

        System.out.println("\n\nDeleting 30 :");
        b.nodeDelete(30);
        System.out.println("\nInorder traversal after deleting 30 : ");
        b.inorder();

        System.out.println('\n');
        b.kLargest(4);

        //Question 3
        b.insert(10);
        System.out.println("\n\nInorder Traversal after inserting duplicate 10: ");
        b.inorder();

        //Question 4
        System.out.println("\n\nChecking if current BT is a BST : " + b.checkBST(b.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
             
    }    
}