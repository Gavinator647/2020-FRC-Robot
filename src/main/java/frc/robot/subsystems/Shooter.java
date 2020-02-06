/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  Spark lsSpark = null;
  Spark rsSpark = null;
  public Shooter() {
    lsSpark = new Spark(RobotMap.LEFT_FLYWHEEL);
    rsSpark = new Spark(RobotMap.RIGHT_FLYWHEEL);
  }

  public void manualShot(){
    lsSpark.setVoltage(6);
    rsSpark.setVoltage(-6);
  }

  public void autoShot(){

  }

  public void stopShooter(){
    lsSpark.setVoltage(0);
    rsSpark.setVoltage(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
