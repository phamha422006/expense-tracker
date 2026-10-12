import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();
    private int nextId = 1;

    public void add(double amount, String type, String category, String note, LocalDate date) {
        transactions.add(new Transaction(nextId++, amount, type, category, note, date));
    }

    public List<Transaction> getAll() {
        return transactions;
    }

    public boolean delete(int id) {
        return transactions.removeIf(t -> t.getId() == id);
    }

    public double getTotal(String type) {
        double sum = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals(type)) sum += t.getAmount();
        }
        return sum;
    }

    public void saveToFile(String path) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
        for (Transaction t : transactions) {
            pw.println(t.getId() + ";" + t.getAmount() + ";" + t.getType() + ";"
                    + t.getCategory() + ";" + t.getNote() + ";" + t.getDate());
        }
    } catch (IOException e) {
        System.out.println("Loi luu file: " + e.getMessage());
    }
}

public void loadFromFile(String path) {
    File file = new File(path);
    if (!file.exists()) return;
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] p = line.split(";", -1);
            int id = Integer.parseInt(p[0]);
            transactions.add(new Transaction(id, Double.parseDouble(p[1]), p[2], p[3], p[4], LocalDate.parse(p[5])));
            if (id >= nextId) nextId = id + 1;
        }
    } catch (IOException e) {
        System.out.println("Loi doc file: " + e.getMessage());
    }
}
}

