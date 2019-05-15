public class MultiplicationHash {

        public int size = 13;
        public LinkedList[] T = {new LinkedList(), new LinkedList(),
                new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(),
                new LinkedList(), new LinkedList(), new LinkedList(), new LinkedList(),
                new LinkedList(), new LinkedList(), new LinkedList()};

        public int hashFunction(Person p){
            double A = (Math.sqrt(5)-1)/2;
            String person = p.toString();
            Main asciiValue = new Main();
            int hashValue = (int) Math.floor(size*(asciiValue.ascii(person)*A%1));
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
        }
}
