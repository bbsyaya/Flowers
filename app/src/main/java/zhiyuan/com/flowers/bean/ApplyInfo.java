package zhiyuan.com.flowers.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ApplyInfo extends BmobObject {
    private String applyId;
    private String name;
    private String qq;
    private String certificate;
    private String account;
    private String password;
    private String record;
    private String grade;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecord() {
        return record;
    }


    public void setRecord(String record) {
        this.record = record;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ApplyInfo(String applyId, String name, String qq, String certificate, String account, String password, String record, String grade) {
        this.applyId = applyId;
        this.name = name;
        this.qq = qq;
        this.certificate = certificate;
        this.account = account;
        this.password = password;
        this.record = record;
        this.grade = grade;
    }

    public ApplyInfo(String name, String qq, String certificate, String account, String password, String record, String grade) {
        this.name = name;
        this.qq = qq;
        this.certificate = certificate;
        this.account = account;
        this.password = password;
        this.record = record;
        this.grade = grade;
    }

    public ApplyInfo(String tableName, String applyId, String name, String qq, String certificate, String account, String password, String record, String grade, String phone) {
        super(tableName);
        this.applyId = applyId;
        this.name = name;
        this.qq = qq;
        this.certificate = certificate;
        this.account = account;
        this.password = password;
        this.record = record;
        this.grade = grade;
        this.phone = phone;
    }
}
