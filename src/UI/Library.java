package UI;

import Domain.Book;
import Domain.CD;
import Service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class Library {
    public Library(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    private LibraryService libraryService;
    public void createBook(){
        Scanner scanner= new Scanner(System.in);
        int yearOfPublication,numberOfPages;
        String title, author, type, color;
        System.out.println("______________________");
        System.out.println("Title: ");
        title=scanner.next();
        System.out.println("Author: ");
        author=scanner.next();
        System.out.println("Type: ");
        type=scanner.next();
        System.out.println("Color: ");
        color=scanner.next();
        System.out.println("yearOfPublication: ");
        yearOfPublication=scanner.nextInt();
        System.out.println("numberOfPages ");
        numberOfPages=scanner.nextInt();
       libraryService.createBook(yearOfPublication,title,author,type,numberOfPages,color);

    }
    public void updateBook(){
        Scanner scanner= new Scanner(System.in);
        int yearOfPublicationOld,numberOfPagesOld;
        String titleOld, authorOld, typeOld, colorOld;
        System.out.println("______________________");
        System.out.println("Old title:  ");
        titleOld=scanner.next();
        System.out.println("Old Author: ");
        authorOld=scanner.next();
        System.out.println("Old type:  ");
        typeOld=scanner.next();
        System.out.println("Old color: ");
        colorOld=scanner.next();
        System.out.println("Old year of publication: ");
        yearOfPublicationOld=scanner.nextInt();
        System.out.println("Old number of pages: ");
        numberOfPagesOld=scanner.nextInt();

        int yearOfPublicationNew,numberOfPagesNew;
        String titleNew, authorNew, typeNew, colorNew;
        System.out.println("______________________");
        System.out.println("New title: ");
        titleNew=scanner.next();
        System.out.println("New author: ");
        authorNew=scanner.next();
        System.out.println("New type: ");
        typeNew=scanner.next();
        System.out.println("New color: ");
        colorNew=scanner.next();
        System.out.println("New year of publication: ");
        yearOfPublicationNew=scanner.nextInt();
        System.out.println("New number of pages: ");
        numberOfPagesNew=scanner.nextInt();
        libraryService.updateBook(yearOfPublicationOld,titleOld,authorOld,typeOld,numberOfPagesOld,colorOld,yearOfPublicationNew,titleNew,authorNew,typeNew,numberOfPagesNew,colorNew );


    }


    public void createCD(){
        Scanner scanner= new Scanner(System.in);
        int yearOfPublication, numberOfSongs;
        String title, author, typeOfMusic, label;
        double duration;
        System.out.println("______________________");
        System.out.println("Title: ");
        title=scanner.next();
        System.out.println("Author: ");
        author=scanner.next();
        System.out.println("Type of music: ");
        typeOfMusic=scanner.next();
        System.out.println("Label: ");
        label=scanner.next();
        System.out.println("Year of publication: ");
        yearOfPublication=scanner.nextInt();
        System.out.println("Number of songs: ");
        numberOfSongs=scanner.nextInt();
        System.out.println("Duration: ");
        duration=scanner.nextInt();
        libraryService.createCD(yearOfPublication,title,author,typeOfMusic,numberOfSongs,label,duration);
    }

    public void updateCD(){
        Scanner scanner= new Scanner(System.in);
        int yearOfPublicationOld, numberOfSongsOld;
        String titleOld, authorOld, typeOfMusicOld, labelOld;
        double durationOld;
        System.out.println("______________________");
        System.out.println("Old Title: ");
        titleOld=scanner.next();
        System.out.println("Old Author: ");
        authorOld=scanner.next();
        System.out.println("Old music type: ");
        typeOfMusicOld=scanner.next();
        System.out.println("Old label: ");
        labelOld=scanner.next();
        System.out.println("Old year of publication: ");
        yearOfPublicationOld=scanner.nextInt();
        System.out.println("Old number of songs: ");
        numberOfSongsOld=scanner.nextInt();
        System.out.println("Old duration: ");
        durationOld=scanner.nextInt();

        int yearOfPublicationNew, numberOfSongsNew;
        String titleNew, authorNew, typeOfMusicNew, labelNew;
        double durationNew;
        System.out.println("______________________");
        System.out.println("New title: ");
        titleNew=scanner.next();
        System.out.println("New author: ");
        authorNew=scanner.next();
        System.out.println("New type of music: ");
        typeOfMusicNew=scanner.next();
        System.out.println("New label: ");
        labelNew=scanner.next();
        System.out.println("New year of publication: ");
        yearOfPublicationNew=scanner.nextInt();
        System.out.println("New number of songs:  ");
        numberOfSongsNew=scanner.nextInt();
        System.out.println("New duration: ");
        durationNew=scanner.nextInt();
        libraryService.updateCD(yearOfPublicationOld,titleOld,authorOld,typeOfMusicOld,numberOfSongsOld,labelOld,durationOld, yearOfPublicationNew,titleNew,authorNew,typeOfMusicNew,numberOfSongsNew,labelNew,durationNew);
    }

    public void deleteBook(){
        Scanner scanner= new Scanner(System.in);
        String title;
        System.out.println("______________________");
        System.out.println("Title: ");
        title=scanner.next();
        libraryService.deleteBook(title);
    }
    public void deleteCD(){
        Scanner scanner= new Scanner(System.in);
        String title;
        System.out.println("______________________");
        System.out.println("Title: ");
        title=scanner.next();
        libraryService.deleteCD(title);

    }

    public void findCD() {
        Scanner scanner = new Scanner(System.in);
        String title;
        System.out.println("______________________");
        System.out.println("The title of the CD you are looking for: ");
        title = scanner.next();
        CD foundCD = libraryService.findCD(title);
        System.out.println("__________CD Informations____________");
        System.out.println("Title: " + foundCD.getTitle());
        System.out.println("Author: " + foundCD.getAuthor());
        System.out.println("Type of music: " + foundCD.getTypeOfMusic());
        System.out.println("Label: " + foundCD.getLabel());
        System.out.println("Year of publication: " + foundCD.getYearOfPublication());
        System.out.println("Number of songs: " + foundCD.getNumberOfSongs());
        System.out.println("Duration: " + foundCD.getDuration());
    }

    public void findBook() {
        Scanner scanner = new Scanner(System.in);
        String title;
        System.out.println("____________Book informations__________");
        System.out.println("The title of the book you are looking for: ");
        title = scanner.next();
        Book foundBook = libraryService.findBook(title);
        System.out.println("______________________");
        System.out.println("Title: " + foundBook.getTitle());
        System.out.println("Author: " + foundBook.getAuthor());
        System.out.println("Type: " + foundBook.getType());
        System.out.println("Color: " + foundBook.getColor());
        System.out.println("Year of publication: " + foundBook.getYearOfPublication());
        System.out.println("Number of pages: " + foundBook.getNumberOfPages());
    }

    public void getAllBooks() {
        System.out.println("____________Books informations__________");
        List<Book> bookList = libraryService.getAllBooks();
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Type: " + book.getType());
            System.out.println("Color: " + book.getColor());
            System.out.println("Year of publication: " + book.getYearOfPublication());
            System.out.println("Number of pages: " + book.getNumberOfPages());
            System.out.println("______________________");
        }
    }

    public void getAllCDs() {
        System.out.println("____________CDs information__________");
        List<CD> cdList = libraryService.getAllCDs();
        for (CD cd : cdList) {
            System.out.println("Title: " + cd.getTitle());
            System.out.println("Author: " + cd.getAuthor());
            System.out.println("Type of music: " + cd.getTypeOfMusic());
            System.out.println("Label: " + cd.getLabel());
            System.out.println("Year of publication: " + cd.getYearOfPublication());
            System.out.println("Number of songs: " + cd.getNumberOfSongs());
            System.out.println("Duration: " + cd.getDuration());
            System.out.println("______________________");
        }
    }
//--------------------------------------------
public void findBooksByAuthor() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the author's name:");
    String author = scanner.nextLine();
    List<Book> bookList = libraryService.findBooksByAuthor(author);
    if (bookList.isEmpty()) {
        System.out.println("No books found for author: " + author);
    } else {
        for (Book book : bookList) {
            System.out.println(book); // Asigură-te că metoda toString() din Book este implementată adecvat
        }
    }
}

    public void searchCDsByGenre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the music genre:");
        String genre = scanner.nextLine();
        List<CD> cds = libraryService.searchCDsByGenre(genre);
        if (cds.isEmpty()) {
            System.out.println("No CDs found for genre: " + genre);
        } else {
            for (CD cd : cds) {
                System.out.println(cd);
            }
        }
    }

    public void loanBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book to loan:");
        String title = scanner.nextLine();
        libraryService.loanBook(title);
    }

    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book to return:");
        String title = scanner.nextLine();
        libraryService.returnBook(title);
    }
    public void loanCD() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the CD to loan:");
        String title = scanner.nextLine();
        libraryService.loanCD(title);
    }

    public void returnCD() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the CD to return:");
        String title = scanner.nextLine();
        libraryService.returnCD(title);
    }
    public void reserveBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book to reserve:");
        String title = scanner.nextLine();
        libraryService.reserveBook(title);
    }

    public void reserveCD() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the CD to reserve:");
        String title = scanner.nextLine();
        libraryService.reserveCD(title);
    }

    public void getallloanbooks() {
      List<Book> loanedBook = libraryService.getallloanbooks();
      for (Book book: loanedBook) {
          System.out.println(book);
      }
    }

    public void getallloanCDs() {
        List<CD> loanedCD = libraryService.getallloanCDs();
        for (CD cd: loanedCD) {
            System.out.println(cd);
        }
    }

    public void menu(){
        System.out.println(" 0.Exit ");
        System.out.println(" 1.Add book ");
        System.out.println(" 2.Change book ");
        System.out.println(" 3.Delete book ");
        System.out.println(" 4.Find book");
        System.out.println(" 5.Show of all books ");
        System.out.println(" 6.Add CD ");
        System.out.println(" 7.Change CD ");
        System.out.println(" 8.Delete CD ");
        System.out.println(" 9.Find CD ");
        System.out.println(" 10.Show of all CD ");
        System.out.println(" 11.Search books by author ");
        System.out.println(" 12.Search CDs by music genre ");
        System.out.println(" 13.Book loan ");
        System.out.println(" 14.Book return ");
        System.out.println(" 15.CD loan ");
        System.out.println(" 16.CD return ");
        System.out.println(" 17.Book reservation ");
        System.out.println(" 18.CD reservation");
        System.out.println(" 19. Show all loan books");
        System.out.println(" 20. Show all loan CDs ");
    }
    public void run(){
        boolean ready=false;
        libraryService.createCD(1982, "Thriller", "Michael Jackson", "Pop", 9, "Epic Records", 42.28);
        libraryService.createCD(1980, "Back in Black", "AC/DC", "Hard Rock", 10, "Atlantic Records", 42.11);
        libraryService.createCD(1969, "Abbey Road", "The Beatles", "Rock", 17, "Apple Records", 47.23);
        libraryService.createCD(1973, "The Dark Side of the Moon", "Pink Floyd", "Progressive Rock", 10, "Harvest Records", 42.49);
        libraryService.createCD(1977, "Rumours", "Fleetwood Mac", "Rock", 11, "Warner Bros. Records", 39.31);

        libraryService.createBook(1997, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 223, "Black");
        libraryService.createBook(1960, "To Kill a Mockingbird", "Harper Lee", "Fiction", 281, "Red");
        libraryService.createBook(1949, "1984", "George Orwell", "Dystopian", 328, "Blue");
        libraryService.createBook(1865, "Alice's Adventures in Wonderland", "Lewis Carroll", "Fantasy", 272, "Yellow");
        libraryService.createBook(1954, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1178, "Green");


        while(!ready){
            menu();
            String option;
            System.out.println(" Give the option: ");
            Scanner scanner= new Scanner(System.in);
            option= scanner.next();
            switch(option){
                case "1":{
                    createBook();
                    break;
                }
                case "2":{
                    updateBook();
                    break;
                }
                case "3":{
                    deleteBook();
                    break;
                }
                case "4":{
                    findBook();
                    break;
                }
                case "5":{
                    getAllBooks();
                    break;
                }
                case "6":{
                    createCD();
                    break;
                }
                case "7":{
                    updateCD();
                    break;
                }
                case "8":{
                    deleteCD();
                    break;
                }
                case "9":{
                    findCD();
                    break;
                }
                case "10":{
                    getAllCDs();
                    break;
                }
                case "11":{
                    findBooksByAuthor();
                    break;
                }
                case "12":{
                    searchCDsByGenre();
                    break;
                }
                case "13":{
                    loanBook();
                    break;
                }
                case "14":{
                    returnBook();
                    break;
                }
                case "15":{
                    loanCD();
                    break;
                }
                case "16":{
                    returnCD();
                    break;
                }
                case "17":{
                    reserveBook();
                    break;
                }
                case "18":{
                    reserveCD();
                    break;
                }
                case "19":{
                    getallloanbooks();
                    break;
                }
                case "20":{
                    getallloanCDs();
                    break;
                }
                case "0":{
                    ready=true;
                    break;
                }


            }
        }
    }
}
