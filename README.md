# YouTube Video Downloader

This project is a simple Java application that downloads YouTube videos using the `yt-dlp` tool.

## Prerequisites

- Java Development Kit (JDK) installed
- `yt-dlp` installed and available in your system's PATH

## How to Use

1. Clone the repository or download the source code.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. Run the `Downloader` class.
4. Enter the YouTube video URL when prompted.
5. The video will be downloaded to the `C:/Downloads` directory.

## Code Overview

The main functionality is implemented in the `Downloader` class. The `downloadYouTubeVideo` method uses `ProcessBuilder` to execute the `yt-dlp` command and download the video.

```java
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

## License
This project is licensed under the MIT License.