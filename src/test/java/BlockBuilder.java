public class BlockBuilder {
    private int y;
    private char orientation;
    private int id;
    private int x;
    private int length = 1;

    public BlockBuilder withY(int y) {
        this.y = y;
        return this;
    }

    public BlockBuilder horizontal() {
        this.orientation = 'h';
        return this;
    }

    public BlockBuilder withX(int x) {
        this.x = x;
        return this;
    }

    public BlockBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public Block build() {
        return new Block(id, x, y, length, orientation);
    }

    public BlockBuilder vertical() {
        this.orientation = 'v';
        return this;
    }
}
