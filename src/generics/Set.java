package generics;

import java.util.ArrayList;

public class Set<T extends Identifiable> {
    private ArrayList<T> elements;
    
    public Set() {
        elements = new ArrayList<>();
    }
    
    public void add(T element) {
        if (!peek(element.getID())) {
            elements.add(element);
        }
    }
    
    public T remove(int id) {
        for (int i = 0; i < elements.size(); i++) {
            T element = elements.get(i);
            if (element.getID() == id) {
                elements.remove(i);
                return element;
            }
        }
        return null;
    }
    
    public boolean peek(int id) {
        for (T element : elements) {
            if (element.getID() == id) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return elements.size();
    }
    
    public boolean equals(Set<T> otherSet) {
        if (size() != otherSet.size()) {
            return false;
        }
        for (T element : elements) {
            if (!otherSet.peek(element.getID())) {
                return false;
            }
        }
        return true;
    }
    
    public void display() {
        System.out.print("{ ");
        for (T element : elements) {
            System.out.print(element.getID() + " ");
        }
        System.out.println("}");
    }
}
