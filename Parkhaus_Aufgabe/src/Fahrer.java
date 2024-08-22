public class Fahrer {
private long start;
private long end;
private boolean bezahlt = false;

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }



public long getCheckInTime(){
    long start = System.currentTimeMillis();
    return start;
}

public long getCheckOutTime(){
    long end = System.currentTimeMillis();
    return end;
}

public long getVisitTime(long end, long start) {
    return end - start;
}}

