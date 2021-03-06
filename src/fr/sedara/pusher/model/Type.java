package fr.sedara.pusher.model;

import java.awt.Color;

/** Boxes' type.
 * @author Sedara
 *
 */
public enum Type {

	// TODO Langue pour EUX !

    /**
     * The Player.
     */
    PLAYER("P", Color.BLUE, "player"),
    
    /**
     * A wall.
     */
    WALL("W", Color.RED, "wall"),
    
    /**
     * A playable box.
     */
    PLAYABLE_BOX("X", Color.GRAY, "playable"),
    
    /**
     * A box which kills the player if he touches it.
     */
    DEADLY("D", Color.WHITE, "deadly"),
    
    /**
     * A breakable box which will be destroyed if the player of a playable box touches it.
     */
    BREAKABLE("B", Color.YELLOW, "breakable"),
    
    /**
     * An objective block.
     */
    OBJECTIVE("O", Color.CYAN, "objective"),
    
    /**
     * A box which contains nothing.
     */
    NULL(" ", Color.BLACK, "null");

    /**
     * The number of all the different boxes.
     */
    public static final int NUMBER_OF_BLOCKS = 7;
    
    /**
     * The character which represents the box.
     */
    private final String toStringChar;
    
    /**
     * The color of the box.
     */
    private final Color  color;
    
    /**
     * The name of the box.
     */
    private final String name;

    /** Creates a new Type.
     * @param toStringChar : The character which represents the box.
     * @param color : The color of the box.
     * @param name : The name of the box.
     */
    private Type(String toStringChar, Color color, String name) {
        this.toStringChar = toStringChar;
        this.color = color;
        this.name = name;
    }

    /**
     * @param index : The number of the Type.
     * @return The type searched.
     */
    public static Type getType(int index) {
        switch (index) {
            case 0:
                return PLAYER;
            case 1:
                return WALL;
            case 2:
                return OBJECTIVE;
            case 3:
                return PLAYABLE_BOX;
            case 4:
                return BREAKABLE;
            case 5:
                return DEADLY;
            case 6:
                return NULL;
        }

        return NULL;
    }

    /**
     * @return The name of the Type.
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return toStringChar;
    }

    /**
     * @return The color of the Type.
     */
    public Color getColor() {
        return color;
    }


}
