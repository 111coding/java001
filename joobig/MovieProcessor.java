import movie.MovieDTO;

public class MovieProcessor {
    // REVIEW
    // Java 애플리케이션 내에서 main은 반드시 하나만 존재헤야합니다
    // 지금구조 같이 MovieProcessor와 MovieOpreations두 클래스 내에 각각 메인함수가 있다면 
    // 두 클래스 각각 다른 프로그램으로 인식될거에요
    public static void main(String[] args) {

        MovieDTO[] m = new MovieDTO[3];
        m[0] = new MovieDTO("기생충","김기택",132,8.6f,1);
        m[1] = new MovieDTO("올드보이","오대수",120,8.4f,2);
        m[2] = new MovieDTO("괴물","박강두",119,7.1f,3);

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i].getMrating()<m[j].getMrating()){
                    MovieDTO tmp;
                    tmp=m[i];
                    m[i]=m[j];
                    m[j]=tmp;
                }
            }
        }
        for (MovieDTO movie: m) {
            System.out.println(movie);
        }
    }
}
