package com.cqut.sample.demo_zhihu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cqut.sample.demo_zhihu.ui.fragment.first.child.childpager.FirstHomePageFragment;
import com.cqut.sample.demo_zhihu.ui.fragment.first.child.childpager.OtherPagerFragment;

//为fragment添加数据
public class ZhihuPagerFragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles;

    public ZhihuPagerFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }
//创建一个Fragment实例
    @Override
    public Fragment getItem(int position) {
       if (position == 0) {
            return FirstHomePageFragment.newInstance();
        } else {
            return OtherPagerFragment.newInstance(mTitles[position]);
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
