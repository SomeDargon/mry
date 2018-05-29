package com.mry.entity.common;

import javax.persistence.*;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/8/16 15:33
 */
@Entity
@Table(name = DataDictionary.TABLE_NAME)
public class DataDictionary extends BaseEntity {
    private static final long serialVersionUID = 2260278476121987627L;
    public static final String TABLE_NAME = "data_dictionary";

    //字典文字
    private String text;

    //字典类型
    @Enumerated(EnumType.STRING)
    private DataDictionaryType type;

    //是否启用
    @Column(name = "is_active")
    private boolean isActive;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DataDictionaryType getType() {
        return type;
    }

    public void setType(DataDictionaryType type) {
        this.type = type;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
