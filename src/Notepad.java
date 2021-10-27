import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class Notepad {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad window = new Notepad();
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
	public Notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,450,300);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\notepad.png");

		frame.setIconImage(icon); 
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem item1 = new JMenuItem("New");
		item1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item1);
		
		/*JMenuItem item2 = new JMenuItem("New Window  ");
		item2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item2);*/
		
		JMenuItem item3 = new JMenuItem("Open...");
		item3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item3);
		
		JMenuItem item4 = new JMenuItem("Save");
		item4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item4);
		
		/*JMenuItem item5 = new JMenuItem("Save As...");
		item5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(item5);*/
		
		JMenuItem item6 = new JMenuItem("Print...");
		item6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item6);
		
		JMenuItem item7 = new JMenuItem("Exit");
		item7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		mnNewMenu.add(item7);
		
		JMenu h = new JMenu("Edit");
		h.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(h);
		
		JMenuItem item8 = new JMenuItem("Cut");
		item8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		h.add(item8);
		
		JMenuItem item9 = new JMenuItem("Copy");
		item9.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		h.add(item9);
		
		JMenuItem item10 = new JMenuItem("Paste");
		item10.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		h.add(item10);
		
		JMenuItem item11 = new JMenuItem("Delete");
		item11.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		h.add(item11);
		
		JMenuItem item12 = new JMenuItem("Select All");
		item12.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		h.add(item12);
		
		JMenuItem item13 = new JMenuItem("Time/Date");
		item13.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		item13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,ActionEvent.CTRL_MASK));
		h.add(item13);
		
		JMenu mnNewMenu_1_1 = new JMenu("Format");
		mnNewMenu_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1_1);
		
		JMenu mnNewMenu_1_1_1 = new JMenu("View");
		mnNewMenu_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1_1_1);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem about = new JMenuItem("About Notepad");
		about.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu_1.add(about);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monaco", Font.PLAIN, 18));
		textArea.setColumns(160);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		frame.getContentPane().add(textArea, BorderLayout.WEST);
		frame.setVisible(true);
		//new window
		
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("New")) {
				textArea.setText("");
				}
				
			}
			});
		
		//for open
		
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("Open...")) {
					
					JFileChooser o = new JFileChooser();
					o.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter ext= new FileNameExtensionFilter("only .txt .java .xml .dart .py files","txt","java","xml","py","dart") ;
					o.addChoosableFileFilter(ext);
					int action = o.showOpenDialog(o);
					if(action !=o.APPROVE_OPTION) {
						return;
					}
					File file = o.getSelectedFile();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
						textArea.read(reader, null);
						
					}catch(Exception ex) {}

					
				
			}
			}});
	
//	for Save
	
		item4.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Save")) {
					
					JFileChooser s = new JFileChooser();
					s.setApproveButtonText("Save");
					int action = s.showSaveDialog(s);
					if (action !=JFileChooser.APPROVE_OPTION) {
						return;
					}
					
					File filename = new File(s.getSelectedFile() + ".txt");
					BufferedWriter outfile = null;
					try {
						outfile = new BufferedWriter(new FileWriter(filename));
						textArea.write(outfile);
						
					}catch(Exception ex) {}
				}
			}
		});
		
		
		// for print
		item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Print...")) {
					try {
						textArea.print();
					}catch(Exception ex) {}					
					
				}
			}
		});
		
		//for exit
		
		item7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Exit")) {
					try {
						System.exit(0);
					}catch(Exception ex) {}					
					
				}
			}
		});
		
		//for cut
		item8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Cut")) {
					textArea.cut();				
					
				}
			}
		});
		
		// for copy
		item9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Copy")) {
					textArea.copy();			
					
				}
			}
		});
		
		
		//for Paste
		
		item10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Paste")) {
					textArea.paste();
					
					
				}
			}
		});
		
		
		// for delete 
		item11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Delete")) {
					textArea.setText("");		
					
				}
			}
		});
		// for SelectAll
		
		item12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Delete")) {
					textArea.selectAll();		
					
				}
			}
		});
		
		//for time and date 
		item13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Time/Date")) {
				     LocalDateTime now = LocalDateTime.now();  
				     DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				     String formatDateTime = now.format(format);  
				     textArea.setText(formatDateTime);
				}
			}
		});
		
	//about notpad
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("About Notepad")) {
				   new About().setVisible(true);
				}
			}
		});
	
	}
	
}
