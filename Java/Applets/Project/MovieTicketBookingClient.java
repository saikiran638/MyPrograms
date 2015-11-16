import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<html>

	<head>
	</head>
	
	<body> 
		<applet code="MovieTicketBookingClient.java" height=500 width=500> </applet> 
	</body>
	
</html>
*/


public class MovieTicketBookingClient extends Applet implements ActionListener {
	
	Panel topPanel 		= new Panel(new BorderLayout());
	Panel centerPanel	= new Panel(new FlowLayout());
	Panel bottomPanel	= new Panel();//not used
	
	Panel buttonsPanel	= new Panel(new FlowLayout(FlowLayout.TRAILING));
	Label title			= new Label("Movie Ticket Booking System",Label.CENTER);
	
	Button homeButton	= new Button("Home");
	Button loginButton	= new Button("Login");
	Button signupButton	= new Button("Register");
	Button theatreButton= new Button("Theatre Staff");
	
	Panel userInput		= new Panel(new GridLayout(4,1));
	Panel dummy			= new Panel(new BorderLayout());
	
	Panel phnoPanel		= new Panel(new GridLayout());
	Panel passwdPanel	= new Panel(new GridLayout());
	Panel namePanel		= new Panel(new GridLayout());
	Panel buttons		= new Panel(new GridLayout());
	
	
	TextField phno		= new TextField("Phone no.",20);
	TextField passwd	= new TextField("Password",20);
	TextField name		= new TextField("Name",20);
	
	Button clearButton	= new Button("Clear");
	Button submitButton	= new Button("Submit");
	
	Label introduction	= new Label(" This software helps you book your favorite movie ticket ",Label.CENTER);
	
	int registerState	= 1;
	int loginState		= 2;
	int theatreState	= 4;
	
	int state			= 0;
	
	public void init()	{
		setLayout(new BorderLayout());
		
		title.setFont(new Font("Serif",Font.BOLD,20));
		introduction.setFont(new Font("Serif",Font.PLAIN,15));
		
		//Add buttons to buttonPanel
		buttonsPanel.add(homeButton);
		buttonsPanel.add(loginButton);
		buttonsPanel.add(signupButton);
		buttonsPanel.add(theatreButton);
		
		//Fill topPanel
		topPanel.add(buttonsPanel,BorderLayout.NORTH);
		topPanel.add(title,BorderLayout.SOUTH);
		topPanel.setBackground(Color.white);
		
		
		namePanel.add(new Label("Name:",Label.LEFT));
		namePanel.add(name);
		
		phnoPanel.add(new Label("Phone No:",Label.LEFT));
		phnoPanel.add(phno);
		
		passwdPanel.add(new Label("Password:",Label.LEFT));
		passwd.setEchoChar("*");
		passwdPanel.add(passwd);
		
		buttons.add(clearButton,BorderLayout.NORTH);
		buttons.add(submitButton,BorderLayout.SOUTH);
		
		//Add to input field
		userInput.add(namePanel);
		userInput.add(phnoPanel);
		userInput.add(passwdPanel);
		userInput.add(buttons);

		
		dummy.add(introduction,BorderLayout.NORTH);
		dummy.add(userInput,BorderLayout.CENTER);
	
		centerPanel.add(dummy);
		//centerPanel.remove(userInput);	
		
		//Add action listener to these buttons
		homeButton.addActionListener(this);
		loginButton.addActionListener(this);	
		signupButton.addActionListener(this);
		theatreButton.addActionListener(this);
		
		clearButton.addActionListener(this);
		submitButton.addActionListener(this);
		
		add(topPanel,BorderLayout.NORTH);
		add(centerPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		
		}
	
	public void actionPerformed(ActionEvent action){
		//String pressedButton = action.getActionCommand();
		if (action.getSource() == homeButton){
			//centerPanel.setBackground(Color.blue);
			}
		else if (action.getSource() == loginButton){
			state |= loginState;
			introduction.setText("Enter valid credentials to login");
			dummy.add(introduction,BorderLayout.NORTH);
			dummy.add(userInput,BorderLayout.SOUTH);
			userInput.remove(namePanel);
			//centerPanel.setBackground(Color.green);
			}
		else if (action.getSource() == signupButton){
			state |= registerState;
			introduction.setText("Enter valid credentials to register");
			dummy.add(introduction,BorderLayout.NORTH);
			dummy.add(userInput,BorderLayout.SOUTH);
			userInput.add(namePanel);
			//centerPanel.setBackground(Color.yellow);
			}
		else if (action.getSource() == theatreButton){
			state |= theatreState;
			}
		else if (action.getSource() == clearButton){
			name.setText("");
			phno.setText("");
			passwd.setText("");
			}
		else if (action.getSource() == submitButton){
			// Process the input data to store.
			String namein	= name.getText();
			System.out.println(namein);
			}
		System.out.println(state);
		repaint();
		}
		
	//public void paint(Graphics g) {
		//showStatus("Hello! Guest");
		//}
	}
