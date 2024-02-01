package solutions._07.classes;

public class Song
{
    private String name;
    private String artist;
    private String album = null;
    private int duration;

    public Song(String name, String artist, int duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public String getArtistName() {
        return this.artist;
    }

    public String getAlbumName() {
        if (this.isPartOfAnAlbum()) {
            return this.album;
        }
        else {
            return "Ukjent";
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setArtistName(String value) {
        this.artist = value;
    }

    public void setAlbumName(String value) {
        this.album = value;
    }

    public boolean isPartOfAnAlbum() {
        return this.album != null;
    }
}
