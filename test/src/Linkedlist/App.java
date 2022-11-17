package Linkedlist;
import java.util.Scanner;

public class App {
    public static void main(String[] args) { 
        Node<String> head = arrayToLinkedlist(); // Calling arraytolinkedlist function
        printlistRecursion(head); // Print list using recursion function with head parameter
        System.out.println("Len" + length(head)); // print length of initial linked list
        Node<String> nHead = insert(head, "Pass", 3); // calling insertNode function
        printlist(nHead); // print updated linklist 
        System.out.println("Len" + length(nHead)); // print length of updated linked list
        }
    
    // Function to print linkedlist using loop
    public static void printlist(Node<String> head){
        Node<String> pointer = head;   // Node variable to store head node
        while(pointer!= null){         // check head node exist or not
            System.out.print(pointer.data + "-->"); 
            pointer= pointer.next; // point node to next node
        }
    }

    // Function to print linkedlist using recursion
    public static void printlistRecursion(Node<String> head){
        if(head == null){     // stopping condition for recursion
            return;
        }
        System.out.print(head.data + "-->"); 
        printlistRecursion(head.next); // call recursion with next node as parameter
    }

    // Function to insert node in linkedlist at any position
    public static Node<String> insert(Node<String> head, String data, Integer pos){
        int len = length(head); 
        if( pos <= len ){ //check input is right or not
            Node<String> insertNode = new Node<>(data);
            Node<String> Pointer = head;
            int count = 0;
            if(pos == 0){ // Case 1 insert at head
                insertNode.next = head;  // make head next to insert node
                head = insertNode; // update new head
            }
            else{ // other cases 
                while(count <= pos-2){ // reach till the insert position
                    Pointer = Pointer.next; // update pointer node
                    count++; 
                }
                if(Pointer.next == null){ // insert at end of list
                    Pointer.next = insertNode; // connect insertnode to end node
                }
                else{ // Insert in between
                    insertNode.next = Pointer.next; //insert node connect with next to position node
                    Pointer.next = insertNode; // position node connect with insert node
                }
            }

        }else{ // Print warning to user
            System.out.print("Invalid input"); 
        }
        return head; // Return updated head
    }

    // Function to return the length of linkedlist
    public static Integer length(Node<String> head){
        int length = 0;  // variable to store length
        while(head != null){
            length += 1;        // increment on each iteration
            head = head.next;   // update head to next node
        }
        return length;
    }

    // Function to convert an array to linkedlist
    public static Node<String> arrayToLinkedlist(){
        try (Scanner input = new Scanner(System.in)) { // Input an array
            String inpvar = input.next(); // first item of array in variable
            Node<String> Headnode = null;  // Node variable to store head node
            while(!"E".equals(inpvar)){     // array input limit
                Node<String> currentNode = new Node<>(inpvar); // Creation of node
                if(Headnode == null){        // Case 1. create head node(check exist or not)
                    Headnode = currentNode;  // save current node in head node
                }
                else{
                    Node<String> tailNode = Headnode; // pointer variable to head node
                    while (tailNode.next != null){  // check next node exist after or not
                        tailNode = tailNode.next;
                    }
                    tailNode.next = currentNode; // current node connect to pointer next node

                }
                inpvar = input.next(); // assign next item to variable
            } 
            return Headnode; // return head node
        }
    }
}
