package binaryHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

	List<T> elements;
	Comparator<T> comp;

    public BinaryHeap(Comparator<T> comparator) {
    	this.comp = comparator;
    	this.elements = new ArrayList<T>();

    }

    public T pop() {
    	if(elements.size() == 0) throw new NoSuchElementException("list empty");
        Iterator<T> it = elements.iterator();
        T save = it.next();
        while(it.hasNext()) {
            T tmp = it.next();
            if(comp.compare(save, tmp) > 0) {
                save = tmp;
            }
        }
        elements.remove(save);
    	return save;
    }

    public T peek() {
        if(elements.size() == 0) throw new NoSuchElementException("list empty");
        Iterator<T> it = elements.iterator();
        T save = it.next();
        while(it.hasNext()) {
            T tmp = it.next();
            if(comp.compare(save, tmp) > 0) {
                save = tmp;
            }
        }
        
    	return save;
    }

    public void push(T element) { 
        elements.add(element);
    }

    public int count() {
        return elements.size();
     }

}