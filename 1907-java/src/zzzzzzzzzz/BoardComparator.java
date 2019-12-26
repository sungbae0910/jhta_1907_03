package zzzzzzzzzz;

import java.util.Comparator;

public class BoardComparator implements Comparator<BoardVo> {
   
   @Override
   public int compare(BoardVo o1, BoardVo o2) {
      return o1.getmDate()-o2.getmDate();
    		  
   }   
}