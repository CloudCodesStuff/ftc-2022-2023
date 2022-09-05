package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp()

public class auto extends OpMode {
    double SetMovementSpeed = 0.5;

    double VarMovementSpeed = 0.5;
    double spinnerSpeed = 1;
    double turboSpeed = 1;

    private DcMotor RIGHT_FRONT;
    private DcMotor LEFT_FRONT;
    private DcMotor RIGHT_REAR;
    private DcMotor LEFT_REAR;
    private DcMotor SPINNER;

    String Message = "Controller Info:";

    @Override
    public void init() {

        telemetry.addData("", Message);

        RIGHT_FRONT = hardwareMap.get(DcMotor.class, "RIGHT_FRONT");
        LEFT_FRONT = hardwareMap.get(DcMotor.class, "LEFT_FRONT");
        RIGHT_REAR = hardwareMap.get(DcMotor.class, "RIGHT_REAR");
        LEFT_REAR = hardwareMap.get(DcMotor.class, "LEFT_REAR");
        SPINNER = hardwareMap.get(DcMotor.class, "SPINNER");

        //        RIGHT_REAR.setDirection(DcMotor.Direction.REVERSE);
//        RIGHT_FRONT.setDirection(DcMotor.Direction.REVERSE);
        LEFT_FRONT.setDirection(DcMotor.Direction.REVERSE);
//        LEFT_REAR.setDirection(DcMotor.Direction.REVERSE);

        LEFT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LEFT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SPINNER.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            VarMovementSpeed = turboSpeed;

        }else {
            VarMovementSpeed = SetMovementSpeed;
        }

        double horizontal = VarMovementSpeed * gamepad1.left_stick_x;
        double vertical = VarMovementSpeed * -gamepad1.left_stick_y;
        double turn =  VarMovementSpeed * -gamepad1.right_stick_x;
        double spinLeft = spinnerSpeed * gamepad1.left_trigger;
        double spinRight = spinnerSpeed * gamepad1.right_trigger;

        LEFT_REAR.setPower(vertical - horizontal - turn);
        LEFT_FRONT.setPower(vertical + horizontal - turn);
        RIGHT_REAR.setPower(vertical + horizontal + turn);
        RIGHT_FRONT.setPower(vertical - horizontal + turn);

        SPINNER.setPower(spinRight - spinLeft);

        telemetry.addData("", "Sticks");
        telemetry.addData("leftStickX", gamepad1.left_stick_x);
        telemetry.addData("leftStickY", gamepad1.left_stick_y);
        telemetry.addData("RightStickX", gamepad1.right_stick_x);
        telemetry.addData("RightStickY", gamepad1.right_stick_y);
        telemetry.addData("", "Triggers");
        telemetry.addData("TriggerL", gamepad1.left_trigger);
        telemetry.addData("TriggerR", gamepad1.right_trigger);

    }

}
