import java.time.LocalDate;

public class Transaction {
    private int id;
    private double amount;
    private String type; // "Thu" or "Chi"
    private String  category; // ăn uống, đi lại, giải trí, học tập, sức khỏe, quà tặng, khác
    private String note;
    private LocalDate date;
    
    
    public Transaction(int id, double amount, String type, String category, String note, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.note = note;
        this.date = date;
    }


    public int getId() {
        return id;
    }


    public double getAmount() {
        return amount;
    }


    public String getType() {
        return type;
    }


    public String getCategory() {
        return category;
    }


    public String getNote() {
        return note;
    }


    public LocalDate getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Transaction [id=" + id + ", amount=" + amount + ", type=" + type + ", category=" + category + ", note=" + note
                + ", date=" + date + "]";
    }

    

    
}