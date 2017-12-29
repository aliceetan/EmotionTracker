package hu.ait.android.emotiontracker.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.ait.android.emotiontracker.R;

public class Emotion {

    private String emotion;

    public Emotion(){

    }

    public Emotion(String emotion){
        this.emotion = emotion;
    }

    public String getEmotion(){
        return emotion;
    }

    public void setEmotion(String emotion){
        this.emotion = emotion;
    }
}
