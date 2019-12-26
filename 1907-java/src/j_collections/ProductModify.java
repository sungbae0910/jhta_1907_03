package j_collections;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ProductModify extends JInternalFrame {
	Set<ProductVo> pls;
	Set<ProductVo> ils;
	ButtonGroup bg = new ButtonGroup();
	ProductVo oldVo; //수정 전
	Set<ProductVo> list;  
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField serial;
	private JTextField pCode;
	private JTextField pName;
	private JTextField ea;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel status;
	private JLabel lblNewLabel_5;
	private JRadioButton imBtn;
	private JRadioButton exBtn;
	private JLabel lblNewLabel_6;
	private JTextField nal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductModify frame = new ProductModify();
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
	public ProductModify() {
		super("수정/삭제",false, true, true, true);
		setVisible(true);
		setBounds(100, 100, 400, 364);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getSerial());
		getContentPane().add(getPCode());
		getContentPane().add(getPName());
		getContentPane().add(getEa());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		getContentPane().add(getLblNewLabel_5());
		getContentPane().add(getImBtn());
		getContentPane().add(getExBtn());
		getContentPane().add(getLblNewLabel_6());
		getContentPane().add(getNal());

	}
	
	public ProductModify(Set<ProductVo> ils, Set<ProductVo> pls) {
		this();
		this.ils=ils;
		this.pls=pls;
	}
	
	public void search() {
		String s = serial.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(imBtn.isSelected()) {
			list=ils;
		}else {
			list=pls;
		}
		
		oldVo=null;
		status.setText("자료를 검색중입니다.");
		for(ProductVo old : list) {
			if(old.getSerial().equals(s)) {
				pCode.setText(old.getCode());
				pName.setText(old.getpName());
				ea.setText(Integer.toString(old.getEa()));
				nal.setText(sdf.format(old.getNal()));
				oldVo=old;
				status.setText("찾으시는 자료입니다.");
				break;
			}
		}
		
		if(oldVo == null) {
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("찾는자료가 없습니다.");
		}
/*		Iterator<ProductVo> a = list.iterator();
		while(a.hasNext()) {
			ProductVo pp = a.next();
			if(pp.getSerial().equals(s)) {
				pCode.setText(pp.getCode());
				pName.setText(pp.getpName());
				ea.setText(Integer.toString(pp.getEa()));
				nal.setText(sdf.format(pp.getNal()));
				break;
			}
		}*/
	}
	
	public void modify() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int eA = Integer.parseInt(ea.getText());
		if(oldVo!=null) {
			
			
			try {
				Date n = sdf.parse(nal.getText());
				ProductVo pb = new ProductVo(serial.getText(), pCode.getText(), pName.getText(), eA, n);
				list.remove(oldVo);
				list.add(pb);
				
				status.setText("내용이 수정되었습니다.");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else {
			status.setText("검색부터 해주세요");
		}
	}
	
	public void delete() {
		if(oldVo != null) {
			list.remove(oldVo);
			pCode.setText("");
			pName.setText("");
			ea.setText("");
			nal.setText("");
			status.setText("자료가 삭제되었습니다.");
		}else {
			status.setText("먼저 검색해주세요");
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC2DC\uB9AC\uC5BC");
			lblNewLabel.setBounds(28, 52, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC81C\uD488\uCF54\uB4DC");
			lblNewLabel_1.setBounds(28, 91, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uC81C\uD488\uBA85");
			lblNewLabel_2.setBounds(28, 131, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uC218\uB7C9");
			lblNewLabel_3.setBounds(28, 164, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getSerial() {
		if (serial == null) {
			serial = new JTextField();
			serial.setBounds(97, 48, 168, 21);
			serial.setColumns(10);
		}
		return serial;
	}
	private JTextField getPCode() {
		if (pCode == null) {
			pCode = new JTextField();
			pCode.setBounds(97, 87, 168, 21);
			pCode.setColumns(10);
		}
		return pCode;
	}
	private JTextField getPName() {
		if (pName == null) {
			pName = new JTextField();
			pName.setBounds(97, 128, 168, 21);
			pName.setColumns(10);
		}
		return pName;
	}
	private JTextField getEa() {
		if (ea == null) {
			ea = new JTextField();
			ea.setBounds(97, 161, 168, 21);
			ea.setColumns(10);
		}
		return ea;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});
			btnNewButton.setBounds(275, 48, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC218\uC815");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modify();
				}
			});
			btnNewButton_1.setBounds(97, 237, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uC0AD\uC81C");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnNewButton_2.setBounds(216, 237, 97, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setBackground(new Color(173, 216, 230));
			status.setOpaque(true);
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(28, 270, 325, 55);
		}
		return status;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("\uAD6C\uBD84");
			lblNewLabel_5.setBounds(28, 10, 57, 15);
		}
		return lblNewLabel_5;
	}
	private JRadioButton getImBtn() {
		if (imBtn == null) {
			imBtn = new JRadioButton("\uC785\uACE0");
			imBtn.setBounds(100, 6, 62, 23);
			bg.add(imBtn);
			imBtn.setSelected(true);
		}
		return imBtn;
	}
	private JRadioButton getExBtn() {
		if (exBtn == null) {
			exBtn = new JRadioButton("\uCD9C\uACE0");
			exBtn.setBounds(166, 6, 121, 23);
			bg.add(exBtn);
		}
		return exBtn;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("\uB0A0\uC9DC");
			lblNewLabel_6.setBounds(28, 195, 57, 15);
		}
		return lblNewLabel_6;
	}
	private JTextField getNal() {
		if (nal == null) {
			nal = new JTextField();
			nal.setBounds(97, 192, 168, 21);
			nal.setColumns(10);
		}
		return nal;
	}
}
