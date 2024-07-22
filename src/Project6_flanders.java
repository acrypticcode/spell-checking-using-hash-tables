//This program spellchecks a file given as a command line argument by the user and prints the misspelled words to the screen
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Project6_flanders {
    public static String removeNonLetDig(String s) {
        //removes non-letter digits surrounding a word
        int b = 0, e = s.length() - 1;

        // Trim from the beginning
        while (b <= e && !Character.isLetterOrDigit(s.charAt(b)))
            b++;

        // Trim from the end
        while (e >= b && !Character.isLetterOrDigit(s.charAt(e)))
            e--;

        if (b <= e)
            return s.substring(b, e + 1);
        else
            return null;
    }

    public static void main(String args[]) throws FileNotFoundException {
        //opens file for the spellcheck dictionary and the document to be spellchecked
        Scanner dictionary = new Scanner(new FileReader("dictionary.txt"));
        Scanner document = new Scanner(new FileReader(args[0]));
        //creates a hashtable
        StringHash.HashTable table = new StringHash.HashTable(2000);
        String word;
        //adds words in dictionary to hashtable
        while (dictionary.hasNext()) {
            table.put(dictionary.next().toLowerCase());
        }
        //checks each word in the document
        //if the word doesn't appear in the dictionary, the word is printed to the screen
        while (document.hasNext()) {
            word = removeNonLetDig(document.next());
            if (word != null){
                if (!table.get(word.toLowerCase())) {
                    System.out.println(word);
                }
            }
        }
    }
}