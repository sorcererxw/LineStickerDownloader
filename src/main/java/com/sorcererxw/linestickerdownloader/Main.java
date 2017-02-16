package com.sorcererxw.linestickerdownloader;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Author: Sorcerer
 * Date: 2017/2/1
 * Description:
 */
public class Main {
    private static final String USER_AGENT =
            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";

    public static void main(String... args) throws IOException {
        setLocalProxy();

        System.out.print("Sticker ID:  ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String listUrl = "http://dl.stickershop.line.naver.jp/products/0/0/1/{}/android/productInfo.meta".replace("{}", String.valueOf(id));
        System.out.println(listUrl);
        InputStream input = new URL(listUrl).openStream();
        StringWriter stringWriter = new StringWriter();
        IOUtils.copy(input, stringWriter, Charset.defaultCharset());
        String listString = stringWriter.toString();
        StickerCollection stickerCollection = new Gson().fromJson(listString, StickerCollection.class);
        File dir = getSaveDir(stickerCollection.getPackageId() + " "
                + (stickerCollection.getTitle().getZh_CN()==null ? stickerCollection.getTitle().getEn() : stickerCollection.getTitle().getZh_CN()).replaceAll("[-+.^:,&'\"]", ""));

        System.out.println("type:\n1. default\n2. gif\n3. png");
        int type = scanner.nextInt();
        String suffix = stickerCollection.isHasAnimation() ? "gif" : "png";
        if (type == 2) {
            suffix = "gif";
        }
        if (type == 3) {
            suffix = "png";
        }

        String finalSuffix = suffix;
        stickerCollection.getStickers().forEach(stickersBean -> {
            File savePath = new File(dir, stickersBean.getId() + "." + finalSuffix);
            if (finalSuffix.equals("gif")) {
                String url = "http://lstk.ddns.net/animg/{}.gif".replace("{}", String.valueOf(stickersBean.getId()));
                System.out.println(url);

                try {
                    saveGif(url, savePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String url = "http://dl.stickershop.line.naver.jp/stickershop/v1/sticker/{}/android/sticker.png".replace("{}", "" + stickersBean.getId());
                System.out.println(url);

                try {
                    BufferedImage image = ImageIO.read(new URL(url));
                    int width = image.getWidth();
                    int height = image.getHeight();
                    double scale = 512.0 / Math.max(width, height);
                    BufferedImage resizedImage;
                    if (width >= height) {
                        resizedImage = resize(image, 512, (int) (height * scale));
                    } else {
                        resizedImage = resize(image, (int) (width * scale), 512);
                    }
                    ImageIO.write(resizedImage, finalSuffix, savePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static File getSaveDir(String name) {
        File dir = new File(System.getProperty("user.home") + "/Line Stickers");
        while (!dir.exists()) {
            if (dir.mkdir()) {
                break;
            }
        }
        File subDir = new File(dir, name);
        while (!subDir.exists()) {
            if (subDir.mkdir()) {
                break;
            }
        }
        return subDir;
    }

    private static void saveGif(String urls, File path) throws IOException {
        byte[] b = new byte[1];
        URL url = new URL(urls);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        DataInputStream di = new DataInputStream(urlConnection.getInputStream());

        FileOutputStream fo = new FileOutputStream(path);
        while (-1 != di.read(b, 0, 1))
            fo.write(b, 0, 1);
        di.close();
        fo.close();
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private static void setLocalProxy() {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "1080");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "1080");
    }
}
