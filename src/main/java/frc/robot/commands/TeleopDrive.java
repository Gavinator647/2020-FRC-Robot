/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  /**
   * Creates a new TeleopDrive.
   */
  private final Drivetrain m_Drive;
  private double moveSpeed;
  private double rotateSpeed;
  public TeleopDrive(Drivetrain subsystem, double moveSpeed, double rotateSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Drive = subsystem;
    addRequirements(m_Drive);
    this.moveSpeed = moveSpeed;
    this.rotateSpeed = rotateSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
