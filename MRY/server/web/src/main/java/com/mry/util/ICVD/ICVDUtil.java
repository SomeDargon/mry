package com.mry.util.ICVD;

/**
 * 评估缺血性心血管病（ICVD）10年发病危险
 *
 * @author vito
 * @version 1.0 2016/12/5
 */
public class ICVDUtil {
    /**
     * 性别（1.男，2.女）
     */
    private int gender;

    /**
     * 年龄
     */
    private int age;

    /**
     * 收缩压
     */
    private int sbp;

    /**
     * 身体质量指数
     */
    private double bmi;

    /**
     * 总胆固醇
     */
    private double chol;

    /**
     * 是否吸烟
     */
    private boolean smoke = false;

    /**
     * 是否糖尿病
     */
    private boolean diabetes = false;

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSbp(int sbp) {
        this.sbp = sbp;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setChol(double chol) {
        this.chol = chol;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public double score() {
        switch (this.gender) {
            case 1:
                return this.scoreByMale();
            case 2:
                return this.scoreByFemale();
            default:
                return 0;
        }
    }

    private double scoreByMale() {
        int point = pointByAge() + pointByBmi() + pointByChol() + malePointBySbp() + malePointBySmoking() + malePointByDiabetes();
        switch (point) {
            case -2:
            case -1:
                return 0.3;
            case 0:
                return 0.5;
            case 1:
                return 0.6;
            case 2:
                return 0.8;
            case 3:
                return 1.1;
            case 4:
                return 1.5;
            case 5:
                return 2.1;
            case 6:
                return 2.9;
            case 7:
                return 3.9;
            case 8:
                return 5.4;
            case 9:
                return 7.3;
            case 10:
                return 9.7;
            case 11:
                return 12.8;
            case 12:
                return 16.8;
            case 13:
                return 21.7;
            case 14:
                return 27.7;
            case 15:
                return 35.3;
            case 16:
                return 44.3;
            default:
                return 52.6;
        }
    }

    private double scoreByFemale() {
        int point = pointByAge() + pointByBmi() + pointByChol() + femalePointBySbp() + femalePointBySmoking() + femalePointByDiabetes();
        switch (point) {
            case -2:
                return 0.1;
            case -1:
                return 0.2;
            case 0:
                return 0.2;
            case 1:
                return 0.3;
            case 2:
                return 0.5;
            case 3:
                return 0.8;
            case 4:
                return 1.2;
            case 5:
                return 1.8;
            case 6:
                return 2.8;
            case 7:
                return 4.4;
            case 8:
                return 6.8;
            case 9:
                return 10.3;
            case 10:
                return 15.6;
            case 11:
                return 23.0;
            case 12:
                return 32.7;
            default:
                return 43.1;
        }
    }

    /**
     * 年龄分数
     *
     * @return 分数
     */
    private int pointByAge() {
        if (this.age <= 39) return 0;
        else if (this.age <= 44) return 1;
        else if (this.age <= 49) return 2;
        else if (this.age <= 54) return 3;
        else return 4;
    }

    /**
     * 男性收缩压分数
     *
     * @return 分数
     */
    private int malePointBySbp() {
        if (this.sbp <= 120) return -2;
        else if (this.sbp < 130) return 0;
        else if (this.sbp < 140) return 1;
        else if (this.sbp < 160) return 2;
        else if (this.sbp < 180) return 5;
        else return 8;
    }

    /**
     * 女性收缩压分数
     *
     * @return 分数
     */
    private int femalePointBySbp() {
        if (this.sbp <= 120) return -2;
        else if (this.sbp < 130) return 0;
        else if (this.sbp < 140) return 1;
        else if (this.sbp < 160) return 2;
        else if (this.sbp < 180) return 3;
        else return 4;
    }

    /**
     * 身体质量指数分数
     *
     * @return 分数
     */
    private int pointByBmi() {
        if (this.bmi < 24) return 0;
        else if (this.bmi < 28) return 1;
        else return 2;
    }

    /**
     * 总胆固醇分数
     *
     * @return 分数
     */
    private int pointByChol() {
        return this.chol < 5.2 ? 0 : 1;
    }

    /**
     * 男性吸烟分数
     *
     * @return 分数
     */
    private int malePointBySmoking() {
        return this.smoke ? 2 : 0;
    }

    /**
     * 女性吸烟分数
     *
     * @return 分数
     */
    private int femalePointBySmoking() {
        return this.smoke ? 1 : 0;
    }

    /**
     * 男性糖尿病分数
     *
     * @return 分数
     */
    private int malePointByDiabetes() {
        return this.diabetes ? 1 : 0;
    }

    /**
     * 女性糖尿病分数
     *
     * @return 分数
     */
    private int femalePointByDiabetes() {
        return this.diabetes ? 2 : 0;
    }
}
