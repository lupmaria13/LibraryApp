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
        System.out.println("Number of songs: " + foundBook.getNumberOfPages());
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
            System.out.println("Number of songs: " + book.getNumberOfPages());
            System.out.println("______________________");
        }
    }

    public void getAllCDs() {
        System.out.println("____________CDs informations__________");
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
        System.out.println(" 12.Search for CDs by music genre ");
        System.out.println(" 13.Book loan ");
        System.out.println(" 14.Book return ");
        System.out.println(" 15.CD loan ");
        System.out.println(" 16.CD return ");
        System.out.println(" 17.Search books by author ");
        System.out.println(" 28.Search CDs by music genre ");
        System.out.println(" 29.Book reservation ");
        System.out.println(" 20.CD reservation");
    }
    public void run(){
        boolean ready=false;
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
                case "0":{
                    ready=true;
                    break;
                }

            }
        }
    }
}
