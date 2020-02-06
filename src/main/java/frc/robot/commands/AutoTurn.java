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
  private Drivetrain drive3 = new Drivetrain();
  double angle;
  public AutoTurn(double angle, Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive3);
    this.angle = angle;
    drive3=drivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    drive3.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    //double rotateSpeed = angle - RobotContainer.drive3.getAngle() * (1/3600);
    drive3.arcadeDrive(0, 0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    drive3.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    if(angle - drive3.getAngle()<=0.5 && angle - drive3.getAngle()>=-0.5 ) return true;
    return false;
  }
}
