package com.bawei.costomimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * 作    者：高学军
 * 时    间：16/12/20
 * 描    述：
 * 修改时间：
 */
public class RoundImage extends ImageView{


    //申明画笔
    Paint paint;

    public RoundImage(Context context) {
        super(context);
        //开启硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public RoundImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public RoundImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        CircleImage(canvas);
    }


    //绘制圆
    public void CircleImage(Canvas canvas){



        //实例化画笔
        paint = new Paint();
        //设置颜色
        paint.setColor(Color.WHITE);



        //获取宽度和高度
        int w = getWidth();


        //获取drawable
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        //获取 bitmap
        Bitmap bitmap = bitmapDrawable.getBitmap();

        if(bitmap.getWidth() != w || bitmap.getHeight() != w){
            bitmap = Bitmap.createScaledBitmap(bitmap,w,w,false);
        }




        //实例化 rect
        Rect rect = new Rect(0,0,getWidth(),getHeight());
//        canvas.drawRect(rect,paint);
        Log.d("bitmap",bitmap.getHeight()+"=="+bitmap.getWidth());



        //绘制圆
        canvas.drawCircle(w/2,w/2,w/2,paint);
        //设置取两个圆交汇处
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap,rect,rect,paint);




    }


}
