package pckg;

import pckg.Class.Reader;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader("src/pckg/Testing.java");
        reader.readFromFile("src/pckg/Testing.java");
    }
}
