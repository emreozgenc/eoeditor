package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EOEditorObject {
    private float posX;
    private float posY;
    private float width;
    private float height;
    private Texture texture;
    private int layerIndex;
    
    public EOEditorObject(float width, float height, int layerIndex, String texturePath) {
        posX = posY = 0;
        this.width = width;
        this.height = height;
        this.layerIndex = layerIndex;
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }
    
    public void setPos(Vector2 pos) {
        posX = pos.x;
        posY = pos.y;
    }

    public Vector2 getPos() {
        return new Vector2(posX, posY);
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(texture,
                posX + width/2,
                posY + height/2,
                width, height);
    }
    
    public int getLayerIndex() {
        return layerIndex;
    }
}
