/**
 * DSA_Lab2_Q1
 */

import java.util.Scanner;
//import java.util.ArrayList;

public class Stack_ADT_Assignment {

    public static class stack{
        
        int arr[];
        int top = -1;
        int size;
        stack(int size){
            arr = new int[size];
            this.size = size;
        }

        boolean isEmpty(){
            if(top == -1){
                return true;
            }
            else{
                return false;
            }
        }

        void push(int item){

            if(top >= size-1){
                System.out.println("Stack Overflow");
            }
            else{
                top += 1;
                arr[top] = item;
            }
        }

        int peek(){
            return arr[top];
        }

        int pop(){

            if(isEmpty()){
                return -1;
            }
            else{
                int x = arr[top];
                top -= 1;
                return x;
            }
        }
    }

    public static void revStack(stack s, stack rev){
        
        if(s.isEmpty()){
            return;
        }
        else{
            int x = s.pop();
            rev.push(x);
            revStack(s, rev);
            
            s.push(x);
        }
    }

    static int max = 0;
    public static int max(stack s){
        
        
        if(s.isEmpty()){
            return -1;
        }
        else{
            
            int x = s.pop();
            if(x > max){
                max = x;
            }
            max(s);
            s.push(x);
            
        }

        return max;
    }   

    static double min = Double.POSITIVE_INFINITY;
    public static int getminElement(stack s){

        if(s.isEmpty()){
            return -1;
        }
        else{
            
            int x = s.pop();
            if(x < min){
                min = x;
            }
            getminElement(s);
            s.push(x);
            
        }

        return (int)min;
    }

    public static stack copyStack(stack s){

        stack copy = s;
        /*ArrayList <Integer> arr = new ArrayList <Integer>();
        

        if(s.isEmpty()){
            return copy;
        }
        else{

            int x = s.pop();
            arr.add(x);
            copyStack(s);

            s.push(x);

        }

        System.out.println(arr);

        for(int i = s.size - 1; i >= 0; i--){
            copy.push(arr.get(i));
        }*/

        return copy;
    }

    public static void printStack(stack s){

        if(s.isEmpty()){
            return;
        }
        else{
            int x = s.pop();
            System.out.print(x + " ");
            printStack(s);

            s.push(x);
        }
    }


    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        System.out.println("\nThis is a Stack ADT implementation..\n");
        
        System.out.print("\nEnter Stack Size: ");
        int size = cin.nextInt();
        stack s1 = new stack(size);

        for(int i = 0; i < size; i++){
            System.out.print("\nEnter next element: ");
            s1.push(cin.nextInt());
        }

        System.out.println("\nPrinting current Stack: ");
        printStack(s1);

        System.out.print("\n\nMaximum in the stack is: " + max(s1)) ;

        System.out.print("\n\nMinimum in the stack is: " + getminElement(s1));

        System.out.print("\n\nFirst pop gives " + s1.pop());

        System.out.println("\n\nPrinting current Stack: ");
        printStack(s1);

        System.out.println("\n\nPrinting copy stack :");
        printStack(copyStack(s1));        

        System.out.println("\n\nReversing Stack...");
        stack rev = new stack(s1.size);
        revStack(s1, rev);
        
        System.out.println("\nPrinting reversed Stack: ");
        printStack(rev);

        System.out.println('\n');

        cin.close();
    }
}