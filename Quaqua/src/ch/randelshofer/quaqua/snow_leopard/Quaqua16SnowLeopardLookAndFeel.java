/*
 * @(#)Quaqua16SnowLeopardLookAndFeel.java
 *
 * Copyright (c) 2009 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * The copyright of this software is owned by Werner Randelshofer. 
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * Werner Randelshofer. For details see accompanying license terms. 
 */
package ch.randelshofer.quaqua.snow_leopard;

import ch.randelshofer.quaqua.leopard.*;
import ch.randelshofer.quaqua.color.InactivatableColorUIResource;
import ch.randelshofer.quaqua.color.GradientColor;
import ch.randelshofer.quaqua.color.AlphaColorUIResource;
import ch.randelshofer.quaqua.border.BackgroundBorderUIResource;
import ch.randelshofer.quaqua.*;
import ch.randelshofer.quaqua.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;

/**
 * The Quaqua16SnowLeopardLookAndFeel provides bug fixes and enhancements for Apple's
 * Aqua Look and Feel for Java 1.6 on Mac OS X 10.6 (Snow Leopard). 
 * <p>
 * The Quaqua Look and Feel can not be used on other platforms than Mac OS X.
 * <p>
 * <h3>Usage</h3>
 * Please use the <code>QuaquaManager</code> to activate this look and feel in
 * your application. Or use the generic <code>QuaquaLookAndFeel</code>. Both
 * are designed to autodetect the appropriate Quaqua Look and Feel
 * implementation.
 * <p>
 * 
 * @author Werner Randelshofer
 * @version $Id$
 */
public class Quaqua16SnowLeopardLookAndFeel extends BasicQuaquaLookAndFeel {

    /**
     * Creates a new instance.
     */
    public Quaqua16SnowLeopardLookAndFeel() {
        // Our target look and feel is Apple's AquaLookAndFeel.
        super("apple.laf.AquaLookAndFeel");
    }

    /**
     * Creates a new instance.
     */
    protected Quaqua16SnowLeopardLookAndFeel(String className) {
        super(className);
    }

    /**
     * Return a one line description of this look and feel implementation,
     * e.g. "The CDE/Motif Look and Feel".   This string is intended for
     * the user, e.g. in the title of a window or in a ToolTip message.
     */
    public String getDescription() {
        return "The Quaqua Snow Leopard Look and Feel " +
                QuaquaManager.getVersion() +
                " for J2SE 6";
    }

    /**
     * Return a short string that identifies this look and feel, e.g.
     * "CDE/Motif".  This string should be appropriate for a menu item.
     * Distinct look and feels should have different names, e.g.
     * a subclass of MotifLookAndFeel that changes the way a few components
     * are rendered should be called "CDE/Motif My Way"; something
     * that would be useful to a user trying to select a L&F from a list
     * of names.
     */
    @Override
    public String getName() {
        return "Quaqua Snow Leopard";
    }

