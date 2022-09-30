
public class BST {
    
    BSTNode root;
    

    public void insert(int key){
        if (root == null)
            root = new BSTNode(key);
        else
            root.insert(key);
    }

    public void inorder(){

        if (root == null)
            return;
        else
            root.inorder();
    }

    public boolean search (int key){

        if (root == null)
            return false;
        else
            return root.search(key);
    }

    public void preorder(){

        if(root == null)
            return;
        else
            root.preorder();
    }

    public void postorder(){

        if(root == null)
            return;
        else
            root.postorder();
    }

    public void levelorder(){

        if(root == null)
            return;
        else{
        int i;
        for (i = 1; i <= computeHeight(root); i++)
            root.printCurrentLevel(root, i);
        }
    }

    public void displayMax(){

        if(root == null)
            return;
        else
            System.out.println("Maximum is " + root.findMax());
    }

    public void displayMin(){

        if(root == null)
            return;
        else
            System.out.println("Minimum is " + root.findMin());
    }

    public int max(int x, int y){
        if(x >= y)
            return x;
        else 
            return y;
    }

    public int computeHeight(BSTNode node){
        
        if(node == null)
            return 0;
        else    
            return max(computeHeight(node.right), computeHeight(node.left)) + 1;
    }

    public void nodeDelete(int data){

        if(root == null)
            return;
        else 
            root.delete(data);
        return;
    }

    public class count{
        int c = 0;
    }

    public void kLargest(int k){
        count C = new count();
        this.findKLargest(this.root, k, C);
    }

    public void findKLargest(BSTNode n, int k, count C){
        
        if(n == null || C.c >= k)
            return ;

        this.findKLargest(n.right, k, C);  // Found Largest
        C.c += 1;

        if(C.c == k)
            System.out.println(k + "th largest element is " + n.data);

        this.findKLargest(n.left, k, C);

    }

    public boolean checkBST(BSTNode root, int min, int max){

        if(root != null){
            if(root.data > max || root.data < min){
                return false;
            }
            return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
        }

        return true;
    }
}