package com.gg.onboarding.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public Board findBoardById(Long id);
}
