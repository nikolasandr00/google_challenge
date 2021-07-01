package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to represent a Playlist
 */
class VideoPlaylist {

    private final String name;
    private List<Video> list1 = new ArrayList<>();
    private boolean existing;

    public VideoPlaylist(String name) {
        this.name = name;
    }

    public void addVideo(String videoId) {
        list1.add(new Video(videoId));

    }

    public void removeVideo(String videoId) {
        for (int i = 0; i < list1.size(); i++) {
            String temp = list1.get(i).getVideoId();
            boolean removedElement = list1.remove(temp);
        }

    }

    public boolean clearPlaylist(String videoId) {
        list1.clear();
        if (list1.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(String videoId) {

        return list1.size() < 1;

    }

    public int Size() {
        return list1.size();
    }

    public void PrintPlaylistContent(String videoId){
        System.out.print("Index  : \t");
        for(int i=0; i<list1.size(); i++){
            System.out.print((i) + "\t");
        }
        System.out.print("\nElement:\t");

        for(int i=0; i<list1.size(); i++)
            System.out.print(list1.indexOf(i) + "\t");

        System.out.println("\n");
    }
    public boolean Search(String videoId){
        if(list1.contains(videoId)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    @Override
    public String toString() {
        return  "name=" + name ;
    }
    public boolean deletePlayList(String playlistName){
        list1=null;
        return true;

    }

}
