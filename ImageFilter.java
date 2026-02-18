 public void applyBlur() {
    Pixel[][] pixels = getImagePixels();

    // traverse starting at (1,1) bc using pixel to the top left
    // need to stop one less so - 1 in for loop condition
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        // call methods to calculate RBG weights
        int weightedRed = calcWeightedRed(pixels, row, col);
        int weightedGreen = calcWeightedGreen(pixels, row, col);
        int weightedBlue = calcWeightedBlue(pixels, row, col);

        // update the RBG with weighted values
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(weightedRed);
        currentPixel.setGreen(weightedGreen);
        currentPixel.setBlue(weightedBlue);
      }
    } 
  }

  /*
   * Returns a weighted red average of the pixels around the specified row and col
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }
  
public void grayFilter() {
  Pixel[][] pixels = getImagePixels();  //gets 2D array of all pixels in image


for (int row = 0; row < pixels.length; row++) {  //loops through all rows
for (int col = 0; col < pixels[0].length; col++) {  //loops through all columns
  Pixel p = pixels[row][col];  //gets the current pixel

  int gray = (p.getRed() + p.getGreen() + p.getBlue()) / 3;   //calculates the average of red, green, and blue

  //Sets all RGB values to gray
  p.setRed(gray); 
  p.setGreen(gray);
  p.setBlue(gray);
}
}
}
  
}