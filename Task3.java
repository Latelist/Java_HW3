import java.util.ArrayList;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.


public class Task3 {
    Task3() {
        ArrayList<Integer> list = Task2.listGenerator(10);
        System.out.println(list);
        list.sort(null);
        System.out.println("min = " + list.get(0));
        System.out.println("max = " + list.get(list.size()-1));
        System.out.println("average = " + list.get(list.size()/2));
    }


}
