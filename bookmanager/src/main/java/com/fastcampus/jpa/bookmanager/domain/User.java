package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table
@EntityListeners(value = {UserEntityListener.class})
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING) // 중요! EnumType의 default가 ORDINAL로 돼있기때문에 인덱스로 자동 맵핑됨! 따라서 STRINTG으로 바꿔줘야 잠재적 버그가 없다!
    private Gender gender;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

////    @Column(insertable = false) // 엔티티 insert 시 필드 저장 유무
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
//
//    // db데이터에 반영되지 않는다
//    @Transient
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void PreUpdate(){
//        this.updatedAt = LocalDateTime.now();
//    }

}
