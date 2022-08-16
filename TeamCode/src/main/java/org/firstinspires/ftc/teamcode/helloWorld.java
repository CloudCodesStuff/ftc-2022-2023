package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp()

public class helloWorld extends OpMode {
    String initMsg = "Robot initialized";
    private DcMotor LEFT_FRONT;
    private DcMotor RIGHT_FRONT;
    private DcMotor RIGHT_REAR;
    private DcMotor LEFT_REAR;

    @Override
    public void init() {
        telemetry.addData("", initMsg);
        LEFT_FRONT = hardwareMap.dcMotor.get("LEFT_FRONT");
        RIGHT_FRONT = hardwareMap.dcMotor.get("RIGHT_FRONT");
        RIGHT_REAR = hardwareMap.dcMotor.get("RIGHT_REAR");
        LEFT_REAR = hardwareMap.dcMotor.get("LEFT_REAR");
        RIGHT_FRONT.setDirection(DcMotorSimple.Direction.REVERSE);
        RIGHT_REAR.setDirection(DcMotorSimple.Direction.REVERSE);
        LEFT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RIGHT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LEFT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    @Override
    public void loop() {
        float left_power = gamepad1.left_stick_y;
        float right_power = gamepad1.right_stick_y;
        telemetry.addData("leftStickX", gamepad1.left_stick_x);
        telemetry.addData("leftStickY", gamepad1.left_stick_y);
        telemetry.addData("RightStickX", gamepad1.right_stick_x);
        telemetry.addData("RightStickY", gamepad1.right_stick_y);
        LEFT_FRONT.setPower(left_power);
        LEFT_REAR.setPower(-left_power);

        RIGHT_FRONT.setPower(right_power);
        RIGHT_REAR.setPower(right_power);

    }
}
