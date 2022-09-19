package datastructures;

public class LinkedListMain {

    public static void main(String[] args) {

        Node n1 = new Node(4, null);
        Node head = new Node(2, n1);
        LinkedList linkedList = new LinkedList(head);
        Node newNode = new Node(19, null);
        Node newNode2 = new Node(24, null);
        linkedList.addNodeLast(newNode);
        linkedList.addNodeLast(newNode2);
        Node newNode3 = new Node(17, null);


        linkedList.printLinkedList();

        System.out.println("#######################");

        linkedList.addNodePosition(newNode3, 0);

        linkedList.printLinkedList();
    }

}

class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public void addNodePosition(Node node, int position){
        if(isEmpty() || position > getSize()){
            System.out.println("Not found");
        }else {
            Node previous = null;
            Node current = head;
            Node next = current.nextNode;

            for(int i = 0; i <= position;i++){

                if(i == position){
                    if(previous == null) {
                        addNodeFirst(node);
                    } else{
                        previous.setNextNode(node);
                        node.setNextNode(current);
                    }
                    break;
                } else if(next == null){
                    addNodeLast(node);
                    break;
                }
                previous = current;
                current = next;
                next = next.getNextNode();
            }
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getSize(){
        Node current = head;
        int i = 0;

        while (current != null){
            i++;
            current = current.nextNode;
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
       head.nextNode = second;
    }


    public Node getLast(){

        Node last = head;
        while (last != null){
            if(last.nextNode == null){
                break;
            }
            last = last.nextNode;
        }

        return last;
    }

    public void printLinkedList(){

        Node last = head;
        while (last != null){
            System.out.println("nro :"+ last.data);
            last = last.nextNode;
        }
    }
}

class Node {
    int data;
    Node nextNode;

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
}