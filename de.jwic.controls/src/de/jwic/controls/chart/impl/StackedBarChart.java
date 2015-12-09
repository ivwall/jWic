package de.jwic.controls.chart.impl;

import de.jwic.base.IControlContainer;
import de.jwic.controls.chart.api.Chart;
import de.jwic.controls.chart.api.ChartType;
import de.jwic.controls.chart.api.ValueListDatasetModel;

/**
 * 
 * @author Karolina Marek (karolina-marek.eu)
 *
 * @date 08.12.2015
 */
public class StackedBarChart extends
		Chart<ValueListDatasetModel, BarChartConfiguration> {

	/**
	 * 
	 * @param container
	 * @param name
	 * @param model
	 */
	public StackedBarChart(IControlContainer container, String name,
			ValueListDatasetModel model) {
		super(container, name, ChartType.STACKED_BAR, model);
		setConfiguration(new BarChartConfiguration());

	}

}
