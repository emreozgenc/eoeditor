package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class EOEditorObject {

    protected float posX;
    protected float posY;
    protected int layerIndex;

    public EOEditorObject(float posX, float posY, int layerIndex) {
        this.posX = posX;
        this.posY = posY;
        this.layerIndex = layerIndex;
    }
    
    public abstract void render(SpriteBatch batc);
    public abstract void update(float delta);

    public float getPosX() {
        return this.posX;
    }

    public float getPosY() {
        return this.posY;
    }

    public int getLayerIndex() {
        return this.layerIndex;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setLayerIndex(int layerIndex) {
        this.layerIndex = layerIndex;
    }
}
