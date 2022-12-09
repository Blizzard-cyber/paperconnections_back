package com.paper.connection.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    int paperId;
    String title;
    String date;
    String journal;
    String commit;
    String doi;
    String license;
    String abs;
    String author;
    String categories;
}
