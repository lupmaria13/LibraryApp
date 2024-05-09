package Repository;

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
}
