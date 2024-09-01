public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(7);

        linkedList.push(4);
        System.out.println(linkedList);

//        linkedList.pop();
//        System.out.println(linkedList);

        linkedList.unshift(11);
        System.out.println(linkedList);

//        linkedList.shift();
//        System.out.println(linkedList);

//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.get(10));
//        System.out.println(linkedList.get(-1));

//        System.out.println(linkedList.set(2,13));
//        System.out.println(linkedList.set(-2,13));

//        linkedList.set(2,13);
//        System.out.println(linkedList);
//        linkedList.set(-10,14);
//        System.out.println(linkedList);

        System.out.println(linkedList.reverse());
    }
}
