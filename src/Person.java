public class Person {

    private String name;
    private LinkedList friends = new LinkedList();
    Person(String name){
        this.name = name;

    }

    public void addFriend(Person p){

        if(!friends.contains(p)) {
            friends.add(p);
        }
        System.out.println(name);
    }

    public void unFriend(Person p){
        if(friends.contains(p)){
            friends.delete(p);
        }
    }

    public String getName() {
        return name;
    }

    public LinkedList getFriends() {
        return friends;
    }
}
