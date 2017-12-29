package hu.ait.android.emotiontracker.data;

/**
 * Created by alicetan on 12/28/17.
 */

public class Action {

    private String actionName;

    private String uid;

    public Action(){

    }

    public Action(String uid, String actionName){
        this.uid = uid;
        this.actionName = actionName;
    }

    public String getActionName(){
        return actionName;
    }

    public void setAction(String actionName){
        this.actionName = actionName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

