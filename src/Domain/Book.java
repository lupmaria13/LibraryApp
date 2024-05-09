package Domain;

public class Book extends LibraryItem {
     private String type;
     private int numberOfPages;
     private String color;

     public Book(int yearOfPublication, String title, String author) {
          super(yearOfPublication, title, author);
     }

     public Book(int yearOfPublication, String title, String author, String type, int numberOfPages, String color) {
          super(yearOfPublication, title, author);
          this.type = type;
          this.numberOfPages = numberOfPages;
          this.color = color;
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

     @Override
     public String toString() {
          return "Domain.Book{" +
                  "Type: " + type + '\'' +
                  "NumberOfPages: " + numberOfPages +
                  "Color: " + color + '\'' +
                  '}';
     }
}


