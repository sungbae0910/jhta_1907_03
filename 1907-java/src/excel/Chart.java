package excel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart extends JDialog {
	List<FinanVo> list;
	FinanVo vo;
	private JButton btnNewButton;

	public static void main(String[] args) throws Exception {
		    SwingUtilities.invokeAndWait(()->{
		    Chart example=new Chart();
		      example.setSize(800, 400);
		      example.setLocationRelativeTo(null);
		      example.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		      example.setVisible(true);
		    });
		  }	
		
  public Chart() {
//    super(appTitle);

    // Create Dataset
    CategoryDataset dataset = createDataset();
    
    //Create chart
    JFreeChart chart=ChartFactory.createBarChart(
        "salary", //Chart Title
        "", // Category axis
        "", // Value axis
        dataset,
        PlotOrientation.VERTICAL,
        true,true,false
       );

    ChartPanel panel=new ChartPanel(chart);
    setBounds(100, 100, 800, 444);
    setContentPane(panel);
    panel.setLayout(null);
    panel.add(getBtnNewButton());
    setVisible(true);
  }
  


  private CategoryDataset createDataset() {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    FinanDao dao = new FinanDao();
    int s = 0;
/*    List<Integer> list = dao.select();
    for(int i = 0; i<list.size(); i++) {
    	s = list.get(i);
    	dataset.addValue(s, "USA"+i, i+"month");
    }*/
    	List<FinanVo> list = dao.selectPE();
	    for(int i = 0; i<list.size(); i++) {
	    	vo = list.get(i);
	    	dataset.addValue(vo.getExpend(), "expend", (i+1)+"month");
	    	dataset.addValue(vo.getProfit(), "profit", (i+1)+"month");
	    }
    return dataset;
  }
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uC5D1\uC140 \uC800\uC7A5");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sdf = new SimpleDateFormat("MM");
					FinanDao dao = new FinanDao();
					List<FinanVo> list = dao.selectPE();
					Excel ex = new Excel();
					
					boolean bo = ex.xlsxWiter(list);
					if(bo) {
						JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
					}else {
						JOptionPane.showMessageDialog(null, "�������� ���� �� ���� �߻�!!");
					}
				}
			});
			btnNewButton.setBounds(650, 6, 111, 23);
		}
		return btnNewButton;
	}
}
