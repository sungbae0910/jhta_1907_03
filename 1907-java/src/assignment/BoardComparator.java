package assignment;

import java.util.Comparator;

public class BoardComparator implements Comparator<BoardVo> {

	@Override
   public int compare(BoardVo o1, BoardVo o2) {
      int r = 0;
      
      if(o1==null || o2 == null) {
    	  r=0;
      }else {
    	  r = o2.getmDate().compareTo(o1.getmDate());
      }
	   
	   return r;
    		  
   }
}