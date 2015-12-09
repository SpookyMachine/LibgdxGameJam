package com.mygdx.game.box2d;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by mike on 12/9/15.
 */
public class GroundUserData extends UserData{
    public GroundUserData() {
        super();
        userDataType = UserDataType.GROUND;
    }
}
