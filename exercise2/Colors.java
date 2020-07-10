/* public class Colors {

    String[] colorful(String[] strings) {
        // For the given strings, keep all the strings that begin with a color ("red", "yellow", "green", "blue", etc.) return an array of strings that start with a color.  discard all the other strings.  If no strings start with a color in the input array, return an empty array.
        return new String[]{};
    }

    public static void main(String[] args) {
        Colors code = new Colors();
        code.colorful(new String[]{"bluebird","red herring", "yellow bumblebee","black spider", "green monkey","pink","great gatsby","feeding frenzy","black bird","widowmaker","quran","bible","torah"});
        System.out.println("This is the Colors class");
    }
} */

public class Colors {
    String[] colorful;

    public Colors(String[] strings) {

        // For the given strings, keep all the strings that begin with a color ("red", "yellow", "green", "blue", etc.)
        // return an array of strings that start with a color.  discard all the other strings.
        // If no strings start with a color in the input array, return an empty array.

        this.colorful = strings;
    }

    public static void main(String[] args) {

        String[] strings = {"bluebird", "red herring", "yellow bumblebee", "black spider", "green monkey", "pink", "great gatsby", "feeding frenzy", "black bird", "widowmaker", "quran", "bible", "torah"};
        Colors code = new Colors(strings);
        System.out.println("This is the Colors class");
        String[] r =
                java.util.Arrays.stream(code.colorful).filter((s) ->
                        s.startsWith("blue") || s.startsWith("red") || s.startsWith("yellow") || s.startsWith("black")
                                || s.startsWith("green") || s.startsWith("pink") || s.startsWith("purple") || s.startsWith("orange")).toArray(String[]::new);
        code.colorful = r;

        for (String i : code.colorful) {
            System.out.println(i);
        }
    }


}