class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public LinkedList push(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    public Node pop() {
        if (this.head == null) return null;
        Node temp = this.head;
        Node pre = this.head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        this.tail = pre;
        this.tail.next = null;
        this.length--;
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }
        return temp;
    }

    public LinkedList unshift(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    public Node shift() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if (this.length == 0) {
            this.tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > this.length) return null;
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

//    public LinkedList set(int index, int value){
//        Node temp = get(index);
//        if(temp != null) get(index).value = value;
//        else return null;
//        return this;
//    }

    public boolean set(int index, int value) {
        Node temp = this.get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index == 0) {
            this.unshift(value);
            return true;
        }
        if (index == this.length) {
            this.push(value);
            return true;
        }
        if (index < 0 || index >= this.length) return false;
        Node newNode = new Node(value);
        Node temp = this.get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
        return true;
    }

    public boolean remove(int index, int value){
        if(index == 0){
            this.shift();
            return true;
        }
        if(index == this.length){
            this.pop();
            return true;
        }
        if (index < 0 || index > this.length) return false;
        Node newNode = new Node(value);
        Node temp = get(index);
        Node before = get(index-1);
        before.next = temp.next;
        temp.next = null;
        this.length--;
        return true;
    }

    public LinkedList reverse(){
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node next = temp.next;
        Node prev = null;
        for(int i = 0; i < this.length; i++){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return this;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}


