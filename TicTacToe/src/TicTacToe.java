import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	TicTacToe(){
		
		//Configures the game window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);;
		frame.getContentPane().setBackground(new Color(0,173,180));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//Configures the text field
		textfield.setBackground(new Color(0, 128, 128));
		textfield.setForeground(new Color(255,255,255));
		textfield.setFont(new Font("Comic Sans MS",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		//Configures the title panel
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		//Creating buttons
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);		
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
	
		//Schedule for first turn
		addTitlePage();
		Timer timer = new Timer(2000, e -> removeTitlePage());
	    timer.setRepeats(false); // Set to false to execute only once
		timer.start();
		firstTurn();
	}
	
	// Adds a title page
	public void addTitlePage() {
	    JPanel titlePagePanel = new JPanel(new GridBagLayout());
	    titlePagePanel.setPreferredSize(new Dimension(800, 800));

	    try {
	        // Initial logo image
	        BufferedImage logo = ImageIO.read(new File("src/Logo.jpg"));
	        // Logo when mouse hovers over it
	        BufferedImage logoHover = ImageIO.read(new File("src/LogoHover.jpg"));

	        int width = 140;
	        int height = (width * logo.getHeight()) / logo.getWidth();

	        // Scale the logos to a smaller size
	        Image scaledLogo = logo.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        Image scaledLogoHover = logoHover.getScaledInstance(width, height, Image.SCALE_SMOOTH);

	        // Convert images to icons
	        ImageIcon logoIcon = new ImageIcon(scaledLogo);
	        ImageIcon logoHoverIcon = new ImageIcon(scaledLogoHover);

	        JLabel logoLabel = new JLabel(logoIcon);
	        logoLabel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                logoLabel.setIcon(logoHoverIcon);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                logoLabel.setIcon(logoIcon);
	            }

	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/JasonRafferty"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });

	        GridBagConstraints logoConstraints = new GridBagConstraints();
	        logoConstraints.gridx = 0;
	        logoConstraints.gridy = 6;
	        titlePagePanel.add(logoLabel, logoConstraints);

	        // Adding the game title
	        JLabel textLabel = new JLabel
	                ("<html><font color='green'>Tic</font> <font color='red'>Tac</font> <font color='green'>Toe</font></html>");
	        textLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 120));
	        GridBagConstraints textConstraints = new GridBagConstraints();
	        textConstraints.gridx = 0;
	        textConstraints.gridy = 0;
	        titlePagePanel.add(textLabel, textConstraints);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    //Remove the existing components
	    frame.getContentPane().removeAll();
	    frame.getContentPane().add(titlePagePanel);

	    //Revalidate and repaint the frame to reflect the changes
	    frame.revalidate();
	    frame.repaint();
	}
	//Removes the title page
	public void removeTitlePage() {
	    frame.getContentPane().removeAll();
	    frame.getContentPane().add(title_panel, BorderLayout.NORTH);
	    frame.getContentPane().add(button_panel);

	    frame.revalidate();
	    frame.repaint();
	}
	
	//Adds an end game page
	public void addEndGamePanel() {
	    // Create a new panel with GridBagLayout
	    JPanel endGamePanel = new JPanel(new GridBagLayout());
	    endGamePanel.setPreferredSize(new Dimension(800, 800)); 

        //Create a "Play Again" button
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        playAgainButton.setForeground(Color.GREEN); 
        playAgainButton.addActionListener(e -> restartGame());
        playAgainButton.setBorderPainted(false);
        playAgainButton.setFocusPainted(false);
        playAgainButton.setContentAreaFilled(false);
      
	    
	    // Adding the Logo
	    try {
	        BufferedImage image = ImageIO.read(new File("src/Logo.jpg"));
	        BufferedImage imageHover = ImageIO.read(new File("src/LogoHover.jpg"));

	        int width = 160;
	        int height = (width * image.getHeight()) / image.getWidth();

	        // Create scaled versions of the logo and its hover state
	        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        Image scaledHoverImage = imageHover.getScaledInstance(width, height, Image.SCALE_SMOOTH);

	        // Create icon versions of the logo and its hover state
	        ImageIcon logoIcon = new ImageIcon(scaledImage);
	        ImageIcon logoHoverIcon = new ImageIcon(scaledHoverImage);

	        // Create the logo label
	        JLabel logoLabel = new JLabel(logoIcon);
	        logoLabel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                logoLabel.setIcon(logoHoverIcon);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                logoLabel.setIcon(logoIcon);
	            }

	            @Override
	            public void mouseClicked(MouseEvent e) {
	                try {
	                    Desktop.getDesktop().browse(new URI("https://github.com/JasonRafferty"));
	                } catch (IOException | URISyntaxException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });
	        
	        GridBagConstraints logoConstraints1 = new GridBagConstraints();
	        logoConstraints1.gridx = 0;
	        logoConstraints1.gridy = 0;
	        logoConstraints1.gridwidth = 2; // this line ensures that the logo is centered over the two buttons
	        endGamePanel.add(logoLabel, logoConstraints1);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	   
        //Hover Feature
        playAgainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playAgainButton.setContentAreaFilled(true);
                playAgainButton.setForeground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                playAgainButton.setContentAreaFilled(false);
                playAgainButton.setForeground(Color.GREEN); 
            }
        });
        

        //Create a "Quit" button
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        quitButton.setForeground(Color.RED); 
        quitButton.addActionListener(e -> System.exit(0));
        quitButton.setBorderPainted(false);
        quitButton.setFocusPainted(false);
        quitButton.setContentAreaFilled(false);
        
        //Hover Feature
        quitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quitButton.setContentAreaFilled(true);
                quitButton.setForeground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                quitButton.setContentAreaFilled(false);
                quitButton.setForeground(Color.RED);
            }
        });

        //Add the buttons to the panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // some padding

        constraints.gridx = 0;
        constraints.gridy = 40;
        endGamePanel.add(playAgainButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 40;
        endGamePanel.add(quitButton, constraints);

        //Remove the existing components
        frame.getContentPane().removeAll();
        frame.getContentPane().add(endGamePanel);

        //Revalidate and repaint the frame to reflect the changes
        frame.revalidate();
        frame.repaint();
    }
    
    //This method restarts the game
    public void restartGame() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(title_panel, BorderLayout.NORTH);
        frame.getContentPane().add(button_panel);
        frame.revalidate();
        frame.repaint();
        firstTurn();
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(new JButton().getBackground());
        }
    }
    
    public void startGame() {
        // Remove the existing components
        frame.getContentPane().removeAll();
        frame.getContentPane().add(title_panel, BorderLayout.NORTH);
        frame.getContentPane().add(button_panel);

        frame.revalidate();
        frame.repaint();

        firstTurn();
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setBackground(new Color(255, 255, 255)); // Reset button backgrounds to white
        }
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText().equals("")) {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn = false;
						textfield.setText("O turn");	
						check();
					}	
				}
				else {
					if(buttons[i].getText().equals("")) {
						buttons[i].setForeground(new Color(0,255,0));
						buttons[i].setText("O");
						player1_turn = true;
						textfield.setText("X turn");	
						check();
						}
					}
				}
		}
		
	}
	
	public void firstTurn() {
		
		disableButtons();
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enableButtons();
		
		//Selects randomly who starts
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}
	}
	
	public void disableButtons() {
		for (int b=0 ; b<9 ; b++) {
			buttons[b].setEnabled(false);
		}
	}
	
	public void enableButtons() {
		for (int b=0 ; b<9 ; b++) {
			buttons[b].setEnabled(true);
		}
	}
	
	public void check() {
		//Check x win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X") 
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X") 
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X") 
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X") 
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X") 
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X") 
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X") 
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X") 
				) {
			xWins(2,4,6);
		}
		

		//Check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") 
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O") 
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O") 
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O") 
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O") 
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O") 
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O") 
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O") 
				) {
			oWins(2,4,6);
		}
		
		//Check if any win condition has already been met
	    if (textfield.getText().equals("X Wins") || textfield.getText().equals("O Wins")) {
	    	//The return method exits the method earlier
	        return; 
	    }
		
		//Check for a tie condition
		boolean isTie = true; 
	    for (int x = 0; x < 9; x++) {
	        if (buttons[x].getText().isEmpty()) {
	            isTie = false;
	            break;
	        }
	    }
	    if (isTie) {
	        disableButtons();
	        textfield.setText("It's a Tie!"); 

	        Timer timer = new Timer(1400, e -> addEndGamePanel());
	        timer.setRepeats(false);
	        timer.start();
	    }
	    //Check if the game has ended
	    if (textfield.getText().equals("X Wins") || textfield.getText().equals("O Wins") || textfield.getText().equals("It's a Tie!")) {
	        Timer timer = new Timer(1400, e -> addEndGamePanel());
	        timer.setRepeats(false); // Set to false to execute only once
	        timer.start();
	    }
	}
	
	
	public void xWins(int a, int b, int c) {
		//Set the winning buttons to Green
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins");
		
		 Timer timer = new Timer(1400, e -> addEndGamePanel());
		    timer.setRepeats(false);
		    timer.start();
	
		
	}
	
	public void oWins(int a, int b, int c) {
		//Set the winning buttons to Green
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins");
		
		 Timer timer = new Timer(1400, e -> addEndGamePanel());
		    timer.setRepeats(false);
		    timer.start();
	}
}
