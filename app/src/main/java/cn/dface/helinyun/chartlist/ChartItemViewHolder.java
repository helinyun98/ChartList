package cn.dface.helinyun.chartlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public class ChartItemViewHolder extends RecyclerView.ViewHolder {

    public static ChartItemViewHolder create(ViewGroup parent) {
        return new ChartItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
    }

    private ChartItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void update(ChartItemData pre, ChartItemData next) {

    }
}
