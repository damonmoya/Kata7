package main;

import model.Block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

public class BlockPanel extends JPanel implements view.BlockDisplay{

    private Block block;
    private Graphics g;
    
    public BlockPanel (Block block){
        this.block = block;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(212, 212, 212));
        g.fillRect(250, 250, 90, 90);
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

