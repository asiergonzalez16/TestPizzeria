import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class FileAccessor {

    ArrayList<Customer> listaCustomer = new ArrayList();
    ArrayList<Pizza> listaPizza = new ArrayList();
    ArrayList<Ingrediente> listaIngredientes = new ArrayList();


    public void readCustomerFile(String filename) throws IOException {
        int id;
        String name, address, email, phone;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            address = str.nextToken();
            email = str.nextToken();
            phone = str.nextToken();
            // System.out.println(id + name + country + year + active);
            listaCustomer.add(new Customer(id, name, address, email, phone));
        }
        br.close();
    }
    public void printCustomer() {
        for (int i = 0; i < listaCustomer.size(); i++) {
            System.out.println(listaCustomer.get(i).toString());
        }
    }

    public void readOrderFile(String filename) throws IOException {
        int idOrder;
        int idCustomer;
        Date date;
        DateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idOrder = Integer.parseInt(str.nextToken());
            idCustomer = Integer.parseInt(str.nextToken());
            try {
                date = dateformat.parse(str.nextToken());
                for (Customer c1:listaCustomer) {
                    if (c1.getId_Customer() == idCustomer){
                        Order order = new Order(idOrder,date);
                        c1.addOrder(order);
                    }
                }
            } catch (ParseException e) {
                System.err.println(" errada format data al fitxer");
                e.printStackTrace();
            }
        }
        br.close();
    }

    public void printOrder() {
        for (int i = 0; i < listaCustomer.size(); i++) {
            for (int j = 0; j < listaCustomer.get(i).getSizeOrder(); j++) {
                System.out.println(listaCustomer.get(i).getOrders(j));
            }
        }
    }
    public void readPizzaFile(String filename) throws IOException {
        int idPizza;
        String name;
        float precio;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idPizza = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            precio = Float.parseFloat(str.nextToken());
            listaPizza.add(new Pizza(idPizza, name, precio));
        }
        br.close();
    }

    public void printPizza() {
        for (int i = 0; i < listaPizza.size(); i++) {
            System.out.println(listaPizza.get(i).toString());
        }
    }

    public void readOrderDetailFile(String filename) throws IOException {
        int idOrder;
        int idPizza;
        int quantity;
        float priceEach;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idOrder = Integer.parseInt(str.nextToken());
            idPizza = Integer.parseInt(str.nextToken());
            quantity = Integer.parseInt(str.nextToken());
            priceEach = Float.parseFloat(str.nextToken());
            for (Customer c1:listaCustomer) {
                for (int j = 0; j < c1.getSizeOrder(); j++) {
                    if (c1.getOrders(j).getId_order() == idOrder){
                        for(Pizza p1:listaPizza){
                            if(p1.getId_pizza() == idPizza){
                                OrderDetail orderDetail = new OrderDetail(p1,quantity,priceEach);
                                orderDetail.setOrder(c1.getOrders(j));
                                c1.getOrders(j).addOrderDetails(orderDetail);

                            }
                        }
                    }
                }
            }
        }
        br.close();
    }
    public void printOrderDetail() {
        for (Customer c1:listaCustomer) {
            for (int j = 0; j < c1.getSizeOrder(); j++) {
                for (int x = 0; x < c1.getOrders(j).getSizeOrderDetail(); x++) {
                    System.out.println(c1.getOrders(j).getOrdersDetail(x).toString());
                }

            }
        }
    }

    public void readIngredientsFile(String filename) throws IOException {
        int idIngrediente;
        String name;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idIngrediente = Integer.parseInt(str.nextToken());
            name = str.nextToken();
            listaIngredientes.add(new Ingrediente(idIngrediente,name));
        }
        br.close();
    }

    public void printIngredientes() {
        for (int i = 0; i < listaIngredientes.size(); i++) {
            System.out.println(listaIngredientes.get(i).toString());
        }
    }

    public void readContieneFile(String filename) throws IOException {
        int idPizza;
        int idIngrediente;

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            idPizza = Integer.parseInt(str.nextToken());
            idIngrediente = Integer.parseInt(str.nextToken());

            Ingrediente ingrediente = null;
            for(Ingrediente i1:listaIngredientes){
                if(i1.getId_ingredient() == idIngrediente){
                    ingrediente = i1;
                    break;
                }
            }
            for(Pizza p1:listaPizza){
                if (p1.getId_pizza() == idPizza) {
                    p1.addIngrediente(ingrediente);
                }
            }
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        FileAccessor fileAccessor = new FileAccessor();

        fileAccessor.readCustomerFile("customers.txt");
        fileAccessor.printCustomer();

        fileAccessor.readIngredientsFile("ingredientes.txt");
        fileAccessor.printIngredientes();

        fileAccessor.readOrderFile("order.txt");
        fileAccessor.printOrder();

        fileAccessor.readPizzaFile("pizza.txt");


        fileAccessor.readOrderDetailFile("orderdetail.txt");
        fileAccessor.readContieneFile("contiene.txt");
        fileAccessor.printOrderDetail();
        fileAccessor.printPizza();




    }
}
