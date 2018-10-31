package com.cqut.sample.demo_zhihu.ui.fragment.third;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;



public class ColleageFragment extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
     String TextContent ="Colleage";
    private String mTitle;

    public static ColleageFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_TYPE, title);
        ColleageFragment fragment = new ColleageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTitle = getArguments().getString("ddd");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homecolleage, container, false);
//        initView(view);
        return view;
    }

    private void initView(View view) {
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
        tvTitle.setText(mTitle);
    }


}
