/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climb extends SubsystemBase {
  /**
   * Creates a new Climb.
   */
  PWMSparkMax liftSpark = null;
  PWMSparkMax winchSpark = null;
  
  public Climb() {
    liftSpark = new PWMSparkMax(RobotMap.LIFT);
    winchSpark = new PWMSparkMax(RobotMap.WINCH);
  }

  public void raisehook(){
    liftSpark.setSpeed(-1);
  }

  public void lowerhook(){
    liftSpark.setVoltage(-6);
  }

  public void stophook(){
    liftSpark.setVoltage(0);
  }

  public void climb(){
    winchSpark.setSpeed(-1);
    liftSpark.setSpeed(0.3);
  }

  public void rest(){
    winchSpark.setVoltage(0);
    liftSpark.setVoltage(0);
  }

  public void unspool(){
    winchSpark.setSpeed(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
