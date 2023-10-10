package study.dev.ssrmbrlsy.vo.hr;

import lombok.Data;

@Data
//직워정보
public class EmployeesVo {

    private int employeeId;
    private String name;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private int salary;
    private int commissionPct;
    private int managerId;
    private String jobTitle;
}

