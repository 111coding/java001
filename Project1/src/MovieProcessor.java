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
            // REVIEW
            // 입력값을 대문자로 치환한 후 비교하면 소문자로도 입력을 받을 수 있어서 편해질거 같아요
            // scanner.nextLine().toUpperCase() 이렇게요
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
        // REVIEW
        // nextInt를 사용할 때에는 예외처리를 잘 해주어야 돼요
        // 사용자가 문자열을 입력하면 애플리케이션이 터지게 되거든요
        // scanner의 입력을 받아서 int 를 리턴해주는 유틸 함수를 만들고 해당 함수내에서 예외처리를 해놓으면
        // 다른곳에서도 사용할 수 있어서 개발할 때 편하실거에요
        int numberOfMovies = scanner.nextInt();
        // 불필요한 코드
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
            // REVIEW
            // 불필요한 코드 아닌가요?
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
