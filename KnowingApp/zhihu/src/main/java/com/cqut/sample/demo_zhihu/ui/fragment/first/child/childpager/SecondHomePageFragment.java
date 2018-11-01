package com.cqut.sample.demo_zhihu.ui.fragment.first.child.childpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.base.BaseMainFragment;
import com.cqut.sample.demo_zhihu.ui.fragment.second.child.SecondHomeFragment;

/**
 * Created by fei on 2018/10/31.
 */

public class SecondHomePageFragment  extends BaseMainFragment {
    public static SecondHomePageFragment newInstance() {
        Bundle args = new Bundle();
        SecondHomePageFragment fragment = new SecondHomePageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhihu_fragment_first, container, false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        if (findChildFragment(SecondHomeFragment.class) == null) {
            loadRootFragment(R.id.fl_first_container, FirstSecHomeFragment.newInstance());
        }
    }
}
