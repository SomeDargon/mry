package com.mry.json.store;

/**
 * Created by kaik on 2017/12/14.
 */
public class ProblemDescriptionJson {

    private Long id;

    //问题
    private String problem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public ProblemDescriptionJson(Long id, String problem) {
        this.id = id;
        this.problem = problem;
    }
}
