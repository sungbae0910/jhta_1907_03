package j_collections;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductOutput extends JInternalFrame {
	Set<ProductVo> pls;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JTextField nal;
	private JLabel status;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOutput frame = new ProductOutput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductOutput() {
		super("제품출고", false, true, true, true);
		setVisible(true);
		setTitle("\uC81C\uD488 \uCD9C\uACE0");
		setBounds(100, 100, 347, 343);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getNal());
		getContentPane().add(getStatus());
		getContentPane().add(getBtnNewButton());

	}
	
	public ProductOutput(Set<ProductVo> pls) {
		this();
		this.pls=pls;
	}
	
	
	//폼에서 입력한 값을 가지고 ProductVo 생성
	public void output(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(pCode.getText().equals("") || pName.getText().equals("") || ea.getText().equals("")||nal.getText().equals("")) {
			status.setText("입력항목에 빈 공간이 있습니다.");
			return;
		}
		try {
			String serial = sdf.format(new Date()) + "-" + MemberMain.eSerial;
			String pc = pCode.getText();
			String pn = pName.getText();
			int e = Integer.parseInt(ea.getText());
			Date n = sdf.parse(nal.getText());
			
			ProductVo pv = new ProductVo(serial,pc,pn,e,n);
			pls.add(pv);
			status.setText(MemberMain.eSerial+"번째 출고리스트가 작성되었습니다.");
			MemberMain.eSerial++;
			pCode.setText("");
			pName.setText("");
			ea.setText("");
		} catch (ParseException e1) {
			e1.printStackTrace();
		} catch(NumberFormatException e2){
			e2.printStackTrace();
		}
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel.setBounds(12, 44, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C\uD488\uBA85");
			lblNewLabel_1.setBounds(12, 84, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC218\uB7C9");
			lblNewLabel_2.setBounds(12, 125, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uCD9C\uACE0\uB0A0\uC9DC");
			lblNewLabel_3.setBounds(12, 167, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(110, 41, 165, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setBounds(110, 81, 165, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setBounds(110, 122, 165, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setHorizontalAlignment(SwingConstants.CENTER);
			nal.setBounds(110, 164, 165, 21);
			nal.setColumns(10);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			nal.setText(sdf.format(new Date()));
		}
		return nal;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setBackground(new Color(230, 230, 250));
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(39, 228, 257, 62);
		}
		return status;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uCD9C\uACE0");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					output();
				}
			});
			btnNewButton.setBounds(144, 195, 97, 23);
		}
		return btnNewButton;
	}
}
