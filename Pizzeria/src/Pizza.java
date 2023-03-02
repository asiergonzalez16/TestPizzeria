import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Pizza implements Serializable {
    private int id_pizza;
    private String name;
    private float price;
    private Set<Ingrediente> listaingredientes = new HashSet<>();

    public Pizza(int id_pizza, String name, float price) {
        super();
        this.id_pizza = id_pizza;
        this.name = name;
        this.price = price;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Ingrediente getIngredientes(int i) {
        Iterator<Ingrediente> it = listaingredientes.iterator();
        for (int j = 0; j < i; j++) {
            it.next();
        }
        return it.next();
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.listaingredientes = ingredientes;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        listaingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        String texto ="";
        texto+= "Pizza [id_pizza= " + id_pizza + ", name= " + name
                + ", price= " + price + " ingredientes: ";

        Iterator<Ingrediente>it = listaingredientes.iterator();
        while(it.hasNext()){
            texto+=it.toString();
        }
        return texto;
    }
}
