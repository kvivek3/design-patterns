package com.designpattern.structural.proxy;

interface Video {
    void play();
}

class RealVideo implements  Video {
    private String url;

    public RealVideo(String url) {
        this.url = url;
        downloadVideo();
    }
    public void downloadVideo() {
        System.out.println("Downloading Video from url " + url);
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void play() {
        System.out.println("Playing Video from url " + url);
    }
}

class ProxyVideo implements Video {
    private RealVideo realVideo;
    private String url;

    public ProxyVideo(String url) {
        this.url = url;
    }

    @Override
    public void play() {
        if(realVideo == null)
            realVideo = new RealVideo(url);
        realVideo.play();
    }
}

public class VideoPlayingSystem {
    public static void main(String[] args) {

        Video video = new ProxyVideo("https://youtube.com");
        // First time playing the video, it will download
        video.play();
        // Subsequent times, it will use the cached version
        video.play();

    }
}
