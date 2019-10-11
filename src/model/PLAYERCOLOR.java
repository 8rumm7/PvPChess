package model;

public enum PLAYERCOLOR {

    WHITE  (0), BLACK(1);

    private final int color;

    PLAYERCOLOR(int num){
        this.color = num;
    }

    public boolean equals(PLAYERCOLOR other){
        return this.color == other.color;
    }
}
