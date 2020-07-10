package exercise2;

//public class Statically {
    //Once you have finished getting statistically.js to run, refactor the code here in Java.
// }


public class Statically {
    private static String glue = "Epoxy";
    private static String jello = "Jello";

    private static void moveAndShake() {
        System.out.println("Never stagnate in life.  Be agile, change, and improve...");
    }

    private static void stubborn() {
        Statically.moveAndShake();
        System.out.println("Please don't make me change... I just don't like it...");
    }

    private static void explain() {
        Statically.stubborn();
        System.out.println(Statically.glue);
        System.out.println("The static keyword does behave similarly as a kind of global access modifier in JS as it does in Java, because both operate in the class instead of the instance. This is why I had to change the 'stats.methods()' and 'stats.glue' calls to the class name 'Statically' to get them to work. A static class can return an instance in both JS and Java. The way it accesses variables is also the similar. The 'static' keyword seems to be used far less in JS than in Java. This is most likely the case because JS isn't always using OOP principles such as encapsulation/abstraction and often relies on functional programming methodologies.");
    }

    public static void main(String[] args) {
        Statically stats = new Statically();

        Statically.moveAndShake();
        Statically.stubborn();
        Statically.explain();

        System.out.println(Statically.glue);
        System.out.println(stats.jello);
    }

};
