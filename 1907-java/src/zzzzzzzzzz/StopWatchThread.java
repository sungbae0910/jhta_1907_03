package zzzzzzzzzz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StopWatchThread extends JPanel implements Runnable{
	private JTextField asd;
	boolean stop = false;

	/**
	 * Create the panel.
	 */
	public StopWatchThread() {
		setLayout(new BorderLayout(0, 0));
		add(getAsd(), BorderLayout.CENTER);
	}
	
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
		/*DecimalFormat df = new DecimalFormat("###,###.000");*/
		long begin = new Date().getTime();
		while(!stop) {
			long end = new Date().getTime()-begin;
			try {
				Thread.sleep(1);
			} catch (Exception e) {}
			/*asd.setText(df.format(end/1000.0));*/
			asd.setText(sdf.format(end));
		}
	}
	private JTextField getAsd() {
		if (asd == null) {
			asd = new JTextField();
			asd.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
			asd.setHorizontalAlignment(SwingConstants.CENTER);
			asd.setColumns(10);
		}
		return asd;
	}
}
