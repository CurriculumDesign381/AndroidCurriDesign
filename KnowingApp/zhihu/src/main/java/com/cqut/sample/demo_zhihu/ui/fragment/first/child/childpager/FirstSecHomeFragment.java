package com.cqut.sample.demo_zhihu.ui.fragment.first.child.childpager;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cqut.eventbusactivityscope.EventBusActivityScope;
import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.MainActivity;
import com.cqut.sample.demo_zhihu.adapter.FirstHomeAdapter;
import com.cqut.sample.demo_zhihu.entity.Article;
import com.cqut.sample.demo_zhihu.event.TabSelectedEvent;
import com.cqut.sample.demo_zhihu.helper.DetailTransition;
import com.cqut.sample.demo_zhihu.listener.OnItemClickListener;
import com.cqut.sample.demo_zhihu.ui.fragment.second.child.SecondDetailFragment;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 2018/11/1.
 */

public class FirstSecHomeFragment extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView mRecy;
    private SwipeRefreshLayout mRefreshLayout;
    private FloatingActionButton mFab;

    private FirstHomeAdapter mAdapter;

    private boolean mInAtTop = true;
    private int mScrollTotal;

    private String[] mTitles = new String[]{
            "日出而作，日入而息。" +
                    "凿井而饮，耕田而食。" +
                    "帝力于我何有哉！",
            "燕丹善养士，志在报强嬴。" +
                    "招集百夫良，岁暮得荆卿。",
            "种豆南山下，草盛豆苗稀。" +
                    "晨兴理荒秽，带月荷锄归。",
            "花光浓烂柳轻明，酌酒花前送我行" +
                    "我亦且如常日醉，莫教弦管作离声。",
            "洒洒沾巾雨，披披侧帽风。花燃山色里，柳卧水声中。"
    };

    private int[] mImgRes = new int[]{
            R.drawable.bg_first, R.drawable.bg_second, R.drawable.bg_third, R.drawable.bg_fourth, R.drawable.bg_fifth
    };


    public static FirstSecHomeFragment newInstance() {
        Bundle args = new Bundle();
        FirstSecHomeFragment fragment = new FirstSecHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondsec_page, container, false);
        EventBusActivityScope.getDefault(_mActivity).register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mRecy = (RecyclerView) view.findViewById(R.id.recy);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);



        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);

        mAdapter = new FirstHomeAdapter(_mActivity);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                SecondDetailFragment fragment = SecondDetailFragment.newInstance(mAdapter.getItem(position));

                // 这里是使用SharedElement的用例
                // LOLLIPOP(5.0)系统的 SharedElement支持有 系统BUG， 这里判断大于 > LOLLIPOP
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    setExitTransition(new Fade());
                    fragment.setEnterTransition(new Fade());
                    fragment.setSharedElementReturnTransition(new DetailTransition());
                    fragment.setSharedElementEnterTransition(new DetailTransition());

                    // 25.1.0以下的support包,Material过渡动画只有在进栈时有,返回时没有;
                    // 25.1.0+的support包，SharedElement正常
                    extraTransaction()
                            .addSharedElement(((FirstHomeAdapter.VH) vh).img, getString(R.string.image_transition))
                            .addSharedElement(((FirstHomeAdapter.VH) vh).tvTitle, "tv")
                            .start(fragment);
                } else {
                    start(fragment);
                }
            }
        });

        // Init Datas
        List<Article> articleList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int index = i % 5;
            Article article = new Article(mTitles[index], mImgRes[index]);
            articleList.add(article);
        }
        mAdapter.setDatas(articleList);

        mRecy.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollTotal += dy;
                if (mScrollTotal <= 0) {
                    mInAtTop = true;
                } else {
                    mInAtTop = false;
                }
                if (dy > 5) {
                    mFab.hide();
                } else if (dy < -5) {
                    mFab.show();
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(_mActivity, "Action", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    private void scrollToTop() {
        mRecy.smoothScrollToPosition(0);
    }

    /**
     * 选择tab事件
     */
    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event) {
        if (event.position != MainActivity.FIRST) return;

        if (mInAtTop) {
            mRefreshLayout.setRefreshing(true);
            onRefresh();
        } else {
            scrollToTop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusActivityScope.getDefault(_mActivity).unregister(this);
    }
}
