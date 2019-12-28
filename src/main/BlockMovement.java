package main;

import model.Block;

public class BlockMovement {
    
    private int pos;
    
    public BlockMovement(){
        this.pos = 200;
    }
    
    public Block origin() {
        return BlockAt(200);
    }
    
    private Block BlockAt(int pos) {
        return new Block() {
            @Override
            public Block moveRight() {
                return BlockAt(pos < 500 ? pos+50 : pos);
            }

            @Override
            public Block moveLeft() {
                return BlockAt(pos > 0 ? pos-50 : pos);
            }

        };
    }
    
}


    