package org.icepear.echarts.bar;

import static org.junit.Assert.assertEquals;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.icepear.echarts.component.BarSeries;
import org.icepear.echarts.component.CategoryAxis;
import org.icepear.echarts.component.Grid;
import org.icepear.echarts.component.Legend;
import org.icepear.echarts.component.Option;
import org.icepear.echarts.component.Title;
import org.icepear.echarts.component.Tooltip;
import org.icepear.echarts.component.TooltipAxisPointer;
import org.icepear.echarts.component.ValueAxis;
import org.icepear.echarts.origin.util.SeriesOption;
import org.icepear.echarts.serializer.EChartSerializer;
import org.junit.Test;

public class WorldPopulationTest {

    @Test
    public void testWorldPopulation() {
        Title title = new Title()
                .setText("World Population");
        Tooltip tooltip = new Tooltip()
                .setTrigger("axis")
                .setAxisPointer(new TooltipAxisPointer()
                        .setType("shadow"));
        Legend legend = new Legend();
        Grid grid = new Grid()
                .setLeft("3%")
                .setRight("4%")
                .setBottom(("3%"))
                .setContainLabel(true);
        ValueAxis xAxis = new ValueAxis()
                .setType("value")
                .setBoundaryGap(new Number[] {0, 0.01});
        CategoryAxis yAxis = new CategoryAxis()
                .setType("category")
                .setData(new String[] {"Brazil", "Indonesia", "USA", "India", "China", "World"});
        BarSeries series2011 = new BarSeries()
                .setName("2011")
                .setType("bar")
                .setData(Arrays.asList(18203, 23489, 29034, 104970, 131744, 630230));
        BarSeries series2012 = new BarSeries()
                .setName("2012")
                .setType("bar")
                .setData(Arrays.asList(19325, 23438, 31000, 121594, 134141, 681807));
        Option option = new Option()
                .setTitle(title)
                .setTooltip(tooltip)
                .setLegend(legend)
                .setGrid(grid)
                .setXAxis(xAxis)
                .setYAxis(yAxis)
                .setSeries(new SeriesOption[] {series2011, series2012});

        Reader reader = new InputStreamReader(
                this.getClass().getResourceAsStream("/bar/world-population.json"));
        JsonElement expected = JsonParser.parseReader(reader);
        JsonElement actual = EChartSerializer.toJsonTree(option);
        assertEquals(expected, actual);

        // System.out.println(EChartSerializer.toJson(option));
    }

}