/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  double distance;
  private final Drivetrain drive2 = new Drivetrain();
  public AutoDrive(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    addRequirements(drive2);
    this.distance=distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    drive2.resetEncoder();
    drive2.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double moveSpeed = distance - drive2.getDistance()*(1/24);
    double rotateSpeed = 0 - drive2.getAngle()*(1/1440);
    drive2.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive2.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    if (distance - drive2.getDistance()<=1 || distance - drive2.getDistance()>=-1) return true;
  
    return false;
  }
}
