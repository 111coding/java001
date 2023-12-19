import movie.MovieDTO;

public class MovieProcessor {
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
