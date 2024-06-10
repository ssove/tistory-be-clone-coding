package com.example.tistorybackendclonecoding.blog

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogRepository: JpaRepository<Blog, Long> {
    fun findByUserId(userId: Long): Blog?
    fun findAllByUserId(userId: Long): List<Blog>
    fun existsByUserId(id: Long): Boolean
}