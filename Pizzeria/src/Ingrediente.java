import java.io.Serializable;

public class Ingrediente implements Serializable {

    private int id_ingredient;
    private String name;
    public Ingrediente(int id_ingredient, String name) {
        super();
        this.id_ingredient = id_ingredient;
        this.name = name;
    }
    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Ingredients [id_ingredient= " + id_ingredient + ", name= " + name+ "]";
    }
}
