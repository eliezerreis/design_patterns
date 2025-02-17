package structural;

/*
 * The Facade design pattern provides a simplified interface to a complex subsystem.
 *
 * Why use it?
 * - When you have a complex system with many classes and interface and you want to provide a simpler interface.
 * - When you want to minimize the dependencies between the client and the subsystem.
 * - When you're integrating with 3rd party systems.
 *
 * Pros:
 * - Simplifies complex objects.
 */
class TV {
    public void turnOn() {
        System.out.println("Turning on the TV");
    }

    public void turnOff() {
        System.out.println("Turning off the TV");
    }
}

class SoundSystem {
    public void turnOn() {
        System.out.println("Turning on the SoundSystem");
    }

    public void setVolume(int volume) {
        System.out.printf("Setting the volume to %d /n", volume);
    }
}


class Light {
    public void dim(int level) {
        System.out.println("Dimming lights to " + level + "%");
    }
}


class HomeTheater {
    private final TV tv;
    private final SoundSystem soundSystem;
    private final Light light;

    public HomeTheater(TV tv, SoundSystem soundSystem, Light light) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.light = light;
    }

    public void watchMovie() {
        System.out.println("Setting up home theater for movie night...");
        light.dim(10);
        tv.turnOn();
        soundSystem.turnOn();
        soundSystem.setVolume(5);
        System.out.println("Movie is ready to watch!");
    }

}


public class FacadeApp {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater(new TV(), new SoundSystem(), new Light());
        homeTheater.watchMovie();
    }
}