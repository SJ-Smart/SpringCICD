package com.smhrd.SpringWeb.repository;

import com.smhrd.SpringWeb.dto.Cloud_Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Cloud_Member,Long> {

}
