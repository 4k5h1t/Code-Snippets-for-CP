public class Contact {
    
    String fname;
    String lname;
    String number;
    String email;
    Contact right;
    Contact left;

    public Contact(String f, String l, String n, String e){
        fname = f;
        lname = l;
        number = n;
        email = e;
    }

    public void DispNode(){
        System.out.println("\nName \t\t: " + fname + " " + lname);
        System.out.println("Phone Number(s) : " + number);
        System.out.println("E-mail ID(s) \t: " + email + '\n');
    }

    public void insert(String fkey, String lkey, String n, String e){

        if(fkey.compareToIgnoreCase(fname) < 0){
            if(left == null)
                left = new Contact(fkey, lkey, n, e);
            else left.insert(fkey, lkey, n, e);
        }
        else if (fkey.equalsIgnoreCase(fname) && lkey.compareToIgnoreCase(lname) < 0){
            if(left == null)
                left = new Contact(fkey, lkey, n, e);
            else left.insert(fkey, lkey, n, e);
        }
        else if(fkey.equalsIgnoreCase(fname) && lkey.equalsIgnoreCase(lname)){
            if(!n.equalsIgnoreCase(number)){
                number += " | " + n; 
            }
            if(!e.equalsIgnoreCase(email)){
                email += " | " + e; 
            }
            if(n.equalsIgnoreCase(number) && e.equalsIgnoreCase(email)){
                System.out.println("This contact already exists");
            }
        }
        else{
            if(right == null)
                right = new Contact(fkey, lkey, n, e);
            else right.insert(fkey, lkey, n, e);
        }
    }

    public void inorder(){

        if(left != null)
            left.inorder();
        this.DispNode();
        if(right != null)
            right.inorder();
    }

    public void search (String key, boolean found){

        if(key.equalsIgnoreCase(fname)){
            this.DispNode();
            if(left != null)
                left.search(key, true);
            if(right != null)
                right.search(key, true);

        }
        else if (key.compareToIgnoreCase(fname) < 0 && left != null)
            left.search(key, found);
        else if (key.compareToIgnoreCase(fname) > 0 && right != null)
            right.search(key, found);
        else if (found == false)
            System.out.println("No contacts hold the given name... ");
        else System.out.print("");
    }


    public Contact findMax(){

        if(right != null)
            return right.findMax();      
        else{
            return this;
        }
    }

    public Contact findMin(){

        if(left != null)
            return left.findMin();    
        else{
            return this ;
        }
    }

}