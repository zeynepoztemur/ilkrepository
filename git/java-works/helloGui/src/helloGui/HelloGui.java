package helloGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;
import java.awt.FlowLayout;

public class HelloGui {

	public JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloGui window = new HelloGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("HOSGELDİNİZ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblk = new JLabel("MERHABA HOŞGELDİNİZ");
		lblk.setBounds(81, 90, 258, 32);
		lblk.setBackground(UIManager.getColor("ToolBar.shadow"));
		lblk.setFont(new Font("SignPainter", Font.PLAIN, 32));
		frame.getContentPane().add(lblk);
		
		JButton btnTkl = new JButton("Yeni bir sf için tıkla");
		btnTkl.setBounds(132, 139, 158, 45);
		btnTkl.addMouseMotionListener(null);
		btnTkl.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			Next nxt = new Next();
			nxt.frame.setVisible(true);
	
			
			}
		});
		frame.getContentPane().add(btnTkl);
	}

}
