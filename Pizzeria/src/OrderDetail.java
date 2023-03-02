import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int quantiy;

    private float priceEach;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    Order order;
    Pizza pizza;


    public OrderDetail(Pizza pizza, int quantiy, float priceEach) {
        this.pizza = pizza;
        this.quantiy = quantiy;
        this.priceEach = priceEach;
    }
    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(float priceEach) {
        this.priceEach = priceEach;
    }
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "OrderDetail [id_Order= " + order.getId_order() + ", quantity = " + quantiy
                + ", priceEach= " + priceEach +"]";
    }
}
