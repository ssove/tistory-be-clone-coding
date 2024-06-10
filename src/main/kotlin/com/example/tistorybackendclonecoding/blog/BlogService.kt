package com.example.tistorybackendclonecoding.blog

interface BlogService {
    fun create(blogDto: BlogRequestDto)
    fun findById(id: Long): BlogResponseDto
    fun findByUserId(userId: Long): BlogResponseDto
    fun findAllByUserId(userId: Long): List<BlogResponseDto>
    fun update(id: Long, blogDto: BlogRequestDto)
    fun delete(id: Long)
}