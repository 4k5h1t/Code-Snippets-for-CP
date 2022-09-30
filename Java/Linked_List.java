public class Linked_List {
    
    public static class node{
        int data;
        node next;

        node(){
            next = null;
        }
        node(int i){
            this.data = i;
            this.next = null;
        }
    }

    public static class linked_list{
        
        node head;
        node tail;

        public void insert_at_head(int i){

            node newNode = new node(i);
            if(head == null){
                tail = newNode;
                head = newNode;
            }
            else{
                newNode.next = head;
                head = newNode;
            }
        }

        public void traversal(){

            if(head == null){
                System.out.println("Empty");
            }
            else{
                node temp = head;
                while (temp != null){
                    System.out.println(temp.data);
                    temp = temp.next;
                }
            }
        }

        public int findSum(){
            int ans = 0;
            if(head == null){
                System.out.println("Empty");
            }
            else{
                node temp = head;
                while (temp != null){
                    ans += temp.data;
                    temp = temp.next;
                }
            }
            return ans;
        }

        public void search(int item){
            int pos = 0;
            if(head == null){
                System.out.println("Empty");
            }
            else{
                node temp = head;
                while (temp != null){
                    pos += 1;
                    if(temp.data == item){
                        System.out.println("\nItem found at : " + pos);
                    }
                    temp = temp.next;
                }
            }
        }

        public node findmid(){

            node slowptr = head;
            node fastptr = head;
            while(fastptr != null){
                fastptr = fastptr.next;
                if(fastptr !=  null){
                    fastptr = fastptr.next;
                }
                else break;
                slowptr = slowptr.next;
            }
            return slowptr;
        }

        public node findn(int pos){
            node temp = head;
            for (int i = 1; i < pos; i++){
                temp = temp.next;
            }
            return temp;
        }

        public int findDup(int item){
            node temp = head;
            int counter = 0;
            while(temp != null){
                if (temp.data == item){
                    counter += 1;    
                }
                temp = temp.next;
            }
            return counter;
        }
        
        public void insert_at_tail(int data){
            node newNode = new node(data);
            if(head == null){
                tail = newNode;
                head = newNode;
            }
            else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        public void insert_at_pos(int data, int pos){

            node temp = head;
            node newNode = new node(data);
            for(int i = 1; i < pos -1; i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        public void delete_item(int item){
            node temp = head;
            node behind = head;
            while(temp != null){
                if(temp.data == item){
                    behind.next = temp.next;
                }

                if(temp == head){
                    temp = temp.next;
                }
                else{
                    temp = temp.next;
                    behind = behind.next;
                }
            }
        }

        public void delete_pos(int pos){
            node behind = head;
            for(int i = 1; i < pos - 2; i++){
                behind = behind.next;
            }
            node temp = behind.next;
            behind.next = temp.next;
        }

        public void delete_head(){
            head = head.next;
        }

        public void change(int oitem, int nitem){

            System.out.println("Changing " + oitem + " into " + nitem);
            node temp = head;
            while (temp != null){
                if(temp.data == oitem){
                    temp.data = nitem;
                }
                temp = temp.next;
            }
        }

        public void displaceLarge(){
            node temp = head;
            int max = temp.data;
            while (temp != null){
                if(max < temp.data){
                    max = temp.data;
                }
                temp = temp.next;
            }
        
            delete_item(max);
            insert_at_tail(max);
            
        }

        public void delete_evens(){
            node temp = head;
            node behind = head;
            while(temp != null){
                if(temp.data % 2  == 0){
                    behind.next = temp.next;
                }
                if(temp == head){
                    temp = temp.next;
                }
                else{
                    temp = temp.next;
                    behind = behind.next;
                }
            }
        }

    }

    public static class stack{
        
        linked_list stack = new linked_list();

        void push(int i){
            stack.insert_at_head(i);       
        }

        int pop(){
            int result = stack.head.data;
            stack.delete_head();
            return result;
        }

        int peek(){
            return stack.head.data;
        }

        boolean isEmpty(){
            return stack.head == null;
        }

        void printStack(){
            stack.traversal();
        }

    }

    public static class queue{

        linked_list queue = new linked_list();

        void enqueue(int i){
            queue.insert_at_tail(i);       
        }

        int dequeue(){
            int result = queue.head.data;
            queue.delete_head();
            return result;
        }

        int peek(){
            return queue.head.data;
        }

        boolean isEmpty(){
            return queue.head == null;
        }

        void printStack(){
            queue.traversal();
        }        
    }

    public static linked_list revLL(linked_list l){
        linked_list rl = new linked_list();
        node temp = l.head;
        
        while(temp != null){
            rl.insert_at_head(temp.data);
            temp = temp.next;
        }
        return rl;

    }

    public static linked_list concatLL (linked_list l1, linked_list l2){
        linked_list newll = new linked_list();
        node temp = l1.head;
        while(temp != null){
            newll.insert_at_tail(temp.data);
            temp = temp.next;
        }
        linked_list l = newll ;
        newll.tail.next = l2.head;
        l.head = newll.head;
        l.tail = l2.tail;
        return l;
    }

    public static void splitLL(linked_list l){
        linked_list el = new linked_list();
        linked_list ol = new linked_list();

        node temp = l.head;
        int counter = 0;
        while(temp != null){
            if(counter % 2 == 0){
                el.insert_at_tail(temp.data);
            }
            else{
                ol.insert_at_tail(temp.data);
            }
            temp = temp.next;
            counter++;
        }

        System.out.println("\nEven list is \n");
        el.traversal();
        System.out.println("\nOdd list is \n");
        ol.traversal();

    }


    public static void main(String[] args) {
        
        
        queue s = new queue();
        System.out.println("\nEnqueuing 20, 30, 40, 55, 67\n");
        s.enqueue(20);
        s.enqueue(30);
        s.enqueue(40);
        s.enqueue(55);
        s.enqueue(67);
        s.printStack();
        System.out.println("\nDequeuing twice..");
        s.dequeue();
        s.dequeue();
        s.printStack();


    }
}
