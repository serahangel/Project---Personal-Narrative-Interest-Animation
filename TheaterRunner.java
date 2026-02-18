import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
 ImageFilter[][] Hobbiesimages = {
      // row 0 --> culture
      { new ImageFilter("images-(1).jpg"), new ImageFilter("images.jpg") },
      // row 1 --> sports (no second image so put null)
      { new ImageFilter("wriing.jpg"), new ImageFilter("poetry.png") },
      // row 2 --> favorite beverages
      { new ImageFilter("reading1.jpg"), new ImageFilter("reading.jpg") },
    };

    //2D array for travel goals images
ImageFilter[][] Travelimages = {
      // row 0 --> culture
      { new ImageFilter("greece.png"), new ImageFilter("greece1.png") },
      // row 1 --> sports (no second image so put null)
      { new ImageFilter("spain.jpg"), new ImageFilter("spain1.jpg") },
      // row 2 --> favorite beverages
      { new ImageFilter("france.jpg"), new ImageFilter("france1.jpg") },
    };

    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(Hobbiesimages);
    SceneTwo scene2 = new SceneTwo(Travelimages);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}