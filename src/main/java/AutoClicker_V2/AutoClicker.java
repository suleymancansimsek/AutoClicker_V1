package AutoClicker_V2;

import java.awt.Robot;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoClicker {

    private static ScheduledExecutorService executor;
    private static boolean running;
    private static int keyCode;
    private static int interval;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter key code: ");
        keyCode = scanner.nextInt();
        System.out.print("Enter interval (ms): ");
        interval = scanner.nextInt();

        String input;
        while (true) {
            System.out.print("Enter 's' to start, 'p' to pause, or 'q' to quit: ");
            input = scanner.next();

            if (input.equals("s")) {
                if (!running) {
                    startAutoClicker();
                    running = true;
                }
            }
         else if (input.equals("p")) {
            if (running) {
                stopAutoClicker();
                running = false;
            }
        } else if (input.equals("q")) {
            if (running) {
                stopAutoClicker();
            }
            break;
        }
    }
}

    private static void startAutoClicker() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Robot robot = new Robot();
                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, interval, TimeUnit.MILLISECONDS);
    }

    private static void stopAutoClicker() {
        if (executor != null) {
            executor.shutdown();
            executor = null;
        }
    }
}

