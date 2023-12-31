public class Main {
    public class Singleton {
        private static Singleton instance;

        private Singleton() {
            // constructor privat
        }

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
