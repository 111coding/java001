package enums;

public enum Genre {
    DRAMA("드라마"),
    ACTION("액션"),
    HOROR("호러");

    private String label;

    Genre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    static public void printLabels() {
        System.out.print("(");
        for (int i = 0; i < Genre.values().length; i++) {
            Genre g = Genre.values()[i];
            System.out.printf("%d=%s", i + 1, g.getLabel());
        }
        System.out.println(")");
    }
}
