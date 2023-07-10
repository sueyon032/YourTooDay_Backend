package org.fire.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sympathy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sympathy_no", updatable = false)
    private Long sympathyNo;    // 기본키

    // tree(0) sad(1) angry(2) nice(3) happy(4) love(5)
    @Column(name = "sympathy_kind", nullable = false)
    private Integer sympathyKind;

    @Column(name = "user_no", updatable = false)
    private Long userNo;    // User클래스에서 diaryNo를 받아야함

    @Column(name = "diary_no", updatable = false)
    private Long diaryNo;   // Diary클래스에서 diaryNo를 받아야함

    @Builder
    public Sympathy(Integer sympathyKind, Long userNo, Long diaryNo) {
        this.sympathyKind = sympathyKind;
        this.userNo = userNo;
        this.diaryNo = diaryNo;
    }
}
