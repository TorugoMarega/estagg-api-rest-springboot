package br.com.estagginc.estagg_api.repository;

import br.com.estagginc.estagg_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
