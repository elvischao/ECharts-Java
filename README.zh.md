<div align="center">
    <img src="assets/imgs/logo.png" alt="logo" width=150 height=150 />
</div>
<h1 align="center">ECharts Java</h1>
<p align="center">
    <em>"We bring better visualization into Java with ECharts"</em>
</p>
<p align="center">
    <a href="https://github.com/ECharts-Java/ECharts-Java/actions">
        <img src="https://github.com/ECharts-Java/ECharts-Java/actions/workflows/maven.yml/badge.svg" alt="Github Actions Status">
    </a>
    <a href="https://github.com/pyecharts/pyecharts/pulls">
        <img src="https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat" alt="Contributions welcome">
    </a>
    <!-- <a href="https://codecov.io/gh/ECharts-Java/ECharts-Java">
        <img src="https://codecov.io/gh/ECharts-Java/ECharts-Java/branch/dev/graph/badge.svg?token=V1N6AQ0EA1"/>
    </a> -->
    <a href="https://opensource.org/licenses/Apache-2.0">
        <img src="https://img.shields.io/badge/License-Apache_2.0-blue.svg" alt="License">
    </a>
    <a href="https://maven-badges.herokuapp.com/maven-central/org.icepear.echarts/echarts-java">
        <img src="https://maven-badges.herokuapp.com/maven-central/org.icepear.echarts/echarts-java/badge.svg" alt="Maven Central">
    </a>
</p>

[English README](README.md)

## 📙 简介

