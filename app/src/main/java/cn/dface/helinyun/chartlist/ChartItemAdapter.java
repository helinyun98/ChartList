package cn.dface.helinyun.chartlist;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

public class ChartItemAdapter extends RecyclerView.Adapter<ChartItemViewHolder> {

    private WeakReference<Activity> activityWeakReference;
    private List<ChartItemData> chartList;

    public ChartItemAdapter(Activity activity, List<ChartItemData> chartList) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.chartList = chartList;
    }

    public Activity getActivity() {
        return activityWeakReference.get();
    }

    @Override
    public int getItemCount() {
        return chartList.size() - 1;
    }

    @Override
    public ChartItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChartItemViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(ChartItemViewHolder holder, int position) {
        ChartItemData pre = chartList.get(position);
        ChartItemData next = chartList.get(position + 1);
        holder.update(pre, next);
    }

}
