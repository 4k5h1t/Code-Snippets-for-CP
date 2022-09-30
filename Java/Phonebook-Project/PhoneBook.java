
public class PhoneBook {
    
    Contact root;

    public void insert(String fkey, String lkey, String n, String e){
        if (root == null)
            root = new Contact(fkey, lkey, n, e);
        else
            root.insert(fkey, lkey, n, e);
    }

    public void Display(){

        if (root == null)
            return;
        else
            root.inorder();
    }

    public void Search (String key){

        if (root == null)
            System.out.println("\nEmpty Phonebook");
        else
            root.search(key, false);
    }

    public void DisplayFirst(){
        root.findMin().DispNode();
    }


    public void DisplayLast(){
        root.findMax().DispNode();
    }

}