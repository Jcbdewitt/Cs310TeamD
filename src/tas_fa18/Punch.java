/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas_fa18;
import java.text.*;
import java.util.*;
/**
 *
 * @author jdewi
 */
public class Punch {
    
    private Badge employeeBadge;
    private int punchType;
    private int terminalId;
    private long originalTimeStamp;
    
    public Punch(Badge employeeBadges, int terminalId, int punchType, long originalTimeStamp){
        this.employeeBadge = employeeBadges;
        this.punchType = punchType;
        this.terminalId = terminalId;
        this.originalTimeStamp = originalTimeStamp;
    }
    
    public Punch(Badge employeeBadges, int terminalId, int punchType) {
        this.employeeBadge = employeeBadges;
        this.punchType = punchType;
        this.terminalId = terminalId;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.getTime();
        this.originalTimeStamp = calendar.getTimeInMillis();
    }
    
    public String getBadgeid() {
        String returningString = (String)employeeBadge.getId();
        return returningString;
    }
    
    public int getTerminalid() {
        int returningInt = this.terminalId;
        return returningInt;
    }
    
    public int getPunchtypeid() {
        int returningInt = this.punchType;
        return returningInt;
    }
    
    public long getOriginaltimestamp() {
        long returningLong = this.originalTimeStamp;
        return returningLong;
    }
    
    public String printOriginalTimestamp() {
        String punchResults = "";
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(this.originalTimeStamp);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss");  
        String strDate = formatter.format(date);
        switch(this.punchType){
            case 0:
                punchResults = " CLOCKED OUT:";
                break;
            case 1:
                punchResults = " CLOCKED IN:";
                break;
            case 2:
                punchResults = " TIMED OUT:";
                break;
            default:
                System.out.println("Error");
        }
        
        String originalTimestampString = "#" + this.employeeBadge.getId() + punchResults + " " + strDate.toUpperCase();
        return originalTimestampString;
    }
    
    public void adjust(Shift s) {
        
    }
}
