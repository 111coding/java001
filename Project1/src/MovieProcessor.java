//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;
import model.MovieDTO;
import model.MovieOperations;

public class MovieProcessor {
    public MovieProcessor() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieOperations operations = new MovieOperations();

        while(true) {
            System.out.println("========= 장르별 영화 검색 프로그램 =========");
            System.out.println("1.영화입력(I) 2.영화출력(P) 3.영화검색(S) 4.종료(E)");
            System.out.println("=============================================");
            System.out.print("메뉴입력: ");
            switch (scanner.nextLine()) {
                case "I":
                    addMovie(scanner, operations);
                    break;
                case "P":
                    operations.searchMoviesByRating();
                    break;
                case "S":
                    searchMoviesByGenre(scanner, operations);
                    break;
                case "-1":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private static void addMovie(Scanner scanner, MovieOperations operations) {
        System.out.print("저장할 영화 데이터 수를 입력하세요: ");
        int numberOfMovies = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numberOfMovies; ++i) {
            System.out.println("영화 " + (i + 1) + ":");
            System.out.print("제목 ('-1' 입력시 영화 데이터 입력을 중단합니다.): ");
            String title = scanner.nextLine();
            if ("-1".equals(title)) {
                System.out.println("영화 입력을 중지합니다.");
                return;
            }

            System.out.print("주연: ");
            String major = scanner.nextLine();
            System.out.print("상영시간: ");
            int runningTime = scanner.nextInt();
            System.out.print("평점: ");
            double rating = scanner.nextDouble();
            System.out.print("장르 (1: 드라마, 2: 액션, 3: 호러): ");
            int genre = scanner.nextInt();
            scanner.nextLine();
            MovieDTO movie = new MovieDTO(title, major, runningTime, rating, genre);
            operations.addMovie(movie);
        }

        System.out.println("영화 데이터 입력이 완료되었습니다.");
    }

    private static void searchMoviesByGenre(Scanner scanner, MovieOperations operations) {
        if (operations.isEmpty()) {
            System.out.println("데이터가 없습니다.");
        } else {
            int genre;
            do {
                System.out.print("검색할 장르를 입력하세요 (1: 드라마, 2: 액션, 3: 호러): ");
                genre = scanner.nextInt();
                scanner.nextLine();
                if (!operations.isValidGenre(genre)) {
                    System.out.println("잘못된 장르 입력입니다. 1, 2, 3 중 하나를 입력하세요.");
                }
            } while(!operations.isValidGenre(genre));

            operations.searchMoviesByGenre(genre);
        }
    }
}
