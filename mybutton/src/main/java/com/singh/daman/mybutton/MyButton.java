package com.singh.daman.mybutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import com.singh.daman.mybutton.R;

public class MyButton extends ImageView {

    public static final int BUTTON_CIRCLE = 0;
    public static final int BUTTON_RECT = 1;
    public static final int ROUND_RECT = 2;
    public static final int STAR = 3;

    private String text;
    private float ValueX;
    private float ValueY;
    private int roundness = 5;
    private int type;
    private int strokewidth = 5;
    private int textsize;

    private Paint circlePaint;
    private Paint strokePaint;
    private Paint textPaint;

    private float CircleRadius;

    public MyButton(Context context) {
        super(context);
        init(context, null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int height = bounds.bottom + bounds.height();
        float length = textPaint.measureText(text);
        switch (type){
            case BUTTON_CIRCLE:
                canvas.drawCircle(ValueX/2, ValueY/2, CircleRadius/2, strokePaint);
                canvas.drawCircle(ValueX/2, ValueY/2, CircleRadius/2, circlePaint);
                canvas.drawText(text, ValueX/2 - length/2, ValueY/2 + height/2, textPaint);
                break;
            case BUTTON_RECT:
                canvas.drawRect(0, 0, ValueX, ValueY, circlePaint );
                canvas.drawRect(0, 0, ValueX, ValueY, strokePaint );
                canvas.drawText(text, ValueX/2 - length/2, ValueY/2 + height/2, textPaint);
                break;
            case ROUND_RECT:
                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    canvas.drawRoundRect(0, 0, ValueX, ValueY, roundness, roundness, circlePaint);
                    canvas.drawRoundRect(0, 0, ValueX, ValueY, roundness, roundness, strokePaint);
                    canvas.drawText(text, ValueX/2 - length/2, ValueY/2 + height/2, textPaint);
                    break;
                }
                else {
                    canvas.drawRect(0, 0, ValueX, ValueY, circlePaint);
                    canvas.drawRect(0, 0, ValueX, ValueY, strokePaint );
                    canvas.drawText(text, ValueX/2 - length/2, ValueY/2 + height/2, textPaint);
                    break;
                }
            case STAR:
                float mid = ValueX / 2;
                float min = Math.min(ValueX, ValueY);
                float half = min/2;
                mid = mid - half;
                circlePaint.setStyle(Paint.Style.FILL);
                Path path = new Path();
                // top left
                path.moveTo(mid + half * 0.5f, half * 0.84f);
                // top right
                path.lineTo(mid + half * 1.5f, half * 0.84f);
                // bottom left
                path.lineTo(mid + half * 0.68f, half * 1.45f);
                // top tip
                path.lineTo(mid + half * 1.0f, half * 0.5f);
                // bottom right
                path.lineTo(mid + half * 1.32f, half * 1.45f);
                // top left
                path.lineTo(mid + half * 0.5f, half * 0.84f);

                path.close();
                canvas.drawPath(path, strokePaint);
                canvas.drawPath(path, circlePaint);
                canvas.drawText(text, ValueX/2 - length/2, ValueY/2 + height/2, textPaint);
                break;
        }

        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ValueX = w;
        ValueY = h;
        CircleRadius = Math.min(w,h) - strokewidth;
    }

    public void setColor(int color, int strokecolor, int strokewidth, int roundness,
                         String text, int textsize, int textcolor) {
        this.roundness = roundness;
        this.text = text;
        this.textsize = textsize;
        circlePaint.setColor(color);
        strokePaint.setColor(strokecolor);
        strokePaint.setStrokeWidth(strokewidth);
        textPaint.setColor(textcolor);
        textPaint.setTextSize(textsize);
        this.invalidate();
    }

    private void init(Context context, AttributeSet attrs) {
        this.setFocusable(true);
        setClickable(true);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);

        strokePaint = new Paint(circlePaint);
        strokePaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint(circlePaint);
        textPaint.setStyle(Paint.Style.STROKE);

        int color = Color.BLACK;
        int strokecolor = Color.BLACK;
        int textcolor =Color.BLACK;
        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AmazingButtons);
            color = a.getColor(R.styleable.AmazingButtons_fill_color, color);
            strokecolor = a.getColor(R.styleable.AmazingButtons_stroke_color, strokecolor);
            strokewidth = (int)a.getDimension(R.styleable.AmazingButtons_stroke_width, strokewidth);
            roundness = (int)a.getDimension(R.styleable.AmazingButtons_stroke_width, roundness);
            text = a.getString(R.styleable.AmazingButtons_text);
            textsize = (int)a.getDimension(R.styleable.AmazingButtons_text_size, textsize);
            textcolor = a.getColor(R.styleable.AmazingButtons_text_color, textcolor);
            type = a.getInteger(R.styleable.AmazingButtons_button_type, BUTTON_CIRCLE);
            a.recycle();
        }
        setColor(color , strokecolor, strokewidth, roundness, text, textsize, textcolor);
    }
}