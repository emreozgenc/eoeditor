package com.emreozgenc.eoeditor.entities;

import com.badlogic.gdx.utils.Array;

public class EOEditorArrays {
    public static Array<EOEditorObject> objects = new Array<>();
    
    public static void sortObjects() {
        for(int i=0 ; i < objects.size ; i++) {
            int small = i;
            for(int j=i+1; j < objects.size; j++) {
                if(objects.get(j).getLayerIndex() < objects.get(small).getLayerIndex())
                    small = j;
            }
            
            EOEditorObject temp = objects.get(small);
            objects.set(small, objects.get(i));
            objects.set(i, temp);
        }
    }
}
