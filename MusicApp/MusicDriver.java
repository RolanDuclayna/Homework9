package Homework9.MusicApp;

import java.util.List;

public class MusicDriver {
    public static void main(String[] args) {
        SongService realService = new RealSongService();
        SongService songService = new SongServiceProxy(realService);

        System.out.println("First ID search:");
        System.out.println(songService.searchById(0));

        System.out.println("\nRepeating the same ID search:");
        System.out.println(songService.searchById(0));

        System.out.println("\nFirst title search:");
        List<Song> titleResults = songService.searchByTitle("Blinding Lights");

        for (Song song : titleResults) {
            System.out.println(song);
        }

        System.out.println("\nRepeating the same title search:");
        titleResults = songService.searchByTitle("Blinding Lights");

        for (Song song : titleResults) {
            System.out.println(song);
        }

        System.out.println("\nFirst album search:");
        List<Song> albumResults = songService.searchByAlbum("Future Nostalgia");

        for (Song song : albumResults) {
            System.out.println(song);
        }

        System.out.println("\nRepeating the same album search:");
        albumResults = songService.searchByAlbum("Future Nostalgia");

        for (Song song : albumResults) {
            System.out.println(song);
        }
    }
}
