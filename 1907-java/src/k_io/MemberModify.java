package k_io;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberModify extends JInternalFrame {
	int index = -1;
	List<MemberVo> ls;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField mId;
	private JTextField pwd;
	private JTextField mName;
	private JTextField phone;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JLabel status;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberModify frame = new MemberModify();
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
	public MemberModify() {
		super("modify", false,true,true,true);
		setBounds(100, 100, 450, 349);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getMId());
		getContentPane().add(getPwd());
		getContentPane().add(getMName());
		getContentPane().add(getPhone());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getStatus());
		setVisible(true);

	}
	
	public void search() {
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		index = -1;
		String find = mId.getText();
		MemberDao dao = new MemberDao();
		MemberVo mv = dao.search(find);
		
		if(mv != null) {
			pwd.setText(mv.getPwd());
			mName.setText(mv.getmName());
			phone.setText(mv.getPhone());
			
			status.setBackground(Color.CYAN);
			status.setText("자료가 검색되었습니다.");
		}else{
			status.setText("찾는값이 없습니다.");
			status.setBackground(Color.LIGHT_GRAY);
			mId.requestFocus();
		}
	}
	

	
	public void modify() { //수정
		mId.setText("");
		pwd.setText("");
		mName.setText("");
		phone.setText("");
		
		MemberVo mv = new MemberVo(mId.getText(),pwd.getText(),mName.getText(),phone.getText());
		MemberDao dao = new MemberDao();
		boolean b = dao.modify(mv);
		if(b) {
			status.setText("수정완료되었습니다.");
		}else {
			status.setText("수정 중 오류발생");
		}
		
		
	}
	
	public void delete() { //삭제
			String findMid = mId.getText();
			MemberDao dao = new MemberDao();
			boolean b = dao.delete(findMid);
			
			if(b) {
			mId.setText("");
			pwd.setText("");
			mName.setText("");
			phone.setText("");
			status.setText("삭제완료!!");
			
			mId.requestFocus();
			mId.selectAll();
		}else {
			status.setText("자료 삭제 중 오류발 생");
		}
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC544\uC774\uB514");
			lblNewLabel.setBounds(12, 31, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("\uC554\uD638");
			lblNewLabel_1.setBounds(12, 76, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uBA85");
			lblNewLabel_2.setBounds(12, 118, 57, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("\uD3F0\uBC88\uD638");
			lblNewLabel_3.setBounds(12, 157, 57, 15);
		}
		return lblNewLabel_3;
	}
	private JTextField getMId() {
		if (mId == null) {
			mId = new JTextField();
			mId.setBounds(118, 28, 116, 21);
			mId.setColumns(10);
		}
		return mId;
	}
	private JTextField getPwd() {
		if (pwd == null) {
			pwd = new JTextField();
			pwd.setBounds(118, 73, 116, 21);
			pwd.setColumns(10);
		}
		return pwd;
	}
	private JTextField getMName() {
		if (mName == null) {
			mName = new JTextField();
			mName.setBounds(118, 115, 116, 21);
			mName.setColumns(10);
		}
		return mName;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(118, 154, 116, 21);
			phone.setColumns(10);
		}
		return phone;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("\uC0AD\uC81C");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			btnNewButton_1.setBounds(259, 188, 97, 23);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC218\uC815");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modify();
				}
			});
			btnNewButton.setBounds(128, 188, 97, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("\uAC80\uC0C9");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search();
				}
			});
			btnNewButton_2.setBounds(259, 27, 97, 23);
		}
		return btnNewButton_2;
	}
	private JLabel getStatus() {
		if (status == null) {
			status = new JLabel("");
			status.setOpaque(true);
			status.setBackground(new Color(176, 224, 230));
			status.setHorizontalAlignment(SwingConstants.CENTER);
			status.setBounds(12, 232, 388, 58);
		}
		return status;
	}
}
