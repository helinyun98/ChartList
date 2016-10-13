package cn.dface.helinyun.chartlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.chartListView)
    RecyclerView chartListView;

    private LinearLayoutManager layoutManager;
    private ChartItemAdapter adapter;

    private ArrayList<ChartItemData> chartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            ChartItemData e = new ChartItemData(i * 20, random.nextInt(100));
            chartList.add(e);
        }

        initChart();
    }

    private void initChart() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        adapter = new ChartItemAdapter(this, chartList);

        chartListView.setLayoutManager(layoutManager);
        chartListView.setAdapter(adapter);
    }

}
