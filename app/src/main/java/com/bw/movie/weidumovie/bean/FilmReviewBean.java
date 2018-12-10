package com.bw.movie.weidumovie.bean;

import java.util.List;

/**
 * 作者:李自强
 * <p>
 * 2018/12/4
 **/
public class FilmReviewBean {

    /**
     * result : [{"commentContent":"又来","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg","commentId":1312,"commentTime":1543893828000,"commentUserId":1431,"commentUserName":"lidikun","greatNum":0,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"的师傅都是","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-11-30/20181130191303.png","commentId":1260,"commentTime":1543807842000,"commentUserId":1418,"commentUserName":"小黑","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":3},{"commentContent":"大萨达","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-11-30/20181130191303.png","commentId":1255,"commentTime":1543798310000,"commentUserId":1418,"commentUserName":"小黑","greatNum":3,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"范德萨法萨芬撒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-11-30/20181130191303.png","commentId":1254,"commentTime":1543750071000,"commentUserId":1418,"commentUserName":"小黑","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0},{"commentContent":"范德萨法萨芬撒","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2018-11-30/20181130191303.png","commentId":1253,"commentTime":1543749880000,"commentUserId":1418,"commentUserName":"小黑","greatNum":2,"hotComment":0,"isGreat":0,"replyNum":0}]
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
         * commentContent : 又来
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/bwjy.jpg
         * commentId : 1312
         * commentTime : 1543893828000
         * commentUserId : 1431
         * commentUserName : lidikun
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         * replyNum : 0
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
        private int replyNum;

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

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }
    }
}
