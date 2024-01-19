//importing necessary packages
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//Creating class and implementing interfaces
public class GuessingGameJava implements ActionListener, KeyListener {


	//Crating Object of UIManager class to manage the look and feel
	UIManager UI=new UIManager();

	//Creating objects of JFrame and JPanel
	JFrame frame;
	JPanel panel1;
	JPanel panel2;

	//Creating objects of components
	JLabel textLabel1;
	JLabel textLabel2;
	JLabel textLabel3;
	JLabel textLabel4;
	JLabel textLabel5;
	JLabel textLabel7;
	JLabel textLabel8;
	JLabel textLabel9;
	JLabel textLabel10;
	JLabel textLabel12;
	JLabel imageLabel;
	JTextField guessTextField;
	JButton guessButton;
	JButton giveUpButton;
	JButton newGameButton;
	JLabel attemptsLabel;
	JLabel highestScoreLabel;
	JLabel timeTakenLabel;
	JTextField attemptsField;
	JTextField highestScoreField;
	JTextField timeTakenField;

	//Creating object of Timer class
	Timer timer;
	
	//Creating object of Random class
	Random random=new Random();
	int randomNumber=random.nextInt(100)+1;
	
	//declaring and initializing variables
	int attemptCount =0;
	int scoreCount=0;
	int elapsedTime=0;
	int minutes=0;
	int seconds=0;
	int temp=0;
	String second_string=String.format("%02d",seconds);
	String minute_string=String.format("%02d",minutes);

	GuessingGameJava(){


		//Managing look and feel of JOptionPane
		UI.put("OptionPane.background",new Color(1,16,247));
		UI.put("Panel.background", new Color(1,16,247));

		UI.put("OptionPane.messageForeground", Color.white);
		UI.put("OptionPane.messageFont",new Font("Comic Sans MS",Font.BOLD,13));

		//Setting properties of JFrame
		frame =new JFrame();
		frame.setTitle("Number Guessing Game");
		frame.getContentPane().setLayout(null);

		//Setting Properties of JPanel one and two
		panel1 =new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(128,0,128));
		panel1.setBounds(0,0,350,470);

		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(new Color(255,15,134));
		panel2.setBounds(350,370,350,100);


		//Setting properties of the components

		textLabel1 =new JLabel();
		textLabel1.setText("Number");
		textLabel1.setFont(new Font("Comic Sans MS", Font.BOLD, 55));
		textLabel1.setForeground(Color.cyan);
		textLabel1.setBounds(78,20,300,100);


		textLabel2 =new JLabel();
		textLabel2.setText("Guessing Game");
		textLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
		textLabel2.setForeground(Color.WHITE);
		textLabel2.setBounds(48,80,300,100);

		textLabel12 =new JLabel();
		textLabel12.setText("Let's Have Fun :))");
		textLabel12.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		textLabel12.setForeground(Color.cyan);
		textLabel12.setBounds(48,170,300,100);


        textLabel7 =new JLabel();
		textLabel7.setText("Here are the  rules:");
		textLabel7.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		textLabel7.setForeground(Color.WHITE);
		textLabel7.setBounds(48,260,300,100);

        textLabel8 =new JLabel();
		textLabel8.setText("1.Guess a number between 1 to 100.");
		textLabel8.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		textLabel8.setForeground(Color.WHITE);
		textLabel8.setBounds(48,300,300,100);

        textLabel9 =new JLabel();
		textLabel9.setText("2.Input only number");
		textLabel9.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		textLabel9.setForeground(Color.WHITE);
		textLabel9.setBounds(48,330,300,100);

        textLabel10 =new JLabel();
		textLabel10.setText("3.Don't input negative number");
		textLabel10.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		textLabel10.setForeground(Color.WHITE);
		textLabel10.setBounds(48,360,300,100);

		textLabel3 =new JLabel();
		textLabel3.setText("Guess A Number");
		textLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		textLabel3.setForeground(new Color(128,0,128));
		textLabel3.setBounds(390,20,300,100);


		textLabel4 =new JLabel();
		textLabel4.setText("( Between 1 to 100 )");
		textLabel4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		textLabel4.setForeground(Color.black);
		textLabel4.setBounds(410,80,300,100);


