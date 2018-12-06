package com.bw.movie.WeiDuMovie.bean;

import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/4
 */
public class MovieQueryFollowBean {
    /**
     * result : [{"fare":0,"id":1,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/wbsys/wbsys1.jpg","name":"我不是药神","releaseTime":1530720000000,"summary":"一位不速之客的意外到访，打破了神油店老板程勇（徐峥 饰）的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药\u201c格列宁\u201d的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以\u201c药神\u201d的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开......"},{"fare":0,"id":4,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/drjzsdtw/drjzsdtw1.jpg","name":"狄仁杰之四大天王","releaseTime":1566835200000,"summary":"狄仁杰(赵又廷 饰）大破神都龙王案，获御赐亢龙锏，并掌管大理寺，使他成为武则天（刘嘉玲 饰）走向权力之路最大的威胁。武则天为了消灭眼中钉，命令尉迟真金（冯绍峰 饰）集结实力强劲的\u201c异人组\u201d，妄图夺取亢龙锏。在医官沙陀忠（林更新 饰）的协助下，狄仁杰既要守护亢龙锏，又要破获神秘奇案，还要面对武则天的步步紧逼，大唐江山陷入了空前的危机之中\u2026\u2026"},{"fare":0,"id":12,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/fyz/fyz1.jpg","name":"风语咒","releaseTime":1536336000000,"summary":"生活在孝阳岗的少年郎明怀揣侠岚梦想，但双眼失明的他却只能靠招摇撞骗混于市井之中。直到有一天，罗刹袭击孝阳岗，与他相依为命的母亲突然失踪，郎明迫不得已踏上了找寻真相之路。一波未平一波又起，上古神兽饕餮现世让人间危在旦夕，传说中的侠岚们也出现在眼前，郎明也踏上了改变一生的冒险之旅\u2026\u2026"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * fare : 0
         * id : 1
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/wbsys/wbsys1.jpg
         * name : 我不是药神
         * releaseTime : 1530720000000
         * summary : 一位不速之客的意外到访，打破了神油店老板程勇（徐峥 饰）的平凡人生，他从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”的独家代理商。收获巨额利润的他，生活剧烈变化，被病患们冠以“药神”的称号。但是，一场关于救赎的拉锯战也在波涛暗涌中慢慢展开......
         */

        private int fare;
        private int id;
        private String imageUrl;
        private String name;
        private long releaseTime;
        private String summary;

        public int getFare() {
            return fare;
        }

        public void setFare(int fare) {
            this.fare = fare;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
