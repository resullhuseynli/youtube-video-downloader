import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Downloader {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the YouTube video URL: ");
        String videoURL = sc.nextLine();
        String savePath = "C:/Downloads";
        downloadYouTubeVideo(videoURL, savePath);
    }

    public static void downloadYouTubeVideo(String videoURL, String savePath) {

        try {
            ProcessBuilder builder = new ProcessBuilder("yt-dlp", "-o", savePath + "/%(title)s.%(ext)s", videoURL);
            builder.redirectErrorStream(true);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            System.out.println("Download complete!");
        } catch (IOException | InterruptedException e) {
            System.out.println("There was an error while downloading the video.");
        }
    }
}