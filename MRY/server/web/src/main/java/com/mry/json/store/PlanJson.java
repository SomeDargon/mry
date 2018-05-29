package com.mry.json.store;

/**
 * Created by kaik on 2017/12/15.
 */
public class PlanJson {

    //描述
    private String description;


    //
    private Long[] ids;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
