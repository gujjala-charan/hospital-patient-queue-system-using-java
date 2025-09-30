import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
 
class Patient {
    String name;
    int severity;
    long arrivalTime;
 
    public Patient(String name, int severity, long arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }
 
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
 
class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // Compare by severity first. Lower severity means higher priority.
        if (p1.severity != p2.severity) {
            return Integer.compare(p1.severity, p2.severity);
        } else {
            // If severity is the same, compare by arrival time. Earlier arrival means higher priority.
            return Long.compare(p1.arrivalTime, p2.arrivalTime);
        }
    }
}
 
public class HospitalQueueSystem {
    private static PriorityQueue<Patient> patientQueue;
    private static long arrivalCounter = 0;
 
    public HospitalQueueSystem() {
        patientQueue = new PriorityQueue<>(new PatientComparator());
    }
 
    public void checkIn(String name, int severity) {
        Patient newPatient = new Patient(name, severity, arrivalCounter++);
        patientQueue.add(newPatient);
        System.out.println("\n✅ CHECK-IN: '" + name + "' (Severity: " + severity + ") has been added to the queue.");
    }
 
    public void checkOut() {
        if (!patientQueue.isEmpty()) {
            Patient nextPatient = patientQueue.poll();
            System.out.println("\n🩺 CHECK-OUT: Doctor is now seeing '" + nextPatient.name + "' (Severity: " + nextPatient.severity + ").");
        } else {
            System.out.println("\n❌ The queue is empty. No patients to check out.");
        }
    }
 
    public void displayQueue() {
        if (patientQueue.isEmpty()) {
            System.out.println("\n✅ The current queue is empty.");
            return;
        }
 
        // Create a temporary queue to display the sorted patients without modifying the original queue
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue);
        System.out.println("\n🏥 CURRENT PATIENT QUEUE:");
        int i = 1;
        while (!tempQueue.isEmpty()) {
            System.out.println(i++ + ". " + tempQueue.poll());
        }
    }
 
    public static void main(String[] args) {
        HospitalQueueSystem system = new HospitalQueueSystem();
        System.out.println("--- 🩺 Starting Hospital Patient Queue System Simulation ---");
 
        // Check-in patients
        system.checkIn("John", 3);
        system.checkIn("Mary", 1);
        system.checkIn("Peter", 3);
        system.checkIn("Sarah", 2);
 
        // Display the queue
        system.displayQueue();
 
        // Check-out the next patient
        system.checkOut();
 
        // Display the queue after check-out
        system.displayQueue();
    }
}