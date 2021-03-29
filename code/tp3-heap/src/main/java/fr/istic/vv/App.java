package binaryHeap;

import java.util.Comparator;

/**
* Hello world!
*/
public final class App {
    private App() {
    }
    
    /**
    * Says hello to the world.
    * @param args The arguments of the program.
    */
    public static void main(String[] args) {
        Comparator<Integer> comp = new IntComparator();
        BinaryHeap<Integer> bh = new BinaryHeap<>(comp);
        System.out.println("Hello World!" + bh.count());
    }
    
    
}
