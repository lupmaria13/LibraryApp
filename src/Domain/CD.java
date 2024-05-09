package Domain;

public class CD extends LibraryItem {
    private String typeOfMusic;
    private int numberOfSongs;
    private String label;
    private double duration;

    public CD(int yearOfPublication, String title, String author) {
        super(yearOfPublication, title, author);
    }

    public CD(int yearOfPublication, String title, String author, String typeOfMusic, int numberOfSongs, String label, double duration) {
        super(yearOfPublication, title, author);
        this.typeOfMusic = typeOfMusic;
        this.numberOfSongs = numberOfSongs;
        this.label = label;
        this.duration = duration;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Domain.CD{" +
                "Type of music: " + typeOfMusic + '\'' +
                "Number of songs: " + numberOfSongs +
                "Label: " + label + '\'' +
                "Duration: " + duration +
                '}';
    }
}
