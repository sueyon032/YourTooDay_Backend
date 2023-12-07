package org.fire.repository;

import org.fire.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

// 스프링 데이터 JPA에서 제공하는 JpaRepository 인터페이스를 상속하여
// Diary 엔티티와 관련된 데이터베이스 작업을 수행하는데 필요한 메서드를 자동으로 제공받게 해줌.

// 매개변수: <엔티티 클래스, 엔티티의 기본 키 타입>
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
