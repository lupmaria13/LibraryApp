package Repository;

import Domain.Book;
import Domain.CD;
import Domain.Entity;

import java.util.List;
import java.util.Optional;

// Crud= create read update delete
public interface Repository<ID,E extends Entity<ID>> {
    Optional<E> addItem(E item);
    Optional<E> removeItem(ID id);
    Optional<E> findItem(ID id);
    Optional<E> updateItem(E entity);
    List<E> getAllItems();
    default List<E> findByTitle(String title){
        throw new UnsupportedOperationException();
    }
    default List<Book> findByAuthor(String author){
        throw new UnsupportedOperationException();
    }
    default void loan(String title){
        throw new UnsupportedOperationException();
    }
    default void returnLoan(String title){
        throw new UnsupportedOperationException();
    }
    default void cancel(String title){
        throw new UnsupportedOperationException();
    }
    default void reserved(String title){
        throw new UnsupportedOperationException();
    }
    default List<CD> findCDsByGenre(String genre){
        throw new UnsupportedOperationException();
    }
    default List<CD> getAllLoanCDs(){
        throw new UnsupportedOperationException();
    }
    default List<Book> getAllLoanBooks(){
        throw new UnsupportedOperationException();
    }
}
