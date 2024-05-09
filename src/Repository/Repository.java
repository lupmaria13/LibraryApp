package Repository;

import Domain.LibraryItem;

import java.util.List;

// Crud= create read update delete
public interface Repository<T> {
    T addItem(T item);
    void removeItem(T item);
    T findItem(String title);
    T updateItem(T oldItem, T newItem);
    List<T> getAllItems();



}
