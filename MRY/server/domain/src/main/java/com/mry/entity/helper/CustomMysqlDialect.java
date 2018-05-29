package com.mry.entity.helper;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StringType;


public class CustomMysqlDialect extends MySQL5InnoDBDialect {
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}

	public CustomMysqlDialect(){
		super();
		registerFunction("convert_gbk", new SQLFunctionTemplate(StringType.INSTANCE, "convert(?1 using GBK)") );
	}
}
