package com.android.zzh.androidexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzh.androidexample.R;

import java.util.List;

/**
 * Created by zzh on 16/2/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHodler> {

    private LayoutInflater mInflater;
    private Context mContext;
    protected List<String> mDatas;

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);

        void OnItenLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }


    public RecyclerViewAdapter(Context context, List<String> datas){
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_single_textview,parent,false);
        RecyclerViewViewHodler viewHolder = new RecyclerViewViewHodler(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewViewHodler holder,final int position) {
        holder.tv.setText(mDatas.get(position));
        setupItemEvent(holder);
    }

    public void setupItemEvent( final RecyclerViewViewHodler holder){
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.OnItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.OnItenLongClick(holder.itemView,pos);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    public class RecyclerViewViewHodler extends RecyclerView.ViewHolder
    {
        TextView tv;
        View itemView;
        public RecyclerViewViewHodler(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.textview_item);
            this.itemView = itemView;
        }
    }

    public void addData(int pos){
        mDatas.add(pos,"Add one");
        notifyItemInserted(pos);
    }

    public void deleteDate(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}


