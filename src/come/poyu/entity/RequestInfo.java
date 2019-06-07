package come.poyu.entity;

public class RequestInfo {
    private int id;
    private String email;
    private String car_number;
    private String unrule_record;
    private String content;
    private int approval;
    private double money;
    private  int pointdec;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getUnrule_record() {
        return unrule_record;
    }

    public void setUnrule_record(String unrule_record) {
        this.unrule_record = unrule_record;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPointdec() {
        return pointdec;
    }

    public void setPointdec(int pointdec) {
        this.pointdec = pointdec;
    }
}
