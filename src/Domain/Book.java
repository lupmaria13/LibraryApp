package Domain;

public class Book extends LibraryItem {
     private String type;
     private int numberOfPages;
     private String color;
     private boolean isLoaned;
     private boolean isReserved;

     public Book(int yearOfPublication, String title, String author) {
          super(yearOfPublication, title, author);
     }

     public Book(int yearOfPublication, String title, String author, String type, int numberOfPages, String color) {
          super(yearOfPublication, title, author);
          this.type = type;
          this.numberOfPages = numberOfPages;
          this.color = color;
          this.isLoaned=false;
          this.isReserved=false;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public int getNumberOfPages() {
          return numberOfPages;
     }

     public void setNumberOfPages(int numberOfPages) {
          this.numberOfPages = numberOfPages;
     }

     public String getColor() {
          return color;
     }

     public void setColor(String color) {
          this.color = color;
     }

     public boolean isLoaned() {
          return isLoaned;
     }

     public void setLoaned(boolean loaned) {
          this.isLoaned = loaned;
     }
     public boolean isReserved() {
          return isReserved;
     }

     public void setReserved(boolean reserved) {
          isReserved = reserved;
     }

     @Override
     public String toString() {
          return "Domain.Book{" +
                  "Type: " + type + '\'' +
                  "NumberOfPages: " + numberOfPages +
                  "Color: " + color + '\'' +
                  '}';
     }
}


