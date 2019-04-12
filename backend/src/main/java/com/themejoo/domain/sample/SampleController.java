package com.themejoo.domain.sample;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by betterfly
 * Date : 2019.03.25
 */

@RestController
@AllArgsConstructor
public class SampleController {

    private SampleRepository sampleRepository;
    @PostMapping("/sample/save")
    public void saveSample(@RequestBody SampleSaveRequestDto dto){
        sampleRepository.save(dto.toEntity());
    }
}
