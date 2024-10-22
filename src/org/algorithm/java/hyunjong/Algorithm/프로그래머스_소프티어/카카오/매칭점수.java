package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 매칭점수 {
	static HashMap<String,Integer> urlMap;
	static URL[] urls;
	public static void main(String[] args) {
		String word = "blind";
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		System.out.println(solution(word, pages));
	}

	static int solution(String word, String[] pages){
		urlMap = new HashMap<>();
		urls = new URL[pages.length];

		word = word.toLowerCase();
		for(int i=0;i<pages.length;i++){
			pages[i] = pages[i].toLowerCase();
		}

		for(int i=0;i<pages.length;i++){
			Pattern urlPattern = Pattern.compile("<meta property=\"og:url\" content=\\S+/>");
			Pattern refUrlPattern = Pattern.compile("<a href=\\S+>");
			Pattern bodyPattern = Pattern.compile("\\b"+word+"\\b");
			Matcher urlMatcher = urlPattern.matcher(pages[i]);
			Matcher refUrlMatcher = refUrlPattern.matcher(pages[i]);
			Matcher bodyMatcher = bodyPattern.matcher(pages[i].split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " "));

			int score = 0;
			List<String> refUrlList = new ArrayList<>();
			if(urlMatcher.find()){
				String url = urlMatcher.group().split("=")[2].split("/>")[0];
				urlMap.put(url, i);
			}

			while(refUrlMatcher.find()){
				String url = refUrlMatcher.group().split(">")[0].split("=")[1];;
				refUrlList.add(url);
			}

			while(bodyMatcher.find()){
				score++;
				// System.out.println(bodyMatcher.group());
			}
			// System.out.println("index : "+i+" score : "+score);

			urls[i] = new URL(i, score, refUrlList);
		}

		for(URL u : urls){
			double s = u.score;
			int refCount = u.refList.size();
			for(String ref : u.refList){
				if(urlMap.containsKey(ref)){
					urls[urlMap.get(ref)].linkScore += s/refCount;
				}
			}
		}

		for(URL u : urls){
			u.setLinkScore();
		}

		Arrays.sort(urls);

		int answer = urls[0].index;
		return answer;
	}

	static class URL implements Comparable<URL> {
		int index;
		double score;
		double linkScore;
		List<String> refList;
		public URL(int index, int score, List<String> refList){
			this.index = index;
			this.score = score;
			this.refList = refList;
			this.linkScore=0;
		}

		@Override
		public int compareTo(URL o){
			if(o.linkScore > this.linkScore) return 1;
			else if(o.linkScore == this.linkScore) return 0;
			else return -1;
		}

		public void setLinkScore(){
			this.linkScore+=this.score;
		}
	}
}
