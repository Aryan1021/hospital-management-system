package HospitalManagementSystem;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        System.out.println(System.getenv("DB_URL"));
        System.out.println(System.getenv("DB_USERNAME"));
        System.out.println(System.getenv("DB_PASSWORD") != null);
    }
}
