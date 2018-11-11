package io.navendra.dreamgl.views.camera2video;

import android.content.Context;
import android.graphics.*;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

class CustomView extends SurfaceView {

    private final Paint paint;
    private final SurfaceHolder mHolder;
    private final Context context;

    public CustomView(Camera2VideoFragment context) {
        super(context.getActivity().getBaseContext());
        mHolder = getHolder();
        mHolder.setFormat(PixelFormat.TRANSPARENT);
        this.context = context.getActivity().getBaseContext();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            invalidate();
            if (mHolder.getSurface().isValid()) {
                final Canvas canvas = mHolder.lockCanvas();
                Log.d("touch", "touchRecieved by camera");
                if (canvas != null) {
                    Log.d("touch", "touchRecieved CANVAS STILL Not Null");
                    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
                    canvas.drawColor(Color.TRANSPARENT);
                    canvas.drawCircle(event.getX(), event.getY(), 100, paint);
                    mHolder.unlockCanvasAndPost(canvas);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Canvas canvas1 = mHolder.lockCanvas();
                            if(canvas1 !=null){
                                canvas1.drawColor(0, PorterDuff.Mode.CLEAR);
                                mHolder.unlockCanvasAndPost(canvas1);
                            }

                        }
                    }, 1000);

                }
                mHolder.unlockCanvasAndPost(canvas);


            }
        }


        return false;
    }
}
