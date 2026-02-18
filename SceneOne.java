import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** Instance Variables */
  private ImageFilter[][] images;
  public static final int SAMPLE_RATE = 44100; // for audioClip
  /** Constructor */
  public SceneOne(ImageFilter[][] images) {
    this.images = images;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    drawfirstScene();
    drawViolinImages();
    drawWritingImages();
    drawReadingImages();
  }

  private void applyDefaultSize(ImageFilter img, int x, int y) {
    drawImage(img, x, y, 400, 400, 0);
    }
  
  /**
   * Helper method to apply text titles
   */
  private void applyDefaultTextStyle() {
    setTextStyle(Font.SANS, FontStyle.BOLD);
    }
   
    public void drawfirstScene() {
      playBackgroundTrack(18); //plays audio
      clear("pink"); //clears the screen to pink 
      setTextHeight(50); //sets text height to 50
      applyDefaultTextStyle();  //Default TextStyle
      drawText("My Hobbies", 85, 215);  
      pause(2); //pauses for 2 seconds
    }
   
  /**
   * Draws all images in first row of images using pixelate filter
   */
      public void drawViolinImages() {
    for (ImageFilter img : images[0]) {
      clear("white");
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
      
      img.pixelate(10);
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
    }
  }
  
  /**
   * Draws all images in first row of images using keepColor("green")
   */
  public void drawWritingImages() {
    for (ImageFilter img : images[1]) {
      clear("white");

      if (img != null) {
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);
        
        img.applyBlur();
        
        drawImage(img, 0, 0, 400, 400, 0);
        pause(1);
      }
      
    }
  }
  
  /**
   * Draws all images in first row of images using keepColor("blue")
   */
  public void drawReadingImages() {
    for (ImageFilter img : images[2]) {
      clear("white");

      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
      
      img.adjustContrast(5);
      
      drawImage(img, 0, 0, 400, 400, 0);
      pause(1);
    }
  }

    /**
   * PLays my audio file
   */
// background music for the images
    public void playBackgroundTrack(int numSeconds) {
    double[] audio = SoundLoader.read("fresh-457883-(1).wav");
    // just play the first numSeconds
    double[] clip = createClip(audio, 0, numSeconds);
    playSound(clip);
  }

  /**
   * Creates an audio clip from a given start time to a end time
   */
  public static double[] createClip(double[] sound, int start, int end) {
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;
    
    double[] newSound = new double[endIndex - startIndex];

    int index = 0;
    
    while (startIndex < endIndex) {
      newSound[index] = sound[startIndex];
      startIndex++;
      index++;
    }

    return newSound;
  }
}