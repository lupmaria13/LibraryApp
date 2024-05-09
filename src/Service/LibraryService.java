package Service;

import Domain.Book;
import Domain.CD;
import Repository.BookRepository;
import Repository.CDRepository;

import java.util.List;

public class LibraryService {
    private BookRepository bookRepository;
    private CDRepository cdRepository;

    public LibraryService(BookRepository bookRepository, CDRepository cdRepository) {
        this.bookRepository = bookRepository;
        this.cdRepository = cdRepository;
    }

    // Crud book
    public void createBook(int yearOfPublication, String title, String author, String type, int numberOfPages, String color){
        Book book= new Book(yearOfPublication,title,author,type,numberOfPages,color);
        bookRepository.addItem(book);

    }
    public void updateBook(int yearOfPublicationOld, String titleOld, String authorOld, String typeOld, int numberOfPagesOld, String colorOld, int yearOfPublicationNew, String titleNew, String authorNew, String typeNew, int numberOfPagesNew, String colorNew){
        Book bookNew= new Book(yearOfPublicationNew,titleNew,authorNew,typeNew,numberOfPagesNew,colorNew);
        Book bookOld= new Book(yearOfPublicationOld,titleOld,authorOld,typeOld,numberOfPagesOld,colorOld);
        bookRepository.updateItem(bookOld,bookNew);

    }

    public void deleteBook(String title){
        Book book= bookRepository.findItem(title);
        bookRepository.removeItem(book);

    }
    public Book findBook( String title){
        Book book= bookRepository.findItem(title);
         return book;
    }

    public void createCD(int yearOfPublication, String title, String author, String typeOfMusic, int numberOfSongs, String label, double duration){
        CD cdNew= new CD( yearOfPublication, title, author, typeOfMusic, numberOfSongs, label, duration);
         cdRepository.addItem(cdNew);
    }

    public void updateCD(int yearOfPublicationNew, String titleNew, String authorNew, String typeOfMusicNew, int numberOfSongsNew, String labelNew, double durationNew, int yearOfPublicationOld, String titleOld, String authorOld, String typeOfMusicOld, int numberOfSongsOld, String labelOld, double durationOld){
        CD cdNew= new CD(yearOfPublicationNew, titleNew, authorNew, typeOfMusicNew, numberOfSongsNew, labelNew, durationNew);
        CD cdOld = new CD(yearOfPublicationOld, titleOld, authorOld, typeOfMusicOld, numberOfSongsOld, labelOld, durationOld);
        cdRepository.updateItem(cdOld, cdNew);
    }
    public void deleteCD(String title){
        CD cd =cdRepository.findItem(title);
        cdRepository.removeItem(cd);
    }
    public CD findCD(String title){
        CD cd =cdRepository.findItem(title);
        return cd;

    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllItems();
    }
    public List<CD> getAllCDs(){
        return cdRepository.getAllItems();
    }

}

