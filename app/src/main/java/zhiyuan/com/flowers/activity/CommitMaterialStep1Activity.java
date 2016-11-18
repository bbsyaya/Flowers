package zhiyuan.com.flowers.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;
import zhiyuan.com.flowers.R;
import zhiyuan.com.flowers.application.MyApplication;
import zhiyuan.com.flowers.bean.ApplyInfo;

public class CommitMaterialStep1Activity extends BaseActivity {

    private static final String TAG = "CommitMaterialStep1";
    private EditText et_commit_count;
    private EditText et_commit_mouth;
    private EditText et_commit_name;
    private EditText et_commit_phone;
    private EditText et_commit_qq;
    private EditText et_commit_certif;
    private EditText et_commit_province;
    private ProgressDialog dialog;
    private TextView tv_commit_contactinf;
    private String applyId;
    private EditText et_commit_weixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_material_step1);

        initView();
    }

    private void initView() {
        et_commit_name = (EditText) findViewById(R.id.et_commit_name);
        et_commit_count = (EditText) findViewById(R.id.et_commit_count);
        et_commit_mouth = (EditText) findViewById(R.id.et_commit_mouth);
        et_commit_phone = (EditText) findViewById(R.id.et_commit_phone);
        et_commit_qq = (EditText) findViewById(R.id.et_commit_qq);
        et_commit_certif = (EditText) findViewById(R.id.et_commit_certif);
        et_commit_province = (EditText) findViewById(R.id.et_commit_province);
        et_commit_weixin = (EditText) findViewById(R.id.et_commit_weixin);

        tv_commit_contactinf = (TextView) findViewById(R.id.tv_commit_contactinf);


        String qqContactInfo = MyApplication.sharedPreferences.getString("qqContactInfo", "");
        if (!qqContactInfo.equals("")){
            tv_commit_contactinf.setText(qqContactInfo);
        }
    }


    public void commitInfo(View view){
        String name = et_commit_name.getText().toString();
        String count = et_commit_count.getText().toString();
        String mouth = et_commit_mouth.getText().toString();
        String phone = et_commit_phone.getText().toString();
        String qq = et_commit_qq.getText().toString();
        String certificate = et_commit_certif.getText().toString();
        String province = et_commit_province.getText().toString();
        String weixin = et_commit_weixin.getText().toString();

        Log.i(TAG,","+name+","+count+","+mouth);
        if (count.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入金额", Toast.LENGTH_SHORT).show();
        }
        else if (mouth.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入时间", Toast.LENGTH_SHORT).show();
        }
        else if (name.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }

        else if (phone.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入电话", Toast.LENGTH_SHORT).show();
        }

        /*else if (qq.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入qq", Toast.LENGTH_SHORT).show();
        }

        else if (certificate.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入身份证号", Toast.LENGTH_SHORT).show();
        }

        else if (province.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入省份", Toast.LENGTH_SHORT).show();
        }
        else if (weixin.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入微信", Toast.LENGTH_SHORT).show();
        }*/

        else {
            //数据提交
            applyId = "appid"+ System.currentTimeMillis();

            ApplyInfo applyInfo = new ApplyInfo(applyId,name,qq,weixin,certificate,province,count,phone,mouth);
            applyInfo.setPhone(phone);
            uploadData(applyInfo);
        }
    }

    private void uploadData(ApplyInfo applyInfo) {
        showDialog("正在提交");
        applyInfo.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                hideDialog();
                Toast.makeText(CommitMaterialStep1Activity.this, "申请成功", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CommitMaterialStep1Activity.this,ApplySuccessActivity.class));
                MyApplication.sharedPreferences.edit().putString("applyId",applyId).commit();
                finish();
            }

            @Override
            public void onFailure(int i, String s) {
                hideDialog();
                Toast.makeText(CommitMaterialStep1Activity.this, "申请失败"+s, Toast.LENGTH_SHORT).show();
            }
        });

    }

    void showDialog(String message) {
        try {
            if (dialog == null) {
                dialog = new ProgressDialog(this);
                dialog.setCancelable(true);
            }
            dialog.setMessage(message);
            dialog.show();
        } catch (Exception e) {
            // 在其他线程调用dialog会报错
        }
    }

    void hideDialog() {
        if (dialog != null && dialog.isShowing())
            try {
                dialog.dismiss();
            } catch (Exception e) {
            }
    }


    public void back(View view){
        finish();
    }
}
