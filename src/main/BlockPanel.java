package main;

import model.Block;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
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
        for ( int x = 0; x <= 700; x += 100 )
        g.drawLine( x, 0, x, 700 );
        
        for ( int y = 0; y <= 700; y += 100 ) 
        g.drawLine( 0, y, 700, y );
        
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

