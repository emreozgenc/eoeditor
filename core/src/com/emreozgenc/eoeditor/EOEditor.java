package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.emreozgenc.eoeditor.entities.EOEditorObject;
import com.emreozgenc.eoeditor.entities.EOEditorRectObject;

public class EOEditor extends ApplicationAdapter {
    
    public final int PPM = 100;
    
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private ShapeRenderer renderer;
    
    EOEditorObject obj;

    @Override
    public void create() {
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth() / PPM, Gdx.graphics.getHeight() / PPM);
        cam.position.set(Vector3.Zero);
        
        obj = new EOEditorRectObject(0, 0, 0, 3, 3);
        renderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glLineWidth(2f);
        handleCameraMovement();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        obj.render(batch);
        batch.end();
        
        
        renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.GREEN);
        renderer.rect(obj.getPosX(), obj.getPosY(), 3, 3);
        renderer.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
    
    private void handleCameraMovement() {
        if(Gdx.input.isButtonPressed(Buttons.RIGHT)) {
            float deltaX = Gdx.input.getDeltaX();
            float deltaY = Gdx.input.getDeltaY();
            
            cam.position.x -= deltaX * Gdx.graphics.getDeltaTime() * .5f;
            cam.position.y += deltaY * Gdx.graphics.getDeltaTime() * .5f;
        }
        
        cam.update();
    }
    
    // Test
    public void setPos(float posX, float posY) {
        obj.setPosX(posX);
        obj.setPosY(posY);
    }
}
