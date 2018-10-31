package com.cqut.sample.demo_zhihu.ui.fragment.fourth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cqut.sample.R;


public class Main_notice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        View set = findViewById(R.id.notice_set);
        set.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Main_notice.this,setting.class);

                startActivity(intent);
            }
        });

        View privateletter = findViewById(R.id.LinearLayout_privateletter);
        privateletter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Main_notice.this,privateletter.class);

                startActivity(intent);
            }
        });
        View invite = findViewById(R.id.LinearLayout_invite);
        invite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Main_notice.this,invite.class);
                startActivity(intent);
            }
        });
        View badge = findViewById(R.id.LinearLayout_badge);
        badge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Main_notice.this,badge.class);
                startActivity(intent);
            }
        });
    }
}
