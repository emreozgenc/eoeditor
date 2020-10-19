package com.emreozgenc.eoeditor.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class EOEditorXMLCreator {
    private XStream xs;
    private EOEditorRootObjectXML root;
    
    public EOEditorXMLCreator() {
        xs = new XStream(new StaxDriver());
    }
}
