package com.designpattern.behavioural.iterator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Iterator<T> {
    boolean hasNext();
    T next();
}
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

class Playlist implements IterableCollection<String> {

    private List<String> songs;

    public Playlist(List<String> songs) {
        this.songs = songs;
    }

    @Override
    public Iterator<String> createIterator() {
        return new SongIterator(songs);
    }
}

class SongIterator implements Iterator<String> {
    private List<String>songs;
    private int position = 0;

    public SongIterator(List<String> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public String next() {
        return hasNext() ? songs.get(position++) : null;
    }
}

public class IteratorPatternDemo {
    public static void main(String[] args) {
        Playlist playlist = new Playlist(Arrays.asList("Song A", "Song B", "Song C"));
        Iterator<String>iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
