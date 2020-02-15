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
  private final Drivetrain m_Drive;
  public AutoDrive(double distance, Drivetrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drive = subsystem;
    addRequirements(m_Drive);
    this.distance=distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    m_Drive.resetEncoder();
    m_Drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double moveSpeed = distance - m_Drive.getDistance()*(1/24);
    double rotateSpeed = 0 - m_Drive.getAngle()*(1/1440);
    m_Drive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    if (distance - m_Drive.getDistance()<=1 || distance - m_Drive.getDistance()>=-1) return true;
  
    return false;
  }
}
