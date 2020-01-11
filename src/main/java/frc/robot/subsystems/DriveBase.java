/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  public TalonSRX frontLeftDrive;//Front Left Motor
  public TalonSRX frontRightDrive;//Front Right Motor
  public VictorSPX backLeftDrive;//Back Left Motor
  public VictorSPX backRightDrive;//Back Right Motor
  public double peak;
  public DriveBase()
{
  peak = .5;
  frontLeftDrive = new TalonSRX(2);
  frontRightDrive = new TalonSRX(3);
  backLeftDrive = new VictorSPX(0);
  backRightDrive = new VictorSPX(1);
  backLeftDrive.follow(frontLeftDrive);
  backRightDrive.follow(frontRightDrive);
  frontRightDrive.setInverted(true);
  backRightDrive.setInverted(true);
  Robot.initMotor(frontLeftDrive,peak);
  Robot.initMotor(frontRightDrive,peak);
  Robot.initMotor(backLeftDrive,peak);
  Robot.initMotor(backRightDrive,peak);
}
public void move(double speedL,double speedR){
  frontLeftDrive.set(ControlMode.PercentOutput,speedL);
  frontRightDrive.set(ControlMode.PercentOutput,speedR);
}
public void setMotors(double nPeak)
{
  Robot.initMotor(frontLeftDrive, nPeak);
  Robot.initMotor(frontRightDrive, nPeak);
  Robot.initMotor(backLeftDrive, nPeak);
  Robot.initMotor(backRightDrive, nPeak);
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
