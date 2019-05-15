import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Liam", "Noah", "William", "James", "Logan", "Benjamin", "Mason",
                "Elijah", "Oliver", "Jacob", "Lucas", "Michael", "Alexander", "Ethan", "Daniel", "Matthew",
                "Aiden", "Henry", "Joseph", "Jackson", "Samuel", "Sebastian", "David", "Carter", "Wyatt",
                "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Mia", "Charlotte", "Amelia", "Evelyn", "Abigail",
                "Harper", "Emily", "Elizabeth", "Avery", "Sofia", "Ella", "Madison", "Scarlett", "Victoria", "Aria",
                "Grace", "Chloe", "Camila", "Penelope", "Riley"};
        DivisionHash hash = new DivisionHash();
        MultiplicationHash hashMulti = new MultiplicationHash();
        for(int i = 0; i < names.length; i++) {
           Person p = new Person(names[i]);
           hash.ChainedHashInsert(p);
           hashMulti.ChainedHashInsert(p);
        }
        //System.out.println(hash.ChainedHashSearch(new Person("Grace")));
        System.out.println("Multiplication Method");
        for (int i = 0; i < hashMulti.size; i++) {
            System.out.print("\n" + i + " -> ");
            Node node = hashMulti.T[i].current;
            while (node != null) {
                System.out.print(node.getData().getName() + " -> ");
                node = node.getNext();
            }
        }
        System.out.println(System.lineSeparator());
        System.out.println("Division Method");
        for (int i = 0; i < hash.size; i++) {
            System.out.print("\n" + i + " -> ");
            Node node = hash.T[i].current;
            while (node != null) {
                System.out.print(node.getData().getName() + " -> ");
                node = node.getNext();
            }
        }
        System.out.println(System.lineSeparator());
        Scanner scan = new Scanner(System.in);
        int count = 0;
        while(count != 7){
            System.out.println("Select one number from the options given: \n1) Create a person record of the specified name.\n2) Record a person as a new friend.\n3) Remove a person from the Table of friends, and all the friend list\n4) Remove a person from the friend list of a particular person.\n5) Search a person’s name to list his/her friend list.\n6) Enter two person’s names to check whether the two people are friends.\n7) Exit");
            count = scan.nextInt();
            switch (count){
                case 1:{
                    System.out.println("Enter the name to create a record:\t");
                    String name = scan.next();
                    hash.ChainedHashInsert(new Person(name));
                    break;
                }

                case 2:{
                    System.out.println("New person to be added as a friend:\t");
                    String friend = scan.next();
                    System.out.println("Name of person:\t");
                    String friend1 = scan.next();
                    Person p = new Person(friend);
                    Person p1 = new Person(friend1);
                    if (p == null) {
                        if (p1 == null) {
                            p = new Person(friend);
                            p1 = new Person(friend1);
                            p.addFriend(p1);
                            hash.ChainedHashInsert(p);
                            hash.ChainedHashInsert(p1);
                        }
                    } else if (p1 == null) {
                        p1 = new Person(friend1);
                        hash.ChainedHashInsert(p1);
                        p.addFriend(p1);
                    } else {
                        p.addFriend(p1);
                    }
                    break;
                }

                case 3:{
                    System.out.println("Name of person to delete:\t");
                    String friend = scan.next();
                    Person p = new Person(friend);
                    hash.ChainedHashDelete(p);
                    break;
                }
                case 4:{
                    System.out.println("Name of friend 1:\t");
                    String friend = scan.next();
                    System.out.println("Person to be removed from the list:\t");
                    String friend1 = scan.next();
                    Person p = hash.ChainedHashSearch(new Person(friend));
                    Person p1 = hash.ChainedHashSearch(new Person(friend1));
                    p.unFriend(p1);
                    break;
                }

                case 5:{
                    System.out.println("Name of the person, who's friends you wanna display:\t");
                    String friend = scan.next();
                    Person p = hash.ChainedHashSearch(new Person(friend));
                    p.getFriends();
                    break;
                }

                case 6:{
                    System.out.println("Person 1:\n");
                    String name = scan.next();
                    System.out.println("Person 2:\n");
                    String name1 = scan.next();
                    Person p = hash.ChainedHashSearch(new Person(name));
                    Person p1 = hash.ChainedHashSearch(new Person(name1));
                    if(p.getFriends().contains(p1)){
                        System.out.println("Person 1 and Person 2 are friends");
                    } else{
                        System.out.println("Person 1 and Person 2 are not friends");
                    }
                    break;
                }
                case 7:
                    System.out.println("HashTable\n\n" + hash.toString());
                    break;
            }
        }
    }

    public int ascii(String name) {
        String output = name;
        int length = output.length();
        char input;
        int powLength = length - 1;
        int ascii = 0;
        for (int i = 0; i < length; i++) {
            input = output.charAt(i);
            ascii += (int) input;
            powLength--;
        }
        return ascii;
    }

}
