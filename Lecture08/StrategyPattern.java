package Lecture08;

interface Walkable{
    void walk();
}
class Walk implements Walkable{
    @Override
    public void walk(){
        System.out.println("Walking");
    }
}

class NoWalk implements Walkable{
    @Override
    public void walk(){
        System.out.println("No Walking");
    }
}

interface Flyable{
    void fly();
}

class Fly implements Flyable{
    @Override
    public void fly(){
        System.out.println("Flying");
    }
}
class NoFly implements Flyable{
    @Override
    public void fly(){
        System.out.println("No Flying");
    }
}
class Robot{
    private Walkable walkable;
    private Flyable flyable;

    public Robot(Walkable walkable,Flyable flyable){
        this.walkable=walkable;
        this.flyable=flyable;
    }
    public void performWalk(){
        this.walkable.walk();
    }
    public void performFly(){
        this.flyable.fly();
    }
}

public class StrategyPattern {
    public static void main(String[] args){
        Robot robot1=new Robot(new NoWalk(),new NoFly());
        robot1.performFly();
        robot1.performWalk();
    }
}
