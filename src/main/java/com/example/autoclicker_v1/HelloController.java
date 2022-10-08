package com.example.autoclicker_v1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.robot.Robot;

public class HelloController {
    @FXML
    private Label autoCliclerStarter;

    Robot robot = new Robot();

    @FXML
    protected void autoCliclerStarter() throws InterruptedException {
        autoCliclerStarter.setText("working!");
        RobotCommander robotCommander = new RobotCommander();
        robotCommander.pressCharButton('K');
    }

}