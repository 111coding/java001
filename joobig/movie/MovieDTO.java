package movie;
import java.util.*;
import java.lang.*;


public class MovieDTO {
    // 각각 변수명 앞에 m이 붙는 이유가 따로 있을까요?
    private String mtitle;
    private String mmajor;
    private int mruntime;
    private float mrating;
    private int mgenre;
    public static int index;

    public MovieDTO(){}

    public MovieDTO(String mtitle, String mmajor, int mruntime, float mrating, int mgenre) {
        this.mtitle = mtitle;
        this.mmajor = mmajor;
        this.mruntime = mruntime;
        this.mrating = mrating;
        this.mgenre = mgenre;
    }


    public String getMtitle() {return this.mtitle;}
    public void setMtitle(String mtitle) {this.mtitle = mtitle;}

    public String getMmajor() {return this.mmajor;}
    public void setMmajor(String mmajor) {this.mmajor = mmajor;}

    public int getMruntime() {return mruntime;}
    public void setMruntime(int mruntime) {this.mruntime = mruntime;}

    public float getMrating() {return mrating;}
    public void setMrating(float mrating) {this.mrating = mrating;}

    public int getMgenre() {return mgenre;}
    public void setMgenre(int mgenre) {this.mgenre = mgenre;}

    @Override
    public String toString() {
        return "MovieDTO{" +
                "mtitle='" + mtitle + '\'' +
                ", mmajor='" + mmajor + '\'' +
                ", mruntime=" + mruntime +
                ", mrating=" + mrating +
                ", mgenre=" + mgenre +
                '}';
    }
}


