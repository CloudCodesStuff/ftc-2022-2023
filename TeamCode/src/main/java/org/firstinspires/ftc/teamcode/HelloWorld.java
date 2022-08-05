package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp()

public class HelloWorld extends OpMode {
    String name = "user";
    @Override
    public void init() {
        telemetry.addData("Hello", name);
    }
    @Override
    public void loop() {

    }
}
