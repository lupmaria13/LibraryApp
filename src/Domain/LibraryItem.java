package Domain;

public class LibraryItem {
    private int yearOfPublication;
    private String title;
    private String author;

    public LibraryItem(int yearOfPublication, String title, String author) {
        this.yearOfPublication = yearOfPublication;
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return "Domain.LibraryItem{" +
                "Year of publication:" + yearOfPublication +
                "Title: " + title + '\'' +
                "Author: " + author + '\'' +
                '}';
    }
}