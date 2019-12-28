package main;

import model.Block;

public class BlockMovement {
    
    private int pos;
    
    public BlockMovement(){
        this.pos = 200;
    }
    
    public Block origin() {
        return BlockAt(this.pos);
    }
    
    private Block BlockAt(int pos) {
        return new Block() {
            @Override
            public Block moveRight() {
                int localPos = pos;
                if (pos < 500) localPos = pos + 50;
                setPos(localPos);
                return BlockAt(localPos);
            }

            @Override
            public Block moveLeft() {
                int localPos = pos;
                if (pos > 0) localPos = pos - 50;
                setPos(localPos);
                return BlockAt(localPos);
            }

        };
    }
    
}


    