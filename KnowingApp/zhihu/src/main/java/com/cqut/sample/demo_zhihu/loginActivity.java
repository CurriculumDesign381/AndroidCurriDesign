package com.cqut.sample.demo_zhihu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cqut.fragmentation.SupportActivity;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;

import com.cqut.sample.demo_zhihu.ui.fragment.fifth.PersonalHomeFragment;

import butterknife.BindView;

import static com.cqut.sample.R2.id.parent;


public class loginActivity extends SupportActivity {

   /* @BindView(R.id.part_second)
    LinearLayout l2;
    @BindView(R.id.part_third)
    LinearLayout l3;*/

    private Handler handler2 = new Handler();
private  static final  String TAG = "loginActivity";
    LinearLayout l1;
    LinearLayout l2;
    private EditText mUsername;
    private EditText mPassWord;
    private  int status = 0;
    String admin = "hf";
    String passWord = "123456";
    SupportFragment supportFragment = PersonalHomeFragment.newInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        login();




    }
    private void updateUi2(){
        LayoutInflater factory = LayoutInflater.from(loginActivity.this);
        View layout = factory.inflate(R.layout.person_page, null);

        l1 = layout.findViewById(R.id.part_first);
        l2 =  layout.findViewById(R.id.part_second);
        handler2.post(new Runnable() {
            @Override
            public void run() {
                //更新UI
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
            }
        });
    }

    public void login(){

        Button mButton=(Button)findViewById(R.id.sign_login);
        mUsername=(EditText)findViewById(R.id.admin);
        mPassWord=(EditText)findViewById(R.id.login_password);

   mButton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           if(mUsername.getText().toString().equals(admin)&&mPassWord.getText().toString().equals(passWord)){
               Log.d(TAG, "success: "+mUsername.getText().toString());
               Toast.makeText(loginActivity.this,  "登录成功", Toast.LENGTH_SHORT).show();

               updateUi2();

           /*    l1.setVisibility(View.VISIBLE);*/
               status = 1;
               keepLoginStatus(status);
               Intent intent = new Intent(loginActivity.this,MainActivity.class);
               startActivity(intent);

           }
           else {
               Log.d(TAG, "mUsername: "+mUsername.getText().toString());
               Toast.makeText(loginActivity.this, "电话" + "密码或账户名错误", Toast.LENGTH_SHORT).show();
           }
       }
   });


    }


public  void  keepLoginStatus(int status){
    SharedPreferences share = loginActivity.this.getSharedPreferences("loginStatus", MODE_PRIVATE);
    SharedPreferences.Editor edit = share.edit();//编辑文件
    edit.putInt("status",status);
    edit.commit();
}


}
