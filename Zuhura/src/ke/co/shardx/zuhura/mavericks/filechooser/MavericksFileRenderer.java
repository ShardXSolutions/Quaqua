/*
 * @(#)LeopardFileRenderer.java
 *
 * Copyright (c) 2007-2013 Werner Randelshofer, Switzerland.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package ke.co.shardx.zuhura.mavericks.filechooser;

import ke.co.shardx.zuhura.osx.OSXFile;
import javax.swing.*;

import ke.co.shardx.zuhura.ext.batik.ext.awt.LinearGradientPaint;
import ke.co.shardx.zuhura.icon.EmptyIcon;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * The FileRenderer is used to render a file in the JBrowser of one of the
 * Quaqua FileChooserUI's.
 *
 * @author  Werner Randelshofer
 * @version $Id$
 */
public class MavericksFileRenderer extends JLabel implements ListCellRenderer, CellRenderer {

    private Color labelForeground, labelDisabledForeground;
    private Icon selectedExpandingIcon;
    private Icon selectedExpandedIcon;
    private Icon focusedSelectedExpandingIcon;
    private Icon focusedSelectedExpandedIcon;
    private Icon expandingIcon;
    private Icon expandedIcon;
    private Icon emptyIcon;
    private Icon aliasBadgeIcon;
    private JFileChooser fileChooser;
    private int textIconGap;
    private int textArrowIconGap;
    private Icon icon;
    private String text;
    private Icon arrowIcon;
    private Color labelColor, labelBrightColor;
    private boolean isSelected;
    private boolean isActive;
    private boolean isGrayed;
    private boolean isAlias;
    private boolean isListView;
    private double labelRadius = 4.8;

    public MavericksFileRenderer(JFileChooser fileChooser,
            Icon expandingIcon, Icon expandedIcon,
            Icon selectedExpandingIcon, Icon selectedExpandedIcon,
            Icon focusedSelectedExpandingIcon, Icon focusedSelectedExpandedIcon) {
        this.fileChooser = fileChooser;
        this.expandingIcon = expandingIcon;
        this.expandedIcon = expandedIcon;
        this.selectedExpandingIcon = selectedExpandingIcon;
        this.selectedExpandedIcon = selectedExpandedIcon;
        this.focusedSelectedExpandingIcon = focusedSelectedExpandingIcon;
        this.focusedSelectedExpandedIcon = focusedSelectedExpandedIcon;
        this.textIconGap = UIManager.getInt("FileChooser.browserCellTextIconGap");
        this.textArrowIconGap = UIManager.getInt("FileChooser.browserCellTextArrowIconGap");

        emptyIcon = new EmptyIcon(expandedIcon.getIconWidth(), expandedIcon.getIconHeight());
        aliasBadgeIcon = UIManager.getIcon("FileView.aliasBadgeIcon");

        labelForeground = UIManager.getColor("Label.foreground");
        labelDisabledForeground = UIManager.getColor("Label.disabledForeground");

        setOpaque(true);
    }

    // Overridden for performance reasons.
    @Override
    public void validate() {
    }

    @Override
    public void revalidate() {
    }

    @Override
    public void repaint(long tm, int x, int y, int width, int height) {
    }

    @Override
    public void repaint(Rectangle r) {
    }

