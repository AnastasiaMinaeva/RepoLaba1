import java.util.Objects;

public class Product {
    public String name;
    public String description;

    public Product(String name, String description)
    {
        this.name = name;
        this.description = description;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o){return false;}
        if(o == null || getClass() != o.getClass()){return false;}
        Product product = (Product) o;
        return Objects.equals(description, product.description) && Objects.equals( name, product.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, description);
    }

    @Override
    public String toString()
    {
        return "Product{" + 
                "name=" + name + '\'' +
                "description=" + description + '\'' +
                "}";
    }

}
