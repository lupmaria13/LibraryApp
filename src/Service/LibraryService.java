package Service;

import Domain.Book;
import Domain.CD;
import Repository.BookRepository;
import Repository.CDRepository;
import Repository.Repository;

import java.util.List;

public class LibraryService {
    private final Repository <Long,Book> bookRepository;
    private final Repository <Long,CD> cdRepository;

    public LibraryService(Repository <Long,Book> bookRepository, Repository <Long,CD> cdRepository) {
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
    }

    // Crud book
    public void createBook(int yearOfPublication, String title, String author, String type, int numberOfPages, String color){
        Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
        bookRepository.addItem(book);

    }
    public void updateBook(int yearOfPublicationNew, String titleNew, String authorNew, String typeNew, int numberOfPagesNew, String colorNew, String titleOld){
        Book bookNew= new Book(yearOfPublicationNew,titleNew,authorNew,typeNew,numberOfPagesNew,colorNew);
        List<Book> list = bookRepository.findByTitle(titleOld);
        bookNew.setId(list.get(0).getId());
        bookRepository.updateItem(bookNew);
    }

    public void deleteBook(String title){
        List<Book> list = bookRepository.findByTitle(title);
        bookRepository.removeItem(list.get(0).getId());

    }
    public Book findBook( String title){
        List<Book> list = bookRepository.findByTitle(title);
         return list.get(0);
    }

    public void createCD(int yearOfPublication, String title, String author, String typeOfMusic, int numberOfSongs, String label, double duration){
        CD cdNew= new CD( yearOfPublication, title, author, typeOfMusic, numberOfSongs, label, duration);
         cdRepository.addItem(cdNew);
    }

    public void updateCD(int yearOfPublicationNew, String titleNew, String authorNew, String typeOfMusicNew, int numberOfSongsNew, String labelNew, double durationNew,  String titleOld){
        CD cdNew= new CD(yearOfPublicationNew, titleNew, authorNew, typeOfMusicNew, numberOfSongsNew, labelNew, durationNew);
        List<CD> list = cdRepository.findByTitle(titleOld);
        cdNew.setId(list.get(0).getId());
        cdRepository.updateItem(cdNew);
    }
    public void deleteCD(String title){
        List<CD> list = cdRepository.findByTitle(title);
        cdRepository.removeItem(list.get(0).getId());

    }
    public CD findCD(String title){
        List<CD> list = cdRepository.findByTitle(title);
        return list.get(0);

    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllItems();
    }
    public List<CD> getAllCDs(){
        return cdRepository.getAllItems();
    }
    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }
    public List<CD> searchCDsByGenre(String genre) {
        return cdRepository.findCDsByGenre(genre);
    }

    public void loanBook(String title) {
        bookRepository.loan(title);
    }

    public void returnBook(String title) {
        bookRepository.returnLoan(title);
    }
    public void loanCD(String title) {
        cdRepository.loan(title);
    }

    public void returnCD(String title) {
        cdRepository.returnLoan(title);
    }
    public void reserveBook(String title) {
        bookRepository.reserved(title);
    }

    public void reserveCD(String title) {
        cdRepository.reserved(title);
    }

    public  List<Book> getAllLoanBooks() {
     return bookRepository.getAllItems();
    }
    public  List<CD> getAllLoanCDs() {
        return cdRepository.getAllLoanCDs();
    }

}
//----------------




