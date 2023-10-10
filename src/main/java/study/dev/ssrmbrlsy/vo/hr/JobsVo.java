package study.dev.ssrmbrlsy.vo.hr;

import lombok.Data;

@Data
public class JobsVo {

    private String jobId;
    private String jobTitle;
    private int minSalary;
    private int maxSalary;
}
