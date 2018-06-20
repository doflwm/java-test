package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	List<UserEntity> findByLastName(String lastName);
}
