package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    // 반드시 존재하는 값 - not null .. t면 outer join 일어남! ..  mappedBy를 하면 연관키를 갖지 않는다
    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore; // 레퍼런스 타입은 null 체크를 해줘어야 한다 -> Float

    private int reviewCount;
}
