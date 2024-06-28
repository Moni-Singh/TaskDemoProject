package com.example.taskdemo.ui.tab.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskdemo.databinding.ItemSlideImageBinding;
import com.example.taskdemo.databinding.ListItemBinding;
import com.google.android.material.snackbar.Snackbar;

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_VIEWPAGER = 0;
    private static final int TYPE_ITEM = 1;

    private String[] mValues;
    private Context mContext;

    public SimpleStringRecyclerViewAdapter(Context context, String[] items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_VIEWPAGER : TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_VIEWPAGER) {
            ItemSlideImageBinding binding = ItemSlideImageBinding.inflate(inflater, parent, false);
            return new ViewPagerViewHolder(binding);
        } else if (viewType == TYPE_ITEM) {
            ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
            return new ViewHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewPagerViewHolder) {

            String[] imageUrls = {mValues[2], mValues[3]};
            ((ViewPagerViewHolder) holder).binding.sliderImage.setImageResource(mContext.getResources().getIdentifier(imageUrls[0], "drawable", mContext.getPackageName()));

        } else if (holder instanceof ViewHolder) {
            String item = mValues[position - 1];
            ((ViewHolder) holder).binding.idTvItem.setText(item);
            ((ViewHolder) holder).binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, getValueAt(position - 1), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mValues.length + 1;
    }

    public String getValueAt(int position) {
        return mValues[position];
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ListItemBinding binding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        public final ItemSlideImageBinding binding;

        public ViewPagerViewHolder(ItemSlideImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
