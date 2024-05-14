package Repository;

import Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Repository <Book> {
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
        for (Book book : bookList) {
            if (book.getTitle().equals(title))
                return book;
        }
        return new Book(0, "", "");
    }

    @Override
    public Book updateItem(Book oldItem, Book newItem) {
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            if (book.getTitle().equals(oldItem.getTitle()) && book.getAuthor().equals(oldItem.getAuthor())) {
                bookList.set(i, newItem);
                return newItem;
            }
        }
        return new Book(0, "", "");
    }

    @Override
    public List<Book> getAllItems() {
        return bookList;
    }

    // implementez find din repository generic

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;

    }

    public void loanBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isLoaned()) {
                book.setLoaned(true);
                System.out.println("Book has been loaned: " + title);
                return;
            }
        }
        System.out.println("Book is not available for loan: " + title);
    }

    public void returnBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isLoaned()) {
                book.setLoaned(false);
                System.out.println("Book has been returned: " + title);
                return;
            }
        }
        System.out.println("Book was not loaned: " + title);
    }
    public void reserveBook(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isReserved()) {
                book.setReserved(true);
                System.out.println("Book has been reserved: " + title);
                return;
            }
        }
        System.out.println("Book is already reserved or not found: " + title);
    }

    public List<Book> getallloanbooks() {
        List<Book> bookListLoan = new ArrayList<>();
        for (Book book : bookList) {
            if (book.isLoaned() ) {
                bookListLoan.add(book);
            }
        }
        return bookListLoan;
    }

}
