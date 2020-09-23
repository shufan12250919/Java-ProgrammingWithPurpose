/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] blur = new int[3][3];
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                blur[i][0] = 1;
                blur[i][1] = 2;
                blur[i][2] = 1;
            }
        }
        blur[1][0] = 2;
        blur[1][1] = 4;
        blur[1][2] = 2;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double Rsum = 0;
                double Gsum = 0;
                double Bsum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        int targeti = i - (1 - k);
                        int targetj = j - (1 - h);

                        if (targeti < 0) {
                            targeti += width;
                        }
                        else if (targeti >= width) {
                            targeti -= width;
                        }
                        if (targetj < 0) {
                            targetj += height;
                        }
                        else if (targetj >= height) {
                            targetj -= height;
                        }
                        Rsum += blur[k][h] * picture.get(targeti, targetj).getRed() / 16.0;
                        Gsum += blur[k][h] * picture.get(targeti, targetj).getGreen() / 16.0;
                        Bsum += blur[k][h] * picture.get(targeti, targetj).getBlue() / 16.0;
                    }

                }
                int Rsumi = clamp((int) Math.round(Rsum));
                int Gsumi = clamp((int) Math.round(Gsum));
                int Bsumi = clamp((int) Math.round(Bsum));
                Color color = new Color(Rsumi, Gsumi, Bsumi);
                target.set(i, j, color);
            }
        }
        return target;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] blur = new int[3][3];
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                blur[i][0] = 0;
                blur[i][1] = -1;
                blur[i][2] = 0;
            }
        }
        blur[1][0] = -1;
        blur[1][1] = 5;
        blur[1][2] = -1;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int Rsum = 0;
                int Gsum = 0;
                int Bsum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        int targeti = i - (1 - k);
                        int targetj = j - (1 - h);

                        if (targeti < 0) {
                            targeti += width;
                        }
                        else if (targeti >= width) {
                            targeti -= width;
                        }
                        if (targetj < 0) {
                            targetj += height;
                        }
                        else if (targetj >= height) {
                            targetj -= height;
                        }
                        Rsum += blur[k][h] * picture.get(targeti, targetj).getRed();
                        Gsum += blur[k][h] * picture.get(targeti, targetj).getGreen();
                        Bsum += blur[k][h] * picture.get(targeti, targetj).getBlue();
                    }

                }
                Rsum = clamp(Rsum);
                Gsum = clamp(Gsum);
                Bsum = clamp(Bsum);
                Color color = new Color(Rsum, Gsum, Bsum);
                target.set(i, j, color);
            }
        }
        return target;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] blur = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blur[i][j] = -1;
            }
        }
        blur[1][1] = 8;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int Rsum = 0;
                int Gsum = 0;
                int Bsum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        int targeti = i - (1 - k);
                        int targetj = j - (1 - h);

                        if (targeti < 0) {
                            targeti += width;
                        }
                        else if (targeti >= width) {
                            targeti -= width;
                        }
                        if (targetj < 0) {
                            targetj += height;
                        }
                        else if (targetj >= height) {
                            targetj -= height;
                        }
                        Rsum += blur[k][h] * picture.get(targeti, targetj).getRed();
                        Gsum += blur[k][h] * picture.get(targeti, targetj).getGreen();
                        Bsum += blur[k][h] * picture.get(targeti, targetj).getBlue();
                    }

                }
                Rsum = clamp(Rsum);
                Gsum = clamp(Gsum);
                Bsum = clamp(Bsum);
                Color color = new Color(Rsum, Gsum, Bsum);
                target.set(i, j, color);
            }
        }
        return target;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] blur = new int[3][3];
        blur[0][0] = -2;
        blur[0][1] = -1;
        blur[0][2] = 0;
        blur[1][0] = -1;
        blur[1][1] = 1;
        blur[1][2] = 1;
        blur[2][0] = 0;
        blur[2][1] = 1;
        blur[2][2] = 2;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int Rsum = 0;
                int Gsum = 0;
                int Bsum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int h = 0; h < 3; h++) {
                        int targeti = i - (1 - k);
                        int targetj = j - (1 - h);

                        if (targeti < 0) {
                            targeti += width;
                        }
                        else if (targeti >= width) {
                            targeti -= width;
                        }
                        if (targetj < 0) {
                            targetj += height;
                        }
                        else if (targetj >= height) {
                            targetj -= height;
                        }
                        Rsum += blur[k][h] * picture.get(targeti, targetj).getRed();
                        Gsum += blur[k][h] * picture.get(targeti, targetj).getGreen();
                        Bsum += blur[k][h] * picture.get(targeti, targetj).getBlue();
                    }

                }
                Rsum = clamp(Rsum);
                Gsum = clamp(Gsum);
                Bsum = clamp(Bsum);
                Color color = new Color(Rsum, Gsum, Bsum);
                target.set(i, j, color);
            }
        }
        return target;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] blur = new int[9][9];
        for (int i = 0; i < 9; i++) {
            blur[i][i] = 1;

        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                double Rsum = 0;
                double Gsum = 0;
                double Bsum = 0;

                for (int k = 0; k < 9; k++) {
                    for (int h = 0; h < 9; h++) {
                        int targeti = i - (1 - k);
                        int targetj = j - (1 - h);

                        while (targeti < 0) {
                            targeti += width;
                        }
                        while (targeti >= width) {
                            targeti -= width;
                        }
                        while (targetj < 0) {
                            targetj += height;
                        }
                        while (targetj >= height) {
                            targetj -= height;
                        }
                        Rsum += blur[k][h] * picture.get(targeti, targetj).getRed() / 9.0;
                        Gsum += blur[k][h] * picture.get(targeti, targetj).getGreen() / 9.0;
                        Bsum += blur[k][h] * picture.get(targeti, targetj).getBlue() / 9.0;
                    }

                }
                int Rsumi = clamp((int) Math.round(Rsum));
                int Gsumi = clamp((int) Math.round(Gsum));
                int Bsumi = clamp((int) Math.round(Bsum));
                Color color = new Color(Rsumi, Gsumi, Bsumi);
                target.set(i, j, color);
            }
        }
        return target;
    }

    private static int clamp(int a) {
        if (a > 255) {
            return 255;
        }
        else if (a < 0) {
            return 0;
        }
        return a;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture pic1 = gaussian(pic);
        //Picture pic2 = sharpen(pic);
        //Picture pic3 = laplacian(pic);
        //Picture pic4 = emboss(pic);
        Picture pic5 = motionBlur(pic);
        pic.show();
        pic1.show();
        //pic2.show();
        //pic3.show();
        //pic4.show();
        pic5.show();

    }
}
