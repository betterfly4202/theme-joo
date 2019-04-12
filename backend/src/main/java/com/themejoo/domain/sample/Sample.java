package com.themejoo.domain.sample;

import com.themejoo.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by betterfly
 * Date : 2019.03.25
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "Sample")
public class Sample extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    private String author;

    @Builder
    public Sample(String title, String contents, String author){
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

}
