package Lecture10;

import java.lang.reflect.Constructor;

class Singalton{
    private static Singalton INSTANCE=null;
    private Singalton(){

    }
    public static  Singalton getInstance(){
        if(INSTANCE==null){
            synchronized (Singalton.class){
                if(INSTANCE==null){
                    INSTANCE=new Singalton();
                }
            }
        }
        return INSTANCE;
    }
}


public class PracticeSet {
    public static void main(String[] args){
        try{
        Constructor<Singalton> construct=Singalton.class.getDeclaredConstructor();
        construct.setAccessible(true);
        Singalton instance1=construct.newInstance();
        Singalton instance2=construct.newInstance();
        System.out.println(instance1==instance2);

        }  catch(Exception e){
            e.printStackTrace();
        }

    }
}
