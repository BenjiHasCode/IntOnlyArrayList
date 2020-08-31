public class IntOnlyArrayList {
    private Integer[] array;

    //Constructor
    public IntOnlyArrayList() {
        array = new Integer[2]; //Hvor stort skal vores array være?
    }

    //Returns number of elements
    public int size() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i; //0 based so if we return first occurrence of null, then we return the number of elements (last index 34, size = 35)
            }
        }
        return array.length; //else return length of array (every space could be occupied
    }

    //Adds to end of list
    public void add(int value) {
        //If last index is filled = enlarge
        checkArrayIncrease();
        //size returns the number of elements, and since its 0 based, the size must be the next empty index
        array[size()] = value;
    }

    //Adds at designated index
    public void add(int index, int value) {
        if (index > size() || index < 0) { //man kunne sige index >= size(), men ved kun at sige > så kan vi også tilføje til slutningen af listen. Hvorfor man ikke bare bruger den anden metode vil jeg ikke vide.
            throw new IndexOutOfBoundsException();
        } else {
            //Checks if we need to increase our array
            checkArrayIncrease();
            for (int i = array.length - 1; i > index; i--) {
                //We start shuffling the elements in the end of the list
                if (array[i - 1] != null) {
                    array[i] = array[i - 1]; //we shuffle it to the right
                }
                //if the next index (i is decrementing) is the one we want to add to -> assign it the value
                if (i - 1 == index) {
                    array[i - 1] = value;
                }
            }
        }
    }

    //removes from index, shuffling everything into place
    public void remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            //if index is last - set null
            if (index == array.length - 1){
                array[index] = null;
            }else{
                for (int i = index + 1; i < array.length ; i++) {
                    if (array[i] != null) { //if current (one to right of delete index) isnt empty -> shuffle left
                        array[i - 1] = array[i]; //index left gets current value thus "deleting" our designated index
                        array[i] = null;
                    }
                }
            }
            checkArrayDecrease(); //Check if we can make the array smaller
        }
    }

    //Empties arraylist by creating a new one.
    public void clear() {
        array = new Integer[2];
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

    //Prints our arraylist
    public String toString() {
        if (array == null || size() == 0) {
            return "[]";
        } else {
            String result = "[" + array[0];

            for (int i = 1; i < array.length; i++) {
                if (array[i] != null) {
                    result += ", " + array[i];
                }
            }
            result += "]";
            return result;
        }
    }

    //Checks if we need to increase our array size
    private void checkArrayIncrease() {
        if (array.length < 1){          //If array is size 0, make new one
            array = new Integer[2];
        }
        else if (array[array.length - 1] != null) {
            Integer[] newArray = new Integer[array.length * 2];

            //Copy from array to newArray. copy amount of elements fitting with array.length
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    //checks if we can decrease our array size
    private void checkArrayDecrease() {
        if (array[array.length / 2] == null) {    //If half the array is empty. Make a smaller one
            Integer[] newArray = new Integer[array.length / 2 ];

            //Copy array
            System.arraycopy(array, 0, newArray, 0, array.length / 2);
            array = newArray;
        }
    }
}