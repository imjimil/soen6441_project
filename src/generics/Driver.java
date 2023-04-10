package generics;

class Disciplines implements Identifiable {
    private int id;
    private String name;
    
    public Disciplines(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}

public class Driver {
    public static void main(String[] args) {

        Set<Disciplines> set1 = new Set<>();
        Set<Disciplines> set2 = new Set<>();
        
        set1.add(new Disciplines(1, "CS"));
        set1.add(new Disciplines(2, "SE"));
        set1.add(new Disciplines(3, "ME"));
        
        set2.add(new Disciplines(1, "EE"));
        set2.add(new Disciplines(2, "IE"));
        set2.add(new Disciplines(3, "IT"));
        
        System.out.println(set1.equals(set2)); // true because all ids are same
        
        set2.add(new Disciplines(4, "Dave")); 
        
        System.out.println(set1.equals(set2)); // false because set2>set1
        
        System.out.print("set1- "); 
        set1.display(); // {1,2,3}
        System.out.print("set2- "); 
        set2.display(); // {1,2,3,4}   

        System.out.println(set1.peek(2)); //true
        Disciplines removedPerson = set1.remove(2);
        set1.display(); // {1,3}

        System.out.println(set1.peek(2)); //false because it is removed.
    }
}
