package com.lekhana;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album3","Thriller");

        album = new Album("Album1","AC/DC");
        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.00);
        albums.add(album);

        album = new Album("Album2","Eminem");
        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);
        albums.add(album);

        album.addSong("Thriller",5.57);
        album.addSong("Billie Jean",4.54);
        album.addSong("Beat It",4.18);
        album.addSong("Wanna Be Startin\' Somethin'",6.03);
        album.addSong("Human Nature",4.06);

        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT",playlist_1);
        albums.get(0).addToPlayList("Highway to hell",playlist_1);
        albums.get(1).addToPlayList("Rap god",playlist_1);
        albums.get(1).addToPlayList("Lose yourself",playlist_1);

        play(playlist_1);
    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forword = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size()==0){
            System.out.println("This playlist have nop songs");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist Complete");
                    quit = true;
                    break;
                case 1:
                    if(!forword){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forword = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now Playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("No song available reached to the end of the list");
                        forword = false;
                        }
                    break;
                case 2:
                    if(forword){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                            forword = false;
                        }
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing "+listIterator.previous().toString());
                        }
                        else{
                            System.out.println("We are at the first song");
                            forword = false;
                        }
                    }
                    break;
                case 3:
                    if(forword){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forword = false;
                        }
                        else {
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forword = true;
                        }else{
                            System.out.println("We have reached to the end of the list");
                        }
                        break;
                    }
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("Now Playing "+listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options \n press ");
        System.out.println("0 -> quit\n " +
                "1 -> play next song\n " +
                "2 -> play previous song\n " +
                "3 -> replay the current song\n" +
                " 4 -> list of all songs\n" +
                " 5 -> print all available options\n " +
                "6 -> delete current song\n ");
    }
    public static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------------------");
    }
}