import Domain.Book;
import Domain.CD;
import Repository.BookRepository;
import Repository.CDRepository;
import Repository.Repository;
import Service.LibraryService;
import UI.Library;

import java.io.FileReader;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String dbPath = "C:\\Users\\User\\IdeaProjects\\Tema2\\src\\bd.properties";
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Properties props = new Properties();
        try {
            props.load(new FileReader(dbPath));
        } catch (Exception var13) {
            System.out.println(var13);
        }
        Repository <Long,Book> bookRepository = new BookRepository(props);
        Repository <Long, CD> cdRepository = new CDRepository(props);
        LibraryService libraryService = new LibraryService(bookRepository, cdRepository);
        Library library= new Library(libraryService);
        library.run();
    }
}