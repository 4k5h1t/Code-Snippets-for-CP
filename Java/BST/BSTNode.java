public class BSTNode {
    
    int data;
    BSTNode right;
    BSTNode left;
    int count = 1;

    public BSTNode(int d){
        data = d;
        count = 1;
    }

    public BSTNode(){
        count = 1;
    }

    public void insert(int key){

        if(key < data){
            if(left == null)
                left = new BSTNode(key);
            else left.insert(key);
        }
        else if(key == data){
            count ++;
        }
        else{
            if(right == null)
                right = new BSTNode(key);
            else right.insert(key);
        }
    }

    public void inorder(){

        if(left != null)
            left.inorder();
        System.out.print(data + "(" + count + ")" + " ");
        if(right != null)
            right.inorder();
    }

    public boolean search (int key){

        if(key == data)
            return true;
        else if (key < data && left != null)
            return left.search(key);
        else if (key > data && right != null)
            return right.search(key);
        else 
            return false;
    }

    public void preorder(){

        System.out.print(data + "(" + count + ")" + " ");
        if(left != null)
            left.preorder();
        
        if(right != null)
            right.preorder();
    }

    public void postorder(){

        if(left != null)
            left.postorder();
        
        if(right != null)
            right.postorder();
        
        System.out.print(data + "(" + count + ")" + " ");
    }

    public void printCurrentLevel (BSTNode n ,int level)
    {
        if (n == null)
            return;
        if (level == 1)
            System.out.print(n.data + "(" + count + ")" + " ");
        else if (level > 1)
        {
            printCurrentLevel(n.left, level-1);
            printCurrentLevel(n.right, level-1);
        }
    }


    public int findMax(){

        if(right == null)
            return data ;
        else
            right.findMax();
        return 0;
    }

    public int findMin(){

        if(left == null)
            return data ;
        else
            left.findMin();
        return 0;
    }
    
    public BSTNode delete(int id){

        if(data != id){
            if(id > data)
                right = right.delete(id);
            else
                left = left.delete(id);
        }
        else{
            if(left == null)
                return right;
            else if (right == null)
                return left;
            data = right.inOrderSuccessor();
            right = right.delete(data);
        }
        return this;        
    }

    public int inOrderSuccessor() {
        
        return findMin();
    }

}
