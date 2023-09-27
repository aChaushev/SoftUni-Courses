package _03_StacksAndQueues_Lab;

public class Memory_BigOAlgorithm {
    public static void main(String[] args) {


        int[] arr = {12, 42, 73, 69};

        // N =  arr.length

        int number = 69;

        boolean containsNumber = false;
        for (int i = 0; i < arr.length; i++) {
            int currentElement = arr[i];   // O(1)
            if (currentElement == number) {
                containsNumber = true;
                break;
            }
        }
        System.out.println(containsNumber);

        int memory = arr.length * Integer.BYTES;
        System.out.println(memory);
    }
}
