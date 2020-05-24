/*
 * Copyright (c) 2014 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the license agreement. For details see
 * accompanying license terms.
 */
package ke.co.shardx.zuhura.leopard.filechooser;

import ke.co.shardx.zuhura.JBrowser;
import ke.co.shardx.zuhura.QuaquaScrollPaneUI;
import ke.co.shardx.zuhura.filechooser.QuaquaFileChooserBrowserListUI;
import ke.co.shardx.zuhura.filechooser.QuaquaFileChooserListMouseBehavior;

import javax.swing.*;
import javax.swing.plaf.ListUI;
import java.io.File;

/**
 * The browser in a file chooser. Implements special behavior for clicking on an ordinary file in a Save panel.
 */
public class QuaquaFileChooserBrowser extends JBrowser {
    protected JFileChooser fc;

    public QuaquaFileChooserBrowser(JFileChooser fc) {
        this.fc = fc;
    }

    @Override
    protected ListUI getColumnListUI(ListUI basicUI) {
        QuaquaFileChooserBrowserListUI ui = new QuaquaFileChooserBrowserListUI(fc);
        ui.setFileSelectionHandler(new QuaquaFileChooserListMouseBehavior.FileSelectionHandler() {
            @Override
            public void fileSelected(File f) {
                QuaquaFileChooserBrowser.this.fileSelectedInSavePanel(f);
            }
        });
        return ui;
    }

    @Override
    protected JScrollPane createScrollPane(JComponent c, int columnIndex) {
        JScrollPane sp = super.createScrollPane(c, columnIndex);
        sp.setUI(new QuaquaScrollPaneUI());
        sp.setBorder(null);
        sp.setFocusable(false);
        sp.getVerticalScrollBar().setFocusable(false);
        sp.getHorizontalScrollBar().setFocusable(false);
        return sp;
    }

    protected void fileSelectedInSavePanel(File f) {
    }
}
