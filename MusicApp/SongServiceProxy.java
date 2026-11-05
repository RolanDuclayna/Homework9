package Homework9.MusicApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final SongService realSongService;

    private final Map<Integer, Song> idCache = new HashMap<>();
    private final Map<String, List<Song>> titleCache = new HashMap<>();
    private final Map<String, List<Song>> albumCache = new HashMap<>();

    public SongServiceProxy(SongService realSongService) {
        this.realSongService = realSongService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!idCache.containsKey(songID)) {
            System.out.println("Fetching song ID " + songID + " from server...");
            idCache.put(songID, realSongService.searchById(songID));
        } else {
            System.out.println("Getting song ID " + songID + " from cache...");
        }

        return idCache.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title.toLowerCase();

        if (!titleCache.containsKey(key)) {
            System.out.println("Searching for title \"" + title + "\" on server...");
            titleCache.put(key, realSongService.searchByTitle(title));
        } else {
            System.out.println("Getting title \"" + title + "\" from cache...");
        }

        return titleCache.get(key);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album.toLowerCase();

        if (!albumCache.containsKey(key)) {
            System.out.println("Searching for album \"" + album + "\" on server...");
            albumCache.put(key, realSongService.searchByAlbum(album));
        } else {
            System.out.println("Getting album \"" + album + "\" from cache...");
        }

        return albumCache.get(key);
    }
}
