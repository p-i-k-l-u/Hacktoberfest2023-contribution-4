import java.util.Scanner;

public class singlyLL2 {

    int size = 0;

    class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addfirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;

        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        }
        Node currNode = head;

        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }


    public void deletefirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Deleted node is " + head.data);
            head = head.next;
        }
    }

    public void deletelast() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        if (head.next == null) {
            System.out.println("Deleted node is " + head.data);
            head = null;
        }

        Node pre = null;
        Node temp = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        System.out.println("Deleted Node is " + temp.data);
        pre.next = null;

    }

    int countNodes() {
        int count = 0;

        Node currNode = head;

        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

//    public void insertpos(int data , int index)
//    {
//        if(index ==0)
//        {
//            addfirst(data);
//            return ;
//        }
//
//        if(index == countNodes())
//        {
//            addLast(data);
//        }
//
//        Node currNode = head;
//
//        for (int i = 1;i<index ; i++)
//        {
//            currNode = currNode.next;
//        }
//
//        Node newNode = new Node(data);
//        currNode.next = newNode;
//
//
//
//    }

    public void insertpos(int data, int pos) {
        Node newNode = new Node(data);
        newNode.data = data;
        newNode.next = null;

        if (pos < 1) {
            System.out.println("Invalid position");
        }
        // first position

        else if (pos == 1) {
            addfirst(data);
            size++;
        } else if (pos == size) {
            addLast(data);
            return;
        } else {
            Node temp = head;
            // traverse till current node (pos -1 )th Node
            while (--pos > 1) {
                temp = temp.next;

            }

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

    }

//    public void deletepos(int pos)
//    {
//        Node temp = head;
//        Node preNode = null;
//
//        if(pos<1 || pos>size)
//        {
//            System.out.println("Invalid position");
//        }
//        // delete first node
//
//        if(pos==1)
//        {
//            deletefirst();
//            return;
//        }
//       while(--pos>0)
//        {
//            preNode = temp;
//            temp = temp.next;
//        }
//       preNode.next = temp.next;
//        System.out.println("Deleted node "+ temp.data);
//        size--;
//
//    }

    public Node getIndex(int index) {
        Node newNode = head;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        return newNode;
    }

    public int deletepos(int pos) {
//        if (size <= 1) {
//            deletefirst();
//        }
//
//        Node secondLast = getIndex(size - 2);
//        int data = tail.data;
//        tail = secondLast;
//        tail.next = null;
//        return data;
        if(pos==0)
        {
             deletefirst();
        }
        if(pos == size-1)
        {
            deletelast();
        }
        Node pre = getIndex(pos -1);
        int data = pre.next.data;

        pre.next = pre.next.next;

        return  data ;

    }



    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("List empty");
            return;
        }
        System.out.println("Singly linked list ");
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

        System.out.println();

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        singlyLL2 list = new singlyLL2();

        while (true)
        {
            System.out.println("1 add node ");
            System.out.println("2 display ");
            System.out.println("3 add first ");
            System.out.println("4 add last ");
            System.out.println("5 delete first");
            System.out.println("6 delete last ");
            System.out.println("7 count Nodes ");
            System.out.println("8 add node in pos");
            System.out.println("9 delete node certain position");

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter the number which you want to store  ");
                    list.addNode(sc.nextInt());
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.println("Enter the number which you want to store :");
                    list.addfirst(sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter the number ");
                    list.addLast(sc.nextInt());
                    break;

                case 5:
                    list.deletefirst();
                    break;

                case 6:
                    list.deletelast();
                    break;

                case 7:
                    System.out.println("Total Nodes are -> " +list.countNodes());

                    break;

                case 8:
                    System.out.println("Enter the possition and data ");

                    list.insertpos(sc.nextInt(),sc.nextInt());
                    break;

                case 9:
                    System.out.println("Enter the posotion where you want to delete:");
                    list.deletepos(sc.nextInt());
                    break;

                default:
                    System.out.println("Invalid input ");
            }



        }

//        list.addNode(1);
//        list.addNode(2);
//        list.addNode(4);
//
//        list.display();


    }


}
