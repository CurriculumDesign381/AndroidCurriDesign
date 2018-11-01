package com.cqut.sample.demo_zhihu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cqut.sample.R;
import com.cqut.sample.demo_zhihu.entity.Fruit;

import java.util.List;

/**
 * ${DESC}
 * author: gyq
 * create at 2016/12/12 18:51
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        // View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView) {
            super(itemView);
            //fruitView = itemView;
            fruitImage = (ImageView)itemView.findViewById(R.id.iv_item_icon);
            fruitName = (TextView)itemView.findViewById(R.id.tv_item_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitInfo) {
        mFruitList = fruitInfo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


}
