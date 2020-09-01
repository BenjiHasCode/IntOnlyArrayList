public class Main {
    public static void main(String[] args) {
        //instantier
        IntOnlyArrayList il = new IntOnlyArrayList();

        //Tilføj nogle tal
        il.add(1);
        il.add(17);
        il.add(42);

        //udskriv
        System.out.println(il);

        //fjern et element
        il.remove(1);

        //udskriv
        System.out.println(il);

        //clear
        il.clear();
        System.out.println("Clear:\n"+il);
    }
}