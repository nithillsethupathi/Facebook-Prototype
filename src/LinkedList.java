public class LinkedList{
    public Node current;

    LinkedList() {
        current = null;
    }

    public Node search(Person p){
        Node node = current;
        while(node != null){
            System.out.println(node.getNext());
            System.out.println(p.getName());
            if(node.getData().getName().equals(p.getName())) {
                return node;
            }
            node = node.getNext();
        }
        return node;
    }

    public void add(Person p) {
        Node newNode = new Node(p);
        if (current == null) {
            current = new Node(p);

        } else {
            Node node = current;
            while (node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    public void delete(Person p) {
        Node searchNode = current;
        Node previousNode = null;
        while(searchNode != null){
            if(searchNode.getData().getName().equals(p.getName())) {
                break;
            }
            previousNode = searchNode;
            searchNode = searchNode.getNext();
        } if(searchNode == null){
            return;
        }

        if(previousNode == null){
            current = searchNode.getNext();
            return;
        }
        previousNode.setNext(searchNode.getNext());
        searchNode.setNext(null);
    }

    public boolean contains(Person p){
        Node node = current;
        while(node != null){
            if(node.getData().getName().equals(p.getName())) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
}

