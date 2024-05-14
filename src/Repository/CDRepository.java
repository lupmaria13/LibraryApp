package Repository;

import Domain.Book;
import Domain.CD;

import java.util.ArrayList;
import java.util.List;

public class CDRepository implements Repository<CD> {

    private List<CD> cdList = new ArrayList<>();
    @Override
    public CD addItem(CD item) {
        cdList.add(item);
        return item;
    }

    @Override
    public void removeItem(CD item) {
        cdList.remove(item);
        System.out.println("Deleted: " + item);

    }

    @Override
    public CD findItem(String title) {
        for (CD cd: cdList){
            if(cd.getTitle().equals(title))
                return cd;
        }
        return new CD(0, "", "");
    }

    @Override
    public CD updateItem(CD oldItem, CD newItem) {
        for(int i=0; i<cdList.size(); i++){
            CD cd=cdList.get(i);
            if (cd.getTitle().equals(oldItem.getTitle()) && cd.getAuthor().equals(oldItem.getAuthor())){
                cdList.set(i,newItem);
                return newItem;
            }
        }
        return new CD(0,"","");
    }

    @Override
    public List<CD> getAllItems() {
        return cdList;
    }

    public List<CD> findCDsByGenre(String genre) {
        List<CD> foundCDs = new ArrayList<>();
        for (CD cd : cdList) {
            if (cd.getTypeOfMusic().equalsIgnoreCase(genre)) {
                foundCDs.add(cd);
            }
        }
        return foundCDs;
    }
    public void loanCD(String title) {
        for (CD cd : cdList) {
            if (cd.getTitle().equalsIgnoreCase(title) && !cd.isLoaned()) {
                cd.setLoaned(true);
                System.out.println("CD has been loaned: " + title);
                return;
            }
        }
        System.out.println("CD is not available for loan: " + title);
    }

    public void returnCD(String title) {
        for (CD cd : cdList) {
            if (cd.getTitle().equalsIgnoreCase(title) && cd.isLoaned()) {
                cd.setLoaned(false);
                System.out.println("CD has been returned: " + title);
                return;
            }
        }
        System.out.println("CD was not loaned: " + title);
    }
    public void reserveCD(String title) {
        for (CD cd : cdList) {
            if (cd.getTitle().equalsIgnoreCase(title) && !cd.isReserved()) {
                cd.setReserved(true);
                System.out.println("CD has been reserved: " + title);
                return;
            }
        }
        System.out.println("CD is already reserved or not found: " + title);
    }

    public List<CD> getallloanCDs() {
        List<CD> cdListLoan = new ArrayList<>();
        for (CD cd : cdList) {
            if (cd.isLoaned() ) {
                cdListLoan.add(cd);
            }
        }
        return cdListLoan;
    }
}
