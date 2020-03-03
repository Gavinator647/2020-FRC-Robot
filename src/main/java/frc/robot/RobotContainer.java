/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Intake m_Intake = new Intake();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Drivetrain m_Drive = new Drivetrain();
  private final Climb m_Climb = new Climb();
  private final Chamber m_Chamber = new Chamber();
  private final Shooter m_Shooter = new Shooter();
  Joystick mainStick = new Joystick(0);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_Drive.setDefaultCommand(new TeleopDrive(m_Drive, () -> mainStick.getRawAxis(1), () -> mainStick.getRawAxis(4)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Button A = new JoystickButton(mainStick, 1);
    Button B = new JoystickButton(mainStick, 2);
    Button X = new JoystickButton(mainStick, 3);
    Button Y = new JoystickButton(mainStick, 4);
    Button LB = new JoystickButton(mainStick, 5);
    Button RB = new JoystickButton(mainStick, 6);
    Button Back = new JoystickButton(mainStick, 7);
    Button Start = new JoystickButton(mainStick, 8);
    Button LJ = new JoystickButton(mainStick, 9);
    Button RJ = new JoystickButton(mainStick, 10);
    
    Back.whenPressed(new RetractIntake(m_Intake));
    Start.whenPressed(new DeployIntake(m_Intake));
    
    X.whenPressed(new RaiseHook(m_Climb));
    X.whenReleased(new RestHook(m_Climb));
    
    Y.whenPressed(new PullUp(m_Climb));
    Y.whenReleased(new RestClimb(m_Climb));
    
    A.whenPressed(new Unspool(m_Climb));
    A.whenReleased(new RestClimb(m_Climb));

    //LB.whenPressed(new ManualShoot(m_Shooter, 40, 40));
    //LB.whenReleased(new StopShooter(m_Shooter));

    RB.whenPressed(new ManualShoot(m_Shooter, 65, 65));
    RB.whenReleased(new StopShooter(m_Shooter));

    LJ.whenPressed(new ChamberLoad(m_Chamber));
    LJ.whenReleased(new ChamberHalt(m_Chamber));

    RJ.whenPressed(new ChamberFreeSpin(m_Chamber));
    RJ.whenReleased(new ChamberHalt(m_Chamber));

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
