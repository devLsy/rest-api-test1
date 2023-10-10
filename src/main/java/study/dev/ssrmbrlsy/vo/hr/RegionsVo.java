package study.dev.ssrmbrlsy.vo.hr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//전체 지역
public class RegionsVo {

    @JsonIgnore
    private int employeeId;
    private String regionName;
    @JsonIgnore
    private String countryName;
    @JsonIgnore
    private String city;
    @JsonIgnore
    private String streetAddress;
    @JsonIgnore
    private String postalCode;
    @JsonIgnore
    private String stateProvince;
    @JsonIgnore
    private int departmentId;
    @JsonIgnore
    private String departmentName;
    @JsonIgnore
    private String name;    //성+이름
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String phoneNumber;
    @JsonIgnore
    private String hireDate;
    @JsonIgnore
    private int salary;
    @JsonIgnore
    private String commissionPct;
    @JsonIgnore
    private String jobTitle;

    private int regionId;
    @JsonIgnore
    private String countryId;
    @JsonIgnore
    private int locationId;

    List<ContriesVo> contriesList = new ArrayList<>();
}
