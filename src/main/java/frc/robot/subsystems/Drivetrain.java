/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  Spark frSpark = null;
  Spark flSpark = null;
  Spark brSpark = null;
  Spark blSpark = null;
  AHRS navX =null;
  Encoder leftDrivEncoder = null;
  Encoder rightDrivEncoder = null;

  DifferentialDrive drive = null;
 
  public Drivetrain() {
  frSpark = new Spark(RobotMap.FRONT_RIGHT_DRIVE);
  flSpark = new Spark(RobotMap.FRONT_LEFT_DRIVE);
  brSpark = new Spark(RobotMap.BACK_RIGHT_DRIVE);
  blSpark = new Spark(RobotMap.BACK_LEFT_DRIVE);

  navX = new AHRS(SPI.Port.kMXP);
  leftDrivEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_FIRST, RobotMap.LEFT_DRIVE_ENCODER_SECOND);
  rightDrivEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_FIRST, RobotMap.RIGHT_DRIVE_ENCODER_SECOND);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(flSpark, blSpark);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(frSpark, brSpark);

  leftDrivEncoder.setDistancePerPulse(100);
  rightDrivEncoder.setDistancePerPulse(100);
  drive = new DifferentialDrive(leftMotors, rightMotors);
  }
  /**
   *  This is the Arcade Drive
   * @param moveSpeed move speed
   * @param rotateSpeed rotational speed
   */
  public void arcadeDrive(double moveSpeed, double rotateSpeed){
    drive.arcadeDrive(moveSpeed, rotateSpeed,false);
  }

  public double getAngle(){
    return navX.getAngle();
  }

  public double getDistance(){
    return (leftDrivEncoder.getDistance()+rightDrivEncoder.getDistance())/2;
  }

  public double getUltrasound(){
    return 0;
  }

  public void resetEncoder(){
    leftDrivEncoder.reset();
    rightDrivEncoder.reset();
  }

  public void resetGyro(){
    navX.zeroYaw();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
