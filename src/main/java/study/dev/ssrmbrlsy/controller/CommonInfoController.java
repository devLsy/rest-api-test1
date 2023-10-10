package study.dev.ssrmbrlsy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.dev.ssrmbrlsy.service.CommonInfoService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "common/*")
public class CommonInfoController {

    private final CommonInfoService commonInfoService;

    /**
     * 오라클 hr계정 지역>나라>location>부서>직원 검색
     *
     * @return
     */
    @GetMapping(value = "hrList")
    public Object hrList() {
        ModelMap model = new ModelMap().addAttribute("regionsList", commonInfoService.selectRegionsList());
        return model;
    }
}
