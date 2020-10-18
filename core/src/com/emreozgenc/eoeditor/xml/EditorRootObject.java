
package com.emreozgenc.eoeditor.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

public class EditorRootObject {
    public List<EditorObject> objects;
    
    public EditorRootObject() {
        objects = new ArrayList<>();
    }
}
