package com.example.tistorybackendclonecoding.blog

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class BlogRequestDto(

    @NotNull(message = "블로그를 소유한 유저 ID는 null이 될 수 없습니다.")
    val userId: Long,

    @NotBlank(message = "블로그 제목은 null이거나 비어있을 수 없습니다.")
    @Size(min = 2, max = 20, message = "블로그 제목은 2자 이상 20자 이하여야 합니다.")
    val title: String,

    @NotBlank(message = "블로그 url은 null이거나 비어있을 수 없습니다.")
    @Size(max = 150, message = "블로그 url은 150자 이하여야 합니다.")
    val url: String,
)