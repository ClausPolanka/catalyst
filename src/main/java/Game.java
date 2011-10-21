import java.util.ArrayList;
import java.util.List;

public class Game {
    private int[][] raster;
    private List<Block> blocks = new ArrayList<Block>();
    private int xAxis;
    private int yAxis;

    public Game(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        raster = new int[xAxis][yAxis];
        initGameRasterWithZeros();
    }

    private void initGameRasterWithZeros() {
        for (int i = 0; i < xAxis; i++) {
            for (int j = 0; j < yAxis; j++) {
                raster[i][j] = 0;
            }
        }
    }

    public void add(Block block) {
        blocks.add(block);
    }

    public boolean overlap() {
        setBlocksOnPitch();
        return pitchHasOverlaps();
    }

    private void setBlocksOnPitch() {
        for (Block block : blocks) {
            setOnPitch(block);
        }
    }

    private void setOnPitch(Block block) {
        for (int i = 0; i < block.length; i++) {
            if (block.isHorizontal()) {
                raster[block.x++][block.y]++;
            } else {
                raster[block.x][block.y++]++;
            }
        }
    }

    private boolean pitchHasOverlaps() {
        for (int i = 0; i < xAxis; i++) {
            for (int j = 0; j < yAxis; j++) {
                if (raster[i][j] >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
