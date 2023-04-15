package com.example.regextest;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexService {
    private RegexRepository regexRepository;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("\"[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\"");
    private static final Pattern TEL_PATTERN = Pattern.compile("\\d{2,3}-\\d{3,4}-\\d{4}$");

    public RegexService(RegexRepository regexRepository) {
        this.regexRepository = regexRepository;
    }

    public void startTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> combinedText = getCombinedText();
        for (String s : combinedText) {
            extractEmail(s);
            extractTel(s);
        }
        stopWatch.stop();
        System.out.println("total Time = " + stopWatch.getTotalTimeMillis()); ;
    }

    /**
     * email 추출
     * @param s
     */
    private void extractEmail(String s) {
       String regex = "[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println("Full match Email : " + matcher.group(0));
        }
    }

    /**
     * tel 추출
     * @param s
     */
    private void extractTel(String s) {
        String regex = "\\d{2,3}-\\d{3,4}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println("Full match Tel : " + matcher.group(0));
        }
    }

    /**
     * table column 하나의 데이터로 합치는 메서드
     * @return
     */
    private List<String> getCombinedText() {
        List<SeoulBidData> seoulBidDataList = regexRepository.findAll();
        List<String> combinTxtList = new ArrayList<>();
        seoulBidDataList.forEach(data -> {
            StringBuilder sb = new StringBuilder();
            sb.append(data.getPostId() + " ");
            sb.append(data.getPostName() + " ");
            sb.append(data.getCreateDate() + " ");
            sb.append(data.getUpdateDate() + " ");
            sb.append(data.getOrgan() + " ");
            sb.append(data.getPosition() + " ");
            sb.append(data.getTel() + " ");
            sb.append(data.getEmail() + " ");
            sb.append(data.getTagWord() + " ");
            sb.append(data.getContents() + " ");
            sb.append(data.getStartDate() + " ");
            sb.append(data.getEndDate() + " ");
            sb.append(data.getDateCheck() + " ");
            sb.append(data.getFileName() + " ");
            sb.append(data.getFileCount() + " ");
            combinTxtList.add(sb.toString());
        });
        return combinTxtList;
    }
}