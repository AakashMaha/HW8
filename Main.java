package HW8;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField textFieldAddSku;
	private JTextField textFieldAddTitle;
	private JTextField textFieldAddPrice;
	private JTextField textFieldAddQuantity;
	private JTextField textFieldDeleteSku;
	private JTextField textFieldDisplaySku;
	private JTextArea textAreaOutputAll;
	private JTextArea textAreaOutputOne;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnDisplay;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		createEvents();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SKU");
		lblNewLabel_1.setBounds(105, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setBounds(185, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(259, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity");
		lblNewLabel_4.setBounds(335, 10, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
	    btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(-1, 44, 74, 21);
		frame.getContentPane().add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(-1, 90, 74, 21);
		frame.getContentPane().add(btnDelete);
		
		btnDisplay = new JButton("Display one");
		btnDisplay.setBounds(-1, 191, 85, 21);
		frame.getContentPane().add(btnDisplay);
		
		textFieldAddSku = new JTextField();
		textFieldAddSku.setBounds(87, 45, 54, 19);
		frame.getContentPane().add(textFieldAddSku);
		textFieldAddSku.setColumns(10);
		
		textFieldAddTitle = new JTextField();
		textFieldAddTitle.setColumns(10);
		textFieldAddTitle.setBounds(164, 45, 54, 19);
		frame.getContentPane().add(textFieldAddTitle);
		
		textFieldAddPrice = new JTextField();
		textFieldAddPrice.setColumns(10);
		textFieldAddPrice.setBounds(243, 45, 54, 19);
		frame.getContentPane().add(textFieldAddPrice);
		
		textFieldAddQuantity = new JTextField();
		textFieldAddQuantity.setColumns(10);
		textFieldAddQuantity.setBounds(323, 45, 54, 19);
		frame.getContentPane().add(textFieldAddQuantity);
		
		textFieldDeleteSku = new JTextField();
		textFieldDeleteSku.setColumns(10);
		textFieldDeleteSku.setBounds(83, 91, 54, 19);
		frame.getContentPane().add(textFieldDeleteSku);
		
		textAreaOutputAll = new JTextArea();
		textAreaOutputAll.setBounds(93, 120, 287, 92);
		frame.getContentPane().add(textAreaOutputAll);
		
		textAreaOutputOne = new JTextArea();
		textAreaOutputOne.setBounds(93, 230, 287, 23);
		frame.getContentPane().add(textAreaOutputOne);
		
		textFieldDisplaySku = new JTextField();
		textFieldDisplaySku.setColumns(10);
		textFieldDisplaySku.setBounds(10, 233, 54, 19);
		frame.getContentPane().add(textFieldDisplaySku);
		
		lblNewLabel = new JLabel("SKU:");
		lblNewLabel.setBounds(9, 210, 45, 13);
		frame.getContentPane().add(lblNewLabel);
	}
	private void createEvents() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutputAdd();
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutputDelete();
			}
		});
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutputDisplay();
			}
		});
	}
	private void buildOutputAdd() {
		int sku = Integer.parseInt(textFieldAddSku.getText());
		String title = textFieldAddTitle.getText().toString();
		double price = Double.parseDouble(textFieldAddPrice.getText());
		int quantity = Integer.parseInt(textFieldAddQuantity.getText());
		textAreaOutputAll.append(Inventory.buildString(sku,title,price,quantity));
	}
	private void buildOutputDelete() {
		String sku = textFieldDeleteSku.getText();
		final JTextArea converter = new JTextArea();
		converter.setText(textAreaOutputAll.getText().toString());
		String list =  converter.getText().toString();
		String[] lines = list.split("\n");
		for(int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith(textFieldDeleteSku.getText())) {
				lines[i] = "";
			}
			else if (!lines[i].startsWith(textFieldDeleteSku.getText())) {
				lines[i] = "ERROR: ITEM IS NOT IN INVENTORY";
			}
		}
		StringBuilder finalStringBuilder= new StringBuilder("");
		for(String s:lines){
		   if(!s.equals("")){
		       finalStringBuilder.append(s).append("\n");
		    }
		}
		String finalString = finalStringBuilder.toString();
		textAreaOutputAll.setText(finalString);

	}
	private void buildOutputDisplay() {
		String sku = textFieldDisplaySku.getText();
		final JTextArea converter = new JTextArea();
		converter.setText(textAreaOutputAll.getText().toString());
		String list =  converter.getText().toString();
		String[] lines = list.split("\n");
		for(int i = 0; i < lines.length; i++) {
			if (lines[i].startsWith(textFieldDisplaySku.getText())) {
				textAreaOutputOne.setText(lines[i]);
			}
			else if(!lines[i].startsWith(textFieldDisplaySku.getText())){
				textAreaOutputOne.setText("Error: SKU does not exist");

			}
		}
	}

}
