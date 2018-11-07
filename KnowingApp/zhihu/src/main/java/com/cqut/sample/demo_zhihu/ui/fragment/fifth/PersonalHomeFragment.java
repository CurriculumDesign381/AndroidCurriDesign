package com.cqut.sample.demo_zhihu.ui.fragment.fifth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.adapter.FruitAdapter;
import com.cqut.sample.demo_zhihu.entity.Fruit;
import com.cqut.sample.demo_zhihu.loginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;
import static com.cqut.sample.R2.id.container;

/**
 * Created by fei on 2018/10/25.
 */

public class PersonalHomeFragment extends SupportFragment {
    /*@BindView(R.id.part_first)
    LinearLayout l1;
    @BindView(R.id.part_second)
    LinearLayout l2;*/
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    LinearLayout l1_2;
    LinearLayout l2_2;
    LinearLayout l3_2;

    private  int status;
    private Handler handler2 = new Handler();
    private static final String ARG_TYPE = "arg_type";
    public static PersonalHomeFragment newInstance() {

        Bundle args = new Bundle();
    /*    args.putString(ARG_TYPE, title);*/
        PersonalHomeFragment fragment = new PersonalHomeFragment();
        /*fragment.setArguments(args);*/
        return fragment;
    }
    private List<Fruit> fruitInfo = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void updateUi2(){
        l1 =  getActivity().findViewById(R.id.part_first);
        l2 =  getActivity().findViewById(R.id.part_second);
        l3 = getActivity().findViewById(R.id.part_third);

        l1_2 =  getActivity().findViewById(R.id.part_first2);
        l2_2 =  getActivity().findViewById(R.id.part_second2);
        l3_2 = getActivity().findViewById(R.id.part_third2);
        handler2.post(new Runnable() {
            @Override
            public void run() {
                //更新UI
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.VISIBLE);
                l1_2.setVisibility(View.GONE);
                l2_2.setVisibility(View.GONE);
                l3_2.setVisibility(View.GONE);


            }
        });
    }
    private void initFruit() {
        for (int i = 0; i < 2;i++) {
            Fruit icon1 = new Fruit("模板一",R.drawable.flow1);
            fruitInfo.add(icon1);
            Fruit icon2 = new Fruit("模板二",R.drawable.flow2);
            fruitInfo.add(icon2);
            Fruit icon3 = new Fruit("模板三",R.drawable.flow3);
            fruitInfo.add(icon3);
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.person_page, container, false);
        initFruit();

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());

        //设置水平滚动
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter adapter = new FruitAdapter(fruitInfo);
        recyclerView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = getActivity().findViewById(R.id.textView20_2);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),loginActivity.class);
                startActivity(intent);
            }
        });

    }


public void initialize(){

    l1_2 =  getActivity().findViewById(R.id.part_first2);
    l2_2 =  getActivity().findViewById(R.id.part_second2);
    l1 =  getActivity().findViewById(R.id.part_first);
    l2 =  getActivity().findViewById(R.id.part_second);


    l1.setVisibility(View.VISIBLE);
    l2.setVisibility(View.VISIBLE);
    l2.setVisibility(View.VISIBLE);
    l2.setVisibility(View.VISIBLE);


}


    @Override
    public void onResume() {
        super.onResume();
        status =0;
        SharedPreferences share = getActivity().getSharedPreferences("loginStatus",MODE_PRIVATE);
         status= share.getInt("status",0);
        Log.d(TAG, "onResume: dddd"+status);

        if(status ==1) {
            updateUi2();
            status = 0;
        }

        keepLoginStatus( status);
    }

    public  void  keepLoginStatus(int status){
        SharedPreferences share = getActivity().getSharedPreferences("loginStatus", MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();//编辑文件
        edit.putInt("status",status);
        edit.commit();
    }
}