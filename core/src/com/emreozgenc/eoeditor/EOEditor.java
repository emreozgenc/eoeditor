package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.emreozgenc.eoeditor.entities.EOEditorArrays;
import com.emreozgenc.eoeditor.entities.EOEditorGridSystem;
import com.emreozgenc.eoeditor.entities.EOEditorObject;
import com.emreozgenc.eoeditor.interfaces.IEOEditorLauncher;
import java.util.Timer;
import java.util.TimerTask;

public class EOEditor extends ApplicationAdapter {

    public final int PPM = 100;
    public float cameraMovementSpeed = 1;

    private SpriteBatch batch;
    private OrthographicCamera cam;
    private EOEditorGridSystem gridSystem;
    private ShapeRenderer renderer;
    private IEOEditorLauncher launcher;
    
    //Timers
    private Timer camTimer;
    
    private EOEditorObject test;
 

    @Override
    public void create() {
        batch = new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth() * 2 / PPM, Gdx.graphics.getHeight() * 2/ PPM);
        cam.position.set(Vector3.Zero);

        renderer = new ShapeRenderer();
        gridSystem = new EOEditorGridSystem();
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
        gridSystem.render(batch);
        for(EOEditorObject object : EOEditorArrays.objects) {
            object.render(batch);
        }
        System.out.println(EOEditorArrays.objects.size);
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void handleCameraMovement() {
        if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
            float deltaX = Gdx.input.getDeltaX();
            float deltaY = Gdx.input.getDeltaY();

            cam.position.x -= deltaX * Gdx.graphics.getDeltaTime() * .7f * cameraMovementSpeed;
            cam.position.y += deltaY * Gdx.graphics.getDeltaTime() * .7f * cameraMovementSpeed;
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
