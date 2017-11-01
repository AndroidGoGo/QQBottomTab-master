package star.yx.modul;

/**
 * Created by ${廖昭启} on 2017/10/24.
 */

public class RedPackModul {

    private int  redPackType;

    private String dates;
    private  double  money;

    private  int count;
    private  int status;
    private  int rec;

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }

    public int getRedPackType() {
        return redPackType;
    }

    public void setRedPackType(int redPackType) {
        this.redPackType = redPackType;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
