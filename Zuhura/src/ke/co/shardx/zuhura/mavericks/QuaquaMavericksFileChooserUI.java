/*
 * Copyright (c) 2014 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement. For details see accompanying license terms.
 */
package ke.co.shardx.zuhura.mavericks;

import ke.co.shardx.zuhura.filechooser.CellRenderer;
import ke.co.shardx.zuhura.filechooser.ColumnView;
import ke.co.shardx.zuhura.lion.QuaquaLionFileChooserUI;
import ke.co.shardx.zuhura.mavericks.filechooser.MavericksColumnView;
import ke.co.shardx.zuhura.mavericks.filechooser.MavericksFileRenderer;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * A replacement for the AquaFileChooserUI. Emulates the list and column views of the native Aqua user interface on Mac
 * OS X 10.9 (Mavericks).
 */

public class QuaquaMavericksFileChooserUI extends QuaquaLionFileChooserUI {

    public static ComponentUI createUI(JComponent c) {
        return new QuaquaMavericksFileChooserUI((JFileChooser) c);
    }

    public QuaquaMavericksFileChooserUI(JFileChooser filechooser) {
        super(filechooser);
    }
    
    @Override
    protected CellRenderer createFileRenderer(JFileChooser fc) {
        return new MavericksFileRenderer(
                fc,
                UIManager.getIcon("Browser.expandingIcon"),
                UIManager.getIcon("Browser.expandedIcon"),
                UIManager.getIcon("Browser.selectedExpandingIcon"),
                UIManager.getIcon("Browser.selectedExpandedIcon"),
                UIManager.getIcon("Browser.focusedSelectedExpandingIcon"),
                UIManager.getIcon("Browser.focusedSelectedExpandedIcon"));
    }
    
    @Override
    protected ColumnView createColumnView(JFileChooser fc) {
        return new MavericksColumnView(fc);
    }
}
