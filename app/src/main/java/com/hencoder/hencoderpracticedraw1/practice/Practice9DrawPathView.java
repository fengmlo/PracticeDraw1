package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public Practice9DrawPathView(Context context) {
		super(context);
	}

	public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		Path path = new Path();
		path.addArc(centerX - 100, centerY - 100, centerX, centerY, 135, 225);
		path.arcTo(centerX, centerY - 100, centerX + 100, centerY, 180, 225, false);
		path.lineTo(centerX, centerY + 80);
		path.close();

		canvas.drawPath(path, paint);
	}
}
