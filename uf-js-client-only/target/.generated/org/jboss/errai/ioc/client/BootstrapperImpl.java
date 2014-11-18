package org.jboss.errai.ioc.client;

import com.allen_sauer.gwt.dnd.client.AbstractDragController;
import com.allen_sauer.gwt.dnd.client.DragController;
import com.allen_sauer.gwt.dnd.client.FiresDragEvents;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.HasDragEndHandlers;
import com.google.gwt.event.dom.client.HasDragEnterHandlers;
import com.google.gwt.event.dom.client.HasDragHandlers;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDragStartHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.HasGestureChangeHandlers;
import com.google.gwt.event.dom.client.HasGestureEndHandlers;
import com.google.gwt.event.dom.client.HasGestureStartHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.HasTouchCancelHandlers;
import com.google.gwt.event.dom.client.HasTouchEndHandlers;
import com.google.gwt.event.dom.client.HasTouchMoveHandlers;
import com.google.gwt.event.dom.client.HasTouchStartHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.logical.shared.HasBeforeSelectionHandlers;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.AutoDirectionHandler.Target;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.EventPreview;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasAnimation;
import com.google.gwt.user.client.ui.HasConstrainedValue;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasFocus;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.SourcesFocusEvents;
import com.google.gwt.user.client.ui.SourcesKeyboardEvents;
import com.google.gwt.user.client.ui.SourcesMouseEvents;
import com.google.gwt.user.client.ui.SourcesPopupEvents;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.inject.Named;
import javax.inject.Provider;
import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.api.ClientMessageBus;
import org.jboss.errai.bus.client.api.Subscription;
import org.jboss.errai.bus.client.framework.ClientMessageBusImpl;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.extension.InitVotes;
import org.jboss.errai.common.client.api.interceptor.RemoteCallInterceptor;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.api.RestErrorCallback;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.container.BeanProvider;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.DestructionCallback;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ioc.client.container.ProxyResolver;
import org.jboss.errai.ioc.client.container.RefHolder;
import org.jboss.errai.ioc.client.container.SimpleCreationalContext;
import org.jboss.errai.ioc.client.container.SyncBeanManager;
import org.jboss.errai.ioc.client.lifecycle.api.Access;
import org.jboss.errai.ioc.client.lifecycle.api.Creation;
import org.jboss.errai.ioc.client.lifecycle.api.Destruction;
import org.jboss.errai.ioc.client.lifecycle.api.LifecycleEvent;
import org.jboss.errai.ioc.client.lifecycle.api.LifecycleListenerRegistrar;
import org.jboss.errai.ioc.client.lifecycle.api.StateChange;
import org.jboss.errai.ioc.client.lifecycle.impl.AccessImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.CreationImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.DestructionImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.LifecycleEventImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.LifecycleListenerRegistrarImpl;
import org.jboss.errai.ioc.client.lifecycle.impl.StateChangeImpl;
import org.jboss.errai.ioc.support.bus.client.BatchCallerProvider;
import org.jboss.errai.ioc.support.bus.client.MessageBusProvider;
import org.jboss.errai.ioc.support.bus.client.RequestDispatcherProvider;
import org.jboss.errai.ioc.support.bus.client.SenderProvider;
import org.jboss.errai.security.client.local.api.SecurityContext;
import org.jboss.errai.security.client.local.callback.DefaultBusSecurityErrorCallback;
import org.jboss.errai.security.client.local.callback.DefaultRestSecurityErrorCallback;
import org.jboss.errai.security.client.local.context.BasicUserCacheImpl;
import org.jboss.errai.security.client.local.context.SecurityContextImpl;
import org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage;
import org.jboss.errai.security.client.local.interceptors.AuthenticationServiceInterceptor;
import org.jboss.errai.security.client.local.interceptors.ClientSecurityRoleInterceptor;
import org.jboss.errai.security.client.local.nav.SecurityContextHoldingSingleton;
import org.jboss.errai.security.client.local.roles.ClientRequiredRolesExtractorImpl;
import org.jboss.errai.security.client.local.spi.ActiveUserCache;
import org.jboss.errai.security.client.local.storage.CookieStorageHandlerProvider;
import org.jboss.errai.security.client.local.storage.UserStorageHandler;
import org.jboss.errai.security.client.local.style.RoleStyleBindingProvider;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.event.LoggedInEvent;
import org.jboss.errai.security.shared.event.LoggedOutEvent;
import org.jboss.errai.security.shared.roles.SharedRequiredRolesExtractorImpl;
import org.jboss.errai.security.shared.service.NonCachingUserService;
import org.jboss.errai.security.shared.spi.RequiredRolesExtractor;
import org.jboss.errai.ui.client.local.spi.LessStyle;
import org.jboss.errai.ui.client.local.spi.TranslationServiceProvider;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.client.widget.LocaleListBox;
import org.jboss.errai.ui.client.widget.LocaleSelector;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.PageTransitionProvider;
import org.jboss.errai.ui.nav.client.local.TransitionAnchorFactoryProvider;
import org.jboss.errai.ui.nav.client.local.TransitionAnchorProvider;
import org.jboss.errai.ui.nav.client.local.TransitionToRole;
import org.jboss.errai.ui.nav.client.local.TransitionToRoleProvider;
import org.jboss.errai.ui.nav.client.local.api.LoginPage;
import org.jboss.errai.ui.nav.client.local.api.SecurityError;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uberfire.backend.vfs.IsVersioned;
import org.uberfire.backend.vfs.ObservablePath;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.backend.vfs.impl.ObservablePathImpl;
import org.uberfire.client.HomePerspective;
import org.uberfire.client.HomePerspectiveActivity;
import org.uberfire.client.JSEntryPoint;
import org.uberfire.client.ShowcaseEntryPoint;
import org.uberfire.client.ShowcaseEntryPoint.DumpLayout;
import org.uberfire.client.WorkbenchPanelPanel;
import org.uberfire.client.editor.JSNativeEditor;
import org.uberfire.client.exporter.EditorJSExporter;
import org.uberfire.client.exporter.PerspectiveJSExporter;
import org.uberfire.client.exporter.PlaceManagerJSExporter;
import org.uberfire.client.exporter.PluginJSExporter;
import org.uberfire.client.exporter.SplashScreenJSExporter;
import org.uberfire.client.exporter.UberfireComponentsJSExporter;
import org.uberfire.client.exporter.UberfireJSAPIExporter;
import org.uberfire.client.exporter.UberfireJSExporter;
import org.uberfire.client.exporter.VFSJSExporter;
import org.uberfire.client.menu.CustomSplashHelp;
import org.uberfire.client.menu.MenuSplashList;
import org.uberfire.client.mvp.AbstractActivity;
import org.uberfire.client.mvp.AbstractPopupActivity;
import org.uberfire.client.mvp.AbstractSplashScreenActivity;
import org.uberfire.client.mvp.AbstractWorkbenchActivity;
import org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity;
import org.uberfire.client.mvp.AbstractWorkbenchScreenActivity;
import org.uberfire.client.mvp.Activity;
import org.uberfire.client.mvp.ActivityBeansCache;
import org.uberfire.client.mvp.ActivityLifecycleError;
import org.uberfire.client.mvp.ActivityLifecycleErrorHandler;
import org.uberfire.client.mvp.ActivityManager;
import org.uberfire.client.mvp.ActivityManagerImpl;
import org.uberfire.client.mvp.ContextSensitiveActivity;
import org.uberfire.client.mvp.IsSplashScreen;
import org.uberfire.client.mvp.PerspectiveActivity;
import org.uberfire.client.mvp.PerspectiveManager;
import org.uberfire.client.mvp.PerspectiveManagerImpl;
import org.uberfire.client.mvp.PlaceHistoryHandler;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.PlaceManagerImpl;
import org.uberfire.client.mvp.PlaceRequestHistoryMapper;
import org.uberfire.client.mvp.PlaceRequestHistoryMapperImpl;
import org.uberfire.client.mvp.PopupActivity;
import org.uberfire.client.mvp.SplashScreenActivity;
import org.uberfire.client.mvp.TemplatedActivity;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.mvp.WorkbenchActivity;
import org.uberfire.client.mvp.WorkbenchScreenActivity;
import org.uberfire.client.perspective.JSNativePerspective;
import org.uberfire.client.plugin.JSNativePlugin;
import org.uberfire.client.plugin.RuntimePluginsServiceProxy;
import org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl;
import org.uberfire.client.screen.JSNativeScreen;
import org.uberfire.client.screens.ActivityNotFoundPresenterActivity;
import org.uberfire.client.screens.AnotherScreen;
import org.uberfire.client.screens.AnotherScreenActivity;
import org.uberfire.client.screens.DemoSplashScreen;
import org.uberfire.client.screens.DemoSplashScreenActivity;
import org.uberfire.client.screens.HelloWorldScreen;
import org.uberfire.client.screens.HelloWorldScreenActivity;
import org.uberfire.client.screens.HomeScreen;
import org.uberfire.client.screens.HomeScreenActivity;
import org.uberfire.client.screens.MoodScreen;
import org.uberfire.client.screens.MoodScreenActivity;
import org.uberfire.client.screens.WelcomeScreen;
import org.uberfire.client.screens.WelcomeScreenActivity;
import org.uberfire.client.splash.JSNativeSplashScreen;
import org.uberfire.client.workbench.BeanFactory;
import org.uberfire.client.workbench.DefaultBeanFactory;
import org.uberfire.client.workbench.LayoutSelection;
import org.uberfire.client.workbench.PanelManager;
import org.uberfire.client.workbench.PanelManagerImpl;
import org.uberfire.client.workbench.StandaloneEditorPerspective;
import org.uberfire.client.workbench.UberfireContext;
import org.uberfire.client.workbench.UberfireContextDefaultImpl;
import org.uberfire.client.workbench.VFSServiceProxy;
import org.uberfire.client.workbench.VFSServiceProxyClientImpl;
import org.uberfire.client.workbench.Workbench;
import org.uberfire.client.workbench.WorkbenchLayout;
import org.uberfire.client.workbench.WorkbenchLayoutImpl;
import org.uberfire.client.workbench.WorkbenchServicesProxy;
import org.uberfire.client.workbench.WorkbenchServicesProxyClientImpl;
import org.uberfire.client.workbench.events.ApplicationReadyEvent;
import org.uberfire.client.workbench.events.BeforeClosePlaceEvent;
import org.uberfire.client.workbench.events.ChangeTitleWidgetEvent;
import org.uberfire.client.workbench.events.ClosePlaceEvent;
import org.uberfire.client.workbench.events.DropPlaceEvent;
import org.uberfire.client.workbench.events.MaximizePlaceEvent;
import org.uberfire.client.workbench.events.NewPerspectiveEvent;
import org.uberfire.client.workbench.events.NewSplashScreenActiveEvent;
import org.uberfire.client.workbench.events.NewWorkbenchScreenEvent;
import org.uberfire.client.workbench.events.PanelFocusEvent;
import org.uberfire.client.workbench.events.PerspectiveChange;
import org.uberfire.client.workbench.events.PlaceGainFocusEvent;
import org.uberfire.client.workbench.events.PlaceLostFocusEvent;
import org.uberfire.client.workbench.events.SelectPlaceEvent;
import org.uberfire.client.workbench.panels.DockingWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.DockingWorkbenchPanelView;
import org.uberfire.client.workbench.panels.MultiPartWidget;
import org.uberfire.client.workbench.panels.WorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.WorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.LayoutPanelPresenter;
import org.uberfire.client.workbench.panels.impl.LayoutPanelView;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.MultiTabWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.MultiTabWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.SimpleDnDWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleDnDWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.SimpleWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SimpleWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.SplitLayoutPanelPresenter;
import org.uberfire.client.workbench.panels.impl.SplitLayoutPanelView;
import org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView;
import org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelPresenter;
import org.uberfire.client.workbench.panels.impl.TemplatedWorkbenchPanelView;
import org.uberfire.client.workbench.panels.support.PartManager;
import org.uberfire.client.workbench.part.WorkbenchPartPresenter;
import org.uberfire.client.workbench.part.WorkbenchPartPresenter.View;
import org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartPresenterDefault;
import org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartView;
import org.uberfire.client.workbench.type.AnyResourceType;
import org.uberfire.client.workbench.type.ClientResourceType;
import org.uberfire.client.workbench.type.ClientTypeRegistry;
import org.uberfire.client.workbench.type.DotResourceType;
import org.uberfire.client.workbench.type.impl.ClientTypeRegistryImpl;
import org.uberfire.client.workbench.widgets.dnd.CompassDropController;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragContext;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController;
import org.uberfire.client.workbench.widgets.listbar.ListBarWidget;
import org.uberfire.client.workbench.widgets.listbar.ResizeFlowPanel;
import org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter;
import org.uberfire.client.workbench.widgets.menu.PartContextMenusView;
import org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusPresenter;
import org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusView;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBar;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView;
import org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter;
import org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundView;
import org.uberfire.client.workbench.widgets.notifications.NotificationPopupView;
import org.uberfire.client.workbench.widgets.notifications.NotificationPopupsManager;
import org.uberfire.client.workbench.widgets.panel.ContextPanel;
import org.uberfire.client.workbench.widgets.panel.StaticFocusedResizePanel;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView;
import org.uberfire.rpc.SessionInfo;
import org.uberfire.security.Resource;
import org.uberfire.security.authz.AuthorizationManager;
import org.uberfire.security.authz.RuntimeResource;
import org.uberfire.security.client.SecurityEntryPoint;
import org.uberfire.security.impl.authz.RuntimeAuthorizationManager;
import org.uberfire.shared.Mood;
import org.uberfire.workbench.events.NotificationEvent;
import org.uberfire.workbench.events.ResourceBatchChangesEvent;
import org.uberfire.workbench.events.ResourceCopiedEvent;
import org.uberfire.workbench.events.ResourceDeletedEvent;
import org.uberfire.workbench.events.ResourceRenamedEvent;
import org.uberfire.workbench.events.ResourceUpdatedEvent;
import org.uberfire.workbench.model.menu.MenuFactory.CustomMenuBuilder;
import org.uberfire.workbench.type.AnyResourceTypeDefinition;
import org.uberfire.workbench.type.DotResourceTypeDefinition;
import org.uberfire.workbench.type.ResourceTypeDefinition;
import org.uberfire.workbench.type.TextResourceTypeDefinition;

public class BootstrapperImpl implements Bootstrapper {
  {
    addLookups_0();
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
  }

