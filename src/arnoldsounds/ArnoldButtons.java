package arnoldsounds;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ArnoldButtons implements ActionListener {
	
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;


	public ArnoldButtons() {
		
		JFrame frame = new JFrame();
		
		this.button = new JButton("Get to the chopper!");
		this.button2 = new JButton("Shut Up!");
		this.button3 = new JButton("Scream!");
		this.button4 = new JButton("Bathroom.");


		
		this.button.addActionListener(this);
		this.button2.addActionListener(this);
		this.button3.addActionListener(this);
		this.button4.addActionListener(this);


		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(this.button);
		panel.add(this.button2);
		panel.add(this.button3);
		panel.add(this.button4);


		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Arnold is king");
		frame.pack();
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
    	String audioResource = null;
    	
    	if(arg0.getSource() == button) {
    		audioResource = "chopper.wav";
    	}else if(arg0.getSource() == button2) {
    		audioResource = "shutup.wav";
    	}else if(arg0.getSource() == button3) {
    		audioResource = "scream.wav";
    	}else if(arg0.getSource() == button4) {
    		audioResource = "bathroom.wav";
    	}
        	
		AudioInputStream audioIn = null;
		try {
			audioIn = AudioSystem.getAudioInputStream(ArnoldButtons.class.getResource(audioResource));
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip.open(audioIn);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		clip.start();
	}

}
