package com.mry.service.helper;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import com.mry.util.properties.CommonPropertiesUtil;

public class ChartHelper {

	static final String blackFont = CommonPropertiesUtil.getString("black.bold.font");
	static final String TREND_CHART = CommonPropertiesUtil.getString("trend.chart");
	static final String NO_DATA_CN = CommonPropertiesUtil.getString("no.data.chart");

	private int width = 800;
	private int height = 450;
	private String title;
	// private String subTitle;
	private HashMap<Integer,List<ChartBean>> valueMap;

	private Number defaultLow;
	private Number defaultHigh;
	private Date startDate;
	private Date endDate;
	private boolean needMarker;
	private Number currentLow;
	private Number currentHigh;
	private boolean hasDiffValue = true;
	private Number warnHigh;
	private Number warnLow;
	
	public Number getWarnHigh() {
		return warnHigh;
	}

	public void setWarnHigh(Number warnHigh) {
		this.warnHigh = warnHigh;
	}

	public Number getWarnLow() {
		return warnLow;
	}

	public void setWarnLow(Number warnLow) {
		this.warnLow = warnLow;
	}

	
	public boolean isHasDiffValue() {
		return hasDiffValue;
	}

	public void setHasDiffValue(boolean hasDiffValue) {
		this.hasDiffValue = hasDiffValue;
	}

	public Number getCurrentLow() {
		return currentLow;
	}

	public void setCurrentLow(Number currentLow) {
		this.currentLow = currentLow;
	}

	public Number getCurrentHigh() {
		return currentHigh;
	}

	public void setCurrentHigh(Number currentHigh) {
		this.currentHigh = currentHigh;
	}


	public ChartHelper(String title, HashMap<Integer,List<ChartBean>> beansWithType) {
		this.title = title;
		this.valueMap = beansWithType;
		// this.subTitle = getSubtitle();
	}

	public ChartHelper(String title, HashMap<Integer,List<ChartBean>> valueMap, Number defaultLow, Number defaultHigh, Number currentLow, Number currentHigh , Date start, Date end,
			boolean needMarker) {
		this(title, valueMap);
		this.defaultLow = defaultLow;
		this.defaultHigh = defaultHigh;
		this.startDate = start;
		this.endDate = end;
		this.needMarker = needMarker;
		this.currentHigh = currentHigh;
		this.currentLow = currentLow;
	}

	public ChartHelper(String title, HashMap<Integer,List<ChartBean>>  valueMap, Date start, Date end) {
		this(title, valueMap);
		this.startDate = start;
		this.endDate = end;
	}

//	public String getSubtitle() {
//		String start = DatetimeUtil.formatDate(values.get(0).getDate());
//		String end = DatetimeUtil.formatDate(values.get(values.size() - 1).getDate());
//		return start + " - " + end + " " + TREND_CHART;
//	}

	private boolean isNoData() {
		return valueMap == null || valueMap.isEmpty();
	}

