package b4;
import java.util.LinkedList;

class EmergencyRoom {
    private LinkedList<String> queue = new LinkedList<>();
    public void patientCheckIn(String name) {
        queue.addLast(name);
    }
    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }
    public void treatPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân.");
            return;
        }
        String patient = queue.removeFirst();
        if (queue.size() >= 0) {
            if (patient.equals("C")) {
                System.out.println("Đang cấp cứu: " + patient);
            } else {
                System.out.println("Đang khám: " + patient);
            }
        }
    }
}

public class B4 {
    public static void main(String[] args) {
        EmergencyRoom room = new EmergencyRoom();

        room.patientCheckIn("A");
        room.patientCheckIn("B");
        room.emergencyCheckIn("C");

        room.treatPatient();
        room.treatPatient();
        room.treatPatient();
    }
}