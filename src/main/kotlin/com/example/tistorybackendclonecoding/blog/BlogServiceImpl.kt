package com.example.tistorybackendclonecoding.blog

import com.example.tistorybackendclonecoding.common.logger
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BlogServiceImpl(
    private val blogRepository: BlogRepository,
): BlogService {

    private val log = logger()

    @Transactional
    override fun create(blogDto: BlogRequestDto) {
        blogRepository.save(toEntity(blogDto))
        log.info("블로그가 생성되었습니다. (userId: ${blogDto.userId}, title: ${blogDto.title})")
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): BlogResponseDto {
        require(blogRepository.existsById(id)) { "해당 ID의 블로그가 존재하지 않습니다. (id: $id)" }
        return BlogResponseDto.fromEntity(blogRepository.findById(id).get())
    }

    @Transactional(readOnly = true)
    override fun findByUserId(userId: Long): BlogResponseDto {
        require(blogRepository.existsByUserId(userId)) { "해당 유저가 소유한 블로그가 존재하지 않습니다. (userId: $userId)" }
        return BlogResponseDto.fromEntity(blogRepository.findByUserId(userId)!!)
    }

    @Transactional(readOnly = true)
    override fun findAllByUserId(userId: Long): List<BlogResponseDto> {
        require(blogRepository.existsByUserId(userId)) { "해당 유저가 소유한 블로그가 존재하지 않습니다. (userId: $userId)" }
        return blogRepository.findAllByUserId(userId).map { BlogResponseDto.fromEntity(it) }
    }

    @Transactional
    override fun update(id: Long, blogDto: BlogRequestDto) {
        require(blogRepository.existsById(id)) { "해당 ID의 블로그가 존재하지 않습니다. (id: $id)" }
        blogRepository.findById(id).get().apply {
            userId = blogDto.userId
            title = blogDto.title
            url = blogDto.url
        }
        log.info("블로그가 수정되었습니다. (id: $id, userId: ${blogDto.userId}, title: ${blogDto.title})")
    }

    @Transactional
    override fun delete(id: Long) {
        require(blogRepository.existsById(id)) { "해당 ID의 블로그가 존재하지 않습니다. (id: $id)" }
        blogRepository.deleteById(id)
        log.info("블로그가 삭제되었습니다. (id: $id)")
    }

    private fun toEntity(blogDto: BlogRequestDto) = Blog(
        userId = blogDto.userId,
        title = blogDto.title,
        url = blogDto.url,
    )
}