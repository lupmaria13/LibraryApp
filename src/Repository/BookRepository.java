package Repository;

import Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Repository <Book>{
    private List<Book> bookList = new ArrayList<>();
    @Override
    public Book addItem(Book item) {
        bookList.add(item);
        return item;
    }

    @Override
    public void removeItem(Book item) {
        bookList.remove(item);
        System.out.println("Deleted: " + item);
    }

    @Override
    public Book findItem(String title) {
        for (Book book: bookList){
            if( book.getTitle().equals(title))
                return book;
        }
        return new Book(0, "", "" );
    }

    @Override
    public Book updateItem(Book oldItem, Book newItem) {
        for (int i=0; i<bookList.size(); i++){
            Book book=bookList.get(i);
            if( book.getTitle().equals(oldItem.getTitle()) && book.getAuthor().equals(oldItem.getAuthor())) {
                bookList.set(i, newItem);
                return newItem;
            }
        }
        return new Book(0, "", "" );
    }

    @Override
    public List<Book> getAllItems() {
        return bookList;
    }
}
