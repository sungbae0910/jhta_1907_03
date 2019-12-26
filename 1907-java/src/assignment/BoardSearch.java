package assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BoardSearch extends JInternalFrame {
   private JPanel panel;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea textArea;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardSearch frame = new BoardSearch();
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
   public BoardSearch() {
      super("Board Search", true, true, true, true);
      setBounds(100, 100, 318, 281);
      getContentPane().add(getPanel(), BorderLayout.NORTH);
      getContentPane().add(getScrollPane(), BorderLayout.CENTER);
      setVisible(true);
   }

   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(35, 35));
         panel.add(getBtnNewButton());
      }
      return panel;
   }

   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uC870\uD68C!");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               // 3.BoardSearch.java(IntervalFrame)
               // -배열에 저장된 내용을 작성일순으로 내림차순 정렬하여 표시
               // BoardComparator
/*               BoardVo[] temp = BoardMain.data;
               BoardVo ee = null;
               int result = 0;

               for (int i = 0; i < BoardMain.count - 1; i++) {
                  for (int j = i + 1; j < BoardMain.count; j++) {
                     result = Objects.compare(temp[i], temp[j], new BoardComparator());
                     if (result < 0) {
                        ee = temp[i];
                        temp[i] = temp[j];
                        temp[j] = ee;
                     }
                  }
               }*/ // For문의 끝
            	
            	//내부 아키텍처에 의해 소트
               Collections.sort(Arrays.asList(BoardMain.data), new BoardComparator());            

               String tet = "";
               textArea.setText("");
               for (int i = 0; i < BoardMain.count; i++) {
            	   BoardVo a = BoardMain.data[i];
            	   tet += a.toString();
               }
               textArea.append(tet);
            }

         });
      }
      return btnNewButton;
   }

   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTextArea());
      }
      return scrollPane;
   }

   private JTextArea getTextArea() {
      if (textArea == null) {
         textArea = new JTextArea();
      }
      return textArea;
   }
}