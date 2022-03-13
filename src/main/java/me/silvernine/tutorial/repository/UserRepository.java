package me.silvernine.tutorial.repository;

import me.silvernine.tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   @EntityGraph(attributePaths = "authorities")
   Optional<User> findOneWithAuthoritiesByUsername(String username);

   // findOneWithAuthoritiesByUsername username을 기준으로 User정보를 가져올 때 권한 정보도 같이 가져오게 됨됨
   // @EntityGraph은 쿼리가 수행이 될 때 Lazy조회가 아니고 Eager조회로 authorities 정보를 같이 가져오게 됨
}
