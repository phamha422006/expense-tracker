import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();   manager.loadFromFile("transactions.csv");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Them khoan thu");
            System.out.println("2. Them khoan chi");
            System.out.println("3. Xem tat ca");
            System.out.println("4. Xoa theo ID");
            System.out.println("5. Thong ke");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1", "2" -> {
                    String type = choice.equals("1") ? "THU" : "CHI";
                    System.out.print("So tien: ");
                    double amount = Double.parseDouble(sc.nextLine());
                    System.out.print("Danh muc: ");
                    String category = sc.nextLine();
                    System.out.print("Ghi chu: ");
                    String note = sc.nextLine();
                    manager.add(amount, type, category, note, LocalDate.now());
                      manager.saveToFile("transactions.csv");
                    System.out.println("Da them!");
                }
                case "3" -> {
                    if (manager.getAll().isEmpty()) System.out.println("Chua co giao dich.");
                    manager.getAll().forEach(System.out::println);
                }
                case "4" -> {
                    System.out.print("Nhap ID can xoa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (manager.delete(id)) {
                    manager.saveToFile("transactions.csv");
                    System.out.println("Da xoa!");
                 } else {
                    System.out.println("Khong tim thay ID.");
    }
}
                case "5" -> {
                    double thu = manager.getTotal("THU");
                    double chi = manager.getTotal("CHI");
                    System.out.printf("Tong thu: %,.0f VND%n", thu);
                    System.out.printf("Tong chi: %,.0f VND%n", chi);
                    System.out.printf("Con lai : %,.0f VND%n", thu - chi);
                }
                case "0" -> {
                    System.out.println("Tam biet!");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le.");
            }
        }
    }
}