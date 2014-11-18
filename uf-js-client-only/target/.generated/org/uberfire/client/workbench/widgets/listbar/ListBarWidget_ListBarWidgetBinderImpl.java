package org.uberfire.client.workbench.widgets.listbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel;

public class ListBarWidget_ListBarWidgetBinderImpl implements UiBinder<org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel, org.uberfire.client.workbench.widgets.listbar.ListBarWidget>, org.uberfire.client.workbench.widgets.listbar.ListBarWidget.ListBarWidgetBinder {


  public org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel createAndBindUi(final org.uberfire.client.workbench.widgets.listbar.ListBarWidget owner) {


    return new Widgets(owner).get_container();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.uberfire.client.workbench.widgets.listbar.ListBarWidget owner;


    public Widgets(final org.uberfire.client.workbench.widgets.listbar.ListBarWidget owner) {
      this.owner = owner;
      build_style();  // generated css resource must be always created. Type: GENERATED_CSS. Precedence: 1
    }


    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 1 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle) GWT.create(org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenBundle.class);
      // Setup section.


      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for res called 1 times. Type: IMPORTED. Build precedence: 1.
     */
    private org.uberfire.client.resources.WorkbenchResources get_res() {
      return build_res();
    }
    private org.uberfire.client.resources.WorkbenchResources build_res() {
      // Creation section.
      final org.uberfire.client.resources.WorkbenchResources res = (org.uberfire.client.resources.WorkbenchResources) GWT.create(org.uberfire.client.resources.WorkbenchResources.class);
      // Setup section.


      return res;
    }

    /**
     * Getter for style called 8 times. Type: GENERATED_CSS. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style style;
    private org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style get_style() {
      return style;
    }
    private org.uberfire.client.workbench.widgets.listbar.ListBarWidget_ListBarWidgetBinderImpl_GenCss_style build_style() {
      // Creation section.
      style = get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay().style();
      // Setup section.
      style.ensureInjected();


      return style;
    }

    /**
     * Getter for container called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel get_container() {
      return build_container();
    }
    private org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel build_container() {
      // Creation section.
      final org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel container = (org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel) GWT.create(org.uberfire.client.workbench.widgets.listbar.ResizeFocusPanel.class);
      // Setup section.
      container.add(get_f_FlowPanel1());


      owner.container = container;

      return container;
    }

    /**
     * Getter for f_FlowPanel1 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel1() {
      return build_f_FlowPanel1();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel1 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel1.add(get_header());
      f_FlowPanel1.add(get_content());
      f_FlowPanel1.setStyleName("" + get_style().fillParent() + "");


      return f_FlowPanel1;
    }

    /**
     * Getter for header called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_header() {
      return build_header();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_header() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel header = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      header.add(get_menuArea());
      header.add(get_f_FlowPanel2());
      header.setStyleName("" + get_res().CSS().listbar() + "");


      owner.header = header;

      return header;
    }

    /**
     * Getter for menuArea called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_menuArea() {
      return build_menuArea();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_menuArea() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel menuArea = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      menuArea.add(get_contextMenu());
      menuArea.add(get_closeButtonContainer());
      menuArea.add(get_dropdownCaretContainer());
      menuArea.setStyleName("" + get_style().pullRight() + " " + get_style().better_margin() + "");


      owner.menuArea = menuArea;

      return menuArea;
    }

    /**
     * Getter for contextMenu called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_contextMenu() {
      return build_contextMenu();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_contextMenu() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel contextMenu = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      contextMenu.setStyleName("" + get_style().inline() + " " + get_style().better_margin() + "");


      owner.contextMenu = contextMenu;

      return contextMenu;
    }

    /**
     * Getter for closeButtonContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.ButtonGroup get_closeButtonContainer() {
      return build_closeButtonContainer();
    }
    private com.github.gwtbootstrap.client.ui.ButtonGroup build_closeButtonContainer() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ButtonGroup closeButtonContainer = (com.github.gwtbootstrap.client.ui.ButtonGroup) GWT.create(com.github.gwtbootstrap.client.ui.ButtonGroup.class);
      // Setup section.
      closeButtonContainer.add(get_closeButton());


      owner.closeButtonContainer = closeButtonContainer;

      return closeButtonContainer;
    }

    /**
     * Getter for closeButton called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.Button get_closeButton() {
      return build_closeButton();
    }
    private com.github.gwtbootstrap.client.ui.Button build_closeButton() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button closeButton = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      closeButton.setIcon(com.github.gwtbootstrap.client.ui.constants.IconType.REMOVE);
      closeButton.setSize(com.github.gwtbootstrap.client.ui.resources.ButtonSize.MINI);


      owner.closeButton = closeButton;

      return closeButton;
    }

    /**
     * Getter for dropdownCaretContainer called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.ButtonGroup get_dropdownCaretContainer() {
      return build_dropdownCaretContainer();
    }
    private com.github.gwtbootstrap.client.ui.ButtonGroup build_dropdownCaretContainer() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.ButtonGroup dropdownCaretContainer = (com.github.gwtbootstrap.client.ui.ButtonGroup) GWT.create(com.github.gwtbootstrap.client.ui.ButtonGroup.class);
      // Setup section.
      dropdownCaretContainer.add(get_dropdownCaret());


      owner.dropdownCaretContainer = dropdownCaretContainer;

      return dropdownCaretContainer;
    }

    /**
     * Getter for dropdownCaret called 1 times. Type: DEFAULT. Build precedence: 6.
     */
    private com.github.gwtbootstrap.client.ui.DropdownButton get_dropdownCaret() {
      return build_dropdownCaret();
    }
    private com.github.gwtbootstrap.client.ui.DropdownButton build_dropdownCaret() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.DropdownButton dropdownCaret = (com.github.gwtbootstrap.client.ui.DropdownButton) GWT.create(com.github.gwtbootstrap.client.ui.DropdownButton.class);
      // Setup section.
      dropdownCaret.setSize(com.github.gwtbootstrap.client.ui.resources.ButtonSize.MINI);


