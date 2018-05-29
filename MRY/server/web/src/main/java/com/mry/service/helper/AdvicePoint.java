package com.mry.service.helper;


public class AdvicePoint {
	private int coin;
	private int flowers;
	private int star;
	
	
	public AdvicePoint() {
	}

	public AdvicePoint(int coin, int flowers, int star) {
		this.coin = coin;
		this.flowers = flowers;
		this.star = star;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getFlowers() {
		return flowers;
	}

	public void setFlowers(int flowers) {
		this.flowers = flowers;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
