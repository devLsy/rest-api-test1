package study.dev.ssrmbrlsy.vo.hr;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//나라
public class ContriesVo {

    private String countryId;
    private String countryName;

    private List<LocationsVo> locationsList = new ArrayList<>();
}
