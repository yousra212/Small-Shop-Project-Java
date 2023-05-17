public class OrderedProduct implements Comparable<OrderedProduct>  {  // This class implements the Comparable interface, which means that it can be compared to other objects of the same type
    final private String name;
    final private double price;
    final private int quantity;
    final private double total;

    public OrderedProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }


    @Override // This annotation is optional, but it's a good practice to use it to indicate that this method overrides a method from the superclass
    public String toString() {
        return name + "\t\t\t" + price + "\t\t" + quantity + "\t\t" + total;
    }

    @Override //Here we override the compareTo method from the Comparable interface
    public int compareTo(OrderedProduct other) {
        return Double.compare(other.getTotal(), this.getTotal());
    }
}
