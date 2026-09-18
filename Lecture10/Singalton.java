package Lecture10;

class Singalton {
   private static Singalton INSTANCE = null;

   private Singalton() {
   }

   public static Singalton getInstance() {
      if (INSTANCE == null) {
         synchronized(Singalton.class) {
            if (INSTANCE == null) {
               INSTANCE = new Singalton();
            }
         }
      }

      return INSTANCE;
   }
}
