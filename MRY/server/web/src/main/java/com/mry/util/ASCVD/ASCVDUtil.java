package com.mry.util.ASCVD;

/**
 * Created by zyh on 2016/12/14.
 */
public class ASCVDUtil {
        //性别
        private String gender;

        //年龄
        private int age;

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

        public void setTotalCholesterol(double totalCholesterol) {
            this.totalCholesterol = totalCholesterol;
        }

        public void setHdlCholesterol(double hdlCholesterol) {
            this.hdlCholesterol = hdlCholesterol;
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

        public int ASCDMark(){
            int allOptimalCholesterol=0;
            int notOptimalCholesterol=0;
            int elevatedCholesterol=0;
            int MajorCholesterol=0;
            int Major2=0;
            int MajorSBP1=0;
            int MajortreatedOrNot=0;
            int allOptimalSBP=0;
            int notOptimalSBP=0;
            int elevatedSBP=0;
            int MajorSBP2=MajortreatedOrNot+MajorSBP1;
            int Majordiabete=0;
            int MajorSmoking=0;
            int Majordiabetes=0;
            //---------------------------------------------------总胆固醇风险值
            if(this.totalCholesterol<4.66)allOptimalCholesterol=1;
            else if(this.totalCholesterol>=4.66&&this.totalCholesterol<5.18)notOptimalCholesterol=1;
            else if(this.totalCholesterol>=5.18&&this.totalCholesterol<6.21)elevatedCholesterol=1;
            else if(this.totalCholesterol>=6.21)MajorCholesterol=1;
         //-----------------------------------------------------高风险血压评估
            if(this.systolicBloodPressure>=160)MajorSBP1=1;
          //-----------------------------------------------------是否有高血压打分
            if(this.treatmentForHypertension.equals("Y"))MajortreatedOrNot=1;
          //-------------------------------------------------------各项SBP打分
            if(this.systolicBloodPressure<120&&this.treatmentForHypertension.equals("N"))allOptimalSBP=1;
            else if(this.systolicBloodPressure>=120&&this.systolicBloodPressure<140&&this.treatmentForHypertension.equals("N"))notOptimalCholesterol=1;
            else if(this.systolicBloodPressure>=140&&this.systolicBloodPressure<160&&this.treatmentForHypertension.equals("N"))elevatedCholesterol=1;
           //--------------------------------------------------------是否抽烟，是否有糖尿病打分
            if(this.smoker.equals("Y"))MajorSmoking=1;
            else if(this.diabetes.equals("Y"))Majordiabete=1;
            //--------------------------------------------------------最后没想风险总分
            int allOptimalSum=allOptimalCholesterol+allOptimalSBP;
            int notOptimalSum=notOptimalCholesterol+notOptimalSBP;
            int elevatedSum=elevatedCholesterol+elevatedSBP;
            int sumOfMajor=MajorCholesterol+MajorSBP1+MajortreatedOrNot+MajorSBP2+MajorSmoking+Majordiabete;
            //-------------------------------------------------------最后得分
            if(allOptimalSum==2&&sumOfMajor==0)return this.gender.equals("F")?8:5;
            else if(notOptimalSum>=1&&elevatedSum==0&&sumOfMajor==0)return this.gender.equals("F")?27:36;
            else if(elevatedSum>=1&&sumOfMajor==0)return this.gender.equals("F")?39:46;
            else if(sumOfMajor==1)return this.gender.equals("F")?39:50;
            else if(sumOfMajor>=2)return this.gender.equals("F")?50:69;

             return this.gender.equals("F")?8:5;
        }

}
