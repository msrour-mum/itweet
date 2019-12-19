package mum.itweet.repository;

import java.util.List;
import java.util.Optional;

import mum.itweet.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mum.itweet.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findAllByEmail(String email);

	public Optional<User> findByEmail(String email);

	@Query(value = "Select u.* from following f inner join user u on u.id=f.follower_id where f.following_id=:userId", nativeQuery = true)
	public List<User> ListFollower(@Param("userId") int userId);

	@Query(value = "Select u.* from following f inner join user u on u.id=f.following_id where f.follower_id=:userId", nativeQuery = true)
	public List<User> ListFollowing(@Param("userId") int userId);

	@Query(value = "Select count(1) from following f inner join user u on u.id=f.follower_id where f.following_id=:userId", nativeQuery = true)
	public int getCountFollower(@Param("userId") int userId);

	@Query(value = "Select count(1)  from following f inner join user u on u.id=f.following_id where f.follower_id=:userId", nativeQuery = true)
	public int getCountFollowing(@Param("userId") int userId);


	@Query(value = "select distinct u.* from user u\n" +
			"where u.isActive=1 and u.isAdmin=0 \n" +
			"and u.id not in (select f.follower_id from following f  where f.following_id = :userId )", nativeQuery = true)
	public List<User> PeopleYouMayKnow(@Param("userId") int userId);


	public List<User> getAllByRole(Role role);

	@Query(value = "SELECT * FROM user where email like %?1% and name like %?2% and isActive=?3", nativeQuery = true)
	public List<User> quickSearch(String name, String email, String enable);

	//public List<User> getAllByNameContainsAndEmailContainsAndIsActiveEquals(String name, String email,  boolean enable);

	//public List<User> getAllByNameContainingAndEmailContainingAndIsActiveEqualsAllIgnoreCase(String name, String email,  boolean enable);
	//public List<User> getAllByNameContainingAndEmailContainingAllIgnoreCase(String name, String email);

	//public List<User> getAllByNameContainingAndEmailContainingAllIgnoreCase(String name, String email);
}
