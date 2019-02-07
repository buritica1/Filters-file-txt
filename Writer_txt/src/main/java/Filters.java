import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Filters {

    public static void main(String[] args){

        Filters filter = new Filters();
        filter.run("../resources/writefilter.txt");
    }

    private void run( String fileText ) {

        try {

            ClassLoader loader = getClass().getClassLoader();
            File file = new File(loader.getResource(fileText).getFile());
            FileWriter writeText = new FileWriter("writetext.txt");

            Scanner campo = new Scanner(file);
            filterT(campo,writeText);
            campo = new Scanner(file);
            filterLetters(campo,writeText);
            campo = new Scanner(file);
            filterPalindromo(campo,writeText);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void filterT(Scanner campo, FileWriter writeText)throws IOException {
        writeText.write("Palabras con t/T\n");

        while (campo.hasNextLine()) {
            String words = campo.next();

            if (words.substring(0, 1).equalsIgnoreCase("t")) {
                writeText.write(words);
                writeText.write("\n");
            }
        }
        writeText.write("\n");
    }

    private void filterLetters(Scanner campo, FileWriter writeText)throws IOException {
        writeText.write("Palabras de 5 letras\n");

        while (campo.hasNextLine()) {
            String words = campo.next();

            if (words.length()==5) {
                writeText.write(words);
                writeText.write("\n");
            }
        }
        writeText.write("\n");
    }

    private void filterPalindromo(Scanner campo, FileWriter writeText)throws IOException {
        writeText.write("Palabras Palindromos\n");

        while (campo.hasNextLine()) {
            String words = campo.next();
            String invert = new StringBuilder(words).reverse().toString();

            if (invert.toLowerCase().equals(words.toLowerCase()) && words.length()>2) {
                writeText.write(words+"\n");
            }
        }
        writeText.close();
    }
}
