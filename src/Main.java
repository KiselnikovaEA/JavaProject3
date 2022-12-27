import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4);
        ArrayList<Integer> al1 = new ArrayList<>(l1);
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        ArrayList<Integer> al2 = new ArrayList<>(l2);

        System.out.println("Task1: " + equals(al1, al2));
        System.out.println("Task2: " + equalNumCount(al1, al2, 1));

        List<Integer> l3 = Arrays.asList(10, 4, 5, 6, 7, 2, 2, 9);
        ArrayList<Integer> al3 = new ArrayList<>(l3);

        System.out.println("Task3: \nБыло: " + al3);
        System.out.println("Стало: " + sortEvenNumbers(al3));

        System.out.println("Task4: \nБыло: " + al3);
        System.out.println("Стало: " + removeEvenNumbers(al3));

    }

    private static boolean equals(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        if (al1.size() != al2.size()) {
            return false;
        }
        for (int i = 0; i < al1.size(); i++) {
            if (al1.get(i) != al2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean equalNumCount(ArrayList<Integer> al1, ArrayList<Integer> al2, int num) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < al1.size(); i++) {
            if (al1.get(i) == num) {
                count1++;
            }
        }
        for (int j = 0; j < al2.size(); j++) {
            if (al2.get(j) == num) {
                count2++;
            }
        }
        return count1 == count2;
    }

    private static ArrayList<Integer> sortEvenNumbers(ArrayList<Integer> al) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) % 2 == 0) {
                temp.add(al.get(i));
            }
        }
        temp.sort(Comparator.naturalOrder());
        int j = 0;
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) % 2 == 0) {
                al.set(i, temp.get(j++));
            }
        }
        return al;
    }

    private static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> al) {
        Iterator iterator = al.iterator();

        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (current.hashCode() % 2 == 0) {
                iterator.remove();
            }
        }

        return al;
    }
}