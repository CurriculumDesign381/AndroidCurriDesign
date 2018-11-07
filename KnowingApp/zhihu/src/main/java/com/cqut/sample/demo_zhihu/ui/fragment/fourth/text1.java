package com.cqut.sample.demo_zhihu.ui.fragment.fourth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;


public class text1 extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    String TextContent ="Colleage";
    private String mTitle;

    public static HomePageFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_TYPE, title);
        HomePageFragment fragment = new HomePageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getActivity().findViewById(R.id.notice_set);
        view.setOnClickListener(new android.view.View.OnClickListener(){
            public void onClick(android.view.View v) {
//            Intent intent=new Intent(getActivity(),setting.class);
//            startActivity();
            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_setting, container, false);
        return view;
    }


}
