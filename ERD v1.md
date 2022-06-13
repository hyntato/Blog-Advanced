# ERD 설계

### 상세 기획서 기반으로 ERD 설계
[게시판 상세 기획서 · Well-Founded-Confidence/Blog-Advanced Wiki](https://github.com/Well-Founded-Confidence/Blog-Advanced/wiki/%EA%B2%8C%EC%8B%9C%ED%8C%90-%EC%83%81%EC%84%B8-%EA%B8%B0%ED%9A%8D%EC%84%9C)

### Version 1.0
![ERD ver5](https://user-images.githubusercontent.com/56067179/173331921-2053f820-2458-45cc-8b0e-0b567312bd69.jpeg)

### user (사용자)

- id
- name
- password
- email

### post (게시글)

- id
- user_id
- comment_id
- title
- contents
- comment_enabled
- created_at
- updated_at

### comment (댓글)

- id
- user_id
- parent_comment_id
- depth
- contents
- created_at
- updated_at

### like_post (게시글 좋아요)

- id
- user_id
- post_id

### like_comment (댓글 좋아요)

- id
- user_id
- comment_id

### hit (조회 수)

- id
- post_id
- count

