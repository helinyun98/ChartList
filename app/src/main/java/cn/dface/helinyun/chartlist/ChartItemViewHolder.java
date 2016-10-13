package cn.dface.helinyun.chartlist;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChartItemViewHolder extends RecyclerView.ViewHolder {

    @BindView (R.id.chartItem)
    ChartItemView chartItem;

    public static ChartItemViewHolder create(ViewGroup parent) {
        return new ChartItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
    }

    private ChartItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void update(ChartItemData pre, ChartItemData next) {
        PointF prePoint = pre.getPoint();
        PointF nextPoint = next.getPoint();
        chartItem.updateData(prePoint, nextPoint);
    }
}
