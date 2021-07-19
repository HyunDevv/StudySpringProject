package com.fastcampus.jpa.bookmanager.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) // 중요! EnumType의 default가 ORDINAL로 돼있기때문에 인덱스로 자동 맵핑됨! 따라서 STRINTG으로 바꿔줘야 잠재적 버그가 없다!
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;

//    @Column(insertable = false)
    private LocalDateTime updatedAt;

    // db데이터에 반영되지 않는다
    @Transient
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

}
