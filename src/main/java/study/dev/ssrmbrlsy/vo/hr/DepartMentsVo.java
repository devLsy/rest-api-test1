package study.dev.ssrmbrlsy.vo.hr;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//부서
public class DepartMentsVo {

    private int departmentId;
    private String departmentName;

    private List<EmployeesVo> employeesList = new ArrayList<>();
}
