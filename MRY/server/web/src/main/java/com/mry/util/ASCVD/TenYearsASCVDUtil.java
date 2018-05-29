package com.mry.util.ASCVD;

/**
 * Created by zyh on 2016/12/14.
 */
public class TenYearsASCVDUtil {
    //性别
    private String gender;

    //年龄
    private int age;

    private String race="WH";

    //总胆固醇
    private double totalCholesterol;

    //高密度脂蛋白-胆固醇
    private double hdlCholesterol;

    //收缩压
    private int systolicBloodPressure;

    //是否高血压
    private String treatmentForHypertension="Y";

    //糖尿病
    private String diabetes="N";

    //是否吸烟;
    private String smoker="N";

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setTotalCholesterol(double totalCholesterol) {
        if(totalCholesterol*38.7>320.000){
            this.totalCholesterol=totalCholesterol=320;
        }else if(totalCholesterol*38.7<130.000){
            this.totalCholesterol=totalCholesterol=130;
        }else {
            this.totalCholesterol = totalCholesterol * 38.7;
        }
    }

    public void setHdlCholesterol(double hdlCholesterol) {
        if(hdlCholesterol*38.7>100.000) {
            this.hdlCholesterol = 100;
        }else if(hdlCholesterol*38.7<20.000){
            this.hdlCholesterol = 20;
        }else{
            this.hdlCholesterol = hdlCholesterol * 38.7;
        }

    }

    public void setSystolicBloodPressure(int systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public void setTreatmentForHypertension(String treatmentForHypertension) {
        this.treatmentForHypertension = treatmentForHypertension;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public Double TenYearsASCVD(){
        int treatmentForHypertension1=0;
        int treatmentForHypertension2=1;
        int smocke=0;
        int diabetes=0;
        if(this.treatmentForHypertension.equals("Y")){treatmentForHypertension1=1;}
        if(this.treatmentForHypertension.equals("Y")){treatmentForHypertension2=0;}
        Double B16=Math.log(age);
        Double B17=Math.log(totalCholesterol);
        Double B18=Math.log(hdlCholesterol);
        Double B19=Math.log(systolicBloodPressure)*treatmentForHypertension1;
        Double B20=Math.log(systolicBloodPressure)*treatmentForHypertension2;
        Double B21=B16*B16;
        Double B22=B16*B17;
        Double B23=B16*B18;
        Double B24=B16*B19;
        Double B25=B16*B20;
        if(this.smoker.equals("Y")){smocke=1;}
        Double B26=B16*smocke;
        if(this.diabetes.equals("Y")){diabetes=1;}
        Double B27=B16*diabetes;
    //----------------------------------------------------------------------------------------算出预测值
        Double predict1=17.1141*B16+0.9396*B17+(-18.9196*B18)+4.4748*B23+29.2907*B19+(-6.4321*B24)+27.8197*B20+(-6.0873*B25)+0.6908*smocke+0.8738*diabetes;
        Double predict2=(-29.799*B16)+4.884*B21+13.54*B17+(-3.114*B22)+(-13.578*B18)+3.149*B23+2.019*B19+1.957*B20+7.574*smocke+(-1.665*B26)+0.661*diabetes;
        Double predict3=2.469*B16+0.302*B17+(-0.307*B18)+1.916*B19+1.809*B20+0.549*smocke+0.645*diabetes;
        Double predict4=12.344*B16+11.853*B17+(-2.664*B22)+(-7.99*B18)+1.769*B23+1.797*B19+1.764*B20+7.837*smocke+(-1.795*B26)+0.658*diabetes;
      //------------------------------------------------------------------------------------------------------------
        Double cvdPredict1=1-Math.pow(0.95334,Math.exp(predict1-86.6081));
        Double cvdPredict2=1-Math.pow(0.96652,Math.exp(predict2-(-29.1817)));
        Double cvdPredict3=1-Math.pow(0.89536,Math.exp(predict3-19.5425));
        Double cvdPredict4=1-Math.pow(0.91436,Math.exp(predict4-61.1816));
      //-----------------------------------------------------------------------------------
        int F29=0;
        if (this.gender.equals("F")&&this.race.equals("AA")) F29=1;
        int F30=0;
        if (this.gender.equals("F")&&this.race.equals("WH")) F30=1;
        int F31=0;
        if (this.gender.equals("M")&&this.race.equals("AA")) F31=1;
        int F32=0;
        if (this.gender.equals("M")&&this.race.equals("WH")) F32=1;
        Double sum=(cvdPredict1*F29+cvdPredict2*F30+cvdPredict3*F31+cvdPredict4*F32)*100;
        return sum;
    }

//    public static  void main(String[] ages){
//        TenYearsASCVDUtil a=new TenYearsASCVDUtil();
//        a.setGender("F");
//        a.setAge(40);
//        a.setTotalCholesterol(3.36);
//        a.setHdlCholesterol(0.64);
//        a.setSystolicBloodPressure(100);
//        a.setTreatmentForHypertension("N");
//        a.setDiabetes("N");
//        a.setSmoker("N");
//        double res=a.TenYearsASCVD();
//        System.out.println(res+"%");
//    }
}
