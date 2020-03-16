import java.util.*;

public class Movies {
    private LinkedList<String> titles = new LinkedList<>(); // titles/years as strings
    private TreeMap<String, String> tree_map = new TreeMap<>(); // titles/years as keys/values
    private LinkedList<Movie> list; // all data from file/s
    public Movies() { // constructor
        list = new LinkedList<Movie>();
    }
    public void convert(ArrayList<ArrayList<String>> array) { 
        // converter from 2D String ArrayList to Movie LinkedList
        LinkedList<Movie> movies = new LinkedList<>();
        for (ArrayList<String> row : array) {
            int ID = Integer.parseInt(row.get(0));
            String title = row.get(1); 
            titles.add(title); // adding title strings (including years) to String LinkedList
            String genre = row.get(2);
            Movie movie = new Movie(ID, title, genre); 
            movies.add(movie);
        }
        list = movies;
    }
    public void toTreeMap() {
        // converter from titles (String LinkedList) to TreeMap (keys=titles, values=years)  
        String s = "";
        String n = "";
        String l = "";
        for (int i = 0; i < titles.size(); i++) {
            s = titles.get(i);
            n = s.replaceAll("[^0-9]", "");
            l = s.replaceAll("[0-9()]", "");
            tree_map.put(l, n);
        }
    }
    public void printTree() {
        // full tree printer
        for (Map.Entry<String, String> entry : tree_map.entrySet()) {
            System.out.println("[" + entry.getKey() 
                               + ", " + entry.getValue() + "]"); 
        }
    }
    public void printSubTree(String first, String last) {
        // partial tree printer
        System.out.println(tree_map.subMap(first, last));
    }
    public LinkedList<Movie> getList() {
        // LinkedList getter
        return list;
    }
    public void printList() {
        // LinkedList printer
        for (Movie m : list) {
            System.out.println(m + " ");
        }
    }
    public void printTitles() {
        // strings of titles (including years) printer
        for (String t : titles) {
            System.out.println(t + " ");
        }
    }
    public void sortList() {
        // LinkedList sort
        Collections.sort(list);
    }
    public class Movie implements Comparable {
        // nested class defines each node & implements Comparable for sorting
        private int ID;
        private String title;
        private String genre;
        public Movie() { // constructor
            this(0, " ", " ");
        }
        public Movie(int ID, String title, String genre) { // constructor
            this.ID = ID;
            this.title = title;
            this.genre = genre;
        }
        @Override
        public String toString() { // overriden toString (each node)
            return ID +" "+ title +" "+ genre;
        }
        @Override
        public int compareTo(Object o) { // overriden compareTo for soring
            Movie other = (Movie) o;
            int compared = this.title.compareTo(other.title);
            return compared;
        }
        @Override
        public boolean equals(Object o) { // overriden equals (not used yet) 
            if (o instanceof Movie) {
                return this.title.equals(((Movie) o).title);
            }
            else {
                return false;
            }
        }
    }
}
