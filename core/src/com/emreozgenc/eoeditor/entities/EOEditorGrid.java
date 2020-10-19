package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.graphics.Texture;

public class EOEditorGrid {
    public int posX;
    public int posY;
    public Texture texture;

    public EOEditorGrid(int posX, int posY, Texture texture) {
        this.posX = posX;
        this.posY = posY;
        this.texture = texture;
    }
    
    
}
