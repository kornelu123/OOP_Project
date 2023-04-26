package pl.edu.pwr.bum.simulation.random.events.animation;

public interface Animation {
    public void printAnimation() throws InterruptedException;
    static void cleanScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
