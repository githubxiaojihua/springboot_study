package com.xiaojihua.m07_springboot_jpa.reporsitory;

import com.xiaojihua.m07_springboot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
