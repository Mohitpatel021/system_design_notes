package Lecture09;

interface Pizza{
    void prepare();
}
class NormalPizza implements Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing Normal Pizza" );
    }
}

class PremiumPizza implements Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing Premium Pizza" );
    }
}

interface PizzaFactory{
    Pizza createPizza();
}
class NormalPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createPizza(){
        return new NormalPizza();
    }
}
class PremiumPizzaFactory implements PizzaFactory{
    @Override
    public Pizza createPizza(){
        return new PremiumPizza();
    }
}


public class FactoryMethod {
    public static void main(String[] args){
        PizzaFactory factory=new NormalPizzaFactory();
        Pizza pizza=factory.createPizza();
        pizza.prepare();
    }
}
