package com.tony.dbmovie.data;

/**
 * Created by bushi on 2018/2/5.
 */

public class EmptyClass {

    private String leftString;
    private String rightString;

    public String getLeftString() {
        return leftString;
    }

    public void setLeftString(String leftString) {
        this.leftString = leftString;
    }

    public String getRightString() {
        return rightString;
    }

    public void setRightString(String rightString) {
        this.rightString = rightString;
    }

    public EmptyClass() {

    }

    public EmptyClass(String l,boolean isLeft)
    {
        if (isLeft) {
            leftString = l;
        }else {
            rightString = l;
        }
    }

    public EmptyClass(String l,String r)
    {
        leftString = l;
        rightString = r;
    }
}
