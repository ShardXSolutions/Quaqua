/*
 * Copyright (c) 2014 Alan Snyder.
 * All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement. For details see accompanying license terms.
 */
package ke.co.shardx.zuhura.mavericks.filechooser;

import ke.co.shardx.zuhura.lion.filechooser.LionColumnView;
import javax.swing.*;

/**
  * The file chooser column view for Mavericks.
*/

public class MavericksColumnView extends LionColumnView {

    public MavericksColumnView(JFileChooser fc) {
        super(fc);

        browser.setFixedCellWidth(207);
    }
}
