package solutions._07.classes;

import java.util.ArrayList;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.setName(name);
        this.setArtist(artist);
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getArtistName() {
        return this.name;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    private void setName(String value) {
        this.name = value;
    }

    private void setArtist(String value) {
        this.artist = value;
    }

    public boolean containsSong(Song song) {
        return this.songs.contains(song);
    }

    public void addSong(Song song) {
        if (!this.containsSong(song)) {
            song.setAlbumName(this.getName());
            this.songs.add(song);
        }
    }

    public int getTotalDuration() {
        int seconds = 0;

        for (Song song : this.songs) {
            seconds += song.getDuration();
        }

        return seconds;
    }

    public static void main(String[] args) {
        String artist = "Unknown Singer";

        Album album = new Album("Ukjente sanger", artist);

        Song song1 = new Song("Tilfeldighetens tanker", artist, 120);
        Song song2 = new Song("Kodetid", artist, 256);

        album.addSong(song1);
        album.addSong(song2);

        int songs = album.getSongs().size();

        System.out.printf("Albumet varer i %d sekunder og inneholder %d sang%s%n".formatted(
                album.getTotalDuration(),
                songs,
                songs > 1 ? "er" : ""
        ));
    }
}
