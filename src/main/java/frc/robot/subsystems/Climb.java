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

public class Climb extends SubsystemBase {
  /**
   * Creates a new Climb.
   */
  Spark reachSpark = null;
  Spark winchSpark = null;
  
  public Climb() {
    reachSpark = new Spark(RobotMap.LIFT);
    winchSpark = new Spark(RobotMap.WINCH);
  }

  public void reach(){
    reachSpark.setVoltage(6);
  }

  public void shorten(){
    reachSpark.setVoltage(-6);
  }

  public void stopReach(){
    reachSpark.setVoltage(0);
  }

  public void climb(){
    winchSpark.setVoltage(-6);
    reachSpark.setVoltage(-6);
  }

  public void rest(){
    winchSpark.setVoltage(0);
    reachSpark.setVoltage(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
