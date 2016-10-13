package cn.dface.helinyun.chartlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

public class ChartItemView extends View {

    private PointF pointPre = new PointF(0.0f, 0.0f);
    private PointF pointNext = new PointF(0.0f, 0.0f);
    private int width;
    private int height;
    private float maxY;

    public ChartItemView(Context context) {
        this(context, null);
    }

    public ChartItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            //获取值
            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ChartItemView);
            try {
                float preX = attributes.getFloat(R.styleable.ChartItemView_preX, 0);
                float preY = attributes.getFloat(R.styleable.ChartItemView_preY, 0);
                float nextX = attributes.getFloat(R.styleable.ChartItemView_nextX, 0);
                float nextY = attributes.getFloat(R.styleable.ChartItemView_nextY, 0);
                maxY = attributes.getFloat(R.styleable.ChartItemView_maxY, 0f);
                pointPre = new PointF(preX, preY);
                pointNext = new PointF(nextX, nextY);
            } finally {
                attributes.recycle();
            }
        }

    }

    public void updateData(PointF pointPre, PointF pointNext) {
        this.pointPre = pointPre;
        this.pointNext = pointNext;
        this.invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
