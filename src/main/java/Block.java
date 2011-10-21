public class Block {

    public int x;
    public int y;
    public int length;
    private char orientation;

    public Block(int id, int x, int y, int length, char orientation) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.orientation = orientation;
    }

    public boolean isHorizontal() {
        return orientation == 'h';
    }
}
