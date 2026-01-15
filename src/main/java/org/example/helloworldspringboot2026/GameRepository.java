package org.example.helloworldspringboot2026;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface GameRepository extends JpaRepository<Game, Integer> {

}
