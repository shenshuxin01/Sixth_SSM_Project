package ssx.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DBScheamE implements Serializable {

    @JsonProperty("v_id")
    private int myId;

    @Override
    public String toString() {
        return "DBScheamE{" +
                "myId=" + myId +
                ", myName='" + myName + '\'' +
                '}';
    }

    @JsonProperty("v_name")
    private String myName;

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public DBScheamE(int myId, String myName) {
        this.myId = myId;
        this.myName = myName;
    }

    public DBScheamE() {
    }
}
