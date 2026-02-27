package b6;
import java.util.*;

class Medicine {
    String drugId;
    String drugName;
    double unitPrice;
    int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    double getTotal() {
        return unitPrice * quantity;
    }
}

public class B6 {

    static Scanner sc = new Scanner(System.in);
    static List<Medicine> cart = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=========== MENU ===========");
            System.out.println("1. Thêm thuốc vào đơn");
            System.out.println("2. Điều chỉnh số lượng");
            System.out.println("3. Xóa thuốc");
            System.out.println("4. In hóa đơn");
            System.out.println("5. Tìm thuốc giá rẻ");
            System.out.println("6. Thoát");
            System.out.println("============================");

            System.out.print("Chọn lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addMedicine(); break;
                case 2: updateQuantity(); break;
                case 3: removeMedicine(); break;
                case 4: printInvoice(); break;
                case 5: cheapMedicine(); break;
                case 6: System.exit(0);
                default: System.out.println("Chọn sai!");
            }
        }
    }

    static void addMedicine() {
        System.out.print("Nhập mã thuốc: ");
        String id = sc.nextLine();

        for (Medicine m : cart) {
            if (m.drugId.equals(id)) {
                System.out.print("Thuốc đã tồn tại, nhập số lượng thêm: ");
                int add = Integer.parseInt(sc.nextLine());
                m.quantity += add;
                System.out.println("Đã cộng dồn số lượng!");
                return;
            }
        }

        System.out.print("Nhập tên thuốc: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá thuốc: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng: ");
        int qty = Integer.parseInt(sc.nextLine());

        cart.add(new Medicine(id, name, price, qty));
        System.out.println("Thêm thuốc thành công!");
    }

    static void updateQuantity() {
        while (true) {
            System.out.print("Nhập mã thuốc: ");
            String id = sc.nextLine();

            for (Medicine m : cart) {
                if (m.drugId.equals(id)) {
                    System.out.print("Nhập số lượng mới: ");
                    int q = Integer.parseInt(sc.nextLine());

                    if (q == 0) {
                        cart.remove(m);
                        System.out.println("Đã xóa thuốc vì số lượng = 0");
                    } else {
                        m.quantity = q;
                        System.out.println("Cập nhật thành công!");
                    }
                    return;
                }
            }
            System.out.println("Thuốc không tồn tại trong đơn.");
        }
    }

    static void removeMedicine() {
        System.out.print("Nhập mã thuốc cần xóa: ");
        String id = sc.nextLine();

        Iterator<Medicine> it = cart.iterator();
        while (it.hasNext()) {
            if (it.next().drugId.equals(id)) {
                it.remove();
                System.out.println("Đã xóa thuốc.");
                return;
            }
        }

        System.out.println("Không tìm thấy thuốc.");
    }

    static void printInvoice() {
        if (cart.isEmpty()) {
            System.out.println("Đơn thuốc rỗng.");
            return;
        }

        double total = 0;

        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n",
                "Mã Thuốc","Tên Thuốc","Đơn Giá","Số Lượng","Thành Tiền");

        for (Medicine m : cart) {
            double money = m.getTotal();
            total += money;

            System.out.printf("%-10s %-20s %-10.2f %-10d %-10.2f\n",
                    m.drugId, m.drugName, m.unitPrice, m.quantity, money);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Tổng tiền: %.2f VND\n", total);

        cart.clear();
        System.out.println("Đơn đã được làm mới.");
    }

    static void cheapMedicine() {
        boolean found = false;

        System.out.printf("%-10s %-20s %-10s\n","Mã","Tên","Giá");

        for (Medicine m : cart) {
            if (m.unitPrice < 50000) {
                System.out.printf("%-10s %-20s %-10.2f\n",
                        m.drugId, m.drugName, m.unitPrice);
                found = true;
            }
        }

        if (!found)
            System.out.println("Không có thuốc giá rẻ.");
    }
}
