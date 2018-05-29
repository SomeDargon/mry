package com.mry.json;

import java.util.List;

public class ResultsWrapper<T> {
	private Long total;
	private List<T> results;
	private int pages;

	public ResultsWrapper() {
	}

	public ResultsWrapper(Long total, int pages, List<T> results) {
		this.total = total;
		this.pages = pages;
		this.results = results;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
