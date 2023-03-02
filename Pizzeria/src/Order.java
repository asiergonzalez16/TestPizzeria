import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Order implements Serializable {
    Customer customer;
    OrderDetail orderDetail;


    private int id_order;
    private Date order_date;
    private Set<OrderDetail> orderDetails = new HashSet<>();

    public Order(int id_order, Date order_date) {
        super();
        this.id_order = id_order;
        this.order_date = order_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public OrderDetail getOrdersDetail(int i) {
        Iterator<OrderDetail> it = orderDetails.iterator();
        for (int j = 0; j < i; j++) {
            it.next();
        }
        return it.next();
    }
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void addOrderDetails(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }
    public int getSizeOrderDetail(){
        return orderDetails.size();
    }

    @Override
    public String toString() {
        return "Order [id_Order= " + id_order + ", order_date= " + order_date +"]";
    }
}
