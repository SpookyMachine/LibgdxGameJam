package com.mygdx.game.box2d;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by mike on 12/9/15.
 */
public abstract class UserData {
    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }
}
