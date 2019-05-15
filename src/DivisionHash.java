public class DivisionHash {
        public int size = 13;
        public LinkedList[] T = {new LinkedList(), new LinkedList(),
        new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(),
                new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(),
                new LinkedList(), new LinkedList(), new LinkedList()};

        public int hashFunction(Person p){
            String person = p.toString();
            Main asciiValue = new Main();
            int hashValue = (int) Math.floor(asciiValue.ascii(person)%size);
            return hashValue;
        }

        public void ChainedHashInsert(Person p){
            T[hashFunction(p)].add(p);
        }

        public Person ChainedHashSearch(Person p){
            return T[hashFunction(p)].search(p).getData();
        }
        public void ChainedHashDelete(Person p){
            T[hashFunction(p)].delete(p);
            for (int i = 0; i < size; i++) {
                Node node = T[i].current;
                while (node != null) {
                    node.getData().unFriend(p);
                    node = node.getNext();
                }
            }
        }
}
