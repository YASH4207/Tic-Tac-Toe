import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlepanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JLabel textfeild = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton restartbutton = new JButton("Restart");	//create a button with the text "Restart"
	boolean player1_turn;

	MyFrame(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		textfeild.setBackground(new Color(25,25,25));
		textfeild.setForeground(new Color(25,255,0));
		textfeild.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfeild.setHorizontalAlignment(JLabel.CENTER);
		textfeild.setText("TIC TAC TOE");
		textfeild.setOpaque(true);
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0, 0, 800, 100);
		buttonpanel.setLayout(new GridLayout(3,3));
		buttonpanel.setBackground(new Color(150,150,150));
		restartbutton.setBounds(0, 0, 100, 50);	//Set the butto's position and size
		restartbutton.setFocusable(false);
		restartbutton.addActionListener(this); // set the buttton's action listener to the current class

		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonpanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this); 
		}
		titlepanel.setLayout ((LayoutManager) new FlowLayout (FlowLayout.RIGHT));
		titlepanel.add(textfeild);
		titlepanel.add(restartbutton); // add the button to the title panel
		frame.add(titlepanel,BorderLayout.NORTH); 
		frame.add(buttonpanel);
		firstturn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0 ; i<9;i++) {
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText().equals("")) {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfeild.setText("O urn");
						check();
						}
					}else {
						if(buttons[i].getText().equals("")) {
							buttons[i].setForeground(new Color(0,0,255));
							buttons[i].setText("O");
							player1_turn=true;
							textfeild.setText("X urn");
							check();
					}
				}				
			}			
		}
		
	}
	
	public void actionPerformed1 (ActionEvent e) {
		  if (e.getSource () == restartbutton) { // check if the source of the event is the button

			  for (int i = 0; i < 9; i++) {
				  buttons[i].getText().equals("");
				  buttons[i].setEnabled(true);
			      }
		    }
			    // reset the turn
			 firstturn(); // set the turn to X
		  }
	
	public void firstturn() {	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfeild.setText("X Turn");
			
		}else {

			player1_turn=false;
			textfeild.setText("O Turn");
		}
	}
	
	public void check() {
//		Check X wins
		if (buttons[0].getText().equals("X") && 
			buttons[1].getText().equals("X") && 
			buttons[2].getText().equals("X")) {
		    xWins(0, 1, 2);
			}
		if (buttons[3].getText().equals("X") && 
			buttons[4].getText().equals("X") && 
			buttons[5].getText().equals("X")
		    ){xWins(3,4,5);}
		if (buttons[6].getText().equals("X") && 
			buttons[7].getText().equals("X") && 
			buttons[8].getText().equals("X")
			){xWins(6,7,8);}
		if (buttons[2].getText().equals("X") && 
		    buttons[4].getText().equals("X") && 
		    buttons[6].getText().equals("X")
			){xWins(2,4,6);}		
		if (buttons[0].getText().equals("X") && 
		    buttons[4].getText().equals("X") && 
		    buttons[8].getText().equals("X")
			){xWins(0,4,8);}
		if (buttons[0].getText().equals("X") && 
		    buttons[3].getText().equals("X") && 
		    buttons[6].getText().equals("X")
			){xWins(0,3,6);}
		if (buttons[1].getText().equals("X") && 
		    buttons[4].getText().equals("X") && 
		    buttons[7].getText().equals("X")
			){xWins(1,4,7);}
		if (buttons[2].getText().equals("X") && 
		    buttons[5].getText().equals("X") && 
		    buttons[8].getText().equals("X")
			){xWins(2,5,8);}
						
//		Check O wins
		if (buttons[0].getText().equals("O") && 
		    buttons[1].getText().equals("O") && 
		    buttons[2].getText().equals("O")
			){oWins(0,1,2);}
		if (buttons[3].getText().equals("O") && 
		    buttons[4].getText().equals("O") && 
		    buttons[5].getText().equals("O")
			){oWins(3,4,5);}
		if (buttons[6].getText().equals("O") && 
		    buttons[7].getText().equals("O") && 
		    buttons[8].getText().equals("O")
			){oWins(6,7,8);}
		if (buttons[2].getText().equals("O") && 
		    buttons[4].getText().equals("O") && 
		    buttons[6].getText().equals("O")
			){oWins(2,4,6);}
		if (buttons[0].getText().equals("O") && 
		    buttons[4].getText().equals("O") && 
		    buttons[8].getText().equals("O")
			){oWins(0,8,4);}
		if (buttons[0].getText().equals("O") && 
		    buttons[3].getText().equals("O") && 
		    buttons[6].getText().equals("O")
			){oWins(0, 3, 6);}
		if (buttons[1].getText().equals("O") && 
		    buttons[4].getText().equals("O") && 
		    buttons[7].getText().equals("O")
			){oWins(1,4,7);}
		if (buttons[2].getText().equals("O") && 
		    buttons[5].getText().equals("O") && 
		    buttons[8].getText().equals("O")
			){oWins(2,5,8);
		}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.red);
		buttons[b].setBackground(Color.red);
		buttons[c].setBackground(Color.red);
		
		for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfeild.setText("X WINS");
	}
	
public void oWins(int a, int b, int c) {

	buttons[a].setBackground(Color.green);
	buttons[b].setBackground(Color.green);
	buttons[c].setBackground(Color.green);
	
	for(int i = 0; i<9; i++) {	
		buttons[i].setEnabled(false);
	}
	textfeild.setText("O WINS");
	}
}


 