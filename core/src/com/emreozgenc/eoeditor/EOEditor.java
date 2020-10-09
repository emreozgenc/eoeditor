package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.emreozgenc.eoeditor.entities.EOEditorObject;
import com.emreozgenc.eoeditor.entities.EOEditorRectObject;

public class EOEditor extends ApplicationAdapter {
    
    public final int PPM = 100;
    
    private SpriteBatch batch;
    private OrthographicCamera cam;
    
    EOEditorObject obj;

    @Override
    public void create() {
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth() / PPM, Gdx.graphics.getHeight() / PPM);
        cam.position.set(Vector3.Zero);
        
        obj = new EOEditorRectObject(0, 0, 0, 3, 3);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleCameraMovement();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        obj.render(batch);
        batch.end();
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
}
