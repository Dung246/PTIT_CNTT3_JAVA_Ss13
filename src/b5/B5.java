package b5;
import java.util.*;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getLastName() {
        String[] parts = fullName.trim().split("\\s+");
        return parts[parts.length - 1];
    }
    @Override
    public String toString() {
        return "ID : " + id +
                " | FullName : " + fullName +
                " | Age : " + age +
                " | Diagnosis : " + diagnosis + " |";
    }
}

public class B5 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> list = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách bệnh nhân");
            System.out.println("5. Hiển thị danh sách bệnh nhân");
            System.out.println("6. Thoát");
            System.out.println("======================================");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addPatient(); break;
                case 2: updateDiagnosis(); break;
                case 3: dischargePatient(); break;
                case 4: sortPatients(); break;
                case 5: showPatients(); break;
                case 6: System.exit(0);
                default: System.out.println("Chọn sai!");
            }
        }
    }

    static void addPatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.getId().equals(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        list.add(new Patient(id, name, age, diagnosis));
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân để cập nhật chẩn đoán: ");
        String id = sc.nextLine();

        for (Patient p : list) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                p.setDiagnosis(sc.nextLine());
                System.out.println("Chẩn đoán đã được cập nhật.");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân.");
    }

    static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân để xuất viện: ");
        String id = sc.nextLine();

        Iterator<Patient> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                System.out.println("Đã xuất viện.");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    static void sortPatients() {
        Collections.sort(list, new Comparator<Patient>() {
            public int compare(Patient a, Patient b) {
                if (a.getAge() != b.getAge())
                    return b.getAge() - a.getAge();
                return a.getFullName().compareToIgnoreCase(b.getFullName());
            }
        });

        System.out.println("Danh sách bệnh nhân đã được sắp xếp.");
    }

    static void showPatients() {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        System.out.println("======== Danh sách bệnh nhân ========");
        for (Patient p : list) {
            System.out.println(p);
        }
    }
}