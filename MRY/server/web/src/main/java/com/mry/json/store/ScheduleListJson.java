package com.mry.json.store;

import java.util.List;

/**
 * Created by kaik on 2017/11/22.
 */
public class ScheduleListJson {
    private Long id;

    private String name;

    private List<SchedulexxJson> json;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SchedulexxJson> getJson() {
        return json;
    }

    public void setJson(List<SchedulexxJson> json) {
        this.json = json;
    }
}
