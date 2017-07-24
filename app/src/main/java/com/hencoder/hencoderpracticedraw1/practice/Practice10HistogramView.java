package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

	Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private List<DataSet> dataSets = new ArrayList<>();
	private float spaceX;
	private float spaceY;
	private float startX;
	private float chartWidth;
	private float chartHeight;
	private float startY;
	private float chartSpace;
	private float chartSpaceBetween;
	private float chartItemWidth;
	private int textSize = 24;

	{
		dataSets.add(new DataSet("Froyo", 1));
		dataSets.add(new DataSet("GB", 5));
		dataSets.add(new DataSet("ICS", 5));
		dataSets.add(new DataSet("JB", 20));
		dataSets.add(new DataSet("KitKat", 40));
		dataSets.add(new DataSet("L", 45));
		dataSets.add(new DataSet("M", 20));
	}

	public Practice10HistogramView(Context context) {
		super(context);
	}

	public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}

	public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

		spaceX = getWidth() * 0.2f;
		spaceY = getHeight() * 0.2f;
		startX = spaceX / 2;
		startY = spaceY / 2;
		chartHeight = getHeight() - spaceY;
		chartWidth = getWidth() - spaceX;
		chartSpace = chartWidth * 0.2f;
		chartSpaceBetween = chartSpace / (dataSets.size() + 1);
		chartItemWidth = (chartWidth - chartSpace) / dataSets.size();

		paint.setColor(Color.WHITE);
		paint.setStrokeWidth(2);

		// 绘制横竖线
		canvas.drawLine(startX, startY, startX, startY + chartHeight, paint);
		canvas.drawLine(startX, startY + chartHeight, startX + chartWidth, startY + chartHeight, paint);

		// 绘制图表
		paint.setStrokeWidth(chartItemWidth);
		paint.setTextSize(textSize);
		for (int i = 0; i < dataSets.size(); i++) {
			DataSet dataSet = dataSets.get(i);

			float x = this.startX + (chartSpaceBetween + chartItemWidth) * i + (chartSpaceBetween + chartItemWidth / 2);

			// 绘制文字
			paint.setColor(Color.WHITE);
			canvas.drawText(dataSet.tittle, x, startY + chartHeight + textSize, paint);

			// 绘制柱状图
			paint.setColor(Color.GREEN);
			canvas.drawLine(x,
					startY + chartHeight - 1,
					x,
					startY + chartHeight * (1 - dataSet.number / 100)
					, paint);
		}
	}

	private class DataSet {
		String tittle;
		float number;

		public DataSet(String tittle, float number) {
			this.tittle = tittle;
			this.number = number;
		}
	}
}
