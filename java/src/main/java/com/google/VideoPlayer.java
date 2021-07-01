package com.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VideoPlayer {

    List<VideoPlaylist> PlayL = new ArrayList<VideoPlaylist>();
    private VideoLibrary videoLibrary = new VideoLibrary();
    private int remainingTime = 0;
    private String current_video = null;
    private String previous_video = null;
    private boolean pause = false;
    private boolean stop = false;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();

    }
    Video vid1 = videoLibrary.getVideo("funny_dogs_video_id");
    Video vid2 = videoLibrary.getVideo("amazing_cats_video_id");
    Video vid3 = videoLibrary.getVideo("another_cat_video_id");
    Video vid4 = videoLibrary.getVideo("life_at_google_video_id");
    Video vid5 = videoLibrary.getVideo("nothing_video_id");

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {
        String arr[] = new String[videoLibrary.getVideos().size()];
        System.out.printf("Here's a list of all available videos: %n");

        for (int i = 0; i < videoLibrary.getVideos().size(); i++) {

            arr[i] = videoLibrary.getVideos().get(i).getTitle() + " ("
                    + videoLibrary.getVideos().get(i).getVideoId() + ") "
                    + videoLibrary.getVideos().get(i).getTags();
        }
        Arrays.sort(arr);

        for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
            System.out.printf("%s%n", arr[i]);
        }

    }

    public boolean playVideo(String videoId) {

        switch (videoId){
            case "funny_dogs_video_id":
                if(current_video == null) {
                    System.out.printf("Playing video: %s %n", vid1.getTitle());
                    current_video = vid1.getTitle();
                    setCurrent_video(current_video);
                }else {
                    System.out.println("Stopping video: " + current_video);
                    System.out.printf("Playing video: %s %n", vid1.getTitle());
                    current_video = vid1.getTitle();
                    setCurrent_video(current_video);
                }
                break;

            case "amazing_cats_video_id":
                if(current_video == null) {
                    System.out.printf("Playing video: %s %n", vid2.getTitle());
                    current_video = vid2.getTitle();
                    setCurrent_video(current_video);
                }
                else{
                    System.out.println("Stopping video: " + current_video);
                    System.out.printf("Playing video: %s %n", vid2.getTitle());
                    current_video = vid2.getTitle();
                    setCurrent_video(current_video);
                }
                break;

            case "another_cat_video_id":
                if(current_video == null) {
                    System.out.printf("Playing video: %s %n", vid3.getTitle());
                    current_video = vid3.getTitle();
                    setCurrent_video(current_video);
                }else{
                    System.out.println("Stopping video: " + current_video);
                    System.out.println("Playing video: " + vid3.getTitle());
                    current_video = vid3.getTitle();
                    setCurrent_video(current_video);
                }
                break;

            case "life_at_google_video_id":
                if(current_video == null) {
                    System.out.printf("Playing video: %s %n", vid4.getTitle());
                    current_video = vid4.getTitle();
                    setCurrent_video(current_video);
                }else{
                    System.out.println("Stopping video " + current_video);
                    System.out.println("Playing video: " + vid4.getTitle());
                    current_video = vid4.getTitle();
                    setCurrent_video(current_video);
                }
                break;

            case "nothing_video_id":
                if(current_video == null) {
                    System.out.printf("Playing video: %s %n", vid5.getTitle());
                    current_video = vid5.getTitle();
                    setCurrent_video(current_video);

                }else{
                    System.out.println("Stopping video: " + current_video);
                    System.out.println("Playing video: " + vid5.getTitle());
                    current_video = vid5.getTitle();
                    setCurrent_video(current_video);
                }
                break;

            default:
                System.out.println("Cannot play video: Video does not exist");
        }
        return true;
    }
    public void setCurrent_video (String videoplaying){
        current_video = videoplaying;
        getCurrent_video(current_video);
    }

    public String getCurrent_video(String videoplaying){
        return videoplaying;
    }
  /*  public boolean playVideo(String videoId) {

        for (Video v : videoLibrary.getVideos()) {
            if (videoId.equals(v.getVideoId())) {

                v.setPlaying(true);
                System.out.println("Now Playing : " + videoLibrary.getVideo(videoId));
                for (int i = v.getDuration(); i > 0; i--) {
                    remainingTime = i;
                    System.out.println(remainingTime);
                }
                return true;
            } else {
                System.out.println("Cannot Play video");
                return false;
            }

        }
        return  false;
    }*/

    public boolean stopVideo() {
        if(current_video != null){
            System.out.println("Stopping video: " + current_video);
            previous_video = current_video;
            setCurrent_video(null);
            stop = true;
        }
        else
            System.out.println("Cannot stop video: No video is currently playing");

        return stop;
    }

    public void playRandomVideo() {

        Random r = new Random();
        int randomVideoIndex = r.nextInt(videoLibrary.getVideos().size());
      //  pause = false;
        if(current_video != null){
            stopVideo();
            playVideo(videoLibrary.getVideos().get(randomVideoIndex).getVideoId());
            return;
        } else
            playVideo(videoLibrary.getVideos().get(randomVideoIndex).getVideoId());


    }

    public boolean pauseVideo() {


            if (current_video != null) {

               System.out.println("Pausing video: " + current_video);
               previous_video = current_video;
               setCurrent_video(null);
               pause = true;
            }else if(pause == true) {
                System.out.println("Video already paused: " + previous_video);
                previous_video = current_video;
                setCurrent_video(null);
                pause = true;
            }else if(current_video == null && stop == true){
                System.out.println("Cannot pause video: No video is currently playing");
            }
            else
                System.out.println("No video currently playing");

    return pause;
    }

    public void continueVideo() {
        if (current_video != null) {

            System.out.println("Continuing video: " + current_video);
            setCurrent_video(current_video);
        }else if(pause == true){
            System.out.println("Continuing video: " + previous_video);
            setCurrent_video(current_video);
        }else
            System.out.println("Cannot continue video: No video is currently playing");

    }

    public void showPlaying() {

        if(current_video != null)
                System.out.println("Now Playing : " + getCurrent_video(current_video));

        else
            System.out.println("No video is currently playing");

    }
    VideoPlaylist playlist;

    public VideoPlaylist createPlaylist(String playlistName) {
        playlist = new VideoPlaylist(playlistName);
        PlayL.add(playlist);
        System.out.println("Successfully created new playlist: " + playlistName);
        return playlist;
    }

    public void addVideoToPlaylist(String playlistName, String videoId) {
        if (!playlist.isExisting()) {
            createPlaylist(playlistName);
        }
        playlist.addVideo(videoId);
    }

    public void showAllPlaylists() {
        for (int i = 0; i < PlayL.size(); i++) {
            System.out.print((PlayL.get(i)).toString());
        }
    }

    public void showPlaylist(String playlistName) {
        playlist.PrintPlaylistContent(playlistName);

    }

    public void removeFromPlaylist(String playlistName, String videoId) {

        playlist.removeVideo(videoId);
    }

    public void clearPlaylist(String playlistName) {

        playlist.clearPlaylist(playlistName);
    }

    public void deletePlaylist(String playlistName) {
        playlist.deletePlayList(playlistName);
    }

    public void searchVideos(String videoId) {

        if (playlist.Search(videoId)) {
            System.out.println("looking For" + videoLibrary.getVideo(videoId));

        } else {
            System.out.println("video Does not exist");
        }

    }

    public void searchVideosWithTag(String videoTag) {

    }

    public void flagVideo(String videoId) {
        Video Vid = new Video(videoId);
        Vid.setIsFlagged(true);

    }

    public void flagVideo(String videoId, String reason) {
        flagVideo(videoId);
    }

    public void allowVideo(String videoId) {

    }
}
