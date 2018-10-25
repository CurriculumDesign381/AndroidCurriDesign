package com.cqut.sample.demo_zhihu.ui.fragment.fifth;

import android.os.Bundle;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.demo_zhihu.ui.fragment.third.ColleageFragment;

/**
 * Created by fei on 2018/10/25.
 */

public class NoticceFragment extends SupportFragment {
    private static final String ARG_TYPE = "arg_type";
    public static ColleageFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_TYPE, title);
        ColleageFragment fragment = new ColleageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
