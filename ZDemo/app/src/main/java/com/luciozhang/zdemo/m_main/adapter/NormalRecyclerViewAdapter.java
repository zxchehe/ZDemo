package com.luciozhang.zdemo.m_main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luciozhang.zdemo.R;
import com.luciozhang.zdemo.m_main.MainFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luciozhang on 2017/7/28.
 */

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> texts;

    public NormalRecyclerViewAdapter(Context context,List<String> texts) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.texts=texts;
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.mTextView.setText(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return texts == null ? 0 : texts.size();
    }

    public void setList(List<String> texts){
        this.texts=texts;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_view)
        TextView mTextView;

        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
