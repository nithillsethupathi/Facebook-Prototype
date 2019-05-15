public class Node {
    private Person data;
    private Node next;


    Node(Person data){
        this.data = data;
        this.next = null;
    }
    Node(String node){
        data = new Person(node);
    }
    public Person getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }


}
