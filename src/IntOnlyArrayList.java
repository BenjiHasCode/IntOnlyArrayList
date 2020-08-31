public class IntOnlyArrayList {
    private Integer[] array;

    public IntOnlyArrayList() {
        array = new Integer[2]; //Hvor stort skal vores array være?
    }

    public int size() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i; //0 based so if we return first occurrence of null, then we return the number of elements (last index 34, size = 35)
            }
        }
        return array.length; //else return length of array
    }

    public void add(int value) {
        //check if last index isn't null
        checkArrayIncrease();
        //Find empty index
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = value;
                return; //so stopper metoden lige så snart den har addet noget. Ved ikke om det er god skik
            }
        }
    }

    public void add(int index, int value) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            checkArrayIncrease();
            //Last place should be empty. Were shuffling spaces
            for (int i = array.length - 1; i > index; i--) {
                if (array[i - 1] != null) {
                    array[i] = array[i - 1]; //we shuffle it to the right
                }
                if (i - 1 == index) {
                    array[i - 1] = value;
                }
            }
        }
    }

    public void remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            //if its the last index - set null
            if (index == array.length - 1){
                array[index] = null;
            }else{
                for (int i = index + 1; i < array.length ; i++) {
                    if (array[i] != null) { //if current (one to right of delete index) isnt empty -> shuffle left
                        array[i - 1] = array[i]; //index left gets current value thus "deleting" our designated index
                        array[i] = null; //remove current -> move next to current
                    }
                }
            }
            checkArrayDecrease();
        }
    }

    public void clear() {
        array = new Integer[2];
        //Man kunne selvfølgelig også gå sekventielt igennem og gøre alle null
    }

    public int get(int index) {
        //checks that our index isn't out of bounds
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return array[index];
        }
    }

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
            return result; //Må man gerne bare bruge array toString metode?
        }
    }

    public void checkArrayIncrease() {
        if (array.length < 1){          //If array is size 0, make new one
            array = new Integer[2];
        }
        else if (array[array.length - 1] != null) {
            Integer[] newArray = new Integer[array.length * 2];

            //Copy array
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            //System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    public void checkArrayDecrease() {
        if (array[array.length / 2] == null) {    //If half the array is empty. Make a smaller one
            Integer[] newArray = new Integer[array.length / 2 ];

            //Copy array
            for (int i = 0; i < array.length/2; i++) {
                newArray[i] = array[i];
            }
            //System.arraycopy(array, 0, newArray, 0, array.length / 2);
            array = newArray;
        }
    }
}