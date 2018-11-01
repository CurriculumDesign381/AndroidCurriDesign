package com.cqut.sample.demo_zhihu.ui.fragment.fifth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cqut.fragmentation.SupportFragment;
import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.adapter.FruitAdapter;
import com.cqut.sample.demo_zhihu.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fei on 2018/10/25.
 */

public class PersonalHomeFragment extends SupportFragment {
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
        View view = inflater.inflate(R.layout.person_page, container, false);
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
}
