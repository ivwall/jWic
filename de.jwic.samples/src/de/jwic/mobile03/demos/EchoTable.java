package de.jwic.mobile03.demos;

import de.jwic.mobile03.MobileDemoModule;
import de.jwic.base.Control;
import de.jwic.base.ControlContainer;
import de.jwic.base.IControlContainer;

// from de.jwic.demo.tbv.BasicTBVDemo
import de.jwic.base.ImageRef;
import de.jwic.controls.Button;
import de.jwic.controls.ToolBar;
import de.jwic.controls.ToolBarGroup;
import de.jwic.controls.actions.Action;
import de.jwic.controls.actions.IAction;
import de.jwic.controls.dialogs.DialogAdapter;
import de.jwic.controls.dialogs.DialogEvent;
import de.jwic.controls.menu.Menu;
import de.jwic.controls.tableviewer.TableColumn;
import de.jwic.controls.tableviewer.TableModel;
import de.jwic.controls.tableviewer.TableModelAdapter;
import de.jwic.controls.tableviewer.TableModelEvent;
import de.jwic.controls.tableviewer.TableViewer;
import de.jwic.demo.ImageLibrary;
import de.jwic.events.ElementSelectedEvent;
import de.jwic.events.ElementSelectedListener;
import de.jwic.events.SelectionEvent;
import de.jwic.events.SelectionListener;

import de.jwic.mobile03.demos.tbv.DemoTaskContentProvider;

public class EchoTable extends MobileDemoModule {

	public EchoTable() {
		super("Echo Table");
	}
	
	private TableViewer viewer;
	private DemoTaskContentProvider contentProvider;

	private IAction flagRed;
	private IAction flagBlue;
	private IAction deleteTask;

	
	
	
	
	@Override
	public Control createPage(IControlContainer controlContainer) {
		final ControlContainer container = new ControlContainer(controlContainer, "container");

		/*****
		final TableViewer table = new TableViewer(container, "table1");
		DemoTaskContentProvider contentProvider = new DemoTaskContentProvider(createDemoData());
		table.setContentProvider(contentProvider);
		table.setTableLabelProvider(new LabelProvider());
		table.setTableRenderer(new MobileTableRenderer());

		TableModel model = table.getModel();

		model.setSelectionMode(TableModel.SELECTION_SINGLE);
		model.setColumnBtnText("Columns Button");
		createColumns(table);
		*****/

		return container;
	}
	
	
}