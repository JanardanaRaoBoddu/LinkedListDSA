package com.DSA.www;

class Node{
    int value;
    Node next;

    Node(int value){
        this.value=value;
    }
}
public class LinkedList  {
    private Node tail;
    private Node head;
    private int length;


    LinkedList(int value) {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void getTail() {
        System.out.println("Tail: "+tail.value);
    }
    public void getHead() {
        System.out.println("Head: "+head.value);
    }
    public void getLength() {
        System.out.println("Length: "+length);
    }

    public void append(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
        }
        else {
            tail.next=newNode;
        }
        tail=newNode;
        length++;
    }

    public Node removeLast(){
        if(length==0) return  null;
        Node temp=head;
        Node pre=head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;

        }
        length++;
    }

    public Node removeFirst(){
        if (length==0) return null;
        Node temp=head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }

    public Node getNode(int index){
        if(index<0 || index>length) return null;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    public boolean set(int index,int value){
        Node temp=getNode(index);
        if(temp!=null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value){
        if(index<0 || index>length) return false;

        if(index==0) {
            prepend(value);
            return true;
        }

        if (index==length){
            append(value);
            return true;
        }
        Node newNode=new Node(value);
        Node temp=getNode(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index<0 || index>=length) return null;
        if(index==0) return removeFirst();
        if(index==length-1) return removeLast();


        Node pre=getNode(index-1);
        Node temp=pre.next;
        pre.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp=head;
        head=tail;
        tail=temp;

        Node after=temp.next;
        Node before=null;

        for(int i=0;i<length;i++){
            after=temp.next;
            temp.next=before;
            before=temp;
            temp=after;

        }
    }


    public static void main(String[] args) {
        LinkedList myLinkedList=new LinkedList(2);
        myLinkedList.append(3);
       // myLinkedList.prepend(1);
       // myLinkedList.printList();

        //(2)items Return 3 Node
        //System.out.println(myLinkedList.removeLast().value);

        //(1)item Return 2 Node
        // System.out.println(myLinkedList.removeLast().value);

        //(0) items Return Null
        //System.out.println(myLinkedList.removeLast());

        //(2)items return 2 node
        //System.out.println(myLinkedList.removeFirst().value);

        //(1)item return 3 node
        //System.out.println(myLinkedList.removeFirst().value);

        //(0)items return null
       // System.out.println(myLinkedList.removeFirst());

       // myLinkedList.append(4);

       // System.out.println(myLinkedList.getNode(2).value+"\n");
       // System.out.println(myLinkedList.getNode(1).value+"\n");

       // myLinkedList.append(6);
       // myLinkedList.append(6);
        //myLinkedList.append(7);

       // myLinkedList.printList();
      //  System.out.println("********************");
      //  myLinkedList.set(3,5);

       // myLinkedList.printList();

        //System.out.println("********************");

       // myLinkedList.insert(0,1);
       // myLinkedList.insert(2,9);
       // myLinkedList.printList();

        myLinkedList.append(4);
        myLinkedList.append(34);
        myLinkedList.append(23);
        myLinkedList.append(19);

        myLinkedList.printList();

        System.out.println("********************");

       // myLinkedList.remove(4);
        //myLinkedList.printList();

        myLinkedList.reverse();
        myLinkedList.printList();







    }


}