	private JFreeChart createChart() {

		TimeSeriesCollection dataset = createSingleDataset();

		JFreeChart chart = ChartFactory.createTimeSeriesChart(this.title, "", "", dataset, false, false, false);

		// chart.removeLegend();
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		// xylineandshaperenderer.setBaseShapesVisible(true);
		xylineandshaperenderer.setSeriesShapesVisible(0, true);
		xylineandshaperenderer.setSeriesShape(0, new Ellipse2D.Float(-3.0f, -3.0f, 6.0f, 6.0f));
		xylineandshaperenderer.setSeriesPaint(0, Color.blue);
		xylineandshaperenderer.setSeriesPaint(1, Color.cyan);
		xylineandshaperenderer.setSeriesPaint(2, Color.pink);

		plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinePaint(Color.gray);
		plot.setRangeGridlinePaint(Color.gray);
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 15D));

		if (startDate != null && endDate != null) {
			DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
			domainAxis.setRange(startDate, endDate);
		}

		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		if (defaultLow != null && defaultHigh != null) {
			NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
			if (isNoData()) {
				
				yAxis.setRange(defaultLow.doubleValue(), defaultHigh.doubleValue());
			} else {
				if(hasDiffValue){
				
				yAxis.setRange(currentLow.doubleValue(), currentHigh.doubleValue());
				}
				if (needMarker) {
					IntervalMarker interNormal = new IntervalMarker(warnLow==null? yAxis.getRange().getLowerBound():warnLow.doubleValue(), warnHigh==null?yAxis.getRange().getUpperBound():warnHigh.doubleValue());
					interNormal.setLabelOffsetType(LengthAdjustmentType.EXPAND);
					interNormal.setPaint(Color.green);
					interNormal.setAlpha(0.1F);
//					interNormal.setLabelFont(new Font("SansSerif", 41, 14));
//					interNormal.setLabelPaint(Color.BLACK);
//					interNormal.setLabel("正常范围");
					if(warnHigh!=null){
					IntervalMarker interHigh = new IntervalMarker(warnHigh.doubleValue(), yAxis.getRange().getUpperBound());
					interHigh.setLabelOffsetType(LengthAdjustmentType.EXPAND);
					interHigh.setPaint(Color.red);
					interHigh.setAlpha(0.1F);
					plot.addRangeMarker(interHigh);
					}
					if(warnLow!=null){
					IntervalMarker interLow = new IntervalMarker(yAxis.getRange().getLowerBound(), warnLow.doubleValue());
					interLow.setLabelOffsetType(LengthAdjustmentType.EXPAND);
					interLow.setPaint(Color.red);
					interLow.setAlpha(0.1F);
					plot.addRangeMarker(interLow);
					}
					
					plot.addRangeMarker(interNormal);
					
					
				}
			}
		}

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MM-dd"));

		// chart.addSubtitle(new TextTitle(this.subTitle, new Font(blackFont,
		// Font.BOLD, 12)));
		// chart.setTitle(new TextTitle(this.title, new Font(blackFont,
		// Font.BOLD,
		// 15)));
		chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
		chart.setAntiAlias(true);

		return chart;
	}

	private TimeSeriesCollection createSingleDataset() {
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		valueMap.forEach((type, values)->{
			TimeSeries series = new TimeSeries("");
						for (ChartBean p : values) {
				// series.add(new Day(p.getDate()), p.getValue());
				//p.get
				series.addOrUpdate(new Second(p.getDate()), p.getValue());
			}
			lineDataset.addSeries(series);
		});
		
		return lineDataset;
	}

	public void saveAsFile(String outputPath) {
		JFreeChart chart = createChart();
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);
			ChartUtilities.writeChartAsPNG(out, chart, width, height);
			// ChartUtilities.writeChartAsJPEG(out, chart, width, height);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException ignoreException) {

				}
			}
		}
	}

	public void output(OutputStream output) {
		JFreeChart chart = createChart();
		try {
			ChartUtilities.writeChartAsPNG(output, chart, width, height);
			// ChartUtilities.writeChartAsJPEG(out, chart, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// public String getFilename() {
	// return title + "-" + subTitle + ".png";
	// }

	public static void main(String[] args) {

		List<ChartBean> values = new ArrayList<ChartBean>();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -3);
		Date start = cal.getTime();

		int rate = 50;
		Date now = new Date();
		for (int i = 0; i < 100; i++) {
			cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, 1);

			now = cal.getTime();

			if (i % 3 == 0) {
				continue;
			}
			values.add(new ChartBean(now, now, rate++));
			if (rate > 70) {
				rate = 50;
			}
		}

		values = new ArrayList<ChartBean>();

		rate = 50;
		now = new Date();
		for (int i = 0; i < 20; i++) {
			cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, 1);

			now = cal.getTime();

			if (i % 3 == 0) {
				continue;
			}
			values.add(new ChartBean(now, now, (rate++) * 1.5));
			if (rate > 70) {
				rate = 50;
			}
		}

		cal.add(Calendar.DAY_OF_MONTH, 3);
		Date end = cal.getTime();

		//ChartHelper util = new ChartHelper("Heart Rate", values, 75, 85, 80, 90 ,start, end, false);

		//util.saveAsFile("D:\\jfreechart\\lineXY.png");
		System.out.println("OK");
	}

}
