package com.example.tistorybackendclonecoding.blog

data class BlogResponseDto(
    val userId: Long,
    val title: String,
    val url: String,
) {

    companion object {
        fun fromEntity(blog: Blog) = BlogResponseDto(
            userId = blog.userId,
            title = blog.title,
            url = blog.url,
        )
    }
}