    /**
     * Initialize the uiClassID to BasicComponentUI mapping.
     * The JComponent classes define their own uiClassID constants
     * (see AbstractComponent.getUIClassID).  This table must
     * map those constants to a BasicComponentUI class of the
     * appropriate type.
     *
     * @see #getDefaults
     */
    @Override
    protected void initClassDefaults(UIDefaults table) {
        String basicPrefix = "javax.swing.plaf.basic.Basic";
        String quaquaPrefix = "ch.randelshofer.quaqua.Quaqua";
        String quaquaJaguarPrefix = "ch.randelshofer.quaqua.jaguar.QuaquaJaguar";
        String quaquaPantherPrefix = "ch.randelshofer.quaqua.panther.QuaquaPanther";
        String quaqua14PantherPrefix = "ch.randelshofer.quaqua.panther.Quaqua14Panther";
        String quaquaLeopardPrefix = "ch.randelshofer.quaqua.leopard.QuaquaLeopard";

        // NOTE: Change code below, to override different
        // UI classes of the target look and feel.
        Object[] uiDefaults = {
            "BrowserUI", quaquaPrefix + "BrowserUI",
            "ButtonUI", quaquaPrefix + "ButtonUI",
            "CheckBoxUI", quaquaPrefix + "CheckBoxUI",
            "ColorChooserUI", quaquaPrefix + "14" + "ColorChooserUI",
            "FileChooserUI", quaquaLeopardPrefix + "FileChooserUI",
            "FormattedTextFieldUI", quaquaPrefix + "FormattedTextFieldUI",
            "RadioButtonUI", quaquaPrefix + "RadioButtonUI",
            "ToggleButtonUI", quaquaPrefix + "ToggleButtonUI",
            "SeparatorUI", quaquaPantherPrefix + "SeparatorUI",
            "MenuSeparatorUI", quaquaPantherPrefix + "SeparatorUI",
            //  "ProgressBarUI", basicPrefix + "ProgressBarUI",
            "ScrollBarUI", quaquaPrefix + "ScrollBarUI",
            "ScrollPaneUI", quaquaPrefix + "ScrollPaneUI",
            "SplitPaneUI", quaquaPrefix + "SplitPaneUI",
            "SliderUI", quaquaPrefix + "SliderUI",
            "SpinnerUI", quaquaPrefix + "14" + "SpinnerUI",
            "ToolBarSeparatorUI", quaquaPrefix + "ToolBarSeparatorUI",
            "PopupMenuSeparatorUI", quaquaPantherPrefix + "SeparatorUI",
            "TextAreaUI", quaquaPrefix + "TextAreaUI",
            "TextFieldUI", quaquaPrefix + "TextFieldUI",
            "PasswordFieldUI", quaquaPrefix + "PasswordFieldUI",
            "TextPaneUI", quaquaPrefix + "TextPaneUI",
            "EditorPaneUI", quaquaPrefix + "EditorPaneUI",
            "TreeUI", quaquaPrefix + "TreeUI",
            "LabelUI", quaquaPrefix + "LabelUI",
            "ListUI", quaquaPrefix + "ListUI",
            "TabbedPaneUI", quaqua14PantherPrefix + "TabbedPaneUI",
            "ToolBarUI", quaquaPrefix + "ToolBarUI",
            // "ToolTipUI", basicPrefix + "ToolTipUI",
            "ComboBoxUI", quaquaPrefix + "ComboBoxUI",
            "TableUI", quaquaPrefix + "TableUI",
            "TableHeaderUI", quaquaPrefix + "TableHeaderUI",
            // "InternalFrameUI", basicPrefix + "InternalFrameUI",
            //"DesktopPaneUI", quaquaPrefix + "DesktopPaneUI",
            //"DesktopIconUI", basicPrefix + "DesktopIconUI",
            "OptionPaneUI", quaquaPrefix + "OptionPaneUI",
            "PanelUI", quaquaPrefix + "PanelUI",
            "ViewportUI", quaquaPrefix + "ViewportUI",
            // Do not create a RootPaneUI on our own, unless we also
            // create our own ButtonUI. Aqua's RootPaneUI is responsible
            // for updating the border of the ButtonUI, when it is the default,
            // and for propagating window activation/dectivation events to
            // all the child components of a window.
            "RootPaneUI", quaquaPrefix + "14RootPaneUI",};
        putDefaults(table, uiDefaults);

        /*
        // Popup menu fix only works fully when we have all AWT event permission
        SecurityManager security = System.getSecurityManager();
        try {
        if (security != null) {
        security.checkPermission(sun.security.util.SecurityConstants.ALL_AWT_EVENTS_PERMISSION);
        }
        uiDefaults = new Object[] {
        "PopupMenuUI", quaquaPrefix + "PopupMenuUI",
        };
        } catch (SecurityException e) {
        // do nothing
        }*/
        uiDefaults = new Object[]{
                    "PopupMenuUI", basicPrefix + "PopupMenuUI",};
        putDefaults(table, uiDefaults);


        // FIXME Menu related workarounds work only if useScreenMenuBar is off.
        if (!isUseScreenMenuBar()) {
            uiDefaults = new Object[]{
                        "MenuBarUI", quaquaPrefix + "MenuBarUI",
                        "MenuUI", quaquaPrefix + "MenuUI",
                        "MenuItemUI", quaquaPrefix + "MenuItemUI",
                        "CheckBoxMenuItemUI", quaquaPrefix + "MenuItemUI",
                        "RadioButtonMenuItemUI", quaquaPrefix + "MenuItemUI"
                    };
            putDefaults(table, uiDefaults);
        }
    }

    protected boolean isBrushedMetal() {
        String property;
        property = QuaquaManager.getProperty("apple.awt.brushMetalLook", "false");
        return property.equals("true");
    }