		guessTextField =new JTextField();
		guessTextField.setDocument(new JTextFieldCharLimit(2));
		guessTextField.setHorizontalAlignment(SwingConstants.CENTER);
		guessTextField.setBounds(440,170,145,30);
		guessTextField.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		guessTextField.setBackground(new Color(232,232,232));
		guessTextField.setBorder(BorderFactory.createBevelBorder(1));



		guessButton = new JButton();
		guessButton.setText("Guess");
		guessButton.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		guessButton.setBounds(450,215,125,35);
		guessButton.setFocusable(false);
		guessButton.setBackground(new Color(128,0,128));
		guessButton.setForeground(Color.white);


		textLabel5 =new JLabel();
		textLabel5.setText("");
		textLabel5.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		textLabel5.setForeground(Color.red);
		textLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		textLabel5.setBounds(420,220,180,100);


		giveUpButton = new JButton();
		giveUpButton.setText("Give UP!");
		giveUpButton.setFont(new Font("Comic Sans MS",Font.BOLD,17));
		giveUpButton.setBounds(390,310,125,35);
		giveUpButton.setFocusable(false);
		giveUpButton.setBackground(new Color(128,0,128));
		giveUpButton.setForeground(Color.white);

		newGameButton = new JButton();
		newGameButton.setText("New Game");
		newGameButton.setFont(new Font("Comic Sans MS",Font.BOLD,17));
		newGameButton.setBounds(530,310,125,35);
		newGameButton.setFocusable(false);
		newGameButton.setBackground(new Color(128,0,128));
		newGameButton.setForeground(Color.white);

		attemptsLabel=new JLabel();
		attemptsLabel.setText("Attempts");
		attemptsLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		attemptsLabel.setBounds(10,5,125,35);
		attemptsLabel.setForeground(Color.black);



		highestScoreLabel=new JLabel();
		highestScoreLabel.setText("Lowest Move");
		highestScoreLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		highestScoreLabel.setBounds(10,30,125,35);
		highestScoreLabel.setForeground(Color.black);


	timeTakenLabel=new JLabel();
	timeTakenLabel.setText("Time Taken (MM:SS)");
	timeTakenLabel.setFont(new Font("Comic Sans MS",Font.BOLD,15));
	timeTakenLabel.setBounds(10,55,160,35);
	timeTakenLabel.setForeground(Color.black);


		attemptsField=new JTextField();
		attemptsField.setEditable(false);
		attemptsField.setBounds(230,14,70,15);
		attemptsField.setHorizontalAlignment(SwingConstants.CENTER);
		attemptsField.setFont(new Font("Comic Sans MS",Font.BOLD,13));
		attemptsField.setBorder(BorderFactory.createBevelBorder(1));


		highestScoreField=new JTextField();
		highestScoreField.setEditable(false);
		highestScoreField.setText("");
		highestScoreField.setBounds(230,39,70,15);
		highestScoreField.setHorizontalAlignment(SwingConstants.CENTER);
		highestScoreField.setFont(new Font("Comic Sans MS",Font.BOLD,13));
		highestScoreField.setBorder(BorderFactory.createBevelBorder(1));

		timeTakenField=new JTextField();
		timeTakenField.setEditable(false);
		timeTakenField.setBounds(230,64,70,15);
		timeTakenField.setHorizontalAlignment(SwingConstants.CENTER);
		timeTakenField.setFont(new Font("Comic Sans MS",Font.BOLD,13));
		timeTakenField.setBorder(BorderFactory.createBevelBorder(1));



		ImageIcon icon=new ImageIcon("GuessingGame.png");
		imageLabel=new JLabel(icon);
		imageLabel.setBounds(70,200,icon.getIconWidth(),icon.getIconHeight());

		//Adding Action Listener to JButtons
		guessButton.addActionListener(this);
		giveUpButton.addActionListener(this);
		newGameButton.addActionListener(this);

		//Adding Key Listener to JTextField
		guessTextField.addKeyListener(this);

		//Adding panels to JFrame
		frame.add(panel1);
		frame.add(panel2);

