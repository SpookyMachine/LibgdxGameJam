package com.mygdx.enums;

/**
 * Created by mike on 12/4/15.
 */
public enum TiledMapLayer {

    GROUND("Ground"),
    COINS("Coins"),
    PIPES("Pipes"),
    BRICKS("Bricks"),
    GOOMBAS("Goombas")
    ;

    private final String text;

    /**
     * @param text
     */
    private TiledMapLayer(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
