package b2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2 {
    public static void main(String[] args) {
        List<String> medicines = new ArrayList<>();
        medicines.add("Paracetamol");
        medicines.add("Ibuprofen");
        medicines.add("Panadol");
        medicines.add("Paracetamol");
        medicines.add("Aspirin");
        medicines.add("Ibuprofen");
        System.out.println(medicines);

        List<String> result = new ArrayList<>();
        for (String medicine : medicines) {
            if (!result.contains(medicine)) {
                result.add(medicine);
            }
        }
        Collections.sort(result);
        System.out.println(result);
    }
}