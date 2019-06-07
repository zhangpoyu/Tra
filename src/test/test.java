package test;

import come.image.processing.core.CharsRecognise;
import come.image.processing.core.PlateDetect;
import org.bytedeco.javacpp.opencv_core;
import org.junit.Test;
import java.util.Vector;
import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

public class test {
    @Test
    public void testCharsRecognise() {
        String AbsolutePath = "res/image/test_image/1/A1R272.jpg";
       Mat src = imread(AbsolutePath);
        String result = null;
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<opencv_core.Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognise cr = new CharsRecognise();

            for (int i = 0; i < matVector.size(); ++i) {
                result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }else
        {
            System.out.println("wrong");
        }
    }
}