      owner.dropdownCaret = dropdownCaret;

      return dropdownCaret;
    }

    /**
     * Getter for f_FlowPanel2 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_f_FlowPanel2() {
      return build_f_FlowPanel2();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_f_FlowPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel f_FlowPanel2 = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.
      f_FlowPanel2.add(get_contextDisplay());
      f_FlowPanel2.add(get_title());
      f_FlowPanel2.setStyleName("" + get_style().inline() + "");


      return f_FlowPanel2;
    }

    /**
     * Getter for contextDisplay called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.github.gwtbootstrap.client.ui.Button get_contextDisplay() {
      return build_contextDisplay();
    }
    private com.github.gwtbootstrap.client.ui.Button build_contextDisplay() {
      // Creation section.
      final com.github.gwtbootstrap.client.ui.Button contextDisplay = (com.github.gwtbootstrap.client.ui.Button) GWT.create(com.github.gwtbootstrap.client.ui.Button.class);
      // Setup section.
      contextDisplay.setIcon(com.github.gwtbootstrap.client.ui.constants.IconType.REORDER);
      contextDisplay.setSize(com.github.gwtbootstrap.client.ui.resources.ButtonSize.MINI);


      owner.contextDisplay = contextDisplay;

      return contextDisplay;
    }

    /**
     * Getter for title called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.SimplePanel get_title() {
      return build_title();
    }
    private com.google.gwt.user.client.ui.SimplePanel build_title() {
      // Creation section.
      final com.google.gwt.user.client.ui.SimplePanel title = (com.google.gwt.user.client.ui.SimplePanel) GWT.create(com.google.gwt.user.client.ui.SimplePanel.class);
      // Setup section.
      title.setStyleName("" + get_style().inline() + " " + get_style().title() + "");


      owner.title = title;

      return title;
    }

    /**
     * Getter for content called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.FlowPanel get_content() {
      return build_content();
    }
    private com.google.gwt.user.client.ui.FlowPanel build_content() {
      // Creation section.
      final com.google.gwt.user.client.ui.FlowPanel content = (com.google.gwt.user.client.ui.FlowPanel) GWT.create(com.google.gwt.user.client.ui.FlowPanel.class);
      // Setup section.


      owner.content = content;

      return content;
    }
  }
}