    protected boolean isUseScreenMenuBar() {
        String property;
        property = QuaquaManager.getProperty("apple.laf.useScreenMenuBar", "false");
        return property.equals("true");
    }

    @Override
    protected void initFontDefaults(UIDefaults table) {
        super.initFontDefaults(table);

        Object emphasizedSmallSystemFont = new UIDefaults.ProxyLazyValue(
                "javax.swing.plaf.FontUIResource",
                null,
                new Object[]{"Lucida Grande", new Integer(Font.BOLD), new Integer(11)});

        Object[] uiDefaults = {
            "FileChooser.previewLabelFont", emphasizedSmallSystemFont,};
        putDefaults(table, uiDefaults);
    }

    @Override
    protected void initSystemColorDefaults(UIDefaults table) {
        super.initSystemColorDefaults(table);
        /*
        if (QuaquaManager.getDesign() != QuaquaManager.TIGER) {
        boolean isBrushedMetal = isBrushedMetal();
        Object controlBackground = (isBrushedMetal)
        ? table.get("control")
        : makeTextureColor(0xf4f4f4, pantherDir+"Panel.texture.png");
        Object toolBarBackground = (isBrushedMetal)
        ? table.get("ToolBar.background")
        : makeTextureColor(0xf4f4f4, pantherDir+"ToolBar.texture.png");
        Object menuBackground = (isBrushedMetal)
        ? table.get("menu")
        : makeTextureColor(0xf4f4f4, pantherDir+"MenuBar.texture.png");
        Object menuHighlight = makeTextureColor(0x3471cf, pantherDir+"MenuBar.texture.S.png");

        Object[] uiDefaults = {
        "window", controlBackground, // Default color for the interior of windows
        "control", controlBackground, // Default color for controls (buttons, sliders, etc)
        "menu", menuBackground, // Default color for the interior of menus
        "menuHighlight", menuHighlight, // Default color for the interior of menus

        // Quaqua specific 'system' colors
        "listHighlight", table.get("textHighlight"), // List background color when selected
        "listHighlightText", table.get("textHighlightText"), // List color when selected
        "listHighlightBorder", new ColorUIResource(0x808080), // List color when selected
        };
        putDefaults(table, uiDefaults);
        }*/

    }

