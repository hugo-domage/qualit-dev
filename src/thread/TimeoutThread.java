package thread;

import Game.Jeu;

import java.util.Scanner;

public class TimeoutThread extends Thread {
    private Jeu jeu;
    private int timeout;
    private boolean running;

    public TimeoutThread(int timeout, Jeu jeu) {
        this.jeu = jeu;
        this.timeout = timeout;
        this.running = false;
    }

    public void run() {
        running = true;
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        while (running) {
            String line = scanner.nextLine();
            if (line != null && !line.isEmpty()) {
                startTime = System.currentTimeMillis();
            }
            if ((System.currentTimeMillis() - startTime) > (timeout * 1000)) {
                System.out.println("Timeout reached. Exiting...");
                System.exit(0);
            }
        }
        jeu.endGame();
    }

    public void stopThread() {
        running = false;
    }
}
