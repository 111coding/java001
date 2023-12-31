package model;

import enums.Genre;
public class MovieDTO {
    // 세부정보는 제목(title), 주인공(major), 상영시간(runningTime), 평점(rating), 장르(genre)로
    //구성됩니다.
    //- 장르는 1(드라마), 2(액션), 3(호러)로
    private String title;
    private String major;
    private int runningTime;
    private float rating;
    private Genre genre;

    public MovieDTO(){}

    public MovieDTO(String title, String major, int runningTime, float rating, int genre) {
        this.title = title;
        this.major = major;
        this.runningTime = runningTime;
        this.rating = rating;
        // ui에서 장르가 1부터 시작해서 1빼줌
        this.genre = Genre.values()[genre - 1]; // TODO length check
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", major='" + major + '\'' +
                ", runningTime=" + runningTime +
                ", rating=" + rating +
                ", genre=" + genre.getLabel() +
                '}';
    }
}
