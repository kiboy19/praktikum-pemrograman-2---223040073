package model;

public class Product {
    private int id;
    private String itemName;
    private String description;
    private String category;
    private int quantity;
    private int price;
    private boolean onSale;

    // Constructor kosong
    public Product() {}

    // Constructor dengan semua atribut
    public Product(int id, String itemName, String description, String category, int quantity, int price, boolean onSale) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.onSale = onSale;
    }

    // Getter dan Setter untuk setiap atribut
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public boolean isOnSale() { return onSale; }
    public void setOnSale(boolean onSale) { this.onSale = onSale; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", onSale=" + onSale +
                '}';
    }
}
