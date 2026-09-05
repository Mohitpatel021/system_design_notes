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

class PizzaFactory{

    public static Pizza createPizza(String type){
        if("normal".equals(type)){
            return new NormalPizza();
        }
        else if("premium".equals(type)){
            return new PremiumPizza();
        }
        else{
            throw new IllegalArgumentException("Unknown pizza type: "+type);
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args){
    Pizza pizza=PizzaFactory.createPizza("normal");
    pizza.prepare();
    }
}
