/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  DoubleSolenoid intakeSolenoid = null;
  Spark intakeSpark = null;

  public Intake() {
    intakeSolenoid = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_DEPLOY, RobotMap.INTAKE_SOLENOID_RETRACT);
    intakeSpark = new Spark(RobotMap.INTAKE);
  }

  public void deployIntake(){
    intakeSolenoid.set(Value.kForward);
  }

  public void retractIntake(){
    intakeSolenoid.set(Value.kReverse);
  }
  
  public void intake(){
    intakeSpark.setVoltage(6);
  }

  public void outtake(){
    intakeSpark.setVoltage(-6);
  }

  public void stoptake(){
    intakeSpark.setVoltage(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}