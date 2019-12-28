package control;

import view.BlockDisplay;

public class MoveDownCommand implements Command{
    
    private final BlockDisplay display;
    
    public MoveDownCommand(BlockDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.show(display.block().moveDown());
    }
    
}