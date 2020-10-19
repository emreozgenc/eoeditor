
package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class EOEditorGridSystem {
    private List<EOEditorGrid> grids;
    private Texture gridTexture;
    
    public EOEditorGridSystem() {
        grids = new ArrayList<>();
        gridTexture = new Texture(Gdx.files.internal("grid.png"));
        
        for(int i=-500; i<=500; i++) {
            for(int j=-500; j<=500; j++) {
                grids.add(new EOEditorGrid(i, j, gridTexture));
            }
        }
    }
    
    public void render(SpriteBatch batch) {
        for(EOEditorGrid grid : grids) {
            batch.draw(grid.texture, grid.posX, grid.posY, 1, 1);
        }
    }
}
