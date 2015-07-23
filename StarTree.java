
import java.util.ArrayList;

public class StarTree {

    public static void main(String[] args) {

        String completed_tree = "incomplete";
        Integer number_of_levels = 3;

        if (args.length > 0) {

            // Exception handling while parsing CLI arguments, courtesy of:
            // https://docs.oracle.com/javase/tutorial/
            //                    essential/environment/cmdLineArgs.html
            try {

               number_of_levels = Integer.parseInt(args[0]);

            } catch (NumberFormatException e) {

                System.err.println("The first supplied argument must be an integer.");
                System.exit(1);

            }
        }

        completed_tree = build_tree(number_of_levels);
        System.out.println(completed_tree);

    }

    private static String build_tree(Integer levels) {

        String current_line = "";
        ArrayList<String> full_tree;
        String completed_tree = "";

        String spaces = "";
        String stars = "";
        Integer number_of_spaces_on_this_line = 0;
        Integer number_of_stars_on_this_line = 0;

        full_tree = new ArrayList<String>();

        for (Integer each_level = 1; each_level <= levels; each_level++) {

            for (Integer current_tier = 0; current_tier <= each_level; current_tier++) {

                number_of_spaces_on_this_line = levels - current_tier;

                number_of_stars_on_this_line = (current_tier * 2) + 1;

                // number_of_stars_on_this_line = ((levels - number_of_spaces_on_this_line) * 2) + 1;

                // Reference:
                // http://stackoverflow.com/a/16812721
                // This one is complicated to explain at first.
                // This puts a new String object into current_line.
                // The first parameter of this String object is
                // whatever the String contains, such as:
                //     new String("Hello")
                // So, this String contains an array full of chars.
                // This array full of chars is initialized with a
                // number; this number will populate the char array
                // with a number of null characters (ie, "\0").
                // These null characters are then all replaced with
                // spaces (ie, " ") using the String class's replace
                // method. ... I chose this because I wanted to
                // understand why String formatting wasn't easy by
                // default. It sort of is; it just isn't obvious.
                spaces = new String(
                        new char[number_of_spaces_on_this_line]
                    ).replace("\0", " ");

                stars = new String(
                        new char[number_of_stars_on_this_line]
                    ).replace("\0", "*");

                current_line = spaces + stars;

                full_tree.add(current_line);
            }
        }

        // Reference:
        // http://stackoverflow.com/a/599181
        for (String each_row : full_tree) {
            completed_tree += "\n" + each_row;
        }

        return completed_tree;

    }

}
