package com.mry.entity.common.image;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 具体图片表
 */
@Entity
@Table(name = Image.TABLE_NAME)
public class Image extends BaseEntity {
	private static final long serialVersionUID = -4988902088243910222L;

	public static final String TABLE_NAME = "image";

	@Column(name = "name")
	private String name;

	@Column(name = "normal_url")
	private String normalUrl;

	@Column(name = "original_url")
	private String originalUrl;

	@Column(name = "thumbnail_url")
	private String thumbnailUrl;

	@Column(name = "add_time")
	private Date addTime;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "wrapper_id")
	private ImageWrapper wrapper;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNormalUrl() {
		return normalUrl;
	}

	public void setNormalUrl(String normalUrl) {
		this.normalUrl = normalUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public ImageWrapper getWrapper() {
		return wrapper;
	}

	public void setWrapper(ImageWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
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
