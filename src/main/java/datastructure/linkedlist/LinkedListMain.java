package datastructure.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {

        Node n1 = new Node(4, null);
        Node head = new Node(2, n1);
        LinkedList linkedList = new LinkedList(head);
        Node newNode = new Node(19, null);
        Node newNode2 = new Node(24, null);
        linkedList.addNodeLast(newNode);
        linkedList.addNodeLast(newNode2);


        linkedList.printLinkedList();

        System.out.println("#######################");

        linkedList.addNodePosition(13, 0);
        linkedList.addNodePosition(32, 5);

        System.out.println("Adding a Node");
        linkedList.printLinkedList();

        linkedList.deleteNodePosition(4);

        System.out.println("Deleting a Node");
        linkedList.printLinkedList();

        System.out.println("Deleting a Node by key");
        linkedList.deleteByValue(19);
        linkedList.printLinkedList();


        System.out.println("Reverse Linkedlist");
        //linkedList.reverseLinkedList();
        //linkedList.reverseLinkedList2();
        //linkedList.reverseLinkedListUltimate();
        linkedList.reverseLinkedListRecursion(linkedList.head);
        linkedList.printLinkedList();

    }

}

class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void addNodePosition(int data, int position){
        if(isEmpty() || isOutOfRangeAdd(position)){
            System.out.println("Not found");
        }else {
            Node previous = null;
            Node current = head;
            Node next = current.getNextNode();
            Node newNode = new Node(data, null);
            for(int i = 0; i <= position;i++){

                if(i == position){
                    if(previous == null) {
                        addNodeFirst(newNode);
                    } else{
                        previous.setNextNode(newNode);
                        newNode.setNextNode(current);
                    }
                    break;
                } else if(next == null){
                    addNodeLast(newNode);
                    break;
                }
                previous = current;
                current = next;
                next = next.getNextNode();
            }
        }
    }

    public void deleteNodePosition(int position){

        if(isEmpty() || isOutOfRangeDelete(position)){
            System.out.println("Not found");
        }else {

            Node previous = null;
            Node current = head;
            Node next = current.getNextNode();
            for(int i = 0; i <= position; i++){
                if(position == i){
                    if(previous == null){
                        head = next;
                    } else if (next == null){
                        previous.setNextNode(null);
                    } else {
                        previous.setNextNode(next);
                    }
                    break;
                }
                previous = current;
                current = next;
                next = next.getNextNode();
            }
        }
    }


    public void deleteByValue(int value){
        if(isEmpty()){
            System.out.println("Lista vacía");
        }else {

            Node current = head;
            Node next = current.getNextNode();
            if(current.getData() == value){

                if(next != null){
                    head = next;
                }else{
                    head = null;
                }
            }else{
                while(next != null){
                  if(next.getData() == value){
                      Node newNext = next.getNextNode();
                      current.setNextNode(newNext);
                  }
                  current = next;
                  next = next.getNextNode();
                }
            }
        }
    }

    public void reverseLinkedList(){

        Node firstToLast = head;
        Node next = head;
        Node previous = null;
        while(firstToLast.getNextNode() != null) {

            if(next.getNextNode()== null){
                Node prevHead = head;
                head = next;
                next.setNextNode(prevHead);
                if(previous == firstToLast){
                    firstToLast.setNextNode(null);
                }
                previous.setNextNode(null);
            }else {
                previous = next;
                next = next.getNextNode();

            }
        }





    }

    public void reverseLinkedList2(){

        Node firstToLast = head;
        Node next = head;
        Node previous = null;
        while(firstToLast.getNextNode() != null) {
           previous = next;
           next = next.getNextNode();
           if(next.getNextNode() == null){
               previous.setNextNode(null);
               Node temp = head;
               Node prevTemp = null;
               while(true){
                   if(temp == firstToLast){
                       if(prevTemp == null){
                           head = next;
                           head.setNextNode(temp);
                       } else {
                           prevTemp.setNextNode(next);
                           next.setNextNode(firstToLast);

                       }
                       break;
                   } else{
                       prevTemp = temp;
                       temp = temp.getNextNode();
                   }
               }
           }
        }
    }

    public void reverseLinkedListUltimate(){

        // 1 2 3 4 5

        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }


    public Node reverseLinkedListRecursion(Node node){
        if(node == null || node.getNextNode() == null){
            return node;
        }
        // 1 2 3 4 5
        Node reverseLinkedList = reverseLinkedListRecursion(node.getNextNode());
        node.getNextNode().setNextNode(node);
        node.setNextNode(null);
        return reverseLinkedList;

    }


    public boolean isOutOfRangeAdd(int position){
        return position > getSize() || position < 0;
    }

    public boolean isOutOfRangeDelete(int position){
        return position > getSize()-1 || position < 0;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public int getSize(){
        Node current = head;
        int i = 0;

        while (current != null){
            i++;
            current = current.getNextNode();
        }
        return i;
    }

    public void addNodeLast(Node node){
        Node last = getLast();
        last.setNextNode(node);
    }

    public void addNodeFirst(Node node){
       Node second = head;
       head = node;
       head.setNextNode(second);
    }


    public Node getLast(){

        Node last = head;
        if(last == null){
            return null;
        } else {
            while (last.getNextNode() != null){
                last = last.getNextNode();
            }
            return last;
        }

    }

    public void printLinkedList(){

        Node last = head;
        while (last != null){
            System.out.println("nro :"+ last.getData());
            last = last.getNextNode();
        }
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

}