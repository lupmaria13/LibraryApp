import Repository.BookRepository;
import Repository.CDRepository;
import Service.LibraryService;
import UI.Library;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BookRepository bookRepository= new BookRepository();
        CDRepository cdRepository = new CDRepository();
        LibraryService libraryService = new LibraryService(bookRepository, cdRepository);
        Library library= new Library(libraryService);
        library.run();
    }
}