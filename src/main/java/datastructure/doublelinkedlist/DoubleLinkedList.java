package datastructure.doublelinkedlist;


public class DoubleLinkedList {

    public static void main(String[] args) {
       try{
           NodeD head = new NodeD(69, null, null);

           DLinkedList dLinkedList = new DLinkedList(head);

           System.out.println("list size "+ dLinkedList.getSize());
           NodeD newNode0 = new NodeD(21, null, null);
           dLinkedList.addNewHeadNode(newNode0);

           dLinkedList.printLinkedList();

       }catch(RuntimeException exception){
           System.out.println(exception.getMessage());
       }



    }
}


class DLinkedList {
    NodeD head;

    public DLinkedList() {
    }
    public DLinkedList(NodeD head) {
        this.head = head;
    }
    public void printLinkedList(){
        System.out.println("printLinkedList inicio :");
        validateEmpty();
        NodeD current = head;
        int cont = 0;
        while(current != null){
            System.out.println("Node "+ cont +"  "+ current.getData());
            current = current.getNext();
            cont++;
        }
    }
    public void addNewHeadNode(NodeD newHeadNode){
        System.out.println("addNewHeadNode :"+ newHeadNode);
        validateEmpty();
        NodeD second = head;
        head = newHeadNode;
        second.setPrevious(newHeadNode);
        head.setNext(second);
        System.out.println("addNewHeadNode :"+ getSize());
    }
    public int getSize(){
        validateEmpty();
        NodeD pointer = head;
        int counter = 1;
        while(pointer.getNext() != null){
            counter++;
            pointer = pointer.getNext();
        }
        return counter;
    }

    public void validateEmpty(){
        if(head == null) throw new RuntimeException("Empty list");
    }


}




class NodeD {
    private int data;
    private NodeD previous;
    private NodeD next;

    public NodeD(int data, NodeD previous, NodeD next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeD getPrevious() {
        return previous;
    }

    public void setPrevious(NodeD previous) {
        this.previous = previous;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }
}