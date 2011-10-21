import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {
    private static final int SAME = 1;
    private static final int B1Y = 2;

    @Test
    public void twoHorizontalBlocksDoNotOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(1).withY(SAME).withLength(3).horizontal().build());
        game.add(new BlockBuilder().withX(4).withY(SAME).horizontal().build());
        assertFalse("Must not overlap", game.overlap());
    }

    @Test
    public void twoHorizontalBlocksWithDifferentYCoordinateCanNeverOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withY(1).horizontal().build());
        game.add(new BlockBuilder().withY(2).horizontal().build());
        assertFalse("Must not overlap", game.overlap());
    }

    @Test
    public void twoHorizontalBlocksOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(1).withY(SAME).withLength(3).horizontal().build());
        game.add(new BlockBuilder().withX(3).withY(SAME).horizontal().build());
        assertTrue("Must overlap", game.overlap());
    }

    @Test
    public void twoVerticalBlocksDoNotOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(SAME).withY(1).withLength(3).vertical().build());
        game.add(new BlockBuilder().withX(SAME).withY(4).vertical().build());
        assertFalse("Must not overlap", game.overlap());
    }

    @Test
    public void twoVerticalBlocksOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(SAME).withY(1).withLength(3).vertical().build());
        game.add(new BlockBuilder().withX(SAME).withY(3).vertical().build());
        assertTrue("Must overlap", game.overlap());
    }

    @Test
    public void twoVerticalBlocksWithDifferentXCoordinateCanNeverOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(1).vertical().build());
        game.add(new BlockBuilder().withX(2).vertical().build());
        assertFalse("Must not overlap", game.overlap());
    }

    @Test
    public void oneVerticalAndOneHorizontalBlockWithDifferentYCoordinateDoNotOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(SAME).withY(B1Y).horizontal().build());
        game.add(new BlockBuilder().withX(SAME).withY(B1Y + 1).vertical().build());
        assertFalse("Must not overlap", game.overlap());
    }

    @Test
    public void oneVerticalAndOneHorizontalBlockWithSameYCoordinateOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(SAME).withY(SAME).horizontal().build());
        game.add(new BlockBuilder().withX(SAME).withY(SAME).vertical().build());
        assertTrue("Must overlap", game.overlap());
    }

    @Test public void
    oneVerticalAndHorizontalBlockWithDifferentYCoordinateButVerticalBlockHasNecessaryLengthToOverlap() {
        Game game = new Game(6, 5);
        game.add(new BlockBuilder().withX(SAME).withY(B1Y).horizontal().build());
        game.add(new BlockBuilder().withX(SAME).withY(B1Y - 1).withLength(2).vertical().build());
        assertTrue("Must overlap", game.overlap());
    }
}
