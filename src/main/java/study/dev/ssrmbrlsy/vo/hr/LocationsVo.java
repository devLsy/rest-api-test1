package study.dev.ssrmbrlsy.vo.hr;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//구역
public class LocationsVo {

    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

    private List<DepartMentsVo> departMentsList = new ArrayList<>();
}
