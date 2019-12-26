package zzzzzzzzzz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class BoardMain extends JFrame {

   private JDesktopPane contentPane;
   private JMenuBar menuBar;
   private JMenu mnNewMenu;
   private JMenuItem input;
   private JMenuItem search;
   static  BoardVo[] data;
   static int count; //게시물 수 
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardMain frame = new BoardMain();
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
   static{
      data = new BoardVo[100];
      
      BoardVo bVo = new BoardVo(1, "안녕하세요","모두들 안녕하세요~", "kjava", 1185, "23");
      data[0] = bVo;
      
      bVo = new BoardVo(2, "질문이요","안녕하세요. 질문이있어요!", "dkdlel", 2018, "11");
      data[1] = bVo;
      
      bVo = new BoardVo(3, "테스트!","잘 작동하나요?", "kakao", 8888, "2");
      data[2] = bVo;
      
      count = 3;
      
   }
   public BoardMain() {
      setTitle("Board");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 731, 461);
      setJMenuBar(getMenuBar_1());
      contentPane = new JDesktopPane();
      contentPane.setBackground(new Color(255, 245, 238));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
   }

   private JMenuBar getMenuBar_1() {
      if (menuBar == null) {
         menuBar = new JMenuBar();
         menuBar.add(getMnNewMenu());
      }
      return menuBar;
   }
   private JMenu getMnNewMenu() {
      if (mnNewMenu == null) {
         mnNewMenu = new JMenu("\uBA54\uB274");
         mnNewMenu.add(getInput());
         mnNewMenu.add(getSearch());
      }
      return mnNewMenu;
   }
   private JMenuItem getInput() {
      if (input == null) {
         input = new JMenuItem("\uC785\uB825");
         input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               BoardInput input = new BoardInput();
               contentPane.add(input);
            }
         });
      }
      return input;
   }
   private JMenuItem getSearch() {
      if (search == null) {
         search = new JMenuItem("\uC870\uD68C");
         search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	BoardSearch dd = new BoardSearch();
            	contentPane.add(dd);
            }
         });
      }
      return search;
   }
   
}