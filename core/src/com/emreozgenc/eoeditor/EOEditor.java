package com.emreozgenc.eoeditor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
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
    
    public static EOEditorObject selectedObject = null;
    
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
        update();
        handleCameraMovement();

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        gridSystem.render(batch);
        for(EOEditorObject object : EOEditorArrays.objects) {
            object.render(batch);
        }
        batch.end();
        
        renderer.setProjectionMatrix(cam.combined);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.GREEN);
        if(selectedObject != null) {
            renderer.rect(selectedObject.getPos().x, selectedObject.getPos().y,
                    selectedObject.getWidth(), selectedObject.getHeight());
        }
        renderer.end();
    }
    
    private void update() {
        for(EOEditorObject object : EOEditorArrays.objects) {
            object.update();
        }
        
        if(Gdx.input.isButtonJustPressed(Buttons.RIGHT)) {
            selectedObject = null;
            launcher.setSelectedObject(-1);
        }
        
        if(Gdx.input.isButtonPressed(Buttons.LEFT)) {
            if(selectedObject != null) {
                Vector3 pos = cam.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
                selectedObject.setPos(new Vector2(pos.x - selectedObject.getWidth() / 2,
                        pos.y - selectedObject.getHeight() / 2));
            }
        }
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
    
    public OrthographicCamera getCamera() {
        return cam;
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
    
    public void setSelectedObject(int index) {        
        launcher.setSelectedObject(index);
    }
}
