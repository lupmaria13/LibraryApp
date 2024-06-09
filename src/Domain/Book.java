package Domain;

public class Book extends Entity<Long> {
     private String type;
     private int numberOfPages;
     private String color;
     private boolean isLoaned;
     private boolean isReserved;
     private int yearOfPublication;
     private String title;
     private String author;

     public Book(int yearOfPublication, String title, String author, String type, int numberOfPages,  String color) {
          this.type = type;
          this.numberOfPages = numberOfPages;
          this.color = color;
          this.isLoaned = false;
          this.isReserved = false;
          this.yearOfPublication = yearOfPublication;
          this.title = title;
          this.author = author;

     }

     public Book(String type, int numberOfPages, String color, boolean isLoaned, boolean isReserved) {
          this.type = type;
          this.numberOfPages = numberOfPages;
          this.color = color;
          this.isLoaned = isLoaned;
          this.isReserved = isReserved;
     }

     public Book() {
     }

     public int getYearOfPublication() {
          return yearOfPublication;
     }

     public void setYearOfPublication(int yearOfPublication) {
          this.yearOfPublication = yearOfPublication;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getAuthor() {
          return author;
     }

     public void setAuthor(String author) {
          this.author = author;
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


