/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoTurn extends CommandBase {
  /**
   * Creates a new AutoTurn.
   */
  private final Drivetrain m_Drive;
  double angle;
  public AutoTurn(double angle, Drivetrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drive = subsystem;
    addRequirements(m_Drive);
    this.angle = angle;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    m_Drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    //double rotateSpeed = angle - RobotContainer.m_Drive.getAngle() * (1/3600);
    m_Drive.arcadeDrive(0, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    m_Drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    if(angle - m_Drive.getAngle()<=0.5 && angle - m_Drive.getAngle()>=-0.5 ) return true;
    return false;
  }
}
