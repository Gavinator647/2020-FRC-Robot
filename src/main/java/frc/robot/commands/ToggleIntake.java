/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleIntake extends InstantCommand {
  private final Intake m_Intake;
  private int toggle = 0;
  public ToggleIntake(Intake subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Intake=subsystem;
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (toggle==0){
      m_Intake.retractIntake();
      toggle = 1;
    }
    
    if (toggle==1){
      m_Intake.deployIntake();
      toggle = 0;
    }
  }
}
