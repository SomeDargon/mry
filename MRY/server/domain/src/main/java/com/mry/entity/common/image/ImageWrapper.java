package com.mry.entity.common.image;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 图片库表
 */
@Entity
@Table(name = ImageWrapper.TABLE_NAME)
public class ImageWrapper extends BaseEntity {
	private static final long serialVersionUID = -8642982935221071141L;

	public static final String TABLE_NAME = "image_wrapper";

	@Column(name = "last_update_time")
	private Date lastUpdateTime;

	@OneToMany(mappedBy = "wrapper", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Image> images;

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public List<Image> getImages() {
		if (images == null) {
			images = new ArrayList<Image>();
		}
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
