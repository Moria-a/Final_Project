package utilities;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MonteScreenRecorder extends ScreenRecorder {
    public static ScreenRecorder screenRecorder;
    public String name;

    public MonteScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!this.movieFolder.exists()) {
            this.movieFolder.mkdirs();
        } else if (!this.movieFolder.isDirectory()) {
            throw new IOException("\"" + this.movieFolder + "\" is not a directory.");
        }

        System.out.println("Recorded Screen Cast File is Now Created");
        return new File(this.movieFolder, this.name + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startRecord(String methodName) throws Exception {
        File file = new File("./test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        Rectangle captureSize = new Rectangle(0, 0, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new MonteScreenRecorder(gc, captureSize, new Format(new Object[]{VideoFormatKeys.MediaTypeKey, MediaType.FILE, VideoFormatKeys.MimeTypeKey, "video/avi"}), new Format(new Object[]{VideoFormatKeys.MediaTypeKey, MediaType.VIDEO, VideoFormatKeys.EncodingKey, "tscc", VideoFormatKeys.CompressorNameKey, "tscc", VideoFormatKeys.DepthKey, 24, VideoFormatKeys.FrameRateKey, Rational.valueOf(15.0), VideoFormatKeys.QualityKey, 1.0F, VideoFormatKeys.KeyFrameIntervalKey, 900}), new Format(new Object[]{VideoFormatKeys.MediaTypeKey, MediaType.VIDEO, VideoFormatKeys.EncodingKey, "black", VideoFormatKeys.FrameRateKey, Rational.valueOf(30.0)}), (Format)null, file, methodName);
        screenRecorder.start();
    }

    public static void stopRecord() throws Exception {
        screenRecorder.stop();
        System.out.println("Recorded Screen Cast File Stop Recording");
    }
}