  private final Named _1314308073Named_954429984 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=AnotherScreen)";
    }
    public String value() {
      return "AnotherScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_2063879335 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_954429984 };
  private final Named _1314308073Named_834929514 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=SplitLayoutPanelView)";
    }
    public String value() {
      return "SplitLayoutPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_142200960 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_834929514 };
  private final Named _1314308073Named_12923817 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MultiTabWorkbenchPanelView)";
    }
    public String value() {
      return "MultiTabWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_52355314 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, _1314308073Named_12923817, QualifierUtil.DEFAULT_ANNOTATION };
  private final Named _1314308073Named_2123941264 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=LayoutPanelView)";
    }
    public String value() {
      return "LayoutPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_891553467 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_2123941264 };
  private final Named _1314308073Named_771251763 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=SimpleWorkbenchPanelView)";
    }
    public String value() {
      return "SimpleWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1084219910 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_771251763 };
  private final Named _1314308073Named_607526542 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MultiListWorkbenchPanelView)";
    }
    public String value() {
      return "MultiListWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1664445436 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_607526542 };
  private final Named _1314308073Named_797591419 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=TemplatedWorkbenchPanelView)";
    }
    public String value() {
      return "TemplatedWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1634264068 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_797591419 };
  private final Named _1314308073Named_1811347959 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=StaticWorkbenchPanelView)";
    }
    public String value() {
      return "StaticWorkbenchPanelView";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_968424154 = new Annotation[] { _1314308073Named_1811347959, QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION };
  private final Named _1314308073Named__266016381 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=HelloWorldScreen)";
    }
    public String value() {
      return "HelloWorldScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_259736363 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named__266016381 };
  private final Named _1314308073Named__1901730907 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=StandaloneEditorPerspective)";
    }
    public String value() {
      return "StandaloneEditorPerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1283183184 = new Annotation[] { _1314308073Named__1901730907, QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION };
  private final Named _1314308073Named_1947407538 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=HomePerspective)";
    }
    public String value() {
      return "HomePerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1853576499 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_1947407538 };
  private final Named _1314308073Named_115588205 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=welcome)";
    }
    public String value() {
      return "welcome";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_945122451 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named_115588205 };
  private final Named _1314308073Named__456639164 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=HomeScreen)";
    }
    public String value() {
      return "HomeScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1828304098 = new Annotation[] { QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION, _1314308073Named__456639164 };
  private final Named _1314308073Named_2061124429 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=uf.workbench.activity.notfound)";
    }
    public String value() {
      return "uf.workbench.activity.notfound";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1589807214 = new Annotation[] { _1314308073Named_2061124429, QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION };
  private final Named _1314308073Named_1141066092 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=MoodScreen)";
    }
    public String value() {
      return "MoodScreen";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1484530921 = new Annotation[] { _1314308073Named_1141066092, QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION };
  private final IsSplashScreen _$68260680IsSplashScreen_0 = new IsSplashScreen() {
    public Class annotationType() {
      return IsSplashScreen.class;
    }
    public String toString() {
      return "@org.uberfire.client.mvp.IsSplashScreen()";
    }
  };
  private final Named _1314308073Named_1301404637 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=demo.splash)";
    }
    public String value() {
      return "demo.splash";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_302748957 = new Annotation[] { _$68260680IsSplashScreen_0, _1314308073Named_1301404637, QualifierUtil.ANY_ANNOTATION };
  private final Named _1314308073Named_1701556496 = new Named() {
    public Class annotationType() {
      return Named.class;
    }
    public String toString() {
      return "@javax.inject.Named(value=workbench.activity.notfound)";
    }
    public String value() {
      return "workbench.activity.notfound";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_41887215 = new Annotation[] { _1314308073Named_1701556496, QualifierUtil.ANY_ANNOTATION, QualifierUtil.DEFAULT_ANNOTATION };
  private final SimpleInjectionContext injContext = new SimpleInjectionContext();
  private final SimpleCreationalContext context = injContext.getRootContext();
  private final BeanProvider<TranslationServiceProvider> inj1989_TranslationServiceProvider_creational = new BeanProvider<TranslationServiceProvider>() {
    public TranslationServiceProvider getInstance(final CreationalContext context) {
      final TranslationServiceProvider inj1962_TranslationServiceProvider = new TranslationServiceProvider();
      context.addBean(context.getBeanReference(TranslationServiceProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1962_TranslationServiceProvider);
      return inj1962_TranslationServiceProvider;
    }
  };
  private final TranslationServiceProvider inj1962_TranslationServiceProvider = inj1989_TranslationServiceProvider_creational.getInstance(context);
  private final BeanProvider<WorkbenchPartView> inj1992_WorkbenchPartView_creational = new BeanProvider<WorkbenchPartView>() {
    public WorkbenchPartView getInstance(final CreationalContext context) {
      final WorkbenchPartView inj203_WorkbenchPartView = new WorkbenchPartView();
      context.addBean(context.getBeanReference(WorkbenchPartView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj203_WorkbenchPartView);
      return inj203_WorkbenchPartView;
    }
  };
  private InitializationCallback<WorkbenchPartPresenterDefault> init_inj1990_WorkbenchPartPresenterDefault = new InitializationCallback<WorkbenchPartPresenterDefault>() {
    public void init(final WorkbenchPartPresenterDefault obj) {
      _35605411_init(obj);
    }
  };
  private final BeanProvider<WorkbenchPartPresenterDefault> inj1991_WorkbenchPartPresenterDefault_creational = new BeanProvider<WorkbenchPartPresenterDefault>() {
    public WorkbenchPartPresenterDefault getInstance(final CreationalContext context) {
      final View var6 = inj1992_WorkbenchPartView_creational.getInstance(context);
      final WorkbenchPartPresenterDefault inj1990_WorkbenchPartPresenterDefault = new WorkbenchPartPresenterDefault(var6);
      context.addBean(context.getBeanReference(WorkbenchPartPresenterDefault.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1990_WorkbenchPartPresenterDefault);
      context.addInitializationCallback(inj1990_WorkbenchPartPresenterDefault, init_inj1990_WorkbenchPartPresenterDefault);
      return inj1990_WorkbenchPartPresenterDefault;
    }
  };
  private final BeanProvider<SenderProvider> inj1993_SenderProvider_creational = new BeanProvider<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj1970_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1970_SenderProvider);
      return inj1970_SenderProvider;
    }
  };
  private final SenderProvider inj1970_SenderProvider = inj1993_SenderProvider_creational.getInstance(context);
  private final BeanProvider<IOCBeanManagerProvider> inj1994_IOCBeanManagerProvider_creational = new BeanProvider<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj1968_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1968_IOCBeanManagerProvider);
      return inj1968_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj1968_IOCBeanManagerProvider = inj1994_IOCBeanManagerProvider_creational.getInstance(context);
  private final BeanProvider<UberfireContextDefaultImpl> inj1996_UberfireContextDefaultImpl_creational = new BeanProvider<UberfireContextDefaultImpl>() {
    public UberfireContextDefaultImpl getInstance(final CreationalContext context) {
      final UberfireContextDefaultImpl inj1995_UberfireContextDefaultImpl = new UberfireContextDefaultImpl();
      context.addBean(context.getBeanReference(UberfireContextDefaultImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1995_UberfireContextDefaultImpl);
      return inj1995_UberfireContextDefaultImpl;
    }
  };
  private final UberfireContextDefaultImpl inj1995_UberfireContextDefaultImpl = inj1996_UberfireContextDefaultImpl_creational.getInstance(context);
  private final BeanProvider<InstanceProvider> inj1997_InstanceProvider_creational = new BeanProvider<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj1976_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1976_InstanceProvider);
      return inj1976_InstanceProvider;
    }
  };
  private final InstanceProvider inj1976_InstanceProvider = inj1997_InstanceProvider_creational.getInstance(context);
  private final BeanProvider<LayoutSelection> inj1999_LayoutSelection_creational = new BeanProvider<LayoutSelection>() {
    public LayoutSelection getInstance(final CreationalContext context) {
      final LayoutSelection inj1998_LayoutSelection = new LayoutSelection();
      context.addBean(context.getBeanReference(LayoutSelection.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1998_LayoutSelection);
      _$1825231548__$652658075_iocManager(inj1998_LayoutSelection, inj1968_IOCBeanManagerProvider.get());
      return inj1998_LayoutSelection;
    }
  };
  private final LayoutSelection inj1998_LayoutSelection = inj1999_LayoutSelection_creational.getInstance(context);
  private final BeanProvider<EventProvider> inj2000_EventProvider_creational = new BeanProvider<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj1980_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1980_EventProvider);
      return inj1980_EventProvider;
    }
  };
  private final EventProvider inj1980_EventProvider = inj2000_EventProvider_creational.getInstance(context);
  private final BeanProvider<DefaultBeanFactory> inj2002_DefaultBeanFactory_creational = new BeanProvider<DefaultBeanFactory>() {
    public DefaultBeanFactory getInstance(final CreationalContext context) {
      final DefaultBeanFactory inj2001_DefaultBeanFactory = new DefaultBeanFactory();
      context.addBean(context.getBeanReference(DefaultBeanFactory.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2001_DefaultBeanFactory);
      _1174169399__$652658075_iocManager(inj2001_DefaultBeanFactory, inj1968_IOCBeanManagerProvider.get());
      return inj2001_DefaultBeanFactory;
    }
  };
  private final DefaultBeanFactory inj2001_DefaultBeanFactory = inj2002_DefaultBeanFactory_creational.getInstance(context);
  private final BeanProvider<PanelManagerImpl> inj2004_PanelManagerImpl_creational = new BeanProvider<PanelManagerImpl>() {
    public PanelManagerImpl getInstance(final CreationalContext context) {
      final PanelManagerImpl inj2003_PanelManagerImpl = new PanelManagerImpl();
      context.addBean(context.getBeanReference(PanelManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2003_PanelManagerImpl);
      _$389641401__1116818801_placeGainFocusEvent(inj2003_PanelManagerImpl, inj1980_EventProvider.provide(new Class[] { PlaceGainFocusEvent.class }, null));
      _$389641401__1116818801_placeLostFocusEvent(inj2003_PanelManagerImpl, inj1980_EventProvider.provide(new Class[] { PlaceLostFocusEvent.class }, null));
      _$389641401__1116818801_panelFocusEvent(inj2003_PanelManagerImpl, inj1980_EventProvider.provide(new Class[] { PanelFocusEvent.class }, null));
      _$389641401__1116818801_selectPlaceEvent(inj2003_PanelManagerImpl, inj1980_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null));
      _$389641401__$652658075_iocManager(inj2003_PanelManagerImpl, inj1968_IOCBeanManagerProvider.get());
      _$389641401__$903668163_placeManager(inj2003_PanelManagerImpl, inj1976_InstanceProvider.provide(new Class[] { PlaceManager.class }, null));
      _$389641401__$1825231548_layoutSelection(inj2003_PanelManagerImpl, inj1998_LayoutSelection);
      _$389641401__$1887041540_beanFactory(inj2003_PanelManagerImpl, inj2001_DefaultBeanFactory);
      _$389641401__1730751009_uberfireContext(inj2003_PanelManagerImpl, inj1995_UberfireContextDefaultImpl);
      final Subscription var7 = CDI.subscribeLocal("org.uberfire.client.workbench.events.SelectPlaceEvent", new AbstractCDIEventCallback<SelectPlaceEvent>() {
        public void fireEvent(final SelectPlaceEvent event) {
          _$389641401_onSelectPlaceEvent_SelectPlaceEvent(inj2003_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.SelectPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2003_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var7.remove();
          // WEEEEE!;
        }
      });
      final Subscription var8 = CDI.subscribeLocal("org.uberfire.client.workbench.events.DropPlaceEvent", new AbstractCDIEventCallback<DropPlaceEvent>() {
        public void fireEvent(final DropPlaceEvent event) {
          _$389641401_onDropPlaceEvent_DropPlaceEvent(inj2003_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.DropPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2003_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var8.remove();
          // WEEEEE!;
        }
      });
      final Subscription var9 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ChangeTitleWidgetEvent", new AbstractCDIEventCallback<ChangeTitleWidgetEvent>() {
        public void fireEvent(final ChangeTitleWidgetEvent event) {
          _$389641401_onChangeTitleWidgetEvent_ChangeTitleWidgetEvent(inj2003_PanelManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ChangeTitleWidgetEvent []";
        }
      });
      context.addDestructionCallback(inj2003_PanelManagerImpl, new DestructionCallback<PanelManagerImpl>() {
        public void destroy(final PanelManagerImpl obj) {
          var9.remove();
          // WEEEEE!;
        }
      });
      return inj2003_PanelManagerImpl;
    }
  };
  private final PanelManagerImpl inj2003_PanelManagerImpl = inj2004_PanelManagerImpl_creational.getInstance(context);
  private final BeanProvider<WorkbenchPickupDragController> inj2006_WorkbenchPickupDragController_creational = new BeanProvider<WorkbenchPickupDragController>() {
    public WorkbenchPickupDragController getInstance(final CreationalContext context) {
      final WorkbenchPickupDragController inj2005_WorkbenchPickupDragController = new WorkbenchPickupDragController();
      context.addBean(context.getBeanReference(WorkbenchPickupDragController.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2005_WorkbenchPickupDragController);
      final WorkbenchDragAndDropManager_inj2007_proxy inj2007_proxy = new WorkbenchDragAndDropManager_inj2007_proxy();
      context.addUnresolvedProxy(new ProxyResolver<WorkbenchDragAndDropManager>() {
        public void resolve(WorkbenchDragAndDropManager obj) {
          inj2007_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj2007_proxy, obj);
        }
      }, WorkbenchDragAndDropManager.class, QualifierUtil.DEFAULT_QUALIFIERS);
      _683332058__153624969_dndManager(inj2005_WorkbenchPickupDragController, inj2007_proxy);
      return inj2005_WorkbenchPickupDragController;
    }
  };
  private final WorkbenchPickupDragController inj2005_WorkbenchPickupDragController = inj2006_WorkbenchPickupDragController_creational.getInstance(context);
  private final BeanProvider<WorkbenchDragAndDropManager> inj2009_WorkbenchDragAndDropManager_creational = new BeanProvider<WorkbenchDragAndDropManager>() {
    public WorkbenchDragAndDropManager getInstance(final CreationalContext context) {
      final WorkbenchDragAndDropManager inj2008_WorkbenchDragAndDropManager = new WorkbenchDragAndDropManager();
      context.addBean(context.getBeanReference(WorkbenchDragAndDropManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2008_WorkbenchDragAndDropManager);
      _153624969__683332058_dragController(inj2008_WorkbenchDragAndDropManager, ((SimpleCreationalContext) context).getInstanceOrNew(inj2006_WorkbenchPickupDragController_creational, WorkbenchPickupDragController.class, QualifierUtil.DEFAULT_QUALIFIERS));
      _153624969__$1887041540_factory(inj2008_WorkbenchDragAndDropManager, inj2001_DefaultBeanFactory);
      return inj2008_WorkbenchDragAndDropManager;
    }
  };
  private final WorkbenchDragAndDropManager inj2008_WorkbenchDragAndDropManager = inj2009_WorkbenchDragAndDropManager_creational.getInstance(context);
  private final BeanProvider<CompassDropController> inj2011_CompassDropController_creational = new BeanProvider<CompassDropController>() {
    public CompassDropController getInstance(final CreationalContext context) {
      final CompassDropController inj2010_CompassDropController = new CompassDropController();
      context.addBean(context.getBeanReference(CompassDropController.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2010_CompassDropController);
      _$1705636724__$262319993_panelManager(inj2010_CompassDropController, inj2003_PanelManagerImpl);
      _$1705636724__153624969_dndManager(inj2010_CompassDropController, inj2008_WorkbenchDragAndDropManager);
      _$1705636724__1116818801_workbenchPartDroppedEvent(inj2010_CompassDropController, inj1980_EventProvider.provide(new Class[] { DropPlaceEvent.class }, null));
      return inj2010_CompassDropController;
    }
  };
  private final BeanProvider<StateChangeImpl> inj2013_StateChangeImpl_creational = new BeanProvider<StateChangeImpl>() {
    public StateChangeImpl getInstance(final CreationalContext context) {
      final StateChangeImpl inj2012_StateChangeImpl = new StateChangeImpl();
      context.addBean(context.getBeanReference(StateChangeImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2012_StateChangeImpl);
      return inj2012_StateChangeImpl;
    }
  };
  private InitializationCallback<Navigation> init_inj2014_Navigation = new InitializationCallback<Navigation>() {
    public void init(final Navigation obj) {
      _136504311_init(obj);
    }
  };
  private DestructionCallback<Navigation> destroy_inj2014_Navigation = new DestructionCallback<Navigation>() {
    public void destroy(final Navigation obj) {
      obj.cleanUp();
    }
  };
  private final BeanProvider<Navigation> inj2015_Navigation_creational = new BeanProvider<Navigation>() {
    public Navigation getInstance(final CreationalContext context) {
      final Navigation inj2014_Navigation = new Navigation();
      context.addBean(context.getBeanReference(Navigation.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2014_Navigation);
      _136504311__$2056551207_stateChangeEvent(inj2014_Navigation, inj2013_StateChangeImpl_creational.getInstance(context));
      context.addInitializationCallback(inj2014_Navigation, init_inj2014_Navigation);
      context.addDestructionCallback(inj2014_Navigation, destroy_inj2014_Navigation);
      return inj2014_Navigation;
    }
  };
  private final Navigation inj2014_Navigation = inj2015_Navigation_creational.getInstance(context);
  private final BeanProvider<CallerProvider> inj2016_CallerProvider_creational = new BeanProvider<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj1984_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1984_CallerProvider);
      return inj1984_CallerProvider;
    }
  };
  private final CallerProvider inj1984_CallerProvider = inj2016_CallerProvider_creational.getInstance(context);
  private final BeanProvider<CookieStorageHandlerProvider> inj2017_CookieStorageHandlerProvider_creational = new BeanProvider<CookieStorageHandlerProvider>() {
    public CookieStorageHandlerProvider getInstance(final CreationalContext context) {
      final CookieStorageHandlerProvider inj1972_CookieStorageHandlerProvider = new CookieStorageHandlerProvider();
      context.addBean(context.getBeanReference(CookieStorageHandlerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1972_CookieStorageHandlerProvider);
      return inj1972_CookieStorageHandlerProvider;
    }
  };
  private final CookieStorageHandlerProvider inj1972_CookieStorageHandlerProvider = inj2017_CookieStorageHandlerProvider_creational.getInstance(context);
  private InitializationCallback<BasicUserCacheImpl> init_inj2018_BasicUserCacheImpl = new InitializationCallback<BasicUserCacheImpl>() {
    public void init(final BasicUserCacheImpl obj) {
      _663569186_maybeLoadStoredCache(obj);
    }
  };
  private final BeanProvider<BasicUserCacheImpl> inj2019_BasicUserCacheImpl_creational = new BeanProvider<BasicUserCacheImpl>() {
    public BasicUserCacheImpl getInstance(final CreationalContext context) {
      final BasicUserCacheImpl inj2018_BasicUserCacheImpl = new BasicUserCacheImpl();
      context.addBean(context.getBeanReference(BasicUserCacheImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2018_BasicUserCacheImpl);
      final Logger var10 = LoggerFactory.getLogger("org.jboss.errai.security.client.local.context.BasicUserCacheImpl");
      _663569186__1388723237_logger(inj2018_BasicUserCacheImpl, var10);
      _663569186__$1444549593_userStorageHandler(inj2018_BasicUserCacheImpl, inj1972_CookieStorageHandlerProvider.get());
      context.addInitializationCallback(inj2018_BasicUserCacheImpl, init_inj2018_BasicUserCacheImpl);
      return inj2018_BasicUserCacheImpl;
    }
  };
  private final BasicUserCacheImpl inj2018_BasicUserCacheImpl = inj2019_BasicUserCacheImpl_creational.getInstance(context);
  private InitializationCallback<SecurityContextImpl> init_inj2020_SecurityContextImpl = new InitializationCallback<SecurityContextImpl>() {
    public void init(final SecurityContextImpl obj) {
      _378913974_setup(obj);
    }
  };
  private final BeanProvider<SecurityContextImpl> inj2021_SecurityContextImpl_creational = new BeanProvider<SecurityContextImpl>() {
    public SecurityContextImpl getInstance(final CreationalContext context) {
      final SecurityContextImpl inj2020_SecurityContextImpl = new SecurityContextImpl();
      context.addBean(context.getBeanReference(SecurityContextImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2020_SecurityContextImpl);
      _378913974__1116818801_loginEvent(inj2020_SecurityContextImpl, inj1980_EventProvider.provide(new Class[] { LoggedInEvent.class }, null));
      _378913974__1116818801_logoutEvent(inj2020_SecurityContextImpl, inj1980_EventProvider.provide(new Class[] { LoggedOutEvent.class }, null));
      _378913974__136504311_navigation(inj2020_SecurityContextImpl, inj2014_Navigation);
      _378913974__$282317259_userCache(inj2020_SecurityContextImpl, inj2018_BasicUserCacheImpl);
      final Logger var11 = LoggerFactory.getLogger("org.jboss.errai.security.client.local.context.SecurityContextImpl");
      _378913974__1388723237_logger(inj2020_SecurityContextImpl, var11);
      _378913974__120980481_userServiceCaller(inj2020_SecurityContextImpl, inj1984_CallerProvider.provide(new Class[] { NonCachingUserService.class }, null));
      context.addInitializationCallback(inj2020_SecurityContextImpl, init_inj2020_SecurityContextImpl);
      return inj2020_SecurityContextImpl;
    }
  };
  private final SecurityContextImpl inj2020_SecurityContextImpl = inj2021_SecurityContextImpl_creational.getInstance(context);
  private final BeanProvider<RuntimeAuthorizationManager> inj2023_RuntimeAuthorizationManager_creational = new BeanProvider<RuntimeAuthorizationManager>() {
    public RuntimeAuthorizationManager getInstance(final CreationalContext context) {
      final RuntimeAuthorizationManager inj2022_RuntimeAuthorizationManager = new RuntimeAuthorizationManager();
      context.addBean(context.getBeanReference(RuntimeAuthorizationManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2022_RuntimeAuthorizationManager);
      return inj2022_RuntimeAuthorizationManager;
    }
  };
  private final RuntimeAuthorizationManager inj2022_RuntimeAuthorizationManager = inj2023_RuntimeAuthorizationManager_creational.getInstance(context);
  private final BeanProvider<EditorJSExporter> inj2025_EditorJSExporter_creational = new BeanProvider<EditorJSExporter>() {
    public EditorJSExporter getInstance(final CreationalContext context) {
      final EditorJSExporter inj2024_EditorJSExporter = new EditorJSExporter();
      context.addBean(context.getBeanReference(EditorJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2024_EditorJSExporter);
      return inj2024_EditorJSExporter;
    }
  };
  private final EditorJSExporter inj2024_EditorJSExporter = inj2025_EditorJSExporter_creational.getInstance(context);
  private final BeanProvider<HeaderPanel> inj2028_HeaderPanel_creational = new BeanProvider<HeaderPanel>() {
    public HeaderPanel getInstance(final CreationalContext context) {
      final HeaderPanel inj1532_HeaderPanel = new HeaderPanel();
      context.addBean(context.getBeanReference(HeaderPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1532_HeaderPanel);
      return inj1532_HeaderPanel;
    }
  };
  private InitializationCallback<WorkbenchLayoutImpl> init_inj2026_WorkbenchLayoutImpl = new InitializationCallback<WorkbenchLayoutImpl>() {
    public void init(final WorkbenchLayoutImpl obj) {
      _1934862923_init(obj);
    }
  };
  private final BeanProvider<WorkbenchLayoutImpl> inj2027_WorkbenchLayoutImpl_creational = new BeanProvider<WorkbenchLayoutImpl>() {
    public WorkbenchLayoutImpl getInstance(final CreationalContext context) {
      final WorkbenchLayoutImpl inj2026_WorkbenchLayoutImpl = new WorkbenchLayoutImpl();
      context.addBean(context.getBeanReference(WorkbenchLayoutImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2026_WorkbenchLayoutImpl);
      _1934862923__$1393584145_root(inj2026_WorkbenchLayoutImpl, inj2028_HeaderPanel_creational.getInstance(context));
      _1934862923__153624969_dndManager(inj2026_WorkbenchLayoutImpl, inj2008_WorkbenchDragAndDropManager);
      _1934862923__683332058_dragController(inj2026_WorkbenchLayoutImpl, inj2005_WorkbenchPickupDragController);
      context.addInitializationCallback(inj2026_WorkbenchLayoutImpl, init_inj2026_WorkbenchLayoutImpl);
      return inj2026_WorkbenchLayoutImpl;
    }
  };
  private final WorkbenchLayoutImpl inj2026_WorkbenchLayoutImpl = inj2027_WorkbenchLayoutImpl_creational.getInstance(context);
  private final BeanProvider<User> inj1950_User_creational = new BeanProvider<User>() {
    public User getInstance(CreationalContext pContext) {
      User var12 = _663569186_produceActiveUser(inj2018_BasicUserCacheImpl);
      context.addBean(context.getBeanReference(User.class, QualifierUtil.DEFAULT_QUALIFIERS), var12);
      return var12;
    }
  };
  private final BeanProvider<NotificationPopupsManager> inj2030_NotificationPopupsManager_creational = new BeanProvider<NotificationPopupsManager>() {
    public NotificationPopupsManager getInstance(final CreationalContext context) {
      final NotificationPopupsManager inj2029_NotificationPopupsManager = new NotificationPopupsManager();
      context.addBean(context.getBeanReference(NotificationPopupsManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2029_NotificationPopupsManager);
      _$746838216__$652658075_iocManager(inj2029_NotificationPopupsManager, inj1968_IOCBeanManagerProvider.get());
      final Subscription var13 = CDI.subscribeLocal("org.uberfire.workbench.events.NotificationEvent", new AbstractCDIEventCallback<NotificationEvent>() {
        public void fireEvent(final NotificationEvent event) {
          inj2029_NotificationPopupsManager.addNotification(event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.NotificationEvent []";
        }
      });
      context.addDestructionCallback(inj2029_NotificationPopupsManager, new DestructionCallback<NotificationPopupsManager>() {
        public void destroy(final NotificationPopupsManager obj) {
          var13.remove();
          // WEEEEE!;
        }
      });
      return inj2029_NotificationPopupsManager;
    }
  };
  private final NotificationPopupsManager inj2029_NotificationPopupsManager = inj2030_NotificationPopupsManager_creational.getInstance(context);
  private final BeanProvider<ActivityLifecycleErrorHandler> inj2032_ActivityLifecycleErrorHandler_creational = new BeanProvider<ActivityLifecycleErrorHandler>() {
    public ActivityLifecycleErrorHandler getInstance(final CreationalContext context) {
      final ActivityLifecycleErrorHandler inj2031_ActivityLifecycleErrorHandler = new ActivityLifecycleErrorHandler();
      context.addBean(context.getBeanReference(ActivityLifecycleErrorHandler.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2031_ActivityLifecycleErrorHandler);
      final Logger var14 = LoggerFactory.getLogger("org.uberfire.client.mvp.ActivityLifecycleErrorHandler");
      _$1934524921__1388723237_logger(inj2031_ActivityLifecycleErrorHandler, var14);
      _$1934524921__1116818801_lifecycleErrorEvent(inj2031_ActivityLifecycleErrorHandler, inj1980_EventProvider.provide(new Class[] { ActivityLifecycleError.class }, null));
      _$1934524921__$746838216_notificationManager(inj2031_ActivityLifecycleErrorHandler, inj2029_NotificationPopupsManager);
      return inj2031_ActivityLifecycleErrorHandler;
    }
  };
  private final ActivityLifecycleErrorHandler inj2031_ActivityLifecycleErrorHandler = inj2032_ActivityLifecycleErrorHandler_creational.getInstance(context);
  private InitializationCallback<ActivityBeansCache> init_inj2033_ActivityBeansCache = new InitializationCallback<ActivityBeansCache>() {
    public void init(final ActivityBeansCache obj) {
      _2052955140_init(obj);
    }
  };
  private final BeanProvider<ActivityBeansCache> inj2034_ActivityBeansCache_creational = new BeanProvider<ActivityBeansCache>() {
    public ActivityBeansCache getInstance(final CreationalContext context) {
      final ActivityBeansCache inj2033_ActivityBeansCache = new ActivityBeansCache();
      context.addBean(context.getBeanReference(ActivityBeansCache.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2033_ActivityBeansCache);
      _2052955140__$652658075_iocManager(inj2033_ActivityBeansCache, inj1968_IOCBeanManagerProvider.get());
      _2052955140__1116818801_newPerspectiveEventEvent(inj2033_ActivityBeansCache, inj1980_EventProvider.provide(new Class[] { NewPerspectiveEvent.class }, null));
      _2052955140__1116818801_newWorkbenchScreenEventEvent(inj2033_ActivityBeansCache, inj1980_EventProvider.provide(new Class[] { NewWorkbenchScreenEvent.class }, null));
      context.addInitializationCallback(inj2033_ActivityBeansCache, init_inj2033_ActivityBeansCache);
      return inj2033_ActivityBeansCache;
    }
  };
  private final ActivityBeansCache inj2033_ActivityBeansCache = inj2034_ActivityBeansCache_creational.getInstance(context);
  private final BeanProvider<ActivityManagerImpl> inj2036_ActivityManagerImpl_creational = new BeanProvider<ActivityManagerImpl>() {
    public ActivityManagerImpl getInstance(final CreationalContext context) {
      final ActivityManagerImpl inj2035_ActivityManagerImpl = new ActivityManagerImpl();
      context.addBean(context.getBeanReference(ActivityManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2035_ActivityManagerImpl);
      _1730935432__$652658075_iocManager(inj2035_ActivityManagerImpl, inj1968_IOCBeanManagerProvider.get());
      _1730935432__$1574799830_authzManager(inj2035_ActivityManagerImpl, inj2022_RuntimeAuthorizationManager);
      _1730935432__2052955140_activityBeansCache(inj2035_ActivityManagerImpl, inj2033_ActivityBeansCache);
      _1730935432__597466346_identity(inj2035_ActivityManagerImpl, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      _1730935432__$1934524921_lifecycleErrorHandler(inj2035_ActivityManagerImpl, inj2031_ActivityLifecycleErrorHandler);
      return inj2035_ActivityManagerImpl;
    }
  };
  private final ActivityManagerImpl inj2035_ActivityManagerImpl = inj2036_ActivityManagerImpl_creational.getInstance(context);
  private final BeanProvider<WorkbenchServicesProxyClientImpl> inj2038_WorkbenchServicesProxyClientImpl_creational = new BeanProvider<WorkbenchServicesProxyClientImpl>() {
    public WorkbenchServicesProxyClientImpl getInstance(final CreationalContext context) {
      final WorkbenchServicesProxyClientImpl inj2037_WorkbenchServicesProxyClientImpl = new WorkbenchServicesProxyClientImpl();
      context.addBean(context.getBeanReference(WorkbenchServicesProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2037_WorkbenchServicesProxyClientImpl);
      return inj2037_WorkbenchServicesProxyClientImpl;
    }
  };
  private final BeanProvider<PerspectiveManagerImpl> inj2040_PerspectiveManagerImpl_creational = new BeanProvider<PerspectiveManagerImpl>() {
    public PerspectiveManagerImpl getInstance(final CreationalContext context) {
      final PerspectiveManagerImpl inj2039_PerspectiveManagerImpl = new PerspectiveManagerImpl();
      context.addBean(context.getBeanReference(PerspectiveManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2039_PerspectiveManagerImpl);
      _$348507737__$262319993_panelManager(inj2039_PerspectiveManagerImpl, inj2003_PanelManagerImpl);
      _$348507737__$304677073_wbServices(inj2039_PerspectiveManagerImpl, inj2038_WorkbenchServicesProxyClientImpl_creational.getInstance(context));
      _$348507737__1116818801_perspectiveChangeEvent(inj2039_PerspectiveManagerImpl, inj1980_EventProvider.provide(new Class[] { PerspectiveChange.class }, null));
      return inj2039_PerspectiveManagerImpl;
    }
  };
  private final PerspectiveManagerImpl inj2039_PerspectiveManagerImpl = inj2040_PerspectiveManagerImpl_creational.getInstance(context);
  private final BeanProvider<PlaceManagerImpl> inj2042_PlaceManagerImpl_creational = new BeanProvider<PlaceManagerImpl>() {
    public PlaceManagerImpl getInstance(final CreationalContext context) {
      final PlaceManagerImpl inj2041_PlaceManagerImpl = new PlaceManagerImpl();
      context.addBean(context.getBeanReference(PlaceManagerImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2041_PlaceManagerImpl);
      _$1757102468__1116818801_workbenchPartBeforeCloseEvent(inj2041_PlaceManagerImpl, inj1980_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$1757102468__1116818801_workbenchPartCloseEvent(inj2041_PlaceManagerImpl, inj1980_EventProvider.provide(new Class[] { ClosePlaceEvent.class }, null));
      _$1757102468__1116818801_newSplashScreenActiveEvent(inj2041_PlaceManagerImpl, inj1980_EventProvider.provide(new Class[] { NewSplashScreenActiveEvent.class }, null));
      _$1757102468__$1583970232_activityManager(inj2041_PlaceManagerImpl, inj2035_ActivityManagerImpl);
      _$1757102468__1116818801_selectWorkbenchPartEvent(inj2041_PlaceManagerImpl, inj1980_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null));
      _$1757102468__$262319993_panelManager(inj2041_PlaceManagerImpl, inj2003_PanelManagerImpl);
      _$1757102468__$1335679257_perspectiveManager(inj2041_PlaceManagerImpl, inj2039_PerspectiveManagerImpl);
      _$1757102468__$1934524921_lifecycleErrorHandler(inj2041_PlaceManagerImpl, inj2031_ActivityLifecycleErrorHandler);
      _$1757102468__$1657106037_workbenchLayout(inj2041_PlaceManagerImpl, inj2026_WorkbenchLayoutImpl);
      final Subscription var15 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$1757102468_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2041_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2041_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var15.remove();
          // WEEEEE!;
        }
      });
      final Subscription var16 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          _$1757102468_onWorkbenchPartLostFocus_PlaceLostFocusEvent(inj2041_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2041_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var16.remove();
          // WEEEEE!;
        }
      });
      return inj2041_PlaceManagerImpl;
    }
  };
  private final PlaceManagerImpl inj2041_PlaceManagerImpl = inj2042_PlaceManagerImpl_creational.getInstance(context);
  private final BeanProvider<JSNativePerspective> inj2044_JSNativePerspective_creational = new BeanProvider<JSNativePerspective>() {
    public JSNativePerspective getInstance(final CreationalContext context) {
      final JSNativePerspective inj2043_JSNativePerspective = new JSNativePerspective();
      context.addBean(context.getBeanReference(JSNativePerspective.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2043_JSNativePerspective);
      _684448251__$262319993_panelManager(inj2043_JSNativePerspective, inj2003_PanelManagerImpl);
      _684448251__$906533316_placeManager(inj2043_JSNativePerspective, inj2041_PlaceManagerImpl);
      _684448251__$1583970232_activityManager(inj2043_JSNativePerspective, inj2035_ActivityManagerImpl);
      _684448251__$304677073_wbServices(inj2043_JSNativePerspective, inj2038_WorkbenchServicesProxyClientImpl_creational.getInstance(context));
      return inj2043_JSNativePerspective;
    }
  };
  private final BeanProvider<MessageBusProvider> inj2045_MessageBusProvider_creational = new BeanProvider<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj1956_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1956_MessageBusProvider);
      return inj1956_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj1956_MessageBusProvider = inj2045_MessageBusProvider_creational.getInstance(context);
  private final BeanProvider<RequestDispatcherProvider> inj2046_RequestDispatcherProvider_creational = new BeanProvider<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj1960_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1960_RequestDispatcherProvider);
      return inj1960_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj1960_RequestDispatcherProvider = inj2046_RequestDispatcherProvider_creational.getInstance(context);
  private final BeanProvider<AnotherScreen> inj2048_AnotherScreen_creational = new BeanProvider<AnotherScreen>() {
    public AnotherScreen getInstance(final CreationalContext context) {
      final AnotherScreen inj2047_AnotherScreen = new AnotherScreen();
      context.addBean(context.getBeanReference(AnotherScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2047_AnotherScreen);
      return inj2047_AnotherScreen;
    }
  };
  private final BeanProvider<AnotherScreenActivity> inj2050_AnotherScreenActivity_creational = new BeanProvider<AnotherScreenActivity>() {
    public AnotherScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var17 = inj2041_PlaceManagerImpl;
      final AnotherScreenActivity inj2049_AnotherScreenActivity = new AnotherScreenActivity(var17);
      context.addBean(context.getBeanReference(AnotherScreenActivity.class, arrayOf_19635043Annotation_2063879335), inj2049_AnotherScreenActivity);
      _$2070321720__1043576729_realPresenter(inj2049_AnotherScreenActivity, inj2048_AnotherScreen_creational.getInstance(context));
      return inj2049_AnotherScreenActivity;
    }
  };
  private InitializationCallback<SecurityContextHoldingSingleton> init_inj2051_SecurityContextHoldingSingleton = new InitializationCallback<SecurityContextHoldingSingleton>() {
    public void init(final SecurityContextHoldingSingleton obj) {
      _322507922_setInstance(obj);
    }
  };
  private final BeanProvider<SecurityContextHoldingSingleton> inj2052_SecurityContextHoldingSingleton_creational = new BeanProvider<SecurityContextHoldingSingleton>() {
    public SecurityContextHoldingSingleton getInstance(final CreationalContext context) {
      final SecurityContext var18 = inj2020_SecurityContextImpl;
      final SecurityContextHoldingSingleton inj2051_SecurityContextHoldingSingleton = new SecurityContextHoldingSingleton(var18);
      context.addBean(context.getBeanReference(SecurityContextHoldingSingleton.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2051_SecurityContextHoldingSingleton);
      context.addInitializationCallback(inj2051_SecurityContextHoldingSingleton, init_inj2051_SecurityContextHoldingSingleton);
      return inj2051_SecurityContextHoldingSingleton;
    }
  };
  private final SecurityContextHoldingSingleton inj2051_SecurityContextHoldingSingleton = inj2052_SecurityContextHoldingSingleton_creational.getInstance(context);
  private final BeanProvider<PespectiveContextMenusView> inj2054_PespectiveContextMenusView_creational = new BeanProvider<PespectiveContextMenusView>() {
    public PespectiveContextMenusView getInstance(final CreationalContext context) {
      final PespectiveContextMenusView inj2053_PespectiveContextMenusView = new PespectiveContextMenusView();
      context.addBean(context.getBeanReference(PespectiveContextMenusView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2053_PespectiveContextMenusView);
      _$1913953616__$1574799830_authzManager(inj2053_PespectiveContextMenusView, inj2022_RuntimeAuthorizationManager);
      _$1913953616__597466346_identity(inj2053_PespectiveContextMenusView, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      return inj2053_PespectiveContextMenusView;
    }
  };
  private final BeanProvider<PespectiveContextMenusPresenter> inj2056_PespectiveContextMenusPresenter_creational = new BeanProvider<PespectiveContextMenusPresenter>() {
    public PespectiveContextMenusPresenter getInstance(final CreationalContext context) {
      final PespectiveContextMenusPresenter inj2055_PespectiveContextMenusPresenter = new PespectiveContextMenusPresenter();
      context.addBean(context.getBeanReference(PespectiveContextMenusPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2055_PespectiveContextMenusPresenter);
      _7760253__$577439348_view(inj2055_PespectiveContextMenusPresenter, inj2054_PespectiveContextMenusView_creational.getInstance(context));
      final Subscription var19 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PerspectiveChange", new AbstractCDIEventCallback<PerspectiveChange>() {
        public void fireEvent(final PerspectiveChange event) {
          _7760253_onPerspectiveChange_PerspectiveChange(inj2055_PespectiveContextMenusPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PerspectiveChange []";
        }
      });
      context.addDestructionCallback(inj2055_PespectiveContextMenusPresenter, new DestructionCallback<PespectiveContextMenusPresenter>() {
        public void destroy(final PespectiveContextMenusPresenter obj) {
          var19.remove();
          // WEEEEE!;
        }
      });
      return inj2055_PespectiveContextMenusPresenter;
    }
  };
  private final PespectiveContextMenusPresenter inj2055_PespectiveContextMenusPresenter = inj2056_PespectiveContextMenusPresenter_creational.getInstance(context);
  private final BeanProvider<PlaceRequestHistoryMapperImpl> inj2059_PlaceRequestHistoryMapperImpl_creational = new BeanProvider<PlaceRequestHistoryMapperImpl>() {
    public PlaceRequestHistoryMapperImpl getInstance(final CreationalContext context) {
      final PlaceRequestHistoryMapperImpl inj722_PlaceRequestHistoryMapperImpl = new PlaceRequestHistoryMapperImpl();
      context.addBean(context.getBeanReference(PlaceRequestHistoryMapperImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj722_PlaceRequestHistoryMapperImpl);
      return inj722_PlaceRequestHistoryMapperImpl;
    }
  };
  private final BeanProvider<PlaceHistoryHandler> inj2058_PlaceHistoryHandler_creational = new BeanProvider<PlaceHistoryHandler>() {
    public PlaceHistoryHandler getInstance(final CreationalContext context) {
      final PlaceHistoryHandler inj2057_PlaceHistoryHandler = new PlaceHistoryHandler();
      context.addBean(context.getBeanReference(PlaceHistoryHandler.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2057_PlaceHistoryHandler);
      _1047951015__$695339145_mapper(inj2057_PlaceHistoryHandler, inj2059_PlaceRequestHistoryMapperImpl_creational.getInstance(context));
      return inj2057_PlaceHistoryHandler;
    }
  };
  private final BeanProvider<WorkbenchMenuBarView> inj2062_WorkbenchMenuBarView_creational = new BeanProvider<WorkbenchMenuBarView>() {
    public WorkbenchMenuBarView getInstance(final CreationalContext context) {
      final WorkbenchMenuBarView inj1841_WorkbenchMenuBarView = new WorkbenchMenuBarView();
      context.addBean(context.getBeanReference(WorkbenchMenuBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1841_WorkbenchMenuBarView);
      _102087148__$1574799830_authzManager(inj1841_WorkbenchMenuBarView, inj2022_RuntimeAuthorizationManager);
      _102087148__597466346_identity(inj1841_WorkbenchMenuBarView, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      return inj1841_WorkbenchMenuBarView;
    }
  };
  private final BeanProvider<WorkbenchMenuBarPresenter> inj2061_WorkbenchMenuBarPresenter_creational = new BeanProvider<WorkbenchMenuBarPresenter>() {
    public WorkbenchMenuBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchMenuBarPresenter inj2060_WorkbenchMenuBarPresenter = new WorkbenchMenuBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchMenuBarPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2060_WorkbenchMenuBarPresenter);
      _$292735039__1201173960_view(inj2060_WorkbenchMenuBarPresenter, inj2062_WorkbenchMenuBarView_creational.getInstance(context));
      _$292735039__$906533316_placeManager(inj2060_WorkbenchMenuBarPresenter, inj2041_PlaceManagerImpl);
      return inj2060_WorkbenchMenuBarPresenter;
    }
  };
  private final WorkbenchMenuBarPresenter inj2060_WorkbenchMenuBarPresenter = inj2061_WorkbenchMenuBarPresenter_creational.getInstance(context);
  private InitializationCallback<ShowcaseEntryPoint> init_inj2063_ShowcaseEntryPoint = new InitializationCallback<ShowcaseEntryPoint>() {
    public void init(final ShowcaseEntryPoint obj) {
      obj.startApp();
    }
  };
  private final BeanProvider<ShowcaseEntryPoint> inj2064_ShowcaseEntryPoint_creational = new BeanProvider<ShowcaseEntryPoint>() {
    public ShowcaseEntryPoint getInstance(final CreationalContext context) {
      final ShowcaseEntryPoint inj2063_ShowcaseEntryPoint = new ShowcaseEntryPoint();
      context.addBean(context.getBeanReference(ShowcaseEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2063_ShowcaseEntryPoint);
      _73328378__$652658075_manager(inj2063_ShowcaseEntryPoint, inj1968_IOCBeanManagerProvider.get());
      _73328378__$351881561_menubar(inj2063_ShowcaseEntryPoint, inj2060_WorkbenchMenuBarPresenter);
      _73328378__$906533316_placeManager(inj2063_ShowcaseEntryPoint, inj2041_PlaceManagerImpl);
      _73328378__$1583970232_activityManager(inj2063_ShowcaseEntryPoint, inj2035_ActivityManagerImpl);
      _73328378__$1335679257_perspectiveManager(inj2063_ShowcaseEntryPoint, inj2039_PerspectiveManagerImpl);
      _73328378__879292651_bus(inj2063_ShowcaseEntryPoint, inj1956_MessageBusProvider.get());
      _73328378__1116818801_dumpLayoutEvent(inj2063_ShowcaseEntryPoint, inj1980_EventProvider.provide(new Class[] { DumpLayout.class }, null));
      final Subscription var20 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ApplicationReadyEvent", new AbstractCDIEventCallback<ApplicationReadyEvent>() {
        public void fireEvent(final ApplicationReadyEvent event) {
          _73328378_setupMenu_ApplicationReadyEvent(inj2063_ShowcaseEntryPoint, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ApplicationReadyEvent []";
        }
      });
      context.addDestructionCallback(inj2063_ShowcaseEntryPoint, new DestructionCallback<ShowcaseEntryPoint>() {
        public void destroy(final ShowcaseEntryPoint obj) {
          var20.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2063_ShowcaseEntryPoint, init_inj2063_ShowcaseEntryPoint);
      return inj2063_ShowcaseEntryPoint;
    }
  };
  private final ShowcaseEntryPoint inj2063_ShowcaseEntryPoint = inj2064_ShowcaseEntryPoint_creational.getInstance(context);
  private final BeanProvider<SplitLayoutPanelView> inj2066_SplitLayoutPanelView_creational = new BeanProvider<SplitLayoutPanelView>() {
    public SplitLayoutPanelView getInstance(final CreationalContext context) {
      final SplitLayoutPanelView inj2065_SplitLayoutPanelView = new SplitLayoutPanelView();
      context.addBean(context.getBeanReference(SplitLayoutPanelView.class, arrayOf_19635043Annotation_142200960), inj2065_SplitLayoutPanelView);
      _1698844050__$906533316_placeManager(inj2065_SplitLayoutPanelView, inj2041_PlaceManagerImpl);
      return inj2065_SplitLayoutPanelView;
    }
  };
  private final BeanProvider<ListWidgetProvider> inj2067_ListWidgetProvider_creational = new BeanProvider<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj1952_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1952_ListWidgetProvider);
      return inj1952_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj1952_ListWidgetProvider = inj2067_ListWidgetProvider_creational.getInstance(context);
  private final BeanProvider<RuntimePluginsServiceProxyClientImpl> inj2069_RuntimePluginsServiceProxyClientImpl_creational = new BeanProvider<RuntimePluginsServiceProxyClientImpl>() {
    public RuntimePluginsServiceProxyClientImpl getInstance(final CreationalContext context) {
      final RuntimePluginsServiceProxyClientImpl inj2068_RuntimePluginsServiceProxyClientImpl = new RuntimePluginsServiceProxyClientImpl();
      context.addBean(context.getBeanReference(RuntimePluginsServiceProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2068_RuntimePluginsServiceProxyClientImpl);
      final Logger var21 = LoggerFactory.getLogger("org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl");
      _$1933089096__1388723237_logger(inj2068_RuntimePluginsServiceProxyClientImpl, var21);
      return inj2068_RuntimePluginsServiceProxyClientImpl;
    }
  };
  private final BeanProvider<JSNativeEditor> inj2071_JSNativeEditor_creational = new BeanProvider<JSNativeEditor>() {
    public JSNativeEditor getInstance(final CreationalContext context) {
      final JSNativeEditor inj2070_JSNativeEditor = new JSNativeEditor();
      context.addBean(context.getBeanReference(JSNativeEditor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2070_JSNativeEditor);
      _1584088255__$2073863603_runtimePluginsService(inj2070_JSNativeEditor, inj2069_RuntimePluginsServiceProxyClientImpl_creational.getInstance(context));
      return inj2070_JSNativeEditor;
    }
  };
  private final BeanProvider<SimpleLayoutPanel> inj2074_SimpleLayoutPanel_creational = new BeanProvider<SimpleLayoutPanel>() {
    public SimpleLayoutPanel getInstance(final CreationalContext context) {
      final SimpleLayoutPanel inj1779_SimpleLayoutPanel = new SimpleLayoutPanel();
      context.addBean(context.getBeanReference(SimpleLayoutPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1779_SimpleLayoutPanel);
      return inj1779_SimpleLayoutPanel;
    }
  };
  private final BeanProvider<ResizeFlowPanel> inj2075_ResizeFlowPanel_creational = new BeanProvider<ResizeFlowPanel>() {
    public ResizeFlowPanel getInstance(final CreationalContext context) {
      final ResizeFlowPanel inj1849_ResizeFlowPanel = new ResizeFlowPanel();
      context.addBean(context.getBeanReference(ResizeFlowPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1849_ResizeFlowPanel);
      return inj1849_ResizeFlowPanel;
    }
  };
  private InitializationCallback<MultiTabWorkbenchPanelView> init_inj2072_MultiTabWorkbenchPanelView = new InitializationCallback<MultiTabWorkbenchPanelView>() {
    public void init(final MultiTabWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _$821728441_setupMultiPartPanel(obj);
    }
  };
  private DestructionCallback<MultiTabWorkbenchPanelView> destroy_inj2072_MultiTabWorkbenchPanelView = new DestructionCallback<MultiTabWorkbenchPanelView>() {
    public void destroy(final MultiTabWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<MultiTabWorkbenchPanelView> inj2073_MultiTabWorkbenchPanelView_creational = new BeanProvider<MultiTabWorkbenchPanelView>() {
    public MultiTabWorkbenchPanelView getInstance(final CreationalContext context) {
      final MultiTabWorkbenchPanelView inj2072_MultiTabWorkbenchPanelView = new MultiTabWorkbenchPanelView();
      context.addBean(context.getBeanReference(MultiTabWorkbenchPanelView.class, arrayOf_19635043Annotation_52355314), inj2072_MultiTabWorkbenchPanelView);
      _618642634__153624969_dndManager(inj2072_MultiTabWorkbenchPanelView, inj2008_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2072_MultiTabWorkbenchPanelView, inj2001_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2072_MultiTabWorkbenchPanelView, inj2074_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2072_MultiTabWorkbenchPanelView, inj2075_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2072_MultiTabWorkbenchPanelView, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2072_MultiTabWorkbenchPanelView, init_inj2072_MultiTabWorkbenchPanelView);
      context.addDestructionCallback(inj2072_MultiTabWorkbenchPanelView, destroy_inj2072_MultiTabWorkbenchPanelView);
      return inj2072_MultiTabWorkbenchPanelView;
    }
  };
  private final BeanProvider<PartManager> inj2077_PartManager_creational = new BeanProvider<PartManager>() {
    public PartManager getInstance(final CreationalContext context) {
      final PartManager inj2076_PartManager = new PartManager();
      context.addBean(context.getBeanReference(PartManager.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2076_PartManager);
      return inj2076_PartManager;
    }
  };
  private final PartManager inj2076_PartManager = inj2077_PartManager_creational.getInstance(context);
  private final BeanProvider<LayoutPanelView> inj2079_LayoutPanelView_creational = new BeanProvider<LayoutPanelView>() {
    public LayoutPanelView getInstance(final CreationalContext context) {
      final LayoutPanelView inj2078_LayoutPanelView = new LayoutPanelView();
      context.addBean(context.getBeanReference(LayoutPanelView.class, arrayOf_19635043Annotation_891553467), inj2078_LayoutPanelView);
      _1420226898__$906533316_placeManager(inj2078_LayoutPanelView, inj2041_PlaceManagerImpl);
      _1420226898__443136474_partManager(inj2078_LayoutPanelView, inj2076_PartManager);
      return inj2078_LayoutPanelView;
    }
  };
  private final BeanProvider<ListBarWidget> inj2081_ListBarWidget_creational = new BeanProvider<ListBarWidget>() {
    public ListBarWidget getInstance(final CreationalContext context) {
      final ListBarWidget inj2080_ListBarWidget = new ListBarWidget();
      context.addBean(context.getBeanReference(ListBarWidget.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2080_ListBarWidget);
      _$924432381__$262319993_panelManager(inj2080_ListBarWidget, inj2003_PanelManagerImpl);
      _$924432381__$1574799830_authzManager(inj2080_ListBarWidget, inj2022_RuntimeAuthorizationManager);
      _$924432381__597466346_identity(inj2080_ListBarWidget, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      return inj2080_ListBarWidget;
    }
  };
  private final BeanProvider<ContextPanel> inj2084_ContextPanel_creational = new BeanProvider<ContextPanel>() {
    public ContextPanel getInstance(final CreationalContext context) {
      final ContextPanel inj1750_ContextPanel = new ContextPanel();
      context.addBean(context.getBeanReference(ContextPanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1750_ContextPanel);
      return inj1750_ContextPanel;
    }
  };
  private InitializationCallback<SimpleDnDWorkbenchPanelView> init_inj2082_SimpleDnDWorkbenchPanelView = new InitializationCallback<SimpleDnDWorkbenchPanelView>() {
    public void init(final SimpleDnDWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<SimpleDnDWorkbenchPanelView> destroy_inj2082_SimpleDnDWorkbenchPanelView = new DestructionCallback<SimpleDnDWorkbenchPanelView>() {
    public void destroy(final SimpleDnDWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<SimpleDnDWorkbenchPanelView> inj2083_SimpleDnDWorkbenchPanelView_creational = new BeanProvider<SimpleDnDWorkbenchPanelView>() {
    public SimpleDnDWorkbenchPanelView getInstance(final CreationalContext context) {
      final SimpleDnDWorkbenchPanelView inj2082_SimpleDnDWorkbenchPanelView = new SimpleDnDWorkbenchPanelView();
      context.addBean(context.getBeanReference(SimpleDnDWorkbenchPanelView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2082_SimpleDnDWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2082_SimpleDnDWorkbenchPanelView, inj2081_ListBarWidget_creational.getInstance(context));
      _1346204971__789713372_contextWidget(inj2082_SimpleDnDWorkbenchPanelView, inj2084_ContextPanel_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2082_SimpleDnDWorkbenchPanelView, inj2008_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2082_SimpleDnDWorkbenchPanelView, inj2001_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2082_SimpleDnDWorkbenchPanelView, inj2074_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2082_SimpleDnDWorkbenchPanelView, inj2075_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2082_SimpleDnDWorkbenchPanelView, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2082_SimpleDnDWorkbenchPanelView, init_inj2082_SimpleDnDWorkbenchPanelView);
      context.addDestructionCallback(inj2082_SimpleDnDWorkbenchPanelView, destroy_inj2082_SimpleDnDWorkbenchPanelView);
      return inj2082_SimpleDnDWorkbenchPanelView;
    }
  };
  private InitializationCallback<SimpleWorkbenchPanelView> init_inj2085_SimpleWorkbenchPanelView = new InitializationCallback<SimpleWorkbenchPanelView>() {
    public void init(final SimpleWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _1346204971_setup(obj);
    }
  };
  private DestructionCallback<SimpleWorkbenchPanelView> destroy_inj2085_SimpleWorkbenchPanelView = new DestructionCallback<SimpleWorkbenchPanelView>() {
    public void destroy(final SimpleWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<SimpleWorkbenchPanelView> inj2086_SimpleWorkbenchPanelView_creational = new BeanProvider<SimpleWorkbenchPanelView>() {
    public SimpleWorkbenchPanelView getInstance(final CreationalContext context) {
      final SimpleWorkbenchPanelView inj2085_SimpleWorkbenchPanelView = new SimpleWorkbenchPanelView();
      context.addBean(context.getBeanReference(SimpleWorkbenchPanelView.class, arrayOf_19635043Annotation_1084219910), inj2085_SimpleWorkbenchPanelView);
      _1346204971__$924432381_listBar(inj2085_SimpleWorkbenchPanelView, inj2081_ListBarWidget_creational.getInstance(context));
      _1346204971__789713372_contextWidget(inj2085_SimpleWorkbenchPanelView, inj2084_ContextPanel_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2085_SimpleWorkbenchPanelView, inj2008_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2085_SimpleWorkbenchPanelView, inj2001_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2085_SimpleWorkbenchPanelView, inj2074_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2085_SimpleWorkbenchPanelView, inj2075_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2085_SimpleWorkbenchPanelView, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2085_SimpleWorkbenchPanelView, init_inj2085_SimpleWorkbenchPanelView);
      context.addDestructionCallback(inj2085_SimpleWorkbenchPanelView, destroy_inj2085_SimpleWorkbenchPanelView);
      return inj2085_SimpleWorkbenchPanelView;
    }
  };
  private InitializationCallback<MultiListWorkbenchPanelView> init_inj2087_MultiListWorkbenchPanelView = new InitializationCallback<MultiListWorkbenchPanelView>() {
    public void init(final MultiListWorkbenchPanelView obj) {
      _618642634_setupDockingPanel(obj);
      _$821728441_setupMultiPartPanel(obj);
    }
  };
  private DestructionCallback<MultiListWorkbenchPanelView> destroy_inj2087_MultiListWorkbenchPanelView = new DestructionCallback<MultiListWorkbenchPanelView>() {
    public void destroy(final MultiListWorkbenchPanelView obj) {
      _618642634_tearDownDockingPanel(obj);
    }
  };
  private final BeanProvider<MultiListWorkbenchPanelView> inj2088_MultiListWorkbenchPanelView_creational = new BeanProvider<MultiListWorkbenchPanelView>() {
    public MultiListWorkbenchPanelView getInstance(final CreationalContext context) {
      final MultiListWorkbenchPanelView inj2087_MultiListWorkbenchPanelView = new MultiListWorkbenchPanelView();
      context.addBean(context.getBeanReference(MultiListWorkbenchPanelView.class, arrayOf_19635043Annotation_1664445436), inj2087_MultiListWorkbenchPanelView);
      _474272692__$924432381_listBar(inj2087_MultiListWorkbenchPanelView, inj2081_ListBarWidget_creational.getInstance(context));
      _618642634__153624969_dndManager(inj2087_MultiListWorkbenchPanelView, inj2008_WorkbenchDragAndDropManager);
      _618642634__$1887041540_factory(inj2087_MultiListWorkbenchPanelView, inj2001_DefaultBeanFactory);
      _618642634__$634457504_topLevelWidget(inj2087_MultiListWorkbenchPanelView, inj2074_SimpleLayoutPanel_creational.getInstance(context));
      _618642634__820873068_partViewContainer(inj2087_MultiListWorkbenchPanelView, inj2075_ResizeFlowPanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2087_MultiListWorkbenchPanelView, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2087_MultiListWorkbenchPanelView, init_inj2087_MultiListWorkbenchPanelView);
      context.addDestructionCallback(inj2087_MultiListWorkbenchPanelView, destroy_inj2087_MultiListWorkbenchPanelView);
      return inj2087_MultiListWorkbenchPanelView;
    }
  };
  private final BeanProvider<TemplatedWorkbenchPanelView> inj2090_TemplatedWorkbenchPanelView_creational = new BeanProvider<TemplatedWorkbenchPanelView>() {
    public TemplatedWorkbenchPanelView getInstance(final CreationalContext context) {
      final TemplatedWorkbenchPanelView inj2089_TemplatedWorkbenchPanelView = new TemplatedWorkbenchPanelView();
      context.addBean(context.getBeanReference(TemplatedWorkbenchPanelView.class, arrayOf_19635043Annotation_1634264068), inj2089_TemplatedWorkbenchPanelView);
      return inj2089_TemplatedWorkbenchPanelView;
    }
  };
  private final BeanProvider<StaticFocusedResizePanel> inj2093_StaticFocusedResizePanel_creational = new BeanProvider<StaticFocusedResizePanel>() {
    public StaticFocusedResizePanel getInstance(final CreationalContext context) {
      final StaticFocusedResizePanel inj1407_StaticFocusedResizePanel = new StaticFocusedResizePanel();
      context.addBean(context.getBeanReference(StaticFocusedResizePanel.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1407_StaticFocusedResizePanel);
      return inj1407_StaticFocusedResizePanel;
    }
  };
  private InitializationCallback<StaticWorkbenchPanelView> init_inj2091_StaticWorkbenchPanelView = new InitializationCallback<StaticWorkbenchPanelView>() {
    public void init(final StaticWorkbenchPanelView obj) {
      _$896357979_postConstruct(obj);
    }
  };
  private final BeanProvider<StaticWorkbenchPanelView> inj2092_StaticWorkbenchPanelView_creational = new BeanProvider<StaticWorkbenchPanelView>() {
    public StaticWorkbenchPanelView getInstance(final CreationalContext context) {
      final StaticWorkbenchPanelView inj2091_StaticWorkbenchPanelView = new StaticWorkbenchPanelView();
      context.addBean(context.getBeanReference(StaticWorkbenchPanelView.class, arrayOf_19635043Annotation_968424154), inj2091_StaticWorkbenchPanelView);
      _$896357979__$906533316_placeManager(inj2091_StaticWorkbenchPanelView, inj2041_PlaceManagerImpl);
      _$896357979__$1655162226_panel(inj2091_StaticWorkbenchPanelView, inj2093_StaticFocusedResizePanel_creational.getInstance(context));
      _$1397438695__$262319993_panelManager(inj2091_StaticWorkbenchPanelView, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2091_StaticWorkbenchPanelView, init_inj2091_StaticWorkbenchPanelView);
      return inj2091_StaticWorkbenchPanelView;
    }
  };
  private InitializationCallback<MultiTabWorkbenchPanelPresenter> init_inj2094_MultiTabWorkbenchPanelPresenter = new InitializationCallback<MultiTabWorkbenchPanelPresenter>() {
    public void init(final MultiTabWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<MultiTabWorkbenchPanelPresenter> inj2095_MultiTabWorkbenchPanelPresenter_creational = new BeanProvider<MultiTabWorkbenchPanelPresenter>() {
    public MultiTabWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var22 = inj2073_MultiTabWorkbenchPanelView_creational.getInstance(context);
      final ActivityManager var23 = inj2035_ActivityManagerImpl;
      final PerspectiveManager var24 = inj2039_PerspectiveManagerImpl;
      final Event var25 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final MultiTabWorkbenchPanelPresenter inj2094_MultiTabWorkbenchPanelPresenter = new MultiTabWorkbenchPanelPresenter(var22, var23, var24, var25);
      context.addBean(context.getBeanReference(MultiTabWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2094_MultiTabWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2094_MultiTabWorkbenchPanelPresenter, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2094_MultiTabWorkbenchPanelPresenter, init_inj2094_MultiTabWorkbenchPanelPresenter);
      return inj2094_MultiTabWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<CustomSplashHelp> inj2097_CustomSplashHelp_creational = new BeanProvider<CustomSplashHelp>() {
    public CustomSplashHelp getInstance(final CreationalContext context) {
      final CustomSplashHelp inj2096_CustomSplashHelp = new CustomSplashHelp();
      context.addBean(context.getBeanReference(CustomSplashHelp.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2096_CustomSplashHelp);
      return inj2096_CustomSplashHelp;
    }
  };
  private final CustomSplashHelp inj2096_CustomSplashHelp = inj2097_CustomSplashHelp_creational.getInstance(context);
  private final BeanProvider<EventBus> inj1948_EventBus_creational = new BeanProvider<EventBus>() {
    public EventBus getInstance(CreationalContext pContext) {
      EventBus var26 = _$1757102468_produceEventBus(inj2041_PlaceManagerImpl);
      context.addBean(context.getBeanReference(EventBus.class, QualifierUtil.DEFAULT_QUALIFIERS), var26);
      return var26;
    }
  };
  private final BeanProvider<AnyResourceType> inj2099_AnyResourceType_creational = new BeanProvider<AnyResourceType>() {
    public AnyResourceType getInstance(final CreationalContext context) {
      final AnyResourceType inj2098_AnyResourceType = new AnyResourceType();
      context.addBean(context.getBeanReference(AnyResourceType.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2098_AnyResourceType);
      return inj2098_AnyResourceType;
    }
  };
  private final AnyResourceType inj2098_AnyResourceType = inj2099_AnyResourceType_creational.getInstance(context);
  private final BeanProvider<DisposerProvider> inj2100_DisposerProvider_creational = new BeanProvider<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj1986_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1986_DisposerProvider);
      _$1300398733__$652658075_beanManager(inj1986_DisposerProvider, inj1968_IOCBeanManagerProvider.get());
      return inj1986_DisposerProvider;
    }
  };
  private final DisposerProvider inj1986_DisposerProvider = inj2100_DisposerProvider_creational.getInstance(context);
  private InitializationCallback<WelcomeScreen> init_inj2101_WelcomeScreen = new InitializationCallback<WelcomeScreen>() {
    public void init(final WelcomeScreen obj) {
      obj.init();
    }
  };
  private final BeanProvider<WelcomeScreen> inj2102_WelcomeScreen_creational = new BeanProvider<WelcomeScreen>() {
    public WelcomeScreen getInstance(final CreationalContext context) {
      final WelcomeScreen inj2101_WelcomeScreen = new WelcomeScreen();
      context.addBean(context.getBeanReference(WelcomeScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2101_WelcomeScreen);
      context.addInitializationCallback(inj2101_WelcomeScreen, init_inj2101_WelcomeScreen);
      return inj2101_WelcomeScreen;
    }
  };
  private final BeanProvider<HelloWorldScreen> inj2104_HelloWorldScreen_creational = new BeanProvider<HelloWorldScreen>() {
    public HelloWorldScreen getInstance(final CreationalContext context) {
      final HelloWorldScreen inj2103_HelloWorldScreen = new HelloWorldScreen();
      context.addBean(context.getBeanReference(HelloWorldScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2103_HelloWorldScreen);
      final Subscription var27 = CDI.subscribeLocal("org.uberfire.client.ShowcaseEntryPoint$DumpLayout", new AbstractCDIEventCallback<DumpLayout>() {
        public void fireEvent(final DumpLayout event) {
          inj2103_HelloWorldScreen.dumpLayout(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.ShowcaseEntryPoint$DumpLayout []";
        }
      });
      context.addDestructionCallback(inj2103_HelloWorldScreen, new DestructionCallback<HelloWorldScreen>() {
        public void destroy(final HelloWorldScreen obj) {
          var27.remove();
          // WEEEEE!;
        }
      });
      return inj2103_HelloWorldScreen;
    }
  };
  private final BeanProvider<HelloWorldScreenActivity> inj2106_HelloWorldScreenActivity_creational = new BeanProvider<HelloWorldScreenActivity>() {
    public HelloWorldScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var28 = inj2041_PlaceManagerImpl;
      final HelloWorldScreenActivity inj2105_HelloWorldScreenActivity = new HelloWorldScreenActivity(var28);
      context.addBean(context.getBeanReference(HelloWorldScreenActivity.class, arrayOf_19635043Annotation_259736363), inj2105_HelloWorldScreenActivity);
      _1095151889__960584674_realPresenter(inj2105_HelloWorldScreenActivity, inj2104_HelloWorldScreen_creational.getInstance(context));
      return inj2105_HelloWorldScreenActivity;
    }
  };
  private final BeanProvider<VFSJSExporter> inj2108_VFSJSExporter_creational = new BeanProvider<VFSJSExporter>() {
    public VFSJSExporter getInstance(final CreationalContext context) {
      final VFSJSExporter inj2107_VFSJSExporter = new VFSJSExporter();
      context.addBean(context.getBeanReference(VFSJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2107_VFSJSExporter);
      _$1254526097__120980481_vfsServices(inj2107_VFSJSExporter, inj1984_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj2107_VFSJSExporter;
    }
  };
  private final VFSJSExporter inj2107_VFSJSExporter = inj2108_VFSJSExporter_creational.getInstance(context);
  private InitializationCallback<ClientTypeRegistryImpl> init_inj2109_ClientTypeRegistryImpl = new InitializationCallback<ClientTypeRegistryImpl>() {
    public void init(final ClientTypeRegistryImpl obj) {
      obj.init();
    }
  };
  private final BeanProvider<ClientTypeRegistryImpl> inj2110_ClientTypeRegistryImpl_creational = new BeanProvider<ClientTypeRegistryImpl>() {
    public ClientTypeRegistryImpl getInstance(final CreationalContext context) {
      final SyncBeanManager var29 = inj1968_IOCBeanManagerProvider.get();
      final ClientTypeRegistryImpl inj2109_ClientTypeRegistryImpl = new ClientTypeRegistryImpl(var29);
      context.addBean(context.getBeanReference(ClientTypeRegistryImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2109_ClientTypeRegistryImpl);
      context.addInitializationCallback(inj2109_ClientTypeRegistryImpl, init_inj2109_ClientTypeRegistryImpl);
      return inj2109_ClientTypeRegistryImpl;
    }
  };
  private final ClientTypeRegistryImpl inj2109_ClientTypeRegistryImpl = inj2110_ClientTypeRegistryImpl_creational.getInstance(context);
  private InitializationCallback<TemplatedWorkbenchPanelPresenter> init_inj2111_TemplatedWorkbenchPanelPresenter = new InitializationCallback<TemplatedWorkbenchPanelPresenter>() {
    public void init(final TemplatedWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<TemplatedWorkbenchPanelPresenter> inj2112_TemplatedWorkbenchPanelPresenter_creational = new BeanProvider<TemplatedWorkbenchPanelPresenter>() {
    public TemplatedWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final TemplatedWorkbenchPanelView var30 = inj2090_TemplatedWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var31 = inj2039_PerspectiveManagerImpl;
      final Event var32 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final TemplatedWorkbenchPanelPresenter inj2111_TemplatedWorkbenchPanelPresenter = new TemplatedWorkbenchPanelPresenter(var30, var31, var32);
      context.addBean(context.getBeanReference(TemplatedWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2111_TemplatedWorkbenchPanelPresenter);
      context.addInitializationCallback(inj2111_TemplatedWorkbenchPanelPresenter, init_inj2111_TemplatedWorkbenchPanelPresenter);
      return inj2111_TemplatedWorkbenchPanelPresenter;
    }
  };
  private InitializationCallback<LayoutPanelPresenter> init_inj2113_LayoutPanelPresenter = new InitializationCallback<LayoutPanelPresenter>() {
    public void init(final LayoutPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<LayoutPanelPresenter> inj2114_LayoutPanelPresenter_creational = new BeanProvider<LayoutPanelPresenter>() {
    public LayoutPanelPresenter getInstance(final CreationalContext context) {
      final LayoutPanelView var33 = inj2079_LayoutPanelView_creational.getInstance(context);
      final PerspectiveManager var34 = inj2039_PerspectiveManagerImpl;
      final Event var35 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final LayoutPanelPresenter inj2113_LayoutPanelPresenter = new LayoutPanelPresenter(var33, var34, var35);
      context.addBean(context.getBeanReference(LayoutPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2113_LayoutPanelPresenter);
      context.addInitializationCallback(inj2113_LayoutPanelPresenter, init_inj2113_LayoutPanelPresenter);
      return inj2113_LayoutPanelPresenter;
    }
  };
  private final BeanProvider<UberfireComponentsJSExporter> inj2116_UberfireComponentsJSExporter_creational = new BeanProvider<UberfireComponentsJSExporter>() {
    public UberfireComponentsJSExporter getInstance(final CreationalContext context) {
      final UberfireComponentsJSExporter inj2115_UberfireComponentsJSExporter = new UberfireComponentsJSExporter();
      context.addBean(context.getBeanReference(UberfireComponentsJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2115_UberfireComponentsJSExporter);
      _57041102__$1583970232_activityManager(inj2115_UberfireComponentsJSExporter, inj2035_ActivityManagerImpl);
      final Subscription var36 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ApplicationReadyEvent", new AbstractCDIEventCallback<ApplicationReadyEvent>() {
        public void fireEvent(final ApplicationReadyEvent event) {
          inj2115_UberfireComponentsJSExporter.export(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ApplicationReadyEvent []";
        }
      });
      context.addDestructionCallback(inj2115_UberfireComponentsJSExporter, new DestructionCallback<UberfireComponentsJSExporter>() {
        public void destroy(final UberfireComponentsJSExporter obj) {
          var36.remove();
          // WEEEEE!;
        }
      });
      return inj2115_UberfireComponentsJSExporter;
    }
  };
  private final UberfireComponentsJSExporter inj2115_UberfireComponentsJSExporter = inj2116_UberfireComponentsJSExporter_creational.getInstance(context);
  private final BeanProvider<StandaloneEditorPerspective> inj2118_StandaloneEditorPerspective_creational = new BeanProvider<StandaloneEditorPerspective>() {
    public StandaloneEditorPerspective getInstance(final CreationalContext context) {
      final PlaceManager var37 = inj2041_PlaceManagerImpl;
      final StandaloneEditorPerspective inj2117_StandaloneEditorPerspective = new StandaloneEditorPerspective(var37);
      context.addBean(context.getBeanReference(StandaloneEditorPerspective.class, arrayOf_19635043Annotation_1283183184), inj2117_StandaloneEditorPerspective);
      return inj2117_StandaloneEditorPerspective;
    }
  };
  private final BeanProvider<MenuSplashList> inj2120_MenuSplashList_creational = new BeanProvider<MenuSplashList>() {
    public MenuSplashList getInstance(final CreationalContext context) {
      final MenuSplashList inj2119_MenuSplashList = new MenuSplashList();
      context.addBean(context.getBeanReference(MenuSplashList.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2119_MenuSplashList);
      _$1340452412__$906533316_placeManager(inj2119_MenuSplashList, inj2041_PlaceManagerImpl);
      final Subscription var38 = CDI.subscribeLocal("org.uberfire.client.workbench.events.NewSplashScreenActiveEvent", new AbstractCDIEventCallback<NewSplashScreenActiveEvent>() {
        public void fireEvent(final NewSplashScreenActiveEvent event) {
          _$1340452412_onNewSplash_NewSplashScreenActiveEvent(inj2119_MenuSplashList, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.NewSplashScreenActiveEvent []";
        }
      });
      context.addDestructionCallback(inj2119_MenuSplashList, new DestructionCallback<MenuSplashList>() {
        public void destroy(final MenuSplashList obj) {
          var38.remove();
          // WEEEEE!;
        }
      });
      return inj2119_MenuSplashList;
    }
  };
  private final MenuSplashList inj2119_MenuSplashList = inj2120_MenuSplashList_creational.getInstance(context);
  private final BeanProvider<HomePerspective> inj2122_HomePerspective_creational = new BeanProvider<HomePerspective>() {
    public HomePerspective getInstance(final CreationalContext context) {
      final HomePerspective inj2121_HomePerspective = new HomePerspective();
      context.addBean(context.getBeanReference(HomePerspective.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2121_HomePerspective);
      context.addInitializationCallback(inj2121_HomePerspective, new InitializationCallback<HomePerspective>() {
        public void init(final HomePerspective obj) {
          org_uberfire_client_HomePerspectiveTemplateResource var39 = GWT.create(org_uberfire_client_HomePerspectiveTemplateResource.class);
          Element var40 = TemplateUtil.getRootTemplateElement(var39.getContents().getText(), "");
          TemplateUtil.translateTemplate("org/uberfire/client/HomePerspective.html", var40);
          Map<String, Element> var41 = TemplateUtil.getDataFieldElements(var40);
          Map<String, Widget> var42 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.HomePerspective", "org/uberfire/client/HomePerspective.html", _$1083291890__421004336_moodScreen(inj2121_HomePerspective), var41, "moodScreen");
          TemplateUtil.compositeComponentReplace("org.uberfire.client.HomePerspective", "org/uberfire/client/HomePerspective.html", _$1083291890__421004336_homeScreen(inj2121_HomePerspective), var41, "homeScreen");
          TemplateUtil.compositeComponentReplace("org.uberfire.client.HomePerspective", "org/uberfire/client/HomePerspective.html", _$1083291890__421004336_anotherScreen(inj2121_HomePerspective), var41, "anotherScreen");
          var42.put("moodScreen", _$1083291890__421004336_moodScreen(inj2121_HomePerspective));
          var42.put("homeScreen", _$1083291890__421004336_homeScreen(inj2121_HomePerspective));
          var42.put("anotherScreen", _$1083291890__421004336_anotherScreen(inj2121_HomePerspective));
          TemplateUtil.initWidget(inj2121_HomePerspective, var40, var42.values());
        }
      });
      return inj2121_HomePerspective;
    }
  };
  private final HomePerspective inj2121_HomePerspective = inj2122_HomePerspective_creational.getInstance(context);
  private final BeanProvider<HomePerspectiveActivity> inj2124_HomePerspectiveActivity_creational = new BeanProvider<HomePerspectiveActivity>() {
    public HomePerspectiveActivity getInstance(final CreationalContext context) {
      final PlaceManager var43 = inj2041_PlaceManagerImpl;
      final HomePerspectiveActivity inj2123_HomePerspectiveActivity = new HomePerspectiveActivity(var43);
      context.addBean(context.getBeanReference(HomePerspectiveActivity.class, arrayOf_19635043Annotation_1853576499), inj2123_HomePerspectiveActivity);
      _689680445__$1083291890_realPresenter(inj2123_HomePerspectiveActivity, inj2121_HomePerspective);
      return inj2123_HomePerspectiveActivity;
    }
  };
  private final BeanProvider<TransitionAnchorProvider> inj2125_TransitionAnchorProvider_creational = new BeanProvider<TransitionAnchorProvider>() {
    public TransitionAnchorProvider getInstance(final CreationalContext context) {
      final TransitionAnchorProvider inj1982_TransitionAnchorProvider = new TransitionAnchorProvider();
      context.addBean(context.getBeanReference(TransitionAnchorProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1982_TransitionAnchorProvider);
      _$1034438370__136504311_navigation(inj1982_TransitionAnchorProvider, inj2014_Navigation);
      return inj1982_TransitionAnchorProvider;
    }
  };
  private final TransitionAnchorProvider inj1982_TransitionAnchorProvider = inj2125_TransitionAnchorProvider_creational.getInstance(context);
  private final BeanProvider<TransitionAnchorFactoryProvider> inj2126_TransitionAnchorFactoryProvider_creational = new BeanProvider<TransitionAnchorFactoryProvider>() {
    public TransitionAnchorFactoryProvider getInstance(final CreationalContext context) {
      final TransitionAnchorFactoryProvider inj1988_TransitionAnchorFactoryProvider = new TransitionAnchorFactoryProvider();
      context.addBean(context.getBeanReference(TransitionAnchorFactoryProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1988_TransitionAnchorFactoryProvider);
      _1496760654__136504311_navigation(inj1988_TransitionAnchorFactoryProvider, inj2014_Navigation);
      return inj1988_TransitionAnchorFactoryProvider;
    }
  };
  private final TransitionAnchorFactoryProvider inj1988_TransitionAnchorFactoryProvider = inj2126_TransitionAnchorFactoryProvider_creational.getInstance(context);
  private final BeanProvider<PageTransitionProvider> inj2127_PageTransitionProvider_creational = new BeanProvider<PageTransitionProvider>() {
    public PageTransitionProvider getInstance(final CreationalContext context) {
      final PageTransitionProvider inj1954_PageTransitionProvider = new PageTransitionProvider();
      context.addBean(context.getBeanReference(PageTransitionProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1954_PageTransitionProvider);
      return inj1954_PageTransitionProvider;
    }
  };
  private final PageTransitionProvider inj1954_PageTransitionProvider = inj2127_PageTransitionProvider_creational.getInstance(context);
  private final BeanProvider<ClientRequiredRolesExtractorImpl> inj2129_ClientRequiredRolesExtractorImpl_creational = new BeanProvider<ClientRequiredRolesExtractorImpl>() {
    public ClientRequiredRolesExtractorImpl getInstance(final CreationalContext context) {
      final ClientRequiredRolesExtractorImpl inj2128_ClientRequiredRolesExtractorImpl = new ClientRequiredRolesExtractorImpl();
      context.addBean(context.getBeanReference(ClientRequiredRolesExtractorImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2128_ClientRequiredRolesExtractorImpl);
      return inj2128_ClientRequiredRolesExtractorImpl;
    }
  };
  private final BeanProvider<ClientSecurityRoleInterceptor> inj2131_ClientSecurityRoleInterceptor_creational = new BeanProvider<ClientSecurityRoleInterceptor>() {
    public ClientSecurityRoleInterceptor getInstance(final CreationalContext context) {
      final SecurityContext var44 = inj2020_SecurityContextImpl;
      final RequiredRolesExtractor var45 = inj2129_ClientRequiredRolesExtractorImpl_creational.getInstance(context);
      final ClientSecurityRoleInterceptor inj2130_ClientSecurityRoleInterceptor = new ClientSecurityRoleInterceptor(var44, var45);
      context.addBean(context.getBeanReference(ClientSecurityRoleInterceptor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2130_ClientSecurityRoleInterceptor);
      return inj2130_ClientSecurityRoleInterceptor;
    }
  };
  private final BeanProvider<RootPanelProvider> inj2132_RootPanelProvider_creational = new BeanProvider<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj1964_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1964_RootPanelProvider);
      return inj1964_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj1964_RootPanelProvider = inj2132_RootPanelProvider_creational.getInstance(context);
  private final BeanProvider<UberfireJSAPIExporter> inj2134_UberfireJSAPIExporter_creational = new BeanProvider<UberfireJSAPIExporter>() {
    public UberfireJSAPIExporter getInstance(final CreationalContext context) {
      final UberfireJSAPIExporter inj2133_UberfireJSAPIExporter = new UberfireJSAPIExporter();
      context.addBean(context.getBeanReference(UberfireJSAPIExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2133_UberfireJSAPIExporter);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2133_UberfireJSAPIExporter.export();
        }
      });
      return inj2133_UberfireJSAPIExporter;
    }
  };
  private final UberfireJSAPIExporter inj2133_UberfireJSAPIExporter = inj2134_UberfireJSAPIExporter_creational.getInstance(context);
  private final BeanProvider<VFSServiceProxyClientImpl> inj2136_VFSServiceProxyClientImpl_creational = new BeanProvider<VFSServiceProxyClientImpl>() {
    public VFSServiceProxyClientImpl getInstance(final CreationalContext context) {
      final VFSServiceProxyClientImpl inj2135_VFSServiceProxyClientImpl = new VFSServiceProxyClientImpl();
      context.addBean(context.getBeanReference(VFSServiceProxyClientImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2135_VFSServiceProxyClientImpl);
      return inj2135_VFSServiceProxyClientImpl;
    }
  };
  private InitializationCallback<Workbench> init_inj2137_Workbench = new InitializationCallback<Workbench>() {
    public void init(final Workbench obj) {
      _$1462522111_earlyInit(obj);
    }
  };
  private final BeanProvider<Workbench> inj2138_Workbench_creational = new BeanProvider<Workbench>() {
    public Workbench getInstance(final CreationalContext context) {
      final Workbench inj2137_Workbench = new Workbench();
      context.addBean(context.getBeanReference(Workbench.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2137_Workbench);
      _$1462522111__1116818801_appReady(inj2137_Workbench, inj1980_EventProvider.provide(new Class[] { ApplicationReadyEvent.class }, null));
      _$1462522111__$652658075_iocManager(inj2137_Workbench, inj1968_IOCBeanManagerProvider.get());
      _$1462522111__$906533316_placeManager(inj2137_Workbench, inj2041_PlaceManagerImpl);
      _$1462522111__$715182114_vfsService(inj2137_Workbench, inj2136_VFSServiceProxyClientImpl_creational.getInstance(context));
      _$1462522111__$1825231548_layoutSelection(inj2137_Workbench, inj1998_LayoutSelection);
      _$1462522111__597466346_identity(inj2137_Workbench, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      _$1462522111__879292651_bus(inj2137_Workbench, inj1956_MessageBusProvider.get());
      _$1462522111__1730751009_uberfireContext(inj2137_Workbench, inj1995_UberfireContextDefaultImpl);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          _$1462522111_startIfNotBlocked(inj2137_Workbench);
        }
      });
      context.addInitializationCallback(inj2137_Workbench, init_inj2137_Workbench);
      return inj2137_Workbench;
    }
  };
  private final Workbench inj2137_Workbench = inj2138_Workbench_creational.getInstance(context);
  private InitializationCallback<StaticWorkbenchPanelPresenter> init_inj2139_StaticWorkbenchPanelPresenter = new InitializationCallback<StaticWorkbenchPanelPresenter>() {
    public void init(final StaticWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<StaticWorkbenchPanelPresenter> inj2140_StaticWorkbenchPanelPresenter_creational = new BeanProvider<StaticWorkbenchPanelPresenter>() {
    public StaticWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final StaticWorkbenchPanelView var46 = inj2092_StaticWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var47 = inj2039_PerspectiveManagerImpl;
      final Event var48 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final StaticWorkbenchPanelPresenter inj2139_StaticWorkbenchPanelPresenter = new StaticWorkbenchPanelPresenter(var46, var47, var48);
      context.addBean(context.getBeanReference(StaticWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2139_StaticWorkbenchPanelPresenter);
      context.addInitializationCallback(inj2139_StaticWorkbenchPanelPresenter, init_inj2139_StaticWorkbenchPanelPresenter);
      return inj2139_StaticWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<TransitionToRoleProvider> inj2141_TransitionToRoleProvider_creational = new BeanProvider<TransitionToRoleProvider>() {
    public TransitionToRoleProvider getInstance(final CreationalContext context) {
      final TransitionToRoleProvider inj1966_TransitionToRoleProvider = new TransitionToRoleProvider();
      context.addBean(context.getBeanReference(TransitionToRoleProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1966_TransitionToRoleProvider);
      return inj1966_TransitionToRoleProvider;
    }
  };
  private final TransitionToRoleProvider inj1966_TransitionToRoleProvider = inj2141_TransitionToRoleProvider_creational.getInstance(context);
  private final BeanProvider<SecurityRolesConstraintPage> inj2142_SecurityRolesConstraintPage_creational = new BeanProvider<SecurityRolesConstraintPage>() {
    public SecurityRolesConstraintPage getInstance(final CreationalContext context) {
      final SecurityRolesConstraintPage inj167_SecurityRolesConstraintPage = new SecurityRolesConstraintPage();
      context.addBean(context.getBeanReference(SecurityRolesConstraintPage.class, QualifierUtil.DEFAULT_QUALIFIERS), inj167_SecurityRolesConstraintPage);
      _1084732347__314455785_loginTransition(inj167_SecurityRolesConstraintPage, inj1966_TransitionToRoleProvider.provide(new Class[] { LoginPage.class }, null));
      _1084732347__314455785_securityErrorTransition(inj167_SecurityRolesConstraintPage, inj1966_TransitionToRoleProvider.provide(new Class[] { SecurityError.class }, null));
      return inj167_SecurityRolesConstraintPage;
    }
  };
  private final BeanProvider<InitBallotProvider> inj2143_InitBallotProvider_creational = new BeanProvider<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj1978_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1978_InitBallotProvider);
      return inj1978_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj1978_InitBallotProvider = inj2143_InitBallotProvider_creational.getInstance(context);
  private final BeanProvider<SplashScreenJSExporter> inj2145_SplashScreenJSExporter_creational = new BeanProvider<SplashScreenJSExporter>() {
    public SplashScreenJSExporter getInstance(final CreationalContext context) {
      final SplashScreenJSExporter inj2144_SplashScreenJSExporter = new SplashScreenJSExporter();
      context.addBean(context.getBeanReference(SplashScreenJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2144_SplashScreenJSExporter);
      return inj2144_SplashScreenJSExporter;
    }
  };
  private final SplashScreenJSExporter inj2144_SplashScreenJSExporter = inj2145_SplashScreenJSExporter_creational.getInstance(context);
  private InitializationCallback<LessStyle> init_inj2146_LessStyle = new InitializationCallback<LessStyle>() {
    public void init(final LessStyle obj) {
      obj.init();
    }
  };
  private final BeanProvider<LessStyle> inj2147_LessStyle_creational = new BeanProvider<LessStyle>() {
    public LessStyle getInstance(final CreationalContext context) {
      final LessStyle inj2146_LessStyle = new LessStyle();
      context.addBean(context.getBeanReference(LessStyle.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2146_LessStyle);
      context.addInitializationCallback(inj2146_LessStyle, init_inj2146_LessStyle);
      return inj2146_LessStyle;
    }
  };
  private final LessStyle inj2146_LessStyle = inj2147_LessStyle_creational.getInstance(context);
  private InitializationCallback<MultiListWorkbenchPanelPresenter> init_inj2148_MultiListWorkbenchPanelPresenter = new InitializationCallback<MultiListWorkbenchPanelPresenter>() {
    public void init(final MultiListWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<MultiListWorkbenchPanelPresenter> inj2149_MultiListWorkbenchPanelPresenter_creational = new BeanProvider<MultiListWorkbenchPanelPresenter>() {
    public MultiListWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var49 = inj2088_MultiListWorkbenchPanelView_creational.getInstance(context);
      final ActivityManager var50 = inj2035_ActivityManagerImpl;
      final PerspectiveManager var51 = inj2039_PerspectiveManagerImpl;
      final Event var52 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final MultiListWorkbenchPanelPresenter inj2148_MultiListWorkbenchPanelPresenter = new MultiListWorkbenchPanelPresenter(var49, var50, var51, var52);
      context.addBean(context.getBeanReference(MultiListWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2148_MultiListWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2148_MultiListWorkbenchPanelPresenter, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2148_MultiListWorkbenchPanelPresenter, init_inj2148_MultiListWorkbenchPanelPresenter);
      return inj2148_MultiListWorkbenchPanelPresenter;
    }
  };
  private InitializationCallback<HomeScreen> init_inj2150_HomeScreen = new InitializationCallback<HomeScreen>() {
    public void init(final HomeScreen obj) {
      _$464592863_postConstruct(obj);
    }
  };
  private DestructionCallback<HomeScreen> destroy_inj2150_HomeScreen = new DestructionCallback<HomeScreen>() {
    public void destroy(final HomeScreen obj) {
      _$464592863_preDestroy(obj);
    }
  };
  private final BeanProvider<HomeScreen> inj2151_HomeScreen_creational = new BeanProvider<HomeScreen>() {
    public HomeScreen getInstance(final CreationalContext context) {
      final HomeScreen inj2150_HomeScreen = new HomeScreen();
      context.addBean(context.getBeanReference(HomeScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2150_HomeScreen);
      final Subscription var53 = CDI.subscribeLocal("org.uberfire.shared.Mood", new AbstractCDIEventCallback<Mood>() {
        public void fireEvent(final Mood event) {
          inj2150_HomeScreen.onMoodChange(event);
        }
        public String toString() {
          return "Observer: org.uberfire.shared.Mood []";
        }
      });
      context.addDestructionCallback(inj2150_HomeScreen, new DestructionCallback<HomeScreen>() {
        public void destroy(final HomeScreen obj) {
          var53.remove();
          // WEEEEE!;
        }
      });
      final Subscription var54 = CDI.subscribeLocal("org.uberfire.client.ShowcaseEntryPoint$DumpLayout", new AbstractCDIEventCallback<DumpLayout>() {
        public void fireEvent(final DumpLayout event) {
          inj2150_HomeScreen.dumpHierarchy(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.ShowcaseEntryPoint$DumpLayout []";
        }
      });
      context.addDestructionCallback(inj2150_HomeScreen, new DestructionCallback<HomeScreen>() {
        public void destroy(final HomeScreen obj) {
          var54.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2150_HomeScreen, init_inj2150_HomeScreen);
      context.addDestructionCallback(inj2150_HomeScreen, destroy_inj2150_HomeScreen);
      return inj2150_HomeScreen;
    }
  };
  private final BeanProvider<AccessImpl> inj2153_AccessImpl_creational = new BeanProvider<AccessImpl>() {
    public AccessImpl getInstance(final CreationalContext context) {
      final AccessImpl inj2152_AccessImpl = new AccessImpl();
      context.addBean(context.getBeanReference(AccessImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2152_AccessImpl);
      return inj2152_AccessImpl;
    }
  };
  private final BeanProvider<DataBinderProvider> inj2154_DataBinderProvider_creational = new BeanProvider<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj1974_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1974_DataBinderProvider);
      return inj1974_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj1974_DataBinderProvider = inj2154_DataBinderProvider_creational.getInstance(context);
  private final BeanProvider<WelcomeScreenActivity> inj2156_WelcomeScreenActivity_creational = new BeanProvider<WelcomeScreenActivity>() {
    public WelcomeScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var55 = inj2041_PlaceManagerImpl;
      final WelcomeScreenActivity inj2155_WelcomeScreenActivity = new WelcomeScreenActivity(var55);
      context.addBean(context.getBeanReference(WelcomeScreenActivity.class, arrayOf_19635043Annotation_945122451), inj2155_WelcomeScreenActivity);
      _$1351718937__501237944_realPresenter(inj2155_WelcomeScreenActivity, inj2102_WelcomeScreen_creational.getInstance(context));
      return inj2155_WelcomeScreenActivity;
    }
  };
  private final BeanProvider<SessionInfo> inj1949_SessionInfo_creational = new BeanProvider<SessionInfo>() {
    public SessionInfo getInstance(CreationalContext pContext) {
      SessionInfo var56 = _$1462522111_currentSession(inj2137_Workbench);
      context.addBean(context.getBeanReference(SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS), var56);
      return var56;
    }
  };
  private final BeanProvider<HomeScreenActivity> inj2158_HomeScreenActivity_creational = new BeanProvider<HomeScreenActivity>() {
    public HomeScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var57 = inj2041_PlaceManagerImpl;
      final HomeScreenActivity inj2157_HomeScreenActivity = new HomeScreenActivity(var57);
      context.addBean(context.getBeanReference(HomeScreenActivity.class, arrayOf_19635043Annotation_1828304098), inj2157_HomeScreenActivity);
      _1432847952__$464592863_realPresenter(inj2157_HomeScreenActivity, inj2151_HomeScreen_creational.getInstance(context));
      return inj2157_HomeScreenActivity;
    }
  };
  private final BeanProvider<PlaceManagerJSExporter> inj2160_PlaceManagerJSExporter_creational = new BeanProvider<PlaceManagerJSExporter>() {
    public PlaceManagerJSExporter getInstance(final CreationalContext context) {
      final PlaceManagerJSExporter inj2159_PlaceManagerJSExporter = new PlaceManagerJSExporter();
      context.addBean(context.getBeanReference(PlaceManagerJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2159_PlaceManagerJSExporter);
      return inj2159_PlaceManagerJSExporter;
    }
  };
  private final PlaceManagerJSExporter inj2159_PlaceManagerJSExporter = inj2160_PlaceManagerJSExporter_creational.getInstance(context);
  private InitializationCallback<SimpleWorkbenchPanelPresenter> init_inj2161_SimpleWorkbenchPanelPresenter = new InitializationCallback<SimpleWorkbenchPanelPresenter>() {
    public void init(final SimpleWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SimpleWorkbenchPanelPresenter> inj2162_SimpleWorkbenchPanelPresenter_creational = new BeanProvider<SimpleWorkbenchPanelPresenter>() {
    public SimpleWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var58 = inj2086_SimpleWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var59 = inj2039_PerspectiveManagerImpl;
      final Event var60 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final SimpleWorkbenchPanelPresenter inj2161_SimpleWorkbenchPanelPresenter = new SimpleWorkbenchPanelPresenter(var58, var59, var60);
      context.addBean(context.getBeanReference(SimpleWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2161_SimpleWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2161_SimpleWorkbenchPanelPresenter, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2161_SimpleWorkbenchPanelPresenter, init_inj2161_SimpleWorkbenchPanelPresenter);
      return inj2161_SimpleWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<PluginJSExporter> inj2164_PluginJSExporter_creational = new BeanProvider<PluginJSExporter>() {
    public PluginJSExporter getInstance(final CreationalContext context) {
      final PluginJSExporter inj2163_PluginJSExporter = new PluginJSExporter();
      context.addBean(context.getBeanReference(PluginJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2163_PluginJSExporter);
      return inj2163_PluginJSExporter;
    }
  };
  private final PluginJSExporter inj2163_PluginJSExporter = inj2164_PluginJSExporter_creational.getInstance(context);
  private final BeanProvider<PartContextMenusView> inj2166_PartContextMenusView_creational = new BeanProvider<PartContextMenusView>() {
    public PartContextMenusView getInstance(final CreationalContext context) {
      final PartContextMenusView inj2165_PartContextMenusView = new PartContextMenusView();
      context.addBean(context.getBeanReference(PartContextMenusView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2165_PartContextMenusView);
      _711644943__$1574799830_authzManager(inj2165_PartContextMenusView, inj2022_RuntimeAuthorizationManager);
      _711644943__597466346_identity(inj2165_PartContextMenusView, _663569186_produceActiveUser(inj2018_BasicUserCacheImpl));
      return inj2165_PartContextMenusView;
    }
  };
  private final BeanProvider<PartContextMenusPresenter> inj2168_PartContextMenusPresenter_creational = new BeanProvider<PartContextMenusPresenter>() {
    public PartContextMenusPresenter getInstance(final CreationalContext context) {
      final PartContextMenusPresenter inj2167_PartContextMenusPresenter = new PartContextMenusPresenter();
      context.addBean(context.getBeanReference(PartContextMenusPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2167_PartContextMenusPresenter);
      _$274999170__$906533316_placeManager(inj2167_PartContextMenusPresenter, inj2041_PlaceManagerImpl);
      _$274999170__154256171_view(inj2167_PartContextMenusPresenter, inj2166_PartContextMenusView_creational.getInstance(context));
      final Subscription var61 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$274999170_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2167_PartContextMenusPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2167_PartContextMenusPresenter, new DestructionCallback<PartContextMenusPresenter>() {
        public void destroy(final PartContextMenusPresenter obj) {
          var61.remove();
          // WEEEEE!;
        }
      });
      return inj2167_PartContextMenusPresenter;
    }
  };
  private final PartContextMenusPresenter inj2167_PartContextMenusPresenter = inj2168_PartContextMenusPresenter_creational.getInstance(context);
  private InitializationCallback<RoleStyleBindingProvider> init_inj2169_RoleStyleBindingProvider = new InitializationCallback<RoleStyleBindingProvider>() {
    public void init(final RoleStyleBindingProvider obj) {
      obj.init();
    }
  };
  private final BeanProvider<RoleStyleBindingProvider> inj2170_RoleStyleBindingProvider_creational = new BeanProvider<RoleStyleBindingProvider>() {
    public RoleStyleBindingProvider getInstance(final CreationalContext context) {
      final ActiveUserCache var62 = inj2018_BasicUserCacheImpl;
      final RequiredRolesExtractor var63 = inj2129_ClientRequiredRolesExtractorImpl_creational.getInstance(context);
      final RoleStyleBindingProvider inj2169_RoleStyleBindingProvider = new RoleStyleBindingProvider(var62, var63);
      context.addBean(context.getBeanReference(RoleStyleBindingProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2169_RoleStyleBindingProvider);
      context.addInitializationCallback(inj2169_RoleStyleBindingProvider, init_inj2169_RoleStyleBindingProvider);
      return inj2169_RoleStyleBindingProvider;
    }
  };
  private final RoleStyleBindingProvider inj2169_RoleStyleBindingProvider = inj2170_RoleStyleBindingProvider_creational.getInstance(context);
  private final BeanProvider<DotResourceTypeDefinition> inj2172_DotResourceTypeDefinition_creational = new BeanProvider<DotResourceTypeDefinition>() {
    public DotResourceTypeDefinition getInstance(final CreationalContext context) {
      final DotResourceTypeDefinition inj2171_DotResourceTypeDefinition = new DotResourceTypeDefinition();
      context.addBean(context.getBeanReference(DotResourceTypeDefinition.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2171_DotResourceTypeDefinition);
      return inj2171_DotResourceTypeDefinition;
    }
  };
  private final DotResourceTypeDefinition inj2171_DotResourceTypeDefinition = inj2172_DotResourceTypeDefinition_creational.getInstance(context);
  private InitializationCallback<SimpleDnDWorkbenchPanelPresenter> init_inj2173_SimpleDnDWorkbenchPanelPresenter = new InitializationCallback<SimpleDnDWorkbenchPanelPresenter>() {
    public void init(final SimpleDnDWorkbenchPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SimpleDnDWorkbenchPanelPresenter> inj2174_SimpleDnDWorkbenchPanelPresenter_creational = new BeanProvider<SimpleDnDWorkbenchPanelPresenter>() {
    public SimpleDnDWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final SimpleDnDWorkbenchPanelView var64 = inj2083_SimpleDnDWorkbenchPanelView_creational.getInstance(context);
      final PerspectiveManager var65 = inj2039_PerspectiveManagerImpl;
      final Event var66 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final SimpleDnDWorkbenchPanelPresenter inj2173_SimpleDnDWorkbenchPanelPresenter = new SimpleDnDWorkbenchPanelPresenter(var64, var65, var66);
      context.addBean(context.getBeanReference(SimpleDnDWorkbenchPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2173_SimpleDnDWorkbenchPanelPresenter);
      _1653100451__$262319993_panelManager(inj2173_SimpleDnDWorkbenchPanelPresenter, inj2003_PanelManagerImpl);
      context.addInitializationCallback(inj2173_SimpleDnDWorkbenchPanelPresenter, init_inj2173_SimpleDnDWorkbenchPanelPresenter);
      return inj2173_SimpleDnDWorkbenchPanelPresenter;
    }
  };
  private final BeanProvider<TextResourceTypeDefinition> inj2176_TextResourceTypeDefinition_creational = new BeanProvider<TextResourceTypeDefinition>() {
    public TextResourceTypeDefinition getInstance(final CreationalContext context) {
      final TextResourceTypeDefinition inj2175_TextResourceTypeDefinition = new TextResourceTypeDefinition();
      context.addBean(context.getBeanReference(TextResourceTypeDefinition.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2175_TextResourceTypeDefinition);
      return inj2175_TextResourceTypeDefinition;
    }
  };
  private final TextResourceTypeDefinition inj2175_TextResourceTypeDefinition = inj2176_TextResourceTypeDefinition_creational.getInstance(context);
  private InitializationCallback<NotificationPopupView> init_inj2177_NotificationPopupView = new InitializationCallback<NotificationPopupView>() {
    public void init(final NotificationPopupView obj) {
      obj.init();
    }
  };
  private final BeanProvider<NotificationPopupView> inj2178_NotificationPopupView_creational = new BeanProvider<NotificationPopupView>() {
    public NotificationPopupView getInstance(final CreationalContext context) {
      final NotificationPopupView inj2177_NotificationPopupView = new NotificationPopupView();
      context.addBean(context.getBeanReference(NotificationPopupView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2177_NotificationPopupView);
      context.addInitializationCallback(inj2177_NotificationPopupView, init_inj2177_NotificationPopupView);
      return inj2177_NotificationPopupView;
    }
  };
  private final BeanProvider<WorkbenchToolBarView> inj2181_WorkbenchToolBarView_creational = new BeanProvider<WorkbenchToolBarView>() {
    public WorkbenchToolBarView getInstance(final CreationalContext context) {
      final WorkbenchToolBarView inj312_WorkbenchToolBarView = new WorkbenchToolBarView();
      context.addBean(context.getBeanReference(WorkbenchToolBarView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj312_WorkbenchToolBarView);
      return inj312_WorkbenchToolBarView;
    }
  };
  private final BeanProvider<WorkbenchToolBarPresenter> inj2180_WorkbenchToolBarPresenter_creational = new BeanProvider<WorkbenchToolBarPresenter>() {
    public WorkbenchToolBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchToolBarPresenter inj2179_WorkbenchToolBarPresenter = new WorkbenchToolBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchToolBarPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2179_WorkbenchToolBarPresenter);
      _40974972__$1426067475_view(inj2179_WorkbenchToolBarPresenter, inj2181_WorkbenchToolBarView_creational.getInstance(context));
      _40974972__$906533316_placeManager(inj2179_WorkbenchToolBarPresenter, inj2041_PlaceManagerImpl);
      final Subscription var67 = CDI.subscribeLocal("org.uberfire.client.workbench.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _40974972_onWorkbenchPartClose_ClosePlaceEvent(inj2179_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2179_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var67.remove();
          // WEEEEE!;
        }
      });
      final Subscription var68 = CDI.subscribeLocal("org.uberfire.client.workbench.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _40974972_onWorkbenchPartOnFocus_PlaceGainFocusEvent(inj2179_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2179_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var68.remove();
          // WEEEEE!;
        }
      });
      return inj2179_WorkbenchToolBarPresenter;
    }
  };
  private final WorkbenchToolBarPresenter inj2179_WorkbenchToolBarPresenter = inj2180_WorkbenchToolBarPresenter_creational.getInstance(context);
  private final BeanProvider<LocaleSelector> inj2183_LocaleSelector_creational = new BeanProvider<LocaleSelector>() {
    public LocaleSelector getInstance(final CreationalContext context) {
      final LocaleSelector inj2182_LocaleSelector = new LocaleSelector();
      context.addBean(context.getBeanReference(LocaleSelector.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2182_LocaleSelector);
      return inj2182_LocaleSelector;
    }
  };
  private final LocaleSelector inj2182_LocaleSelector = inj2183_LocaleSelector_creational.getInstance(context);
  private final BeanProvider<LocaleListBox> inj2185_LocaleListBox_creational = new BeanProvider<LocaleListBox>() {
    public LocaleListBox getInstance(final CreationalContext context) {
      final LocaleListBox inj2184_LocaleListBox = new LocaleListBox();
      context.addBean(context.getBeanReference(LocaleListBox.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2184_LocaleListBox);
      _1350680564__$1232121576_selector(inj2184_LocaleListBox, inj2182_LocaleSelector);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2184_LocaleListBox.init();
        }
      });
      return inj2184_LocaleListBox;
    }
  };
  private final BeanProvider<DefaultBusSecurityErrorCallback> inj2187_DefaultBusSecurityErrorCallback_creational = new BeanProvider<DefaultBusSecurityErrorCallback>() {
    public DefaultBusSecurityErrorCallback getInstance(final CreationalContext context) {
      final SecurityContext var69 = inj2020_SecurityContextImpl;
      final DefaultBusSecurityErrorCallback inj2186_DefaultBusSecurityErrorCallback = new DefaultBusSecurityErrorCallback(var69);
      context.addBean(context.getBeanReference(DefaultBusSecurityErrorCallback.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2186_DefaultBusSecurityErrorCallback);
      final RefHolder<UncaughtExceptionHandler> var70 = new RefHolder<UncaughtExceptionHandler>();
      context.addInitializationCallback(inj2186_DefaultBusSecurityErrorCallback, new InitializationCallback<DefaultBusSecurityErrorCallback>() {
        public void init(final DefaultBusSecurityErrorCallback obj) {
          final UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
            public void onUncaughtException(Throwable t) {
              inj2186_DefaultBusSecurityErrorCallback.handleError(t);
            }
          };
          var70.set(handler);
          ((ClientMessageBusImpl) ErraiBus.get()).addUncaughtExceptionHandler(handler);
        }
      });
      context.addDestructionCallback(inj2186_DefaultBusSecurityErrorCallback, new DestructionCallback<DefaultBusSecurityErrorCallback>() {
        public void destroy(final DefaultBusSecurityErrorCallback obj) {
          ((ClientMessageBusImpl) ErraiBus.get()).removeUncaughtExceptionHandler(var70.get());
        }
      });
      return inj2186_DefaultBusSecurityErrorCallback;
    }
  };
  private final DefaultBusSecurityErrorCallback inj2186_DefaultBusSecurityErrorCallback = inj2187_DefaultBusSecurityErrorCallback_creational.getInstance(context);
  private InitializationCallback<SplitLayoutPanelPresenter> init_inj2188_SplitLayoutPanelPresenter = new InitializationCallback<SplitLayoutPanelPresenter>() {
    public void init(final SplitLayoutPanelPresenter obj) {
      _253255348_init(obj);
    }
  };
  private final BeanProvider<SplitLayoutPanelPresenter> inj2189_SplitLayoutPanelPresenter_creational = new BeanProvider<SplitLayoutPanelPresenter>() {
    public SplitLayoutPanelPresenter getInstance(final CreationalContext context) {
      final SplitLayoutPanelView var71 = inj2066_SplitLayoutPanelView_creational.getInstance(context);
      final PerspectiveManager var72 = inj2039_PerspectiveManagerImpl;
      final Event var73 = inj1980_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final SplitLayoutPanelPresenter inj2188_SplitLayoutPanelPresenter = new SplitLayoutPanelPresenter(var71, var72, var73);
      context.addBean(context.getBeanReference(SplitLayoutPanelPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2188_SplitLayoutPanelPresenter);
      context.addInitializationCallback(inj2188_SplitLayoutPanelPresenter, init_inj2188_SplitLayoutPanelPresenter);
      return inj2188_SplitLayoutPanelPresenter;
    }
  };
  private InitializationCallback<ActivityNotFoundView> init_inj1870_ActivityNotFoundView = new InitializationCallback<ActivityNotFoundView>() {
    public void init(final ActivityNotFoundView obj) {
      obj.init();
    }
  };
  private final BeanProvider<ActivityNotFoundView> inj2192_ActivityNotFoundView_creational = new BeanProvider<ActivityNotFoundView>() {
    public ActivityNotFoundView getInstance(final CreationalContext context) {
      final ActivityNotFoundView inj1870_ActivityNotFoundView = new ActivityNotFoundView();
      context.addBean(context.getBeanReference(ActivityNotFoundView.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1870_ActivityNotFoundView);
      context.addInitializationCallback(inj1870_ActivityNotFoundView, init_inj1870_ActivityNotFoundView);
      return inj1870_ActivityNotFoundView;
    }
  };
  private InitializationCallback<ActivityNotFoundPresenter> init_inj2190_ActivityNotFoundPresenter = new InitializationCallback<ActivityNotFoundPresenter>() {
    public void init(final ActivityNotFoundPresenter obj) {
      obj.init();
    }
  };
  private final BeanProvider<ActivityNotFoundPresenter> inj2191_ActivityNotFoundPresenter_creational = new BeanProvider<ActivityNotFoundPresenter>() {
    public ActivityNotFoundPresenter getInstance(final CreationalContext context) {
      final PlaceManager var74 = inj2041_PlaceManagerImpl;
      final ActivityNotFoundPresenter inj2190_ActivityNotFoundPresenter = new ActivityNotFoundPresenter(var74);
      context.addBean(context.getBeanReference(ActivityNotFoundPresenter.class, arrayOf_19635043Annotation_1589807214), inj2190_ActivityNotFoundPresenter);
      _$2051573400__$1566038911_view(inj2190_ActivityNotFoundPresenter, inj2192_ActivityNotFoundView_creational.getInstance(context));
      _$2051573400__$906533316_placeManager(inj2190_ActivityNotFoundPresenter, inj2041_PlaceManagerImpl);
      context.addInitializationCallback(inj2190_ActivityNotFoundPresenter, init_inj2190_ActivityNotFoundPresenter);
      return inj2190_ActivityNotFoundPresenter;
    }
  };
  private final ActivityNotFoundPresenter inj2190_ActivityNotFoundPresenter = inj2191_ActivityNotFoundPresenter_creational.getInstance(context);
  private final BeanProvider<TextBox> inj2195_TextBox_creational = new BeanProvider<TextBox>() {
    public TextBox getInstance(final CreationalContext context) {
      final TextBox inj583_TextBox = new TextBox();
      context.addBean(context.getBeanReference(TextBox.class, QualifierUtil.DEFAULT_QUALIFIERS), inj583_TextBox);
      return inj583_TextBox;
    }
  };
  private final BeanProvider<MoodScreen> inj2194_MoodScreen_creational = new BeanProvider<MoodScreen>() {
    public MoodScreen getInstance(final CreationalContext context) {
      final MoodScreen inj2193_MoodScreen = new MoodScreen();
      context.addBean(context.getBeanReference(MoodScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2193_MoodScreen);
      _1150956601__$371269162_moodTextBox(inj2193_MoodScreen, inj2195_TextBox_creational.getInstance(context));
      _1150956601__1116818801_moodEvent(inj2193_MoodScreen, inj1980_EventProvider.provide(new Class[] { Mood.class }, null));
      final Subscription var75 = CDI.subscribeLocal("org.uberfire.client.ShowcaseEntryPoint$DumpLayout", new AbstractCDIEventCallback<DumpLayout>() {
        public void fireEvent(final DumpLayout event) {
          inj2193_MoodScreen.dumpHierarchy(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.ShowcaseEntryPoint$DumpLayout []";
        }
      });
      context.addDestructionCallback(inj2193_MoodScreen, new DestructionCallback<MoodScreen>() {
        public void destroy(final MoodScreen obj) {
          var75.remove();
          // WEEEEE!;
        }
      });
      context.addInitializationCallback(inj2193_MoodScreen, new InitializationCallback<MoodScreen>() {
        public void init(final MoodScreen obj) {
          org_uberfire_client_screens_MoodScreenTemplateResource var76 = GWT.create(org_uberfire_client_screens_MoodScreenTemplateResource.class);
          Element var77 = TemplateUtil.getRootTemplateElement(var76.getContents().getText(), "");
          TemplateUtil.translateTemplate("org/uberfire/client/screens/MoodScreen.html", var77);
          Map<String, Element> var78 = TemplateUtil.getDataFieldElements(var77);
          Map<String, Widget> var79 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.uberfire.client.screens.MoodScreen", "org/uberfire/client/screens/MoodScreen.html", _1150956601__$371269162_moodTextBox(inj2193_MoodScreen), var78, "moodTextBox");
          var79.put("moodTextBox", _1150956601__$371269162_moodTextBox(inj2193_MoodScreen));
          TemplateUtil.initWidget(inj2193_MoodScreen, var77, var79.values());
          ((HasKeyDownHandlers) var79.get("moodTextBox")).addKeyDownHandler(new KeyDownHandler() {
            public void onKeyDown(KeyDownEvent event) {
              _1150956601_onKeyDown_KeyDownEvent(inj2193_MoodScreen, event);
            }
          });
        }
      });
      return inj2193_MoodScreen;
    }
  };
  private final BeanProvider<MoodScreenActivity> inj2197_MoodScreenActivity_creational = new BeanProvider<MoodScreenActivity>() {
    public MoodScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var80 = inj2041_PlaceManagerImpl;
      final MoodScreenActivity inj2196_MoodScreenActivity = new MoodScreenActivity(var80);
      context.addBean(context.getBeanReference(MoodScreenActivity.class, arrayOf_19635043Annotation_1484530921), inj2196_MoodScreenActivity);
      _$1786166680__1150956601_realPresenter(inj2196_MoodScreenActivity, inj2194_MoodScreen_creational.getInstance(context));
      return inj2196_MoodScreenActivity;
    }
  };
  private final BeanProvider<BatchCallerProvider> inj2198_BatchCallerProvider_creational = new BeanProvider<BatchCallerProvider>() {
    public BatchCallerProvider getInstance(final CreationalContext context) {
      final BatchCallerProvider inj1958_BatchCallerProvider = new BatchCallerProvider();
      context.addBean(context.getBeanReference(BatchCallerProvider.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1958_BatchCallerProvider);
      return inj1958_BatchCallerProvider;
    }
  };
  private final BatchCallerProvider inj1958_BatchCallerProvider = inj2198_BatchCallerProvider_creational.getInstance(context);
  private final BeanProvider<JSNativeSplashScreen> inj2200_JSNativeSplashScreen_creational = new BeanProvider<JSNativeSplashScreen>() {
    public JSNativeSplashScreen getInstance(final CreationalContext context) {
      final JSNativeSplashScreen inj2199_JSNativeSplashScreen = new JSNativeSplashScreen();
      context.addBean(context.getBeanReference(JSNativeSplashScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2199_JSNativeSplashScreen);
      _$448678005__$304677073_wbServices(inj2199_JSNativeSplashScreen, inj2038_WorkbenchServicesProxyClientImpl_creational.getInstance(context));
      _1584088255__$2073863603_runtimePluginsService(inj2199_JSNativeSplashScreen, inj2069_RuntimePluginsServiceProxyClientImpl_creational.getInstance(context));
      return inj2199_JSNativeSplashScreen;
    }
  };
  private final BeanProvider<JSNativeScreen> inj2202_JSNativeScreen_creational = new BeanProvider<JSNativeScreen>() {
    public JSNativeScreen getInstance(final CreationalContext context) {
      final JSNativeScreen inj2201_JSNativeScreen = new JSNativeScreen();
      context.addBean(context.getBeanReference(JSNativeScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2201_JSNativeScreen);
      _1584088255__$2073863603_runtimePluginsService(inj2201_JSNativeScreen, inj2069_RuntimePluginsServiceProxyClientImpl_creational.getInstance(context));
      return inj2201_JSNativeScreen;
    }
  };
  private final BeanProvider<DemoSplashScreen> inj2205_DemoSplashScreen_creational = new BeanProvider<DemoSplashScreen>() {
    public DemoSplashScreen getInstance(final CreationalContext context) {
      final DemoSplashScreen inj1748_DemoSplashScreen = new DemoSplashScreen();
      context.addBean(context.getBeanReference(DemoSplashScreen.class, QualifierUtil.DEFAULT_QUALIFIERS), inj1748_DemoSplashScreen);
      return inj1748_DemoSplashScreen;
    }
  };
  private InitializationCallback<DemoSplashScreenActivity> init_inj2203_DemoSplashScreenActivity = new InitializationCallback<DemoSplashScreenActivity>() {
    public void init(final DemoSplashScreenActivity obj) {
      _$690457926_initialize(obj);
    }
  };
  private final BeanProvider<DemoSplashScreenActivity> inj2204_DemoSplashScreenActivity_creational = new BeanProvider<DemoSplashScreenActivity>() {
    public DemoSplashScreenActivity getInstance(final CreationalContext context) {
      final PlaceManager var81 = inj2041_PlaceManagerImpl;
      final DemoSplashScreenActivity inj2203_DemoSplashScreenActivity = new DemoSplashScreenActivity(var81);
      context.addBean(context.getBeanReference(DemoSplashScreenActivity.class, arrayOf_19635043Annotation_302748957), inj2203_DemoSplashScreenActivity);
      _$1494319141__144807084_realPresenter(inj2203_DemoSplashScreenActivity, inj2205_DemoSplashScreen_creational.getInstance(context));
      _$690457926__$304677073_wbServices(inj2203_DemoSplashScreenActivity, inj2038_WorkbenchServicesProxyClientImpl_creational.getInstance(context));
      context.addInitializationCallback(inj2203_DemoSplashScreenActivity, init_inj2203_DemoSplashScreenActivity);
      return inj2203_DemoSplashScreenActivity;
    }
  };
  private final DemoSplashScreenActivity inj2203_DemoSplashScreenActivity = inj2204_DemoSplashScreenActivity_creational.getInstance(context);
  private final BeanProvider<AuthenticationServiceInterceptor> inj2207_AuthenticationServiceInterceptor_creational = new BeanProvider<AuthenticationServiceInterceptor>() {
    public AuthenticationServiceInterceptor getInstance(final CreationalContext context) {
      final SecurityContext var82 = inj2020_SecurityContextImpl;
      final AuthenticationServiceInterceptor inj2206_AuthenticationServiceInterceptor = new AuthenticationServiceInterceptor(var82);
      context.addBean(context.getBeanReference(AuthenticationServiceInterceptor.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2206_AuthenticationServiceInterceptor);
      return inj2206_AuthenticationServiceInterceptor;
    }
  };
  private InitializationCallback<JSEntryPoint> init_inj2208_JSEntryPoint = new InitializationCallback<JSEntryPoint>() {
    public void init(final JSEntryPoint obj) {
      obj.init();
    }
  };
  private final BeanProvider<JSEntryPoint> inj2209_JSEntryPoint_creational = new BeanProvider<JSEntryPoint>() {
    public JSEntryPoint getInstance(final CreationalContext context) {
      final JSEntryPoint inj2208_JSEntryPoint = new JSEntryPoint();
      context.addBean(context.getBeanReference(JSEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2208_JSEntryPoint);
      _$662927178__$1462522111_workbench(inj2208_JSEntryPoint, inj2137_Workbench);
      _$662927178__$2073863603_runtimePluginsService(inj2208_JSEntryPoint, inj2069_RuntimePluginsServiceProxyClientImpl_creational.getInstance(context));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2208_JSEntryPoint.setup();
        }
      });
      context.addInitializationCallback(inj2208_JSEntryPoint, init_inj2208_JSEntryPoint);
      return inj2208_JSEntryPoint;
    }
  };
  private final JSEntryPoint inj2208_JSEntryPoint = inj2209_JSEntryPoint_creational.getInstance(context);
  private final BeanProvider<SecurityEntryPoint> inj2211_SecurityEntryPoint_creational = new BeanProvider<SecurityEntryPoint>() {
    public SecurityEntryPoint getInstance(final CreationalContext context) {
      final SecurityEntryPoint inj2210_SecurityEntryPoint = new SecurityEntryPoint();
      context.addBean(context.getBeanReference(SecurityEntryPoint.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2210_SecurityEntryPoint);
      _1135152903__879292651_bus(inj2210_SecurityEntryPoint, inj1956_MessageBusProvider.get());
      return inj2210_SecurityEntryPoint;
    }
  };
  private final SecurityEntryPoint inj2210_SecurityEntryPoint = inj2211_SecurityEntryPoint_creational.getInstance(context);
  private final BeanProvider<org.uberfire.client.screens.ActivityNotFoundPresenter> inj2213_ActivityNotFoundPresenter_creational = new BeanProvider<org.uberfire.client.screens.ActivityNotFoundPresenter>() {
    public org.uberfire.client.screens.ActivityNotFoundPresenter getInstance(final CreationalContext context) {
      final org.uberfire.client.screens.ActivityNotFoundPresenter inj2212_ActivityNotFoundPresenter = new org.uberfire.client.screens.ActivityNotFoundPresenter();
      context.addBean(context.getBeanReference(org.uberfire.client.screens.ActivityNotFoundPresenter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2212_ActivityNotFoundPresenter);
      return inj2212_ActivityNotFoundPresenter;
    }
  };
  private final org.uberfire.client.screens.ActivityNotFoundPresenter inj2212_ActivityNotFoundPresenter = inj2213_ActivityNotFoundPresenter_creational.getInstance(context);
  private final BeanProvider<ActivityNotFoundPresenterActivity> inj2215_ActivityNotFoundPresenterActivity_creational = new BeanProvider<ActivityNotFoundPresenterActivity>() {
    public ActivityNotFoundPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var83 = inj2041_PlaceManagerImpl;
      final ActivityNotFoundPresenterActivity inj2214_ActivityNotFoundPresenterActivity = new ActivityNotFoundPresenterActivity(var83);
      context.addBean(context.getBeanReference(ActivityNotFoundPresenterActivity.class, arrayOf_19635043Annotation_41887215), inj2214_ActivityNotFoundPresenterActivity);
      _439167523__1882392308_realPresenter(inj2214_ActivityNotFoundPresenterActivity, inj2212_ActivityNotFoundPresenter);
      return inj2214_ActivityNotFoundPresenterActivity;
    }
  };
  private final BeanProvider<DestructionImpl> inj2217_DestructionImpl_creational = new BeanProvider<DestructionImpl>() {
    public DestructionImpl getInstance(final CreationalContext context) {
      final DestructionImpl inj2216_DestructionImpl = new DestructionImpl();
      context.addBean(context.getBeanReference(DestructionImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2216_DestructionImpl);
      return inj2216_DestructionImpl;
    }
  };
  private final BeanProvider<LifecycleListenerRegistrarImpl> inj2219_LifecycleListenerRegistrarImpl_creational = new BeanProvider<LifecycleListenerRegistrarImpl>() {
    public LifecycleListenerRegistrarImpl getInstance(final CreationalContext context) {
      final LifecycleListenerRegistrarImpl inj2218_LifecycleListenerRegistrarImpl = new LifecycleListenerRegistrarImpl();
      context.addBean(context.getBeanReference(LifecycleListenerRegistrarImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2218_LifecycleListenerRegistrarImpl);
      return inj2218_LifecycleListenerRegistrarImpl;
    }
  };
  private final LifecycleListenerRegistrarImpl inj2218_LifecycleListenerRegistrarImpl = inj2219_LifecycleListenerRegistrarImpl_creational.getInstance(context);
  private final BeanProvider<ObservablePathImpl> inj2221_ObservablePathImpl_creational = new BeanProvider<ObservablePathImpl>() {
    public ObservablePathImpl getInstance(final CreationalContext context) {
      final ObservablePathImpl inj2220_ObservablePathImpl = new ObservablePathImpl();
      context.addBean(context.getBeanReference(ObservablePathImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2220_ObservablePathImpl);
      final BeanProvider<SessionInfo> var84 = new BeanProvider<SessionInfo>() {
        public SessionInfo getInstance(CreationalContext pContext) {
          SessionInfo var84 = _$1462522111_currentSession(inj2137_Workbench);
          context.addBean(context.getBeanReference(SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS), var84);
          return var84;
        }
      };
      _$1304194947__291376327_sessionInfo(inj2220_ObservablePathImpl, ((SimpleCreationalContext) context).getSingletonInstanceOrNew(injContext, var84, SessionInfo.class, QualifierUtil.DEFAULT_QUALIFIERS));
      final Subscription var85 = CDI.subscribe("org.uberfire.workbench.events.ResourceRenamedEvent", new AbstractCDIEventCallback<ResourceRenamedEvent>() {
        public void fireEvent(final ResourceRenamedEvent event) {
          _$1304194947_onResourceRenamed_ResourceRenamedEvent(inj2220_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceRenamedEvent []";
        }
      });
      final Subscription var86 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceRenamedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2220_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var85.remove();
          // WEEEEE!
          var86.remove();
        }
      });
      final Subscription var87 = CDI.subscribe("org.uberfire.workbench.events.ResourceDeletedEvent", new AbstractCDIEventCallback<ResourceDeletedEvent>() {
        public void fireEvent(final ResourceDeletedEvent event) {
          _$1304194947_onResourceDeleted_ResourceDeletedEvent(inj2220_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceDeletedEvent []";
        }
      });
      final Subscription var88 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceDeletedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2220_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var87.remove();
          // WEEEEE!
          var88.remove();
        }
      });
      final Subscription var89 = CDI.subscribe("org.uberfire.workbench.events.ResourceUpdatedEvent", new AbstractCDIEventCallback<ResourceUpdatedEvent>() {
        public void fireEvent(final ResourceUpdatedEvent event) {
          _$1304194947_onResourceUpdated_ResourceUpdatedEvent(inj2220_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceUpdatedEvent []";
        }
      });
      final Subscription var90 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceUpdatedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2220_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var89.remove();
          // WEEEEE!
          var90.remove();
        }
      });
      final Subscription var91 = CDI.subscribe("org.uberfire.workbench.events.ResourceCopiedEvent", new AbstractCDIEventCallback<ResourceCopiedEvent>() {
        public void fireEvent(final ResourceCopiedEvent event) {
          _$1304194947_onResourceCopied_ResourceCopiedEvent(inj2220_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceCopiedEvent []";
        }
      });
      final Subscription var92 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceCopiedEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2220_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var91.remove();
          // WEEEEE!
          var92.remove();
        }
      });
      final Subscription var93 = CDI.subscribe("org.uberfire.workbench.events.ResourceBatchChangesEvent", new AbstractCDIEventCallback<ResourceBatchChangesEvent>() {
        public void fireEvent(final ResourceBatchChangesEvent event) {
          _$1304194947_onResourceBatchEvent_ResourceBatchChangesEvent(inj2220_ObservablePathImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.workbench.events.ResourceBatchChangesEvent []";
        }
      });
      final Subscription var94 = ErraiBus.get().subscribe("cdi.event:org.uberfire.workbench.events.ResourceBatchChangesEvent", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2220_ObservablePathImpl, new DestructionCallback<ObservablePathImpl>() {
        public void destroy(final ObservablePathImpl obj) {
          var93.remove();
          // WEEEEE!
          var94.remove();
        }
      });
      return inj2220_ObservablePathImpl;
    }
  };
  private final BeanProvider<DefaultRestSecurityErrorCallback> inj2223_DefaultRestSecurityErrorCallback_creational = new BeanProvider<DefaultRestSecurityErrorCallback>() {
    public DefaultRestSecurityErrorCallback getInstance(final CreationalContext context) {
      final SecurityContext var95 = inj2020_SecurityContextImpl;
      final DefaultRestSecurityErrorCallback inj2222_DefaultRestSecurityErrorCallback = new DefaultRestSecurityErrorCallback(var95);
      context.addBean(context.getBeanReference(DefaultRestSecurityErrorCallback.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2222_DefaultRestSecurityErrorCallback);
      return inj2222_DefaultRestSecurityErrorCallback;
    }
  };
  private final BeanProvider<PerspectiveJSExporter> inj2225_PerspectiveJSExporter_creational = new BeanProvider<PerspectiveJSExporter>() {
    public PerspectiveJSExporter getInstance(final CreationalContext context) {
      final PerspectiveJSExporter inj2224_PerspectiveJSExporter = new PerspectiveJSExporter();
      context.addBean(context.getBeanReference(PerspectiveJSExporter.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2224_PerspectiveJSExporter);
      return inj2224_PerspectiveJSExporter;
    }
  };
  private final PerspectiveJSExporter inj2224_PerspectiveJSExporter = inj2225_PerspectiveJSExporter_creational.getInstance(context);
  private final BeanProvider<DotResourceType> inj2227_DotResourceType_creational = new BeanProvider<DotResourceType>() {
    public DotResourceType getInstance(final CreationalContext context) {
      final DotResourceType inj2226_DotResourceType = new DotResourceType();
      context.addBean(context.getBeanReference(DotResourceType.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2226_DotResourceType);
      return inj2226_DotResourceType;
    }
  };
  private final DotResourceType inj2226_DotResourceType = inj2227_DotResourceType_creational.getInstance(context);
  private final BeanProvider<CreationImpl> inj2229_CreationImpl_creational = new BeanProvider<CreationImpl>() {
    public CreationImpl getInstance(final CreationalContext context) {
      final CreationImpl inj2228_CreationImpl = new CreationImpl();
      context.addBean(context.getBeanReference(CreationImpl.class, QualifierUtil.DEFAULT_QUALIFIERS), inj2228_CreationImpl);
      return inj2228_CreationImpl;
    }
  };
  static class WorkbenchDragAndDropManager_inj2007_proxy extends WorkbenchDragAndDropManager {
    private WorkbenchDragAndDropManager $$_proxy_$$;
    private boolean $$_init_$$;
    @Override public void makeDraggable(IsWidget a0, IsWidget a1) {
      if ($$_init_$$) {
        $$_proxy_$$.makeDraggable(a0, a1);
      }
    }

    @Override public void registerDropController(WorkbenchPanelView a0, DropController a1) {
      if ($$_init_$$) {
        $$_proxy_$$.registerDropController(a0, a1);
      }
    }

    @Override public void unregisterDropController(WorkbenchPanelView a0) {
      if ($$_init_$$) {
        $$_proxy_$$.unregisterDropController(a0);
      }
    }

    @Override public void unregisterDropControllers() {
      if ($$_init_$$) {
        $$_proxy_$$.unregisterDropControllers();
      }
    }

    @Override public void setWorkbenchContext(WorkbenchDragContext a0) {
      if ($$_init_$$) {
        $$_proxy_$$.setWorkbenchContext(a0);
      }
    }

    @Override public WorkbenchDragContext getWorkbenchContext() {
      if ($$_init_$$) {
        return $$_proxy_$$.getWorkbenchContext();
      } else {
        return null;
      }
    }

    @Override public int hashCode() {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to hashCode() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.hashCode();
      }
    }

    @Override public boolean equals(Object o) {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to equals() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.equals(o);
      }
    }

    public void __$setProxiedInstance$(WorkbenchDragAndDropManager proxy) {
      $$_proxy_$$ = proxy;
      $$_init_$$ = true;
    }
  }
  public interface org_uberfire_client_HomePerspectiveTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/HomePerspective.html") public TextResource getContents(); }
  public interface org_uberfire_client_screens_MoodScreenTemplateResource extends Template, ClientBundle { @Source("org/uberfire/client/screens/MoodScreen.html") public TextResource getContents(); }
  private static void addLookups_0() {
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ApplicationReadyEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ApplicationReadyEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceLostFocusEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceLostFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ClosePlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ClosePlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceGainFocusEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PlaceGainFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PerspectiveChange", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.PerspectiveChange", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceRenamed");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceRenamedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.ShowcaseEntryPoint$DumpLayout", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.DropPlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.DropPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceBatchChangesEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceBatchChangesEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.SelectPlaceEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.SelectPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.shared.Mood", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceCopied");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceCopiedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceUpdated");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceUpdatedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceDeleted");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "org.uberfire.workbench.events.ResourceChange");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.ResourceDeletedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.ChangeTitleWidgetEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.NotificationEvent", "org.uberfire.workbench.events.UberFireEvent");
    CDIEventTypeLookup.get().addLookup("org.uberfire.workbench.events.NotificationEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.events.NewSplashScreenActiveEvent", "java.lang.Object");
  }

  private void declareBeans_0() {
    injContext.addBean(TranslationServiceProvider.class, TranslationServiceProvider.class, inj1989_TranslationServiceProvider_creational, inj1962_TranslationServiceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, TranslationServiceProvider.class, inj1989_TranslationServiceProvider_creational, inj1962_TranslationServiceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPartView.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(View.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleLayoutPanel.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchPartView.class, inj1992_WorkbenchPartView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPartPresenterDefault.class, WorkbenchPartPresenterDefault.class, inj1991_WorkbenchPartPresenterDefault_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchPartPresenter.class, WorkbenchPartPresenterDefault.class, inj1991_WorkbenchPartPresenterDefault_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj1993_SenderProvider_creational, inj1970_SenderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj1993_SenderProvider_creational, inj1970_SenderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj1994_IOCBeanManagerProvider_creational, inj1968_IOCBeanManagerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj1994_IOCBeanManagerProvider_creational, inj1968_IOCBeanManagerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberfireContextDefaultImpl.class, UberfireContextDefaultImpl.class, inj1996_UberfireContextDefaultImpl_creational, inj1995_UberfireContextDefaultImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireContext.class, UberfireContextDefaultImpl.class, inj1996_UberfireContextDefaultImpl_creational, inj1995_UberfireContextDefaultImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj1997_InstanceProvider_creational, inj1976_InstanceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj1997_InstanceProvider_creational, inj1976_InstanceProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LayoutSelection.class, LayoutSelection.class, inj1999_LayoutSelection_creational, inj1998_LayoutSelection, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj2000_EventProvider_creational, inj1980_EventProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj2000_EventProvider_creational, inj1980_EventProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DefaultBeanFactory.class, DefaultBeanFactory.class, inj2002_DefaultBeanFactory_creational, inj2001_DefaultBeanFactory, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(BeanFactory.class, DefaultBeanFactory.class, inj2002_DefaultBeanFactory_creational, inj2001_DefaultBeanFactory, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PanelManagerImpl.class, PanelManagerImpl.class, inj2004_PanelManagerImpl_creational, inj2003_PanelManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PanelManager.class, PanelManagerImpl.class, inj2004_PanelManagerImpl_creational, inj2003_PanelManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPickupDragController.class, WorkbenchPickupDragController.class, inj2006_WorkbenchPickupDragController_creational, inj2005_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PickupDragController.class, WorkbenchPickupDragController.class, inj2006_WorkbenchPickupDragController_creational, inj2005_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDragController.class, WorkbenchPickupDragController.class, inj2006_WorkbenchPickupDragController_creational, inj2005_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DragController.class, WorkbenchPickupDragController.class, inj2006_WorkbenchPickupDragController_creational, inj2005_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FiresDragEvents.class, WorkbenchPickupDragController.class, inj2006_WorkbenchPickupDragController_creational, inj2005_WorkbenchPickupDragController, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchDragAndDropManager.class, WorkbenchDragAndDropManager.class, inj2009_WorkbenchDragAndDropManager_creational, inj2008_WorkbenchDragAndDropManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CompassDropController.class, CompassDropController.class, inj2011_CompassDropController_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DropController.class, CompassDropController.class, inj2011_CompassDropController_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(StateChangeImpl.class, StateChangeImpl.class, inj2013_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StateChange.class, StateChangeImpl.class, inj2013_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, StateChangeImpl.class, inj2013_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, StateChangeImpl.class, inj2013_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, StateChangeImpl.class, inj2013_StateChangeImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Navigation.class, Navigation.class, inj2015_Navigation_creational, inj2014_Navigation, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj2016_CallerProvider_creational, inj1984_CallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj2016_CallerProvider_creational, inj1984_CallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CookieStorageHandlerProvider.class, CookieStorageHandlerProvider.class, inj2017_CookieStorageHandlerProvider_creational, inj1972_CookieStorageHandlerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, CookieStorageHandlerProvider.class, inj2017_CookieStorageHandlerProvider_creational, inj1972_CookieStorageHandlerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(BasicUserCacheImpl.class, BasicUserCacheImpl.class, inj2019_BasicUserCacheImpl_creational, inj2018_BasicUserCacheImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActiveUserCache.class, BasicUserCacheImpl.class, inj2019_BasicUserCacheImpl_creational, inj2018_BasicUserCacheImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SecurityContextImpl.class, SecurityContextImpl.class, inj2021_SecurityContextImpl_creational, inj2020_SecurityContextImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SecurityContext.class, SecurityContextImpl.class, inj2021_SecurityContextImpl_creational, inj2020_SecurityContextImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RuntimeAuthorizationManager.class, RuntimeAuthorizationManager.class, inj2023_RuntimeAuthorizationManager_creational, inj2022_RuntimeAuthorizationManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AuthorizationManager.class, RuntimeAuthorizationManager.class, inj2023_RuntimeAuthorizationManager_creational, inj2022_RuntimeAuthorizationManager, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EditorJSExporter.class, EditorJSExporter.class, inj2025_EditorJSExporter_creational, inj2024_EditorJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, EditorJSExporter.class, inj2025_EditorJSExporter_creational, inj2024_EditorJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HeaderPanel.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, HeaderPanel.class, inj2028_HeaderPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchLayoutImpl.class, WorkbenchLayoutImpl.class, inj2027_WorkbenchLayoutImpl_creational, inj2026_WorkbenchLayoutImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchLayout.class, WorkbenchLayoutImpl.class, inj2027_WorkbenchLayoutImpl_creational, inj2026_WorkbenchLayoutImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(User.class, User.class, inj1950_User_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Serializable.class, User.class, inj1950_User_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(NotificationPopupsManager.class, NotificationPopupsManager.class, inj2030_NotificationPopupsManager_creational, inj2029_NotificationPopupsManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityLifecycleErrorHandler.class, ActivityLifecycleErrorHandler.class, inj2032_ActivityLifecycleErrorHandler_creational, inj2031_ActivityLifecycleErrorHandler, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityBeansCache.class, ActivityBeansCache.class, inj2034_ActivityBeansCache_creational, inj2033_ActivityBeansCache, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityManagerImpl.class, ActivityManagerImpl.class, inj2036_ActivityManagerImpl_creational, inj2035_ActivityManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityManager.class, ActivityManagerImpl.class, inj2036_ActivityManagerImpl_creational, inj2035_ActivityManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchServicesProxyClientImpl.class, WorkbenchServicesProxyClientImpl.class, inj2038_WorkbenchServicesProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchServicesProxy.class, WorkbenchServicesProxyClientImpl.class, inj2038_WorkbenchServicesProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PerspectiveManagerImpl.class, PerspectiveManagerImpl.class, inj2040_PerspectiveManagerImpl_creational, inj2039_PerspectiveManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PerspectiveManager.class, PerspectiveManagerImpl.class, inj2040_PerspectiveManagerImpl_creational, inj2039_PerspectiveManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PlaceManagerImpl.class, PlaceManagerImpl.class, inj2042_PlaceManagerImpl_creational, inj2041_PlaceManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceManager.class, PlaceManagerImpl.class, inj2042_PlaceManagerImpl_creational, inj2041_PlaceManagerImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativePerspective.class, JSNativePerspective.class, inj2044_JSNativePerspective_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj2045_MessageBusProvider_creational, inj1956_MessageBusProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj2045_MessageBusProvider_creational, inj1956_MessageBusProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj2046_RequestDispatcherProvider_creational, inj1960_RequestDispatcherProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj2046_RequestDispatcherProvider_creational, inj1960_RequestDispatcherProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnotherScreen.class, AnotherScreen.class, inj2048_AnotherScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AnotherScreenActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, "AnotherScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, "AnotherScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(WorkbenchActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(ContextSensitiveActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(Activity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(RuntimeResource.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(Resource.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(AbstractActivity.class, AnotherScreenActivity.class, inj2050_AnotherScreenActivity_creational, null, arrayOf_19635043Annotation_2063879335, null, false);
    injContext.addBean(SecurityContextHoldingSingleton.class, SecurityContextHoldingSingleton.class, inj2052_SecurityContextHoldingSingleton_creational, inj2051_SecurityContextHoldingSingleton, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PespectiveContextMenusView.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusPresenter.View.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, PespectiveContextMenusView.class, inj2054_PespectiveContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PespectiveContextMenusPresenter.class, PespectiveContextMenusPresenter.class, inj2056_PespectiveContextMenusPresenter_creational, inj2055_PespectiveContextMenusPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceRequestHistoryMapperImpl.class, PlaceRequestHistoryMapperImpl.class, inj2059_PlaceRequestHistoryMapperImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(PlaceRequestHistoryMapper.class, PlaceRequestHistoryMapperImpl.class, inj2059_PlaceRequestHistoryMapperImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PlaceHistoryHandler.class, PlaceHistoryHandler.class, inj2058_PlaceHistoryHandler_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuBarView.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchMenuBarView.class, inj2062_WorkbenchMenuBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchMenuBarPresenter.class, WorkbenchMenuBarPresenter.class, inj2061_WorkbenchMenuBarPresenter_creational, inj2060_WorkbenchMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(WorkbenchMenuBar.class, WorkbenchMenuBarPresenter.class, inj2061_WorkbenchMenuBarPresenter_creational, inj2060_WorkbenchMenuBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ShowcaseEntryPoint.class, ShowcaseEntryPoint.class, inj2064_ShowcaseEntryPoint_creational, inj2063_ShowcaseEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SplitLayoutPanelView.class, SplitLayoutPanelView.class, inj2066_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_142200960, "SplitLayoutPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, SplitLayoutPanelView.class, inj2066_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_142200960, "SplitLayoutPanelView", false);
    injContext.addBean(UberView.class, SplitLayoutPanelView.class, inj2066_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_142200960, null, false);
    injContext.addBean(IsWidget.class, SplitLayoutPanelView.class, inj2066_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_142200960, null, false);
    injContext.addBean(RequiresResize.class, SplitLayoutPanelView.class, inj2066_SplitLayoutPanelView_creational, null, arrayOf_19635043Annotation_142200960, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj2067_ListWidgetProvider_creational, inj1952_ListWidgetProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj2067_ListWidgetProvider_creational, inj1952_ListWidgetProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RuntimePluginsServiceProxyClientImpl.class, RuntimePluginsServiceProxyClientImpl.class, inj2069_RuntimePluginsServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RuntimePluginsServiceProxy.class, RuntimePluginsServiceProxyClientImpl.class, inj2069_RuntimePluginsServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativeEditor.class, JSNativeEditor.class, inj2071_JSNativeEditor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeEditor.class, inj2071_JSNativeEditor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleLayoutPanel.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SimpleLayoutPanel.class, inj2074_SimpleLayoutPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeFlowPanel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RequiresResize.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ProvidesResize.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FlowPanel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.InsertPanel.ForIsWidget.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InsertPanel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IndexedPanel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ComplexPanel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ResizeFlowPanel.class, inj2075_ResizeFlowPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MultiTabWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, "MultiTabWorkbenchPanelView", true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, "MultiTabWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(WorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(UberView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(IsWidget.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(RequiresResize.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(ResizeComposite.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(Composite.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(IsRenderable.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(Widget.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(EventListener.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(HasHandlers.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(UIObject.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(HasVisibility.class, MultiTabWorkbenchPanelView.class, inj2073_MultiTabWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_52355314, null, false);
    injContext.addBean(PartManager.class, PartManager.class, inj2077_PartManager_creational, inj2076_PartManager, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LayoutPanelView.class, LayoutPanelView.class, inj2079_LayoutPanelView_creational, null, arrayOf_19635043Annotation_891553467, "LayoutPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, LayoutPanelView.class, inj2079_LayoutPanelView_creational, null, arrayOf_19635043Annotation_891553467, "LayoutPanelView", false);
    injContext.addBean(UberView.class, LayoutPanelView.class, inj2079_LayoutPanelView_creational, null, arrayOf_19635043Annotation_891553467, null, false);
    injContext.addBean(IsWidget.class, LayoutPanelView.class, inj2079_LayoutPanelView_creational, null, arrayOf_19635043Annotation_891553467, null, false);
    injContext.addBean(RequiresResize.class, LayoutPanelView.class, inj2079_LayoutPanelView_creational, null, arrayOf_19635043Annotation_891553467, null, false);
    injContext.addBean(ListBarWidget.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiPartWidget.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBeforeSelectionHandlers.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasSelectionHandlers.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ListBarWidget.class, inj2081_ListBarWidget_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ContextPanel.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ContextPanel.class, inj2084_ContextPanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleDnDWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SimpleDnDWorkbenchPanelView.class, inj2083_SimpleDnDWorkbenchPanelView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, "SimpleWorkbenchPanelView", true);
    injContext.addBean(AbstractSimpleWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, "SimpleWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(WorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(UberView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(IsWidget.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(RequiresResize.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(ResizeComposite.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(Composite.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(IsRenderable.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(Widget.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(EventListener.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(HasAttachHandlers.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(HasHandlers.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(UIObject.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(HasVisibility.class, SimpleWorkbenchPanelView.class, inj2086_SimpleWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1084219910, null, false);
    injContext.addBean(MultiListWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, "MultiListWorkbenchPanelView", true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, "MultiListWorkbenchPanelView", false);
    injContext.addBean(AbstractDockingWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(DockingWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(WorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(UberView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(IsWidget.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(RequiresResize.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(AbstractWorkbenchPanelView.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(ResizeComposite.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(Composite.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(IsRenderable.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(Widget.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(EventListener.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(HasHandlers.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(UIObject.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(HasVisibility.class, MultiListWorkbenchPanelView.class, inj2088_MultiListWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1664445436, null, false);
    injContext.addBean(TemplatedWorkbenchPanelView.class, TemplatedWorkbenchPanelView.class, inj2090_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1634264068, "TemplatedWorkbenchPanelView", true);
    injContext.addBean(WorkbenchPanelView.class, TemplatedWorkbenchPanelView.class, inj2090_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1634264068, "TemplatedWorkbenchPanelView", false);
    injContext.addBean(UberView.class, TemplatedWorkbenchPanelView.class, inj2090_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1634264068, null, false);
    injContext.addBean(IsWidget.class, TemplatedWorkbenchPanelView.class, inj2090_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1634264068, null, false);
    injContext.addBean(RequiresResize.class, TemplatedWorkbenchPanelView.class, inj2090_TemplatedWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1634264068, null, false);
    injContext.addBean(StaticFocusedResizePanel.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HasSelectionHandlers.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocusHandlers.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResizeComposite.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiresResize.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, StaticFocusedResizePanel.class, inj2093_StaticFocusedResizePanel_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(StaticWorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, "StaticWorkbenchPanelView", true);
    injContext.addBean(AbstractWorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, "StaticWorkbenchPanelView", false);
    injContext.addBean(WorkbenchPanelView.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(UberView.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(IsWidget.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(RequiresResize.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(ResizeComposite.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(Composite.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(IsRenderable.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(Widget.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(EventListener.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(HasAttachHandlers.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(HasHandlers.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(UIObject.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(HasVisibility.class, StaticWorkbenchPanelView.class, inj2092_StaticWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_968424154, null, false);
    injContext.addBean(MultiTabWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, MultiTabWorkbenchPanelPresenter.class, inj2095_MultiTabWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CustomSplashHelp.class, CustomSplashHelp.class, inj2097_CustomSplashHelp_creational, inj2096_CustomSplashHelp, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(CustomMenuBuilder.class, CustomSplashHelp.class, inj2097_CustomSplashHelp_creational, inj2096_CustomSplashHelp, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventBus.class, EventBus.class, inj1948_EventBus_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AnyResourceType.class, AnyResourceType.class, inj2099_AnyResourceType_creational, inj2098_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientResourceType.class, AnyResourceType.class, inj2099_AnyResourceType_creational, inj2098_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResourceTypeDefinition.class, AnyResourceType.class, inj2099_AnyResourceType_creational, inj2098_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AnyResourceTypeDefinition.class, AnyResourceType.class, inj2099_AnyResourceType_creational, inj2098_AnyResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj2100_DisposerProvider_creational, inj1986_DisposerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj2100_DisposerProvider_creational, inj1986_DisposerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WelcomeScreen.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WelcomeScreen.class, inj2102_WelcomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HelloWorldScreen.class, HelloWorldScreen.class, inj2104_HelloWorldScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HelloWorldScreenActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, "HelloWorldScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, "HelloWorldScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(WorkbenchActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(ContextSensitiveActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(Activity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(RuntimeResource.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(Resource.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(AbstractActivity.class, HelloWorldScreenActivity.class, inj2106_HelloWorldScreenActivity_creational, null, arrayOf_19635043Annotation_259736363, null, false);
    injContext.addBean(VFSJSExporter.class, VFSJSExporter.class, inj2108_VFSJSExporter_creational, inj2107_VFSJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, VFSJSExporter.class, inj2108_VFSJSExporter_creational, inj2107_VFSJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientTypeRegistryImpl.class, ClientTypeRegistryImpl.class, inj2110_ClientTypeRegistryImpl_creational, inj2109_ClientTypeRegistryImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientTypeRegistry.class, ClientTypeRegistryImpl.class, inj2110_ClientTypeRegistryImpl_creational, inj2109_ClientTypeRegistryImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TemplatedWorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2112_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2112_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, TemplatedWorkbenchPanelPresenter.class, inj2112_TemplatedWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LayoutPanelPresenter.class, LayoutPanelPresenter.class, inj2114_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, LayoutPanelPresenter.class, inj2114_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, LayoutPanelPresenter.class, inj2114_LayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberfireComponentsJSExporter.class, UberfireComponentsJSExporter.class, inj2116_UberfireComponentsJSExporter_creational, inj2115_UberfireComponentsJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StandaloneEditorPerspective.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, "StandaloneEditorPerspective", true);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, "StandaloneEditorPerspective", false);
    injContext.addBean(PerspectiveActivity.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(ContextSensitiveActivity.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(Activity.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(RuntimeResource.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(Resource.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(AbstractActivity.class, StandaloneEditorPerspective.class, inj2118_StandaloneEditorPerspective_creational, null, arrayOf_19635043Annotation_1283183184, null, false);
    injContext.addBean(MenuSplashList.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MenuSplashList.class, inj2120_MenuSplashList_creational, inj2119_MenuSplashList, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HomePerspective.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, HomePerspective.class, inj2122_HomePerspective_creational, inj2121_HomePerspective, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HomePerspectiveActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, "HomePerspective", true);
    injContext.addBean(TemplatedActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, "HomePerspective", false);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, "HomePerspective", false);
    injContext.addBean(PerspectiveActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(ContextSensitiveActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(Activity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(RuntimeResource.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(Resource.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(AbstractActivity.class, HomePerspectiveActivity.class, inj2124_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1853576499, null, false);
    injContext.addBean(TransitionAnchorProvider.class, TransitionAnchorProvider.class, inj2125_TransitionAnchorProvider_creational, inj1982_TransitionAnchorProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionAnchorProvider.class, inj2125_TransitionAnchorProvider_creational, inj1982_TransitionAnchorProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TransitionAnchorFactoryProvider.class, TransitionAnchorFactoryProvider.class, inj2126_TransitionAnchorFactoryProvider_creational, inj1988_TransitionAnchorFactoryProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionAnchorFactoryProvider.class, inj2126_TransitionAnchorFactoryProvider_creational, inj1988_TransitionAnchorFactoryProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PageTransitionProvider.class, PageTransitionProvider.class, inj2127_PageTransitionProvider_creational, inj1954_PageTransitionProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, PageTransitionProvider.class, inj2127_PageTransitionProvider_creational, inj1954_PageTransitionProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientRequiredRolesExtractorImpl.class, ClientRequiredRolesExtractorImpl.class, inj2129_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SharedRequiredRolesExtractorImpl.class, ClientRequiredRolesExtractorImpl.class, inj2129_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RequiredRolesExtractor.class, ClientRequiredRolesExtractorImpl.class, inj2129_ClientRequiredRolesExtractorImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ClientSecurityRoleInterceptor.class, ClientSecurityRoleInterceptor.class, inj2131_ClientSecurityRoleInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RemoteCallInterceptor.class, ClientSecurityRoleInterceptor.class, inj2131_ClientSecurityRoleInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj2132_RootPanelProvider_creational, inj1964_RootPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj2132_RootPanelProvider_creational, inj1964_RootPanelProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberfireJSAPIExporter.class, UberfireJSAPIExporter.class, inj2134_UberfireJSAPIExporter_creational, inj2133_UberfireJSAPIExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSServiceProxyClientImpl.class, VFSServiceProxyClientImpl.class, inj2136_VFSServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(VFSServiceProxy.class, VFSServiceProxyClientImpl.class, inj2136_VFSServiceProxyClientImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Workbench.class, Workbench.class, inj2138_Workbench_creational, inj2137_Workbench, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(StaticWorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2140_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2140_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, StaticWorkbenchPanelPresenter.class, inj2140_StaticWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TransitionToRoleProvider.class, TransitionToRoleProvider.class, inj2141_TransitionToRoleProvider_creational, inj1966_TransitionToRoleProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, TransitionToRoleProvider.class, inj2141_TransitionToRoleProvider_creational, inj1966_TransitionToRoleProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SecurityRolesConstraintPage.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SimplePanel.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, SecurityRolesConstraintPage.class, inj2142_SecurityRolesConstraintPage_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj2143_InitBallotProvider_creational, inj1978_InitBallotProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj2143_InitBallotProvider_creational, inj1978_InitBallotProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SplashScreenJSExporter.class, SplashScreenJSExporter.class, inj2145_SplashScreenJSExporter_creational, inj2144_SplashScreenJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, SplashScreenJSExporter.class, inj2145_SplashScreenJSExporter_creational, inj2144_SplashScreenJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LessStyle.class, LessStyle.class, inj2147_LessStyle_creational, inj2146_LessStyle, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(MultiListWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractMultiPartWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, MultiListWorkbenchPanelPresenter.class, inj2149_MultiListWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HomeScreen.class, HomeScreen.class, inj2151_HomeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AccessImpl.class, AccessImpl.class, inj2153_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Access.class, AccessImpl.class, inj2153_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, AccessImpl.class, inj2153_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, AccessImpl.class, inj2153_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, AccessImpl.class, inj2153_AccessImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj2154_DataBinderProvider_creational, inj1974_DataBinderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj2154_DataBinderProvider_creational, inj1974_DataBinderProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WelcomeScreenActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, "welcome", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, "welcome", false);
    injContext.addBean(WorkbenchScreenActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(WorkbenchActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(ContextSensitiveActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(Activity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(RuntimeResource.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(Resource.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(AbstractActivity.class, WelcomeScreenActivity.class, inj2156_WelcomeScreenActivity_creational, null, arrayOf_19635043Annotation_945122451, null, false);
    injContext.addBean(SessionInfo.class, SessionInfo.class, inj1949_SessionInfo_creational, SimpleInjectionContext.LAZY_INIT_REF, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(HomeScreenActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, "HomeScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, "HomeScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(WorkbenchActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(ContextSensitiveActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(Activity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(RuntimeResource.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(Resource.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(AbstractActivity.class, HomeScreenActivity.class, inj2158_HomeScreenActivity_creational, null, arrayOf_19635043Annotation_1828304098, null, false);
    injContext.addBean(PlaceManagerJSExporter.class, PlaceManagerJSExporter.class, inj2160_PlaceManagerJSExporter_creational, inj2159_PlaceManagerJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PlaceManagerJSExporter.class, inj2160_PlaceManagerJSExporter_creational, inj2159_PlaceManagerJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2162_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2162_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2162_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2162_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SimpleWorkbenchPanelPresenter.class, inj2162_SimpleWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PluginJSExporter.class, PluginJSExporter.class, inj2164_PluginJSExporter_creational, inj2163_PluginJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PluginJSExporter.class, inj2164_PluginJSExporter_creational, inj2163_PluginJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PartContextMenusView.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter.View.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
  }

  private void declareBeans_1() {
    injContext.addBean(EventListener.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, PartContextMenusView.class, inj2166_PartContextMenusView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PartContextMenusPresenter.class, PartContextMenusPresenter.class, inj2168_PartContextMenusPresenter_creational, inj2167_PartContextMenusPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RoleStyleBindingProvider.class, RoleStyleBindingProvider.class, inj2170_RoleStyleBindingProvider_creational, inj2169_RoleStyleBindingProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DotResourceTypeDefinition.class, DotResourceTypeDefinition.class, inj2172_DotResourceTypeDefinition_creational, inj2171_DotResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ResourceTypeDefinition.class, DotResourceTypeDefinition.class, inj2172_DotResourceTypeDefinition_creational, inj2171_DotResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimpleDnDWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2174_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractDockingWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2174_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DockingWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2174_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2174_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SimpleDnDWorkbenchPanelPresenter.class, inj2174_SimpleDnDWorkbenchPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TextResourceTypeDefinition.class, TextResourceTypeDefinition.class, inj2176_TextResourceTypeDefinition_creational, inj2175_TextResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ResourceTypeDefinition.class, TextResourceTypeDefinition.class, inj2176_TextResourceTypeDefinition_creational, inj2175_TextResourceTypeDefinition, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(NotificationPopupView.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DecoratedPopupPanel.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PopupPanel.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesPopupEvents.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventPreview.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAnimation.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasCloseHandlers.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, NotificationPopupView.class, inj2178_NotificationPopupView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchToolBarView.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchToolBarView.class, inj2181_WorkbenchToolBarView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchToolBarPresenter.class, WorkbenchToolBarPresenter.class, inj2180_WorkbenchToolBarPresenter_creational, inj2179_WorkbenchToolBarPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LocaleSelector.class, LocaleSelector.class, inj2183_LocaleSelector_creational, inj2182_LocaleSelector, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LocaleListBox.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ValueListBox.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasConstrainedValue.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValue.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TakesValue.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValueChangeHandlers.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsEditor.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Composite.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, LocaleListBox.class, inj2185_LocaleListBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DefaultBusSecurityErrorCallback.class, DefaultBusSecurityErrorCallback.class, inj2187_DefaultBusSecurityErrorCallback_creational, inj2186_DefaultBusSecurityErrorCallback, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SplitLayoutPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2189_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(AbstractWorkbenchPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2189_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(WorkbenchPanelPresenter.class, SplitLayoutPanelPresenter.class, inj2189_SplitLayoutPanelPresenter_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityNotFoundView.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter.View.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UberView.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SimplePanel.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasOneWidget.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(AcceptsOneWidget.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Panel.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ForIsWidget.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasWidgets.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Iterable.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, ActivityNotFoundView.class, inj2192_ActivityNotFoundView_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ActivityNotFoundPresenter.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, "uf.workbench.activity.notfound", true);
    injContext.addBean(AbstractPopupActivity.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, "uf.workbench.activity.notfound", false);
    injContext.addBean(PopupActivity.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, null, false);
    injContext.addBean(Activity.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, null, false);
    injContext.addBean(RuntimeResource.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, null, false);
    injContext.addBean(Resource.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, null, false);
    injContext.addBean(AbstractActivity.class, ActivityNotFoundPresenter.class, inj2191_ActivityNotFoundPresenter_creational, inj2190_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1589807214, null, false);
    injContext.addBean(TextBox.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(TextBoxBase.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ValueBoxBase.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasChangeHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasName.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValue.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(TakesValue.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Target.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasText.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDirection.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsEditor.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(FocusWidget.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesClickEvents.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasClickHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocus.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Focusable.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasEnabled.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasDropHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasFocusHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasBlurHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, TextBox.class, inj2195_TextBox_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MoodScreen.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Composite.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsRenderable.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Widget.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(EventListener.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasAttachHandlers.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasHandlers.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsWidget.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(UIObject.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(HasVisibility.class, MoodScreen.class, inj2194_MoodScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(MoodScreenActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, "MoodScreen", true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, "MoodScreen", false);
    injContext.addBean(WorkbenchScreenActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(WorkbenchActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(ContextSensitiveActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(Activity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(RuntimeResource.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(Resource.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(AbstractActivity.class, MoodScreenActivity.class, inj2197_MoodScreenActivity_creational, null, arrayOf_19635043Annotation_1484530921, null, false);
    injContext.addBean(BatchCallerProvider.class, BatchCallerProvider.class, inj2198_BatchCallerProvider_creational, inj1958_BatchCallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Provider.class, BatchCallerProvider.class, inj2198_BatchCallerProvider_creational, inj1958_BatchCallerProvider, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativeSplashScreen.class, JSNativeSplashScreen.class, inj2200_JSNativeSplashScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeSplashScreen.class, inj2200_JSNativeSplashScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSNativeScreen.class, JSNativeScreen.class, inj2202_JSNativeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(JSNativePlugin.class, JSNativeScreen.class, inj2202_JSNativeScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DemoSplashScreen.class, DemoSplashScreen.class, inj2205_DemoSplashScreen_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(DemoSplashScreenActivity.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, "demo.splash", true);
    injContext.addBean(AbstractSplashScreenActivity.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, "demo.splash", false);
    injContext.addBean(SplashScreenActivity.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, null, false);
    injContext.addBean(Activity.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, null, false);
    injContext.addBean(RuntimeResource.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, null, false);
    injContext.addBean(Resource.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, null, false);
    injContext.addBean(AbstractActivity.class, DemoSplashScreenActivity.class, inj2204_DemoSplashScreenActivity_creational, inj2203_DemoSplashScreenActivity, arrayOf_19635043Annotation_302748957, null, false);
    injContext.addBean(AuthenticationServiceInterceptor.class, AuthenticationServiceInterceptor.class, inj2207_AuthenticationServiceInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RemoteCallInterceptor.class, AuthenticationServiceInterceptor.class, inj2207_AuthenticationServiceInterceptor_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(JSEntryPoint.class, JSEntryPoint.class, inj2209_JSEntryPoint_creational, inj2208_JSEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(SecurityEntryPoint.class, SecurityEntryPoint.class, inj2211_SecurityEntryPoint_creational, inj2210_SecurityEntryPoint, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(org.uberfire.client.screens.ActivityNotFoundPresenter.class, org.uberfire.client.screens.ActivityNotFoundPresenter.class, inj2213_ActivityNotFoundPresenter_creational, inj2212_ActivityNotFoundPresenter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ActivityNotFoundPresenterActivity.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, "workbench.activity.notfound", true);
    injContext.addBean(AbstractPopupActivity.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, "workbench.activity.notfound", false);
    injContext.addBean(PopupActivity.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, null, false);
    injContext.addBean(Activity.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, null, false);
    injContext.addBean(RuntimeResource.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, null, false);
    injContext.addBean(Resource.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, null, false);
    injContext.addBean(AbstractActivity.class, ActivityNotFoundPresenterActivity.class, inj2215_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_41887215, null, false);
    injContext.addBean(DestructionImpl.class, DestructionImpl.class, inj2217_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Destruction.class, DestructionImpl.class, inj2217_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, DestructionImpl.class, inj2217_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, DestructionImpl.class, inj2217_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, DestructionImpl.class, inj2217_DestructionImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleListenerRegistrarImpl.class, LifecycleListenerRegistrarImpl.class, inj2219_LifecycleListenerRegistrarImpl_creational, inj2218_LifecycleListenerRegistrarImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(LifecycleListenerRegistrar.class, LifecycleListenerRegistrarImpl.class, inj2219_LifecycleListenerRegistrarImpl_creational, inj2218_LifecycleListenerRegistrarImpl, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ObservablePathImpl.class, ObservablePathImpl.class, inj2221_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ObservablePath.class, ObservablePathImpl.class, inj2221_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Path.class, ObservablePathImpl.class, inj2221_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(Comparable.class, ObservablePathImpl.class, inj2221_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(IsVersioned.class, ObservablePathImpl.class, inj2221_ObservablePathImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DefaultRestSecurityErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2223_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(RestErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2223_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ErrorCallback.class, DefaultRestSecurityErrorCallback.class, inj2223_DefaultRestSecurityErrorCallback_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(PerspectiveJSExporter.class, PerspectiveJSExporter.class, inj2225_PerspectiveJSExporter_creational, inj2224_PerspectiveJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(UberfireJSExporter.class, PerspectiveJSExporter.class, inj2225_PerspectiveJSExporter_creational, inj2224_PerspectiveJSExporter, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DotResourceType.class, DotResourceType.class, inj2227_DotResourceType_creational, inj2226_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(ClientResourceType.class, DotResourceType.class, inj2227_DotResourceType_creational, inj2226_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(ResourceTypeDefinition.class, DotResourceType.class, inj2227_DotResourceType_creational, inj2226_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(DotResourceTypeDefinition.class, DotResourceType.class, inj2227_DotResourceType_creational, inj2226_DotResourceType, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(CreationImpl.class, CreationImpl.class, inj2229_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, true);
    injContext.addBean(Creation.class, CreationImpl.class, inj2229_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, CreationImpl.class, inj2229_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEventImpl.class, CreationImpl.class, inj2229_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
    injContext.addBean(LifecycleEvent.class, CreationImpl.class, inj2229_CreationImpl_creational, null, QualifierUtil.DEFAULT_QUALIFIERS, null, false);
  }

  private native static TextBox _1150956601__$371269162_moodTextBox(MoodScreen instance) /*-{
    return instance.@org.uberfire.client.screens.MoodScreen::moodTextBox;
  }-*/;

  private native static void _1150956601__$371269162_moodTextBox(MoodScreen instance, TextBox value) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::moodTextBox = value;
  }-*/;

  private native static void _$389641401__$1825231548_layoutSelection(PanelManagerImpl instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::layoutSelection = value;
  }-*/;

  private native static void _711644943__$1574799830_authzManager(PartContextMenusView instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusView::authzManager = value;
  }-*/;

  private native static void _$1304194947__291376327_sessionInfo(ObservablePathImpl instance, SessionInfo value) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::sessionInfo = value;
  }-*/;

  private native static void _$389641401__1116818801_panelFocusEvent(PanelManagerImpl instance, Event<PanelFocusEvent> value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::panelFocusEvent = value;
  }-*/;

  private native static WorkbenchPanelPanel _$1083291890__421004336_anotherScreen(HomePerspective instance) /*-{
    return instance.@org.uberfire.client.HomePerspective::anotherScreen;
  }-*/;

  private native static void _$1083291890__421004336_anotherScreen(HomePerspective instance, WorkbenchPanelPanel value) /*-{
    instance.@org.uberfire.client.HomePerspective::anotherScreen = value;
  }-*/;

  private native static void _73328378__$906533316_placeManager(ShowcaseEntryPoint instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::placeManager = value;
  }-*/;

  private native static void _1730935432__$1934524921_lifecycleErrorHandler(ActivityManagerImpl instance, ActivityLifecycleErrorHandler value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::lifecycleErrorHandler = value;
  }-*/;

  private native static void _$1462522111__879292651_bus(Workbench instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::bus = value;
  }-*/;

  private native static void _$1757102468__$1335679257_perspectiveManager(PlaceManagerImpl instance, PerspectiveManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::perspectiveManager = value;
  }-*/;

  private native static void _1350680564__$1232121576_selector(LocaleListBox instance, LocaleSelector value) /*-{
    instance.@org.jboss.errai.ui.client.widget.LocaleListBox::selector = value;
  }-*/;

  private native static void _$1462522111__1116818801_appReady(Workbench instance, Event<ApplicationReadyEvent> value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::appReady = value;
  }-*/;

  private native static void _73328378__879292651_bus(ShowcaseEntryPoint instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::bus = value;
  }-*/;

  private native static void _$1934524921__1388723237_logger(ActivityLifecycleErrorHandler instance, Logger value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::logger = value;
  }-*/;

  private native static void _1174169399__$652658075_iocManager(DefaultBeanFactory instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.DefaultBeanFactory::iocManager = value;
  }-*/;

  private native static void _618642634__820873068_partViewContainer(AbstractDockingWorkbenchPanelView instance, ResizeFlowPanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::partViewContainer = value;
  }-*/;

  private native static void _$1913953616__597466346_identity(PespectiveContextMenusView instance, User value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusView::identity = value;
  }-*/;

  private native static void _1346204971__789713372_contextWidget(AbstractSimpleWorkbenchPanelView instance, ContextPanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView::contextWidget = value;
  }-*/;

  private native static void _$274999170__154256171_view(PartContextMenusPresenter instance, org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::view = value;
  }-*/;

  private native static void _1084732347__314455785_securityErrorTransition(SecurityRolesConstraintPage instance, TransitionToRole<SecurityError> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage::securityErrorTransition = value;
  }-*/;

  private native static void _$746838216__$652658075_iocManager(NotificationPopupsManager instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notifications.NotificationPopupsManager::iocManager = value;
  }-*/;

  private native static void _1420226898__443136474_partManager(LayoutPanelView instance, PartManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.LayoutPanelView::partManager = value;
  }-*/;

  private native static void _$448678005__$304677073_wbServices(JSNativeSplashScreen instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.splash.JSNativeSplashScreen::wbServices = value;
  }-*/;

  private native static void _689680445__$1083291890_realPresenter(HomePerspectiveActivity instance, HomePerspective value) /*-{
    instance.@org.uberfire.client.HomePerspectiveActivity::realPresenter = value;
  }-*/;

  private native static void _$1786166680__1150956601_realPresenter(MoodScreenActivity instance, MoodScreen value) /*-{
    instance.@org.uberfire.client.screens.MoodScreenActivity::realPresenter = value;
  }-*/;

  private native static void _683332058__153624969_dndManager(WorkbenchPickupDragController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController::dndManager = value;
  }-*/;

  private native static void _153624969__683332058_dragController(WorkbenchDragAndDropManager instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::dragController = value;
  }-*/;

  private native static void _$1757102468__$1657106037_workbenchLayout(PlaceManagerImpl instance, WorkbenchLayout value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchLayout = value;
  }-*/;

  private native static void _$896357979__$906533316_placeManager(StaticWorkbenchPanelView instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::placeManager = value;
  }-*/;

  private native static void _$1462522111__$906533316_placeManager(Workbench instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::placeManager = value;
  }-*/;

  private native static void _1934862923__153624969_dndManager(WorkbenchLayoutImpl instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::dndManager = value;
  }-*/;

  private native static void _378913974__120980481_userServiceCaller(SecurityContextImpl instance, Caller<NonCachingUserService> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::userServiceCaller = value;
  }-*/;

  private native static void _1934862923__683332058_dragController(WorkbenchLayoutImpl instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::dragController = value;
  }-*/;

  private native static void _$274999170__$906533316_placeManager(PartContextMenusPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::placeManager = value;
  }-*/;

  private native static void _$348507737__1116818801_perspectiveChangeEvent(PerspectiveManagerImpl instance, Event<PerspectiveChange> value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::perspectiveChangeEvent = value;
  }-*/;

  private native static void _$1825231548__$652658075_iocManager(LayoutSelection instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.LayoutSelection::iocManager = value;
  }-*/;

  private native static void _$1757102468__1116818801_selectWorkbenchPartEvent(PlaceManagerImpl instance, Event<SelectPlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::selectWorkbenchPartEvent = value;
  }-*/;

  private native static void _$924432381__$262319993_panelManager(ListBarWidget instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.listbar.ListBarWidget::panelManager = value;
  }-*/;

  private native static void _1934862923__$1393584145_root(WorkbenchLayoutImpl instance, HeaderPanel value) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::root = value;
  }-*/;

  private native static void _$389641401__1116818801_placeGainFocusEvent(PanelManagerImpl instance, Event<PlaceGainFocusEvent> value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::placeGainFocusEvent = value;
  }-*/;

  private native static void _378913974__1116818801_loginEvent(SecurityContextImpl instance, Event<LoggedInEvent> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::loginEvent = value;
  }-*/;

  private native static void _$896357979__$1655162226_panel(StaticWorkbenchPanelView instance, StaticFocusedResizePanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::panel = value;
  }-*/;

  private native static void _$389641401__1116818801_selectPlaceEvent(PanelManagerImpl instance, Event<SelectPlaceEvent> value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::selectPlaceEvent = value;
  }-*/;

  private native static void _7760253__$577439348_view(PespectiveContextMenusPresenter instance, org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusPresenter::view = value;
  }-*/;

  private native static void _378913974__$282317259_userCache(SecurityContextImpl instance, ActiveUserCache value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::userCache = value;
  }-*/;

  private native static void _57041102__$1583970232_activityManager(UberfireComponentsJSExporter instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.exporter.UberfireComponentsJSExporter::activityManager = value;
  }-*/;

  private native static void _2052955140__1116818801_newWorkbenchScreenEventEvent(ActivityBeansCache instance, Event<NewWorkbenchScreenEvent> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::newWorkbenchScreenEventEvent = value;
  }-*/;

  private native static void _$1034438370__136504311_navigation(TransitionAnchorProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorProvider::navigation = value;
  }-*/;

  private native static void _73328378__$1583970232_activityManager(ShowcaseEntryPoint instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::activityManager = value;
  }-*/;

  private native static void _1584088255__$2073863603_runtimePluginsService(JSNativePlugin instance, RuntimePluginsServiceProxy value) /*-{
    instance.@org.uberfire.client.plugin.JSNativePlugin::runtimePluginsService = value;
  }-*/;

  private native static void _$2051573400__$906533316_placeManager(ActivityNotFoundPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter::placeManager = value;
  }-*/;

  private native static void _1730935432__597466346_identity(ActivityManagerImpl instance, User value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::identity = value;
  }-*/;

  private native static void _378913974__1116818801_logoutEvent(SecurityContextImpl instance, Event<LoggedOutEvent> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::logoutEvent = value;
  }-*/;

  private native static void _663569186__1388723237_logger(BasicUserCacheImpl instance, Logger value) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::logger = value;
  }-*/;

  private native static void _1420226898__$906533316_placeManager(LayoutPanelView instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.LayoutPanelView::placeManager = value;
  }-*/;

  private native static void _$2051573400__$1566038911_view(ActivityNotFoundPresenter instance, org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notfound.ActivityNotFoundPresenter::view = value;
  }-*/;

  private native static void _378913974__136504311_navigation(SecurityContextImpl instance, Navigation value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::navigation = value;
  }-*/;

  private native static void _618642634__153624969_dndManager(AbstractDockingWorkbenchPanelView instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::dndManager = value;
  }-*/;

  private native static void _$1757102468__$262319993_panelManager(PlaceManagerImpl instance, PanelManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::panelManager = value;
  }-*/;

  private native static void _$1913953616__$1574799830_authzManager(PespectiveContextMenusView instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusView::authzManager = value;
  }-*/;

  private native static void _$1340452412__$906533316_placeManager(MenuSplashList instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.menu.MenuSplashList::placeManager = value;
  }-*/;

  private native static void _102087148__597466346_identity(WorkbenchMenuBarView instance, User value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView::identity = value;
  }-*/;

  private native static void _474272692__$924432381_listBar(MultiListWorkbenchPanelView instance, ListBarWidget value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.MultiListWorkbenchPanelView::listBar = value;
  }-*/;

  private native static void _$1934524921__1116818801_lifecycleErrorEvent(ActivityLifecycleErrorHandler instance, Event<ActivityLifecycleError> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::lifecycleErrorEvent = value;
  }-*/;

  private native static void _$1757102468__$1934524921_lifecycleErrorHandler(PlaceManagerImpl instance, ActivityLifecycleErrorHandler value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::lifecycleErrorHandler = value;
  }-*/;

  private native static void _2052955140__1116818801_newPerspectiveEventEvent(ActivityBeansCache instance, Event<NewPerspectiveEvent> value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::newPerspectiveEventEvent = value;
  }-*/;

  private native static void _$1494319141__144807084_realPresenter(DemoSplashScreenActivity instance, DemoSplashScreen value) /*-{
    instance.@org.uberfire.client.screens.DemoSplashScreenActivity::realPresenter = value;
  }-*/;

  private native static void _$2070321720__1043576729_realPresenter(AnotherScreenActivity instance, AnotherScreen value) /*-{
    instance.@org.uberfire.client.screens.AnotherScreenActivity::realPresenter = value;
  }-*/;

  private native static void _1432847952__$464592863_realPresenter(HomeScreenActivity instance, HomeScreen value) /*-{
    instance.@org.uberfire.client.screens.HomeScreenActivity::realPresenter = value;
  }-*/;

  private native static void _684448251__$1583970232_activityManager(JSNativePerspective instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::activityManager = value;
  }-*/;

  private native static WorkbenchPanelPanel _$1083291890__421004336_moodScreen(HomePerspective instance) /*-{
    return instance.@org.uberfire.client.HomePerspective::moodScreen;
  }-*/;

  private native static void _$1083291890__421004336_moodScreen(HomePerspective instance, WorkbenchPanelPanel value) /*-{
    instance.@org.uberfire.client.HomePerspective::moodScreen = value;
  }-*/;

  private native static void _73328378__$1335679257_perspectiveManager(ShowcaseEntryPoint instance, PerspectiveManager value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::perspectiveManager = value;
  }-*/;

  private native static void _1653100451__$262319993_panelManager(AbstractDockingWorkbenchPanelPresenter instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelPresenter::panelManager = value;
  }-*/;

  private native static void _1730935432__$1574799830_authzManager(ActivityManagerImpl instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::authzManager = value;
  }-*/;

  private native static void _$389641401__1730751009_uberfireContext(PanelManagerImpl instance, UberfireContext value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::uberfireContext = value;
  }-*/;

  private native static void _$1757102468__1116818801_newSplashScreenActiveEvent(PlaceManagerImpl instance, Event<NewSplashScreenActiveEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::newSplashScreenActiveEvent = value;
  }-*/;

  private native static WorkbenchPanelPanel _$1083291890__421004336_homeScreen(HomePerspective instance) /*-{
    return instance.@org.uberfire.client.HomePerspective::homeScreen;
  }-*/;

  private native static void _$1083291890__421004336_homeScreen(HomePerspective instance, WorkbenchPanelPanel value) /*-{
    instance.@org.uberfire.client.HomePerspective::homeScreen = value;
  }-*/;

  private native static void _73328378__1116818801_dumpLayoutEvent(ShowcaseEntryPoint instance, Event<DumpLayout> value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::dumpLayoutEvent = value;
  }-*/;

  private native static void _1095151889__960584674_realPresenter(HelloWorldScreenActivity instance, HelloWorldScreen value) /*-{
    instance.@org.uberfire.client.screens.HelloWorldScreenActivity::realPresenter = value;
  }-*/;

  private native static void _$1933089096__1388723237_logger(RuntimePluginsServiceProxyClientImpl instance, Logger value) /*-{
    instance.@org.uberfire.client.plugin.RuntimePluginsServiceProxyClientImpl::logger = value;
  }-*/;

  private native static void _$1462522111__$715182114_vfsService(Workbench instance, VFSServiceProxy value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::vfsService = value;
  }-*/;

  private native static void _$1462522111__$1825231548_layoutSelection(Workbench instance, LayoutSelection value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::layoutSelection = value;
  }-*/;

  private native static void _$348507737__$262319993_panelManager(PerspectiveManagerImpl instance, PanelManager value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::panelManager = value;
  }-*/;

  private native static void _153624969__$1887041540_factory(WorkbenchDragAndDropManager instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::factory = value;
  }-*/;

  private native static void _$1757102468__$1583970232_activityManager(PlaceManagerImpl instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::activityManager = value;
  }-*/;

  private native static void _$1351718937__501237944_realPresenter(WelcomeScreenActivity instance, WelcomeScreen value) /*-{
    instance.@org.uberfire.client.screens.WelcomeScreenActivity::realPresenter = value;
  }-*/;

  private native static void _73328378__$351881561_menubar(ShowcaseEntryPoint instance, WorkbenchMenuBar value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::menubar = value;
  }-*/;

  private native static void _1730935432__$652658075_iocManager(ActivityManagerImpl instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::iocManager = value;
  }-*/;

  private native static void _$1254526097__120980481_vfsServices(VFSJSExporter instance, Caller<VFSService> value) /*-{
    instance.@org.uberfire.client.exporter.VFSJSExporter::vfsServices = value;
  }-*/;

  private native static void _$292735039__$906533316_placeManager(WorkbenchMenuBarPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::placeManager = value;
  }-*/;

  private native static void _$924432381__$1574799830_authzManager(ListBarWidget instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.listbar.ListBarWidget::authzManager = value;
  }-*/;

  private native static void _663569186__$1444549593_userStorageHandler(BasicUserCacheImpl instance, UserStorageHandler value) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::userStorageHandler = value;
  }-*/;

  private native static void _$1462522111__597466346_identity(Workbench instance, User value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::identity = value;
  }-*/;

  private native static void _378913974__1388723237_logger(SecurityContextImpl instance, Logger value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::logger = value;
  }-*/;

  private native static void _$389641401__$903668163_placeManager(PanelManagerImpl instance, Instance<PlaceManager> value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::placeManager = value;
  }-*/;

  private native static void _$389641401__1116818801_placeLostFocusEvent(PanelManagerImpl instance, Event<PlaceLostFocusEvent> value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::placeLostFocusEvent = value;
  }-*/;

  private native static void _618642634__$634457504_topLevelWidget(AbstractDockingWorkbenchPanelView instance, SimpleLayoutPanel value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::topLevelWidget = value;
  }-*/;

  private native static void _1346204971__$924432381_listBar(AbstractSimpleWorkbenchPanelView instance, ListBarWidget value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView::listBar = value;
  }-*/;

  private native static void _1135152903__879292651_bus(SecurityEntryPoint instance, ClientMessageBus value) /*-{
    instance.@org.uberfire.security.client.SecurityEntryPoint::bus = value;
  }-*/;

  private native static void _$1757102468__1116818801_workbenchPartCloseEvent(PlaceManagerImpl instance, Event<ClosePlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartCloseEvent = value;
  }-*/;

  private native static void _2052955140__$652658075_iocManager(ActivityBeansCache instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::iocManager = value;
  }-*/;

  private native static void _$1705636724__1116818801_workbenchPartDroppedEvent(CompassDropController instance, Event<DropPlaceEvent> value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::workbenchPartDroppedEvent = value;
  }-*/;

  private native static void _711644943__597466346_identity(PartContextMenusView instance, User value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusView::identity = value;
  }-*/;

  private native static void _$1397438695__$262319993_panelManager(AbstractWorkbenchPanelView instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelView::panelManager = value;
  }-*/;

  private native static void _$1705636724__153624969_dndManager(CompassDropController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::dndManager = value;
  }-*/;

  private native static void _1496760654__136504311_navigation(TransitionAnchorFactoryProvider instance, Navigation value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.TransitionAnchorFactoryProvider::navigation = value;
  }-*/;

  private native static void _$1757102468__1116818801_workbenchPartBeforeCloseEvent(PlaceManagerImpl instance, Event<BeforeClosePlaceEvent> value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartBeforeCloseEvent = value;
  }-*/;

  private native static void _$389641401__$652658075_iocManager(PanelManagerImpl instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::iocManager = value;
  }-*/;

  private native static void _136504311__$2056551207_stateChangeEvent(Navigation instance, StateChange value) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::stateChangeEvent = value;
  }-*/;

  private native static void _$1462522111__1730751009_uberfireContext(Workbench instance, UberfireContext value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::uberfireContext = value;
  }-*/;

  private native static void _$662927178__$2073863603_runtimePluginsService(JSEntryPoint instance, RuntimePluginsServiceProxy value) /*-{
    instance.@org.uberfire.client.JSEntryPoint::runtimePluginsService = value;
  }-*/;

  private native static void _$1934524921__$746838216_notificationManager(ActivityLifecycleErrorHandler instance, NotificationPopupsManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityLifecycleErrorHandler::notificationManager = value;
  }-*/;

  private native static void _1084732347__314455785_loginTransition(SecurityRolesConstraintPage instance, TransitionToRole<LoginPage> value) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl.SecurityRolesConstraintPage::loginTransition = value;
  }-*/;

  private native static void _$389641401__$1887041540_beanFactory(PanelManagerImpl instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::beanFactory = value;
  }-*/;

  private native static void _$662927178__$1462522111_workbench(JSEntryPoint instance, Workbench value) /*-{
    instance.@org.uberfire.client.JSEntryPoint::workbench = value;
  }-*/;

  private native static void _439167523__1882392308_realPresenter(ActivityNotFoundPresenterActivity instance, org.uberfire.client.screens.ActivityNotFoundPresenter value) /*-{
    instance.@org.uberfire.client.screens.ActivityNotFoundPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _684448251__$906533316_placeManager(JSNativePerspective instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::placeManager = value;
  }-*/;

  private native static void _$292735039__1201173960_view(WorkbenchMenuBarPresenter instance, org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::view = value;
  }-*/;

  private native static void _73328378__$652658075_manager(ShowcaseEntryPoint instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::manager = value;
  }-*/;

  private native static void _684448251__$262319993_panelManager(JSNativePerspective instance, PanelManager value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::panelManager = value;
  }-*/;

  private native static void _$924432381__597466346_identity(ListBarWidget instance, User value) /*-{
    instance.@org.uberfire.client.workbench.widgets.listbar.ListBarWidget::identity = value;
  }-*/;

  private native static void _$1300398733__$652658075_beanManager(DisposerProvider instance, SyncBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _1730935432__2052955140_activityBeansCache(ActivityManagerImpl instance, ActivityBeansCache value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::activityBeansCache = value;
  }-*/;

  private native static void _40974972__$1426067475_view(WorkbenchToolBarPresenter instance, org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::view = value;
  }-*/;

  private native static void _$1462522111__$652658075_iocManager(Workbench instance, SyncBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::iocManager = value;
  }-*/;

  private native static void _102087148__$1574799830_authzManager(WorkbenchMenuBarView instance, AuthorizationManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView::authzManager = value;
  }-*/;

  private native static void _$348507737__$304677073_wbServices(PerspectiveManagerImpl instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.mvp.PerspectiveManagerImpl::wbServices = value;
  }-*/;

  private native static void _1047951015__$695339145_mapper(PlaceHistoryHandler instance, PlaceRequestHistoryMapper value) /*-{
    instance.@org.uberfire.client.mvp.PlaceHistoryHandler::mapper = value;
  }-*/;

  private native static void _$690457926__$304677073_wbServices(AbstractSplashScreenActivity instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.mvp.AbstractSplashScreenActivity::wbServices = value;
  }-*/;

  private native static void _40974972__$906533316_placeManager(WorkbenchToolBarPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::placeManager = value;
  }-*/;

  private native static void _1698844050__$906533316_placeManager(SplitLayoutPanelView instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.SplitLayoutPanelView::placeManager = value;
  }-*/;

  private native static void _618642634__$1887041540_factory(AbstractDockingWorkbenchPanelView instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::factory = value;
  }-*/;

  private native static void _1150956601__1116818801_moodEvent(MoodScreen instance, Event<Mood> value) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::moodEvent = value;
  }-*/;

  private native static void _$1705636724__$262319993_panelManager(CompassDropController instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::panelManager = value;
  }-*/;

  private native static void _684448251__$304677073_wbServices(JSNativePerspective instance, WorkbenchServicesProxy value) /*-{
    instance.@org.uberfire.client.perspective.JSNativePerspective::wbServices = value;
  }-*/;

  public native static EventBus _$1757102468_produceEventBus(PlaceManagerImpl instance) /*-{
    return instance.@org.uberfire.client.mvp.PlaceManagerImpl::produceEventBus()();
  }-*/;

  public native static SessionInfo _$1462522111_currentSession(Workbench instance) /*-{
    return instance.@org.uberfire.client.workbench.Workbench::currentSession()();
  }-*/;

  public native static User _663569186_produceActiveUser(BasicUserCacheImpl instance) /*-{
    return instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::produceActiveUser()();
  }-*/;

  public native static void _35605411_init(WorkbenchPartPresenterDefault instance) /*-{
    instance.@org.uberfire.client.workbench.pmgr.nswe.part.WorkbenchPartPresenterDefault::init()();
  }-*/;

  public native static void _$389641401_onSelectPlaceEvent_SelectPlaceEvent(PanelManagerImpl instance, SelectPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onSelectPlaceEvent(Lorg/uberfire/client/workbench/events/SelectPlaceEvent;)(a0);
  }-*/;

  public native static void _$389641401_onDropPlaceEvent_DropPlaceEvent(PanelManagerImpl instance, DropPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onDropPlaceEvent(Lorg/uberfire/client/workbench/events/DropPlaceEvent;)(a0);
  }-*/;

  public native static void _$389641401_onChangeTitleWidgetEvent_ChangeTitleWidgetEvent(PanelManagerImpl instance, ChangeTitleWidgetEvent a0) /*-{
    instance.@org.uberfire.client.workbench.PanelManagerImpl::onChangeTitleWidgetEvent(Lorg/uberfire/client/workbench/events/ChangeTitleWidgetEvent;)(a0);
  }-*/;

  public native static void _136504311_init(Navigation instance) /*-{
    instance.@org.jboss.errai.ui.nav.client.local.Navigation::init()();
  }-*/;

  public native static void _663569186_maybeLoadStoredCache(BasicUserCacheImpl instance) /*-{
    instance.@org.jboss.errai.security.client.local.context.BasicUserCacheImpl::maybeLoadStoredCache()();
  }-*/;

  public native static void _378913974_setup(SecurityContextImpl instance) /*-{
    instance.@org.jboss.errai.security.client.local.context.SecurityContextImpl::setup()();
  }-*/;

  public native static void _1934862923_init(WorkbenchLayoutImpl instance) /*-{
    instance.@org.uberfire.client.workbench.WorkbenchLayoutImpl::init()();
  }-*/;

  public native static void _2052955140_init(ActivityBeansCache instance) /*-{
    instance.@org.uberfire.client.mvp.ActivityBeansCache::init()();
  }-*/;

  public native static void _$1757102468_onWorkbenchPartOnFocus_PlaceGainFocusEvent(PlaceManagerImpl instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartLostFocus_PlaceLostFocusEvent(PlaceManagerImpl instance, PlaceLostFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartLostFocus(Lorg/uberfire/client/workbench/events/PlaceLostFocusEvent;)(a0);
  }-*/;

  public native static void _322507922_setInstance(SecurityContextHoldingSingleton instance) /*-{
    instance.@org.jboss.errai.security.client.local.nav.SecurityContextHoldingSingleton::setInstance()();
  }-*/;

  public native static void _7760253_onPerspectiveChange_PerspectiveChange(PespectiveContextMenusPresenter instance, PerspectiveChange a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PespectiveContextMenusPresenter::onPerspectiveChange(Lorg/uberfire/client/workbench/events/PerspectiveChange;)(a0);
  }-*/;

  public native static void _73328378_setupMenu_ApplicationReadyEvent(ShowcaseEntryPoint instance, ApplicationReadyEvent a0) /*-{
    instance.@org.uberfire.client.ShowcaseEntryPoint::setupMenu(Lorg/uberfire/client/workbench/events/ApplicationReadyEvent;)(a0);
  }-*/;

  public native static void _618642634_setupDockingPanel(AbstractDockingWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::setupDockingPanel()();
  }-*/;

  public native static void _$821728441_setupMultiPartPanel(AbstractMultiPartWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractMultiPartWorkbenchPanelView::setupMultiPartPanel()();
  }-*/;

  public native static void _618642634_tearDownDockingPanel(AbstractDockingWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractDockingWorkbenchPanelView::tearDownDockingPanel()();
  }-*/;

  public native static void _1346204971_setup(AbstractSimpleWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractSimpleWorkbenchPanelView::setup()();
  }-*/;

  public native static void _$896357979_postConstruct(StaticWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.StaticWorkbenchPanelView::postConstruct()();
  }-*/;

  public native static void _253255348_init(AbstractWorkbenchPanelPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.panels.impl.AbstractWorkbenchPanelPresenter::init()();
  }-*/;

  public native static void _$1340452412_onNewSplash_NewSplashScreenActiveEvent(MenuSplashList instance, NewSplashScreenActiveEvent a0) /*-{
    instance.@org.uberfire.client.menu.MenuSplashList::onNewSplash(Lorg/uberfire/client/workbench/events/NewSplashScreenActiveEvent;)(a0);
  }-*/;

  public native static void _$1462522111_startIfNotBlocked(Workbench instance) /*-{
    instance.@org.uberfire.client.workbench.Workbench::startIfNotBlocked()();
  }-*/;

  public native static void _$1462522111_earlyInit(Workbench instance) /*-{
    instance.@org.uberfire.client.workbench.Workbench::earlyInit()();
  }-*/;

  public native static void _$464592863_postConstruct(HomeScreen instance) /*-{
    instance.@org.uberfire.client.screens.HomeScreen::postConstruct()();
  }-*/;

  public native static void _$464592863_preDestroy(HomeScreen instance) /*-{
    instance.@org.uberfire.client.screens.HomeScreen::preDestroy()();
  }-*/;

  public native static void _$274999170_onWorkbenchPartOnFocus_PlaceGainFocusEvent(PartContextMenusPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.PartContextMenusPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartClose_ClosePlaceEvent(WorkbenchToolBarPresenter instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartClose(Lorg/uberfire/client/workbench/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartOnFocus_PlaceGainFocusEvent(WorkbenchToolBarPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _1150956601_onKeyDown_KeyDownEvent(MoodScreen instance, KeyDownEvent a0) /*-{
    instance.@org.uberfire.client.screens.MoodScreen::onKeyDown(Lcom/google/gwt/event/dom/client/KeyDownEvent;)(a0);
  }-*/;

  public native static void _$690457926_initialize(AbstractSplashScreenActivity instance) /*-{
    instance.@org.uberfire.client.mvp.AbstractSplashScreenActivity::initialize()();
  }-*/;

  public native static void _$1304194947_onResourceRenamed_ResourceRenamedEvent(ObservablePathImpl instance, ResourceRenamedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceRenamed(Lorg/uberfire/workbench/events/ResourceRenamedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceDeleted_ResourceDeletedEvent(ObservablePathImpl instance, ResourceDeletedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceDeleted(Lorg/uberfire/workbench/events/ResourceDeletedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceUpdated_ResourceUpdatedEvent(ObservablePathImpl instance, ResourceUpdatedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceUpdated(Lorg/uberfire/workbench/events/ResourceUpdatedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceCopied_ResourceCopiedEvent(ObservablePathImpl instance, ResourceCopiedEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceCopied(Lorg/uberfire/workbench/events/ResourceCopiedEvent;)(a0);
  }-*/;

  public native static void _$1304194947_onResourceBatchEvent_ResourceBatchChangesEvent(ObservablePathImpl instance, ResourceBatchChangesEvent a0) /*-{
    instance.@org.uberfire.backend.vfs.impl.ObservablePathImpl::onResourceBatchEvent(Lorg/uberfire/workbench/events/ResourceBatchChangesEvent;)(a0);
  }-*/;

  // The main IOC bootstrap method.
  public SimpleInjectionContext bootstrapContainer() {
    declareBeans_0();
    declareBeans_1();
    return injContext;
  }
}