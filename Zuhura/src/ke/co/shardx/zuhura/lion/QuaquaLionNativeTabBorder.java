/*
 * @(#)QuaquaLionNativeTabBorder.java 
 * 
 * Copyright (c) 2011-2013 Werner Randelshofer, Switzerland.
 * All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with Werner Randelshofer.
 * For details see accompanying license terms.
 */
package ke.co.shardx.zuhura.lion;

import ke.co.shardx.zuhura.border.QuaquaNativeBorder;
import ke.co.shardx.zuhura.osx.OSXAquaPainter.Widget;
import java.awt.Insets;

/**
 * {@code QuaquaLionNativeTabBorder}.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class QuaquaLionNativeTabBorder extends QuaquaNativeBorder {

    public QuaquaLionNativeTabBorder(int cacheSize, Insets imageInsets, Insets borderInsets) {
        super(cacheSize, Widget.tab, imageInsets, borderInsets);
    }

    public QuaquaLionNativeTabBorder(Insets imageInsets, Insets borderInsets) {
        super(Widget.tab,  imageInsets, borderInsets);
    }

    public QuaquaLionNativeTabBorder(int cacheSize) {
        super(cacheSize, Widget.tab);
    }

    public QuaquaLionNativeTabBorder() {
        super(Widget.tab);
    }
    
}
