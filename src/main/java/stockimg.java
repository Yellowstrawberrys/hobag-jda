import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class stockimg {
    public stockimg(String title, int type){
        // Create new chart
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        long uptime = rb.getUptime();
        double[] arr = new double[0];
        if(type == 1)
            arr = main.stk.prices_jk.stream().mapToDouble(Double::doubleValue).toArray();
        else if(type == 2)
            arr = main.stk.prices_jk_cm.stream().mapToDouble(Double::doubleValue).toArray();
        else if(type == 3)
            arr = main.stk.prices_zeone.stream().mapToDouble(Double::doubleValue).toArray();
        else if(type == 4)
            arr = main.stk.prices_zeonh.stream().mapToDouble(Double::doubleValue).toArray();
        double d = standardDeviation(arr, 0);
        if(d > 0)
            addCandel(uptime, 1d, d, 0.1d, 1d);
        else
            addCandel(uptime, 1d, 0.1d, d, 1d);
        final JFreeChart candlestickChart = createChart(title);
        // Create new chart panel
        try {
            BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();

            g2.setRenderingHint(JFreeChart.KEY_SUPPRESS_SHADOW_GENERATION, true);
            Rectangle r = new Rectangle(0, 0, 600, 400);
            candlestickChart.draw(g2, r);
            File f = new File("./stock.png");
            if(f.exists())
                f.delete();

            BufferedImage chartImage = candlestickChart.createBufferedImage( 600, 400, null);
            ImageIO.write( chartImage, "png", f );
        } catch (IOException ex) {

        }
    }
    public static void start(){

    }
    private OHLCSeries ohlcSeries;
    private JFreeChart createChart(String chartTitle) {
        /**
         * Creating candlestick subplot
         */
        // Create OHLCSeriesCollection as a price dataset for candlestick chart
        OHLCSeriesCollection candlestickDataset = new OHLCSeriesCollection();
        ohlcSeries = new OHLCSeries("가격");
        candlestickDataset.addSeries(ohlcSeries);
        // Create candlestick chart priceAxis
        NumberAxis priceAxis = new NumberAxis("가격");
        priceAxis.setAutoRangeIncludesZero(false);
        // Create candlestick chart renderer
        CandlestickRenderer candlestickRenderer = new CandlestickRenderer(CandlestickRenderer.WIDTHMETHOD_AVERAGE,
                false, new CustomHighLowItemLabelGenerator(new SimpleDateFormat("kk:mm"), new DecimalFormat("0.000")));
        // Create candlestickSubplot
        XYPlot candlestickSubplot = new XYPlot(candlestickDataset, null, priceAxis, candlestickRenderer);
        candlestickSubplot.setBackgroundPaint(Color.white);

        /**
         * Create chart main plot with two subplots (candlestickSubplot,
         * volumeSubplot) and one common dateAxis
         */
        // Creating charts common dateAxis
        DateAxis dateAxis = new DateAxis("시간");
        dateAxis.setDateFormatOverride(new SimpleDateFormat("kk:mm"));
        // reduce the default left/right margin from 0.05 to 0.02
        dateAxis.setLowerMargin(0.02);
        dateAxis.setUpperMargin(0.02);
        // Create mainPlot
        CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(dateAxis);
        mainPlot.setGap(10.0);
        mainPlot.add(candlestickSubplot, 3);
        mainPlot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart(chartTitle, JFreeChart.DEFAULT_TITLE_FONT, mainPlot, true);
        chart.removeLegend();
        return chart;
    }
    public void addCandel(long time, double o, double h, double l, double c) {
        try {
            // Add bar to the data. Let's repeat the same bar
            FixedMillisecond t = new FixedMillisecond(Long.parseLong(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(time),
                    TimeUnit.MILLISECONDS.toSeconds(time) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))
            )));
            ohlcSeries.add(t, o, h, l, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static double mean(double[] array) {  // 산술 평균 구하기
        double sum = 0.0;

        for (int i = 0; i < array.length; i++)
            sum += array[i];

        return sum / array.length;
    }


    public static double standardDeviation(double[] array, int option) {
        if (array.length < 2) return Double.NaN;

        double sum = 0.0;
        double sd = 0.0;
        double diff;
        double meanValue = mean(array);

        for (int i = 0; i < array.length; i++) {
            diff = array[i] - meanValue;
            sum += diff * diff;
        }
        sd = Math.sqrt(sum / (array.length - option));

        return sd;
    }
}
