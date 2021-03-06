package cn.dface.helinyun.chartlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

public class ChartItemView extends View {

    private PointF pointPre = new PointF(0.0f, 0.0f);
    private PointF pointNext = new PointF(0.0f, 0.0f);

    private int width;
    private int height;
    private float maxY;

    private Path path;
    private Paint paint;

    public ChartItemView(Context context) {
        this(context, null);
    }

    public ChartItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ChartItemView);

            try {
                maxY = attributes.getFloat(R.styleable.ChartItemView_maxY, 0f);
            } finally {
                attributes.recycle();
            }
        }

        path = new Path();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
    }

    public void updateData(PointF pointPre, PointF pointNext) {
        this.pointPre = pointPre;
        this.pointNext = pointNext;
        this.invalidate();
    }

    public float getMaxY() {
        return maxY;
    }

    public void setMaxY(float maxY) {
        this.maxY = maxY;
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
        path.reset();
        path.moveTo(0, height);
        float y1 = height - pointPre.y / maxY * height;
        path.lineTo(0, y1);
        float y2 = height - pointNext.y / maxY * height;
        path.lineTo(width, y2);
        path.lineTo(width, height);
        path.close();
        canvas.drawPath(path, paint);
    }

}
