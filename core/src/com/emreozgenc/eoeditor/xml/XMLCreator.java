package com.emreozgenc.eoeditor.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLCreator {
    
    public XMLCreator() {
        XStream stream = new XStream(new DomDriver());
        
        stream.alias("root", EditorRootObject.class);
        stream.alias("object", EditorObject.class);
        
        EditorRootObject r = new EditorRootObject();
        
        for(int i=0; i<5; i++) {
            EditorObject obj = new EditorObject(i*2, i*3);
            r.objects.add(obj);
        }
        
        String output = stream.toXML(r);
        
        String path = System.getProperty("user.home");
        path = path + "/Desktop/output.xml";
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(output);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
        }
        
        EditorRootObject r2 = (EditorRootObject) stream.fromXML(new File(path));
        
        for(EditorObject obj : r2.objects) {
            System.out.println(obj.posX);
        }
        
    }
    
}
