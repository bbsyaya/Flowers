package zhiyuan.com.flowers.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/8/12.
 */
public class ApplyInfo extends BmobObject {
    private String applyId;
    private String name;
    private String qq;
    private String weixin;
    private String certificate;
    private String province;
    private String money;
    private String phone;
    private String mouths;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMone() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMouths() {
        return mouths;
    }

    public void setMouths(String mouths) {
        this.mouths = mouths;
    }

    public ApplyInfo(String applyId, String name, String qq, String weixin, String certificate, String province, String money, String phone, String mouths) {
        this.applyId = applyId;
        this.name = name;
        this.qq = qq;
        this.weixin = weixin;
        this.certificate = certificate;
        this.province = province;
        this.money = money;
        this.phone = phone;
        this.mouths = mouths;
    }
}
