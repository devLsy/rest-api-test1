package study.dev.ssrmbrlsy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.dev.ssrmbrlsy.mapper.CommonInfoMapper;
import study.dev.ssrmbrlsy.vo.hr.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CommonInfoService {

    private final CommonInfoMapper commonInfoMapper;
    /**
     * 오라클 hr계정 리스트 조회(나라 > 지역 > 구역 > 부서 > 직원/직업)
     * @return
     */
    public List<RegionsVo> selectRegionsList() {
        //최종 결과 리스트
        List<RegionsVo> regionsList = new ArrayList<>();

        //1단계 전역 검색
        List<RegionsVo> regionsDataList = commonInfoMapper.selectRegionsList();
        //2단계 나라 검색
        List<RegionsVo> contriesDataList = commonInfoMapper.selectContriesList();
        //3단계 지역 검색
        List<RegionsVo> locationsDataList = commonInfoMapper.selectLocationsList();
        //4단계 부서 검색
        List<RegionsVo> deptDataList = commonInfoMapper.selectDeptList();
        //5단계 직원 검색
        List<RegionsVo> employeeDataList = commonInfoMapper.selectEmployeeList();

        RegionsVo regionsInfo = new RegionsVo();
        //1단계 지역 시작
        for (RegionsVo regionsData : regionsDataList) {
            regionsInfo = new RegionsVo();
            regionsInfo.setRegionId(regionsData.getRegionId());
            regionsInfo.setRegionName(regionsData.getRegionName());

            List<ContriesVo> contriesInfoList = new ArrayList<>();
            ContriesVo contriesInfo = new ContriesVo();
            //2단계 나라 시작
            for(RegionsVo contriesData : contriesDataList) {
                if (regionsInfo.getRegionId() == contriesData.getRegionId()) {
                    contriesInfo = new ContriesVo();
                    contriesInfo.setCountryId(contriesData.getCountryId());
                    contriesInfo.setCountryName(contriesData.getCountryName());

                    List<LocationsVo> locationsInfoList = new ArrayList<>();
                    LocationsVo locationInfo = new LocationsVo();
                    //3단계 location 시작
                    for(RegionsVo locationsData : locationsDataList) {
                        if (regionsInfo.getRegionId() == locationsData.getRegionId() && contriesInfo.getCountryId().equals(locationsData.getCountryId())) {
                            locationInfo = new LocationsVo();
                            locationInfo.setLocationId(locationsData.getLocationId());
                            locationInfo.setCity(locationsData.getCity());
                            locationInfo.setStreetAddress(locationsData.getStreetAddress());
                            locationInfo.setPostalCode(locationsData.getPostalCode());
                            locationInfo.setStateProvince(locationsData.getStateProvince());

                            //4단계 부서 시작
                            List<DepartMentsVo> deptInfoList = new ArrayList<>();
                            DepartMentsVo departMentsInfo = new DepartMentsVo();
                            for(RegionsVo deptData: deptDataList) {
                                if (regionsInfo.getRegionId() == deptData.getRegionId() &&
                                    contriesInfo.getCountryId().equals(deptData.getCountryId()) &&
                                    locationInfo.getLocationId() == deptData.getLocationId()) {

                                    departMentsInfo = new DepartMentsVo();
                                    departMentsInfo.setDepartmentId(deptData.getDepartmentId());
                                    departMentsInfo.setDepartmentName(deptData.getDepartmentName());

                                    //5단계 직원 시작
                                    List<EmployeesVo> employeeInfoList = new ArrayList<>();
                                    EmployeesVo employeeInfo = new EmployeesVo();
                                    for(RegionsVo employeeData : employeeDataList) {
                                        if (regionsInfo.getRegionId() == employeeData.getRegionId() &&
                                            contriesInfo.getCountryId().equals(employeeData.getCountryId()) &&
                                            locationInfo.getLocationId() == employeeData.getLocationId() &&
                                            departMentsInfo.getDepartmentId() == employeeData.getDepartmentId()) {

                                            employeeInfo = new EmployeesVo();
                                            employeeInfo.setEmployeeId(employeeData.getEmployeeId());
                                            employeeInfo.setName(employeeData.getName());
                                            employeeInfo.setJobTitle(employeeData.getJobTitle());
                                            employeeInfo.setEmail(employeeData.getEmail());
                                            employeeInfo.setPhoneNumber(employeeData.getPhoneNumber());
                                            employeeInfo.setHireDate(employeeData.getHireDate());
                                            employeeInfo.setSalary(employeeData.getSalary());
                                            employeeInfoList.add(employeeInfo);
                                        }
                                    }
                                    departMentsInfo.setEmployeesList(employeeInfoList);
                                    if (departMentsInfo.getDepartmentId() != 0) {
                                     deptInfoList.add(departMentsInfo);
                                    }
                                }
                            }//4단계 부서 종료
                            locationInfo.setDepartMentsList(deptInfoList);
                            if (locationInfo.getLocationId() != 0) {
                                locationsInfoList.add(locationInfo);
                            }
                        }
                    }//3단계 location 종료
                    contriesInfo.setLocationsList(locationsInfoList);
                    contriesInfoList.add(contriesInfo);
                }
            }//2단계 나라 종료
            regionsInfo.setContriesList(contriesInfoList);
            regionsList.add(regionsInfo);
        }//1단계 지역 종료
        //최종결과 return
        return regionsList;
    }
}
