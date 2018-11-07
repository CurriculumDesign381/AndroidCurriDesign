package com.cqut.sample.demo_zhihu.ui.fragment.fourth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;


import com.cqut.sample.demo_zhihu.ui.fragment.third.ColleageFragment;




public class HomePageFragment extends SupportFragment {
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
            getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, new text1()).commit();
        }
        });
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_notice, container, false);

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View setting = getActivity().findViewById(R.id.notice_set);
        setting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), com.cqut.sample.demo_zhihu.ui.fragment.fourth.setting.class);

                startActivity(intent);
            }
        });

        View privateletter = getActivity().findViewById(R.id.LinearLayout_privateletter);
        privateletter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), com.cqut.sample.demo_zhihu.ui.fragment.fourth.privateletter.class);

                startActivity(intent);
            }
        });
        View invite = getActivity().findViewById(R.id.LinearLayout_invite);
        invite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), com.cqut.sample.demo_zhihu.ui.fragment.fourth.invite.class);
                startActivity(intent);
            }
        });
        View badge = getActivity().findViewById(R.id.LinearLayout_badge);
        badge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), com.cqut.sample.demo_zhihu.ui.fragment.fourth.badge.class);
                startActivity(intent);
            }
        });
    }

    }


