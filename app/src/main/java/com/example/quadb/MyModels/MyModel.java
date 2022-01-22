package com.example.quadb.MyModels;

public class MyModel {
    String score;
    model show;

    public MyModel(String score, model show) {
        this.score = score;
        this.show = show;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public model getShow() {
        return show;
    }


    public void setShow(model show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "score='" + score + '\'' +
                ", show=" + show +
                '}';
    }
}
