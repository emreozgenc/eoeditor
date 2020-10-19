package com.emreozgenc.eoeditor.xml;

public class EOEditorObjectXML {
    public int type;
    public float posX;
    public float posY;
    public float width;
    public float height;
    public int layerIndex;

    public EOEditorObjectXML(int type, float posX, float posY, float width, float height, int layerIndex) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.layerIndex = layerIndex;
    }
}
