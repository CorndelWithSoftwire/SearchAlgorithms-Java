package org.softwire.training.searchalgorithms;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpResponse execute = httpClient.execute(new HttpGet("https://github.com/CorndelWithSoftwire/SearchAlgorithms-Java/raw/master/words"));
        String[] words = Arrays.stream(EntityUtils.toString(execute.getEntity(), StandardCharsets.UTF_8).split("\n"))
                .map(String::toLowerCase)
                .toArray(String[]::new);

        Files.write(Paths.get("words"), String.join("\n", words).getBytes(StandardCharsets.UTF_8));

        runTest(words, new LinearSearch());
        runTest(words, new BinarySearch());
        runTest(words, new JavaApiBinarySearch());
    }

    private static void runTest(String[] words, SearchAlgorithm searchAlgorithm) {
        int numberOfTests = 10000;
        Random random = new Random();
        long elapsedTimeInMillis = 0;

        for (int i = 0; i < numberOfTests; i++) {
            String randomTarget = words[random.nextInt(words.length)];

            long millis = System.currentTimeMillis();
            searchAlgorithm.find(words, randomTarget);
            elapsedTimeInMillis += System.currentTimeMillis() - millis;
        }

        System.out.println(searchAlgorithm.getName() + ", total time: " + elapsedTimeInMillis + "ms");
    }

}
