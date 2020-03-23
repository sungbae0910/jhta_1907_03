package excel;

import java.util.Date;

public class FinanVo {

   int profit;
   int expend;
   Date idate;
   
   
   public FinanVo() {}
   public FinanVo(int profit, int expend, Date idate) {
      this.profit=profit;
      this.expend=expend;
      this.idate=idate;
   }


   public int getProfit() {
      return profit;
   }


   public void setProfit(int profit) {
      this.profit = profit;
   }


   public int getExpend() {
      return expend;
   }


   public void setExpend(int expend) {
      this.expend = expend;
   }
   
   public Date getIdate() {
      return idate;
   }
   
   public void setIdate(Date idate) {
      this.idate = idate;
   }
   

   
}
