package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EOEditorRectObject extends EOEditorObject {
    
    private float width;
    private float height;
    private Texture texture;
    
    public EOEditorRectObject(float posX, float posY, int layerIndex, String name, float width, float height) {
        super(posX, posY, layerIndex, name);
        this.width = width;
        this.height = height;
        
        this.texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }
    
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, posX, posY, width, height);
    }
    
    @Override
    public void update(float delta) {
        
    }
    
    public float getWidth() {
        return this.width;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public void setWidth(float width) {
        this.width = width;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }
    
    

}
