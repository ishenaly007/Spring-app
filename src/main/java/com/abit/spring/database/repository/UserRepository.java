package com.abit.spring.database.repository;

import com.abit.spring.dto.IPersonalInfo;
import com.abit.spring.entity.Role;
import com.abit.spring.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findAllBy(Pageable pageable);

    List<User> findFirstBy(Sort sort);

    @Query(value = "select u.firstname, u.lastname, u.birth_date " +
                   "from users u " +
                   "where u.company_id = :companyId",
            nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    @Query(
            "select u from User u " +
            "where u.firstname like %:firstname% and " +
            "u.lastname like %:lastname%")
    List<User> findAllByFirstnameContainingIgnoreCaseAndLastnameContainingIgnoreCase(String firstname, String lastname);

    @Query(
            value = "SELECT u.* FROM users u " +
                    "WHERE u.username = :username",
            nativeQuery = true)
    User findByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
           "where u.id in (:ids)")
    int updateRole(Role role, Integer... ids);
}