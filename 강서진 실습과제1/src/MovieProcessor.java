import model.MovieDTO;

import java.util.*;

public class MovieProcessor {
    public static void main(String[] args) {
        MovieOperations movieOp= new MovieOperations();

        while (true){
            // 초기 화면
            String menu = movieOp.start();

            // 영화 입력
            // REVIEW
            // menu를 대문자 혹은 소문자로 바꾼 후 비교하면 대소문자 둘 중 하나만 비교해도 되어서 개발시 실수를 방지하고 가독성면에서 더 좋을거에요
            if (menu.equals("I")||menu.equals("i")){
                System.out.println("추가할 영화의 수: ");
                // REVIEW
                // 숫자가 아닌 일반 문자열 입력을 받으면 애플리케이션이 RuntimeException으로 종료될 거에요
                // scanner로 입력받은 문자열을 숫자로 바꾸어서 리턴해주는 유틸 함수를 따로 만들어서 그 함수 내에서 예외처리까지 해놓으면
                // 다른 부분에서도 공통적으로 쓸 수 있어서 편할거에요
                int num = Integer.parseInt(movieOp.scan.nextLine());
                movieOp.addMovie(num);
            }

            // 영화 출력
            else if (menu.equals("P")||menu.equals("p")) {
                // REVIEW
                // if 문에 빈 블록을 사용하는 것보다 if(!movieOp.emptyMovies()) 조건을 사용한다면
                // else문은 없앨 수 있지 않을까요? 개인적인 의견입니다
                if (movieOp.emptyMovies()) {} else {
                    movieOp.printMovies();
                }
            }

            // 영화 장르로 검색
            else if (menu.equals("S")||menu.equals("s")) {
                if (movieOp.emptyMovies()) {} else {
                    System.out.println("장르를 입력하세요.\n1=드라마, 2=액션, 3=호러");
                    int gen = Integer.parseInt(movieOp.scan.nextLine());
                    movieOp.searchByGenre(gen);
                }
            }

            else if (menu.equals("T")||menu.equals("t")) {
                if (movieOp.emptyMovies()) {} else {
                    System.out.println("제목을 입력하세요: ");
                    String title = movieOp.scan.nextLine();
                    movieOp.searchByName(title);
                }
            }

            // 종료
            else if ((menu.equals("E"))||(menu.equals("-1"))||menu.equals("e")){
                return;
            }

            // 잘못된 입력
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. ");
            }
        }
    }
}
