The Proxy Pattern is a structural design pattern that provides an object representing another object. It acts as an intermediary, controlling access to the original object, which may be useful in several scenarios such as lazy initialization, access control, logging, and more.

### Naive Approach
Consider a scenario where we have a `Video` class that simulates downloading a video from the internet. Every time you want to access the video, it downloads it again, which can be inefficient and time-consuming if the video is large or if network conditions are poor.

```java
class Video {
    private String url;

    public Video(String url) {
        this.url = url;
        downloadVideo();
    }

    private void downloadVideo() {
        System.out.println("Downloading video from " + url);
        // Simulating a delay for downloading
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        System.out.println("Playing video from " + url);
    }
}
```

In this naive approach, every time you create a `Video` object, it downloads the video from the URL, even if you want to access the same video multiple times. This is inefficient and can degrade performance.

### How the Proxy Pattern Solves the Problem
The Proxy Pattern introduces a `ProxyVideo` class that controls access to the `Video` class. It downloads the video only when needed and caches it for subsequent use. This reduces unnecessary network usage and improves performance.

#### Proxy Implementation

```java
interface Video {
    void play();
}

class RealVideo implements Video {
    private String url;

    public RealVideo(String url) {
        this.url = url;
        downloadVideo();
    }

    private void downloadVideo() {
        System.out.println("Downloading video from " + url);
        // Simulating a delay for downloading
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        System.out.println("Playing video from " + url);
    }
}

class ProxyVideo implements Video {
    private RealVideo realVideo;
    private String url;

    public ProxyVideo(String url) {
        this.url = url;
    }

    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(url);
        }
        realVideo.play();
    }
}
```

#### Real World Scenario
Imagine you're developing a video streaming application. Users often replay videos they have watched previously. By using the Proxy Pattern, you can ensure that once a video is downloaded, it doesn't need to be downloaded again, which conserves bandwidth and improves user experience.

#### Usage

```java
public class Main {
    public static void main(String[] args) {
        Video video = new ProxyVideo("http://example.com/video.mp4");

        // First time playing the video, it will download
        video.play();

        // Subsequent times, it will use the cached version
        video.play();
    }
}
```

### Summary
- **Naive Approach**: Directly accessing the resource each time leads to inefficiencies.
- **Proxy Pattern**: Introduces a proxy that handles access control, caching, and other functionalities, improving performance and user experience.
- **Use Case**: Ideal for scenarios where resource-intensive operations need to be controlled or optimized, such as video streaming, remote services, or expensive computations.