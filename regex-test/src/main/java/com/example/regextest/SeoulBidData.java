package com.example.regextest;

import javax.persistence.*;

@Entity
@Table(name = "seoul_bid_data")
public class SeoulBidData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name = "post_id")
    private String postId;
    @Column(name = "post_name")
    private String postName;
    @Column(name = "post_creator")
    private String postCreator;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "update_date")
    private String updateDate;
    private String organ;
    private String position;
    private String tel;
    private String email;
    @Column(name = "tag_word")
    private String tagWord;
    private String contents;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "date_check")
    private Integer dateCheck;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_count")
    private Integer fileCount;
    @Column(name = "file_size")
    private Long fileSize;

    public Long getSeq() {
        return seq;
    }

    public String getPostId() {
        return postId;
    }

    public String getPostName() {
        return postName;
    }

    public String getPostCreator() {
        return postCreator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getOrgan() {
        return organ;
    }

    public String getPosition() {
        return position;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getTagWord() {
        return tagWord;
    }

    public String getContents() {
        return contents;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getDateCheck() {
        return dateCheck;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public Long getFileSize() {
        return fileSize;
    }
}
