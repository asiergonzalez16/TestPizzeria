import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Customer implements Serializable{
    int id_Customer;

    private String name;
    private String address;
    private String email;
    private String phone;
    private Set<Order> orders = new HashSet<>();

    public Customer(int id_Customer, String name, String address, String email, String phone) {
        super();
        this.id_Customer = id_Customer;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }



    public int getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(int id_Customer) {
        this.id_Customer = id_Customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Order getOrders(int i) {
        Iterator<Order> it = orders.iterator();
        for (int j = 0; j < i; j++) {
            it.next();
        }
        return it.next();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public int getSizeOrder(){
        return orders.size();
    }

    @Override
    public String toString() {
        return "Customer [id_Cusomer= " + id_Customer + ", name= " + name
                + ", address= " + email + ", phone= "
                + phone + "]";
    }
}
