package com.bw.movie.weidumovie.bean;

import java.util.List;

/**
 * 作者：温浩
 * 时间：2018/12/7
 */
public class CommentBean {

    /**
     * result : [{"commentContent":"高佳宝是智障","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-07/20181207143536.png","commentId":716,"commentTime":1544164510000,"commentUserId":1437,"commentUserName":"马富燕","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"高佳宝是智障","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-07/20181207143536.png","commentId":715,"commentTime":1544164507000,"commentUserId":1437,"commentUserName":"马富燕","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"高佳宝是智障","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-07/20181207143536.png","commentId":714,"commentTime":1544164492000,"commentUserId":1437,"commentUserName":"马富燕","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"阿萨","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-06/20181206105413.png","commentId":695,"commentTime":1543996618000,"commentUserId":1459,"commentUserName":"小妮","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"哈哈哈哈哈","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-06/20181206105413.png","commentId":687,"commentTime":1543992913000,"commentUserId":1459,"commentUserName":"小妮","greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"如果个人","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-12-06/20181206105413.png","commentId":685,"commentTime":1543990356000,"commentUserId":1459,"commentUserName":"小妮","greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : 高佳宝是智障
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2018-12-07/20181207143536.png
         * commentId : 716
         * commentTime : 1544164510000
         * commentUserId : 1437
         * commentUserName : 马富燕
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }
    }
}
