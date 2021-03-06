/**
 * Created by leader on 17/8/11.
 */

// product
class Pizza{
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough){
        this.dough = dough;
    }
    public void setSauce(String sauce){
        this.sauce = sauce;
    }
    public void setTopping(String topping){
        this.topping = topping;
    }

    @Override
    public String toString(){
        return "pizza of dough:" + this.dough + " sauce:" + this.sauce + " topping:" + this.topping;
    }
}

//abstract builder
abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza(){
        return pizza;
    }

    public void createNewPizzaProduct(){
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

//concrete build
class ItalianPizzaBuilder extends PizzaBuilder{
    public void buildDough(){
        pizza.setDough("cross");
    }

    public void buildSauce(){
        pizza.setSauce("mild");
    }

    public void buildTopping(){
        pizza.setTopping("ham+pineapple");
    }
}

class ChinesePizzaBuilder extends PizzaBuilder{
    public void buildDough(){
        pizza.setDough("pan baked");
    }

    public void buildSauce(){
        pizza.setSauce("hot");
    }

    public void buildTopping(){
        pizza.setTopping("pepperoni+salami");
    }
}

//director
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb){
        this.pizzaBuilder = pb;
    }

    public Pizza getPizza(){
        return pizzaBuilder.getPizza();
    }

    public void constructPizza(){
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder italianPizzaBuilder = new ItalianPizzaBuilder();
        PizzaBuilder chinesePizzaBuilder = new ChinesePizzaBuilder();

        waiter.setPizzaBuilder(italianPizzaBuilder);
        waiter.constructPizza();
        Pizza pizza1 = waiter.getPizza();
        System.out.println(pizza1.toString());

        waiter.setPizzaBuilder(chinesePizzaBuilder);
        waiter.constructPizza();
        Pizza pizza2 = waiter.getPizza();
        System.out.println(pizza2.toString());
    }
}
