package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp()

public class mecanumDRIVEEEE extends OpMode {
    //movement tune
    double movementMultipler = 1;
    double spinMultiplier = 0.7;
    //end of movement tune
    String initMsg = "Robot initialized";
    private DcMotor LEFT_FRONT;
    private DcMotor RIGHT_FRONT;
    private DcMotor RIGHT_REAR;
    private DcMotor LEFT_REAR;
    private DcMotor SPINNER;

    @Override
    public void init() {
        //printed an init message to the driver hub
        telemetry.addData("", initMsg);


        //Mapped all motors
        LEFT_FRONT = hardwareMap.dcMotor.get("LEFT_FRONT");
        RIGHT_FRONT = hardwareMap.dcMotor.get("RIGHT_FRONT");
        RIGHT_REAR = hardwareMap.dcMotor.get("RIGHT_REAR");
        LEFT_REAR = hardwareMap.dcMotor.get("LEFT_REAR");
        SPINNER = hardwareMap.dcMotor.get("SPINNER");


        //Reverses left motor
        //        RIGHT_FRONT.setDirection(DcMotorSimple.Direction.REVERSE);
       LEFT_REAR.setDirection(DcMotorSimple.Direction.REVERSE);

       //Set motors to brake mode so we don't slide around.
        LEFT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_FRONT.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RIGHT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LEFT_REAR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SPINNER.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    @Override
    public void loop() {
        double horizontal = movementMultipler * gamepad1.left_stick_x;
        double vertical = -movementMultipler * gamepad1.left_stick_y;
        double turn = -movementMultipler * gamepad1.right_stick_x;
        double spinnerL = spinMultiplier * gamepad1.left_trigger;
        double spinnerR = spinMultiplier * gamepad1.right_trigger;

        //Mecanum movement code

        LEFT_REAR.setPower(turn + horizontal - vertical);
        LEFT_FRONT.setPower(turn - horizontal - vertical);
        RIGHT_REAR.setPower(turn + horizontal + vertical);
        RIGHT_FRONT.setPower(turn - horizontal + vertical);

       //Spinner code
        SPINNER.setPower(spinnerR-spinnerL);

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
