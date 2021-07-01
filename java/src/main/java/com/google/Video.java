package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class used to represent a video.
 */
class Video {

    static Iterable<VideoLibrary> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String title = "";
    private String videoId = "";
    private List<String> tags;
    private boolean playing;
    private int duration;//minutes
    private boolean isFlagged;
    private ArrayList flaggedVideos = new ArrayList();

    public Video(String videoId) {
        this.videoId = videoId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    Video(String title, String videoId, List<String> tags) {
        this.title = title;
        this.videoId = videoId;
        this.tags = Collections.unmodifiableList(tags);
    }

    /**
     * Returns the title of the video.
     */
    String getTitle() {
        return title;
    }

    /**
     * Returns the video id of the video.
     */
    String getVideoId() {
        return videoId;
    }

    /**
     * Returns a readonly collection of the tags of the video.
     */
    List<String> getTags() {
        return tags;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void flaggedVideo(String videoId) {
        if (this.isFlagged) {
            flaggedVideos.add(this);
        }
    }

    public ArrayList getFlaggedVideos() {
        return flaggedVideos;
    }

    public void setIsFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

}