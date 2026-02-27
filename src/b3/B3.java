package b3;
import java.util.ArrayList;
import java.util.List;

public class B3 {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>();
        a1.add(101);
        a1.add(102);
        a1.add(105);

        List<Integer> b1 = new ArrayList<>();
        b1.add(102);
        b1.add(105);
        b1.add(108);
        System.out.println("Test Case 1 Output: " + findCommonPatients(a1, b1));

        List<String> a2 = new ArrayList<>();
        a2.add("DN01");
        a2.add("DN02");
        a2.add("DN03");

        List<String> b2 = new ArrayList<>();
        b2.add("DN02");
        b2.add("DN04");

        System.out.println("Test Case 2 Output: " + findCommonPatients(a2, b2));
    }
}