package comparator;

import comparator.core.FileComparator;

public class Main {
    public static void main(String[] args) {

        try{
            FileComparator.Compare(args[0], args[1]);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Check your inputs");
        }
    }
}