public class Driver {
    public static void main(String[] args) {
        System.out.println("Hello World");

        DatabaseConnection d = DatabaseConnection.getInstance();
        DatabaseConnection e = DatabaseConnection.getInstance();

        System.out.println(d);
        System.out.println(e);
    }
}