ECharts Java是一款基于[Apache ECharts](https://echarts.apache.org/en/index.html)的，简易但全面的数据可视化库。

论简易性，ECharts Java重新设计了一系列和绘图有关的接口，使得绘图过程更加符合直觉和常理。同时，由于Apache ECharts的接口过于复杂和繁琐，我们在ECharts Java的图表API中简化了部分原本的接口设计。

论全面，ECharts Java保留了Apache ECharts“一切皆Option”的设计理念。因此，除了重新设计的图表APIs以外，我们还保留了自定义Option对象的方法。用户可以从零开始，按照ECharts的Option文档，自定义任何ECharts支持的Option。除此以外，我们还使用链式方法调用等方式，使得Java开发者在构建Option的过程中更加方便。


## 🌠 特性

- 简单、整洁、高度组织化的API接口，支持链式调用
- 完整保存Apache ECharts的功能
- 快速集成至当前流行的Web框架
- 灵活的导出格式，支持HTML，PNG和JSON
- 完整、详细的文档和示例库

## 🔬 安装


Maven项目:
```xml
// pom.xml
<dependency>
  <groupId>org.icepear.echarts</groupId>
  <artifactId>echarts-java</artifactId>
  <version>1.0.2</version>
</dependency>
```

Gradle项目:
```
implementation 'org.icepear.echarts:echarts-java:1.0.2'
```

如果你使用的是其他项目，请参阅[这里](https://search.maven.org/artifact/org.icepear.echarts/echarts-java/1.0.2/jar)。

## 🔭 使用

### 生成HTML和下载图片

```java
public static void main(String[] args) {
    // All methods in EChart Java supports method chaining
    Bar bar = new Bar()
            .setTooltip(new Tooltip().setTrigger("axis")
                    .setAxisPointer(new TooltipAxisPointer().setType("shadow")))
            .setLegend()
            .addXAxis()
            .addYAxis(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" })
            .addSeries(createSeries("Direct", new Number[] { 320, 302, 301, 334, 390, 330, 320 }))
            .addSeries(createSeries("Mail Ad", new Number[] { 120, 132, 101, 134, 90, 230, 210 }))
            .addSeries(createSeries("Affiliate Ad", new Number[] { 220, 182, 191, 234, 290, 330, 310 }))
            .addSeries(createSeries("Video Ad", new Number[] { 150, 212, 201, 154, 190, 330, 410 }))
            .addSeries(createSeries("Search Engine", new Number[] { 820, 832, 901, 934, 1290, 1330, 1320 }));
    Engine engine = new Engine();
    // The render method will generate our EChart into a HTML file saved locally in the current directory.
    // The name of the HTML can also be set by the first parameter of the function.
    engine.render("index.html", bar);
}
```
<img src="assets/imgs/multibar-render.gif" alt="multi-bar-render" style="width:85%;" />

### 生成Option对象和对应JSON结构

```java
public static void main(String[] args) {
    Line lineChart = new Line()
                .addXAxis(new CategoryAxis()
                        .setData(new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" })
                        .setBoundaryGap(false))
                .addYAxis()
                .addSeries(new LineSeries()
                        .setData(new Number[] { 820, 932, 901, 934, 1290, 1330, 1320 })
                        .setAreaStyle(new LineAreaStyle()));
    Engine engine = new Engine();
    // It is recommended that you can  get the serialized version of Option in the representation of JSON, which can be used directly in the template or in the RESTful APIs.
    String jsonStr = engine.renderJsonOption(lineChart);
}
```

生成的JSON对象如下：

```json
{
  "xAxis": [
    {
      "type": "category",
      "data": ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
      "boundaryGap": false
    }
  ],
  "yAxis": [{ "type": "value" }],
  "series": [
    {
      "type": "line",
      "data": [820, 932, 901, 934, 1290, 1330, 1320],
      "areaStyle": {}
    }
  ]
}
```

### 集成至Spring Boot应用

<img src="assets/imgs/line-renderHtml.gif" alt="spring-boot-integration" style="width:75%;" />

详细内容请参阅，[文档](https://echarts.icepear.org/#/zh-cn/) ，[代码仓库](https://github.com/incandescentxxc/ECharts-Java-Examples)。

## 🎇 示例

<p float="center">
  <img src="assets/imgs/stacked-line.jpg" width="32%" />
  <img src="assets/imgs/stacked-area.jpg" width="32%" /> 
  <img src="assets/imgs/multiple-series-bar.jpg" width="32%" />
  <img src="assets/imgs/horizontal-stacked-bar.jpg" width="32%" /> 
  <img src="assets/imgs/basic-scatter.jpg" width="32%" />
  <!-- <img src="assets/imgs/basic-boxplot.jpg" width="32%" />  -->
  <img src="assets/imgs/basic-candlestick.jpg" width="32%" /> 
  <img src="assets/imgs/basic-heatmap.jpg" width="32%" /> 
  <img src="assets/imgs/basic-polar-line.jpg" width="32%" /> 
  <img src="assets/imgs/tangential-polar-bar.jpg" width="32%" /> 
  <img src="assets/imgs/basic-polar-scatter.jpg" width="32%" /> 
  <img src="assets/imgs/basic-radar.jpg" width="32%" /> 
  <img src="assets/imgs/basic-parallel.jpg" width="32%" />
  <img src="assets/imgs/basic-theme-river.jpg" width="32%" />
  <img src="assets/imgs/basic-rose.jpg" width="32%" />
  <img src="assets/imgs/nested-pie.jpg" width="32%" />
  <img src="assets/imgs/circular-layout-graph.jpg" width="32%" />
  <img src="assets/imgs/hide-overlapped-label-graph.jpg" width="32%" />
  <img src="assets/imgs/basic-sankey.jpg" width="32%" />
  <img src="assets/imgs/basic-funnel.jpg" width="32%" />
  <img src="assets/imgs/basic-sunburst.jpg" width="32%" />
  <img src="assets/imgs/animation-gauge.jpg" width="32%" /> 
</p>

## 💡 作者
- [@IcePear-Jzx](https://github.com/IcePear-Jzx)
- [@incandescentxxc](https://github.com/incandescentxxc)

欢迎大家积极提issue，fork，和其他贡献！

## 💌 鸣谢
- This project is inspired by the Homework 6 of the course [Principles of Software Construction Objects, Design, and Concurrency](https://cmu-17-214.github.io/f2021/), Fall 2021, at [Carnegie Mellon University](https://www.cmu.edu/). We sincerely thank [Christian](https://www.cs.cmu.edu/~ckaestne/) and [Vincent](https://vhellendoorn.github.io/) for the wonderful course.

- This project is also inspired by the [pyecharts](https://github.com/pyecharts/pyecharts) and [go-echarts](https://github.com/go-echarts/go-echarts), which are the ECharts siblings in Python and Go languages.

## 🎈 证书

ECharts Java is available under the [Apache License 2.0](LICENSE).