import java.util.ArrayList;
import java.util.Random;

// Пусть дан произвольный список целых чисел, удалить из него четные числа


public class Task2 {

    Task2() {
        ArrayList<Integer> list = listGenerator(10);
        System.out.println(list);

        ArrayList<Integer> noEvenList = evenDeleter(list);
        System.out.println(noEvenList);
    }

    public static ArrayList<Integer> listGenerator(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < num; ++i) {
            list.add(rnd.nextInt(100));
        }
        return list;
    }

    public static ArrayList<Integer> evenDeleter(ArrayList<Integer> list) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                evens.add(integer);
            }
        }
        list.removeAll(evens);
        return list;
    }
    
}
