package study.dev.ssrmbrlsy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import study.dev.ssrmbrlsy.vo.hr.RegionsVo;

import java.util.List;

@Mapper @Repository
public interface CommonInfoMapper {

    /* 1단계 전역 검색 */
    List<RegionsVo> selectRegionsList();

    /* 2단계 나라 검색 */
    List<RegionsVo> selectContriesList();

    /* 3단계 지역 검색 */
    List<RegionsVo> selectLocationsList();

    /* 4단계 부서 검색 */
    List<RegionsVo> selectDeptList();

    /* 5단계 직원 검색 */
    List<RegionsVo> selectEmployeeList();
}
