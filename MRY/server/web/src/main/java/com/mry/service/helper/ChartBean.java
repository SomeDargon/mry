package com.mry.service.helper;

import java.util.Date;

public class ChartBean implements Comparable<ChartBean> {
	private Date date;
	private Date checkTime;
	private Number value;

	public ChartBean() {
	}

	public ChartBean(Date date, Date checkTime, Number value) {
		this.date = date;
		this.checkTime = checkTime;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Override
	public String toString() {
		return "ChartBean [date=" + date + ", checkTime=" + checkTime + ", value=" + value + "]";
	}

	@Override
	public int compareTo(ChartBean o) {
		return date.compareTo(o.date);
	}
}
