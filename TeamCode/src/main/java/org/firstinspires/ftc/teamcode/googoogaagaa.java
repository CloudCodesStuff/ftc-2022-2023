package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp()

public class googoogaagaa extends OpMode {

    double movementMultiplier = 1;
    double spinMultiplier = 0.7;
    String initMsg = "Robot initialized";
    private DcMotor SPINNER;
    private DcMotor LEFT_FRONT;
    private DcMotor RIGHT_FRONT;
    private DcMotor RIGHT_REAR;
    private DcMotor LEFT_REAR;

    @Override
    public void init() {
        //prints init message to driver hub
        telemetry.addData("", initMsg);
        //mapped motors
        SPINNER  = hardwareMap.dcMotor.get("SPINNER");
        LEFT_FRONT = hardwareMap.dcMotor.get("LEFT_FRONT");
        RIGHT_FRONT = hardwareMap.dcMotor.get("RIGHT_FRONT");
        RIGHT_REAR = hardwareMap.dcMotor.get("RIGHT_REAR");
        LEFT_REAR = hardwareMap.dcMotor.get("LEFT_REAR");



        //set motors to brake mode so we don't slide around.
        LEFT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LEFT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SPINNER.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        double horizontal = movementMultiplier * gamepad1.left_stick_x;
        double vertical = -movementMultiplier * gamepad1.left_stick_y;
        double turn = movementMultiplier * gamepad1.right_stick_x;
        double spinnerL = spinMultiplier * gamepad1.left_trigger;
        double spinnerR = spinMultiplier * gamepad1.right_trigger;

        LEFT_REAR.setPower(vertical +horizontal);
        LEFT_FRONT.setPower( -vertical - horizontal);
        RIGHT_REAR.setPower(vertical - horizontal);
        RIGHT_FRONT.setPower(vertical - horizontal);

        SPINNER.setPower(spinnerR-spinnerL);

        telemetry.addData("Left stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        telemetry.addData("left trigger", gamepad1.left_trigger);
        telemetry.addData("right trigger", gamepad1.right_trigger);
        telemetry.addData("A button", gamepad1.a);


    }
}
