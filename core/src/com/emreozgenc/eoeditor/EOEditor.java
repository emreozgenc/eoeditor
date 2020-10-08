package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class EOEditor extends ApplicationAdapter {
    
    public final int PPM = 100;
    
    private SpriteBatch batch;
    private OrthographicCamera cam;
    
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture(Gdx.files.internal("badlogic.jpg"));
        cam = new OrthographicCamera(Gdx.graphics.getWidth() / PPM, Gdx.graphics.getHeight() / PPM);
        cam.position.set(Vector3.Zero);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        handleCameraMovement();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(img, 0, 0, 2, 2);
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
