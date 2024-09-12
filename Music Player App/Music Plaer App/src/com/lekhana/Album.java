package com.lekhana;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String title;
    private ArrayList<Song> songs;

    public Album(String name, String title) {
        this.name = name;
        this.title = title;
        this.songs = new ArrayList<>();
    }
    public Album(){

    }

    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getSong_name().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println(title+" successfully added to the list");
            return true;
        }
        else{
//            System.out.println("Song with name "+title+"a lready exists in the list");
            return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> Playlist){
        int index = trackNumber-1;
        if(index>0 && index <= this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
//        System.out.println("This album does not have song with track Number "+trackNumber);
        return false;
    }

    public boolean addToPlayList(String title,LinkedList<Song> Playlist){
        for(Song checkedSong : this.songs){
            if(checkedSong.getSong_name().equals(title)){
                Playlist.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title+" there is no suc song in album");
        return false;
    }
}