		//Adding components to the container
		panel1.add(textLabel1);
		panel1.add(textLabel2);
		panel1.add(textLabel7);
		panel1.add(textLabel8);
		panel1.add(textLabel9);
		panel1.add(textLabel10);
		panel1.add(textLabel12);
		panel2.add(attemptsLabel);
		panel2.add(highestScoreLabel);
		panel2.add(timeTakenLabel);
		panel2.add(attemptsField);
		panel2.add(highestScoreField);
		panel2.add(timeTakenField);
		frame.add(textLabel3);
		frame.add(textLabel4);
		frame.add(textLabel5);
		frame.add(guessTextField);
		frame.add(guessButton);
		frame.add(giveUpButton);
		frame.add(newGameButton);
		panel1.add(imageLabel);


		//Setting properties of JFrame
		frame.getContentPane().setBackground(Color.cyan);
		frame.setSize(700,500);
		frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//calling method countDownTimer()
		countDownTimer();
		//Starting timer
		timer.start();

	}



	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {


	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		//Restricting JTextField to accept only numbers
		char c=e.getKeyChar();

		if(!Character.isDigit(c)||Character.isWhitespace(c)){
			if(!(e.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
				Toolkit.getDefaultToolkit().beep();
			}
			e.consume();

		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Code for Guess Button
		if(e.getSource()==guessButton) {

			if (guessTextField.getText().equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Invalid Input","Error",JOptionPane.ERROR_MESSAGE);
			} else {
				attemptCount++;
				attemptsField.setText(Integer.toString(attemptCount));
				int number = Integer.parseInt(guessTextField.getText());
				if (randomNumber == number) {

					timer.stop();
					guessTextField.setEditable(false);
					guessTextField.getCaret().setVisible(false);
					textLabel5.setText("");
					guessTextField.setText("");
					temp++;
					if(temp==1){
						highestScoreField.setText(String.valueOf(attemptCount));
						scoreCount=attemptCount;
					}else{
						if(attemptCount<=scoreCount){
							highestScoreField.setText(String.valueOf(attemptCount));
							scoreCount=attemptCount;
						}
					}
					JOptionPane.showMessageDialog(null,"YOU WIN! Correct Guess was "+randomNumber+"\nClick on New Game to Play Again","Victory",JOptionPane.INFORMATION_MESSAGE);

				}else if (randomNumber > number) {
					textLabel5.setText(number + " is Low. Try Again!");
				} else if (randomNumber < number) {
					textLabel5.setText(number + " is High. Try Again!");
	        	}

			}

		}
		
		
		//Code for Give UP Button

		if(e.getSource()==giveUpButton){
			timer.stop();
			textLabel5.setText("");
			guessTextField.setText("");
			guessTextField.setEnabled(false);
			JOptionPane.showMessageDialog(null,+randomNumber+" is the right guess");

		}
		
		//Code for New Game Button
		if(e.getSource()==newGameButton){

			elapsedTime=0;
			seconds=0;
			minutes=0;
			timer.start();
			attemptCount =0;
			textLabel5.setText("");
			timeTakenField.setText("");
			attemptsField.setText("");
			guessTextField.setText("");
			guessTextField.setEnabled(true);
			guessTextField.setEditable(true);
			guessTextField.getCaret().setVisible(true);
			guessTextField.requestFocus();
			randomNumber=random.nextInt(100)+1;

		}


	}

	
	//Code for displaying Timer
	public void countDownTimer(){


		timer=new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				elapsedTime=elapsedTime+1000;
				minutes=(elapsedTime/60000)%60;
				seconds=(elapsedTime/1000)%60;
				second_string=String.format("%02d",seconds);
				minute_string=String.format("%02d",minutes);
				timeTakenField.setText(minute_string+":"+second_string);

			}
		});
	}

	//Creating main method
	public static void main(String[] args) {

		//Creating object of the class
		GuessingGameJava guessingGameJava=new GuessingGameJava();

	}

}

//Restricting JTextField Character limits using PlainDocument class
class JTextFieldCharLimit extends PlainDocument
{
	int limit;
	public JTextFieldCharLimit(int limitation){
		this.limit=limitation;
	}
	public void insertString(int offset, String str, AttributeSet set)throws BadLocationException {
		if(str==null){
			return;
		}else if(getLength() + str.length() <=limit){
			super.insertString(offset, str, set);
		}
		else if(getLength() + str.length() >limit){
			Toolkit.getDefaultToolkit().beep();
		}
	}
}
