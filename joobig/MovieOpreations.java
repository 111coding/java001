import movie.MovieDTO;

import java.util.*;
import java.lang.*;

public class MovieOpreations {
    public static void main(String[] args) {
        List<MovieDTO> movies = new ArrayList<>();
        Scanner scan = new Scanner(System.in);



        while(true){
            System.out.printf("========= 장르별 영화 검색 프로그램(어..? 이게 왜 돼조) =========%n");
            System.out.println("1.영화입력(I) 2.영화출력(P) 3.영화검색(S) 4.종료(E)");
            System.out.println("========================================================");
            System.out.print("메뉴 입력 : ");


//            String SelectNum= scan.nextLine();
            switch (scan.nextLine()){

                case "1" : case "i": case "I":
                    System.out.print("영화 제목 : ");
                    String mtitle=scan.nextLine();

                    System.out.print("영화 주인공 : ");
                    String mmajor=scan.nextLine();

                    System.out.print("영화 상영시간 : ");
                    int mruntime=scan.nextInt();

                    System.out.print("영화 평점 : ");
                    float mrating=scan.nextFloat();

                    System.out.print("영화 장르 : ");
                    int mgenre=scan.nextInt();

                    MovieDTO movie = new MovieDTO(mtitle, mmajor, mruntime, mrating, mgenre);
                    movies.add(movie);
                    break;


                case "2" : case "p": case "P":


                    for (int i = 0; i < movies.size(); i++) {
                        for (int j = 0; j < i; j++) {
                            if (movies.get(i).getMrating() < movies.get(j).getMrating()){
                                MovieDTO tmp=movies.get(i);
                                movies.set(j,movies.get(i));
                                movies.set(i,tmp);
                            }
                        }
                    }

                    for (MovieDTO movieLi: movies) {System.out.printf("%n"+movieLi+"%n");}
                    System.out.println();
                    break;

                case "3" : case "s": case "S":
                    System.out.printf("%n======검색할 장르를 검색하세요======%n.");
                    System.out.println(" 드라마(1)   액션(2)   호러(3)");
                    System.out.println("==============================");
                    System.out.print("장르 입력 : ");
                    int Genre = scan.nextInt();
                    if (0> Genre || Genre >4) {
                        System.out.printf("%n잘못된 입력입니다!!!!!!%n");
                        scan.nextInt();
                    }

                    int count = 0;
                    for (MovieDTO m: movies){
                        if (m.getMgenre()==Genre){
                            System.out.printf("%n영화 제목 : "+m.getMtitle());
                            System.out.print(", 영화 주인공 : "+m.getMmajor());
                            System.out.print(", 영화 상영시간 : "+m.getMruntime());
                            System.out.print(", 영화 평점 : "+m.getMrating());
                            switch (m.getMgenre()){
                                case (1):
                                    System.out.println(", 영화 장르 : 1");
                                    break;
                                case (2):
                                    System.out.println(", 영화 장르 : 2");
                                    break;
                                case(3):
                                    System.out.println(", 영화 장르 : 3");
                            }
                            count++;
                        }
                    }

                    int temp=0;


                    break;

                case "4" : case "-1" : case "e": case "E":
                    return;
            }
        }


    }
}
