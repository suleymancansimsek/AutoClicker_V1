package com.example.autoclicker_v1;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.robot.Robot;

public class RobotCommander implements KeyCommands {

    int delay;
    Robot robot = new Robot();

    @Override
    public void pressCharButton(char charachter) throws InterruptedException {
        robot.keyPress(KeyCode.valueOf(String.valueOf(charachter)));
        robot.keyRelease(KeyCode.valueOf(String.valueOf(charachter)));

    }

    @Override
    public void pressNumButton(int number) {

    }

    public void workNow(){

    }
}
