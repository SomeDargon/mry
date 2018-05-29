package com.mry.entity.store;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/12/28.
 * 门店与条目
 */
@Entity
@Table(name = StoreEntry.TABLE_NAME)
public class StoreEntry extends BaseEntity {

    public static final String TABLE_NAME = "store_entry";


}
