package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.emreozgenc.eoeditor.entities.EOEditorObject;
import com.emreozgenc.eoeditor.entities.EOEditorRectObject;
import com.emreozgenc.eoeditor.interfaces.IEOEditorLauncher;
import java.util.Timer;
import java.util.TimerTask;

public class EOEditor extends ApplicationAdapter {

    public final int PPM = 100;

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private ShapeRenderer renderer;
    private IEOEditorLauncher launcher;
    
    //Timers
    private Timer camTimer;

    EOEditorObject obj;

    @Override
    public void create() {
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth() / PPM, Gdx.graphics.getHeight() / PPM);
        cam.position.set(Vector3.Zero);

        obj = new EOEditorRectObject(0, 0, 0, "Emre", 3, 3);
        renderer = new ShapeRenderer();
        startCamTimer();
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
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
        if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
            float deltaX = Gdx.input.getDeltaX();
            float deltaY = Gdx.input.getDeltaY();

            cam.position.x -= deltaX * Gdx.graphics.getDeltaTime() * .7f;
            cam.position.y += deltaY * Gdx.graphics.getDeltaTime() * .7f;
        }

        cam.update();
    }
    
    private void updateCameraFields() {
        Vector3 pos = cam.position;
       
        launcher.upgradeCamPositionFields(pos.x, pos.y);
    }
    
    public Vector3 getCameraPosition() {
        System.out.println(cam.position);
        return cam.position;
    }

    public void setLauncher(IEOEditorLauncher launcher) {
        this.launcher = launcher;
    }
    
    public void setCameraPosition(float posX, float posY) {
        cam.position.x = posX;
        cam.position.y = posY;
    }
    
    public void resetCameraPosition() {
        cam.position.x = 0f;
        cam.position.y = 0f;
    }
    
    public void setCameraZoom(float zoom) {
        cam.zoom = 1 / zoom;
    }
    
    public void resetCameraZoom() {
        cam.zoom = 1;
    }
    
    public void startCamTimer() {
        camTimer = new Timer();
        camTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateCameraFields();
            }
        }, 300, 300);
    }
    
    public void pauseCamTimer() {
        if(camTimer != null) {
            camTimer.cancel();
        }
    }
}
