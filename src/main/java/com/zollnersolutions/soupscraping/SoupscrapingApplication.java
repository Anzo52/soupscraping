package com.zollnersolutions.soupscraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SpringBootApplication
public class SoupscrapingApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SoupscrapingApplication.class, args);
		try {
			Document doc = Jsoup.connect("https://www.codetriage.com/?language=java").get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				System.out.println("\nlink: " + link.attr("href"));
				System.out.println("text: " + link.text());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
