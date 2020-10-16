package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class EOEditorObject {

    protected float posX;
    protected float posY;
    protected int layerIndex;
    protected String name;

    public EOEditorObject(float posX, float posY, int layerIndex, String name) {
        this.posX = posX;
        this.posY = posY;
        this.layerIndex = layerIndex;
        this.name = name;
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
    
    public String getName() {
        return this.name;
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
    
    public void setName(String name) {
        this.name = name;
    }
}