    @Override
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, short oldValue, short newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, long oldValue, long newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, float oldValue, float newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, double oldValue, double newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected,
            boolean cellHasFocus) {
        return getCellRendererComponent(list, value, isSelected, cellHasFocus, false);
    }

    @Override
    public Component getCellRendererComponent(JComponent container, Object value, boolean isSelected, boolean cellHasFocus) {
        return getCellRendererComponent(container, value, isSelected, cellHasFocus, true);
    }

    protected Component getCellRendererComponent(JComponent container,
        Object value,
        boolean isSelected,
        boolean cellHasFocus,
        boolean isListView) {

        this.isListView = isListView;

        if (!(value instanceof FileInfo)) {
            return this;
        }

        FileInfo info = (FileInfo) value;

        isGrayed = !info.isAcceptable() && !info.isTraversable();

        labelColor = OSXFile.getLabelColor(info.getFileLabel(), (isGrayed) ? 2 : 0);
        labelBrightColor = OSXFile.getLabelColor(info.getFileLabel(), (isGrayed) ? 3 : 1);

        this.isSelected = isSelected;
        this.isActive = container.isEnabled() && QuaquaUtilities.isFocused(container);

        if (this.isSelected) {
            if (isActive) {
                setBackground(UIManager.getColor("Browser.selectionBackground"));
                setForeground(UIManager.getColor("Browser.selectionForeground"));
            } else {
                setBackground(UIManager.getColor("Browser.inactiveSelectionBackground"));
                setForeground(UIManager.getColor("Browser.inactiveSelectionForeground"));
            }
        } else {
            //setBackground((labelColor == null) ? container.getBackground() : labelColor);
            setBackground(container.getBackground());
            setForeground((isGrayed) ? labelDisabledForeground : labelForeground);
        }

        if (!isListView) {
            boolean useUnselectedArrow = UIManager.getBoolean("FileChooser.browserUseUnselectedExpandIconForLabeledFile");
            if (this.isSelected && (!useUnselectedArrow || labelColor == null)) {
                if (QuaquaUtilities.isFocused(container)) {
                    arrowIcon = (info.isValidating()) ? focusedSelectedExpandingIcon : focusedSelectedExpandedIcon;
                } else {
                    arrowIcon = (info.isValidating()) ? selectedExpandingIcon : selectedExpandedIcon;
                }
            } else {
                arrowIcon = (info.isValidating()) ? expandingIcon : expandedIcon;
            }

            /*
              Special case: no arrow is displayed for a package even if the package is traversable (an option).
            */

            if (!info.isTraversable() || OSXFile.isVirtualFile(info.lazyGetResolvedFile())) {
                arrowIcon = (labelColor == null) ? null : emptyIcon;
            }
        } else {
            arrowIcon = null;
        }

        text = info.getUserName();
        icon = info.getIcon();

        isAlias = false;
        if (info instanceof FileSystemTreeModel.Node) {
            FileSystemTreeModel.Node n = (FileSystemTreeModel.Node) info;
            isAlias = n.isAlias();
        }

        setOpaque(!isListView);
        setEnabled(container.isEnabled());
        setFont(container.getFont());
        setBorder(isListView ? null : (cellHasFocus) ? UIManager.getBorder(isGrayed ? "FileChooser.browserCellFocusBorderGrayed" : "FileChooser.browserCellFocusBorder") : UIManager.getBorder("FileChooser.browserCellBorder"));
        return this;
    }

    @Override
    protected void paintComponent(Graphics gr) {
        Object oldHints = QuaquaUtilities.beginGraphics((Graphics2D) gr);
        Graphics2D g = (Graphics2D) gr;
        int width = getWidth();

        int height = getHeight();
        Insets insets = getInsets();

        resetRects();

        viewRect.setBounds(0, 0, width, height);
        viewRect.x += insets.left;
        viewRect.y += insets.top;
        viewRect.width -= insets.left + insets.right;
        viewRect.height -= insets.top + insets.bottom;

        Font textFont = getFont();
        g.setFont(textFont);
        FontMetrics textFM = g.getFontMetrics(textFont);
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, width, height);
        }

        String clippedText = layoutRenderer(
                textFM, text,
                icon, arrowIcon,
                viewRect, iconRect, textRect, arrowIconRect, labelRect,
                text == null ? 0 : textIconGap, textArrowIconGap);

        if (labelColor != null) {

                // Paint the label as a filled circle with an outline
                double r = labelRadius;
                Shape s = new Ellipse2D.Double(labelRect.x, labelRect.y, r * 2, r * 2);
                g.setPaint(labelColor);
                g.fill(s);
                g.setPaint(isSelected && isActive ? Color.WHITE : Color.LIGHT_GRAY);
                g.draw(s);
            
            
        }

        if (icon != null) {
            icon.paintIcon(this, g, iconRect.x, iconRect.y);
        }

        if (isAlias && aliasBadgeIcon != null) {
            aliasBadgeIcon.paintIcon(this, g, iconRect.x, iconRect.y);
        }

        if (clippedText != null && !clippedText.equals("")) {
            g.setColor(getForeground());
            g.drawString(clippedText, textRect.x, textRect.y + textFM.getAscent());
        }

        if (arrowIcon != null) {
            arrowIcon.paintIcon(this, g, arrowIconRect.x, arrowIconRect.y);
        }

        QuaquaUtilities.endGraphics((Graphics2D) g, oldHints);
    }
    /**
     * The following variables are used for laying out the renderer.
     * This variables are static, because FileRenderer is always called
     * from the EventDispatcherThread, and because we do not use them in a
     * reentrant context, where a FileRenderer instance enters a method of
     * another FileRenderer instance.
     */
    private static final Rectangle zeroRect = new Rectangle(0, 0, 0, 0);
    private static Rectangle iconRect = new Rectangle();
    private static Rectangle textRect = new Rectangle();
    private static Rectangle arrowIconRect = new Rectangle();
    private static Rectangle viewRect = new Rectangle();
    private static Rectangle labelRect = new Rectangle();
    /** r is used in getPreferredSize and in paintComponent. It must not be
     * used in any method called by one of these.
     */
    private static Rectangle r = new Rectangle();

    private void resetRects() {
        iconRect.setBounds(zeroRect);
        textRect.setBounds(zeroRect);
        arrowIconRect.setBounds(zeroRect);
        labelRect.setBounds(zeroRect);
        viewRect.setBounds(0, 0, 32767, 32767);
        r.setBounds(zeroRect);
    }

    @Override
    public Dimension getPreferredSize() {
        Font textFont = getFont();
        FontMetrics textFM = getFontMetrics(textFont);

        resetRects();

        layoutRenderer(
                textFM, text,
                icon, arrowIcon,
                viewRect,
                iconRect,
                textRect,
                arrowIconRect,
                labelRect,
                text == null ? 0 : textIconGap, textArrowIconGap);

        r.setBounds(textRect);
        r = SwingUtilities.computeUnion(iconRect.x, iconRect.y, iconRect.width,
                iconRect.height, r);

        boolean isUseArrow = arrowIcon != null;
        if (isUseArrow) {
            r.width += arrowIconRect.width + textArrowIconGap;
        }

        if (labelColor != null) {
            r.width += labelRect.width + textArrowIconGap;
        }

        Insets insets = getInsets();
        if (insets != null) {
            r.width += insets.left + insets.right;
            r.height += insets.top + insets.bottom;
        }

        return r.getSize();
    }

    /**
     * Layouts the components of the renderer.
     */
    private String layoutRenderer(
            FontMetrics textFM, String text,
            Icon icon, Icon arrowIcon,
            Rectangle viewRect, Rectangle iconRect,
            Rectangle textRect,
            Rectangle arrowIconRect,
            Rectangle labelRect,
            int textIconGap, int textArrowIconGap) {

        boolean isUseArrow = arrowIcon != null;

        if (isUseArrow) {
            arrowIconRect.width = arrowIcon.getIconWidth();
            arrowIconRect.height = arrowIcon.getIconHeight();
            arrowIconRect.x = viewRect.x + viewRect.width - arrowIconRect.width;
            viewRect.width -= arrowIconRect.width + textArrowIconGap;
        }

        if (labelColor != null) {
            int d = (int) Math.ceil(2 * labelRadius);
            labelRect.width = d;
            labelRect.height = d;
            labelRect.x = viewRect.x + viewRect.width - labelRect.width;
            viewRect.width -= labelRect.width + textArrowIconGap;
        }

        text = QuaquaUtilities.layoutCompoundLabel(
                this, textFM, text,
                icon, SwingConstants.CENTER, SwingConstants.LEFT,
                SwingConstants.CENTER, SwingConstants.RIGHT,
                viewRect, iconRect, textRect,
                textIconGap);

        if (isUseArrow) {
            viewRect.width += arrowIconRect.width + textArrowIconGap;
        }

        if (labelColor != null) {
            viewRect.width += labelRect.width + textArrowIconGap;
        }

        Rectangle jLabelRect = iconRect.union(textRect);

        if (isUseArrow) {
            arrowIconRect.y = (viewRect.y + jLabelRect.height / 2 - arrowIconRect.height / 2);
        }

        if (labelColor != null) {
            labelRect.y = (viewRect.y + jLabelRect.height / 2 - labelRect.height / 2);
        }

        if (!QuaquaUtilities.isLeftToRight(this)) {
            int width = viewRect.width;
            iconRect.x = width - (iconRect.x + iconRect.width);
            textRect.x = width - (textRect.x + textRect.width);
            arrowIconRect.x = width - (arrowIconRect.x + arrowIconRect.width);
            labelRect.x = width - (labelRect.x + labelRect.width);
        }

        return text;
    }

    
}
