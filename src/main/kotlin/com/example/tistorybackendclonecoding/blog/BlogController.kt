package com.example.tistorybackendclonecoding.blog

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BlogController(
    private val blogService: BlogService,
) {

    @PostMapping("/blog")

    fun create(@RequestBody @Valid blogRequestDto: BlogRequestDto) {
        blogService.create(blogRequestDto)
    }

    @GetMapping("/blog/id/{id}")
    fun findById(@PathVariable id: Long): BlogResponseDto {
        return blogService.findById(id)
    }

    @GetMapping("/blog/userId/{userId}")
    fun findAllByUserId(@PathVariable userId: Long): List<BlogResponseDto> {
        return blogService.findAllByUserId(userId)
    }

    @PutMapping("/blog/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid blogRequestDto: BlogRequestDto) {
        blogService.update(id, blogRequestDto)
    }

    @DeleteMapping("/blog/{id}")
    fun delete(@PathVariable id: Long) {
        blogService.delete(id)
    }
}