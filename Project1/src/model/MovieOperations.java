package model;

import java.util.*;

public class MovieOperations {
    private List<MovieDTO> movies = new ArrayList<>();

    public void addMovie(MovieDTO movie) {
        movies.add(movie);
    }

    public void searchMoviesByRating() {
        //I에 영화 데이터가 없을 때
        if (movies.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }

        // 평점을 기준으로 내림차순 정렬
        Collections.sort(movies);

        // 정렬된 목록 출력
        for (MovieDTO movie : movies) {
            System.out.println(movie);
        }
    }

    public void searchMoviesByGenre(int genre) {
        if (movies.isEmpty()) {
            System.out.println("데이터가 없습니다.");
            return;
        }

        if (isValidGenre(genre)) {
            List<MovieDTO> filteredMovies = new ArrayList<>();

            for (MovieDTO movie : movies) {
                if (movie.getGenre() == genre) {
                    filteredMovies.add(movie);
                }
            }

            if (filteredMovies.isEmpty()) {
                System.out.println("해당 장르의 영화가 없습니다.");
            } else {
                System.out.println("장르 " + genre + "에 해당하는 영화 :");
                for (MovieDTO movie : filteredMovies) {
                    System.out.println(movie);
                }
            }
        } else {
            System.out.println("잘못된 장르 입력입니다. 1, 2, 3 중 하나를 입력하세요.");
        }

    }
    public boolean isEmpty() {
        return movies.isEmpty();
    }

    public boolean isValidGenre(int genre) {
        return genre >= 1 && genre <= 3;
    }
}


