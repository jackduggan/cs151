
import java.util.AbstractList;

/**
 * I have adhered to the honor code on this assignment
 * This is the MyArrayList class designed to imitate the characteristics of an actual ArrayList
 * @author jackbenson
 */

public class MyArrayList<AnyType> extends AbstractList<AnyType> {

    private int size;
    private AnyType[] data;

    /**
     * @param startSize The size of the array that the user specifies
     */

    @SuppressWarnings("unchecked")
    public MyArrayList(int startSize) {
        size = 0;
        int x = 1;
        while (x < startSize) {
            x *= 2;
        }
        data = (AnyType[]) new Object[x];

    }

    public MyArrayList() { this(2); }

    /**
     * Resize method re-sizes MyArrayList by multiplying the capacity of the list by two
     */

    private void resize(){
        AnyType[] newList = (AnyType[]) new Object [data.length *2];
        int i;
        for (i = 0; i < data.length; i++) {
            newList[i] = data[i];
        }
        data = newList;
    }

    /**
     *
     * @param index The value at the index of MyArrayList that the user wants to get
     * @return this returns the value at index
     *
     */

    public AnyType get(int index) {
        if (index > size) throw new IndexOutOfBoundsException("Too big, my friend");
        return data[index];
    }

    /**
     * @return the count of elements in the
     */

    public int size() { return size; }

    /**
     * This shifts the indices of MyArrayList right
     * @param index
     */

    private void shiftRight (int index){
        for(int i = size; i > index; i--){
            data[i] = data[i-1];
        }
    }

    /**
     * @param element adds a specified element to the end of MyArrayList
     * @return Return true if the element was added
     */

    public boolean add(AnyType element){
        this.add(size, element);
        return true;
    }

    /**
     * @param index index of MyArrayList the user wants to change
     * @param element value that the user would like at that index
     * @return returns the previous value
     */

    public AnyType set(int index, AnyType element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Nice try, think smaller.");
        }
        AnyType result = data[index];
        data[index] = element;
        return result;
    }

    /**
     * @param index Remove the item at the specified index, shifting all other elements to the left.
     * @return the value that was removed
     */

    public AnyType remove(int index){
        if (size == data.length) {
            this.resize();
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Nice try, think smaller.");
        }
        AnyType result = data[index];
        for (int i = index; i < size; i++) data[i] = data[i + 1];
        size --;
        return result;
    }

    /**
     * @return Return true if there are no items stored, false otherwise.
     */

    public boolean isEmpty() {
        if ( size == 0 ) return true;
        return false;
    }

    /**
     * Empty out the list.
     */

    public void clear() { for (int i = 0; i < data.length; i++) data[i] = null;}

    /**
     * @param index Adds the element at the specified index, shifting everything else right one space.
     * @param element element that the user specifies.
     */

    public void add(int index, AnyType element) {
        if (size == data.length) {
            this.resize();

        }if (index > size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds! You tried to get" +
                    index + "but the size is" + size);

        }else if (data[index] == null){
            data[index] = element;
            size ++;

        }else if(data[index] != null){
            this.shiftRight(index);
            data[index] = element;
            size++;
        }


    }

}