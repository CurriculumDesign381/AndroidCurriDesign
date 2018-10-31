package com.cqut.sample.demo_zhihu.ui.fragment.fifth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.ui.fragment.third.ColleageFragment;

/**
 * Created by fei on 2018/10/25.
 */

public class PersonalHomeFragment extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    public static ColleageFragment newInstance() {

        Bundle args = new Bundle();
    /*    args.putString(ARG_TYPE, title);*/
        ColleageFragment fragment = new ColleageFragment();
        /*fragment.setArguments(args);*/
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wo, container, false);
        return view;
    }
}
