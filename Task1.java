import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// Реализовать алгоритм сортировки слиянием(метод взять из Интернета)

public class Task1 {

    Task1() {
        int[] array = arrayGenerator();
        printer(array);
        int[] allUnited = uniteAll(array);
        System.out.println();
        printer(allUnited);
    }
    
    public static void printer(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] arrayGenerator() {
        int[] array = new int[11];
        Random rnd = new Random();
        for (int i = 0; i < array.length; ++i) {
            array[i] = rnd.nextInt(100);
        }
        return array;
    }

    public static ArrayList<int[]> arraySplitter(int[] array) {
        ArrayList<int[]> smallArrays = new ArrayList<>();
        if (array.length > 2) {
            int[] n = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] m = Arrays.copyOfRange(array, array.length / 2, array.length);
            smallArrays.addAll(arraySplitter(n));
            smallArrays.addAll(arraySplitter(m));
        } else {
            if (array.length > 1) {
                if (array[0] > array[1]) {
                    int temporary = array[0];
                    array[0] = array[1];
                    array[1] = temporary;
                }
            }
            smallArrays.add(array);
        }
        return smallArrays;
    }

    public static int[] uniter(int[] array1, int[] array2) {
        int[] united = new int[array1.length + array2.length];

        ArrayList<Integer> buffer = new ArrayList<>();
        buffer.add(array1[0]);
        buffer.add(array2[0]);
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < united.length; ++i) {
            if (buffer.size() > 1) {
                if (buffer.get(0) < buffer.get(1)){
                    united[i] = buffer.get(0);
                    buffer.remove(0);
                } else {
                    united[i] = buffer.get(1);
                    buffer.remove(1);
                }
    
                if (united[i] == array1[index1] && index1 != array1.length-1) {
                    ++index1;
                    buffer.add(array1[index1]);
                } else if ((united[i] == array2[index2] && index2 != array2.length-1)) {
                    ++index2;
                    buffer.add(array2[index2]);
                }
            } else {
                united[i] = buffer.get(0);
                buffer.remove(0);
                if (index1 < array1.length-1) {
                    ++index1;
                    buffer.add(array1[index1]);
                } else if (index2 < array2.length - 1) {
                    ++index2;
                    buffer.add(array2[index2]);
                }
            }
        }
        return united;
    }

    public static int[] uniteAll(int[] array) {
        ArrayList<int[]> smallArrays = arraySplitter(array);
        while (smallArrays.size() > 1) {
            int[] united = uniter(smallArrays.get(0), smallArrays.get(1));
            smallArrays.remove(1);
            smallArrays.remove(0);
            smallArrays.add(0, united);
        }
        return smallArrays.get(0);
    }

}