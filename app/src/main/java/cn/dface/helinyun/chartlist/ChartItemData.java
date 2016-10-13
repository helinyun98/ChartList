package cn.dface.helinyun.chartlist;

import android.graphics.PointF;

public class ChartItemData {

    private PointF point;

    public ChartItemData(float x, float y) {
        this.point = new PointF(x, y);
    }

    public PointF getPoint() {
        return point;
    }

    public void setPoint(PointF point) {
        this.point = point;
    }

    public void setPoint(int x, int y) {
        this.point = new PointF(x, y);
    }
}
