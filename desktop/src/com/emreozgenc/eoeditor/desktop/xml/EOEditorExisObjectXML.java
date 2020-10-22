/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emreozgenc.eoeditor.desktop.xml;

public class EOEditorExisObjectXML {
    public float width;
    public float height;
    public String texturePath;
    public String name;

    public EOEditorExisObjectXML(float width, float height, String texturePath, String name) {
        this.width = width;
        this.height = height;
        this.texturePath = texturePath;
        this.name = name;
    }
}
