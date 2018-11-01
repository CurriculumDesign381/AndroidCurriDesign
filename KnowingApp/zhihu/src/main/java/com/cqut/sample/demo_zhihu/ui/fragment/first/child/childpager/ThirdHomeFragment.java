package com.cqut.sample.demo_zhihu.ui.fragment.first.child.childpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.eventbusactivityscope.EventBusActivityScope;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by fei on 2018/11/1.
 */

public class ThirdHomeFragment extends SupportFragment {


    public static ThirdHomeFragment newInstance() {
        Bundle args = new Bundle();
        ThirdHomeFragment fragment = new ThirdHomeFragment();
        fragment.setArguments(args);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_video, container, false);
        /*EventBusActivityScope.getDefault(_mActivity).register(this);*/

        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) view.findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");

        //picass 图片加载框架
        Picasso.with(this.getContext())
                .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(jzVideoPlayerStandard.thumbImageView);

        JZVideoPlayerStandard jzVideoPlayerStandard1 = (JZVideoPlayerStandard) view.findViewById(R.id.videoplayer1);
        jzVideoPlayerStandard1.setUp("http://2449.vod.myqcloud.com/2449_ded7b566b37911e5942f0b208e48548d.f20.mp4"
                , jzVideoPlayerStandard1.SCREEN_WINDOW_NORMAL, "");

        //picass 图片加载框架
        Picasso.with(this.getContext())
                .load("http://p.qpic.cn/videoyun/0/2449_ded7b566b37911e5942f0b208e48548d_2/640")
                .into(jzVideoPlayerStandard1.thumbImageView);


        JZVideoPlayerStandard jzVideoPlayerStandard2 = (JZVideoPlayerStandard) view.findViewById(R.id.videoplayer2);
        jzVideoPlayerStandard2.setUp("http://121.40.64.47/resource/mp3/music_yangguang3.mp3"
                , jzVideoPlayerStandard2.SCREEN_WINDOW_NORMAL, "");

        //picass 图片加载框架
        Picasso.with(this.getContext())
                .load("http://p.qpic.cn/videoyun/0/2449_38e65894d9e211e5b0e0a3699ca1d490_1/640")
                .into(jzVideoPlayerStandard2.thumbImageView);
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
