package com.themejoo.domain.sample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by betterfly
 * Date : 2019.03.25
 */

@Getter
@Setter
@NoArgsConstructor
public class SampleSaveRequestDto {
    private String title;
    private String contents;
    private String author;

    public Sample toEntity(){
        return Sample.builder()
                .title(this.title)
                .contents(this.contents)
                .author(this.author)
                .build();
    }
}
