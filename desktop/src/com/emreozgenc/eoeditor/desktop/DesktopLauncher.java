package com.emreozgenc.eoeditor.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.emreozgenc.eoeditor.EOEditor;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DesktopLauncher extends JFrame{
    private final int C_WIDTH = 1200;
    private final int C_HEIGHT = 720;
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;
    
    private LwjglAWTCanvas canvas;
    private EOEditor editor;
    
    public DesktopLauncher() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("EOEditor Map Editor by emreozgenc");
        setResizable(false);
        setLayout(null);
        editor = new EOEditor();
        canvas = new LwjglAWTCanvas(editor);
        canvas.getCanvas().setBounds(50, 50, C_WIDTH, C_HEIGHT);
        add(canvas.getCanvas());
        
        pack();
        setBounds(0, 0, WIDTH, HEIGHT);
        setVisible(true);
    }
    
    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopLauncher();
            }
        });
    }
}
