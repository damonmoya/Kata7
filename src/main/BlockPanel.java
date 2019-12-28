package main;

import model.Block;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BlockPanel extends JPanel implements view.BlockDisplay{

    private Block block;
    private Graphics g;
    
    public BlockPanel (Block block){
        this.block = block;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for ( int x = 0; x <= 500; x += 50 )
        for ( int y = 0; y <= 500; y += 50 ) 
        g.drawRect( x, y, 50, 50 );
        g.setColor(new Color(255, 0, 0));
        g.fillRect(block.blockPosX(), block.blockPosY(), 100, 100);
    }

    @Override
    public Block block() {
        return block;
    }

    @Override
    public void show(Block block) {
        this.block = block;
        this.repaint();
    }
    
}

