package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.emreozgenc.eoeditor.EOEditor;

public class EOEditorObject {
    private float posX;
    private float posY;
    private float width;
    private float height;
    private Texture texture;
    private int layerIndex;
    private EOEditor editor;
    private int type;
    
    public EOEditorObject(float width, float height, int layerIndex, String texturePath, int type) {
        posX = posY = 0;
        this.width = width;
        this.height = height;
        this.layerIndex = layerIndex;
        this.type = type;
        texture = new Texture(Gdx.files.internal(texturePath));
        editor = (EOEditor)Gdx.app.getApplicationListener();
    }
    
    public void setPos(Vector2 pos) {
        posX = pos.x;
        posY = pos.y;
    }

    public Vector3 getPos() {
        Vector3 pos = new Vector3(posX, posY, 0);
        return pos;
    }
    
    public void update() {
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            Vector3 mPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            mPos = editor.getCamera().unproject(mPos);
            
            Rectangle rect = new Rectangle(posX, posY, width, height);
            
            if(rect.contains(new Vector2(mPos.x, mPos.y))) {
                int index = EOEditorArrays.objects.indexOf(this, true);
                EOEditor.selectedObject = this;
                editor.setSelectedObject(index);
            }
        }
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(texture,
                posX,
                posY,
                width, height);
    }
    
    public int getLayerIndex() {
        return layerIndex;
    }
    
    public float getWidth() {
        return width;
    }
    
    public float getHeight() {
        return height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setLayerIndex(int layerIndex) {
        this.layerIndex = layerIndex;
    }
}
