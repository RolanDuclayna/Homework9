package Homework9.MusicApp;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private final List<Song> songs = new ArrayList<>();

    public RealSongService() {
        songs.add(new Song("Blinding Lights", "The Weeknd", "After Hours"));

        songs.add(new Song("Save Your Tears", "The Weeknd", "After Hours"));

        songs.add(new Song("Levitating", "Dua Lipa", "Future Nostalgia"));

        songs.add(new Song("Don't Start Now", "Dua Lipa", "Future Nostalgia"));

        songs.add(new Song("Shape of You", "Ed Sheeran", "Divide"));

        songs.add(new Song("Perfect", "Ed Sheeran", "Divide"));

        songs.add(new Song("Bad Guy", "Billie Eilish", "When We All Fall Asleep, Where Do We Go?"));
    }

    @Override
    public Song searchById(Integer songID) {
        delay();

        if (songID < 0 || songID >= songs.size()) {
            return null;
        }

        return songs.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay();

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }

        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay();

        List<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }

        return results;
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
