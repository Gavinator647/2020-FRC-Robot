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

public class Chamber extends SubsystemBase {
  /**
   * Creates a new Chamber.
   */
  Spark tcSpark = null;
  Spark bcSpark = null;
  
  public Chamber() {
    tcSpark = new Spark(RobotMap.TOP_CHAMBER);
    bcSpark = new Spark(RobotMap.BOTTOM_CHAMBER);
  }

  public void chamberintake(){
    tcSpark.setSpeed(0.5);
  }
  
  public void load(){
    tcSpark.setSpeed(0.5);
    bcSpark.setSpeed(-0.5);
  }

  public void unload(){
    tcSpark.setSpeed(-0.5);
    bcSpark.setSpeed(0.5);
  }

  public void stopChamber(){
    tcSpark.setVoltage(0);
    bcSpark.setVoltage(0);
  }

  public void autoChamber(){
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
