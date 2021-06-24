import java.util.Scanner;

public class QueueADT {

    public static class Queue{

        int head ;
        int tail ;
        int[] arr;
        int size;

        public Queue(int size){

            head = -1;
            tail = -1;
            arr = new int[size];
            this.size = size;

        }

        boolean isEmpty(){
            if (head == -1 && tail == -1)
                return true;
            else
                return false;
        }

        void enq(int element){
            
            if(tail == size - 1){
                System.out.println("Queue is full..");
            }
            else if(isEmpty()){
                head = 0;
                tail = 0;
                arr[tail] = element;
            }
            else{
                tail += 1;
                arr[tail] = element;
            }
        }

        int deq(){

            int x;

            if(isEmpty()){
                System.out.println("Queue is Empty...");
                return -1;
            }

            else if(head == tail){
                x = arr[head];
                head = -1;
                tail = -1;
            }
            else{
                x = arr[head];
                head += 1;
            }

            return x;
            
        }

        int getFront(){

            if(isEmpty()){
                System.out.println("Queue is Empty..");
                return -1;
            }
            else{
                return arr[head];
            }
        }

        void revQ(){
            if(isEmpty()){
                return;
            }
    
            int d = deq();
            
            revQ();
            enq(d);
        }

        static int min = Integer.MAX_VALUE;

        int getminElement(){
    
            Queue temp = new Queue(size);
               
            while(isEmpty()){
                int d = deq();
                temp.enq(d);
            }
              
            while(!temp.isEmpty()){
                
                int k = temp.deq();
                if(k < min){
                    min = k;
                }
                enq(k);
            }
    
            return min;
        }
    

        
        void printQ(){

            System.out.println("\nHead --> Tail");

            int[] temp = new int[size];
            int counter = 0;
            
            while(!isEmpty()){
                int d = deq();
                temp[counter] = d;
                counter ++;
            }
            
            for(int i = 0; i < counter; i++ ){
                System.out.print(temp[i] + " ");
                enq(temp[i]);
            }
        }

    }

    public static class circQ extends Queue{

        public circQ(int size) {
            super(size);
        }

        void enq(int element) {

            if((tail + 1) % size == head ){
                System.out.println("Queue is full..");
                return;
            }

            else if(isEmpty()){
                head = tail = 0;
                arr[tail] = element;
            }

            else{
                tail = (tail+1) % size;
                arr[tail] = element;
            }

            
            
        }
        
        int deq(){

            int x;

            if(isEmpty()){
                System.out.println("Queue is Empty...");
                return -1;
            }

            else if(head == tail){
                x = arr[head];
                head = -1;
                tail = -1;
            }

            else{
                x = arr[head];
                head = (head+1) % size;
            }
            
            return x;
            
        }

        void splitQ(){

            circQ even = new circQ(size/2 + 1);
            circQ odd = new circQ(size/2 + 1);
            circQ temp = new circQ(size);

            for(int i = 0; i < size; i++){

                int k = deq();
                if(i % 2 == 0){
                    even.enq(k);
                }
                else{
                    odd.enq(k);
                }
                temp.enq(k);
            }        

            while(!temp.isEmpty()){
                enq(temp.deq());
            }

            System.out.print("\nEven Circular Queue : ");
            even.printQ();
            System.out.print("\nOdd Circular Queue : ");
            odd.printQ();
        }

        static int min = Integer.MAX_VALUE;

        int getminElement(){
    
            Queue temp = new Queue(size);
               
            while(!isEmpty()){
                int d = deq();
                temp.enq(d);
            }
              
            while(!temp.isEmpty()){
                
                int k = temp.deq();
                if(k < min){
                    min = k;
                }
                enq(k);
            }
    
            return min;
        }

        void printQ(){

            int i;
            if (isEmpty()) {
                System.out.println("Empty Queue");
            } 
            
            else {
                System.out.println("\nHead --> Tail");

                for (i = head; i != tail; i = (i + 1) % size){
                    System.out.print(arr[i] + " ");
                }
                System.out.println(arr[i]);
            }
        }

    }

    public static boolean equals(Queue q1, Queue q2){

        if(q1.size != q2.size){
            return false;
        }

        Queue temp1 = new Queue(q1.size);
        Queue temp2 = new Queue(q2.size);

        while(!q1.isEmpty()){
            
            int d1 = q1.deq();
            int d2 = q2.deq();
            if(d1 != d2){
                return false;
            }

            temp1.enq(d1);
            temp2.enq(d2);
        }

        while(!temp1.isEmpty()){
            q1.enq(temp1.deq());
            q2.enq(temp2.deq());
        }

        return true;

    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
 
        System.out.println("\nThis is a Circular Queue ADT...\n");
        System.out.print("Enter size of the queue : ");
        
        int size1 = cin.nextInt();
        circQ q1 = new circQ(size1);

        for(int i = 0; i < size1; i++){
            System.out.print("\nEnter next Element : ");
            q1.enq(cin.nextInt());
        }

        q1.printQ();

        System.out.println("Splitting Queue ");
        q1.splitQ();

        System.out.println("\n\nThe minimum element is " + q1.getminElement());

        q1.printQ();
               
        cin.close();
        
    }

}