/*
 * The Adapter Design Pattern allows incompatible interfaces to work together by creating
 * an intermediary that translates method calls from one interface to another.
 *
 * Why use it?
 * - When you want to use existing classes but their interfaces do not match.
 * - When you need to integrate with third-party or legacy systems that you cannot modify.
 *
 * Pros:
 * - Helps decouple the client from the concrete classes.
 * - Increases flexibility, consistency, and maintainability.
 * - Adapting the 3rd-party interface allows the client code to remain agnostic to specific implementations.
 * - Supports the Open/Closed Principle by making the system open for extension but closed for modification.
 * - Adheres to the Single Responsibility Principle (SRP) by ensuring that the Adapter is responsible only for the adaptation.
 */

package structural;

// Preparing the environment

// Interfaces from your current system
interface MediaPlayer {
    void play();
}

class AudioPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Audio is playing..");
    }
}

// Interfaces from 3rd party system
interface Player {
    void playVideo();
}

class VideoPlayer implements Player {
    @Override
    public void playVideo() {
        System.out.println("Video is playing...");
    }
}

// Adapt the 3rd party class with your current system.
class VideoPlayerAdapter implements MediaPlayer {

    private Player videoPlayer;

    public VideoPlayerAdapter(Player videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void play() {
        videoPlayer.playVideo();
    }
}

public class AdapterApp {
    public static void main(String[] args) {
        // Client code using the MediaPlayer interface
        MediaPlayer player = new AudioPlayer();
        player.play();  // Playing audio

        // Using the Adapter to work with the 3rd party system
        Player videoPlayer = new VideoPlayer();
        MediaPlayer adapter = new VideoPlayerAdapter(videoPlayer); // Adapting the system MediaPlayer to accept Player
        adapter.play();  // The adapter delegates the play() method to playVideo() of VideoPlayer
    }
}
