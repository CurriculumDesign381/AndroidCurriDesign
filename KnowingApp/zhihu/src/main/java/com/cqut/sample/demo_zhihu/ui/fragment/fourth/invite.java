package com.cqut.sample.demo_zhihu.ui.fragment.fourth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cqut.sample.R;

public class invite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);


        View notice = findViewById(R.id.return_invite);
        notice.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(invite.this,Main_notice.class);

                startActivity(intent);
            }
        });

    }
}
