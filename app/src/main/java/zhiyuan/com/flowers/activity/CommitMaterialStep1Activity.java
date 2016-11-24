package zhiyuan.com.flowers.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import zhiyuan.com.flowers.R;
import zhiyuan.com.flowers.application.MyApplication;

public class CommitMaterialStep1Activity extends BaseActivity {

    private static final String TAG = "CommitMaterialStep1";
    private EditText et_commit_count;
    private EditText et_commit_mouth;
    private EditText et_commit_name;
    private EditText et_commit_phone;
    private ProgressDialog dialog;
    private TextView tv_commit_contactinf;

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
        tv_commit_contactinf = (TextView) findViewById(R.id.tv_commit_contactinf);

        String qqContactInfo = MyApplication.sharedPreferences.getString("qqContactInfo", "");
        if (!qqContactInfo.equals("")){
            tv_commit_contactinf.setText(qqContactInfo);
        }
    }


    public void netStep(View view){
        String name = et_commit_name.getText().toString();
        String count = et_commit_count.getText().toString();
        String mouth = et_commit_mouth.getText().toString();
        String phone = et_commit_phone.getText().toString();

        Log.i(TAG,","+name+","+count+","+mouth);
        if (count.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入金额", Toast.LENGTH_SHORT).show();
        }
        else if (mouth.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入月数", Toast.LENGTH_SHORT).show();
        }
        else if (name.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
        }

        else if (phone.equals("")){
            Toast.makeText(CommitMaterialStep1Activity.this, "请输入电话", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, CommitMaterialStep2Activity.class);
            intent.putExtra("name",name);
            intent.putExtra("count",count);
            intent.putExtra("mouth",mouth);
            intent.putExtra("phone",phone);
            startActivity(intent);
            finish();
        }
    }

    public void back(View view){
        finish();
    }
}
