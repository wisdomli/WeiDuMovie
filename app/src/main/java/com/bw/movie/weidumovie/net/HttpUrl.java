package com.bw.movie.weidumovie.net;

/**
 * 作者:李自强
 * <p>
 * 2018/11/27
 **/
public class HttpUrl {
    public static String BaseUrl = "http://mobile.bwstudent.com/";
    public static String HotmoviesUrl = "movieApi/movie/v1/findHotMovieList";
    public static String ShowingUpUrl ="movieApi/movie/v1/findReleaseMovieList";
    public static String ShowSoonUrl ="movieApi/movie/v1/findComingSoonMovieList";
    public static String RegisterUrl= "movieApi/user/v1/registerUser";
    public static String LoginUrl= "movieApi/user/v1/login";
    public static String CinemasUrl = "movieApi/cinema/v1/findRecommendCinemas";
    public static String FeedBackUrl = "movieApi/tool/v1/verify/recordFeedBack";
    public static String MoviesDetailUrl ="movieApi/movie/v1/findMoviesDetail";
    public static String UpdateUrl ="movieApi/user/v1/verify/modifyUserInfo";
    public static String QueryCinemaUrl ="movieApi/cinema/v1/verify/findCinemaPageList";
    public static String SuccessCinemaFollow ="movieApi/cinema/v1/verify/followCinema";
    public static String FailureFollow ="movieApi/cinema/v1/verify/cancelFollowCinema";
    public static String MovieQueryUrl ="movieApi/movie/v1/verify/findMoviePageList";
    public static String MovieSuccessFollow ="movieApi/movie/v1/verify/followMovie";
    public static String MovieFailureFollow ="movieApi/movie/v1/verify/cancelFollowMovie";
    public static String FilmreviewUrl = "movieApi/movie/v1/findAllMovieComment";
    public static String VersionUrl = "movieApi/tool/v1/findNewVersion";
    public static String CinemaInfoUrl = "movieApi/cinema/v1/findCinemaInfo";
    public static String ByCinemaIdUrl = "movieApi/movie/v1/findMovieListByCinemaId";
    public static String MovieScheduleUrl = "movieApi/movie/v1/findMovieScheduleList";
    public static String PraiseUrl = "movieApi/movie/v1/verify/movieCommentGreat";
    public static String CinemasListUrl = "movieApi/movie/v1/findCinemasListByMovieId";
    public static String CommentUrl = "movieApi/cinema/v1/findAllCinemaComment";
    public static String CommentGreatUrl = "movieApi/cinema/v1/verify/cinemaCommentGreat";
    public static String HeadPicUrl = "movieApi/user/v1/verify/uploadHeadPic";
}
