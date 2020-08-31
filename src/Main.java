import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IntOnlyArrayList list = new IntOnlyArrayList();
        System.out.println("Empty list");
        System.out.println(list);                   //empty list

        System.out.println("Add number:");
        list.add(1);                                //add number
        System.out.println(list);

        System.out.println("Add number at index 0:");
        list.add(0, 10);               //add number at index
        System.out.println(list);

        System.out.println("Size of ArrayList:");
        System.out.println(list.size());            //Size

        System.out.println("Get index 1:");
        System.out.println(list.get(1));            //get index 1

        System.out.println("Remove index 0:");
        list.remove(0);                      //remove index 0
        System.out.println(list);

        System.out.println("List after for loop (adding 50 random numbers)");
        Random random = new Random();
        for(int i = 0; i < 50; i++){
            list.add(random.nextInt(50) + 1);
        }
        System.out.println(list);

        System.out.println("Clear list:");
        list.clear();
        System.out.println(list);                   //clear

    }
}
