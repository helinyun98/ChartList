package cn.dface.helinyun.chartlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.chartListView)
    RecyclerView chartListView;

    private LinearLayoutManager layoutManager;
    private ChartItemAdapter adapter;

    private ArrayList<ChartItemData> chartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initChart();
    }

    private void initChart() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        chartList = new ArrayList<>();
        adapter = new ChartItemAdapter(this, chartList);

        chartListView.setLayoutManager(layoutManager);
        chartListView.setAdapter(adapter);
    }

}
