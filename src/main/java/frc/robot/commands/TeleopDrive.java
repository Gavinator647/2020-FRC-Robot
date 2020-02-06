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
  private final Drivetrain drive1 = new Drivetrain();
  public TeleopDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //double moveSpeed = RobotContainer.mainStick.getRawAxis(1);
    //double rotateSpeed = RobotContainer.mainStick.getRawAxis(4);
    //m_Drive.arcadeDrive(moveSpeed, rotateSpeed);
    
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