    @Override
    protected void initDesignDefaults(UIDefaults table) {
        Integer zero = new Integer(0);
        Integer one = new Integer(1);
        Integer two = new Integer(2);
        Integer three = new Integer(3);
        Integer four = new Integer(4);
        Integer five = new Integer(5);
        Integer six = new Integer(6);

        boolean isBrushedMetal = isBrushedMetal();
        ColorUIResource disabledForeground = new ColorUIResource(128, 128, 128);
        Object menuBackground = table.get("menuHighlight");
        ColorUIResource menuSelectionForeground = new ColorUIResource(0xffffff);
        Object panelBackground = table.get("control");
        ColorUIResource inactiveSelectionBackground = new ColorUIResource(208, 208, 208);
        Color grayedFocusCellBorderColor = (Color) table.get("listHighlight");

        BorderUIResource.CompoundBorderUIResource browserCellBorder = new BorderUIResource.CompoundBorderUIResource(
                new BorderUIResource.MatteBorderUIResource(0,0,1,0, new ColorUIResource(0xffffff)),
                new BorderUIResource.EmptyBorderUIResource(0,4,1,0));


        String sideBarIconsStart = "/System/Library/CoreServices/CoreTypes.bundle/Contents/Resources/Toolbar";
        String sideBarIconsEnd = "FolderIcon.icns";

        Object[] uiDefaults = {
            "Browser.expandedIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, zero}),
            "Browser.expandingIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, one}),
            "Browser.focusedSelectedExpandedIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, two}),
            "Browser.focusedSelectedExpandingIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, three}),
            "Browser.selectedExpandedIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, four}),
            "Browser.selectedExpandingIcon", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaIconFactory", "createIcon",
            new Object[]{snowLeopardDir + "Browser.disclosureIcons.png", six, Boolean.TRUE, five}),
            //
            //
            "ComboBox.selectionBackground", new GradientColor(new ColorUIResource(0x3875d7), new ColorUIResource(0x5170f6), new ColorUIResource(0x1a43f3)),
            "ComboBox.selectionForeground", menuSelectionForeground,
            "ComboBox.popupBorder", 
            new UIDefaults.ProxyLazyValue("javax.swing.plaf.BorderUIResource$MatteBorderUIResource",
            new Object[]{four,zero,four,zero,new ColorUIResource(0xffffff)}),
            //
            "FileChooser.previewLabelForeground", new ColorUIResource(0x808080),
            "FileChooser.previewValueForeground", new ColorUIResource(0x000000),
            "FileChooser.previewLabelInsets", new InsetsUIResource(1, 0, 0, 4),
            "FileChooser.previewLabelDelimiter", "",
            "FileChooser.cellTipOrigin", new Point(18, 1),
            "FileChooser.splitPaneDividerSize", one,
            "FileChooser.browserCellFocusBorder", browserCellBorder,
            "FileChooser.browserCellFocusBorderGrayed", browserCellBorder,
            "FileChooser.browserCellBorder", browserCellBorder,
            "FileChooser.browserUseUnselectedExpandIconForLabeledFile", Boolean.FALSE,
            "FileChooser.browserCellColorLabelInsets", new InsetsUIResource(0, 1, -1, 1),
            "FileChooser.browserCellSelectedColorLabelInsets", new InsetsUIResource(1,0,0,0),
            "FileChooser.browserCellTextIconGap", six,
            "FileChooser.browserCellTextArrowIconGap", five,
            "FileChooser.sideBarIcon.Applications", makeNativeIcon(sideBarIconsStart + "Apps" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Desktop", makeNativeIcon(sideBarIconsStart + "Desktop" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Documents", makeNativeIcon(sideBarIconsStart + "Documents" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Downloads", makeNativeIcon(sideBarIconsStart + "Downloads" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Library", makeNativeIcon(sideBarIconsStart + "Library" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Movies", makeNativeIcon(sideBarIconsStart + "Movies" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Music", makeNativeIcon(sideBarIconsStart + "Music" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Pictures", makeNativeIcon(sideBarIconsStart + "Pictures" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Public", makeNativeIcon(sideBarIconsStart + "Public" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Sites", makeNativeIcon(sideBarIconsStart + "Sites" + sideBarIconsEnd, 16),
            "FileChooser.sideBarIcon.Utilities", makeNativeIcon(sideBarIconsStart + "Utilities" + sideBarIconsEnd, 16),
            //
            "FileView.computerIcon", makeIcon(getClass(), snowLeopardDir + "FileView.computerIcon.png"),
            "FileView.fileIcon", makeIcon(getClass(), snowLeopardDir + "FileView.fileIcon.png"),
            "FileView.directoryIcon", makeIcon(getClass(), snowLeopardDir + "FileView.directoryIcon.png"),
            "FileView.hardDriveIcon", makeIcon(getClass(), snowLeopardDir + "FileView.hardDriveIcon.png"),
            "FileView.floppyDriveIcon", makeIcon(getClass(), snowLeopardDir + "FileView.floppyDriveIcon.png"),
            //
            "Frame.titlePaneBorders", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.png", new Insets(0, 0, 22, 0), 2, true),
            "Frame.titlePaneBorders.small", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.small.png", new Insets(0, 0, 16, 0), 2, true),
            "Frame.titlePaneBorders.mini", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.mini.png", new Insets(0, 0, 12, 0), 2, true),
            "Frame.titlePaneBorders.vertical", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.vertical.png", new Insets(0, 0, 0, 22), 2, false),
            "Frame.titlePaneBorders.vertical.small", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.vertical.small.png", new Insets(0, 0, 0, 16), 2, false),
            "Frame.titlePaneBorders.vertical.mini", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.vertical.mini.png", new Insets(0, 0, 0, 12), 2, false),
            "Frame.titlePaneEmbossForeground", new AlphaColorUIResource(0x7effffff),
            //
            "InternalFrame.titlePaneBorders", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.png", new Insets(0, 0, 22, 0), 2, true),
            "InternalFrame.titlePaneBorders.small", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.small.png", new Insets(0, 0, 16, 0), 2, true),
            "InternalFrame.titlePaneBorders.mini", makeImageBevelBorders(snowLeopardDir + "Frame.titlePaneBorders.mini.png", new Insets(0, 0, 10, 0), 2, true),
            "InternalFrame.closeIcon", makeFrameButtonStateIcon(snowLeopardDir + "Frame.closeIcons.png", 12),
            "InternalFrame.maximizeIcon", makeFrameButtonStateIcon(snowLeopardDir + "Frame.maximizeIcons.png", 12),
            "InternalFrame.iconifyIcon", makeFrameButtonStateIcon(snowLeopardDir + "Frame.iconifyIcons.png", 12),
            "InternalFrame.closeIcon.small", makeFrameButtonStateIcon(snowLeopardDir + "Frame.closeIcons.small.png", 12),
            "InternalFrame.maximizeIcon.small", makeFrameButtonStateIcon(snowLeopardDir + "Frame.maximizeIcons.small.png", 12),
            "InternalFrame.iconifyIcon.small", makeFrameButtonStateIcon(snowLeopardDir + "Frame.iconifyIcons.small.png", 12),
            "InternalFrame.resizeIcon", makeIcon(getClass(), leopardDir + "Frame.resize.png"),
            //
            "Label.embossForeground", new AlphaColorUIResource(0x7effffff),
            "Label.shadowForeground", new AlphaColorUIResource(0x7e000000),
            //
            "OptionPane.errorIconResource", "/ch/randelshofer/quaqua/leopard/images/OptionPane.errorIcon.png",
            "OptionPane.warningIconResource", "/ch/randelshofer/quaqua/leopard/images/OptionPane.warningIcon.png",
            //
            "PopupMenu.border", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.QuaquaMenuBorder"),
            //
            "Separator.foreground", new ColorUIResource(139, 139, 139),
            "Separator.highlight", new ColorUIResource(243, 243, 243),
            "Separator.shadow", new ColorUIResource(213, 213, 213),
            "Separator.border", new VisualMargin(),
            //
            "TabbedPane.disabledForeground", disabledForeground,
            "TabbedPane.tabInsets", new InsetsUIResource(1, 10, 4, 9),
            "TabbedPane.selectedTabPadInsets", new InsetsUIResource(2, 2, 2, 1),
            "TabbedPane.tabAreaInsets", new InsetsUIResource(4, 16, 0, 16),
            "TabbedPane.contentBorderInsets", new InsetsUIResource(5, 6, 6, 6),
            //"TabbedPane.background", (isBrushedMetal) ? table.get("TabbedPane.background") : makeTextureColor(0xf4f4f4, pantherDir+"Panel.texture.png"),
            "TabbedPane.tabLayoutPolicy", new Integer(isJaguarTabbedPane() ? JTabbedPane.WRAP_TAB_LAYOUT : JTabbedPane.SCROLL_TAB_LAYOUT),
            "TabbedPane.wrap.disabledForeground", disabledForeground,
            "TabbedPane.wrap.tabInsets", new InsetsUIResource(1, 10, 4, 9),
            "TabbedPane.wrap.selectedTabPadInsets", new InsetsUIResource(2, 2, 2, 1),
            "TabbedPane.wrap.tabAreaInsets", new InsetsUIResource(4, 16, 0, 16),
            "TabbedPane.wrap.contentBorderInsets", new InsetsUIResource(2, 3, 3, 3),
            //"TabbedPane.wrap.background", (isBrushedMetal) ? table.get("TabbedPane.background") : makeTextureColor(0xf4f4f4, pantherDir+"Panel.texture.png"),
            "TabbedPane.scroll.selectedTabPadInsets", new InsetsUIResource(0, 0, 0, 0),
            "TabbedPane.scroll.tabRunOverlay", zero,
            "TabbedPane.scroll.tabInsets", new InsetsUIResource(1, 7, 2, 7),
            "TabbedPane.scroll.smallTabInsets", new InsetsUIResource(1, 5, 2, 5),
            "TabbedPane.scroll.outerTabInsets", new InsetsUIResource(1, 11, 2, 11),
            "TabbedPane.scroll.smallOuterTabInsets", new InsetsUIResource(1, 9, 2, 9),
            "TabbedPane.scroll.contentBorderInsets", new InsetsUIResource(2, 2, 2, 2),
            "TabbedPane.scroll.tabAreaInsets", new InsetsUIResource(-2, 16, 1, 16),
            "TabbedPane.scroll.contentBorder", makeImageBevelBorder(
            commonDir + "GroupBox.png", new Insets(7, 7, 7, 7), true),
            "TabbedPane.scroll.emptyContentBorder", makeImageBevelBorder(
            commonDir + "GroupBox.empty.png", new Insets(7, 7, 7, 7), true),
            "TabbedPane.scroll.tabBorders", makeImageBevelBorders(commonDir + "Toggle.borders.png",
            new Insets(8, 10, 15, 10), 10, true),
            "TabbedPane.scroll.tabFocusRing", makeImageBevelBorder(commonDir + "Toggle.focusRing.png",
            new Insets(8, 10, 15, 10), true),
            "TabbedPane.scroll.eastTabBorders", makeImageBevelBorders(commonDir + "Toggle.east.borders.png",
            new Insets(8, 1, 15, 10), 10, true),
            "TabbedPane.scroll.eastTabFocusRing", makeImageBevelBorder(commonDir + "Toggle.east.focusRing.png",
            new Insets(8, 4, 15, 10), true),
            "TabbedPane.scroll.centerTabBorders", makeImageBevelBorders(commonDir + "Toggle.center.borders.png",
            new Insets(8, 0, 15, 1), 10, true),
            "TabbedPane.scroll.centerTabFocusRing", makeImageBevelBorder(commonDir + "Toggle.center.focusRing.png",
            new Insets(8, 4, 15, 4), false),
            "TabbedPane.scroll.westTabBorders", makeImageBevelBorders(commonDir + "Toggle.west.borders.png",
            new Insets(8, 10, 15, 1), 10, true),
            "TabbedPane.scroll.westTabFocusRing", makeImageBevelBorder(commonDir + "Toggle.west.focusRing.png",
            new Insets(8, 10, 15, 4), true),
            //
            "TitledBorder.border", new GroupBox(),
            "TitledBorder.titleColor", new ColorUIResource(0x303030),
            //
            "ToolBar.background", (isBrushedMetal) ? table.get("ToolBar.background") : panelBackground,
            "ToolBarSeparator.foreground", new ColorUIResource(0x808080),
            //
            "Tree.collapsedIcon", makeIcon(getClass(), snowLeopardDir + "Tree.collapsedIcon.png"),
            "Tree.expandedIcon", makeIcon(getClass(), snowLeopardDir + "Tree.expandedIcon.png"),
            "Tree.leafIcon", makeIcon(getClass(), snowLeopardDir + "Tree.leafIcon.png"),
            "Tree.openIcon", makeIcon(getClass(), snowLeopardDir + "Tree.openIcon.png"),
            "Tree.closedIcon", makeIcon(getClass(), snowLeopardDir + "Tree.closedIcon.png"),
            "Tree.background.sideBar", new InactivatableColorUIResource(0xdde4eb, 0xededed),
            "Tree.selectionBorder.sideBar", new UIDefaults.ProxyLazyValue("ch.randelshofer.quaqua.snow_leopard.QuaquaSnowLeopardSideBarSelectionBorder"),
            "Tree.leftChildIndent", new Integer(8), // 7
            "Tree.rightChildIndent", new Integer(12), // 13
            "Tree.icons", makeIcons(snowLeopardDir + "Tree.icons.png", 10, true),
            "Tree.sideBar.icons", makeIcons(snowLeopardDir + "Tree.sideBar.icons.png", 10, true),
            // CHANGE The new properties for the "sideBar" Tree style
            "Tree.sideBarCategory.foreground",
            new InactivatableColorUIResource(0x728194, 0x5f5f5f),
            "Tree.sideBarCategory.selectionForeground",
            new InactivatableColorUIResource(0xffffff, 0xffffff),
            "Tree.sideBarCategory.font", new FontUIResource("Lucida Grande", Font.BOLD, 11),
            "Tree.sideBar.foreground",
            new InactivatableColorUIResource(0x000000, 0x000000),
            "Tree.sideBar.selectionForeground",
            new InactivatableColorUIResource(0xffffff, 0xffffff),
            "Tree.sideBar.font", new FontUIResource("Lucida Grande", Font.PLAIN, 11),
            "Tree.sideBar.selectionFont", new FontUIResource("Lucida Grande", Font.BOLD, 11),};

        putDefaults(table, uiDefaults);

        Border menuBorder = new BackgroundBorderUIResource(new QuaquaLeopardMenuSelectionBorder());

        // FIXME Implement a screen menu bar by myself. We lose too many features here.
        if (isUseScreenMenuBar()) {
            uiDefaults = new Object[]{
                        "CheckBoxMenuItem.checkIcon", makeButtonStateIcon(commonDir + "CheckBoxMenuItem.icons.png", 6, new Rectangle(5, 1, 17, 12)),
                        "CheckBoxMenuItem.border", new BorderUIResource.EmptyBorderUIResource(0, 0, 2, 0),
                        "Menu.checkIcon", makeIcon(getClass(), commonDir + "MenuItem.checkIcon.png", new Point(1, 0)),
                        "Menu.arrowIcon", makeButtonStateIcon(commonDir + "MenuItem.arrowIcons.png", 2, new Rectangle(-6, 1, 6, 12)),
                        "Menu.border", new BorderUIResource.EmptyBorderUIResource(0, 5, 2, 4),
                        "Menu.margin", new InsetsUIResource(0, 8, 0, 8),
                        "Menu.menuPopupOffsetX", new Integer(0),
                        "Menu.menuPopupOffsetY", new Integer(1),
                        "Menu.submenuPopupOffsetX", new Integer(0),
                        "Menu.submenuPopupOffsetY", new Integer(-4),
                        "MenuItem.checkIcon", makeIcon(getClass(), commonDir + "MenuItem.checkIcon.png", new Point(1, 0)),
                        "MenuItem.border", new BorderUIResource.EmptyBorderUIResource(0, 5, 2, 0),
                        "RadioButtonMenuItem.checkIcon", makeButtonStateIcon(commonDir + "RadioButtonMenuItem.icons.png", 6, new Rectangle(5, 0, 17, 12)),
                        "RadioButtonMenuItem.border", new BorderUIResource.EmptyBorderUIResource(0, 0, 2, 0),};
        } else {
            menuBorder = new BackgroundBorderUIResource(new QuaquaLeopardMenuSelectionBorder());
            uiDefaults = new Object[]{
                        "CheckBoxMenuItem.checkIcon", makeButtonStateIcon(commonDir + "CheckBoxMenuItem.icons.png", 6, new Point(0, 1)),
                        "CheckBoxMenuItem.border", menuBorder,
                        "Menu.checkIcon", makeIcon(getClass(), commonDir + "MenuItem.checkIcon.png"),
                        "Menu.arrowIcon", makeButtonStateIcon(commonDir + "MenuItem.arrowIcons.png", 2, new Point(0, 1)),
                        "Menu.margin", new InsetsUIResource(0, 5, 0, 8),
                        "Menu.menuPopupOffsetX", new Integer(0),
                        "Menu.menuPopupOffsetY", new Integer(0),
                        "Menu.submenuPopupOffsetX", new Integer(0),
                        "Menu.submenuPopupOffsetY", new Integer(-4),
                        "Menu.useMenuBarBackgroundForTopLevel", Boolean.TRUE,
                        "Menu.border", menuBorder,
                        //"MenuBar.background", new TextureColorUIResource(0xf4f4f4, getClass().getResource(pantherDir+"MenuBar.texture.png")),
                        //"MenuBar.border", new BorderUIResource.MatteBorderUIResource(0,0,1,0,new Color(128,128,128)),
                        "MenuBar.border", makeImageBevelBackgroundBorder(snowLeopardDir + "MenuBar.border.png", new Insets(18, 0, 2, 0), new Insets(0, 0, 0, 0), true),
                        "MenuBar.selectedBorder", makeImageBevelBackgroundBorder(snowLeopardDir + "MenuBar.selectedBorder.png", new Insets(18, 0, 2, 0), new Insets(0, 0, 0, 0), true),
                        "MenuBar.margin", new InsetsUIResource(1, 8, 2, 8),
                        "MenuBar.shadow", null,
                        "MenuItem.acceleratorSelectionForeground", menuSelectionForeground,
                        "MenuItem.checkIcon", makeIcon(getClass(), commonDir + "MenuItem.checkIcon.png"),
                        "MenuItem.border", menuBorder,
                        "RadioButtonMenuItem.checkIcon", makeButtonStateIcon(commonDir + "RadioButtonMenuItem.icons.png", 6),
                        "RadioButtonMenuItem.border", menuBorder,};
        }
        putDefaults(table, uiDefaults);

    }

    @Override
    public boolean getSupportsWindowDecorations() {
        return true;
    }

    @Override
    public LayoutStyle getLayoutStyle() {
        return new Quaqua16LayoutStyle();

    }
}


