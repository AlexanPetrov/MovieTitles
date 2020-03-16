import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) throws IOException {      
        // Stack w/ absolute file name/s, (using one beacause it's a large sample)
        // can split it and/or add more as in assignment 2 
        Stack<String> stack = new Stack<>();
        stack.add("movies.csv"); // or
        // stack.add("/Users/alexanderpetrovski/Documents/DataStructuresClass/Assignments/MovieTitles/movies.csv");
        // filling up 2D ArrayList with data from files (Part I) 
        ArrayList<ArrayList<String>> array = new ArrayList<>();
        for (int i = 0; i < stack.size(); i++) {
            try (Scanner sc = new Scanner(new File(stack.get(i)))) {
                while (sc.hasNextLine()) {
                    array.add(toTokens(sc.nextLine()));
                }
            }
        }
        // functional calls
        Movies movies = new Movies(); // init
        movies.convert(array); // converting ArrayList to LinkedList
        movies.sortList(); // sorting LinkedList
        movies.printTitles(); // all titles printer (as one string including year) 
        movies.toTreeMap(); // converting to TreeMap
        movies.printTree(); // all titles printer as keys (titles) and values (years) 
        movies.printSubTree("Your Highness", "Zack and Miri Make a Porno"); // subtree printer
        // writing sorted data from LinkedList to txt. file
        File file = new File("input.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            LinkedList<Movies.Movie> list = movies.getList();
            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i));
            }
        }
    }
    public static ArrayList<String> toTokens(String line) {
        // filling up 2D ArrayList with data from files (Part II) 
        ArrayList<String> array = new ArrayList<String>();
        try (Scanner sc = new Scanner(line)) {
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                array.add(sc.next());
            }
            return array;
        }
    }
}
