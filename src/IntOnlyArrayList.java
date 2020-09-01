public class IntOnlyArrayList {
    private int[] array;
    private int size;

    //Constructor
    public IntOnlyArrayList() {
        array = new int[2];
        size = 0;
    }

    //Adds to end of list
    public void add(int value) {
        //check if array is big enough
        checkArrayIncrease();
        array[size()] = value; //size will always +1 of our last index, so we just add the next element there
        size++;
    }

    //Adds at designated index
    public void add(int index, int value) {
        if (index > size() || index < 0) {          //man kunne sige index >= size(), men ved kun at sige > så kan vi også tilføje til slutningen af listen.
            throw new IndexOutOfBoundsException();
        } else {
            //check array length
            checkArrayIncrease();
            for (int i = size; i > index; i--) {
                //We start shuffling the elements in the end of the list
                array[i] = array[i - 1];
                //if next is index, assign value
                if (i - 1 == index) {
                    array[i - 1] = value;
                }
            }
        }
        size++;
    }

    //Returns value of index
    public int get(int index) {
        //checks that our index isn't out of bounds
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

    //removes from index, shuffling everything into place
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < size ; i++) {
                    array[i] = array[i+1];
            }
        }
    size--;
    checkArrayDecrease();
    }

    //Returns number of elements
    public int size() {
      return size;
    }


    //Empties arraylist by creating a new one.
    public void clear() {
        array = new int[2];
        size = 0;
    }

    //Prints our arraylist
    public String toString() {
        if (array == null || size() == 0) {
            return "[]";
        } else {
            String result = "[" + array[0];

            for (int i = 1; i < size; i++) {
                    result += ", " + array[i];
            }
            result += "]";
            return result;
        }
    }

    //Checks if we need to increase our array size
    private void checkArrayIncrease() {
        if (array.length < 1){
            array = new int[2];
        }
        //if length and size(number of elements) are equal, then the array is full and we need to enlarge it
        else if (array.length == size) {
            //we'll just double the size (maybe a better solution would be to increase by certain amount (doubling could end with a gigantic array))
            int[] newArray = new int[array.length * 2];
            //Copy from array to newArray
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    //checks if we can decrease our array size
    private void checkArrayDecrease() {
        if (array.length/2 > size) {    //If half the array is empty. Make a smaller one
            int[] newArray = new int[array.length / 2 ];

            //Copy array
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }
}