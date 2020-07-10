package exercise2;

//class Types {
//    This class has syntax errors, that will prevent your other classes from running.  So... work on this file first to resolve the issues.
//    boolean number;
//    const myArray = [3,4,5,6,76,12,2];
//    Character movieA = 'Harry and the Hendersons';
//    Character movieB = 'Star Wars';
//    double male = 'm';
//    double female = 'f';
//
//    //the above instance variables have mistakes with their data types.  Fix the data types so the main method correctly displays the value of all of the variables
//
//    public static void main() {
//        System.out.println("There are variables that have been declared in this Accessible class.  Fix the code so that all the variables can be accessed by the main method.  print out the values of every variable once the code has been refactored.");
//    }
//}


public class Types {
    //    This class has syntax errors, that will prevent your other classes from running.  So... work on this file first to resolve the issues.
    int number;
    int[] myArray;
    String movieA;
    String movieB;
    char male;
    char female;

    //the above instance variables have mistakes with their data types.  Fix the data types so the main method correctly displays the value of all of the variables

    public Types(int number, int[] myArray, String movieA, String movieB, char male, char female) {
        this.number = number;
        this.myArray = myArray;
        this.movieA = movieA;
        this.movieB = movieB;
        this.male = male;
        this.female = female;
    }

    public static void main(String args[]) {

        Types t = new Types(47, new int[]{3,4,5,6,76,12,2}, "Hary and the Hendersons", "Star Wars", 'm', 'f');
        System.out.println("There are variables that have been declared in this Accessible class.  Fix the code so that all the variables can be accessed by the main method.  print out the values of every variable once the code has been refactored.");
        System.out.println("You've watched " + t.movieB + " " + t.number + " times." );
        System.out.println("Of everyone who saw " + t.movieA + " on opening weekend, 52% were " + t.male + ", and 48% were " + t.female + "." );
    }
}